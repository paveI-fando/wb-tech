package by.bsuir.fando.entity.client;

import by.bsuir.fando.entity.client.interfaces.IUser;

public class User implements IUser, java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String login;
	
	public User() {
		setLogin("");
	}
	
	public User(String login) {
		setLogin(login);
	}

	//TODO rewrite equals
	@Override
	public boolean equals(Object o) {
		if (this == (User)o) {
			return true;
		}else {
			return false;
		}
		
	}
	
	//TODO rewrite hashCode
	@Override
    public int hashCode() {
        int result = this.hashCode();
        return result;
    }

	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}
	
}
