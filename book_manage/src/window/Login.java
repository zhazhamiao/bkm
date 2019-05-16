package window;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import user.Adminstractor;
import user.Student;

public class Login {
	
	public Login() {
		JFrame frame = new JFrame("��¼����");
		Font font = new Font("΢���ź�", 1, 20);
		Font minifont = new Font("΢���ź�", 1, 16);
		frame.setBackground(new Color(248, 248, 255));
		
		JLabel numLab = new JLabel("���:");
		JLabel passwordLab = new JLabel("����:");
		JLabel typeLab = new JLabel("���:");
		passwordLab.setFont(font);
		typeLab.setFont(font);
		numLab.setFont(font);
		
		JTextField num = new JTextField(30);
		JPasswordField password = new JPasswordField(30);
		num.setFont(minifont);
		password.setFont(minifont);
		
		JComboBox<String> typeselect = new JComboBox<String>();
		typeselect.addItem("ѧ��");
		typeselect.addItem( "��ʦ");
		typeselect.addItem("����Ա");
		
		int height = 110 ;
		int length = 60 ;
		numLab.setBounds(110-length, 140-height, 90, 30);
		passwordLab.setBounds(110-length, 170-height, 80, 30);
		typeLab.setBounds(110-length, 200-height, 80 , 30);
		num.setBounds(210-length, 145-height, 270, 25);
		password.setBounds(210-length, 175-height, 270, 25);
		typeselect.setBounds(210-length, 205-height, 270, 25);
		typeselect.setFont(minifont);
		
		JButton submit = new JButton("��¼");
		JButton reset = new JButton("����");
		JButton logon = new JButton("ע��");
		
		submit.setBounds(150, 240-height, 80, 30);
		reset.setBounds(245, 240-height, 80, 30);
		logon.setBounds(340, 240-height, 80, 30);
		submit.setFont(minifont);
		reset.setFont(minifont);
		logon.setFont(minifont);
		
		frame.setLayout(null);
		frame.add(numLab);
		frame.add(passwordLab);
		frame.add(num);
		frame.add(password);
		frame.add(typeLab);
		frame.add(typeselect);
		frame.add(submit);
		frame.add(reset);
		frame.add(logon);
		
		//��¼����ʵ��
		submit.addActionListener(new ActionListener() {
			@SuppressWarnings({ "unused", "deprecation" })
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == submit) {
					String type = (String)typeselect.getSelectedItem();
					//���Ϊѧ��
					if(type.equals("ѧ��")) {
						String numcheck = num.getText();
						String passwordcheck = password.getText();
						Student std = new Student(numcheck, passwordcheck);
						if (std.checkuser()) {
							frame.setVisible(false);
							EventQueue.invokeLater(new Runnable() {
								public void run() {
									try {
										new Thread(new Runnable() {				
											@Override
											public void run() {
												new PreStudent(std);
											}
										}).start();
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
							});
						}else {
							JOptionPane.showMessageDialog(null, "�����º˶��������", "����", JOptionPane.WARNING_MESSAGE);
							//Wrong.showmessage.show(new JLabel("�����º˶��������", JLabel.CENTER));;
						}
					}
					else if (type.equals("����Ա")) {
						String numcheck = num.getText();
						String passwordcheck = password.getText();
						Adminstractor adm = new Adminstractor(numcheck,passwordcheck);
						if (adm.checkuser()) {
							frame.setVisible(false);
							EventQueue.invokeLater(new Runnable() {
								public void run() {
									try {
										new Thread(new Runnable() {				
											@Override
											public void run() {
												new AdminstractorMain();
											}
										}).start();
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
							});
						}else {
							JOptionPane.showMessageDialog(null, "�����º˶��������", "����", JOptionPane.WARNING_MESSAGE);
						}
					}
				}
			}
		});	
		//����ע�����
		logon.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				if (e.getSource() == logon) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								new Logon();
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
			}
		});
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\java-LIAOMIAO\\book_manage\\icon_resourse\\resizeApi.php.png"));
		frame.getContentPane().setBackground(	new Color(248, 248, 255));
		frame.setSize(500,240);
		frame.setLocation(690, 320);
		frame.setVisible(true);
		frame.requestFocus();
		num.requestFocus();
		
		//��Ӽ��̼����¼�
		//��Ҫ�ǿ�ݼ� ��ENTER ��¼
		password.addKeyListener(new KeyAdapter() {
			@SuppressWarnings({ "unused", "deprecation" })
			public void keyPressed (KeyEvent e) {
				if(e.getKeyCode() ==	KeyEvent.VK_ENTER) {
					String type = (String)typeselect.getSelectedItem();
					if(type.equals("ѧ��")) {
						String numcheck = num.getText();
						String passwordcheck = password.getText();
						Student std = new Student(numcheck, passwordcheck);
						if (std.checkuser()) {
							frame.setVisible(false);
							EventQueue.invokeLater(new Runnable() {
								public void run() {
									try {
										new Thread(new Runnable() {				
											@Override
											public void run() {
												new PreStudent(std);
											}
										}).start();
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
							});
						}else {
							JOptionPane.showMessageDialog(null, "�����º˶��������", "����", JOptionPane.WARNING_MESSAGE);
							//Wrong.showmessage.show(new JLabel("�����º˶��������", JLabel.CENTER));;
						}
						}
					else if (type.equals("����Ա")) {
						String numcheck = num.getText();
						String passwordcheck = password.getText();
						Adminstractor adm = new Adminstractor(numcheck,passwordcheck);
						if (adm.checkuser()) {
							frame.setVisible(false);
							EventQueue.invokeLater(new Runnable() {
								public void run() {
									try {
										new Thread(new Runnable() {				
											@Override
											public void run() {
												new AdminstractorMain();
											}
										}).start();
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
							});
						}else {
							JOptionPane.showMessageDialog(null, "�����º˶��������", "����", JOptionPane.WARNING_MESSAGE);
						}
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					num.requestFocus();
				}
			}
		});
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing (WindowEvent e) {
				System.exit(0);
			}
		});
		
	}
}
