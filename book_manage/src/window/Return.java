package window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import book.Book;
import sqlLink.BookSQLAction;
import sqlLink.ForDate;
import user.Student;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class Return extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public Return(Student currentuser) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\java-LIAOMIAO\\book_manage\\icon_resourse\\5.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 431, 146);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(248, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 10, 381, 28);
		contentPane.add(lblNewLabel);
		lblNewLabel.setText("当前用户:   "+currentuser.getName()+"   正在执行还书操作");
		
		JLabel lblNewLabel2 = new JLabel("\u5E8F\u53F7\uFF1A");
		lblNewLabel2.setFont(new Font("微软雅黑", Font.BOLD, 18));
		lblNewLabel2.setBounds(10, 55, 64, 18);
		contentPane.add(lblNewLabel2);
		
		textField = new JTextField();
		textField.setBackground(new Color(245, 245, 245));
		textField.setBounds(87, 54, 118, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		BookSQLAction act = new BookSQLAction();
		JButton rtn = new JButton("\u6267\u884C");
		rtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (arg0.getSource() == rtn) {
					ResultSet set = act.select.selectBookBynum(Integer.parseInt(textField.getText()));
					try {
						set.next();
						Book book = new Book(set.getInt("num"), set.getString("name"), set.getString("author"), set.getString("press"), set.getString("type"));
						book.setExist(set.getInt("exist"));
						book.setRent(set.getString("rentmen"));
						//System.out.println(book.getRent());
						if (!book.getRent().equals(currentuser.getNum())) {
							JOptionPane.showMessageDialog(null, "该书并未被当前用户借阅", "错误", JOptionPane.WARNING_MESSAGE);
							return;
						}else {
							currentuser.returnbook(book);
							new ForDate().Update_return_Date(currentuser.getNum(), book.getNum(), new Date(System.currentTimeMillis()));
							JOptionPane.showMessageDialog(null, "还书成功", "提示", JOptionPane.PLAIN_MESSAGE);
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}			
				}
				setVisible(false);
			}
		});
		rtn.setFont(new Font("等线", Font.BOLD, 17));
		rtn.setBounds(245, 52, 113, 27);
		contentPane.add(rtn);
		setLocation(720, 350);
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
