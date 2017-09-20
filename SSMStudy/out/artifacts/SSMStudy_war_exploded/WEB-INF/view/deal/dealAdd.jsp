<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
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

	<title>添加订单</title>
</head>
<body>
<article class="page-container">
	<form class="form form-horizontal"  id="form-member-add">
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>当前余额：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="number" class="input-text" style="width:300px" value="${requestScope.summoney}" readonly placeholder="" id="money" name="money">
            </div>
        </div>
        <div class="row cl">
			<label class="form-label col-xs-3 col-sm-3"><span class="c-red">*</span>道具：</label>
			<div class="formControls col-xs-8 col-sm-9" >
				<span class="select-box" style="width:300px"  >
					<select name="propId" class="select" id="propid" onchange="findprice(this.value)">
						<option value="0">请选择道具</option>
						<c:forEach items="${propList}" var="p">
							<option value="${p.propId}">${p.propName}</option>
						</c:forEach>
					</select>
				</span>
			</div>
		</div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>所需价格：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="number" class="input-text"style="width:300px"  value="" readonly placeholder="" id="dealPrice" name="dealPrice">
            </div>
        </div>
        <div style="height:50px"></div>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
                    <c:if test="${requestScope.summoney==0.0}">
                        <input class="btn btn-primary radius" onclick="gotoaddmoney();" type="button" value="&nbsp;&nbsp;余额不足，去充值&nbsp;&nbsp;">
                    </c:if>
                <c:if test="${requestScope.summoney!=0.0}">
                    <input class="btn btn-primary radius"  type="submit" value="&nbsp;&nbsp;购买&nbsp;&nbsp;">
                </c:if>
			</div>
		</div>
	</form>
</article>

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
    function gotoaddmoney(){
        location.href="<%=path%>/money/moneyList"
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
                propId:{
                    required:true
                }
            },
            onkeyup:false,
            focusCleanup:true,
            success:"valid",
            submitHandler:function(form){
                //$(form).ajaxSubmit();
                if(($("#money").val())-($("#dealPrice").val())<0){
                    layer.msg('购买失败，余额不足!', {
                        icon : 2,
                        time : 2000
                    });
                }else{
                    $.post(
                        "<%=path%>/deal/addSaveDeal",$("#form-member-add").serialize(),
                        function(data){
                        },
                        "json"
                    );
                    var index = parent.layer.getFrameIndex(window.name);
                    parent.$('#orderlist').trigger("click");
                    parent.layer.close(index);
                }
            }
        });
    });
</script>
<!--/请在上方写此页面业务相关的脚本-->
<script type="text/javascript">
    function findprice(propid){
        $.post(
            "<%=path%>/prop/findTheProp/"+propid,
            function(data){
                $("#dealPrice").val(data.propPrice);
            },
            "json"
        );
    }

</script>
</body>
</html>