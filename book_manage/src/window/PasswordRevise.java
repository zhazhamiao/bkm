package window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sqlLink.UserAct;
import user.Student;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class PasswordRevise extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JPasswordField passwordField2;
	private JButton btnNewButton;

	/**
	 * Create the frame.
	 */
	public PasswordRevise(Student currentuser) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\java-LIAOMIAO\\book_manage\\icon_resourse\\3.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 425, 245);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 245, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lab1 = new JLabel("\u8BF7\u8F93\u5165\u4F60\u7684\u65B0\u5BC6\u7801:");
		lab1.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.BOLD, 18));
		lab1.setBounds(15, 13, 167, 18);
		contentPane.add(lab1);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Book Antiqua", Font.PLAIN, 15));
		passwordField.setBounds(15, 40, 370, 24);
		contentPane.add(passwordField);
		
		JLabel label = new JLabel("\u518D\u6B21\u8F93\u5165:");
		label.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.BOLD, 18));
		label.setBounds(15, 78, 167, 18);
		contentPane.add(label);
		
		passwordField2 = new JPasswordField();
		passwordField2.setFont(new Font("Book Antiqua", Font.PLAIN, 15));
		passwordField2.setBounds(15, 105, 370, 24);
		contentPane.add(passwordField2);
		
		btnNewButton = new JButton("\u786E\u8BA4");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnNewButton) {
					String password = passwordField.getText();
					String password2 = passwordField2.getText();
					if (password.equals(password2)) {
						UserAct act = new UserAct();
						if (act.updateuser(currentuser.getNum(), currentuser.getName(), password)) {
							JOptionPane.showMessageDialog(null, "–ﬁ∏ƒ√‹¬Î≥…π¶", "Ã· æ", JOptionPane.PLAIN_MESSAGE);
							setVisible(false);
						}else {
							JOptionPane.showMessageDialog(null, "–ﬁ∏ƒ√‹¬Î ß∞‹", "¥ÌŒÛ", JOptionPane.ERROR_MESSAGE);
						}
					}else {
						JOptionPane.showMessageDialog(null, "¡Ω¥Œ ‰»Îµƒ√‹¬Î≤ª“ª÷¬", "æØ∏Ê", JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
		btnNewButton.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 18));
		btnNewButton.setBounds(98, 150, 195, 27);
		contentPane.add(btnNewButton);
		
		setLocation(750, 300);
		setVisible(true);
		requestFocus();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
