package T2.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FirstServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		doPost(request, response);
	}
	//提交post数据的处理函数
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
	        PrintWriter out = response.getWriter();
	        HttpSession session = request.getSession(true);
	        out.println("<br>客户端的SessionID: " +request.getRequestedSessionId());
	        out.println("<br>SessionID是否由Cookie提供: " +request.isRequestedSessionIdFromCookie());
	        out.println("<br>SessionID是否在请求URL中解码: " +request.isRequestedSessionIdFromURL());
	        out.println("<br>客户端返回的SessionID是否有效: " + request.isRequestedSessionIdValid());
	        out.println("<br>SessionID是否是新创建的:" + session.isNew());
	        out.println("<br>Session的默认存活期为：" + session.getMaxInactiveInterval() + "秒");
	        out.close();
	}
}
