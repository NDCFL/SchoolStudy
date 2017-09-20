<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="struts.form.StudentForm"%>
<%@ taglib prefix="html"  uri="http://struts.apache.org/tags-html"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html>
  <head>
    <base href="<%=basePath%>">
    <title>学生列表</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.1.min.js"></script>
    <script type="text/javascript">
    	$(function(){
    		$("#info").bind("click",function(){
    			alert("asjdf");
    			$.post(
	    			"${pageContext.request.contextPath}/student.do",
	    			{
	    				"order":"list"
	    			},
	    			play,
	    			"json"
    			);
    		});
    	});
    	function play(data){
				var info="";
				for(var i=0;i<data.length;i++){
					if(i<data.length-1){
						info+="<tr height='40px' align='center'>";
						info+="<td>"+data[i].sno+"</td>";
						info+="<td>"+data[i].studentname+"</td>";
						info+="<td>"+data[i].sage+"</td>";
						info+="<td>"+data[i].ssex+"</td>";
						info+="<td>"+data[i].shobit+"</td>";
						info+="<td>"+data[i].szhuanye+"</td>";
						info+="<td><a href='javascript:void(0);'  id=\"del\" onclick=\"del('"+data[i].sno+"');\">删除</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href='javascript:void(0);' onclick=\"update('"+data[i].sno+"');\">修改</a></td>";
						info+="</tr>";
					}else{
						info+="<tr height='40' align='center'><td colspan='7'>";
		    			info+="<span class='current'>总记录数:&nbsp;&nbsp;"+data[i].pagebarsum+"条&nbsp;&nbsp;</span>&nbsp;&nbsp;&nbsp;&nbsp;";
						info+="<span class='current'>页码："+data[i].sumpage+"&nbsp;&nbsp;/&nbsp;&nbsp;"+data[i].currentpage+"页</span>";
		    			info+="<a href='javascript:void(0);' onclick=\"first('1');\">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;";
		    			info+="<a href='javascript:void(0);' onclick=\"up('"+data[i].currentpage+"');\">上一页&nbsp;&nbsp;&nbsp;&nbsp;</a>";
		    			info+="<a href='javascript:void(0);' onclick=\"down('"+data[i].currentpage+"');\">下一页&nbsp;&nbsp;&nbsp;&nbsp;</a>";
		    			info+="<a href='javascript:void(0);' onclick=\"last('"+data[i].currentpage+"');\">尾页&nbsp;&nbsp;&nbsp;&nbsp;</a>";
						info+="</td></tr>";
					}
				}
				$("#data").html(info);
				$("#sno").val("");
				$("#studentname").val("");
				$("#sage").val("")
				$("#shobit").val("");
				$("#szhuanye").val("");
			}	
			function del(sno){
				if(!confirm("删除确认")){
					return;
				}
				$.post(
					"${pageContext.request.contextPath}/student.do",
					{
						"sno":sno,
						"order":"del"
					},
					play,
					"json"
				);
			}
			function first(page){
				$.post(
					"${pageContext.request.contextPath}/student.do",
					{
						"order":"list",
						"currentpage":page,
						"handle":"firstpage"
					},
					play,
					"json"
				);
			}
			function up(page){
				$.post(
					"${pageContext.request.contextPath}/student.do",
					{
						"order":"list",
						"currentpage":page,
						"handle":"uppage"
					},
					play,
					"json"
				);
			}
			function down(page){
				$.post(
					"${pageContext.request.contextPath}/student.do",
					{
						"order":"list",
						"currentpage":page,
						"handle":"downpage"
					},
					play,
					"json"
				);
			}
			function last(page){
				$.post(
					"${pageContext.request.contextPath}/student.do",
					{
						"order":"list",
						"currentpage":page,
						"handle":"lastpage"
					},
					play,
					"json"
				);
			}
    </script>
  </head>
  <body>
  <%
  	StudentForm student = (StudentForm)request.getAttribute("studentForm");
  %>
  	<h1 align="center">学生列表</h1>
  		<div id="msg"></div>
   		<html:form action="/student.do?order=add" method="post" >
   			<table border="0" align="center" width="800">
    		<tr height="50">
    			<td>
		    		学号：<html:text  name="studentForm" property="sno"  style="height:40px;width:200px;ime-mode: disabled"/>
    			</td>
    			<td>
    				姓名：<html:text  property="studentname" name="studentForm"  style="height:40px;width:200px"/>
    			</td>
    		</tr>
		    <tr height="50">
    			<td>
		    		年龄：<html:text property="sage" name="studentForm"  style="height:40px;width:200px"/>
		    	</td>
    			<td>
		    		性别：&nbsp;&nbsp;<html:radio property="ssex" name="studentForm"  value="男" />男&nbsp;&nbsp;<html:radio property="ssex" name="studentForm"   value="女" />女
		    	</td>
    		</tr>
		    <tr height="50">
		    	<td>
		    		籍贯：<html:text property="shobit" name="studentForm"  style="height:40px;width:200px"/>
		    	</td>
		    	<td>
		    		专业：<html:text property="szhuanye" name="studentForm"  style="height:40px;width:200px"/>
		    	</td>
		    </tr>
		   <tr align="center" height="100">
			   <td align="center" colspan="2">
			   		<html:submit value="新增" style="height:40px;width:200px;display:block" onclick="check();"></html:submit>
			   </td>
			   <td colspan="2">
			   		<html:submit value="显示列表" style="height:40px;width:200px;display:block"></html:submit>
			   </td>
		   </tr>
    	</table>
    	<h1 align="center" id="info">学生基本信息</h1>
   		<table align="center" border="1" width="800px" >
    		<tr height="40px">
    			<th>学号</th>
    			<th>姓名</th>
    			<th>年龄</th>
    			<th>性别</th>
    			<th>籍贯</th>
    			<th>专业</th>
    			<th>操作</th>
    		</tr>
    		<tbody id="data">
    		</tbody>
   	</html:form>
  </body>
</html:html>
