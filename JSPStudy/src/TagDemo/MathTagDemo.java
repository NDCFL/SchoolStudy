package TagDemo;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class MathTagDemo extends BodyTagSupport{

	int count;
	@Override
	public int doStartTag() throws JspException {
		if(count>=0){
			JspWriter out = pageContext.getOut();
			try {
				out.println("<table border='0' align='center'>");
			} catch (IOException e1) {
				System.out.println("打印表格出错！");
			}
			for(int i=1;i<=count;i++){
				try {
					out.println("<tr><td>");
				} catch (IOException e1) {
					System.out.println("打印行出错！");
				}
				for(int j=1;j<=i;j++){
					try {
						out.println(j+"*"+i+"="+(i*j)+"&nbsp;&nbsp;&nbsp;&nbsp;");
					} catch (IOException e) {
						System.out.println("打印九九乘法表出错！");
					}
					
				}
				try {
					out.println("</td></tr>");
				} catch (IOException e1) {
					System.out.println("打印行出错！");
				}
				
			}
			
			return EVAL_BODY_INCLUDE;
		}else {
			return SKIP_BODY;
		}
	}
	@Override
	public int doEndTag() throws JspException {
		JspWriter out = pageContext.getOut();
		try {
			out.println("</table>");
		} catch (IOException e1) {
			System.out.println("打印表格结束出错！");
		}
		return EVAL_PAGE;
	}
	@Override
	public int doAfterBody() throws JspException {
		if(count<=9){
			++count;
			System.out.println("count="+count);
			return EVAL_BODY_AGAIN;
		}else {
			return SKIP_BODY;
		}
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
}
