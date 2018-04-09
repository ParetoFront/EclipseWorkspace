package cn.chen.dbutils;

public class User {
	private String username;
	private String password;
	private int age;
	private int salary;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public User(String username, String password, int age, int salary) {
		super();
		this.username = username;
		this.password = password;
		this.age = age;
		this.salary = salary;
	}
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "user [username=" + username + ", password=" + password + ", age=" + age + ", salary=" + salary
				+ "]";
	}
	
}
