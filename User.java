import java.io.Serializable;

public class User implements Serializable{
	private static final String admin_user= "Admin";
	private static final String admin_pass = "Admin001";
	protected String username;
	protected String pass;
	protected String first;
	protected String last;
	
	public User() {
		
	}
	public User (String first, String last, String username, String pass) {
		this.first = first;
		this.last = last;
		this.username = username;
		this.pass = pass;
	}
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String fisrt) {
		this.first = fisrt;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public void Print() {
		System.out.println("Your first name is: "+this.first);
		System.out.println("Your last name is: "+this.last);
		System.out.println("Your username is: "+this.username);
		System.out.println("Your password is: "+this.pass);
		
	}
	
}


