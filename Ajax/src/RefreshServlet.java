import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RefreshServlet extends HttpServlet {
	HashMap<String, String> map = new HashMap<String, String>();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		map.put("1", "<member>张三</member><member>李四</member>");
		map.put("2", "<member>王五</member><member>小丽</member>");
		map.put("3", "<member>老王</member><member>小小</member>");
		map.put("4", "<member>李小龙</member><member>张三丰</member><member>江小白</member>");
		int depid=1;
		//定义application变量
		ServletContext application = getServletContext();
		if(application.getAttribute("depid")==null){
			application.setAttribute("depid","1");
		}
		depid = Integer.parseInt(application.getAttribute("depid").toString());
		
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version='1.0' encoding='utf-8' ?>");
		sb.append("<members>");
		sb.append(map.get(depid+""));
		sb.append("</members>");
		depid++;
		if(depid>4)
			depid=1;
		application.setAttribute("depid",depid);
		response.setContentType("text/xml;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(sb);
		out.flush();
		out.close();
	}

}
