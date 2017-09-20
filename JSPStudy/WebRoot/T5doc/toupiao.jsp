<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>晨练投票系统</title>
  </head>
  <body background="img/0101.gif">
    <h1 align="center"><font color="blue" face="华文行楷" size="5">晨练投票系统</font></h1>
	<hr color="blue" size="3px"/>
	<%
		Hashtable<String ,Float> ht = new Hashtable<String ,Float>();
		
		float num1,num2,num3,num4,sum=0;
		num1=num2=num3=num4=0;
		if(ht!=null){
			num1 = ht.get("1");
			num2 = ht.get("2");
			num3 = ht.get("3");
			num4 = ht.get("4");
			sum=num1+num2+num3+num4;
			num1=num1/sum*200;
			num2=num2/sum*200;
			num3=num3/sum*200;
			num4=num4/sum*200;
		} 
		if(request.getParameter("sub")!=null){
			//取出相应的票号
			String piao = request.getParameter("ra");
			if(application.getAttribute("renshu")==null){
				ht.put("1",0f);
				ht.put("2",0f);
				ht.put("3",0f);
				ht.put("4",0f);
				ht.put(piao,1f);
				//设值到application中
				application.setAttribute("renshu",ht);
			}else{
				ht=(Hashtable)application.getAttribute("renshu");
				num1 = ht.get("1");
				num2 = ht.get("2");
				num3 = ht.get("3");
				num4 = ht.get("4");
				if(piao.equals("1")){
					num1++;
				}else if(piao.equals("2")){
					num2++;
				}else if(piao.equals("3")){
					num3++;
				}else if(piao.equals("4")){
					num4++;
				}
				ht.put("1",num1);
				ht.put("2",num2);
				ht.put("3",num3);
				ht.put("4",num4);
				application.setAttribute("renshu",ht);
				sum=num1+num2+num3+num4;
				num1=num1/sum*200;
				num2=num2/sum*200;
				num3=num3/sum*200;
				num4=num4/sum*200;
			}
		}
	%>	
	<form action="T5doc/toupiao.jsp" name="ticket" method="post">
		<table border="0" width="380" height="280" align="center">
			<tr height="50"><td width="140"><img src="img/0000.gif"><input type="radio" name="ra" value="1"><font color="blue" face="华文行楷" size="4">赞成晨练</font></td><td><div style="width:<%=num1 %>px;height:25px;background:blue;text-align:center;"><%=num1/2 %>%</div></td></tr>
			<tr height="50"><td width="140"><img src="img/0000.gif"><input type="radio" name="ra" value="2" checked><font color="blue" face="华文行楷" size="4">取消晨练</font></td><td><div style="width:<%=num2 %>px;height:25px;background:blue;text-align:center;"><%=num2/2 %>%</td></tr>
			<tr height="50"><td width="140"><img src="img/0000.gif"><input type="radio" name="ra" value="3"><font color="blue" face="华文行楷" size="4">中立</font></td><td><div style="width:<%=num3 %>px;height:25px;background:blue;text-align:center;"><%=num3/2 %>%</td></tr>
			<tr height="50"><td width="140"><img src="img/0000.gif"><input type="radio" name="ra" value="4"><font color="blue" face="华文行楷" size="4">一周一次</font></td><td><div style="width:<%=num4 %>px;height:25px;background:blue;text-align:center;"><%=num4/2 %>%</td></tr>
			<tr height="40"><td colspan="2" align="center"><input type="submit" name="sub" value=" 投 票 "><input type="reset" name="re" value=" 重 投 "></td></tr>
			<tr height="40"><td colspan="2"><marquee><img src="img/0000.gif"><font color="blue" face="华文行楷" size="4">2016秋宏图软件一班晨练投票系统（多者为胜）</font></marquee></td></tr>
		</table>
	</form>
	
	<h1 align="center"><font color="blue" face="华文行楷" size="5">看看呀！下雨了！建议投取消晨练！！！</font></h1>
  </body>
</html>
