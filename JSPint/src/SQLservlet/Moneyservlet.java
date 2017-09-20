package SQLservlet;

import java.io.IOException;
import java.util.List;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import SQLBase.SQLSentenceimp;
import SQLBean.MoneyBean;
import SQLBean.MoneyRecordBean;
import SQLBean.PagingBean;
import SQLBean.StudentBean;

public class Moneyservlet extends HttpServlet {

	SQLSentenceimp sql = new SQLSentenceimp();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		if(request.getParameter("order")!=null){
			String order = request.getParameter("order");
			if(order.equals("delete")){
			   	sql.moneydel(request.getParameter("recordid"));
			   	String name = request.getParameter("username");
			   	paginglist(request, response);
				request.getRequestDispatcher("data/moneyselect.jsp?username="+name).forward(request, response);
			}else if(order.equals("add")){
				StudentBean studentBean = (StudentBean)session.getAttribute("bean");
				String userid = studentBean.getStudentid()+"";
				String money = request.getParameter("money");
				MoneyBean bean = sql.money(userid);
				if(bean.getUserid()!=Integer.parseInt(userid)){
					sql.insertmoney(money+"",Integer.parseInt(userid),"23913B3D8C1251FB57ACBD565F07FDDC");
				}else {
					sql.updatemoney(money+"",Integer.parseInt(userid));
				}
				System.out.println(money);
				MoneyRecordBean moneybean1 = new MoneyRecordBean();
				moneybean1.setUserid(Integer.parseInt(userid));
				moneybean1.setPay_money(Float.parseFloat(money));
				sql.moneyadd(moneybean1);
				request.setAttribute("msg", "恭喜你充值成功！");
				MoneyBean moneybean = sql.money(userid);
				request.setAttribute("moneybean", moneybean);
				request.setAttribute("userid",moneybean.getUserid() );
				request.getRequestDispatcher("datainfo/main.jsp").forward(request, response);
			}else if(order.equals("list")){
				paginglist(request, response);
				request.getRequestDispatcher("data/moneyselect.jsp").forward(request, response);
			}else if (order.equals("teachermoney")) {
				
			}
		}
	}
		public void paginglist(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
			HttpSession session = request.getSession();
			//实例化javabean，取参数
			PagingBean page = new PagingBean();
			StudentBean studentBean =(StudentBean)session.getAttribute("bean");
			//总记录条数，计算总页数
			page.setPagebarsum(sql.listbarsum(studentBean.getStudentid()+""));
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
			List<MoneyRecordBean> moneylist = sql.moneylist(page.getPagebarsize(), page.getStarlocal(),studentBean.getStudentname());
			request.setAttribute("moneylist", moneylist);
			StudentBean student =  sql.findstudent(studentBean.getStudentname());
			request.setAttribute("userid", student.getStudentid());
			request.setAttribute("pager", page);
		}
}
