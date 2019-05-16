package window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sqlLink.InformationAct;
import sqlLink.UserAct;
import user.Student;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class Student_Information extends JFrame {

	private JPanel contentPane;
	private JTextField namefield;
	private JTextField classfield;
	private JTextField charmberfield;
	private JTextField emailfield;
	private JTextField phonefield;
	private JTextField birthfield;
	private Student currentuser;

	/**
	 * Create the frame.
	 */
	public Student_Information(Student currentuser) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\java-LIAOMIAO\\book_manage\\icon_resourse\\3.png"));
		
		this.currentuser = currentuser;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 418, 413);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(248, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel namelab = new JLabel("\u59D3\u540D\uFF1A");
		namelab.setHorizontalAlignment(SwingConstants.CENTER);
		namelab.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 18));
		namelab.setBounds(14, 60, 101, 18);
		contentPane.add(namelab);
		
		JLabel classlab = new JLabel("\u6240\u5C5E\u73ED\u7EA7\uFF1A");
		classlab.setHorizontalAlignment(SwingConstants.CENTER);
		classlab.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 18));
		classlab.setBounds(14, 100, 101, 18);
		contentPane.add(classlab);
		
		JLabel chamberlab = new JLabel("\u5BDD\u5BA4\u53F7\uFF1A");
		chamberlab.setHorizontalAlignment(SwingConstants.CENTER);
		chamberlab.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 18));
		chamberlab.setBounds(14, 140, 101, 18);
		contentPane.add(chamberlab);
		
		JLabel emaillab = new JLabel("e-mail:");
		emaillab.setHorizontalAlignment(SwingConstants.CENTER);
		emaillab.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 18));
		emaillab.setBounds(14, 180, 101, 18);
		contentPane.add(emaillab);
		
		JLabel phonelab = new JLabel("phone:");
		phonelab.setHorizontalAlignment(SwingConstants.CENTER);
		phonelab.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 18));
		phonelab.setBounds(14, 220, 101, 18);
		contentPane.add(phonelab);
		
		JLabel birthlab = new JLabel("\u51FA\u751F\u65E5\u671F\uFF1A");
		birthlab.setHorizontalAlignment(SwingConstants.CENTER);
		birthlab.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 18));
		birthlab.setBounds(14, 260, 101, 18);
		contentPane.add(birthlab);
		
		JLabel messagelab = new JLabel("New label");
		messagelab.setFont(new Font("Î¢ÈíÑÅºÚ Light", Font.BOLD, 18));
		messagelab.setBounds(14, 8, 313, 23);
		contentPane.add(messagelab);
		
		messagelab.setText("µ±Ç°ÓÃ»§:   "+currentuser.getName());
		
		namefield = new JTextField();
		namefield.setHorizontalAlignment(SwingConstants.CENTER);
		namefield.setBackground(SystemColor.menu);
		namefield.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		namefield.setBounds(143, 57, 234, 24);
		contentPane.add(namefield);
		namefield.setColumns(10);
		
		classfield = new JTextField();
		classfield.setHorizontalAlignment(SwingConstants.CENTER);
		classfield.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		classfield.setColumns(10);
		classfield.setBackground(SystemColor.menu);
		classfield.setBounds(143, 99, 234, 24);
		contentPane.add(classfield);
		
		charmberfield = new JTextField();
		charmberfield.setHorizontalAlignment(SwingConstants.CENTER);
		charmberfield.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		charmberfield.setColumns(10);
		charmberfield.setBackground(SystemColor.menu);
		charmberfield.setBounds(143, 139, 234, 24);
		contentPane.add(charmberfield);
		
		emailfield = new JTextField();
		emailfield.setHorizontalAlignment(SwingConstants.CENTER);
		emailfield.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		emailfield.setColumns(10);
		emailfield.setBackground(SystemColor.menu);
		emailfield.setBounds(143, 179, 234, 24);
		contentPane.add(emailfield);
		
		phonefield = new JTextField();
		phonefield.setHorizontalAlignment(SwingConstants.CENTER);
		phonefield.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		phonefield.setColumns(10);
		phonefield.setBackground(SystemColor.menu);
		phonefield.setBounds(143, 219, 234, 24);
		contentPane.add(phonefield);
		
		birthfield = new JTextField();
		birthfield.setHorizontalAlignment(SwingConstants.CENTER);
		birthfield.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		birthfield.setColumns(10);
		birthfield.setBackground(SystemColor.menu);
		birthfield.setBounds(143, 259, 234, 24);
		contentPane.add(birthfield);
		
		JButton update = new JButton("\u66F4\u65B0");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == update) {
					if (new InformationAct().updateInformation(
							currentuser.getNum(),
							namefield.getText(), classfield.getText(), charmberfield.getText(),
							emailfield.getText(), phonefield.getText(), birthfield.getText())) {
						JOptionPane.showMessageDialog(null, "¸üÐÂ³É¹¦", "ÌáÊ¾", JOptionPane.PLAIN_MESSAGE);
						if(new UserAct().updateuser(currentuser.getNum(), namefield.getText(), currentuser.getPassword())) {
							PreStudent.currentuser.setName(namefield.getText());
							messagelab.setText("µ±Ç°ÓÃ»§:   "+currentuser.getName());
							//PreStudent.currentuser.setName(namefield.getText());
							PreStudent.informationlabel.setText("µ±Ç°²Ù×÷ÓÃ»§:   "+PreStudent.currentuser.getName());
						}	
					}
					else {
						JOptionPane.showMessageDialog(null, "¸üÐÂÊ§°Ü", "´íÎó", JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
		update.setBackground(new Color(220, 220, 220));
		update.setFont(new Font("Ó×Ô²", Font.BOLD, 18));
		update.setBounds(34, 310, 140, 30);
		contentPane.add(update);
		
		JButton reset = new JButton("\u91CD\u7F6E");
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (arg0.getSource() == reset) {
					setfield();
					messagelab.setText("µ±Ç°ÓÃ»§:   "+currentuser.getName());
				}
			}
		});
		reset.setBackground(new Color(220, 220, 220));
		reset.setFont(new Font("Ó×Ô²", Font.BOLD, 18));
		reset.setBounds(217, 310, 140, 30);
		contentPane.add(reset);
		
		setfield();
		setLocation(650, 230);
		setVisible(true);
		requestFocus();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public void setfield() {
		ResultSet set = new InformationAct().selectInformation(currentuser.getNum());
		try {
			set.next();
			namefield.setText(set.getString("name"));
			classfield.setText(set.getString("class"));
			charmberfield.setText(set.getString("chamber"));
			emailfield.setText(set.getString("e_mail"));
			phonefield.setText(set.getString("phone"));
			birthfield.setText(set.getString("birth"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
