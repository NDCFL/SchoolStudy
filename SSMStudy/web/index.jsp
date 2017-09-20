<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.ht.pojo.Plays" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/9/5
  Time: 19:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String path = request.getContextPath();
  Plays play = (Plays) session.getAttribute("plays");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title>SpringMVC学习</title>
  <meta name="robots" content="index, follow" />
  <meta name="googlebot" content="index, follow" />
  <meta property="qc:admins" content="565347177760374526654" />
  <link rel="stylesheet" type="text/css" href="<%=path%>/css/main.css" />
  <link rel="stylesheet" type="text/css" href="<%=path%>/css/font_pe3taublceuerk9.css"></link>
  <link rel="shortcut icon" type="image/x-icon" href="<%=path%>/images/favicon.ico" />
  <script type="text/javascript" src="<%=path%>/js/jquery.js"></script>
  <meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
  <script>
      var _hmt = _hmt || [];
      (function() {var hm = document.createElement("script"); hm.src = "//hm.baidu.com/hm.js?3cecdb545ed6ae876700503d61528301"; var s = document.getElementsByTagName("script")[0]; s.parentNode.insertBefore(hm, s);})();
  </script>
  <style>
    #huiPhoneInDoc{width:80%; height:578px; margin:20px 0px; padding-left:12px; padding-top:72px; background:url(${pageContext.request.contextPath}/images/phone.png) no-repeat top left;}
  </style>
</head>
<body>
<div id="header">
  <div class="cWrap">
    <div id="logo">
      <a href="/"><img src="http://static.hcoder.net/public/images/logo.png" /></a>
    </div>
    <div id="nav">
      <a href="javascript:void(0);" id="navIndex">首页</a>
      <a href="javascript:void(0);" id="navCourse">课程中心</a>
      <a href="javascript:void(0);" id="navShare">问答&amp;分享</a>
      <a href="javascript:void(0);" id="navBook">读书</a>
      <a href="javascript:void(0);" id="navHcwt">公众号框架</a>
      <a href="javascript:void(0);" id="navMui">HUI</a>
      <a href="javascript:void(0);" id="navHjs">H.JS</a>
      <c:if test="<%=play==null%>">
        <a href="<%=path%>/playReg.jsp" id="navHOA">注册</a>
        <a href="<%=path%>/playLogin.jsp" id="loginHeader">+ 登录</a>
      </c:if>
      <c:if test="<%=play!=null%>">
        <a href="javascript:void(0);" onclick="exit();" id="navHOA">安全退出</a>
        <a href="javascript:void(0);" id="loginHeader"><%=play.getPlayNickname()%></a>
      </c:if>
    </div>
  </div>
  <div id="dMenu" class="iconfont icon-caidan"></div>
  <div id="regHeader" style="display:none;" onclick="sReg();"></div>
</div>
<div id="cTopLine"></div>
<div id="HUI_Nav_Menus">
  <a href="javascript:void(0);">课程中心</a>
  <a href="javascript:void(0);">问答&amp;分享</a>
  <a href="javascript:void(0);">读书</a>
  <a href="javascript:void(0);" onclick="sLogin();">注册、登录</a>
  <a href="javascript:closeNavMenu();">关闭菜单</a>
</div><style>
  .cWrap{width:98%;}
  pre.prettyprint{padding:15px; margin-top:10px; margin-bottom:10px; overflow:hidden; word-break:break-all; white-space: pre-wrap; word-wrap:break-word; width:928px !important;}
  pre *{font-size:11px;}
  #footer{width:958px; height:auto; background:#FFFFFF; padding:25px 0px; text-align:center; line-height:32px; border-top:1px solid #D1D1D1;}
  #huiPhone{width:335px; height:650px; background:url(http://www.hcoder.net/public/images/hui/phone.png);  position:fixed; z-index:1; right:20px; top:85px;}
  #header{background:url(http://www.hcoder.net/public/images/cBg.jpg);}
