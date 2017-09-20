package T7;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Studentservlet extends HttpServlet {

	Studentsqlimp im = new Studentsqlimp();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		if (request.getParameter("order")!=null) {
			String order = request.getParameter("order");
			if(order.equals("list")){
				list(request, response);
				request.getRequestDispatcher("T7doc1/votemain.jsp").forward(request, response);
			}else if (order.equals("save")) {
				StudentBean bean = new StudentBean();
				bean.setStudentname(request.getParameterValues("studentname"));
				im.addcount(bean);
				List<StudentBean> list = im.list();
				request.setAttribute("list", list);
				request.getRequestDispatcher("T7doc1/student.jsp").forward(request, response);
			}else if (order.equals("add")) {
				im.addstudent(request.getParameter("studentname"));
				list(request, response);
				request.getRequestDispatcher("T7doc1/votemain.jsp").forward(request, response);
			}
		}
	}
	public void list(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		List<StudentBean> studentList = im.studentlist();
		request.setAttribute("studentList", studentList);
		
	}

}
