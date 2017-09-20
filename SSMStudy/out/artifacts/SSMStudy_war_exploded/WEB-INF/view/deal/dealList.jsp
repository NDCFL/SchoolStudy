<%@ page import="com.ht.pojo.Plays" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/9/7
  Time: 19:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String path = request.getContextPath();
    Plays plays = (Plays) session.getAttribute("plays");
%>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <!--[if lt IE 9]>
    <!--<script type="text/javascript" src="lib/html5shiv.js"></script>-->
    <!--<script type="text/javascript" src="lib/respond.min.js"></script>-->
    <![endif]-->
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/h-ui/css/H-ui.min.css" />
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/h-ui.admin/css/H-ui.admin.css" />
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/Hui-iconfont/1.0.8/iconfont.css" />
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/h-ui.admin/skin/default/skin.css" id="skin" />
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/h-ui.admin/css/style.css" />
    <!--[if IE 6]>
    <!--<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>-->
    <!--<script>DD_belatedPNG.fix('*');</script>-->
    <![endif]-->
    <title>玩家订单列表</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>学生管理 <span class="c-gray en">&gt;</span> 资讯列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" onclick="refush();" id="orderlist"><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
    <div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l">
        <a href="javascript:;" onclick="del()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a>
        <a class="btn btn-primary radius" data-title="添加玩家订单"  onclick="deal_add('添加玩家订单','<%=path%>/deal/initAddDeal','','400')" href="javascript:;"><i class="Hui-iconfont">&#xe600;</i> 添加玩家订单</a></span>
        <span class="r" id="number">共有数据：<strong>54</strong> 条</span> </div>
    <div class="mt-20">
        <table class="table table-border table-bordered table-bg table-hover table-sort table-responsive">
            <thead>
            <tr class="text-c">
                <th width="25"><input type="checkbox" name="id" value="${s.dealId}"></th>
                <th width="80">订单流水账号</th>
                <th width="80">玩家昵称</th>
                <th width="80">价格</th>
                <th width="80">道具名称</th>
                <th width="80">订单时间</th>
                <th width="120">操作</th>
            </tr>
            </thead>
            <tbody>
                <c:forEach items="${dealList}" var="s">
                    <tr class="text-c">
                        <td><input type="checkbox" value="${s.dealId}" name="id"></td>
                        <td>${s.dealBill}</td>
                        <td>${s.plays.playNickname}</td>
                        <td>${s.dealPrice}</td>
                        <td>${s.prop.propName}</td>
                        <td>${s.dealCreatetime}</td>
                        <td class="f-14 td-manage">
                            <a style="text-decoration:none" class="ml-5" onClick="deal_edit('玩家订单编辑','<%=path%>/deal/findDeal/${s.dealId}','','410')" href="javascript:;" title="编辑"><i class="Hui-iconfont">&#xe6df;</i></a>
                            <a style="text-decoration:none" class="ml-5" onClick="deal_del(this,'${s.dealId}')" href="javascript:;" title="删除"><i class="Hui-iconfont">&#xe6e2;</i></a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<script type="text/javascript" src="<%=path %>/js/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/layer/2.4/layer.js"></script>
<script type="text/javascript" src="<%=path %>/js/H-ui.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="<%=path %>/js/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/laypage/1.2/laypage.js"></script>
<script>
    function refush(){
        setTimeout("list()",500);
    }
    function list(){
        window.location.href="<%=path%>/deal/dealList/<%=plays.getPlayId()%>";
    }
</script>
<script type="text/javascript">
    $('.table-sort').dataTable({
        "aaSorting": [[ 1, "desc" ]],//默认第几个排序
        "bStateSave": true,//状态保存
        "pading":false,
        "aoColumnDefs": [
            //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
            {"orderable":false,"aTargets":[0,3]}// 不参与排序的列
        ]
    });
    function deal_edit(title,url,w,h){
        layer_show(title,url,w,h);
    }
    function  del() {
        var a =[];
        $('input[name="id"]:checked').each(function(){
            a.push($(this).val());
        });
        if(a==""){
            layer.msg('删除失败，请勾选数据!', {
                icon : 2,
                time : 2000
            });
            return ;
        }
        layer.confirm('确认要删除吗？',function(index){
            $.post(
                '<%=path%>/deal/deleteManyDeal/'+a,
                {
                    "id":a
                },
                function(data){
                    refush();
                    layer.msg('已删除!',{icon:1,time:1000});
                },
                "json"
            );
        });
    }
    function deal_list(obj,id){
        window.location.href="<%=path%>/dealItems/pagelistbyorderid/${s.id}";
    }
    /*玩家订单-删除*/
    function deal_del(obj,id){
        layer.confirm('确认要删除吗？',function(index){
            $.ajax({
                type: 'POST',
                url: '<%=path%>/deal/deleteDeal/'+id,
                dataType: 'json',
                success: function(data){
                    $(obj).parents("tr").remove();
                    refush();
                    layer.msg('已删除!',{icon:1,time:1000});
                },
                error:function(data) {
                    console.log(data.msg);
                },
            });
        });
    }
    /*玩家订单-添加*/
    function deal_add(title,url,w,h){
        layer_show(title,url,w,h);
    }
</script>
</body>
</html>