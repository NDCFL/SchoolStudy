<%@ page  contentType="text/html;charset=GB2312" %>

<%
   String s = (String)request.getAttribute("n");
	
	
	if(s!=null){
	    int n = Integer.parseInt(s);
		int sum=0;
		for(int i=0;i<=n;i++){
	       sum=sum+i;
	    }
		out.println("�ۼӺ�Ϊ ��"+sum);
	}else{
	    out.println("��ȷ��n��ֵ");
	}
%>