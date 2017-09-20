<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/9/8
  Time: 19:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String path = request.getContextPath();
    String basePath = request.getRealPath("/upfile");
%>
<html>
<head>
    <title>文件下载</title>
</head>
<body>
    <ul>
        <c:forEach items="${requestScope.filelist}" var="d">
            <li><img src="<%=path %>/upfile/${d}" width="100" height="100"><a href="/first/loadFile/${d.substring(d.lastIndexOf('.'),d.length())}/${d}">下载</a></li>
        </c:forEach>
    </ul>
</body>
</html>
