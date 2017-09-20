package ShowDemo;

import java.io.Serializable;

public class PageBean implements Serializable{

	private int pagesize;
	private int pagesum;
	private int startpage;
	private int barsum;
	private String handle;
	private int currentpage;
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public int getPagesum() {
		return pagesum;
	}
	public void setPagesum(int pagesum) {
		this.pagesum = pagesum;
	}
	public int getStartpage() {
		startpage = (currentpage-1)*pagesize;
		return startpage;
	}
	public void setStartpage(int startpage) {
		this.startpage = startpage;
	}
	public int getBarsum() {
		return barsum;
	}
	public void setBarsum(int barsum) {
		pagesum = (int)Math.ceil((float)barsum/(float)pagesize);
		this.barsum = barsum;
	}
	public String getHandle() {
		return handle;
	}
	public void setHandle(String handle) {
		if(handle.equals("firstpage")){
			currentpage=1;
		}else if (handle.equals("uppage")) {
			if(currentpage>1){
				currentpage--;
			}else {
				currentpage=1;
			}
		}else if(handle.equals("downpage")){
			if(currentpage<pagesum){
				currentpage++;
			}else {
				currentpage=pagesum;
			}
		}else if(handle.equals("lastpage")){
			currentpage=pagesum;
		}else {
			currentpage=1;
		}
		this.handle = handle;
	}
	public int getCurrentpage() {
		return currentpage;
	}
	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}
}
