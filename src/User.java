import java.math.BigDecimal;

public class User
{
	private final int USERID;
	private String username;
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private String extension;
	private String dob;
	private String gender;

	public User(int userId, String username, String email, String password, String firstName, String lastName, String extension, String dob, String gender) {
		USERID = userId;
		this.username = username;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.extension = extension;
		this.dob = dob;
		this.gender = gender;
	}
//SETTER
	public void setUsername(String un) {
		username = un;
	}

	public void setEmail(String e) {
		email = e;
	}

	public void setPassword(String pw) {
		password = pw;
	}

	public void setFirstName(String fn) {
		firstName = fn;
	}

	public void setLastName(String ln) {
		lastName = ln;
	}

	public void setExtension(String ex) {
		extension = ex;
	}

	public void setdob(String dob) {
		this.dob = dob;
	}
//GETTER
	public int getUserId() {
		return(USERID);
	}

	public String getUsername() {
		return(username);
	}

	public String getEmail() {
		return(email);
	}

	public String getPassword() {
		return(password);
	}

	public String getFirstName() {
		return(firstName);
	}

	public String getLastName() {
		return(lastName);
	}

	public String getExtension() {
		return(extension);
	}

	public String getDob() {
		return(dob);
	}
//METHODS
	public String toString() {
		return("<product><userid>"+getUserId()+"</userid><username>"+getUsername()+"</username><email>"+getEmail()+"</email><password>"+getPassword()+"</password><firstname>"+getFirstName()+"</firstname><lastname>"+getLastName()+"</lastname><extension>"+getExtension()+"</extension><dateofbirth>"+getDob()+"</dateofbirth></product>");
	}
}
