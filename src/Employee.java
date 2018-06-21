import java.math.BigDecimal;

public class Employee
{
	private final int EMPLOYEEID;
	private String firstName;
	private String lastName;
	private String branchCode;
	private String address1;
	private String address2;
	private String gender;
	private String sss;
	private String philHealth;
	private String jobTitle;
	private String details;

	public Employee(int employeeid, String firstName, String lastName, String branchCode, String address1, String address2, String gender, String sss, String philHealth, String jobTitle, String details) {
		EMPLOYEEID = employeeid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.branchCode = branchCode;
		this.address1 = address1;
		this.address2 = address2;
		this.gender = gender;
		this.sss = sss;
		this.philHealth = philHealth;
		this.jobTitle = jobTitle;
		this.details = details;
	}
//SETTER
	public void setFirstName(String fn) {
		firstName = fn;
	}

	public void setLastName(String ln) {
		lastName = ln;
	}

	public void setBranchCode(String bc) {
		branchCode = bc;
	}

	public void setAddress1(String a) {
		address1 = a;
	}

	public void setAddress2(String add) {
		address2 = add;
	}

	public void setGender(String g) {
		gender = g;
	}

	public void setSSS(String sss) {
		this.sss = sss;
	}

	public void setPhilHealth(String ph) {
		philHealth = ph;
	}

	public void setJobTitle(String jt) {
		jobTitle = jt;
	}

	public void setdetails(String d) {
		details = d;
	}
//GETTER
	public int getEmployeeId() {
		return(EMPLOYEEID);
	}

	public String getFirstName() {
		return(firstName);
	}

	public String getLastName() {
		return(lastName);
	}

	public String getBranchCode() {
		return(branchCode);
	}

	public String getAddress1() {
		return(address1);
	}

	public String getAddress2() {
		return(address2);
	}

	public String getGender() {
		return(gender);
	}

	public String getSSS() {
		return(sss);
	}

	public String getPhilHealth() {
		return(philHealth);
	}

	public String getJobTitle() {
		return(jobTitle);
	}

	public String getDetails() {
		return(details);
	}
//METHODS
	public String toString() {
		return("<employee><employeeid>"+getEmployeeId()+"</employeeid><firstname>"+getFirstName()+"</firstname><lastname>"+getLastName()+"</lastname><branchcode>"+getBranchCode()+"</branchcode><address1>"+getAddress1()+"</address1><address2>"+getAddress2()+"</address2><gender>"+getGender()+"</gender><sss>"+getSSS()+"</sss><philhealth>"+getPhilHealth()+"</philhealth><jobtitle>"+getJobTitle()+"</jobtitle><details>"+getDetails()+"</details></employee>");
	}
}
