<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>菜单</title>
  <style>
	#navigation, #navigation li ul { list-style-type:none; } 
	#navigation li { float:left; text-align:center; position:relative; } 
	#navigation li a:link, #navigation li a:visited { display:block; text-decoration:none; color:#000099; width:120px; height:40px; line-height:40px; border:1px solid #fff; border-width:1px 1px 0 0; background:#9999ff;  padding-left:10px; } 
	#navigation li a:hover { color:#9999ff; background:#6666ff; } //鼠标选中的颜色
	#navigation li ul li a:hover { color:#cc33ff; background:#99cccc; } 
	#navigation li ul {display:none; position:absolute;top:40px; left:0; margin-top:1px; width:120px; } 
  </style>
  <script type="text/javascript">
	  function displaySubMenu(li) { 
		  //getElementsByTagName：通过标签的名称获取标签
			var subMenu = li.getElementsByTagName("ul")[0]; 
			subMenu.style.display = "block"; 
		} 
		function hideSubMenu(li) { 
			var subMenu = li.getElementsByTagName("ul")[0]; 
			subMenu.style.display = "none"; 
		}
  </script>
 </head>

 <body>
 	<table height="240" align="center" border="1" width="100%">
 	<tr height="80" ><td width="200"><%@include file="good.jsp" %></td><td align="center"><%@include file="moble.jsp" %></td><td><%@include file="find.jsp" %></td></tr>
 		<tr>
 			<td width="200">
 				<IFRAME ID='ifm2' WIDTH='168' HEIGHT='70' MARGINWIDTH='0' MARGINHEIGHT='0' HSPACE='0' VSPACE='0' FRAMEBORDER='0' SCROLLING='NO' src="http://news.sina.com.cn/iframe/weather/110100.html"></iframe>
 			</td>
 			<td width="900"></td>
 			<td width="200" align="top"><%@include file="wnl.jsp" %></td>
 		</tr>
 		
 	</table>
 	<table border="1" width="100%" height="400"> 
 		<tr width="100%" height="100%">
 			<td>
 				<table height="400" width="180" border="1">
 					<tr><td></td></tr>
 				</table>
 			</td>
 			<td>
 				
			    <table border="1" align="center" align="left">
			    	<tr height="40">
			    		<td>
			    			<ul id="navigation">
						<li onmouseover="displaySubMenu(this)" onmouseout="hideSubMenu(this)"> 
			        	<a href="#">数学运算</a>
							<ul>
								<li><a href="T1doc/Jjcfb.jsp">九九乘法表</a></li>
								<li><a href="T1doc/cal.jsp">计算器</a></li>
								<li><a href="T1doc/jishi.jsp">计时器</a></li>
								<li><a href="T1doc/juxing.jsp">菱形</a> </li>
								<li><a href="T1doc/Shijian.jsp">登录界面</a></li>  
							</ul>        	
			        	</li>
						<li onmouseover="displaySubMenu(this)" onmouseout="hideSubMenu(this)"> 
			            	<a href="#">登录权限</a>
			            	<ul>	
			            		<li><a href="T2doc/juxing.jsp">include动作元素</a></li>
								<li><a href="T2doc/hefa2.jsp">forward动作元素</a></li>
								<li><a href="T2doc/hefa3.jsp">重定向</a></li>
								<li><a href="T2doc/huikui.jsp">软件反馈</a></li>
								<li><a href="T2doc/Shijian.jsp">时间计划</a></li>
			            	</ul>
			            </li>
						<li onmouseover="displaySubMenu(this)" onmouseout="hideSubMenu(this)"> 
			            	<a href="#">数据操作</a>
							<ul>
								<li><a href="T3doc/SQLcon.jsp">数据库连接</a></li>
								<li><a href="T3doc/Yunsuan.jsp">运算</a></li>
							</ul>
			            </li>
						<li onmouseover="displaySubMenu(this)" onmouseout="hideSubMenu(this)"> 
			            	<a href="#">娱乐小例</a>
							<ul>
						   	   <li><a href="T4doc/tickets.jsp">市民收入投票系统</a> </li>
						   	   <li><a href="T4doc/logincount.jsp">计算访问人数</a> </li>
						   	   <li><a href="T4doc/log.jsp">计算登录用户个数</a> </li>
						       <li><a href="T4doc/getAttibutedemo.jsp">getAttibutedemo的使用</a> </li>
						       <li><a href="T4doc/SetAttibutedemo.jsp">SetAttibutedemo的使用</a> </li>
					       </ul>
			            </li>
						<li onmouseover="displaySubMenu(this)" onmouseout="hideSubMenu(this)"> 
			            	<a href="#">龙龙聊天室</a>
							<ul>
						   	   <li><a href="T4docqq/login.jsp">聊天登录</a> </li>
							</ul>
			            </li>
			            <li id="m_6" ><a href="T5doc/loginshop.jsp">龙龙商城</a></li>
			            <li><a href="T5doc/toupiao.jsp">晨练投票系统</a></li>            
			            <li><a href="#">安全退出</a></li>
			        </ul>
			    		</td>
			    	</tr>
			    	<tr height="300"><td></td></tr>
			    	<tr  height="40"><td></td></tr>
			    </table>
			    
 			</td>
 			<td>
 				<table height="400" width="180" border="1" align="right">
			 		<tr><td>right</td></tr>
			 	</table>	
 			</td>
 		</tr>
 	</table>
 </body>
</html>
				
	  