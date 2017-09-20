package T3.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Severlet1 extends HttpServlet {

	 public void init() throws ServletException{
	}
	 public void service(HttpServletRequest request,HttpServletResponse response)
	 throws ServletException,IOException{
		PrintWriter out = response.getWriter();
		out.println("hello!");
	}


}
