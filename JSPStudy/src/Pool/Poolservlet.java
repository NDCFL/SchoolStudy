package Pool;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Poolservlet extends HttpServlet {

	Teachersqlimp im = new Teachersqlimp();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		if(request.getParameter("order")!=null){
			String order = request.getParameter("order");
			if(order.equals("list")){
				list(request, response);
				request.getRequestDispatcher("T7doc/teacherlist.jsp").forward(request, response);
			}else if (order.equals("delete")) {
				im.teacherdel(request.getParameter("teacherid"));
				list(request, response);
				request.getRequestDispatcher("T7doc/teacherlist.jsp").forward(request, response);
			}else if (order.equals("teacheradd")) {
				TeacherBean bean = new TeacherBean();
				bean.setTeachergread(Float.valueOf(request.getParameter("teachergread")));
				bean.setTeachername(request.getParameter("teachername"));
				im.teacheradd(bean);
				list(request, response);
				request.getRequestDispatcher("T7doc/teacherlist.jsp").forward(request, response);
			}else if (order.equals("teacherupdate")) {
				TeacherBean bean = new TeacherBean();
				bean.setTeacherid(Integer.parseInt(request.getParameter("teacherid")));
				bean.setTeachergread(Float.valueOf(request.getParameter("teachergread")));
				bean.setTeachername(request.getParameter("teachername"));
				im.teacherupdate(bean);
				list(request, response);
				request.getRequestDispatcher("T7doc/teacherlist.jsp").forward(request, response);
			}else if (order.equals("update")) {
				TeacherBean teacherbean = im.bean(request.getParameter("teacherid"));
				request.setAttribute("teacherbean", teacherbean);
				list(request, response);
				request.getRequestDispatcher("T7doc/teacherupdate.jsp").forward(request, response);
			}
			
		}
			
	}

	public void list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<TeacherBean> teacherlist = im.list();
		request.setAttribute("teacherlist", teacherlist);
	}

}
