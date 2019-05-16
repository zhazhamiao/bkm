package sqlLink;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import book.Book;

public class BookSQLAction {
	
	private Connection conn = new Link().link();
	public BookSQLSelectAction select = new BookSQLSelectAction();
	public BookSQLDeleteAction delete = new BookSQLDeleteAction();
	
	private Book waitaction = null;
	
	//设置待操作书籍
	public void setWaitaction(Book newbook) {
		this.waitaction = newbook;
	}
	
	public boolean AddBook() {
		String sql = "INSERT INTO books VALUES(?,?,?,?,?,?,?);";
		
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, waitaction.getNum());
			stmt.setString(2, waitaction.getName());
			stmt.setString(3, waitaction.getAuthor());
			stmt.setString(4, waitaction.getPress());
			stmt.setString(5, waitaction.getType());
			stmt.setInt(6, 0);
			stmt.setString(7, null);
			
			if (stmt.executeUpdate()!=0) {
				System.out.println("插入成功");
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("改图书序号已存在");
			return false;
		}
		return false;
	}
	public boolean update () {
		String sql = "UPDATE books SET name = ?,author = ?,press = ?, type = ?,exist = ?,rentmen = ? "
				+ "WHERE num = ?";
		
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, waitaction.getName());
			stmt.setString(2, waitaction.getAuthor());
			stmt.setString(3, waitaction.getPress());
			stmt.setString(4, waitaction.getType());
			stmt.setInt(5, waitaction.getExist());
			stmt.setString(6, waitaction.getRent());
			stmt.setInt(7, waitaction.getNum());
			
			if (stmt.executeUpdate()!=0) {
				System.out.println("更新成功");
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("更新失败");
		}
		return false;
	}
}
