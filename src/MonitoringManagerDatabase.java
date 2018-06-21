import java.util.ArrayList;
import java.sql.*;
import java.math.BigDecimal;

public class MonitoringManagerDatabase
{
	private static MonitoringManagerDatabase _instance = null;
	private Connection conn;
	private GoodsCollection goods = null;
	private EmployeeCollection employees = null;
	private BranchCollection branches = null;
	private UserCollection users = null;

	public static MonitoringManagerDatabase instance() {
		if(_instance == null) {
			_instance = new MonitoringManagerDatabase();
			return(_instance);
		}
		return(_instance);
	}

	private MonitoringManagerDatabase() {
		goods = new GoodsCollection();
		employees = new EmployeeCollection();
		branches = new BranchCollection();
		users = new UserCollection();
		Statement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/monitoringdb?user=alpha&password=beta&serverTimezone=UTC&useSSL=false");
		}
		catch(Exception e) {}
		finally {
			try{ if(stmt!=null) stmt.close(); } catch(Exception e) {};
		}
		setAllGoods();
		setAllEmployees();
		setAllBranches();
		setAllUsers();
	}
//SET GOODS, SET BRANCH, SET EMPLOYEE
	public void setAllGoods() {
		ResultSet rs = null;
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM tbl_goods");
			while(rs.next()) {
				int gid = rs.getInt("goodsid");
				int qty = rs.getInt("quantity");
				String name = rs.getString("name");
				String cname = rs.getString("codename");
				String bcode = rs.getString("branchcode");
				String brand = rs.getString("brand");
				String batchc = rs.getString("batchcode");
				BigDecimal up = rs.getBigDecimal("unitprice");
				String type = rs.getString("type");
				String details = rs.getString("details");
				Goods g = new Goods(gid, qty, name, cname, bcode, brand, batchc, up, type, details);
				goods.addGoods(g);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try{ if(stmt!=null) stmt.close(); } catch(Exception e) {};
			try{ if(rs!=null) rs.close(); } catch(Exception e) {};
		}
	}

	public void setAllEmployees() {
		ResultSet rs = null;
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM tbl_employees");
			while(rs.next()) {
				int empid = rs.getInt("employeeid");
				String fn = rs.getString("firstname");
				String ln = rs.getString("lastname");
				String bcode = rs.getString("branchcode");
				String add1 = rs.getString("address1");
				String add2 = rs.getString("address2");
				String g = rs.getString("gender");
				String sss = rs.getString("sss");
				String ph = rs.getString("philhealth");
				String jt = rs.getString("jobtitle");
				String d = rs.getString("details");
				Employee e = new Employee(empid, fn, ln, bcode, add1, add2, g, sss, ph, jt, d);
				employees.addEmployee(e);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try{ if(stmt!=null) stmt.close(); } catch(Exception e) {};
			try{ if(rs!=null) rs.close(); } catch(Exception e) {};
		}
	}

	public void setAllBranches() {
		ResultSet rs = null;
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM tbl_branches");
			while(rs.next()) {
				String branchcode = rs.getString("branchcode");
				String city = rs.getString("city");
				String address = rs.getString("address");
				String postalcode = rs.getString("postalcode");
				String phonenum = rs.getString("phonenum");
				String username = rs.getString("username");
				String details = rs.getString("details");
				Branch b = new Branch(branchcode, city, address, postalcode, phonenum, username, details);
				branches.addBranch(b);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try{ if(stmt!=null) stmt.close(); } catch(Exception e) {};
			try{ if(rs!=null) rs.close(); } catch(Exception e) {};
		}
	}

	public void setAllUsers() {
		ResultSet rs = null;
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM tbl_users");
			while(rs.next()) {
				int userid = rs.getInt("userid");
				String username = rs.getString("username");
				String email = rs.getString("email");
				String password = rs.getString("password");
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				String extension = rs.getString("extension");
				String dob = rs.getString("dob");
				String gender = rs.getString("gender");
				User u = new User(userid, username, email, password, firstname, lastname, extension, dob, gender);
				users.addUser(u);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try{ if(stmt!=null) stmt.close(); } catch(Exception e) {};
			try{ if(rs!=null) rs.close(); } catch(Exception e) {};
		}
	}
//GET GOODS, GET BRANCHES, GET EMPLOYEES, GET USERS
	public String getGoods() {
		StringBuffer sb = new StringBuffer();
		for(Goods g : goods.getAllGoods()) {
			sb.append(g.toString());
		}
		return("<goods>"+sb.toString()+"</goods>");
	}

	public String getEmployees() {
		StringBuffer sb = new StringBuffer();
		for(Employee emp : employees.getAllEmployees()) {
			sb.append(emp.toString());
		}
		return("<employees>"+sb.toString()+"</employees>");
	}

	public String getBranches() {
		StringBuffer sb = new StringBuffer();
		for(Branch branch : branches.getAllBranches()) {
			sb.append(branch.toString());
		}
		return("<branches>"+sb.toString()+"</branches>");
	}

	public String getUsers() {
		StringBuffer sb = new StringBuffer();
		for(User user : users.getAllUsers()) {
			sb.append(user.toString());
		}
		return("<users>"+sb.toString()+"</users>");
	}
