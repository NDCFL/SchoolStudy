package T2.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet{
	
	String username;
	String pass;
	String quepass;
	String sex;
	String age;
	String addres;
	String string="";
	String str="";
	@Override
	public void init() throws ServletException {
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		PrintWriter pw = resp.getWriter();
		username = req.getParameter("name");
		pass = req.getParameter("pass1");
		quepass = req.getParameter("pass2");
		sex = req.getParameter("sex");
		age = req.getParameter("age1");
		String hobit[] = req.getParameterValues("hobit"); 
		StringBuffer st = new StringBuffer();
		for (int i = 0; i < hobit.length; i++) {
			st.append(hobit[i]+"  ");
		}
		System.out.println(st.toString());
		string= req.getParameter("province")+","+req.getParameter("city")+","+req.getParameter("county");
		addres=string;
		pw.println("<html><head><title>用户注册结果</title></head><body><tablt><tr><td><h1>用户注册结果</h1>");
		pw.println("昵称："+username+"<br/>");
		pw.println("密码："+pass+"<br/>");
		pw.println("性别："+sex+"<br/>");
		pw.println("年龄："+age+"<br/>");
		pw.println("课程："+st.toString()+"<br/>");
		pw.println("地址："+addres+"<br/>");
		pw.println("</td></tr></table>");
		pw.println("</body></html>");
	}
	@Override
	public void destroy() {
	}
}
