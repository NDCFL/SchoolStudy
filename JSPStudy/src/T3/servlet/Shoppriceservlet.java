package T3.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.taglibs.standard.lang.jstl.test.StaticFunctionTests;

public class Shoppriceservlet extends HttpServlet {
	public static int n=0;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
    	ArrayList<String> list = new ArrayList<String>();
    	HttpSession session = request.getSession();
    	String str[] = request.getParameterValues("z");
    	double money=0.0;
    	if(session.getAttribute("list")!=null && session.getAttribute("money")!=null){
    		money = Double.parseDouble(session.getAttribute("money").toString());
    		list = (ArrayList<String>)session.getAttribute("list");
    	}
    	for(int i=0;i<str.length;i++){
    		switch(i){
    			case 0:
	    			list.add("<input type='checkbox' name='z' value='1' style='width:80px;'>《水浒传》 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;价格为：48元");
	    			money+=48;
	    			break;
    			case 1:
    				list.add("<input type='checkbox' name='z' value='2' style='width:80px;'>《三国演义》 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;价格为：50元");
    				money+=50;
    				break;
    			case 2:
    				list.add("<input type='checkbox' name='z' value='3' style='width:80px;'>《jsp参考大全》 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;价格为：35元");
    				money+=35;
    				break;
    			case 3:
    				list.add("<input type='checkbox' name='z' value='4' style='width:80px;'>《java使用手册》 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;价格为：40元");
    				money+=40;
    				break;
    		}
    	}
    	
    	Iterator<String> it = list.iterator();
    	out.println("<h1>我的购物车</h1>");
    	out.println("<form action='T12doc/del.jsp' method='post' name='form1'><table border='0' width='340'><tr><th align='center'>选择</th><th align='center'>商品名称</th><th align='center'>价格(元)</th></tr></table>");
		while (it.hasNext()) {
			out.println(it.next()+"<br/>");
		}
		session.setAttribute("list", list);
		session.setAttribute("money", money);
		out.println("<input type='submit' value=' 删 除 ' onclick(alert('asfgd'))></form>");
		out.println("你一共购买了："+list.size()+"件商品;共计费用："+money);
	}

}
