package Interceptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;


public class Quanxian extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		String classname = invocation.getAction().getClass().getName();
		String method = invocation.getProxy().getMethod();
		if(classname.equals("Action.Quanxian") && method.equals("init") || method.equals("init1")){
			invocation.invoke();
		}else {
			return Action.ERROR;
		}
		return null;
	}
}
