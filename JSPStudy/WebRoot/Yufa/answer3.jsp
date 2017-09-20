<%@page contentType="text/html; charset=gb2312"%>
<%int i,j;
	String s=request.getParameter("n");
		if(s==null){
			s="0";
		}
	try
	{
		int n=Integer.parseInt(s);
		out.print("1-"+n+"之间的素数有:<br>");
		for(i=1;i<=n;i++){
		for(j=2;j<i;j++)
			if(i%j==0)
				break;
			if(j==i)
				out.print(i+",");
		}
	}catch(NumberFormatException e){
		out.print("<br>请输入数字");
	}

%>

