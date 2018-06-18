import java.util.ArrayList;
import java.sql.*;
import java.math.BigDecimal;

public class MonitoringManagerDatabase
{
	private Connection conn;
	private static MonitoringManagerDatabase _instance = null;
	private static ArrayList<Goods> goods = null;
	private static ArrayList<Employee> employees = null;
	private static ArrayList<Branch> branches = null;

	public static MonitoringManagerDatabase instance() {
		if(_instance == null) {
			_instance = new MonitoringManagerDatabase();
			return(_instance);
		}
		return(_instance);
	}

	private MonitoringManagerDatabase() {
		Statement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/monitoringdb?user=alpha&password=beta&serverTimezone=UTC&useSSL=false");
		}
		catch(Exception e) {}
		finally {
			try{ if(stmt!=null) stmt.close(); } catch(Exception e) {};
		}
		setGoods();
		setEmployee();
		setBranch();
	}
//SET GOODS, SET BRANCH, SET EMPLOYEE
	public void setGoods() {
		goods = new ArrayList<Goods>();
		ResultSet rs = null;
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM tbl_goods");
			while(rs.next()) {
				int gid = rs.getInt("gid");
				int quantity = rs.getInt("quantity");
				String name = rs.getString("name");
				String brand = rs.getString("brand");
				String batchCode = rs.getString("batchcode");
				BigDecimal unitPrice = rs.getBigDecimal("unitprice");
				String type = rs.getString("type");
				String details = rs.getString("details");
				Goods g = new Goods(gid, quantity, name, brand, batchCode, unitPrice, type, details);
				goods.add(g);
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

	public void setEmployee() {
		employees = new ArrayList<Employee>();
		ResultSet rs = null;
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM tbl_employees");
			while(rs.next()) {
				int empid = rs.getInt("empid");
				String fname = rs.getString("fname");
				String lname = rs.getString("lname");
				String address = rs.getString("address");
				int assignedto = rs.getInt("assignedto");
				int sss = rs.getInt("sss");
				int philhealth = rs.getInt("philhealth");
				String position = rs.getString("position");
				String details = rs.getString("details");
				Employee e = new Employee(empid, fname, lname, address, assignedto, sss, philhealth, position, details);
				employees.add(e);
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

	public void setBranch() {
		branches = new ArrayList<Branch>();
		ResultSet rs = null;
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM tbl_branches");
			while(rs.next()) {
				int branchid = rs.getInt("branchid");
				String address = rs.getString("address");
				String owner = rs.getString("owner");
				String details = rs.getString("details");
				Branch b = new Branch(branchid, address, owner, details);
				branches.add(b);
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
//GET GOODS, GET BRANCHES, GET EMPLOYEES
	public String getAllGoods() {
		StringBuilder sb = new StringBuilder();
		for(Goods good : goods) {
			sb.append(good.toString());
		}
		return("<goods>"+sb.toString()+"</goods>");
	}

	public String getAllEmployees() {
		StringBuilder sb = new StringBuilder();
		for(Employee emp : employees) {
			sb.append(emp.toString());
		}
		return("<employees>"+sb.toString()+"</employees>");
	}

	public String getAllBranches() {
		StringBuilder sb = new StringBuilder();
		for(Branch branch : branches) {
			sb.append(branch.toString());
		}
		return("<branches>"+sb.toString()+"</branches>");
	}
}
