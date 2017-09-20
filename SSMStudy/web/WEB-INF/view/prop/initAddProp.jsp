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
	<!--[if IE 6]>
	<script type="text/javascript" src="<%=path%>/js/DD_belatedPNG_0.0.8a-min.js" ></script>
	<script>DD_belatedPNG.fix('*');</script>
	<![endif]-->
	<!--/meta 作为公共模版分离出去-->

	<title>添加道具</title>
</head>
<body>
<article class="page-container">
	<form class="form form-horizontal" id="form-member-add">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>道具名称：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="" id="propName" name="propName">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>道具价格：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="" id="propPrice" name="propPrice">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-3 col-sm-3"><span class="c-red">*</span>道具类型：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<span class="select-box">
					<select name="propGenre" class="select">
						<option value="0">请选择道具类型</option>
						<option value="0">英雄</option>
						<option value="1">武器</option>
						<option value="2">装备</option>
					</select>
				</span>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-2 col-sm-3">道具技能：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<textarea name="propSkill" cols="" id="propSkill" rows="" class="textarea"  placeholder="说点什么...100个字符以内" dragonfly="true" onKeyUp="checkpropSkill(this.value);"></textarea>
				<p class="textarea-numberbar"><em class="textarea-length" id="num">0</em>/100</p>
			</div>
		</div>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
				<input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
			</div>
		</div>
	</form>
</article>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="<%=path%>/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/layer/2.4/layer.js"></script>
<script type="text/javascript" src="<%=path%>/js/H-ui.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="<%=path%>/js/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="<%=path%>/js/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript" src="<%=path%>/js/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript" src="<%=path%>/js/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript">
	function checkpropSkill(name){
	    var len = name.length;
		if(len<100){
		    $("#num").text(len);
		}else{
            layer.msg('最多100字!', {
                icon : 2,
                time : 2000
            });
		    $("#propSkill").val(name.substring(0,100));
		}

	}

</script>
<script type="text/javascript">
    $(function(){
        $('.skin-minimal input').iCheck({
            checkboxClass: 'icheckbox-blue',
            radioClass: 'iradio-blue',
            increaseArea: '20%'
        });
        $("#form-member-add").validate({
            rules:{
                propName:{
                    required:true,
                    minlength:2,
                    maxlength:16
                },
                propPrice:{
                    required:true,
					min:0
                },
                propSkill:{
                    required:true,
                    minlength:10,
                    maxlength:100
                }
            },
            onkeyup:false,
            focusCleanup:true,
            success:"valid",
            submitHandler:function(form){
                //$(form).ajaxSubmit();
				$.post("<%=path%>/prop/addSaveProp",$("#form-member-add").serialize(),
					function(data){
					},
					"json"
				);
                var index = parent.layer.getFrameIndex(window.name);
                parent.$('#patrentutl').trigger("click");
                parent.layer.close(index);
            }
        });
    });
</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>