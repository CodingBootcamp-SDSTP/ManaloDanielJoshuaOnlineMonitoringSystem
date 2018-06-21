import java.util.ArrayList;

public class EmployeeCollection
{
	private ArrayList<Employee> employees;

	public EmployeeCollection() {
		employees = new ArrayList<Employee>();
	}

	public void addEmployee(Employee employee) {
		employees.add(employee);
	}

	public void removeEmployee(Employee employee) {
		employees.remove(employee);
	}

	public ArrayList<Employee> getAllEmployees() {
		return(employees);
	}

	public Employee getEmployeeByIndex(int n) {
		return(employees.get(n));
	}

	public int getEmployeeCount() {
		return(employees.size());
	}

	public Employee getEmployeeById(String id) {
		Employee e = null;
		for(int i = 0; i < getEmployeeCount(); i++) {
			if(Integer.toString(getEmployeeByIndex(i).getEmployeeId()).equalsIgnoreCase(id)) {
				e = getEmployeeByIndex(i);
				break;
			}
		}
		return(e);
	}

	public ArrayList<Employee> search(String s) {
		Employee p = null;
		ArrayList<Employee> el = new ArrayList<Employee>();
		String str = s.toLowerCase();
		for(int i=0; i<getEmployeeCount(); i++) {
			p = getEmployeeByIndex(i);
			if(matches(p, str)) {
				el.add(p);
			}
		}
		return(el);
	}

	public boolean matches(Employee e, String st) {
		String empId = Integer.toString(e.getEmployeeId()).toLowerCase();
		String fName = e.getFirstName()!=null ? e.getFirstName().toLowerCase() : "";
		String lName = e.getLastName()!=null ? e.getLastName().toLowerCase() : "";
		String bcode = e.getBranchCode()!=null ? e.getBranchCode().toLowerCase() : "";
		String add1 = e.getAddress1()!=null ? e.getAddress1().toLowerCase() : "";
		String add2 = e.getAddress2()!=null ? e.getAddress2().toLowerCase() : "";
		String gender = e.getGender()!=null ? e.getGender().toLowerCase() : "";
		String sss = e.getSSS()!=null ? e.getSSS().toLowerCase() : "";
		String philHealth = e.getPhilHealth()!=null ? e.getPhilHealth().toLowerCase() : "";
		String jt  = e.getJobTitle()!=null ? e.getJobTitle().toLowerCase() : "";
		String details = e.getDetails()!=null ? e.getDetails().toLowerCase() : "";
		if(empId.contains(st) || fName.contains(st) || lName.contains(st) || bcode.contains(st) || add1.contains(st) || add2.contains(st) || sss.contains(st) || philHealth.contains(st) || jt.contains(st) || details.contains(st)) {
			return(true);
		}
		return(false);
	}
}
