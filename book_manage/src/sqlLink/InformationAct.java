package sqlLink;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class InformationAct {
	
	private Connection conn = new Link().link();
	private ResultSet set = null;
	private PreparedStatement stmt;
	
	public ResultSet selectInformation (String num) {
		try {
			String sql = "SELECT * FROM student_information WHERE num = ?";
			 stmt = conn.prepareStatement(sql); 
			 stmt.setString(1, num);
			 set = stmt.executeQuery();
			 return set;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("查询失败");
		}
		return null;
	}
	
	public boolean updateInformation (String num, String name, String classfield, String chamber, String e_mail, String phone, String birth) {
		String sql = "UPDATE student_information SET name = ?,class = ?,chamber = ?,e_mail = ?,phone = ?,birth = ?"
				+ " WHERE num = ?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.setString(2, classfield);
			stmt.setString(3, chamber);
			stmt.setString(4, e_mail);
			stmt.setString(5, phone);
			stmt.setString(6, birth);
			stmt.setString(7, num);
			
			if (stmt.executeUpdate()!=0) {
				System.out.println("更新成功");
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("更新失败");
		}
		return false;
	}
}
