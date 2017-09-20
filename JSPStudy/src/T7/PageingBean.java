package T7;

import java.io.Serializable;

public class PageingBean implements Serializable{

	//总页数
	private int sumpage;
	//总记录条数
	private int sumbar;
	//当前页
	private int currentpage;
	//页大小数
	private int pagesize;
	//操作
	private String handle;
	//起始位置
	private int startpage;
	public int getSumpage() {
		return sumpage;
	}
	public void setSumpage(int sumpage) {
		this.sumpage = sumpage;
	}
	public int getSumbar() {
		return sumbar;
	}
	public void setSumbar(int sumbar) {
		sumpage = (int)Math.ceil((float)sumbar/(float)pagesize);
		this.sumbar = sumbar;
	}
	public int getCurrentpage() {
		return currentpage;
	}
	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public String getHandle() {
		return handle;
	}
	public void setHandle(String handle) {
		if(handle.equals("firstpage")){
			currentpage = 1;
		}else if (handle.equals("uppage")) {
			if(currentpage>1){
				currentpage--;
			}else {
				currentpage=1;
			}
		}else if (handle.equals("downpage")) {
			if(currentpage<sumpage){
				currentpage++;
			}else {
				currentpage=sumpage;
			}
		}else if (handle.equals("lastpage")) {
			currentpage = sumpage;
		}else {
			currentpage=1;
		}
		this.handle = handle;
	}
	public int getStartpage() {
		startpage = (currentpage-1)*pagesize;
		return startpage;
	}
	public void setStartpage(int startpage) {
		this.startpage = startpage;
	}
	
}
