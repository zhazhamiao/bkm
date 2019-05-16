package window;

import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import sqlLink.ForDate;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class AllBookrbnotes extends JFrame {

	private JPanel contentPane;
	Object[] titles = {"ÊéºÅ","Ñ§ºÅ","½èÔÄÊ±¼ä","¹é»¹Ê±¼ä"};
	Object[][] info = new Object[11][4];
    int datenum = 0;
	JScrollPane jscrollpane = new JScrollPane();
	JTable table;
	ForDate forDate = new ForDate();

	public AllBookrbnotes() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\java-LIAOMIAO\\book_manage\\icon_resourse\\4.png"));
		setForeground(new Color(128, 128, 128));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 441, 477);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(248, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		try {
			settable();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		contentPane.add(jscrollpane);
		setLocation(505, 200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	public void settable() throws SQLException {
		ResultSet set = forDate.GetNoteDate();
		while(set.next()) {
			datenum++;
		}
		set = forDate.GetNoteDate();
		info = new Object[datenum>11?datenum:11][4];
		int num = 0;
		while (set.next()) {
			info[num][0] = set.getInt("bnum");
			info[num][1] = set.getString("snum");
			info[num][2] = set.getDate("borrowdate");
			if (set.getInt("returnble") == 0) {
				info[num][3] = "ÉÐÎ´¹é»¹";
			}else {
				info[num][3] = set.getDate("returndate");
			}
			num++;
		}
	    table = new JTable(info,titles);
	    table.getColumnModel().getColumn(0).setPreferredWidth(40);
	    table.getColumnModel().getColumn(1).setPreferredWidth(75);
	    table.getColumnModel().getColumn(2).setPreferredWidth(100);
	    table.getColumnModel().getColumn(3).setPreferredWidth(100);
	    table.setBorder(new EmptyBorder(0, 0, 0, 0));
		table.getTableHeader().setFont(new Font("Î¢ÈíÑÅºÚ", 1, 21));
		table.setFont(new Font("Î¢ÈíÑÅºÚ", 1, 18));
		jscrollpane.setBounds(5, 5, 415, 421);
		jscrollpane.setViewportView(table);
		table.setRowHeight(35); 
	}
}
