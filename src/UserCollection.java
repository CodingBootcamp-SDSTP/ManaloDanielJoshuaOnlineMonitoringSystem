import java.util.ArrayList;
import java.math.BigDecimal;

public class UserCollection
{
	private ArrayList<User> users;

	public UserCollection() {
		users = new ArrayList<User>();
	}

	public void addUser(User s) {
		users.add(s);
	}

	public void removeUser(User s) {
		users.remove(s);
	}

	public ArrayList<User> getAllUsers() {
		return(users);
	}

	public User getUserByIndex(int n) {
		return(users.get(n));
	}

	public int getUserCount() {
		return(users.size());
	}

	public User getUserById(String id) {
		User u = null;
		for(int i = 0; i < getUserCount(); i++) {
			if(Integer.toString(getUserByIndex(i).getUserId()).equalsIgnoreCase(id)) {
				u = getUserByIndex(i);
				break;
			}
		}
		return(u);
	}

	public ArrayList<User> search(String s) {
		User u = null;
		ArrayList<User> ul = new ArrayList<User>();
		String str = s.toLowerCase();
		for(int i=0; i<getUserCount(); i++) {
			u = getUserByIndex(i);
			if(matches(u, str)) {
				ul.add(u);
			}
		}
		return(ul);
	}

	public boolean matches(User us, String st) {
		String userid = Integer.toString(us.getUserId()).toLowerCase();
		String un = us.getUsername()!=null ? us.getUsername().toLowerCase() : "";
		String email = us.getEmail()!=null ? us.getEmail().toLowerCase() : "";
		String pw = us.getPassword()!=null ? us.getPassword().toLowerCase() : "";
		String fn = us.getFirstName()!=null ? us.getFirstName().toLowerCase() : "";
		String ln = us.getLastName()!=null ? us.getLastName().toLowerCase() : "";
		String ext = us.getExtension()!=null ? us.getExtension().toLowerCase() : "";
		String dob = us.getDob()!=null ? us.getDob().toLowerCase() : "";
		if(userid.contains(st) || un.contains(st) || email.contains(st) || pw.contains(st) || fn.contains(st) || ln.contains(st) || ext.contains(st) || dob.contains(st)){
			return(true);
		}
		return(false);
	}
}
