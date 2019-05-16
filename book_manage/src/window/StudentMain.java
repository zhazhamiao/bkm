package window;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import book.Book;
import sqlLink.BookSQLAction;
import user.Student;
import java.awt.SystemColor;
import javax.swing.table.DefaultTableModel;
import java.awt.Toolkit;

public class StudentMain{
	
	JFrame frame = new JFrame("ѧ����������");
	Font font = new Font("΢���ź�", 1, 20);
	ResultSet set = null;
	BookSQLAction action = new BookSQLAction();
	JPanel panel = new JPanel();
	JTable table;
	JScrollPane jscrollpane = new JScrollPane();
	Object[] titles = {"���","����","����","������","���","״̬"};
	Object[][] bookinfo = new Object[8][6];
	Book[] books = new Book[1000];
	int booknum = 0;
	//Student currentuser;
	
	public StudentMain(Student currentuser) {
		//this.currentuser = currentuser;
		frame.getContentPane().setBackground(	new Color(248, 248, 255));
		
		table = new JTable(bookinfo,titles);
		table.getColumnModel().getColumn(0).setPreferredWidth(45);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(70);
		table.getColumnModel().getColumn(3).setPreferredWidth(95);
		table.getColumnModel().getColumn(4).setPreferredWidth(70);
		table.getColumnModel().getColumn(5).setPreferredWidth(70);
		table.getTableHeader().setFont(new Font("΢���ź�", 1, 21));
		table.setFont(new Font("΢���ź�", 1, 18));
		jscrollpane.setBounds(100, 23, 600, 316);
		jscrollpane.setViewportView(table);
		table.setRowHeight(35); 
		
		JLabel text1 = new JLabel("ͨ��:");
		JComboBox<String> typeselect = new JComboBox<String>();
		typeselect.addItem("����");
		typeselect.addItem( "���");
		typeselect.addItem("����");
		typeselect.addItem("������");
		typeselect.addItem("����");
		typeselect.addItem("��ѯȫ��");
		JButton act = new JButton("��ѯ");
		JButton borrow = new JButton("ͼ����");
		JButton showborrow = new JButton("��ǰ���");
		showborrow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (arg0.getSource() == showborrow) {
					set = action.select.SelectByrent(currentuser.getNum());
					try {
						booknum = 0;
						while(set.next()) {		
							books[booknum] = new Book(set.getInt("num"), set.getString("name"), set.getString("author"), set.getString("press"), set.getString("type"));
							books[booknum].setExist(set.getInt("exist"));
							books[booknum].setRent(set.getString("rentmen"));
							booknum++;
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
					listbooks(books);
				}
			}
		});
		JButton returnbook = new JButton("�������");
		returnbook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (arg0.getSource() == returnbook) {
					EventQueue.invokeLater(new Runnable() {		
						@Override
						public void run() {
							try {
								new Thread(new Runnable() {				
									@Override
									public void run() {
										new Return(currentuser);
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
		
		act.setSize(100, 50);
		JTextField textField = new JTextField(100);
		
		typeselect.setFont(font);
		act.setFont(font);
		text1.setFont(font);
		textField.setFont(font);
		borrow.setFont(font);
		returnbook.setFont(font);
		showborrow.setFont(font);
		
		text1.setBounds(100, 370, 80, 30);
		typeselect.setBounds(191, 370, 120, 30);
		textField.setBounds(349, 370, 210, 30);
		textField.setBorder(BorderFactory.createLoweredBevelBorder());
		act.setBounds(600, 370, 100, 30);
		borrow.setBounds(100, 419, 150, 35);
		showborrow.setBounds(327, 419, 150, 35);
		returnbook.setBounds(550, 419, 150, 35);
		
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(typeselect);
		frame.getContentPane().add(text1);
		frame.getContentPane().add(act);
		frame.getContentPane().add(borrow);
		frame.getContentPane().add(showborrow);
		frame.getContentPane().add(returnbook);
		frame.getContentPane().add(textField);
		frame.getContentPane().add(jscrollpane);
		
		textField.requestFocus();
		act.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				if(e.getSource() == act) {
						String acttype = (String)typeselect.getSelectedItem();
						String getter = (String)textField.getText();
						
						if(acttype.equals("��ѯȫ��")) {
							set = action.select.selectAll();
						}
						else if(acttype.equals("����")) {
							set = action.select.selectBookByname(getter);
						}
						else if(acttype.equals("���")) {
							set = action.select.selectBookBynum(Integer.parseInt(getter));
						}
						else if(acttype.equals("����")) {
							set = action.select.selectBookByType(getter);
						}
						else if(acttype.equals("������")) {
							set = action.select.selectBookByPress(getter);
						}
						else if(acttype.equals("����")) {
							set = action.select.selectBooksByAuthor(getter);
						}
						try {
							booknum = 0;
							 while (set.next()) {
								 books[booknum] = new Book(set.getInt("num"), set.getString("name"), set.getString("author"), set.getString("press"), set.getString("type"));
								 books[booknum].setExist(set.getInt("exist"));
								 books[booknum].setRent(set.getString("rentmen"));
								 booknum++;
							 }
						} catch (SQLException e1) {
							// TODO �Զ����ɵ� catch ��
							e1.printStackTrace();
						}
						System.out.println(booknum);
						listbooks(books);
					}
			}
		});
		borrow.addActionListener(new ActionListener() {	
			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				if (e.getSource() == borrow) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								new Thread(new Runnable() {				
									@Override
									public void run() {
										new Borrow(currentuser);
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
		
		/*frame.addWindowListener(new WindowAdapter() {
			public void windowClosing (WindowEvent e) {
				System.exit(0);
			}
		});*/
		frame.getContentPane().setForeground(SystemColor.inactiveCaptionText);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\java-LIAOMIAO\\book_manage\\icon_resourse\\3.png"));
		
		frame.setSize(815,536);
		frame.setLocation(660, 250);
		frame.setVisible(true);
		frame.requestFocus();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	//�Ѳ�ѯ�����鱾��Ϣ���뵽�����
	public void listbooks(Book[] listbooks) {
			bookinfo = new Object[booknum>8?booknum:8][6];
			for (int i = 0 ;i < booknum ; i++) {
				bookinfo[i][0] = listbooks[i].getNum();
				bookinfo[i][1] = listbooks[i].getName();
				bookinfo[i][2] = listbooks[i].getAuthor();
				bookinfo[i][3] = listbooks[i].getPress();
				bookinfo[i][4] = listbooks[i].getType();
				if(listbooks[i].getExist()==0) {
					bookinfo[i][5] = "δ������";
				}
				else bookinfo[i][5] = "������";
			}
			table = new JTable(bookinfo,titles);
			table.getColumnModel().getColumn(0).setPreferredWidth(45);
			table.getColumnModel().getColumn(1).setPreferredWidth(100);
			table.getColumnModel().getColumn(2).setPreferredWidth(70);
			table.getColumnModel().getColumn(3).setPreferredWidth(95);
			table.getColumnModel().getColumn(4).setPreferredWidth(70);
			table.getColumnModel().getColumn(5).setPreferredWidth(70);
			table.getTableHeader().setFont(new Font("΢���ź�", 1, 21));
			table.setFont(new Font("΢���ź�", 1, 18));
			jscrollpane.setBounds(100, 23, 600, 316);
			jscrollpane.setViewportView(table);
			table.setRowHeight(35); 
			frame.getContentPane().add(jscrollpane);
	}
}