<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/9/7
  Time: 13:32
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
    <title>学生新增</title>
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/hui.css" />
</head>
<body style="background:#FCFCFC;">
<header class="hui-header">
    <div id="hui-back"></div>
    <h1>HUI 表单验证</h1>
</header>
<div class="hui-wrap">
    <form action="<%=path%>/student/addSaveStudent" method="post" onsubmit="return checkvolid();">
        <div style="margin:28px 10px;" class="hui-form" id="form1">
            <div class="hui-form-items">
                <input type="text" class="hui-input hui-input-clear" name="id" placeholder="您的id" value="" checkType="string" checkData="2,10" checkMsg="称呼应为2-10个字符" />
            </div>
            <div class="hui-form-items">
                <input type="number" class="hui-input" name="name" placeholder="名称" checkType="phone" value="" checkMsg="手机号码格式错误" />
            </div>
            <div class="hui-form-items">
                <input type="password" class="hui-input hui-pwd-eye" placeholder="登录密码" checkType="string" id="pwd" checkData="6,20" value="888888" checkMsg="密码应为6-20个字符" />
            </div>
            <div class="hui-form-items">
                <input type="password" class="hui-input hui-pwd-eye" placeholder="确认密码" checkType="sameWithId" checkData="pwd" value="888888" checkMsg="两次密码不一致"  />
            </div>
            <div class="hui-form-items">
                <div class="hui-form-items-title">爱好</div>
                <div class="hui-form-radios" id="loves">
                    <input type="checkbox" value="1" name="aihao[]" id="c1" /><label for="c1">读书</label>
                    <input type="checkbox" value="2" name="aihao[]" id="c2" /><label for="c2">写字</label>
                </div>
            </div>
            <div class="hui-form-items">
                <div class="hui-form-items-title">年份</div>
                <div class="hui-form-select">
                    <select name="" checkType="notSame" checkData="0" checkMsg="请选择年份">
                        <option value="0">年份</option>
                        <option value="2010">2010</option>
                        <option value="2011">2011</option>
                        <option value="2012">2012</option>
                        <option value="2013">2013</option>
                        <option value="2014">2014</option>
                        <option value="2015">2015</option>
                    </select>
                </div>
            </div>
            <div class="hui-form-items" style="padding:5px;">
                <button type="submit" class="hui-button hui-primary hui-fr" id="submit">提交</button>
            </div>
        </div>
    </form>
</div>
<a href="<%=path%>/student/deleteStudent/1">删除1号学生</a>
<a href="<%=path%>/student/findStudent/2">查询2号学生</a>
<script type="text/javascript" src="<%=path%>/js/hui.js"></script>
<script type="text/javascript" src="<%=path%>/js/hui-form.js"></script>
<script type="text/javascript">

    function checkvolid(){
        //验证
        var res = huiFormCheck('#form1');
        console.log(res);
        //提交
        if(res==true){
            hui.iconToast('验证通过！');
            return true;
        }else{
            return false;
        }
    }
    //附加验证函数用于单选多选等特殊检查项目
    function huiFormCheckAttach(){
        var vals = new Array();
        hui('#loves').find('input').each(function(cObj){
            if(cObj.checked){
                vals.push(cObj.value);
            }
        });
        if(vals.length < 1){
            hui.toast('请至少选择一个爱好');
            return false;
        }
        return true;
    }
</script>
</body>
</html>
