package TagDemo;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;
public class LoginTagDemo extends BodyTagSupport{
	@Override
	public int doEndTag() throws JspException {
		JspWriter out = pageContext.getOut();
		try {
			out.write("<form name='form1' action='T10doc/checklogin.jsp' method='post'><table align='center'><tr height='40'><td>");
			out.write("昵称:<input type='text' name='username'></td></tr>");
			out.write("<tr height='40'><td>密码:<input type='text' name='userpassword'></td></tr>");
			out.write("<tr height='40'><td align='center'><input type='submit' value=' 登 录 '></td></tr>");
		} catch (Exception e) {
			System.out.println("登录Tag出错！");
		}
		return EVAL_BODY_INCLUDE;
	}
	@Override
	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		try {
			out.write("</table></form>");
		} catch (Exception e) {
			System.out.println("登录Tag出错！");
		}
		return EVAL_PAGE;
		
	}
}
