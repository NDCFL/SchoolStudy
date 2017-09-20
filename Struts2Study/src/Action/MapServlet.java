package Action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class MapServlet extends ActionSupport{

	Map request;
	Map session;
	Map application;
	@Override
	public String execute() throws Exception {
		ActionContext context = ActionContext.getContext();
		request=(Map)context.get("request");
		session=context.getSession();
		application=context.getApplication();
		request.put("name", "小丽2");
		session.put("username","小龙2" );
		application.put("user", "说的2");
		return LOGIN;
	}
}
