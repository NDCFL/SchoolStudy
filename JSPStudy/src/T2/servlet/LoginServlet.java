package T2.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("<HEAD><TITLE>软件使用意见反馈</TITLE></HEAD>");
		out.println("<BODY><form action='./Yufa/login.jsp' method='post'>");
		out.print("<h1>软件使用意见反馈</h1><table border='1' align='center'>");
		out.print("<tr><td>姓名：</td><td><input type='text' name='username'></td></tr>");
		out.print("<tr><td>E_mail：</td><td><input type='text' name='email'></td></tr>");
		out.print("<tr><td>软件名称：</td><td><select name='mingcheng' style=width:155px><option value='QQ'>QQ</option><option value='暴风'>暴风</option><optionvalue='微信'>微信</option></select></td></tr>");
		out.print("<tr><td>电话：</td><td><input type='text' name='tel'></td></tr>");
		out.print("<tr><td>操作系统：</td><td><select name='xt' style=width:155px><option value='Win7'>Win7</option><option value='Win8'>Win8</option><optionvalue='Win10'>Win10</option></select></td></tr>");
		out.print("<tr><td>回馈时间：</td><td><input type='text' name='shijian' value='"+new Date().toLocaleString()+"'></td></tr>");
		out.print("<tr><td>回馈描述：</td><td><textarea name='imfo' cols='40' rows='5'></textarea></td></tr>");
		out.print("<tr><td colspan='2' align='center'><input type='submit' value='   确  认   ' name='tijiao'><input type='reset' value='   清  空   ' name='delete'></td></tr>");
		out.println("</form></table>");
		out.println("</BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getParameter("order").equals("add")){
			
			String userId = request.getParameter("userId");
			String courseId= request.getParameter("courseId");
			String evalLevel = request.getParameter("evalLevel");
			String evalContent = request.getParameter("pingjia ");
			System.out.println("asjfijasodfiji="+request.getParameter("pingjia "));
		}
	}

}
