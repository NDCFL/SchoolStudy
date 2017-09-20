package TagDemo;

import java.io.Serializable;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

import SQLBean.Citybean;
import SQLBean.PagingBean;

public class PagingTagDemo extends BodyTagSupport implements Serializable{
	private PagingBean paging ;
	private List<Citybean> list ;
	private String urlString;
	public String getUrlString() {
		return urlString;
	}
	public void setUrlString(String urlString) {
		this.urlString = urlString;
	}
	@Override
	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}
	@Override
	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		try {
			out.write("<table align='center'><tr><td><a href='T10doc/cityadd.jsp'> 新 增</a></td></tr></table>");
			out.write("<table border='1' align='center' width='740'><tr height='40'><th align='center'>城市编号</th><th align='center'>省份名称</th><th align='center'>城市名称</th><th align='center'>操作</th></tr>");
			Citybean citybean = null;
			for(int i=0;i<list.size();i++){
				citybean=list.get(i);
				out.write("<tr height='40'><td align='center'>"+citybean.getCityid()+"</td><td align='center'>"+citybean.getPrivacename()+"</td><td align='center'>"+citybean.getCityname()+"</td>");
				out.write("<td align='center'>");
				out.write("<a href=''> 修 改 </a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
				out.write("<a href='' onclick='javascript:if(confirm('删除确认')){return true;}else{return false;}> 删 除 </a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>");
			}
			out.write("</table>");
			out.write("<br/><br/>");
			out.write("<div align='center' style='font-size:18px'>");
			out.write("<b>总记录数&nbsp;&nbsp;"+paging.getPagebarsum()+"</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
			out.write("<b>总 页 数&nbsp;&nbsp;"+paging.getSumpage()+"页</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
			out.write("<b>当前页数&nbsp;&nbsp;"+paging.getCurrentpage()+"页</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
			out.println("<a href='"+urlString+"cityservlet?order=list&currenpage=1&handle=firstpage'>首    页</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
			out.write("<a href='"+urlString+"cityservlet?order=list&currenpage="+paging.getCurrentpage()+"&handle=uppage'>上 一 页</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp");
			out.write("<a href='"+urlString+"cityservlet?order=list&currenpage="+paging.getCurrentpage()+"&handle=downpage'>下 一 页</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp");
			out.write("<a href='"+urlString+"cityservlet?order=list&currenpage="+paging.getCurrentpage()+"&handle=lastpage'>末    页</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp");
			out.write("</div>");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return SKIP_BODY;
	}
	public PagingBean getPaging() {
		return paging;
	}
	public void setPaging(PagingBean paging) {
		this.paging = paging;
	}
	public List<Citybean> getList() {
		return list;
	}
	public void setList(List<Citybean> list) {
		this.list = list;
	}
	
}