</style>
<div class="huiLeft" id="huiLeft">
  <dl>
    <dt>基本操作</dt>
    <dd><a href="/first/hellow" target="right">Hello</a></dd>
    <dd><a href="/first/cookie" target="right">保存cookie</a></dd>
    <dd><a href="/first/json" target="right">返回json数据</a></dd>
    <dd><a href="/first/fileList" target="right">文件下载</a></dd>
    <dd><a href="/upImg/manyImgAdd" target="right">批量上传图片</a></dd>
    <dd><a href="/upImg/ueditor" target="right">在线编辑器</a></dd>
  </dl>
    <dl>
        <dt>学生操作</dt>
        <dd><a href="<%=path%>/student/studentList" target="right">学生列表</a></dd>
    </dl>
  <dl>
    <dt>用户订单</dt>
    <dd><a href="<%=path%>/users/usersList" target="right">用户列表</a></dd>
  </dl>
  <dl>
    <dt>产品管理</dt>
    <dd><a href="<%=path%>/product/productList" target="right">产品列表</a></dd>
  </dl>
  <dl>
    <dt>道具管理</dt>
    <dd><a href="<%=path%>/prop/propList" target="right">道具列表</a></dd>
  </dl>
  <dl>
    <dt>玩家订单管理</dt>
    <dd><a href="<%=path%>/deal/dealList/<%=play.getPlayId()%>" target="right">装备购买记录</a></dd>
  </dl>
  <dl>
    <dt>金额管理</dt>
    <dd><a href="<%=path%>/money/moneyList/<%=play.getPlayId()%>" target="right">金额列表</a></dd>
  </dl>
</div>
<div class="cWrap" style="padding:18px 0px 20px 0px;" id="docMain">
  <table width="100%" cellspacing="0" cellpadding="0" border="0">
    <tr>
      <td width="200px" valign="top">
        <div style="width:300px;">&nbsp;</div>
      </td>
      <td valign="top">
        <div class="huiContent" style="padding-bottom:38px;">
          <iframe  name="right" src="/studentList.jsp" frameborder="0" scrolling="auto" width="950px" height="700px"></iframe>
        </div>
        <div id="footerLine"></div>
        <div id="footer">
          <a href="/course">教程</a>|
          <a href="/share">交流分享</a>|
          <a href="javascript:void(0);">客服QQ : 275300091</a>|
          <span style="padding-left:12px;">QQ交流群 : 275300091</span>
          <br />
          CopyRight &copy; 2017 - 2020 Hcoder.net - 致力于中国web开发行业发展&nbsp;&nbsp;&nbsp;&nbsp;赣ICP备14004669号-2
        </div>
        <div id="footer2">
          CopyRight &copy; 2017 - 2020 Hcoder.net 赣ICP备14004669号-2<br />
          <a href="javascript:void(0);">客服QQ : 275300091</a>
        </div>
        <div id="footerSD">
          <a href="javascript:void(0);" onclick="sRePwd();" id="sRePwd"></a>
          <a href="javascript:void(0);" onclick="sQqLogin();" id="qqLogin"></a>
        </div>
        <script>
            (function(){
                var bp = document.createElement('script');
                bp.src = '//push.zhanzhang.baidu.com/push.js';
                var s = document.getElementsByTagName("script")[0];
                s.parentNode.insertBefore(bp, s);
            })();
        </script>
      </td>
    </tr>
  </table>
</div>
<script type="text/javascript" src="<%=path%>/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/common.js"></script>
<script type="text/javascript" src="<%=path%>/js/prettify.js" charset="UTF-8"></script>
<script type="text/javascript" src="<%=path%>/js/jquery.zclip.js" charset="UTF-8"></script>
<script type="text/javascript">
    function exit(){
        $.post(
            "${pageContext.request.contextPath}/plays/exit",
            function(data){
                location.href="${pageContext.request.contextPath}/playLogin.jsp"
            },
            "json"
        );
    }
</script>
<script type="text/javascript">
    $(function(){
        $('#navMui').addClass('navSed');
        $('pre').addClass('prettyprint');
        prettyPrint();
        $('#huiDl_268').addClass('huiDlSed');
        resiszedo();
        $(window).resize(function(){resiszedo();});
        var sets = $('#huiDl_268').offset();
        var winHeight = $(window).height();
        $('#huiLeft').scrollTop(sets.top - winHeight / 2 );
    });
    function resiszedo(){
        var winHeight = $(window).height();
        $('#huiLeft').css({height:winHeight - 110});
    }

</script>
</body>
</html>