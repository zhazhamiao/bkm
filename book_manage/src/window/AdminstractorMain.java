package window;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import book.Book;
import sqlLink.BookSQLAction;

public class AdminstractorMain {
	
	Frame frame = new Frame("管理员操作界面");
	Font font = new Font("微软雅黑", 1, 20);
	ResultSet set = null;
	BookSQLAction action = new BookSQLAction();
	JPanel panel = new JPanel();
	JTable table;
	JTable waitset;
	JScrollPane jscrollpane = new JScrollPane();
	JScrollPane jScrollPane2 = new JScrollPane();
	Object[] titles = {"序号","书名","作者","出版社","类别","状态"};
	Object[][] bookinfo = new Object[13][6];
	Book[] books = new Book[1000];
	Book waitactbook;
	int booknum = 0;
	
	public AdminstractorMain() {
		frame.setBackground(new Color(248, 248, 255));
		
		JLabel text1 = new JLabel("通过:");
		JLabel text2 = new JLabel("设置待操作书目   通过序号:");
		JLabel text3 = new JLabel("查询或创建");
		
		JComboBox<String> typeselect = new JComboBox<String>();
		typeselect.addItem("书名");
		typeselect.addItem( "序号");
		typeselect.addItem("类型");
		typeselect.addItem("出版社");
		typeselect.addItem("作者");
		typeselect.addItem("查询全部");
		
		JButton act = new JButton("查询");
		JButton doset = new JButton("执行");
		JButton add = new JButton("添加图书");
		JButton delete = new JButton("删除图书");
		JButton update = new JButton("更新图书");
		JButton showborrow = new JButton("当前借出图书");
		JButton bookbrnotes = new JButton("所有借阅记录");
		
		JTextField textField = new JTextField(100);
		JTextField numField = new JTextField(50);
		
		typeselect.setFont(new Font("微软雅黑", 1, 18));
		act.setFont(font);
		doset.setFont(font);
		add.setFont(font);
		delete.setFont(font);
		update.setFont(font);
		text1.setFont(font);
		text2.setFont(font);
		text3.setFont(font);
		textField.setFont(font);
		numField.setFont(font);
		showborrow.setFont(font);
		bookbrnotes.setFont(font);
		
		table = new JTable(bookinfo,titles);
		table.getColumnModel().getColumn(0).setPreferredWidth(40);
		table.getColumnModel().getColumn(1).setPreferredWidth(95);
		table.getColumnModel().getColumn(2).setPreferredWidth(45);
		table.getColumnModel().getColumn(3).setPreferredWidth(90);
		table.getColumnModel().getColumn(4).setPreferredWidth(45);
		table.getColumnModel().getColumn(5).setPreferredWidth(55);
		table.getTableHeader().setFont(new Font("微软雅黑", 1, 21));
		table.setFont(new Font("微软雅黑", 1, 18));
		jscrollpane.setBounds(15, 45, 520, 491);
		jscrollpane.setViewportView(table);
		table.setRowHeight(35); 
		
		waitset = new JTable(new Object[1][6],titles);
		waitset.getColumnModel().getColumn(0).setPreferredWidth(40);
		waitset.getColumnModel().getColumn(1).setPreferredWidth(95);
		waitset.getColumnModel().getColumn(2).setPreferredWidth(45);
		waitset.getColumnModel().getColumn(3).setPreferredWidth(90);
		waitset.getColumnModel().getColumn(4).setPreferredWidth(45);
		waitset.getColumnModel().getColumn(5).setPreferredWidth(55);
		waitset.setRowHeight(32);
		waitset.getTableHeader().setFont(new Font("微软雅黑", 1, 17));
		waitset.setFont(new Font("微软雅黑", 1, 16));
		jScrollPane2.setBounds(15, 591, 520, 62);
		jScrollPane2.setViewportView(waitset);
		frame.add(jScrollPane2);
		
		text1.setBounds(560, 80, 100, 30);
		typeselect.setBounds(660, 80, 100, 30);
		textField.setBounds(560, 120, 200, 30);
		textField.setBorder(BorderFactory.createLoweredBevelBorder());
		numField.setBorder(BorderFactory.createLoweredBevelBorder());
		act.setBounds(660, 160, 100, 30);
		text2.setBounds(15, 551, 250, 30);
		numField.setBounds(285, 553, 100, 28);
		text3.setBounds(430, 551, 100, 30);
		doset.setBounds(660, 551, 100, 28);
		add.setBounds(610, 591, 150, 35);
		delete.setBounds(610, 636, 150, 35);
		update.setBounds(610, 681, 150, 35);
		showborrow.setBounds(585, 506, 175, 30);
		bookbrnotes.setBounds(585, 200,175,30);
		
		frame.setLayout(null);
		frame.add(typeselect);
		frame.add(text1);
		frame.add(text2);
		frame.add(text3);
		frame.add(act);
		frame.add(doset);
		frame.add(add);
		frame.add(delete);
		frame.add(update);
		frame.add(showborrow);
		frame.add(bookbrnotes);
		frame.add(textField);
		frame.add(numField);
		frame.add(jscrollpane);

		act.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				if(e.getSource() == act) {
						String acttype = (String)typeselect.getSelectedItem();
						String getter = (String)textField.getText();
						
						if(acttype.equals("查询全部")) {
							set = action.select.selectAll();
						}
						else if(acttype.equals("书名")) {
							set = action.select.selectBookByname(getter);
						}
						else if(acttype.equals("序号")) {
							set = action.select.selectBookBynum(Integer.parseInt(getter));
						}
						else if(acttype.equals("类型")) {
							set = action.select.selectBookByType(getter);
						}
						else if(acttype.equals("出版社")) {
							set = action.select.selectBookByPress(getter);
						}
						else if(acttype.equals("作者")) {
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
							// TODO 自动生成的 catch 块
							e1.printStackTrace();
						}
							System.out.println(booknum);
							listbooks(books);
					}
			}
		});
		doset.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == doset) {
					int num = Integer.parseInt((String)numField.getText());
					try {
						SetWaitActionBook(num);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == add) {
					GetWaitActionBook();
					action.setWaitaction(waitactbook);
					if(action.AddBook())
						JOptionPane.showMessageDialog(null, "添加成功", "提示信息", JOptionPane.INFORMATION_MESSAGE);
					else JOptionPane.showMessageDialog(null, "添加失败", "提示信息", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				if(e.getSource() == delete) {
					action.delete.deleteBookByNum(Integer.parseInt(waitset.getValueAt(0, 0).toString()));
					JOptionPane.showMessageDialog(null, "删除成功", "提示信息", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		update.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == update) {
					GetWaitActionBook();
					action.setWaitaction(waitactbook);
					if (action.update())
						JOptionPane.showMessageDialog(null, "更新成功", "提示信息", JOptionPane.INFORMATION_MESSAGE);
					else 
						JOptionPane.showMessageDialog(null, "更新失败", "提示信息", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		showborrow.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == showborrow) {
					EventQueue.invokeLater(new Runnable() {	
						@Override
						public void run() {
							try {
								new Thread(new Runnable() {				
									@Override
									public void run() {
										new ShowBorrows();
									}
								}).start();
							} catch (Exception e) {
								// TODO: handle exception
								e.printStackTrace();
							}	
						}
					});
				}	
			}
		});
		bookbrnotes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == bookbrnotes ) {
					EventQueue.invokeLater(new Runnable() {	
						@Override
						public void run() {
							try {
								new Thread(new Runnable() {				
									@Override
									public void run() {
										new AllBookrbnotes();
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
		
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\java-LIAOMIAO\\book_manage\\icon_resourse\\4.png"));
		frame.setSize(800,750);
		frame.setLocation(390, 120);
		frame.setVisible(true);
		frame.requestFocus();
		
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing (WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	private void listbooks(Book[] listbooks) {
		bookinfo = new Object[booknum>13?booknum:13][6];
		for (int i = 0 ;i < booknum ; i++) {
			bookinfo[i][0] = listbooks[i].getNum();
			bookinfo[i][1] = listbooks[i].getName();
			bookinfo[i][2] = listbooks[i].getAuthor();
			bookinfo[i][3] = listbooks[i].getPress();
			bookinfo[i][4] = listbooks[i].getType();
			if(listbooks[i].getExist()==0) {
				bookinfo[i][5] = "未被借阅";
			}
			else bookinfo[i][5] = "借阅中";
		}
		table = new JTable(bookinfo,titles);
		table.getColumnModel().getColumn(0).setPreferredWidth(40);
		table.getColumnModel().getColumn(1).setPreferredWidth(95);
		table.getColumnModel().getColumn(2).setPreferredWidth(45);
		table.getColumnModel().getColumn(3).setPreferredWidth(90);
		table.getColumnModel().getColumn(4).setPreferredWidth(45);
		table.getColumnModel().getColumn(5).setPreferredWidth(55);
		table.getTableHeader().setFont(new Font("微软雅黑", 1, 21));
		table.setFont(new Font("微软雅黑", 1, 18));
		jscrollpane.setBounds(15, 45, 520, 491);
		jscrollpane.setViewportView(table);
		table.setRowHeight(35); 
	}
	
	private void SetWaitActionBook(int num) throws SQLException {
		ResultSet set = action.select.selectBookBynum(num);
		set.next();
		Book setbook = new Book(set.getInt("num"), set.getString("name"), set.getString("author"), set.getString("press"), set.getString("type"));
		setbook.setExist(set.getInt("exist"));
		setbook.setRent(set.getString("rentmen"));
		waitactbook = setbook;
		Object[][] waitact = {{setbook.getNum(),setbook.getName(),setbook.getAuthor(),setbook.getPress(),setbook.getType(),setbook.getExist()}};
		waitset = new JTable(waitact,titles) ;
		waitset.getColumnModel().getColumn(0).setPreferredWidth(40);
		waitset.getColumnModel().getColumn(1).setPreferredWidth(95);
		waitset.getColumnModel().getColumn(2).setPreferredWidth(45);
		waitset.getColumnModel().getColumn(3).setPreferredWidth(90);
		waitset.getColumnModel().getColumn(4).setPreferredWidth(45);
		waitset.getColumnModel().getColumn(5).setPreferredWidth(55);
		waitset.setRowHeight(32);
		waitset.getTableHeader().setFont(new Font("微软雅黑", 1, 17));
		waitset.setFont(new Font("微软雅黑", 1, 16));
		jScrollPane2.setBounds(15, 591, 520, 62);
		jScrollPane2.setViewportView(waitset);
	}
	
	private void GetWaitActionBook() {
		if(Integer.parseInt(waitset.getValueAt(0, 5).toString())!=1 && Integer.parseInt(waitset.getValueAt(0, 5).toString())!=0) {
			JOptionPane.showMessageDialog(null, "参数不正确，请重新输入", "警告", JOptionPane.WARNING_MESSAGE);
			return;
		}
		waitactbook = new Book
				(Integer.parseInt(waitset.getValueAt(0, 0).toString()), 
						(String) waitset.getValueAt(0, 1), 
						(String) waitset.getValueAt(0, 2), 
						(String) waitset.getValueAt(0, 3), 
						(String) waitset.getValueAt(0, 4));
		waitactbook.setExist(Integer.parseInt(waitset.getValueAt(0, 5).toString()));
		/*
		waitactbook.setNum(Integer.parseInt(waitset.getValueAt(0, 0).toString()));
		waitactbook.setName((String) waitset.getValueAt(0, 1));
		waitactbook.setAuthor((String) waitset.getValueAt(0, 2));
		waitactbook.setPress((String) waitset.getValueAt(0, 3));
		waitactbook.setType((String) waitset.getValueAt(0, 4));
		waitactbook.setExist(Integer.parseInt(waitset.getValueAt(0, 0).toString()));
		 */
	}
}











