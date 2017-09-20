package Action;

import com.opensymphony.xwork2.ActionSupport;

public class LuntanAction extends ActionSupport{

	private String title;
	private String content;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String execute() throws Exception {
		System.out.println("已经过滤了非法的");
		return SUCCESS;
	}
}
