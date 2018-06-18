import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class AllBranchesServlet extends HttpServlet
{
	MonitoringManagerDatabase mmd;
	String branches;

	public void init() throws ServletException{
		mmd = MonitoringManagerDatabase.instance();
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out = res.getWriter();
		branches = mmd.getAllBranches();
		res.setContentType("text/xml");
		out.println(branches);
		out.close();
	}

	public void destroy() {
		mmd = null;
		branches = null;
	}
}
