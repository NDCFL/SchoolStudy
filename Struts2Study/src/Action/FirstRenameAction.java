package Action;

import com.opensymphony.xwork2.ActionSupport;


public class FirstRenameAction extends ActionSupport{
	
	private String srcname;
	public String getSrcname() {
		return srcname;
	}
	public void setSrcname(String srcname) {
		this.srcname = srcname;
	}
	@Override
	public String execute() throws Exception {
		System.out.println("别名原始名称:"+srcname);
		return SUCCESS;
	}

}
