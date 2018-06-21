import java.util.ArrayList;

public class BranchCollection
{
	private ArrayList<Branch> branches;

	public BranchCollection() {
		branches = new ArrayList<Branch>();
	}

	public void addBranch(Branch b) {
		branches.add(b);
	}

	public void removeBranch(Branch b) {
		branches.remove(b);
	}

	public ArrayList<Branch> getAllBranches() {
		return(branches);
	}

	public Branch getBranchByIndex(int n) {
		return(branches.get(n));
	}

	public int getBranchCount() {
		return(branches.size());
	}

	public Branch getBranchById(String id) {
		Branch b = null;
		for(int i = 0; i < getBranchCount(); i++) {
			if(getBranchByIndex(i).getBranchCode().equalsIgnoreCase(id)) {
				b = getBranchByIndex(i);
				break;
			}
		}
		return(b);
	}

	public ArrayList<Branch> search(String s) {
		Branch b = null;
		ArrayList<Branch> el = new ArrayList<Branch>();
		String str = s.toLowerCase();
		for(int i=0; i<getBranchCount(); i++) {
			b = getBranchByIndex(i);
			if(matches(b, str)) {
				el.add(b);
			}
		}
		return(el);
	}

	public boolean matches(Branch b, String st) {
		String bcode = b.getBranchCode()!=null ? b.getBranchCode().toLowerCase() : "";
 		String city = b.getCity()!=null ? b.getCity().toLowerCase() : "";
		String address = b.getAddress()!=null ? b.getAddress().toLowerCase() : "";
		String pcode = b.getPostalCode()!=null ? b.getPostalCode().toLowerCase() : "";
		String phoneNum = b.getPhoneNum()!=null ? b.getPhoneNum().toLowerCase() : "";
		String uname = b.getUsername()!=null ? b.getUsername().toLowerCase() : "";
		String details = b.getDetails()!=null ? b.getDetails().toLowerCase() : "";
		if(bcode.contains(st) || city.contains(st) || address.contains(st) || pcode.contains(st) || phoneNum.contains(st) || uname.contains(st) || details.contains(st)) {
			return(true);
		}
		return(false);
	}
}
