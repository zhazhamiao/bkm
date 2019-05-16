package sqlLink;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import user.Student;

public class UserAct {
	private Connection conn = new Link().link();
	
	public boolean AddUser(Student student) {
		String sql = "INSERT INTO student VALUES(?,?,?);";
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, student.getNum());
			stmt.setString(2, student.getName());
			stmt.setString(3, student.getPassword());
			
			if (stmt.executeUpdate()!=0) {
				System.out.println("插入成功");
				addUserInformation(student);
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("该用户已存在");
			return false;
		}
		return false;
	}
	public boolean updateuser(String num,String name,String password) {
		String sql = "UPDATE student 	SET password = ?,name = ? WHERE num = ?";
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, password);
			stmt.setString(2, name);
			stmt.setString(3, num);
			if (stmt.executeUpdate()!=0) {
				System.out.println("更新成功");
				return true;
			}
		} catch (Exception e) {
			System.out.println("更新失败");
			e.printStackTrace();
		}
		return false;
	}
	public void addUserInformation(Student student) {
		String sql = "INSERT INTO student_information VALUES(?,?,?,?,?,?,?,?);";
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, student.getNum());
			stmt.setString(2, student.getName());
			stmt.setString(3, "");
			stmt.setString(4, "");
			stmt.setString(5, "");
			stmt.setString(6, "");
			stmt.setString(7, "");
			stmt.setDate(8, new Date(System.currentTimeMillis()));
			
			if (stmt.executeUpdate()!=0) {
				System.out.println("插入成功");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("信息更新错误");
		}
	}

}
