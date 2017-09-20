package struts.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.alibaba.fastjson.JSON;

import Bean.PagingBean;
import SQLSentences.SqlSentenceimp;
import struts.form.StudentForm;

public class StudentAction extends Action {
	
	SqlSentenceimp sql = new SqlSentenceimp();
 	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		StudentForm studentForm = (StudentForm) form;
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = null;
		String order = request.getParameter("order");
		try {
			out = response.getWriter();

		} catch (Exception e) {
			e.printStackTrace();
		}
		if(order.equals("add")){
			sql.addstud(studentForm);
			request.setAttribute("studentForm", studentForm);
			try {
				paginglist(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}else if (order.equals("list")) {
			try {
				paginglist(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}else if (order.equals("del")) {
			String sno = request.getParameter("sno");
			sql.delstudent(sno);
			try {
				paginglist(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		return null;
	}
 	public void paginglist(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		//实例化javabean，取参数
		PagingBean page = new PagingBean();
		//总记录条数，计算总页数
		page.setPagebarsum(sql.sum("select count(*) from stud"));
		//当前页
		String currenpage = request.getParameter("currentpage");
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
		List list = sql.studentlist(page.getPagebarsize(), page.getStarlocal());
		list.add(page);
		String data = JSON.toJSONString(list);
		out.println(data);
		System.out.println(data);
	}
}