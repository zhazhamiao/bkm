package sqlLink;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class BookSQLDeleteAction {
	private Connection conn = new Link().link();
	private PreparedStatement stmt;
	
	public void deleteBookByNum(int booknum) {
		try{
			 String sql = "DELETE FROM books WHERE num = ?";
			 stmt = conn.prepareStatement(sql); 
			 stmt.setInt(1, booknum);
			 if(stmt.executeUpdate()!=0) {
				 System.err.println("É¾³ý³É¹¦");
			 };
		}
		 catch(Exception e){
			 e.printStackTrace();
			 System.err.print("É¾³ýÊ§°Ü");
		 }       
	}
	
	public void deleteBookByname (String bookname) {
		try{
			 String sql = "DELETE FROM books WHERE name = ?";
			 stmt = conn.prepareStatement(sql); 
			 stmt.setString(1, bookname);
			 if(stmt.executeUpdate()!=0) {
				 System.err.println("É¾³ý³É¹¦");
			 };
		}
		 catch(Exception e){
			 e.printStackTrace();
			 System.err.print("É¾³ýÊ§°Ü");
		 }       
	}
}
