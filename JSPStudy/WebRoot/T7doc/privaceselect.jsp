<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="SQLBean.Privacebean"%>
<%@page import="T7.PageingBean"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'privaceselect.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		function check(){
			if(form1.privacename.value==null){
				form1.privacename.value=="";
				form1.privacename.foucs();
			}
		} 
		function check1(){
			form1.privacename.value=="请输入省份名称";
			form1.privacename.foucs();
		}
	</script>
  </head>
  
  <body text="blue">
  <%
  	List<Privacebean> list = (List<Privacebean>)request.getAttribute("privacelist"); 
	Privacebean privacebean=null;
	List<Privacebean> citylist = (List<Privacebean>)request.getAttribute("cityalllist");
	Privacebean bean = null;
  %>
  <h1 align='center'><font color="blue">省份信息览表</font></h1>
  <form action="<%=basePath %>privaceservlet?order=selectallcity" method="post" name="form1">
	  <table align='center' border="0" width="500">
	  <tr height="20"><td width="100" align="center">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href='T7doc/privaceadd.jsp' align="center"> 新 增</a><td align="center" width="150"><a href="<%=basePath %>cityservlet?order=list">显示城市列表</a></td><td width="150">&nbsp;&nbsp;&nbsp;&nbsp;</td></tr>
		  <tr height="20">
		  <td align="center">
		 	 <input type="text" name="privacename" value="<%=request.getAttribute("privacename") %>" onblur="check()" onfocus="alert('请输入省份名称')">
		  </td>
		  <td>
		  	<select style="width:150px">
		  		<%
		  		for(int j=0;j<citylist.size();j++){
		  			bean = citylist.get(j);
		  			out.println("<option >"+bean.getPrivaceName()+"</option>");
		  		}
		  		%>
		  	</select>
		  </td>
		  <td>
		  	<input type="submit" value="查找所有城市">
		  </td>
	  		</tr>
	  </table>
  </form>
    <%
    PageingBean pagebe = (PageingBean)request.getAttribute("pagebe");
    out.println("<table border='1' align='center' width='500'>");
	out.println("<tr height='40'><th align='center'>省份编号</th><th align='center'>省份名称</th><th align='center'>操作</th></tr>");
	for(int i=0;i<list.size();i++){
		privacebean = list.get(i);
		out.println("<tr height='40'><td align='center'>"+privacebean.getPrivaceid()+"</td><td align='center'>"+privacebean.getPrivaceName()+"</td>");
%>
		<td align="center">
		<a href="T7doc/privacealter.jsp?id=<%=privacebean.getPrivaceid() %>&privacename=<%=privacebean.getPrivaceName()%>"> 修 改 </a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="<%=basePath %>privaceservlet?id=<%=privacebean.getPrivaceid() %>&order=del" onclick="javascript:if(confirm('删除确认')){return true;}else{return false;}"> 删 除 </a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		</td>
<%
		out.println("</tr>");
	}
	out.println("</table>");
    %>
    <div align="center" style="font-size:18px">
    	<b>总页数&nbsp;&nbsp;&nbsp;&nbsp;<%=pagebe.getSumpage() %>页</b>
    	<b>当前页数&nbsp;&nbsp;&nbsp;&nbsp;<%=pagebe.getCurrentpage() %>页</b>
    	<b>总记录数&nbsp;&nbsp;&nbsp;&nbsp;<%=pagebe.getSumbar() %>条</b>
    	<a href="<%=basePath %>privaceservlet?order=list&handle=firstpage&currentpage=1">  首    页  </a>
    	<a href="<%=basePath %>privaceservlet?order=list&handle=uppage&currentpage=<%=pagebe.getCurrentpage() %>">  上一  页  </a>
    	<a href="<%=basePath %>privaceservlet?order=list&handle=downpage&currentpage=<%=pagebe.getCurrentpage() %>">  下一  页  </a>
    	<a href="<%=basePath %>privaceservlet?order=list&handle=lastpage&currentpage=<%=pagebe.getSumpage() %>">  尾    页  </a>
    </div>
  </body>
</html>