//ADDING DATA TO ArrayList & DB
	public boolean addGoods(Goods g) {
		if(addGoodsToDB(g)) {
			goods.addGoods(g);
			return(true);
		}
		return(false);
	}

	public boolean addGoodsToDB(Goods goo) {
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement("INSERT INTO tbl_goods ( goodsid, quantity, name, codename, branchcode, brand, batchcode, unitprice, type, details ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ? );");
			stmt.setInt(1, goo.getGoodsId());
			stmt.setInt(2, goo.getQuantity());
			stmt.setString(3, goo.getName());
			stmt.setString(4, goo.getCodeName());
			stmt.setString(5, goo.getBranchCode());
			stmt.setString(6, goo.getBrand());
			stmt.setString(7, goo.getBatchCode());
			stmt.setBigDecimal(8, goo.getUnitPrice());
			stmt.setString(9, goo.getType());
			stmt.setString(10, goo.getDetails());
			stmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
			return(false);
		}
		finally {
			try { if(stmt != null) stmt.close(); } catch (Exception e) {};
		}
		return(true);
	}

	public boolean addEmployee(Employee e) {
		if(addEmployeeToDB(e)) {
			employees.addEmployee(e);
			return(true);
		}
		return(false);
	}

	public boolean addEmployeeToDB(Employee emp) {
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement("INSERT INTO tbl_employees ( empid, fname, lname, address, assignedto, sss, philhealth, position, details ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? );");
			stmt.setInt(1, emp.getEmployeeId());
			stmt.setString(2, emp.getFirstName());
			stmt.setString(3, emp.getLastName());
			stmt.setString(4, emp.getBranchCode());
			stmt.setString(5, emp.getAddress1());
			stmt.setString(6, emp.getAddress2());
			stmt.setString(7, emp.getGender());
			stmt.setString(8, emp.getSSS());
			stmt.setString(9, emp.getPhilHealth());
			stmt.setString(10, emp.getJobTitle());
			stmt.setString(11, emp.getDetails());
			stmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
			return(false);
		}
		finally {
			try { if(stmt != null) stmt.close(); } catch (Exception e) {};
		}
		return(true);
	}

	public boolean addBranch(Branch branch) {
		if(addBranchToDB(branch)) {
			branches.addBranch(branch);
			return(true);
		}
		return(false);
	}

	public boolean addBranchToDB(Branch br) {
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement("INSERT INTO tbl_branches ( branchcode, city, address, postalcode, phonenum, username, details ) VALUES ( ?, ?, ?, ?, ?, ? );");
			stmt.setString(1, br.getBranchCode());
			stmt.setString(2, br.getCity());
			stmt.setString(3, br.getAddress());
			stmt.setString(4, br.getPostalCode());
			stmt.setString(5, br.getPhoneNum());
			stmt.setString(6, br.getUsername());
			stmt.setString(7, br.getDetails());
			stmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
			return(false);
		}
		finally {
			try { if(stmt != null) stmt.close(); } catch (Exception e) {};
		}
		return(true);
	}

//SEARCH DATA FROM ArrayList & DB
	public ArrayList<Goods> searchForGoods(String searchtxt) {
		ArrayList<Goods> sg = goods.search(searchtxt);
		return(sg);
	}

	public ArrayList<Employee> searchForEmployees(String searchtxt) {
		ArrayList<Employee> se = employees.search(searchtxt);
		return(se);
	}

	public ArrayList<Branch> searchForBranches(String searchtxt) {
		ArrayList<Branch> sb = branches.search(searchtxt);
		return(sb);
	}

	public ArrayList<User> searchForUsers(String searchtxt) {
		ArrayList<User> us = users.search(searchtxt);
		return(us);
	}
//DELETING DATA FROM ArrayList & DB
	public boolean deleteGoods(Goods g) {
		if(deleteGoodsFromDB(g)) {
			goods.removeGoods(g);
			return(true);
		}
		return(false);
	}

	public boolean deleteGoodsFromDB(Goods goods) {
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement("DELETE * FROM tbl_goods WHERE goodsid = ?;");
			stmt.setInt(1, goods.getGoodsId());
			stmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
			return(false);
		}
		finally {
			try { if(stmt != null) stmt.close(); } catch (Exception e) {};
		}
		return(true);
	}

	public boolean deleteEmployee(Employee e) {
		if(deleteEmployeeFromDB(e)) {
			employees.removeEmployee(e);
			return(true);
		}
		return(false);
	}

	public boolean deleteEmployeeFromDB(Employee employee) {
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement("DELETE * FROM tbl_employees WHERE empid = ?;");
			stmt.setInt(1, employee.getEmployeeId());
			stmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
			return(false);
		}
		finally {
			try { if(stmt != null) stmt.close(); } catch (Exception e) {};
		}
		return(true);
	}

	public boolean deleteBranch(Branch branch) {
		if(deleteBranchFromDB(branch)) {
			branches.removeBranch(branch);
			return(true);
		}
		return(false);
	}

	public boolean deleteBranchFromDB(Branch branch) {
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement("DELETE * tbl_branches WHERE branchcode = ?;");
			stmt.setString(1, branch.getBranchCode());
			stmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
			return(false);
		}
		finally {
			try { if(stmt != null) stmt.close(); } catch (Exception e) {};
		}
		return(true);
	}

//LOGIN
	public boolean doLogin(String un, String pw) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		boolean result = false;
		try {
			stmt = conn.prepareStatement("SELECT * FROM tbl_users WHERE username = ? AND password = ? ;");
			stmt.setString(1, un);
			stmt.setString(2, pw);
			rs = stmt.executeQuery();
			result = rs.next();
		}
		catch(Exception e) {
			e.printStackTrace();
			return(result);
		}
		finally {
			try { if(stmt != null) stmt.close(); } catch (Exception e) {};
		}
		return(result);
	}
}
