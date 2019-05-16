package sqlLink;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BookSQLSelectAction {
	
	private Connection conn = new Link().link();
	private ResultSet set = null;
	private PreparedStatement stmt;
	
	public ResultSet selectBookBynum(int booknum) {	
		try{
			 String sql = "SELECT * FROM books WHERE num = ?";
			 stmt = conn.prepareStatement(sql); 
			 stmt.setInt(1, booknum);
			 set = stmt.executeQuery();
			 
			 /*while (set.next()) {
				 int num = set.getInt("num");
				 String name = set.getString("name");
				 String author = set.getString("author");
				 String press = set.getString("press");
				 String type = set.getString("type");
				 int exist = set.getInt("exist");
				 if(exist == 0) {
					 System.out.print("序号: "+num+" 书名: "+name+" 作者: "+author+" 出版社: "+press+" 类别: "+type);
					 System.out.println(" 未被借出");
				 }
				 else {
					 System.out.print("序号: "+num+" 书名: "+name+" 作者: "+author+" 出版社: "+press+" 类别: "+type);
					 System.out.println(" 被借出 借书人学号:" + set.getString("rentmen"));
				 }
			 }*/
			 return set;
		 }
		 catch(Exception e){
			 e.printStackTrace();
			 System.out.print("查询失败");
		 }    
		return null;
	}
	
	public ResultSet selectBookByname(String bookname) {
		try{
			 String sql = "SELECT * FROM books WHERE name = ?";
			 stmt = conn.prepareStatement(sql); 
			 stmt.setString(1, bookname);
			 set = stmt.executeQuery();
		 
			 /*while (set.next()) {
				 int num = set.getInt("num");
				 String name = set.getString("name");
				 String author = set.getString("author");
				 String press = set.getString("press");
				 String type = set.getString("type");
				 int exist = set.getInt("exist");
				 if(exist == 0) {
					 System.out.print("序号: "+num+" 书名: "+name+" 作者: "+author+" 出版社: "+press+" 类别: "+type);
					 System.out.println(" 未被借出");
				 }
				 else {
					 System.out.print("序号: "+num+" 书名: "+name+" 作者: "+author+" 出版社: "+press+" 类别: "+type);
					 System.out.println(" 被借出 借记人学号:" + set.getString("rentmen"));
				 }
			 }*/
			 return set;
		 }
		 catch(Exception e){
			 e.printStackTrace();
			 System.out.print("查询失败");
		 }        
		return null;
	}
	
	public ResultSet selectAll() {
		try{
			 String sql = "SELECT * FROM books";
			 stmt = conn.prepareStatement(sql); 
			 set = stmt.executeQuery();
			 
			/* while (set.next()) {
				 int num = set.getInt("num");
				 String name = set.getString("name");
				 String author = set.getString("author");
				 String press = set.getString("press");
				 String type = set.getString("type");
				 int exist = set.getInt("exist");
				 if(exist == 0) {
					 System.out.print("序号: "+num+" 书名: "+name+" 作者: "+author+" 出版社: "+press+" 类别: "+type);
					 System.out.println(" 未被借出");
				 }
				 else {
					 System.out.print("序号: "+num+" 书名: "+name+" 作者: "+author+" 出版社: "+press+" 类别: "+type);
					 System.out.println(" 被借出 借书人学号:" + set.getString("rentmen"));
				 }
			 }*/
			 return set;
		 }
		 catch(Exception e){
			 e.printStackTrace();
			 System.out.print("查询失败");
		 }        
		return null;
	}
	
	public ResultSet selectBookByType(String booktype) {
		try{
			 String sql = "SELECT * FROM books WHERE type = ?";
			 stmt = conn.prepareStatement(sql); 
			 stmt.setString(1, booktype);
			 set = stmt.executeQuery();
			 
			 /*while (set.next()) {
				 int num = set.getInt("num");
				 String name = set.getString("name");
				 String author = set.getString("author");
				 String press = set.getString("press");
				 String type = set.getString("type");
				 int exist = set.getInt("exist");
				 if(exist == 0) {
					 System.out.print("序号: "+num+" 书名: "+name+" 作者: "+author+" 出版社: "+press+" 类别: "+type);
					 System.err.println(" 未被借出");
				 }
				 else {
					 System.out.print("序号: "+num+" 书名: "+name+" 作者: "+author+" 出版社: "+press+" 类别: "+type);
					 System.out.println(" 被借出 借书人学号:" + set.getString("rentmen"));
				 }
			 }*/
			 return set;
		 }
		 catch(Exception e){
			 e.printStackTrace();
			 System.out.print("查询失败");
		 }   
		return null;
	}
	public ResultSet selectBookByPress (String presstype) {
		try{
			 String sql = "SELECT * FROM books WHERE press = ?";
			 stmt = conn.prepareStatement(sql); 
			 stmt.setString(1, presstype);
			 set = stmt.executeQuery();
			 
			/* while (set.next()) {
				 int num = set.getInt("num");
				 String name = set.getString("name");
				 String author = set.getString("author");
				 String press = set.getString("press");
				 String type = set.getString("type");
				 int exist = set.getInt("exist");
				 if(exist == 0) {
					 System.out.print("序号: "+num+" 书名: "+name+" 作者: "+author+" 出版社: "+press+" 类别: "+type);
					 System.err.println(" 未被借出");
				 }
				 else {
					 System.out.print("序号: "+num+" 书名: "+name+" 作者: "+author+" 出版社: "+press+" 类别: "+type);
					 System.out.println(" 被借出 借书人学号:" + set.getString("rentmen"));
				 }
			 }*/
			 return set;
		 }
	 catch(Exception e){
			 e.printStackTrace();
			 System.out.print("查询失败");
		 }   
		return null;
	}
	public ResultSet selectBooksByAuthor(String authortype) {
		try{
			 String sql = "SELECT * FROM books WHERE author = ?";
			 stmt = conn.prepareStatement(sql); 
			 stmt.setString(1, authortype);
			 set = stmt.executeQuery();
			 
			/* while (set.next()) {
				 int num = set.getInt("num");
				 String name = set.getString("name");
				 String author = set.getString("author");
				 String press = set.getString("press");
				 String type = set.getString("type");
				 int exist = set.getInt("exist");
				 if(exist == 0) {
					 System.out.print("序号: "+num+" 书名: "+name+" 作者: "+author+" 出版社: "+press+" 类别: "+type);
					 System.err.println(" 未被借出");
				 }
				 else {
					 System.out.print("序号: "+num+" 书名: "+name+" 作者: "+author+" 出版社: "+press+" 类别: "+type);
					 System.out.println(" 被借出 借书人学号:" + set.getString("rentmen"));
				 }
			 }*/
			 return set;
		 }
	 catch(Exception e){
			 e.printStackTrace();
			 System.out.print("查询失败");
		 }   
		return null;
	}
	public ResultSet SelectByrent(String rentmen) {
		try{
			 String sql = "SELECT * FROM books WHERE rentmen = ?";
			 stmt = conn.prepareStatement(sql); 
			 stmt.setString(1, rentmen);
			 set = stmt.executeQuery();
			 return set;
		}
		catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
			 System.out.print("查询失败");
		}
		return null;		
	}
	public ResultSet SelectByexist(){
		try{
			 String sql = "SELECT * FROM books WHERE exist = ?";
			 stmt = conn.prepareStatement(sql); 
			 stmt.setInt(1, 1);
			 set = stmt.executeQuery();
			 return set;
		}
		catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
			 System.out.print("查询失败");
		}
		return null;
	}
}
