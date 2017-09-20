<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
%>
<!--_meta 作为公共模版分离出去-->
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="Bookmark" href="/favicon.ico" >
    <link rel="Shortcut Icon" href="/favicon.ico" />
    <!--[if lt IE 9]>
    <script type="text/javascript" src="<%=path%>/js/html5shiv.js"></script>
    <script type="text/javascript" src="<%=path%>/js/respond.min.js"></script>
    <![endif]-->
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/h-ui/css/H-ui.min.css" />
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/h-ui.admin/css/H-ui.admin.css" />
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/Hui-iconfont/1.0.8/iconfont.css" />
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/h-ui.admin/skin/default/skin.css" id="skin" />
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/h-ui.admin/css/style.css" />
    <link rel="stylesheet" type="text/css" href="<%=path %>/css/themes/icon.css"/>
    <link rel="stylesheet" type="text/css" href="<%=path %>/css/themes/gray/easyui.css">
    <!--[if IE 6]>
    <script type="text/javascript" src="<%=path%>/js/DD_belatedPNG_0.0.8a-min.js" ></script>
    <script>DD_belatedPNG.fix('*');</script>
    <![endif]-->
    <!--/meta 作为公共模版分离出去-->

    <title>玩者登录</title>
</head>
<body>
<div style="height:40px"></div>
<h1 align="center">玩家登录</h1>
<article class="page-container">
    <form class="form form-horizontal"  id="form-member-add">
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-4"><span class="c-red">*</span>玩家账号：</label>
            <div class="formControls col-xs-6 col-sm-4">
                <input type="text" class="input-text" value="" placeholder="" id="playAccount" name="playAccount">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-4"><span class="c-red">*</span>登录密码：</label>
            <div class="formControls col-xs-6 col-sm-4">
                <input type="password" class="input-text" value="" placeholder="" id="playPassword" name="playPassword">
            </div>
        </div>
        <div style="height:50px"></div>
        <div class="row cl">
            <div class="col-xs-4 col-sm-4 col-xs-offset-6 col-sm-offset-4">
                <input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;登录&nbsp;&nbsp;">
                <a style="margin-left:100px" href="<%=path%>/playReg.jsp">还没有账号，去注册</a>
            </div>
        </div>
    </form>
</article>
<div style="height:100px"></div>
<footer>
    <div class="footer-copyRight" style="text-align:center"><span>© 2010-2016 MaxWon.cn 版权所有 沪ICP备15041312号-4</span></div>
</footer>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="<%=path%>/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=path %>/css/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="<%=path%>/js/layer/2.4/layer.js"></script>
<script type="text/javascript" src="<%=path%>/js/H-ui.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="<%=path%>/js/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="<%=path%>/js/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript" src="<%=path%>/js/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript" src="<%=path%>/js/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript">
    $(function(){
        $('.skin-minimal input').iCheck({
            checkboxClass: 'icheckbox-blue',
            radioClass: 'iradio-blue',
            increaseArea: '20%'
        });
        $("#form-member-add").validate({
            rules:{
                playAccount:{
                    required:true,
                    minlength:6,
                    maxlength:10,
                    number:true

                },
                playPassword:{
                    required:true,
                    minlength:6,
                    maxlength:18,

                }
            },
            onkeyup:false,
            focusCleanup:true,
            success:"valid",
            submitHandler:function(form){
                $.post(
                    "<%=path%>/plays/loginIn",$("#form-member-add").serialize(),
                    function(data){
                        if(data.message=='成功!'){
                            location.href="<%=path%>/index.jsp";
                        }else{
                            layer.msg(data.message, {
                                icon : 2,
                                time : 2000
                            });
                        }
                    },
                    "json"
                );
            }
        });
    });
</script>
</body>
</html>