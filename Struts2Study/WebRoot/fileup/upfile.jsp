<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>文件的上传</title>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.1.min.js"></script>
		<script type="text/javascript">
			function filecheck(){
				if($("#upfile").val()==""){
					document.getElementById('msg').style.visibility='visible';
					$("#msg").html("<font color='red'>请选择要上传的文件</font>");
					return false;
				}
			}
		</script>
	</head>
	<body>
		<h1>文件的上传</h1>
		<hr/>
		<form action="FileUpAction.action" method="post" onsubmit="return filecheck();" enctype="multipart/form-data">
			<div id="msg" style="visibility:hidden"></div>
			<s:fielderror></s:fielderror>
			<label>上传文件</label><input type="file"  id="upfile" name="fileupinfo.doc" style="width:200px;height:40px" />
			<input type="submit" value="上传文件" style="width:140px;height:40px"/>
		</form>
	</body>
</html>