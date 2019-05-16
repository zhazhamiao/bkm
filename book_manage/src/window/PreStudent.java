package window;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import user.Student;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class PreStudent extends JFrame {

	private JPanel contentPane;
	public static Student currentuser;
	public static JLabel informationlabel;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PreStudent frame = new PreStudent();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	/**
	 * Create the frame.
	 */
	public PreStudent(Student currentuser) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\java-LIAOMIAO\\book_manage\\icon_resourse\\3.png"));
		PreStudent.currentuser = currentuser;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 499, 336);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 245, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		informationlabel = new JLabel("\u5F53\u524D\u64CD\u4F5C\u7528\u6237\uFF1A");
		informationlabel.setBounds(14, 13, 453, 34);
		informationlabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 21));
		contentPane.add(informationlabel);
		
		JButton informationupdate = new JButton("\u66F4\u65B0\u4E2A\u4EBA\u4FE1\u606F");
		informationupdate.setBackground(new Color(240, 248, 255));
		informationupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == informationupdate) {
					EventQueue.invokeLater(new Runnable() {						
						public void run() {
							try {
								new Thread(new Runnable() {				
									@Override
									public void run() {
										new Student_Information(currentuser);
									}
								}).start();
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
			}
		});
		informationupdate.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 23));
		informationupdate.setBounds(14, 140, 453, 50);
		contentPane.add(informationupdate);
		
		JButton signin = new JButton("\u56FE\u4E66\u64CD\u4F5C\u754C\u9762");
		signin.setBackground(new Color(240, 248, 255));
		signin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == signin) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								new Thread(new Runnable() {				
									@Override
									public void run() {
										new StudentMain(currentuser);
									}
								}).start();
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
			}
		});
		signin.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 23));
		signin.setBounds(15, 70, 452, 50);
		contentPane.add(signin);
		
		JButton passwordrevise = new JButton("\u4FEE\u6539\u5BC6\u7801");
		passwordrevise.setBackground(new Color(240, 248, 255));
		passwordrevise.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == passwordrevise) {
					EventQueue.invokeLater(new Runnable() {
						@Override
						public void run() {
							try {
								new Thread(new Runnable() {				
									@Override
									public void run() {
										new PasswordRevise(currentuser);
									}
								}).start();
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
			}
		});
		passwordrevise.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 23));
		passwordrevise.setBounds(14, 210, 453, 50);
		contentPane.add(passwordrevise);
		informationlabel.setText("µ±Ç°²Ù×÷ÓÃ»§:   "+currentuser.getName());
		setLocation(580, 200);
		setVisible(true);
	}
}
