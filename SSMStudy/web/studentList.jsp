<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="stylesheet" href="<%=path%>/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="<%=path%>/bootstrap/css/bootstrap-table.css">
    <script src="<%=path%>/bootstrap/js/jquery.min.js"></script>
    <script src="<%=path%>/bootstrap/js/bootstrap.min.js"></script>
    <script src="<%=path%>/bootstrap/js/bootstrap-table.js"></script>
    <script src="<%=path%>/bootstrap/js/bootstrap-table-zh-CN.js"></script>
    <script src="<%=path%>/bootstrap/js/bootstrap-table-export.js"></script>
    <script src="<%=path%>/bootstrap/js/tableExport.js"></script>
    <title>学生列表</title>
</head>
<body>
<div class="row base-margin" id="query">
    <ol class="breadcrumb">
        <li><strong><span style="color: #27a0d7">学生列表</span></strong></li>
    </ol>
    <form class="form-inline" role="form" style="width: 80%;align-content: center;margin-left:200px" method="post" id="queryForm">
        <div class="form-group">
            <label for="orgCode">学生:</label>
            <select class="form-control" id="orgCode" name="orgCode">
                <option value="">默认选择</option>
                    <option value="1">1</option>
                    <option value="1">1</option>
                    <option value="1">1</option>
            </select>
        </div>
        <div class="form-group">
            <label for="userName">名称:</label>
            <input type="text" class="form-control" name="userName" id="userName"  placeholder="请输入名称">
        </div>
        <div class="form-group">
            <label >日期:</label>
            <input placeholder="开始日期" class="form-control layer-date" id="startDate" name="startDate">
            <input placeholder="结束日期" class="form-control layer-date" id="endDate" name="endDate">
        </div>
        <div class="form-group">
            <button type="button" id="queryBtn" onclick="doQuery();" class="btn btn-primary">查询</button>
        </div>
        <div class="form-group btn-right">
            <button type="button" class="btn btn-primary" id="addBtn" onclick="addUser();">新增用户</button>
        </div>
    </form>
</div>
<div class="container" style="width: 100%">
    <table id="demo-table">
    </table>
</div>
</body>
<script type="text/javascript">
    $(function () {
        initTable();
//        initDate();
    });

    function doQuery(params){
        $('#demo-table').bootstrapTable('refresh');    //刷新表格
    }

    function initTable(){
        $('#demo-table').bootstrapTable({
            method:'POST',
            dataType:'json',
            contentType: "application/x-www-form-urlencoded",
            cache: false,
            striped: true,                              //是否显示行间隔色
            sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
            url:"<%=path%>/student/pageStudentList",
//            height: $(window).height()-100,
//            width:$(window).width()-60,
            showColumns:true,
            pagination:true,
            queryParams : queryParams,
            minimumCountColumns:2,
            pageNumber:1,                       //初始化加载第一页，默认第一页
            pageSize: 10,                       //每页的记录行数（*）
            pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
            uniqueId: "id",                     //每一行的唯一标识，一般为主键列
            showExport: true,
            exportDataType: 'all',
            responseHandler: responseHandler,
            columns: [
                {
                    field: 'id',
                    title: '编号'
                },
                {
                    field : 'name',
                    title : '学生姓名',
                    align : 'center',
                    valign : 'middle',
                    sortable : true
                }, {
                    field : 'age',
                    title : '年龄',
                    align : 'center',
                    valign : 'middle',
                    sortable : true
                }, {
                    field : 'sex',
                    title : '性别',
                    align : 'center',
                    valign : 'middle'
                }, {
                    field : 'classno',
                    title : '班级',
                    align : 'center',
                    valign : 'middle',
                    sortable : true
                }
            ]
        });
    }
    function queryParams(params) {
        var param = {
            orgCode : $("#orgCode").val(),
            userName : $("#userName").val(),
            startDate : $("#startDate").val(),
            endDate : $("#endDate").val(),
            limit : this.limit, // 页面大小
            offset : this.offset, // 页码
            pageindex : this.pageNumber,
            pageSize : this.pageSize
        }
        return param;
    }

    // 用于server 分页，表格数据量太大的话 不想一次查询所有数据，可以使用server分页查询，数据量小的话可以直接把sidePagination: "server"  改为 sidePagination: "client" ，同时去掉responseHandler: responseHandler就可以了，
    function responseHandler(res) {
        if (res) {
            return {
                "rows" : res.result,
                "total" : res.totalCount
            };
        } else {
            return {
                "rows" : [],
                "total" : 0
            };
        }
    }
</script>
</html>