<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/9/5
  Time: 20:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>hcoder</title>
    <link rel="stylesheet" type="text/css" href="http://www.hcoder.net/public/main.css" />
    <link rel="shortcut icon" type="image/x-icon" href="http://www.hcoder.net/favicon.ico" />
    <script type="text/javascript" src="http://libs.baidu.com/jquery/1.10.2/jquery.js"></script>
    <style type="text/css">
        *{margin:0px; padding:0px;  font-size:13px; color:#303538; font-family:'Microsoft Yahei',Arial,sans-serif; outline:none;}
        .cWidth{width:352px;}
    </style>
</head>
<body>
<div class="loginInputs" id="inputUser">
    <input type="text" id="user" class="loginInput" placeholder="登录邮箱" />
</div>
<div class="loginInputs" id="inputPwd">
    <input type="password" id="pwd" class="loginInput" placeholder="登录密码" />
</div>
<div class="cWidth">
    <a href="javascript:" onclick="loginNow();" class="cButton" id="butLoginNow">登录</a>
</div>
<div class="cWidth" style="padding-top:10px;">
    <div class="FL">
        <span id="loginError"></span>
    </div>
    <div class="FR">
        <a href="javascript:butRePwdIn();">忘记密码?</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="javascript:butRegIn();">立即注册</a>
    </div>
</div>
<div class="cWidth" style="padding-top:10px;">
    <a href="javascript:void(0);" onclick="qqLogin();"><img src="http://static.hcoder.net/public/images/loginQq.jpg" /></a>
</div>
<script type="text/javascript" src="http://www.hcoder.net/public/scripts/common.js"></script>
<script type="text/javascript" src="http://www.hcoder.net/public/scripts/login.js"></script>
</body>
</html>