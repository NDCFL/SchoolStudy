package T2.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class subject extends HttpServlet{

	@Override
	public void init() throws ServletException {
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String id = req.getParameter("id");
		String time = req.getParameter("time");
		String name = req.getParameter("se");
		String xiangmu = req.getParameter("xiangmu");
		String sub = req.getParameter("sub");
		String ex = req.getParameter("ex");
		String shijian= req.getParameter("shijian");
		String imfo= req.getParameter("imfo");
		PrintWriter out = resp.getWriter();
		out.println("<html><head><title>反馈信息</title></head><body><tablt><tr><td><h1>反馈结果</h1>");
		out.println("姓名："+id+"<br/>");
		out.println("email："+time+"<br/>");
		out.println("软件名称："+name+"<br/>");
		out.println("电话："+xiangmu+"<br/>");
		out.println("操作系统："+ex+"<br/>");
		out.println("反馈时间："+shijian+"<br/>");
		out.println("反馈信息："+imfo+"<br/>");
		out.println("</td></tr></table>");
		out.println("</body></html>");
	}
	@Override
	public void destroy() {
		
	}
}
