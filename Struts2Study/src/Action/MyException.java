package Action;

import com.opensymphony.xwork2.ActionSupport;

public class MyException extends ActionSupport{

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String execute() throws Exception {
		System.out.println(name);
		System.out.println("================");
		return ERROR;
	}
}
