package Action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class ServletAction extends ActionSupport{

	HttpServletRequest request;
	HttpSession session;
	ServletContext application;
	@Override
	public String execute() throws Exception {
		request = ServletActionContext.getRequest();
		session = request.getSession();
		application = ServletActionContext.getServletContext();
		request.setAttribute("name", "小丽4");
		session.setAttribute("username","小龙4" );
		application.setAttribute("user", "说的4");
		return LOGIN;
	} 
}
