package Action;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import Vo.FileUpInfoVo;

import com.opensymphony.xwork2.ActionSupport;

public class FileUpAction extends ActionSupport{

	private FileUpInfoVo fileupinfo;
	private File file;
	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public FileUpInfoVo getFileupinfo() {
		return fileupinfo;
	}

	public void setFileupinfo(FileUpInfoVo fileupinfo) {
		this.fileupinfo = fileupinfo;
	}
	@Override
	public String execute() throws Exception {
		String filepath = ServletActionContext.getServletContext().getRealPath("/")+"upfile"; 
		File file = new File(filepath);
		if (!file.exists()) {
			file.mkdir();
		}
		fileupinfo.setFilepath(filepath);
		fileupinfo.setFilename(getFileName(fileupinfo.getDocFileName()));
		FileUtils.copyFile(fileupinfo.getDoc(), new File(fileupinfo.getFilepath(),fileupinfo.getFilename()));
		return SUCCESS;
	}
	private synchronized String getFileName(String filename) {
		int position = filename.lastIndexOf(".");
		String ext = filename.substring(position);
		return System.nanoTime() + ext;
	}
	
}
