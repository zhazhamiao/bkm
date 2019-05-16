package user;

import actions.check;

public class Teacher extends Reader implements check{

	@Override
	public boolean checkuser() {
		return false;
	}

}
