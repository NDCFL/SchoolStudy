package Action;

import java.util.regex.Pattern;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{

	private String username;
	private  String password;
	private String address;
	private String[] hobit;
	public String[] getHobit() {
		return hobit;
	}
	public void setHobit(String[] hobit) {
		this.hobit = hobit;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
		System.out.println("用户名："+this.username);
		System.out.println("密码："+this.password);
		System.out.println("家庭住址:"+this.address);
		String hobit[] = this.hobit;
		for (int i = 0; i < hobit.length; i++) {
			System.out.println(hobit[i]+"=====");
		}
		return INPUT;
	}
	@Override
	public void validate() {
		if(username==null ||username.equals("")){
			addFieldError("username", "用户名不能为空");
			return;
		}
		if(username.length()<4){
			addFieldError("username", "用户名长度不能小于4位");
			return;
		}
		if(password==null ||password.equals("")){
			addFieldError("password", "密码不能为空");
			return;
		}
		if(password.length()<8){
			addFieldError("password", "密码长度不能小于8位");
			return;
		}
		if(!Pattern.matches("^[A-Za-z1-9]+$", password)){
			addFieldError("password", "密码可以由字母数字组成");
			return;
		}
		if(address==null ||address.equals("")){
			addFieldError("address", "地址不能为空");
			return;
		}
		if(hobit==null ||hobit.equals("")){
			addFieldError("hobit", "爱好不能为空");
			return;
		}
	}
	public String say(){
		System.out.println("你好");
		return LOGIN;
	}
}
