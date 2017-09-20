<%@ page contentType="text/xml; charset=gb18030"%><%@ page import="java.util.*"  %><%
	HashMap map = new HashMap();
	map.put("a","<words><word>a</word><word>ab</word><word>abc</word><word>abcd</word><word>abcde</word></words>");
	map.put("ab","<words><word>ab</word><word>abc</word><word>abcd</word><word>abcde</word></words>");
	map.put("abc","<words><word>abc</word><word>abcd</word><word>abcde</word></words>");
	map.put("abcd","<words><word>abcd</word><word>abcde</word></words>");
	map.put("abcde","<words><word>abcde</word></words>");
	
	String inputWord= request.getParameter("inputWord");
	out.write("<?xml version='1.0' encoding='gb2312' ?>");
	if(!map.containsKey(inputWord)){
		out.println("<words></words>");
	}else{
		out.println(map.get(inputWord).toString());
	}
%>