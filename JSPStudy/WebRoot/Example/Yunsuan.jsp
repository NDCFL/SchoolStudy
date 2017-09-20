<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

   <form  method="post" action="./Example/Yunsuan.jsp" align="center">
	   <h1>各种运算结果</h1>
	   <input name="sum" type="radio" value="1">程序1：求1~N的Sum<br/>
	   <input name="sum" type="radio" value="2">程序2：求1~N的阶层<br/>
	   <input name="sum" type="radio" value="3">程序3：求1~N的素数<br/>
	   <input name="inp" type="text1"><input type="submit" value="确定">请输入相应的值
   </form>
   <% 
   		String s = request.getParameter("sum");
   		if(s==null)
		s="1";
   		int n = Integer.parseInt(s);
   		switch(n){
   			case 1:
   %>
   				<jsp:include page="sum.jsp"/>
   <%																																																																																																																																																																																																																																																																																						
   				break;
   			case 2:
   %>
   				<jsp:include page="sum1.jsp"/>
   <%	
   				break;
   			case 3:
   %>
   				<jsp:include page="sum2.jsp"/>
   <%	
   				break;
   		}
   %>

