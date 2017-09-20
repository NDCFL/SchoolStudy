package SQLservlet;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import SQLBase.AesUtils;
import SQLBase.SQLSentenceimp;
import SQLBean.CourseBean;
import SQLBean.JifenBean;
import SQLBean.ManagerBean;
import SQLBean.MoneyBean;
import SQLBean.StudentBean;
import SQLBean.TeacherBean;
import SQLBean.TeacherMoneyBean;

public class Loginservlet extends HttpServlet {

	SQLSentenceimp sql = new SQLSentenceimp();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void tiaozhuan(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<CourseBean> courselist = sql.courselist();
		request.setAttribute("courselist", courselist);
		List<TeacherBean> teacherlist = sql.teacherlist();
		request.setAttribute("teacherlist", teacherlist);
		request.getRequestDispatcher("yunduo/main.jsp").forward(request,
				response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String order = request.getParameter("order");
		if(order.equals("student")){
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			password = AesUtils.encryptStr(password, AesUtils.SECRETKEY);
			StudentBean studentbean = sql.checkstudentlogin(name);
			// 验证码
			String code = request.getParameter("code").trim();
			String rand = session.getAttribute("rand").toString();
			// 判断验证码是否一致
			if (studentbean.getStudentmobile()==null || studentbean.getStudentmobile().equals("")){
				request.setAttribute("msg", "账户不存在！请先注册！");
				tiaozhuan(request,response);
				return; 
			}else{
				if(name.equals(studentbean.getStudentmobile()) && password.equals(studentbean.getStudentpassword())){
					if(!code.toUpperCase().equals(rand.toUpperCase())){
						request.setAttribute("msg", "验证码错误，请重新输入");
						tiaozhuan(request,response);
					}else {
						if(studentbean.getLeibie()==0){
							StudentBean bean = sql.findstudent(studentbean.getStudentname());
							sql.updateteachername(bean.getStudentid()+"", bean.getStudentname());
							TeacherBean teacherBean2 = sql.findmyinfo(bean.getStudentname());
							session.setAttribute("teacherBean2", teacherBean2);
							session.setAttribute("bean", bean);
							session.setAttribute("teacherbean", teacherBean2);
							request.getRequestDispatcher("systemvo/systemteachermain.jsp").forward(request, response);
						}else if (studentbean.getLeibie()!=0) {
							request.setAttribute("studentbean", studentbean);
							StudentBean bean = sql.findstudent(studentbean.getStudentname());
							session.setAttribute("bean", bean);
							request.getRequestDispatcher("systemvo/systemstudentmain.jsp").forward(request, response);
						}
					}
				}else {
					request.setAttribute("msg", "密码错误！");
					tiaozhuan(request,response);
					return;
				}
			}
			
		}else if(order.equals("teacher")){
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			password = AesUtils.encryptStr(password, AesUtils.SECRETKEY);
			TeacherBean teacherbean = sql.checkteacherlogin(name);
			// 验证码
			String code = request.getParameter("code").trim();
			String rand = session.getAttribute("rand").toString();
			// 判断验证码是否一致
			if(teacherbean.getTeachermobile()==null || teacherbean.getTeachermobile().equals("")) {
				request.setAttribute("msg", "账户不存在！请先注册！");
				request.getRequestDispatcher("systemvo/teacherlogin.jsp").forward(request, response);
				return;
				
			}else{
				if(name.equals(teacherbean.getTeachermobile()) && password.equals(teacherbean.getTeacherpassword())){
					if(!code.toUpperCase().equals(rand.toUpperCase())){
						request.setAttribute("msg", "验证码错误，请重新输入");
						request.getRequestDispatcher("systemvo/teacherlogin.jsp").forward(request, response);
					}else {
						TeacherBean teacherBean2 = sql.findmyinfo(teacherbean.getTeachername());
						session.setAttribute("teacherBean2", teacherBean2);
						session.setAttribute("teacherbean", teacherbean);
						request.getRequestDispatcher("systemvo/systemteachermain.jsp").forward(request, response);
					}
				}else {
					request.setAttribute("msg", "密码错误！");
					request.getRequestDispatcher("systemvo/teacherlogin.jsp").forward(request, response);
					return;
				}
				
			}
			
		}else if(order.equals("manager")){
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			password = AesUtils.encryptStr(password, AesUtils.SECRETKEY);
			ManagerBean managerbean = sql.checkmanagerlogin(name);
			// 验证码
			String code = request.getParameter("code").trim();
			String rand = session.getAttribute("rand").toString();
			// 判断验证码是否一致
			if(managerbean.getManager_account()==null || managerbean.getManager_account().equals("")) {
				request.setAttribute("msg", "账户不存在！请先注册！");
				request.getRequestDispatcher("manager/managerlogin.jsp").forward(request, response);
				return;
				
			}else{
				if(name.equals(managerbean.getManager_account()) && password.equals(managerbean.getManager_password())){
					if(!code.toUpperCase().equals(rand.toUpperCase())){
						request.setAttribute("msg", "验证码错误，请重新输入");
						request.getRequestDispatcher("manager/managerlogin.jsp").forward(request, response);
					}else {
						ManagerBean managerbean1 = sql.findmanager(managerbean.getManager_name());
						session.setAttribute("managerbean1", managerbean1);
						session.setAttribute("managerbean", managerbean);
						request.getRequestDispatcher("systemvo/systemmanagermain.jsp").forward(request, response);
					}
				}else {
					request.setAttribute("msg", "密码错误！");
					request.getRequestDispatcher("manager/managerlogin.jsp").forward(request, response);
					return;
				}
				
			}
			
		}else if(order.equals("studentlogin")){
			String name = request.getParameter("name");
			String login = request.getParameter("login");
			System.out.println("login=="+login);
			if(login==null || login.equals("")){
				login="0";
			}
			String password = request.getParameter("password");
			password = AesUtils.encryptStr(password, AesUtils.SECRETKEY);
			StudentBean studentbean = sql.checkstudentlogin(name);
			if (studentbean.getStudentmobile()==null || studentbean.getStudentmobile().equals("")){
				request.setAttribute("msg", "账户不存在！请先注册！");
				request.getRequestDispatcher("datainfo/login.jsp").forward(request, response);
				return; 
			}else{
				if(name.equals(studentbean.getStudentmobile()) && password.equals(studentbean.getStudentpassword())){
					if(studentbean.getLeibie()==0){
						if(login.equals("1")){
							setCookie(request, response, name, password);
						}
						StudentBean bean = sql.findstudent(studentbean.getStudentname());
						sql.updateteachername(bean.getStudentid()+"", bean.getStudentname());
						TeacherBean teacherBean2 = sql.findmyinfo(bean.getStudentname());
						session.setAttribute("teacherBean2", teacherBean2);
						session.setAttribute("bean", bean);
						session.setAttribute("teacherbean", teacherBean2);
						TeacherMoneyBean teacherMoneyBean = sql.teacherbeanlist(teacherBean2.getTeacherid()+"");
						request.setAttribute("teacherMoneyBean", teacherMoneyBean);
						JifenBean jifenBean = sql.jifenlist(teacherBean2.getTeacherid()+"");
						request.setAttribute("jifenBean", jifenBean);
						StudentBean studentBean2  = sql.findstudent(teacherBean2.getTeachername());
						request.setAttribute("studentbean", studentBean2);
						int num = sql.barsum("select count(*) cnt from shoppingcar where studentname='"+studentBean2.getStudentname()+"'");
						request.setAttribute("num", num);
						request.getRequestDispatcher("datainfo/mainteacher.jsp").forward(request, response);
					}else if (studentbean.getLeibie()!=0) {
						if(login.equals("1")){
							setCookie(request, response, name, password);
						}
						request.setAttribute("studentbean", studentbean);
						StudentBean bean = sql.findstudent(studentbean.getStudentname());
						session.setAttribute("bean", bean);
						request.setAttribute("studentBean", bean);
						request.setAttribute("face", bean.getStudentface());
						MoneyBean moneybean = sql.money(studentbean.getStudentid()+"");
						request.setAttribute("moneybean", moneybean);
						session.setAttribute("moneybean", moneybean);
						List<CourseBean> courselist = sql.courselist(6, 0);
						request.setAttribute("courselist", courselist);
						int num = sql.barsum("select count(*) cnt from shoppingcar where studentname='"+bean.getStudentname()+"'");
						request.setAttribute("num", num);
						List<CourseBean> courselistwithsection = sql.courlistwithsection(6, 0);
						request.setAttribute("courselistwithsection", courselistwithsection);
						CourseBean courseBean1 = sql.courlistandsection(1);
						request.setAttribute("courseBean1", courseBean1);
						CourseBean courseBean2 = sql.courlistandsection(6);
						request.setAttribute("courseBean2", courseBean2);
						CourseBean courseBean3 = sql.courlistandsection(3);
						request.setAttribute("courseBean3", courseBean3);
						CourseBean courseBean4 = sql.courlistandsection(4);
						request.setAttribute("courseBean4", courseBean4);
						CourseBean courseBean5 = sql.courlistandsection(5);
						request.setAttribute("courseBean5", courseBean5);
						request.getRequestDispatcher("datainfo/shouye.jsp").forward(request, response);
					}
				}else {
					request.setAttribute("msg", "密码错误！");
					request.getRequestDispatcher("datainfo/login.jsp").forward(request, response);
					return;
				}
			}
		}else if(order.equals("studentlogin1")){
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			StudentBean studentbean = sql.checkstudentlogin(name);
			if (studentbean.getStudentmobile()==null || studentbean.getStudentmobile().equals("")){
				request.setAttribute("msg", "账户不存在！请先注册！");
				request.getRequestDispatcher("datainfo/login.jsp").forward(request, response);
				return; 
			}else{
				if(name.equals(studentbean.getStudentmobile()) && password.equals(studentbean.getStudentpassword())){
					if(studentbean.getLeibie()==0){
						StudentBean bean = sql.findstudent(studentbean.getStudentname());
						sql.updateteachername(bean.getStudentid()+"", bean.getStudentname());
						TeacherBean teacherBean2 = sql.findmyinfo(bean.getStudentname());
						session.setAttribute("teacherBean2", teacherBean2);
						session.setAttribute("bean", bean);
						session.setAttribute("teacherbean", teacherBean2);
						TeacherMoneyBean teacherMoneyBean = sql.teacherbeanlist(teacherBean2.getTeacherid()+"");
						request.setAttribute("teacherMoneyBean", teacherMoneyBean);
						JifenBean jifenBean = sql.jifenlist(teacherBean2.getTeacherid()+"");
						request.setAttribute("jifenBean", jifenBean);
						request.getRequestDispatcher("datainfo/mainteacher.jsp").forward(request, response);
					}else if (studentbean.getLeibie()!=0) {
						request.setAttribute("studentbean", studentbean);
						StudentBean bean = sql.findstudent(studentbean.getStudentname());
						session.setAttribute("bean", bean);
						request.setAttribute("studentBean", bean);
						request.setAttribute("face", bean.getStudentface());
						MoneyBean moneybean = sql.money(studentbean.getStudentid()+"");
						request.setAttribute("moneybean", moneybean);
						session.setAttribute("moneybean", moneybean);
						List<CourseBean> courselist = sql.courselist(6, 0);
						request.setAttribute("courselist", courselist);
						int num = sql.barsum("select count(*) cnt from shoppingcar where studentname='"+bean.getStudentname()+"'");
						request.setAttribute("num", num);
						List<CourseBean> courselistwithsection = sql.courlistwithsection(6, 0);
						request.setAttribute("courselistwithsection", courselistwithsection);
						CourseBean courseBean1 = sql.courlistandsection(1);
						request.setAttribute("courseBean1", courseBean1);
						CourseBean courseBean2 = sql.courlistandsection(6);
						request.setAttribute("courseBean2", courseBean2);
						CourseBean courseBean3 = sql.courlistandsection(3);
						request.setAttribute("courseBean3", courseBean3);
						CourseBean courseBean4 = sql.courlistandsection(4);
						request.setAttribute("courseBean4", courseBean4);
						CourseBean courseBean5 = sql.courlistandsection(5);
						request.setAttribute("courseBean5", courseBean5);
						request.getRequestDispatcher("datainfo/shouye.jsp").forward(request, response);
					}
				}else {
					request.setAttribute("msg", "密码错误！");
					request.getRequestDispatcher("datainfo/login.jsp").forward(request, response);
					return;
				}
			}
		}else if (order.equals("exit")) {
			request.setAttribute("msg", "别走呀！再看看！我会想你的！");
			session.invalidate();
			Cookie cookie1 = new Cookie("studentmobile",URLEncoder.encode(""));
	    	Cookie cookie2 = new Cookie("studentpassword",URLEncoder.encode(""));
			cookie1.setMaxAge(0);
			cookie2.setMaxAge(0);
	    	response.addCookie(cookie1);
	    	response.addCookie(cookie2);
			request.getRequestDispatcher("datainfo/login.jsp").forward(request, response);
		}else if(order.equals("loginin")){
			String name = new String((request.getParameter("name")).getBytes("iso-8859-1"),"utf-8");
			StudentBean studentbean = sql.checkstudentlogin(name);
			if(studentbean.getLeibie()==0){
				StudentBean bean = sql.findstudent(studentbean.getStudentname());
				sql.updateteachername(bean.getStudentid()+"", bean.getStudentname());
				TeacherBean teacherBean2 = sql.findmyinfo(bean.getStudentname());
				session.setAttribute("teacherBean2", teacherBean2);
				session.setAttribute("bean", bean);
				session.setAttribute("teacherbean", teacherBean2);
				TeacherMoneyBean teacherMoneyBean = sql.teacherbeanlist(teacherBean2.getTeacherid()+"");
				request.setAttribute("teacherMoneyBean", teacherMoneyBean);
				JifenBean jifenBean = sql.jifenlist(teacherBean2.getTeacherid()+"");
				request.setAttribute("jifenBean", jifenBean);
				request.getRequestDispatcher("datainfo/mainteacher.jsp").forward(request, response);
			}else if (studentbean.getLeibie()!=0) {
				request.setAttribute("studentbean", studentbean);
				StudentBean bean = sql.findstudent(studentbean.getStudentname());
				session.setAttribute("bean", bean);
				request.setAttribute("face", bean.getStudentface());
				MoneyBean moneybean = sql.money(studentbean.getStudentid()+"");
				request.setAttribute("moneybean", moneybean);
				session.setAttribute("moneybean", moneybean);
				request.getRequestDispatcher("datainfo/main.jsp").forward(request, response);
			}
		}
	}

	private void setCookie(HttpServletRequest request, HttpServletResponse response, String studentmobile,String studentpassword){
		Cookie cookie1 = new Cookie("studentmobile",URLEncoder.encode(studentmobile));
    	Cookie cookie2 = new Cookie("studentpassword",URLEncoder.encode(studentpassword));
    	//设置一天的有效期,单位是秒
		cookie1.setMaxAge(10*24*60*60*30);
		//设置一天的有效期
		cookie2.setMaxAge(10*24*60*60*30);
    	//设置保存路径
    	response.addCookie(cookie1);
    	response.addCookie(cookie2);
	}
	
	
}
