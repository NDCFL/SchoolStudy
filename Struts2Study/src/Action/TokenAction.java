package Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class TokenAction extends ActionSupport{

	private String username;
	private String password;
	public int index;
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		System.out.println("用户名："+username);
		System.out.println("密码："+password);
		System.out.println("索引："+index);
		//首次注册
		if(session.getAttribute("index")==null){
			session.setAttribute("index", index);
			System.out.println("进来了");
			return INPUT;
		}else{
			System.out.println("see"+session.getAttribute("index"));
			System.out.println("req"+request.getParameter("index"));
			if(session.getAttribute("index").toString().equals(request.getParameter("index").toString())){
				System.out.println("sadfkjkl");
				System.out.println("不允许重复登录");
				return SUCCESS;
			}
			session.setAttribute("index", index);
		}
		return INPUT;
	}
}
