import java.math.BigDecimal;

public class Branch
{
	private final String BRANCHCODE;
	private String city;
	private String address;
	private String postalCode;
	private String phoneNum;
	private String username;
	private String details;

	public Branch(String branchcode, String city, String address, String postalCode, String phoneNum, String username, String details) {
		BRANCHCODE = branchcode;
		this.city = city;
		this.address = address;
		this.postalCode = postalCode;
		this.phoneNum = phoneNum;
		this.username = username;
		this.details = details;
	}
//SETTER
	public void setCity(String c) {
		city = c;
	}

	public void setAddress(String a) {
		address = a;
	}

	public void setPostalCode(String pc) {
		postalCode = pc;
	}

	public void setPhoneNum(String pn) {
		phoneNum = pn;
	}

	public void setUsername(String u) {
		username = u;
	}

	public void setDetails(String d) {
		details = d;
	}
//GETTER
	public String getBranchCode() {
		return(BRANCHCODE);
	}

	public String getCity() {
		return(city);
	}

	public String getAddress() {
		return(address);
	}

	public String getPostalCode() {
		return(postalCode);
	}

	public String getPhoneNum() {
		return(phoneNum);
	}

	public String getUsername() {
		return(username);
	}

	public String getDetails() {
		return(details);
	}
//METHODS
	public String toString() {
		return("<branch><branchcode>"+getBranchCode()+"</branchcode><city>"+getCity()+"</city><address>"+getAddress()+"</address><postalcode>"+getPostalCode()+"</postalcode><phonenum>"+getPhoneNum()+"</phonenum><username>"+getUsername()+"</username><details>"+getDetails()+"</details></branch>");
	}
}
