<%@page contentType="text/html; charset=gb2312"%>
<%
String s=request.getParameter("n");
if(s==null)
{s="1";}
try
{
int n=Integer.parseInt(s);
double t=1;
for(int i=1;i<=n;i++)
t*=i;
out.print(n+"的介乘是:<br>"+t);
}catch(NumberFormatException e)
{out.print("<br>请输入数字");}
%>

