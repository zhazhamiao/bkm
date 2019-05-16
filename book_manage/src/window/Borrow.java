package window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import book.Book;
import sqlLink.BookSQLSelectAction;
import sqlLink.ForDate;
import user.Student;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class Borrow extends JFrame {

	private JPanel contentPane;
	private Student currentuser;
	private JTextField numField;
	/**
	 * Create the frame.
	 */
	public Borrow(Student user) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\java-LIAOMIAO\\book_manage\\icon_resourse\\5.png"));
		setTitle("\u501F\u4E66\u64CD\u4F5C");
		currentuser = user;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 434, 159);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.text);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel message1 = new JLabel("New label");
		message1.setFont(new Font("����", Font.BOLD, 19));
		message1.setBounds(10, 13, 404, 22);
		message1.setText("��ǰ�û�:   "+currentuser.getName()+"   ����ִ�н������");
		contentPane.add(message1);
		
		JLabel label = new JLabel("\u5E8F\u53F7\uFF1A");
		label.setFont(new Font("����", Font.BOLD, 18));
		label.setBounds(14, 67, 62, 22);
		contentPane.add(label);
		
		numField = new JTextField();
		numField.setFont(new Font("΢���ź�", Font.BOLD, 16));
		numField.setBackground(new Color(245, 245, 245));
		numField.setHorizontalAlignment(SwingConstants.CENTER);
		numField.setBounds(90, 66, 123, 24);
		contentPane.add(numField);
		numField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u6267\u884C");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if  (arg0.getSource() == btnNewButton) {
					ResultSet set = new BookSQLSelectAction().selectBookBynum(Integer.parseInt(numField.getText()));
					try {
						set.next();
						Book book = new Book(set.getInt("num"), set.getString("name"), set.getString("author"), set.getString("press"), set.getString("type"));
						book.setExist(set.getInt("exist"));
						if (book.getExist() == 1) {
							JOptionPane.showMessageDialog(null, "�����ѱ�����", "����", JOptionPane.WARNING_MESSAGE);
							setVisible(false);
							return;
						}
						if(currentuser.rentbook(book)) {
							new ForDate().insertDate(currentuser.getNum(), book.getNum(), new Date(System.currentTimeMillis()));
							JOptionPane.showMessageDialog(null, "���ĳɹ�", "��ʾ", JOptionPane.PLAIN_MESSAGE);
							setVisible(false);
						}else {
							JOptionPane.showMessageDialog(null, "����ʧ��", "����", JOptionPane.WARNING_MESSAGE);
							setVisible(false);
						}
					} catch (SQLException e) {
						// TODO �Զ����ɵ� catch ��
						e.printStackTrace();
					}
					
				}
			}
		});
		btnNewButton.setFont(new Font("΢���ź�", Font.BOLD, 18));
		btnNewButton.setBounds(244, 65, 123, 27);
		contentPane.add(btnNewButton);
		setLocation(720, 350);
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
