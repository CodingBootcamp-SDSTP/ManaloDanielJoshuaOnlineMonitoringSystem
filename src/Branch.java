import java.math.BigDecimal;

public class Branch
{
	private int branchid;
	private String address;
	private String owner;
	private String details;

	public Branch(int branchid, String address, String owner, String details) {
		this.branchid = branchid;
		this.address = address;
		this.owner = owner;
		this.details = details;
	}
//SETTER
	public void setBranchId(int bi) {
		branchid = bi;
	}

	public void setAddress(String a) {
		address = a;
	}

	public void setOwner(String o) {
		owner = o;
	}

	public void setDetails(String d) {
		details = d;
	}
//GETTER
	public int getBranchId() {
		return(branchid);
	}

	public String getAddress() {
		return(address);
	}

	public String getOwner() {
		return(owner);
	}

	public String getDetails() {
		return(details);
	}
//METHODS
	public String toString() {
		return("<branch><branchid>"+getBranchId()+"</branchid><address>"+getAddress()+"</address><owner>"+getOwner()+"</owner><details>"+getDetails()+"</details></branch>");
	}
}
