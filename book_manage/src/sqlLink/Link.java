package sqlLink;

import java.sql.Connection;
import java.sql.DriverManager;

public class Link {
	private Connection conn;
	public Connection link() {
		 String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		 String dbURL="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=bookmanage";
		 String userName="sa";
		 String userPwd="l1342670936";
		 
		 conn = null;

 		 try{
			 Class.forName(driverName);
		 }
		 catch(Exception e){    
			e.printStackTrace();
	     	System.out.println("加载驱动失败！");
		 }
		 try{
			 conn=DriverManager.getConnection(dbURL,userName,userPwd);
		 }
		 catch(Exception e) {
			 e.printStackTrace();
			 System.out.println("连接失败");
		 }
		return conn;
	}
}

