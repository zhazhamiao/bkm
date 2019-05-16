package sqlLink;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ForDate {
	private Connection conn = new Link().link();
	private ResultSet set = null;
	private PreparedStatement stmt;
	
	public void insertDate(String snum,int bnum,Date date1) {
	//	Date date1 = new Date(System.currentTimeMillis());
		String sql = "INSERT INTO booknotes VALUES(?,?,?,?,?)";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, snum);
			stmt.setInt(2, bnum);
			stmt.setDate(3, date1);
			stmt.setDate(4, date1);
			stmt.setInt(5, 0);
			if (stmt.executeUpdate()!=0) {
				System.out.println("����ɹ�");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("����ʧ��");
		}
	}
	
	public ResultSet GetNoteDate() {
		String sql = "SELECT * FROM booknotes";
		 try {
			stmt = conn.prepareStatement(sql);
			 set = stmt.executeQuery();
			 return set;
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} 
		return null;
	}
	
	public void Update_return_Date(String snum,int bnum,Date date) {
		String sql = "UPDATE booknotes SET returndate = ?,returnble = 1 WHERE snum = ? AND bnum=? AND returnble = 0";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setDate(1, date);
			stmt.setString(2, snum);
			stmt.setInt(3, bnum);
			
			if (stmt.executeUpdate()!=0) {
				System.out.println("���³ɹ�");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("����ʧ��");
		}
	}
	public ResultSet Get_Notedates_Unreturn() {
		String sql = "SELECT * FROM booknotes WHERE returnble = 0";
		 try {
			stmt = conn.prepareStatement(sql);
			 set = stmt.executeQuery();
			 return set;
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} 
		return null;
	}
}
