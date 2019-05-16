package user;



import java.sql.SQLException;

import actions.Bookactions;
import actions.check;
import book.Book;
import sqlLink.BookSQLAction;

public class Student extends Reader implements check,Bookactions{
	@SuppressWarnings("unused")
	
	BookSQLAction action = new BookSQLAction();
	@SuppressWarnings("unused")
	private Student() {
	}
	
	public Student(String num,String password) {
		this.num = num;
		this.password = password;
	}
	@Override
	public boolean checkuser() {
		try {
			String sql = "SELECT * FROM student WHERE num = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, num);
			set = stmt.executeQuery();		
			while (set.next()) {
				passwordcheck = set.getString("password");
				name = set.getString("name");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		if(password.equals(passwordcheck)) return true;
		else return false;
	}

	@Override
	public boolean rentbook(Book book) {
		// TODO 自动生成的方法存根
		book.setRent(num);
		book.setExist(1);
		action.setWaitaction(book);
		return action.update();
	}

	@Override
	public boolean returnbook(Book book) {
		// TODO 自动生成的方法存根
		book.setRent("");
		book.setExist(0);
		action.setWaitaction(book);
		return action.update();
	}

	
}
