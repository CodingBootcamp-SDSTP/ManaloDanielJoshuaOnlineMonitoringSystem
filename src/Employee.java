import java.math.BigDecimal;

public class Employee
{
	private int empid;
	private String fname;
	private String lname;
	private String address;
	private int assignedTo;
	private int sss;
	private int philhealth;
	private String position;
	private String details;

	public Employee(int empid, String fname, String lname, String address, int assignedTo, int sss, int philhealth, String position, String details) {
		this.empid = empid;
		this.fname = fname;
		this.lname = lname;
		this.address = address;
		this.assignedTo = assignedTo;
		this.sss = sss;
		this.philhealth = philhealth;
		this.position = position;
		this.details = details;
	}
//SETTER
	public void setEmpId(int id) {
		empid = id;
	}

	public void setFname(String fn) {
		fname = fn;
	}

	public void setLname(String ln) {
		lname = ln;
	}

	public void set(String a) {
		address = a;
	}

	public void setAssignedTo(int at) {
		assignedTo = at;
	}

	public void setSSS(int sss) {
		this.sss = sss;
	}

	public void setPhilHealth(int ph) {
		philhealth = ph;
	}

	public void setPosition(String p) {
		position = p;
	}

	public void setdetails(String d) {
		details = d;
	}
//GETTER
	public int getEmpId() {
		return(empid);
	}

	public String getFname() {
		return(fname);
	}

	public String getLname() {
		return(lname);
	}

	public String getAddress() {
		return(address);
	}

	public int getAssignedTo() {
		return(assignedTo);
	}

	public int getSSS() {
		return(sss);
	}

	public int getPhilHealth() {
		return(philhealth);
	}

	public String getPosition() {
		return(position);
	}

	public String getDetails() {
		return(details);
	}
//METHODS
	public String toString() {
		return("<employee><empid>"+getEmpId()+"</empid><fname>"+getFname()+"</fname><lname>"+getLname()+"</lname><address>"+getAddress()+"</address><assignedto>"+getAssignedTo()+"</assignedto><sss>"+getSSS()+"</sss><philhealth>"+getSSS()+"</philhealth><position>"+getPosition()+"</position><details>"+getDetails()+"</details></employee>");
	}
}
