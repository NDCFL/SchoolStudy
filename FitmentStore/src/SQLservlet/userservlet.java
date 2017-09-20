package SQLservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SQLBase.SQLSentenceimp;
import SQLBean.UserBean;

public class userservlet extends HttpServlet {

	SQLSentenceimp sql = new SQLSentenceimp();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String order = request.getParameter("order");
		if(order!=null || order.equals("")){
			if(order.equals("add")){
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				String mobilephone = request.getParameter("mobilephone");
				int num = sql.finduser(mobilephone);
				System.out.println(num);
				if(num>=1){
					request.setAttribute("msg", "该用户已存在,请重新注册");
					request.getRequestDispatcher("data/zhuce.jsp").forward(request, response);
					return;
				}else {
					UserBean user = new UserBean();
					user.setLeibie(0);
					user.setUsername(username);
					user.setUserpassword(password);
					user.setUserface("images/301067.jpg");
					user.setUsermobile(mobilephone);
					user.setUserhomeaddress("未填，请完善");
					user.setUseremail("暂无");
					user.setCityid(1);
					user.setProvinceid(1);
					sql.adduser(user);
					request.getRequestDispatcher("data/login.jsp").forward(request, response);
				}
				
			}
		}
	}
}
