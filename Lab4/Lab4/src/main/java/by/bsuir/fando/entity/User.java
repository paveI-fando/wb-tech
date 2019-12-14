package by.bsuir.fando.entity;

public class User {
	private String login;
	private String email;
	private String status;
	private String password;
	
	public User(String login, String email, String status, String password) {
		this.login = login;
		this.email = email;
		this.status = status;
		this.password = password;
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
