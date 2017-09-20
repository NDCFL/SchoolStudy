package T3.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Shopdelservlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		HttpSession session = request.getSession();
		ArrayList<String> list = (ArrayList<String>)session.getAttribute("list");
    	String string[] = request.getParameterValues("z");
    	out.println("<h1>删除订单后的数据</h1>");
    	out.println("<table border='0' width='340'><tr><th align='center'>选择</th><th align='center'>商品名称</th><th align='center'>价格(元)</th></tr></table>");
		for (int i = 1; i <= list.size(); i++) {
			if(string[i]!=null && !string[i].equals("")){
				out.println("j="+string[i]);
			}
			out.println("i="+i);
		}
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}
