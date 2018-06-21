import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class AllEmployeesServlet extends HttpServlet
{
	MonitoringManagerDatabase mmd;
	String employees;

	public void init() throws ServletException{
		mmd = MonitoringManagerDatabase.instance();
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out = res.getWriter();
		employees = mmd.getEmployees();
		res.setContentType("text/xml");
		out.println(employees);
		out.close();
	}

	public void destroy() {
		mmd = null;
	}
}
