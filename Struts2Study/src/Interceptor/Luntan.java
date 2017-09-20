package Interceptor;

import Action.LuntanAction;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class Luntan implements Interceptor{

	public void destroy() {}
	public void init() {}
	public String intercept(ActionInvocation invocation) throws Exception {
		Object object = invocation.getAction();
		if (object instanceof LuntanAction) {
			LuntanAction action = (LuntanAction)object;
			action.setTitle(action.getTitle().replace("毒品", "****"));
			action.setContent(action.getContent().replace("毒品", "****"));
			return Action.SUCCESS;
		}else {
			invocation.invoke();
		}
		return Action.SUCCESS;
	}

}
