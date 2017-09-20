package Action;

import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class RequestAPI extends ActionSupport implements RequestAware,SessionAware,ApplicationAware{

	Map request;
	Map session;
	Map application;
	public void setRequest(Map<String, Object> request) {
		this.request=request;
	}

	public void setSession(Map<String, Object> session) {
		this.session=session;
	}

	public void setApplication(Map<String, Object> application) {
		this.application=application;
	}
	@Override
	public String execute() throws Exception {
		request.put("name", "小丽");
		session.put("username","小龙" );
		application.put("user", "说的");
		return LOGIN;
	}

}
