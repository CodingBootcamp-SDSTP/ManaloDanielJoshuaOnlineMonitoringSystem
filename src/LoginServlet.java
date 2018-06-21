import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet
{
	MonitoringManagerDatabase mmd;

	public void init() throws ServletException{
		mmd = MonitoringManagerDatabase.instance();
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out = res.getWriter();
		res.setContentType("text/xml");
		String un = req.getParameter("username");
		String pw = req.getParameter("password");
		System.out.println("login to");
		out.println("login to");
		if(mmd.doLogin(un, pw)) {
			out.println("pasok");
			System.out.println("pumasok");
		}
		else {
			out.println("di pumasok");
			System.out.println("di pumasok");
		}
		out.close();
	}

	public void destroy() {
		mmd = null;
	}
}
