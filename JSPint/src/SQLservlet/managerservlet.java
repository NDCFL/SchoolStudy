package SQLservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.commons.digester.rss.Image;

import SQLBase.AesUtils;
import SQLBase.SQLSentenceimp;
import SQLBean.Citybean;
import SQLBean.ManagerBean;
import SQLBean.PagingBean;
import SQLBean.Provincebean;

public class managerservlet extends HttpServlet {

	SQLSentenceimp sql = new SQLSentenceimp();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		if(request.getParameter("order")!=null){
			String order = request.getParameter("order");
			if(order.equals("delete")){
			   	sql.managerdel(request.getParameter("managerid"));
			   	paginglist(request, response);
				request.getRequestDispatcher("data/managerselect.jsp").forward(request, response);
			}else if(order.equals("manageradd")){
				ManagerBean bean = new ManagerBean();
				bean.setManager_account(request.getParameter("manager_account"));
				bean.setManager_name(request.getParameter("manager_name"));
				String password = request.getParameter("manager_password");
				password = AesUtils.encryptStr(password, AesUtils.SECRETKEY);
				bean.setManager_password(password);
				bean.setManager_sex(Integer.parseInt(request.getParameter("manager_sex")));
				bean.setManager_contact(request.getParameter("manager_contact"));
				bean.setManager_status(1);
				sql.manageradd(bean);
				paginglist(request, response);
				request.getRequestDispatcher("data/managerselect.jsp").forward(request, response);
			}else if(order.equals("list")){
				paginglist(request, response);
				request.getRequestDispatcher("data/managerselect.jsp").forward(request, response);
				
			}else if (order.equals("update")) {
				String managerid = request.getParameter("managerid");
				ManagerBean managerbean = sql.findmanger(managerid);
				request.setAttribute("managerbean", managerbean);
				request.getRequestDispatcher("data/manageralter.jsp").forward(request, response);
			}else if (order.equals("managerupdate")) {
				ManagerBean bean = new ManagerBean();
				bean.setManager_id(Integer.parseInt(request.getParameter("manager_id")));
				bean.setManager_account(request.getParameter("manager_account"));
				bean.setManager_name(request.getParameter("manager_name"));
				bean.setManager_sex(Integer.parseInt(request.getParameter("manager_sex")));
				bean.setManager_contact(request.getParameter("manager_contact"));
				sql.managerupdate(bean);
				paginglist(request, response);
				request.getRequestDispatcher("data/managerselect.jsp").forward(request, response);
			}else if (order.equals("updatestatus")) {
				sql.checkstatus(request.getParameter("managerid"), request.getParameter("status"));
				paginglist(request, response);
				request.getRequestDispatcher("data/managerselect.jsp").forward(request, response);
			}else if (order.equals("updatepassword")) {
				String managerid = request.getParameter("managerid");
				String managerpassword = AesUtils.encryptStr(request.getParameter("oldpassword"), AesUtils.SECRETKEY);
				ManagerBean managerbean = sql.findmanger(managerid);
				if (managerbean.getManager_password().equals(managerpassword)){
					sql.checkpwd(managerid, managerpassword,"manager","manager_password","manager_id");
					request.setAttribute("msg", "恭喜你！密码修改成功！");
					paginglist(request, response);
					request.getRequestDispatcher("data/managerselect.jsp").forward(request, response);
				}else {
					request.setAttribute("msg", "对不起！你输入的旧密码有误！请核对后再输！");
					paginglist(request, response);
					request.getRequestDispatcher("data/updatemanagerpwd.jsp").forward(request, response);
				}
			}else if (order.equals("initpassword")) {
				sql.checkpwd(request.getParameter("managerid"), AesUtils.encryptStr("666666", AesUtils.SECRETKEY),"manager","manager_password","manager_id");
				request.setAttribute("msg", "恭喜你！初始化密码成功！密码为：666666");
				paginglist(request, response);
				request.getRequestDispatcher("data/managerselect.jsp").forward(request, response);
			}else if (order.equals("money")) {
				String money = sql.pingtai();
				request.setAttribute("money", money);
				request.getRequestDispatcher("data/pingtai.jsp").forward(request, response);
			}
		}
	}
	public void paginglist(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		//实例化javabean，取参数
		PagingBean page = new PagingBean();
		//总记录条数，计算总页数
		page.setPagebarsum(sql.pagebarsum("manager"));
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
		List<ManagerBean> managerlist = sql.managerlist(page.getPagebarsize(),page.getStarlocal());
		request.setAttribute("managerlist", managerlist);
		request.setAttribute("pager", page);
	}
}
