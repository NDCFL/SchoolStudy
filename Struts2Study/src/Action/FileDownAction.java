package Action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class FileDownAction extends ActionSupport {
	private String inputpath;
	private String contenttype;
	private String filename;
	public InputStream getInputStream() {
		System.out.println(ServletActionContext.getServletContext().getResourceAsStream(
		inputpath));
		
		return ServletActionContext.getServletContext().getResourceAsStream(
				inputpath);
	}
	@Override
	public String execute() throws Exception {
		contenttype = "image/jpeg";
		System.out.println(filename+"========");
		inputpath = filename;
		filename = java.net.URLEncoder.encode("文件.jpg", "utf-8");
		return SUCCESS;
	}

	public String getContenttype() {
		return contenttype;
	}

	public void setContenttype(String contenttype) {
		this.contenttype = contenttype;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getInputpath() {
		return inputpath;
	}

	public void setInputpath(String inputpath) {
		this.inputpath = inputpath;
	}
}
