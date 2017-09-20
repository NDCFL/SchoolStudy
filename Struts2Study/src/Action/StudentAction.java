package Action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import SQLSentences.SqlSentenceimp;
import Vo.ClassVo;
import Vo.NationVo;
import Vo.PagingBean;
import Vo.StudentVo;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;

public class StudentAction extends ActionSupport {

	SqlSentenceimp sql = new SqlSentenceimp();
	private String order;
	private StudentVo stud;
	private List<ClassVo> classlist;
	private List<NationVo> nationlist;
	private List<StudentVo> studentList;
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpServletResponse response = ServletActionContext.getResponse();
	public List<StudentVo> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<StudentVo> studentList) {
		this.studentList = studentList;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public List<ClassVo> getClasslist() {
		return classlist;
	}

	public void setClasslist(List<ClassVo> classlist) {
		this.classlist = classlist;
	}

	public List<NationVo> getNationlist() {
		return nationlist;
	}

	public void setNationlist(List<NationVo> nationlist) {
		this.nationlist = nationlist;
	}

	public StudentVo getStud() {
		return stud;
	}

	public void setStud(StudentVo stud) {
		this.stud = stud;
	}
	@Override
	public String execute() throws Exception {
		init();
		if (order==null || order.equals("list") || order.equals("")) {
			init();
			paginglist();
		}else if (order.equals("delete")) {
			sql.delstudent(request.getParameter("sno"));
		}else if (order.equals("update")) {
			stud = sql.findstudent(request.getParameter("sno"));
		}else if (order.equals("add")) {
			StudentVo st = sql.findstudent(stud.getSno()+"");
			//代表的是修改操作
			if(st.getSno()!=0){
				sql.updatestudent(stud);
				stud=null;
			}else {
				sql.addstud(stud);
				stud=null;
			}
		}
		paginglist();
		return LOGIN;
	}
	public void init() {
		nationlist = new ArrayList<NationVo>();
		nationlist = sql.nationlist();
		classlist = new ArrayList<ClassVo>();
		classlist = sql.classlist();

	}
	public void list(){
		this.studentList=sql.studentlist();
	}
	public void paginglist() throws IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//实例化javabean，取参数
		PagingBean page = new PagingBean();
		//总记录条数，计算总页数
		page.setPagebarsum(sql.sum("select count(*) from stud"));
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
		request.setAttribute("pager", page);
		studentList = sql.studentlist(page.getPagebarsize(), page.getStarlocal());
		String  data = JSON.toJSONString(studentList);
		out.print(data);
	}

}
