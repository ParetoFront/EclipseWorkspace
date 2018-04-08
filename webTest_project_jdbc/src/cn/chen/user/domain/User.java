package cn.chen.user.domain;

public class User {
	private String username;
	private String password;
	private String verifycode;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getVerifycode() {
		return verifycode;
	}
	public void setVerifycode(String verifycode) {
		this.verifycode = verifycode;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", verifycode=" + verifycode + "]";
	}
	public User(String username, String password, String verifycode) {
		super();
		this.username = username;
		this.password = password;
		this.verifycode = verifycode;
	}
	public User() {
		super();
	}
	
}
