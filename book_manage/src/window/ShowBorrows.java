package window;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import book.Book;
import sqlLink.BookSQLSelectAction;
import javax.swing.table.DefaultTableModel;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class ShowBorrows extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	Object[] titles = {"ÐòºÅ","ÊéÃû","½èÔÄÈËÑ§ºÅ"};
	Object[][] bookinfo = new Object[11][3];
    Book[] books = new Book[1000];
    int booknum = 0;
	JScrollPane jscrollpane = new JScrollPane();
	JTable table;
	/**
	 * Create the frame.
	 */
	public ShowBorrows() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\java-LIAOMIAO\\book_manage\\icon_resourse\\4.png"));
		setForeground(new Color(128, 128, 128));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 427, 477);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(248, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		getbooks();
		settable();
		
		contentPane.add(jscrollpane);
		setLocation(505, 200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	public void getbooks() {
		ResultSet set = new BookSQLSelectAction().SelectByexist();
		booknum = 0;
		try {
			while(set.next()) {
				 books[booknum] = new Book(set.getInt("num"), set.getString("name"), set.getString("author"), set.getString("press"), set.getString("type"));
				 books[booknum].setExist(set.getInt("exist"));
				 books[booknum].setRent(set.getString("rentmen"));
				 booknum++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void settable() {
		//ResultSet set = new BookSQLSelectAction().SelectByexist();
		bookinfo = new Object[booknum>11?booknum:11][3];
		for (int i = 0 ;i < booknum ; i++) {
			bookinfo[i][0] = books[i].getNum();
			bookinfo[i][1] = books[i].getName();
			bookinfo[i][2] = books[i].getRent();
		}
	    table = new JTable(bookinfo,titles);
	    table.getColumnModel().getColumn(0).setPreferredWidth(55);
	    table.getColumnModel().getColumn(1).setPreferredWidth(80);
	    table.getColumnModel().getColumn(2).setPreferredWidth(90);
	    table.setBorder(new EmptyBorder(0, 0, 0, 0));
		table.getTableHeader().setFont(new Font("Î¢ÈíÑÅºÚ", 1, 21));
		table.setFont(new Font("Î¢ÈíÑÅºÚ", 1, 18));
		jscrollpane.setBounds(5, 5, 400, 421);
		jscrollpane.setViewportView(table);
		table.setRowHeight(35); 
	}
}
