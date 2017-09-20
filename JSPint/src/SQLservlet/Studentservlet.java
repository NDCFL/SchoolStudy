package SQLservlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import SQLBase.AesUtils;
import SQLBase.SQLSentenceimp;
import SQLBean.BankBean;
import SQLBean.Citybean;
import SQLBean.GreadBean;
import SQLBean.MoneyBean;
import SQLBean.PagingBean;
import SQLBean.PayRecordBean;
import SQLBean.Provincebean;
import SQLBean.StudentBean;
import SQLBean.TeacherBean;

public class Studentservlet extends HttpServlet {
	SQLSentenceimp sql = new SQLSentenceimp();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext application = getServletContext();
		HttpSession session = request.getSession(); 
		request.setCharacterEncoding("utf-8");
		if(request.getParameter("order")!=null){
			String order = request.getParameter("order");
			if(order.equals("list")){
			   	paginglist2(request, response);
				request.getRequestDispatcher("datainfo/jiaoyijilu.jsp").forward(request, response);
			}else if(order.equals("checklist")){
			   	paginglist(request, response);
				request.getRequestDispatcher("data/studenttoteacherselect.jsp").forward(request, response);
			}else if (order.equals("delete")) {
				sql.studentdel(Integer.parseInt(request.getParameter("studentid")));
				paginglist1(request, response);
				request.getRequestDispatcher("data/studentselect.jsp").forward(request, response);
			}else if (order.equals("add")) {
				String registerName = request.getParameter("registerName");
				String checkUser = request.getParameter("checkUser");
				String password = request.getParameter("password");
				password = AesUtils.encryptStr(password, AesUtils.SECRETKEY);
				StudentBean studentbean = new StudentBean();
				studentbean.setStudentname(checkUser);
				studentbean.setStudentmobile(registerName);
				studentbean.setStudentpassword(password);
				studentbean.setLeibie(1);
				studentbean.setProvinceid(1);
				studentbean.setCityid(1);
				studentbean.setStudentface("image/face.gif");
				sql.studentadd(studentbean);
				StudentBean bean = sql.findstudent(registerName);
				session.setAttribute("bean", bean);
				request.setAttribute("bean", bean);
				request.setAttribute("name", registerName);
				request.setAttribute("password", password);
				request.getRequestDispatcher("datainfo/zhucesess.jsp").forward(request, response);
			}else if (order.equals("updateinit")) {
				String provinceid = request.getParameter("provinceid");
				System.out.println(provinceid);
				String studentname = request.getParameter("studentname");
				String studentid = request.getParameter("studentid");
				String studentmobile = request.getParameter("studentmobile");
				String studentemail = request.getParameter("studentemail");
				String studenthomeaddress = request.getParameter("studenthomeaddress");
				String studentsex = request.getParameter("studentsex");
				List<Provincebean> provincelist = sql.provincelist();
				List<Citybean> citylist = null;
				if(provinceid!=null){
					citylist = sql.cityalllist(provinceid);
				}else if (provincelist.size()>0) {
					Provincebean p = new Provincebean();
					citylist = sql.cityalllist(p.getProvinceid()+"");
				}
				request.setAttribute("provincelist", provincelist);
				request.setAttribute("citylist", citylist);
				request.setAttribute("provinceid", provinceid);
				request.setAttribute("studentname", studentname);
				request.setAttribute("studentid", studentid);
				request.setAttribute("studentmobile", studentmobile);
				request.setAttribute("studentsex", studentsex);
				request.setAttribute("studentemail", studentemail);
				request.setAttribute("studenthomeaddress", studenthomeaddress);
				request.getRequestDispatcher("data/studentupdate.jsp").forward(request, response);
			}else if (order.equals("addsave")) {
				String studentname = request.getParameter("studentname");
				String studentpassword = request.getParameter("studentpassword");
				String password = AesUtils.encryptStr(studentpassword, AesUtils.SECRETKEY);
				String studentmobile = request.getParameter("studentmobile");
				String studentsex = request.getParameter("studentsex");
				String studentemail = request.getParameter("studentemail");
				int provinceid = Integer.parseInt(request.getParameter("provinceid"));
				int cityid = Integer.parseInt(request.getParameter("cityid"));
				String studenthomeaddress = request.getParameter("studenthomeaddress");
				StudentBean studentbean = new StudentBean();
				studentbean.setCityid(cityid);
				studentbean.setProvinceid(provinceid);
				studentbean.setStudentemail(studentemail);
				studentbean.setStudenthomeaddress(studenthomeaddress);
				studentbean.setStudentmobile(studentmobile);
				studentbean.setStudentname(studentname);
				studentbean.setStudentpassword(password);
				studentbean.setStudentsex(Integer.parseInt(studentsex));
				studentbean.setStudentface("images/logo.png");
				studentbean.setLeibie(1);
				sql.studentadd(studentbean);
				request.setAttribute("studentbean", studentbean);
				StudentBean bean = sql.findstudent(studentname);
				session.setAttribute("bean", bean);
				paginglist(request, response);
				request.getRequestDispatcher("systemvo/systemstudentmain.jsp").forward(request, response);
			}else if (order.equals("update")) {
				List<Provincebean> provincelist = sql.provincelist();
				request.setAttribute("provincelist", provincelist);
				StudentBean studentBean = (StudentBean)session.getAttribute("bean");
				StudentBean  studentbean = sql.findstudent(studentBean.getStudentname());
				request.setAttribute("studentbean", studentbean);
				List<Citybean> citylist = sql.citylist();
				request.setAttribute("citylist", citylist);
				request.getRequestDispatcher("data/studentupdate.jsp").forward(request, response);
			}else if (order.equals("updatesave")) {
				String studentid = request.getParameter("studentid");
				String studentname = request.getParameter("studentname");
				String studentmobile = request.getParameter("studentmobile");
				String studentsex = request.getParameter("studentsex");
				String studentemail = request.getParameter("studentemail");
				String province = request.getParameter("province");
				String city = request.getParameter("cityid");
				Provincebean provincename = sql.findprovincename(province);
				Citybean citybean = sql.findcity(city);
				String studenthomeaddress = provincename.getProvinceName()+citybean.getCityname();
				String studentregisterdate = new Date().toLocaleString();
				StudentBean studentbean1 = new StudentBean();
				studentbean1.setStudentid(Integer.parseInt(studentid));
				studentbean1.setCityid(Integer.parseInt(city));
				studentbean1.setProvinceid(Integer.parseInt(province));
				studentbean1.setStudentemail(studentemail);
				studentbean1.setStudenthomeaddress(studenthomeaddress);
				studentbean1.setStudentmobile(studentmobile);
				studentbean1.setStudentname(studentname);
				studentbean1.setStudentregisterdate(studentregisterdate);
				studentbean1.setStudentsex(Integer.parseInt(studentsex));
				sql.studentupdate(studentbean1);
				List<Provincebean> provincelist = sql.provincelist();
				request.setAttribute("provincelist", provincelist);
				StudentBean  studentbean = sql.findstudent(studentname);
				request.setAttribute("studentbean", studentbean);
				List<Citybean> citylist = sql.citylist();
				request.setAttribute("citylist", citylist);
				request.setAttribute("msg", "资料修改成功！");
				request.getRequestDispatcher("data/studentupdate.jsp").forward(request, response);
			}else if (order.equals("updatepassword")) {
				String studentname = new String(request.getParameter("studentname").getBytes("iso-8859-1"),"utf-8");
				String studentpassword = AesUtils.encryptStr(request.getParameter("oldpassword"), AesUtils.SECRETKEY);
				StudentBean studentbean = sql.findstudent(studentname);
				if (studentbean.getStudentpassword().equals(studentpassword)){
					//sql.checkpwd(studentname, studentpassword, "student","studentpassword","studentname");
					request.setAttribute("msg", "恭喜你！密码验证成功！");
					request.setAttribute("name",studentname );
					paginglist(request, response);
					request.getRequestDispatcher("data/updatestudentpwd.jsp").forward(request, response);
				}else {
					request.setAttribute("msg", "对不起！你输入的旧密码有误！请核对后再输！");
					paginglist(request, response);
					request.getRequestDispatcher("data/oldstudentpwd.jsp").forward(request, response);
				}
			}else if (order.equals("checkpassword")) {
				String studentname = request.getParameter("studentname");
				String studentpassword = AesUtils.encryptStr(request.getParameter("newpassword"), AesUtils.SECRETKEY);
				sql.checkpwd(studentname, studentpassword, "student","studentpassword","studentname");
				request.setAttribute("msg", "恭喜你！密码修改成功！");
				paginglist(request, response);
				request.getRequestDispatcher("systemvo/demo.jsp").forward(request, response);
			}else if (order.equals("toteacher")) {
				StudentBean  studentbean = sql.findstudent(new String(request.getParameter("studentname").getBytes("iso-8859-1"),"utf-8"));
				request.setAttribute("studentbean", studentbean);
				request.getRequestDispatcher("data/studenttoteacher.jsp").forward(request, response);
			}else if (order.equals("checkteacher")) {
				String studentname = new String(request.getParameter("studentname").getBytes("iso-8859-1"),"utf-8");
				sql.checkteacher(studentname,"2");
				request.setAttribute("msg", "你的教师申请已经提交");
				StudentBean  studentbean = sql.findstudent(new String(request.getParameter("studentname").getBytes("iso-8859-1"),"utf-8"));
				request.setAttribute("studentbean", studentbean);
				request.getRequestDispatcher("data/studenttoteacher.jsp").forward(request, response);
			}else if (order.equals("checkteachersave")) {
				String name = sql.findstudentname(request.getParameter("studentid"));
				int status = Integer.parseInt(request.getParameter("status"));
				if(status==1){
					sql.checkteacher(name,"0");
					sql.checkteacher(request.getParameter("teacherid"), request.getParameter("status"), request.getParameter("reason"));
				}else {
					sql.checkteacher(name,"1");
					sql.checkteacher(request.getParameter("teacherid"), request.getParameter("status"), request.getParameter("reason"));
				}
				paginglist(request, response);
				TeacherBean teacherbean = sql.findteacher(request.getParameter("teacherid"));
				request.setAttribute("teacherbean", teacherbean);
				request.getRequestDispatcher("data/studenttoteacherselect.jsp").forward(request, response);
			}else if (order.equals("summoney")) {
				String username = request.getParameter("username");
				StudentBean studentbean = sql.findstudent(new String(username.getBytes("iso-8859-1"),"utf-8"));
				MoneyBean moneybean = sql.money(studentbean.getStudentid()+"");
				request.setAttribute("moneybean", moneybean);
				request.setAttribute("userid", studentbean.getStudentid());
				request.getRequestDispatcher("data/yue.jsp").forward(request, response);
			}else if (order.equals("zhifupwd")) {
				String username = request.getParameter("username");
				StudentBean studentbean = sql.findstudent(new String(username.getBytes("iso-8859-1"),"utf-8"));
				String pwd = AesUtils.encryptStr(request.getParameter("pwd"), AesUtils.SECRETKEY);
				sql.updatezhifupwd(pwd, studentbean.getStudentid());
				request.getRequestDispatcher("systemvo/demo.jsp").forward(request, response);
			}else if (order.equals("teacher")) {
				List<BankBean> banklist = sql.banklist();
				request.setAttribute("banklist", banklist);
				List<GreadBean> greadlist = sql.greadlist();
				request.setAttribute("greadlist", greadlist);
				TeacherBean teacherbean = sql.findmyinfo(new String(request.getParameter("studentname").getBytes("iso-8859-1"),"utf-8"));
				if(teacherbean.getTeachername()!=null){
					request.setAttribute("teacherbean", teacherbean);
					request.getRequestDispatcher("data/teachertostudentupdate.jsp").forward(request, response);
				}else {
					request.getRequestDispatcher("data/teacheradd.jsp").forward(request, response);
				}
			}else if (order.equals("shenqing")) {
				String teachername = request.getParameter("teachername");
				sql.teacherdelete(teachername);
				List<BankBean> banklist = sql.banklist();
				request.setAttribute("banklist", banklist);
				List<GreadBean> greadlist = sql.greadlist();
				request.setAttribute("greadlist", greadlist);
				TeacherBean teacherbean = sql.findmyinfo(teachername);
				if(teacherbean.getTeachername()!=null){
					request.setAttribute("teacherbean", teacherbean);
					request.getRequestDispatcher("data/teachertostudentupdate.jsp").forward(request, response);
				}else {
					request.getRequestDispatcher("data/teacheradd.jsp").forward(request, response);
				}
			}else if (order.equals("teacheradd")) {
				String studentname = request.getParameter("teachername");
				sql.checkteacher(studentname,"2");
				StudentBean  studentbean = sql.findstudent(studentname);
				request.setAttribute("studentbean", studentbean);
				String teachername = request.getParameter("teachername");
				String teacheremail = request.getParameter("teacheremail");
				String teacherjianjie = request.getParameter("teacherjianjie");
				String teacheredution = request.getParameter("teacheredution");
				String teacherjiaolin = request.getParameter("teacherjiaolin");
				String teacherspecial = request.getParameter("teacherspecial");
				String teacherbanknumber = request.getParameter("teacherbanknumber");
				String teacheraddress =request.getParameter("teacheraddress");
				int greadid = Integer.parseInt(request.getParameter("greadid"));
				int bankid = Integer.parseInt(request.getParameter("bankid"));
				TeacherBean teacherbean1 = new TeacherBean();
				teacherbean1.setBankid(bankid);
				teacherbean1.setGradeid(greadid);
				teacherbean1.setTeacheraddress(teacheraddress);
				teacherbean1.setTeacherbanknumber(teacherbanknumber);
				teacherbean1.setTeachereducation(teacheredution);
				teacherbean1.setTeacheremail(teacheremail);
				teacherbean1.setTeacherjianjie(teacherjianjie);
				teacherbean1.setTeacherjiaolin(teacherjiaolin);
				teacherbean1.setTeachermobile(studentbean.getStudentmobile());
				teacherbean1.setTeachername(teachername);
				teacherbean1.setTeacherpassword(studentbean.getStudentpassword());
				teacherbean1.setTeacherpictureurl(studentbean.getStudentface());
				teacherbean1.setTeachersex(studentbean.getStudentsex());
				teacherbean1.setTeacherspecial(teacherspecial);
				teacherbean1.setTeacherbankname(teachername);
				teacherbean1.setStatus(0);
				teacherbean1.setReason("请求审核成教师。。");
				sql.teacheradd(teacherbean1);
				request.setAttribute("studentname", studentbean.getStudentname());
				TeacherBean teacherbean = sql.findmyinfo(teachername);
				request.setAttribute("teacherbean", teacherbean);
				
				request.getRequestDispatcher("data/teachertostudentupdate.jsp").forward(request, response);
			}else if (order.equals("shenhestudent")) {
				String studentname = new String(request.getParameter("studentname").getBytes("iso-8859-1"),"utf-8");
				StudentBean studentbean = sql.findstudent(studentname);
				request.setAttribute("studentbean", studentbean);
				TeacherBean teacherbean = sql.findstudenttoteacher(studentbean.getStudentmobile());
				request.setAttribute("teacherbean", teacherbean);
				List<GreadBean> greadlist = sql.greadlist();
				request.setAttribute("greadlist", greadlist);
				List<BankBean> banklist = sql.banklist();
				request.setAttribute("banklist", banklist);
				request.getRequestDispatcher("data/shenhe.jsp").forward(request, response);
			}else if(order.equals("studentlist")){
				paginglist1(request, response);
				request.getRequestDispatcher("data/studentselect.jsp").forward(request, response);
			}else if (order.equals("zhifucenter")) {
				StudentBean studentbean = (StudentBean)session.getAttribute("bean");
				request.setAttribute("studentbean", studentbean);
				MoneyBean moneybean = sql.money(studentbean.getStudentid()+"");
				request.setAttribute("moneybean", moneybean);
				paginglist2(request, response);
				request.getRequestDispatcher("datainfo/moneycenter.jsp").forward(request, response);
			}else if (order.equals("deletejilu")) {
				sql.payrecodedelete(request.getParameter("payrecodeid"));
				StudentBean studentbean = (StudentBean)session.getAttribute("bean");
				request.setAttribute("studentbean", studentbean);
				MoneyBean moneybean = sql.money(studentbean.getStudentid()+"");
				request.setAttribute("moneybean", moneybean);
				request.setAttribute("msg", "交易记录已删除！");
				paginglist2(request, response);
				request.getRequestDispatcher("datainfo/moneycenter.jsp").forward(request, response);
			}
		}
	}

	public void paginglist(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		//实例化javabean，取参数
		PagingBean page = new PagingBean();
		//总记录条数，计算总页数
		page.setPagebarsum(sql.barsum("select count(*) cont from student"));
		//当前页
		String currenpage = request.getParameter("currenpage");
		//操作
		String handle = request.getParameter("handle");
		if(currenpage==null || currenpage.equals("")){
			//当前页为第一页
			page.setCurrentpage(1);
		}else {
			page.setCurrentpage(Integer.parseInt(currenpage));
		}
		if(handle==null || handle.equals("")){
			//当前页的操作
			page.setHandle("firstpage");
		}else {
			page.setHandle(handle);
		}
		List<StudentBean> studentlist = sql.studentlist(page.getPagebarsize(), page.getStarlocal());
		request.setAttribute("studentlist", studentlist);
		request.setAttribute("pager", page);
	}
	public void paginglist1(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		//实例化javabean，取参数
		PagingBean page = new PagingBean();
		//总记录条数，计算总页数
		page.setPagebarsum(sql.pagebarsum("student"));
		//当前页
		String currenpage = request.getParameter("currenpage");
		//操作
		String handle = request.getParameter("handle");
		if(currenpage==null || currenpage.equals("")){
			//当前页为第一页
			page.setCurrentpage(1);
		}else {
			page.setCurrentpage(Integer.parseInt(currenpage));
		}
		if(handle==null || handle.equals("")){
			//当前页的操作
			page.setHandle("firstpage");
		}else {
			page.setHandle(handle);
		}
		List<StudentBean> studentlist = sql.studentlist(page.getPagebarsize(), page.getStarlocal());
		request.setAttribute("studentlist", studentlist);
		request.setAttribute("pager", page);
	}
	public void paginglist2(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 实例化javabean，取参数
		HttpSession session = request.getSession();
		StudentBean studentBean = (StudentBean)session.getAttribute("bean");
		PagingBean page = new PagingBean();
		page.setPagebarsize(10);
		page.setPagebarsize(5);
		// 总记录条数，计算总页数
		page.setPagebarsum(sql.shopcarbarsum(studentBean.getStudentname()));
		// 当前页
		String currenpage = request.getParameter("currenpage");
		// 操作
		String handle = request.getParameter("handle");
		if (currenpage == null || currenpage.equals("")) {
			// 当前页为第一页
			page.setCurrentpage(1);
		} else {
			page.setCurrentpage(Integer.parseInt(currenpage));
		}
		if (handle == null || handle.equals("")) {
			//当前页的操作
			page.setHandle("firstpage");
		} else {
			page.setHandle(handle);
		}
		List<PayRecordBean> shoplist = sql.payrecodelist(page.getPagebarsize(), page.getStarlocal(), "1", studentBean.getStudentid());
		request.setAttribute("shoplist", shoplist);
		request.setAttribute("pager", page);
	}

}
