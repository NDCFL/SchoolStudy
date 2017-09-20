package TagDemo;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class FontTagDemo extends TagSupport{

	int size;
	String face;
	String color;
	@Override
	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		if(size==0){
			size=7;
		}
		if (face==null || face.equals("")) {
			face="华文行楷";
		}
		if (color==null || color.equals("")) {
			color="blue";
		}
		
		try {
			out.write("<div style='text-align:center'><font size='"+size+"' face='"+face+"' color='"+color+"'>");
		} catch (IOException e) {
			System.out.println("处理字体自定义标签开始出错！");
		}
		//还有方法体要处理，所以使用EVAL_BODY_INCLUDE
		return EVAL_BODY_INCLUDE;
	}
	@Override
	public int doEndTag() throws JspException {
		JspWriter out = pageContext.getOut();
		try {
			out.write("</font></div>");
		} catch (IOException e) {
			System.out.println("处理字体自定义标签结束出错！");
		}
		return EVAL_PAGE;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getFace() {
		return face;
	}
	public void setFace(String face) {
		this.face = face;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
}
