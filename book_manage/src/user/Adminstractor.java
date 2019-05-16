package user;

import java.sql.SQLException;
import actions.check;

public class Adminstractor extends Person implements check{
	
	@SuppressWarnings("unused")
	private Adminstractor() {
	}
	public Adminstractor(String name,String password) {
		this.name = name;
		this.password = password;
	}
	@Override
	public boolean checkuser() {
		// TODO 自动生成的方法存根
		try {
			String sql = "SELECT password FROM adminstractor WHERE name = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, name);
			set = stmt.executeQuery();		
			while (set.next()) {
				passwordcheck = set.getString("password");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		if(password.equals(passwordcheck)) return true;
		return false;
	}

}
