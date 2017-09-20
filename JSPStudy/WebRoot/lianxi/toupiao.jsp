<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'toupiao.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body background="img/0101.gif">
  
  <%
  		request.setCharacterEncoding("utf-8");
  		float num1=0,num2=0,num3=0,num4=0,numsum=0;
  		Hashtable<String,Float> ht = new Hashtable<String,Float>();
  		String name=request.getParameter("username");
  		HashSet hs = new HashSet();
  		Hashtable<String,Float> hts = new Hashtable<String,Float>();
   		if(application.getAttribute("name")!=null){
  		//取出表格中的数据
			hts = (Hashtable)application.getAttribute("num");
			num1 = hts.get("num1");
			num2 = hts.get("num2");
			num3 = hts.get("num3");
			num4 = hts.get("num4");
			numsum=num1+num2+num3+num4;
			num1=num1/numsum*200;
			num2=num2/numsum*200;
			num3=num3/numsum*200;
			num4=num4/numsum*200;
		} 
  		if(application.getAttribute("name")==null){
  			hs.add(name);
  			application.setAttribute("name",hs);
  		}else{
  			hs=(HashSet)application.getAttribute("name");
  			hs.add(name);
  			application.setAttribute("name",hs);
  		}
  		HashSet hst = (HashSet)application.getAttribute("name");
  		Iterator it = hst.iterator();
  		while(it.hasNext()){
  			for(int i=0;i<hst.size();i++){
  				out.print("昵称："+it.next()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;你是第"+(i+1)+"个用户投票<br/>");
  			}
  		}
  		if(request.getParameter("sub")!=null){
  			//判断选择了哪种票！
  			String num = request.getParameter("ra");
  			//取出application对象中的数字
  			if(application.getAttribute("num")==null){
  				//添加数据到表格里
  				ht.put("num1",0f);
  				ht.put("num2",0f);
  				ht.put("num3",0f);
  				ht.put("num4",0f);
  				//加一票进入表格里
  				ht.put(num,1f);
  				application.setAttribute("num",ht);
  			}else{
  				//取出表格中的数据
  				ht = (Hashtable)application.getAttribute("num");
  				num1 = ht.get("num1");
				num2 = ht.get("num2");
				num3 = ht.get("num3");
				num4 = ht.get("num4");
  				if(num.equals("1")){
  					num1++;
  				}else if(num.equals("2")){
  					num2++;
  				}else if(num.equals("3")){
					num3++;  					
  				}else if(num.equals("4")){
					num4++;  					
  				}
				ht.put("num1",num1);
				ht.put("num2",num2);
				ht.put("num3",num3);
				ht.put("num4",num4);
				application.setAttribute("num",ht);
				numsum=num1+num2+num3+num4;
				num1=num1/numsum*200;
				num2=num2/numsum*200;
				num3=num3/numsum*200;
				num4=num4/numsum*200;
  			}
  			
  		}
  
  %>
  <h1 align="center">欢迎<font face="华文行楷" color="blue" size="7"><%=request.getParameter("username")%></font>来到投票界面</h1>
  <hr color="blue" />
  <h3 align="center">当前总票数：<b><font face="华文行楷" color="blue" size="4"><%=numsum %>票</font></b></h3>  
    <form action="lianxi/toupiao.jsp" name="ticket" method="post">
		<table border="0" width="380" height="280" align="center">
			<tr height="50"><td width="140"><img src="img/0000.gif"><input type="radio" name="ra" value="1"><font color="blue" face="华文行楷" size="4">圣诞晚会</font></td><td><div style="width:<%=num1 %>px;height:25px;background:blue;text-align:center;"><%=num1/2 %>%</div></td></tr>
			<tr height="50"><td width="140"><img src="img/0000.gif"><input type="radio" name="ra" value="2" checked><font color="blue" face="华文行楷" size="4">元旦晚会</font></td><td><div style="width:<%=num2 %>px;height:25px;background:blue;text-align:center;"><%=num2/2 %>%</td></tr>
			<tr height="50"><td width="140"><img src="img/0000.gif"><input type="radio" name="ra" value="3"><font color="blue" face="华文行楷" size="4">中立</font></td><td><div style="width:<%=num3 %>px;height:25px;background:blue;text-align:center;"><%=num3/2 %>%</td></tr>
			<tr height="50"><td width="140"><img src="img/0000.gif"><input type="radio" name="ra" value="4"><font color="blue" face="华文行楷" size="4">不开</font></td><td><div style="width:<%=num4 %>px;height:25px;background:blue;text-align:center;"><%=num4/2 %>%</td></tr>
			<tr height="40"><td colspan="2" align="center"><input type="submit" name="sub" value=" 投 票 "><input type="reset" name="re" value=" 重 投 "></td></tr>
			<tr height="40"><td colspan="2"><marquee><img src="img/0000.gif"><font color="blue" face="华文行楷" size="4">2016秋宏图软件一班晨练投票系统（多者为胜）</font></marquee></td></tr>
		</table>
	</form>
	
	<h1 align="center"><font color="blue" face="华文行楷" size="5">请真诚投票！</font></h1>
  </body>
</html>
