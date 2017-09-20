package Action;

import com.opensymphony.xwork2.ActionSupport;

public class SecondRenameAction extends ActionSupport{

	private String rename;
	public String getRename() {
		return rename;
	}
	public void setRename(String rename) {
		this.rename = rename;
	}
	@Override
	public String execute() throws Exception {
		System.out.println("别名名称:"+rename);
		return ERROR;
	}
}
