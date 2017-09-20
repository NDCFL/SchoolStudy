package Interceptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class Function extends MethodFilterInterceptor{


	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		String classname = invocation.getAction().getClass().getName();
		String method = invocation.getProxy().getMethod();
		System.out.println(classname+"中的"+method+"方法被拦截了");
		return Action.INPUT;
	}

}
