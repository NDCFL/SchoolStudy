package SQLservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import SQLBase.SQLSentenceimp;
import SQLBean.UserBean;

public class loginservlet extends HttpServlet {

	SQLSentenceimp sql = new SQLSentenceimp();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String order = request.getParameter("order");
		if(order!=null || order.equals("")){
			if(order.equals("login")){
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				UserBean user = sql.logincheck(username);
				if(user.getUsername()==null){
					request.setAttribute("msg", "用户不存在，请先注册！");
					request.getRequestDispatcher("data/login.jsp").forward(request, response);
				}else {
					if(user.getUsermobile().equals(username) && user.getUserpassword().equals(password)){
						UserBean userbean = sql.logincheck(username);
						System.out.println(userbean.getUsername());
						session.setAttribute("user", userbean);
						request.getRequestDispatcher("data/handle.jsp").forward(request, response);
					}
					if(!user.getUsermobile().equals(username)){
						request.setAttribute("msg", "用户昵称错误！");
						request.getRequestDispatcher("data/login.jsp").forward(request, response);
					}
					if (!user.getUserpassword().equals(password)) {
						request.setAttribute("msg", "用户密码错误，请从新输入！");
						request.getRequestDispatcher("data/login.jsp").forward(request, response);
					}
				}
			}
		}
	}
}
