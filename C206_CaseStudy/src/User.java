
/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 20041283, 1 Aug 2021 2:37:04 pm
 */

public class User {
	
	private String name;
	private String role;
	private String email;
	private String status;
	private String password;
	
	public User(String name, String role, String email, String status, String password) {
		this.name = name;
		this.role = role;
		this.email = email;
		this.status = status;
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User(String name, String role, String email, String status) {
		
		this.name = name;
		this.role = role;
		this.email = email;
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
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

}
