package T2.servlet;

import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecondServer extends HttpServlet{

	String name;
	String age;
	String sex;
	String hobit;
	@Override
	public void init(ServletConfig config) throws ServletException {
		name=config.getInitParameter("username");
		age=config.getInitParameter("age");
		sex=config.getInitParameter("sex");
		hobit=config.getInitParameter("hobit");
		System.out.println("昵称："+name+"\t年龄："+age+"\t性别："+sex+"\t爱好："+hobit);
	}
	public void doGet(HttpServletRequest hsq,HttpServletResponse hsr){
		try {
			hsr.setContentType("text/html;charset=utf-8");
			PrintWriter pr = hsr.getWriter();
			pr.println("<html><head><title>servlet程序</title></head><body bgColor='pink'><h1>hello!world!你好!</h1><hr/><h1>参数值为</h1><font face='华文行楷' size='7' color='blue'>昵称："+name+"&nbsp;&nbsp;&nbsp;&nbsp;年龄："+"age"+"&nbsp;&nbsp;&nbsp;&nbsp;性别："+sex+"&nbsp;&nbsp;&nbsp;&nbsp;爱好："+hobit+"</font></body></html>");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void doPost(){
		
		
	}
	public void destroy(){
		
		
	}
}
