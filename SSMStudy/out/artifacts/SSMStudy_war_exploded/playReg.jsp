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

    <title>添加用户</title>
</head>
<body>
<div style="height:40px"></div>
<h1 align="center">注册玩家</h1>
<article class="page-container">
    <form class="form form-horizontal"  id="form-member-add">
        <input type="hidden"  value="1" name="playIsVip" />
        <input type="hidden" name="userId" id="useriD" value="${requestScope.userid}"/>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-4"><span class="c-red">*</span>玩家昵称：</label>
            <div class="formControls col-xs-6 col-sm-4">
                <input type="text" class="input-text" value="" placeholder="" id="playNickname" name="playNickname">
            </div>
        </div>
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
        </div><div class="row cl">
        <label class="form-label col-xs-4 col-sm-4"><span class="c-red">*</span>确认密码：</label>
        <div class="formControls col-xs-6 col-sm-4">
            <input type="password" class="input-text" value="" placeholder="" id="pwd" name="pwd">
        </div>
    </div>
        <div style="height:50px"></div>
        <div class="row cl">
            <div class="col-xs-4 col-sm-4 col-xs-offset-6 col-sm-offset-4">
                <input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;注册成为玩家&nbsp;&nbsp;">
                <a style="margin-left:100px" href="<%=path%>/playLogin.jsp">有账号，去登录</a>
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
                playName:{
                    required:true,
                    minlength:2,
                    maxlength:16
                },
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
                //$(form).ajaxSubmit();
                alert($("#form-member-add").serialize());
                $.post(
                    "<%=path%>/plays/addSavePlays",$("#form-member-add").serialize(),
                    function(data){
                    },
                    "json"
                );
                location.href="<%=path%>/playLogin.jsp";
//                var index = parent.layer.getFrameIndex(window.name);
//                parent.$('#orderlist').trigger("click");
//                parent.layer.close(index);

            }
        });
    });
</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>