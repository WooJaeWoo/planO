package model;

public class User {
	String uId;
	String email;
	String password;
	String name;
	String birth;
	
	public User(String uId, String email, String password, String name,
			String birth) {
		super();
		this.uId = uId;
		this.email = email;
		this.password = password;
		this.name = name;
		this.birth = birth;
	}
	
	public String getuId() {
		return uId;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getName() {
		return name;
	}
	
	public String getBirth() {
		return birth;
	}
}
