package window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sqlLink.UserAct;
import user.Student;

import java.awt.Label;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class Logon extends JFrame {

	private JPanel contentPane;
	private JTextField numField;
	private JTextField nameField;
	private JPasswordField passwordField;
	private JPasswordField passwordField2;

	/**
	 * Create the frame.
	 */
	public Logon() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\java-LIAOMIAO\\book_manage\\icon_resourse\\resizeApi.php.png"));
		setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 20));
		setTitle("\u6CE8\u518C\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 424, 349);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(248, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label namelab = new Label("\u5B66\u53F7\uFF1A");
		namelab.setAlignment(Label.CENTER);
		namelab.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.BOLD, 20));
		namelab.setBackground(SystemColor.inactiveCaptionBorder);
		namelab.setBounds(25, 29, 82, 30);
		contentPane.add(namelab);
		
		Label passwordlab = new Label("\u59D3\u540D\uFF1A");
		passwordlab.setAlignment(Label.CENTER);
		passwordlab.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.BOLD, 20));
		passwordlab.setBounds(25, 79, 82, 30);
		contentPane.add(passwordlab);
		
		numField = new JTextField();
		numField.setToolTipText("");
		numField.setHorizontalAlignment(SwingConstants.LEFT);
		numField.setFont(new Font("”◊‘≤", Font.BOLD, 18));
		numField.setBounds(150, 29, 204, 30);
		contentPane.add(numField);
		
		nameField = new JTextField();
		nameField.setFont(new Font("”◊‘≤", Font.BOLD, 18));
		nameField.setBounds(150, 79, 204, 30);
		contentPane.add(nameField);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Book Antiqua", Font.PLAIN, 15));
		passwordField.setBounds(150, 129, 204, 30);
		contentPane.add(passwordField);
		
		Label label = new Label("\u5BC6\u7801\uFF1A");
		label.setAlignment(Label.CENTER);
		label.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.BOLD, 20));
		label.setBounds(25, 129, 82, 30);
		contentPane.add(label);
		
		passwordField2 = new JPasswordField();
		passwordField2.setFont(new Font("Book Antiqua", Font.PLAIN, 15));
		passwordField2.setBounds(150, 179, 204, 30);
		contentPane.add(passwordField2);
		
		Label label_1 = new Label("\u786E\u8BA4\u5BC6\u7801\uFF1A");
		label_1.setAlignment(Label.CENTER);
		label_1.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.BOLD, 20));
		label_1.setBounds(10, 179, 104, 30);
		contentPane.add(label_1);
		
		JButton check = new JButton("\u786E   \u8BA4");
		check.setBackground(new Color(220, 220, 220));
		check.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == check) {
					String passwordcheck = passwordField.getText();
					String passwordcheck2 = passwordField2.getText();
					String numcheck = numField.getText();
					String namecheck = nameField.getText();
					if (passwordcheck.equals("")||passwordcheck2.equals("")||numcheck.equals("")||namecheck.equals("")) {
						JOptionPane.showMessageDialog(null, "”––≈œ¢Œ¥ÃÓ–¥", "¥ÌŒÛ", JOptionPane.WARNING_MESSAGE);
						return;
					}
					else if (!passwordcheck.equals(passwordcheck2)) {
						//System.out.println(passwordcheck+passwordcheck2);
						JOptionPane.showMessageDialog(null, "¡Ω¥Œ ‰»Îµƒ√‹¬Î≤ª“ª÷¬", "¥ÌŒÛ", JOptionPane.WARNING_MESSAGE);
						return;
					}
					Student student = new Student(numcheck, passwordcheck);
					student.setName(namecheck);
					UserAct insert = new UserAct();
					if(insert.AddUser(student)) {
						JOptionPane.showMessageDialog(null, "◊¢≤·≥…π¶", "Ã· æ", JOptionPane.PLAIN_MESSAGE);
						passwordField.setText("");
					    passwordField2.setText("");
					    numField.setText("");
					    nameField.setText("");
					}else {
						JOptionPane.showMessageDialog(null, "ø…ƒ‹ «“—¥Ê‘⁄µƒ”√ªß", "¥ÌŒÛ", JOptionPane.WARNING_MESSAGE);
						return;
					}
				}
			}
		});
		check.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 20));
		check.setBounds(30, 240, 130, 35);
		contentPane.add(check);
		
		JButton reset = new JButton("\u91CD   \u7F6E");
		reset.setBackground(new Color(220, 220, 220));
		reset.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 20));
		reset.setBounds(240, 240, 130, 35);
		contentPane.add(reset);
		setLocation(720, 350);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
