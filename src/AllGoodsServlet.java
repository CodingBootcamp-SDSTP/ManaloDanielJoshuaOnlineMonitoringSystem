import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class AllGoodsServlet extends HttpServlet
{
	MonitoringManagerDatabase mmd;
	String goods;

	public void init() throws ServletException{
		mmd = MonitoringManagerDatabase.instance();
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out = res.getWriter();
		goods = mmd.getGoods();
		res.setContentType("text/xml");
		out.println(goods);
		out.close();
	}

	public void destroy() {
		mmd = null;
		goods = null;
	}
}
