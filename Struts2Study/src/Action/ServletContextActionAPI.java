package Action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;

public class ServletContextActionAPI extends ActionSupport implements ServletContextAware,ServletRequestAware{

	HttpServletRequest request;
	ServletContext application;
	HttpSession session;
	public void setServletContext(ServletContext application) {
		this.application=application; 
		
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
		this.session=request.getSession();
		
	}
	@Override
	public String execute() throws Exception {
		request.setAttribute("name", "小丽1");
		session.setAttribute("username","小龙1" );
		application.setAttribute("user", "说的1");
		return LOGIN;
	}
}
