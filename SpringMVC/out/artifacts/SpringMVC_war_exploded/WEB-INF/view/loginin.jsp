<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/9/5
  Time: 19:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <title>用户登录界面</title>
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/hui.css" />
</head>
<body style="background:#F4F5F6;">
<header class="hui-header">
    <div id="hui-back"></div>
    <h1>用户登录界面</h1>
</header>
<div class="hui-wrap">
    <div class="hui-center-title" style="margin-top:35px;"><h1 style="border:0px;">登录</h1></div>
    <form action="<%=path%>/lg/logininto" method="post" onsubmit="return checkvolid();">
        <div style="margin:28px; margin-bottom:15px;" class="hui-form" id="form1">
            <div class="hui-form-items">
                <input type="text" class="hui-input hui-input-clear" name="id" placeholder="用户账号" checkType="int" checkData="2,20" checkMsg="用户账号应为2-20个字符" />
            </div>
            <div class="hui-form-items">
                <input type="password" class="hui-input hui-pwd-eye" name="name" placeholder="登录密码" checkType="string" id="pwd" checkData="6,20" checkMsg="密码应为6-20个字符" />
            </div>
        </div>
        <div style="padding:28px; padding-top:0px;">
            <button type="submit" class="hui-button hui-button-large hui-primary" id="submit" >立即登录</button>
        </div>
    </form>
</div>
<script type="text/javascript" src="<%=path%>/js/hui.js" charset="UTF-8"></script>
<script type="text/javascript" src="<%=path%>/js/hui-form.js" charset="utf-8"></script>
<script type="text/javascript">
    function checkvolid(){
        var res = huiFormCheck('#form1');
        //提交
        if(res==true){
            hui.iconToast('验证通过！');
            return true;
        }else{
            return false;
        }
    }
</script>
</body>
</html>