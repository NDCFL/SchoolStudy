package Action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public class Quanxian extends ActionSupport implements Preparable{

	private String msg;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String init() throws Exception {
		msg="你正在执行init函数";
		return super.execute();
	}
	public String init1() throws Exception {
		msg="你正在执行init1函数";
		return super.execute();
	}
	public String init2() throws Exception {
		msg="你正在执行init2函数";
		return super.execute();
	}
	public String init3() throws Exception {
		msg="你正在执行init3函数";
		return super.execute();
	}
	public String init4() throws Exception {
		msg="你正在执行init4函数";
		return super.execute();
	}
	public void prepare() throws Exception {
		System.out.println("我是prepare方法");
		
	}
	
}
