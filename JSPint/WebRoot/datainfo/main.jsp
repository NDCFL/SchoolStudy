<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="SQLBean.StudentBean"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:wb="http://open.weibo.com/wb">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=1200, initial-scale=device-width/1200, user-scalable=no, minimal-ui">
<title>主页</title>
<meta name="keywords" content="wx589fc89367938" />
<meta name="description" content="" />
<link href="https://static1.51cto.com/edu/css/reset.css?v=2.4.4" rel="stylesheet" type="text/css" />
<link href="https://static1.51cto.com/edu/css/style.css?v=2.4.4" rel="stylesheet" type="text/css" />
<script>var imgpath = "https://static1.51cto.com/edu/images/";</script>
<script type="text/javascript" src="https://static1.51cto.com/edu/js/jquery.min.js?v=2.4.4"></script>
<script type="text/javascript" src="https://static1.51cto.com/edu/js/msgbox.js?v=2.4.4"></script>
<script type="text/javascript" src="https://static1.51cto.com/edu/js/nav.js?v=2.4.4"></script>
<script type="text/javascript" src="https://static1.51cto.com/edu/js/mbox.js?v=2.4.4"></script>
<script type="text/javascript" src="https://static1.51cto.com/edu/js/allpageevent.js?v=2.4.4"></script>
<!-- 通用顶部简导航 -->
<link rel="stylesheet" type="text/css" href="https://static1.51cto.com/edu/css/gen_top.css?v=2.2.80">
<script type="text/javascript" src="https://static1.51cto.com/edu/js/gen_top.js?v=2.2.80"></script>
<!-- New Header -->
<link rel="stylesheet" type="text/css" href="https://static1.51cto.com/edu/css/../center/css/base.css?v=2.4.4">
<link type="text/css" href="https://static1.51cto.com/edu/css/whitestyle.css?v=2.4.4" rel="Stylesheet" />
<script type="text/javascript">
var gen_logo = '';
</script>
</head>
<body>

<div class="GenTopHeader" style="margin-top: 0px;">
    <ul class="Page"  id="GenTopBar"><li class="fl f14" id="Til"><a href="<%=basePath %>mainservlet?order=main">中国最大的IT技能学习平台</a></li>
        <li class="fr navi"><a  target="_blank" style="background-color:none;">网站导航</a>
            <ul class="navigates">
                <li><a href="<%=basePath %>courselistservlet?order=list" target="_blank">首页</a></li>
                <li><a href="<%=basePath %>datainfo/login.jsp" target="_blank">登录界面</a></li>
                <li style="border-bottom: 1px solid #FFF;"><a href="<%=basePath %>datainfo/zhuce.jsp" target="_blank">注册界面</a></li>
                <li><a href="<%=basePath %>studentservlet?order=teacher&studentname=${studentbean.studentname}" target="right">申请开课</a></li>
                <li><a href="<%=basePath %>mainservlet?order=face" target="_blank">IT课堂主站</a></li>
            </ul>
        </li>
        <li class="fr"><a target="_blank" href="<%=basePath %>loginservlet?order=loginin&name=${studentbean.studentmobile}">学习中心</a></li>
        <li class="fr apps"><a href="<%=basePath %>datainfo/app.jsp" target="_blank" style="background:none;">课堂APP</a>
            <ul>
                <li><a href="<%=basePath %>datainfo/app.jsp" target="_blank">Android</a></li>
                <li><a href="<%=basePath %>datainfo/app.jsp target="_blank">iPhone</a></li>
                <li><a href="<%=basePath %>datainfo/app.jsp  target="_blank">iPad</a></li>
            </ul>
        </li>
        <li class="fr reg"><a href="<%=basePath %>datainfo/zhuce.jsp" target="_blank">注册</a></li>
        <li class="fr"><a href="datainfo/login.jsp">登录</a></li>
        <li class="fr"><p><a href="<%=basePath %>loginservlet?order=exit">${studentbean.studentname}<font color="red">【安全退出】</font></a></p></li>
    </ul>
</div>        <ul class="FixedSideBar">
        <li class="FixedSideBar_Spree">
        </li>
        <li class="FixedSideBar_iPad">
            <ul class="reddot"></ul>
            <p>APP下载</p>
            <div class="FixedSideBar_SSS"></div>
            <div class="FixedSideBar_iPad_QrCode">
                <a href="<%=basePath %>courselistservlet?order=app"><img src="<%=basePath %>image/big.png" style="width:90px;" /></a>
                <div class="tc">下载学院APP<br />缓存视频离线看</div>
            </div>
        </li>
        <li class="FixedSideBar_FeedBack">
            <p><a href="<%=basePath %>courselistservlet?order=fankui" target="_blank">意见反馈</a></p>
        </li>
        <li class="FixedSideBar_GoTop">
            <p>返回顶部</p>
        </li>
    </ul>
    
<div class="pagebg" style="width: 100%;background: #fff;">
    <div class="Page" style="height:90px;">
        <a href="<%=basePath %>courselistservlet?order=list" target="_blank">
            <img src="<%=basePath %>image/bg2.jpg" />
        </a>
    </div>
</div>
<div class="Header">
    <div class="Page">
        <div class="Logo fl">
            <a href="<%=basePath %>courselistservlet?order=list" title="IT课堂"><img src="<%=basePath %>image/itlogo.png" class="fl"></a>
        </div>
            <ul class="Navigate fl">
            <li><a href="<%=basePath %>courselistservlet?order=list">首页</a></li>
            <li><a href="<%=basePath %>courselistservlet?order=study" target="_blank">微职位培训</a></li>
            <li><a  target="_blank">视频课程</a></li>
            <li><a  target="_blank">套餐</a></li>
            <li><a  target="_blank">职业路线图</a></li>
            <li><a  target="_blank">企业学习</a></li>
            <li><a   target="_blank">免费试听</a></li>
            <li>
              <p class="min_more">线下学习</p>
              <div class="min_more">
                  <a target="_blank" >IT训练营</a>
                  <a target="_blank" >IT峰会</a>
                  <a target="_blank" >IT集训</a>
              </div>
            </li>
        </ul>
    </div>
</div>
<style type="text/css">
	.w960	{width:1190px;}
</style>
<div class="cont w960">
<c:if test="${msg!=null}">
	<script type="text/javascript">
		alert("${msg}");
	</script>
</c:if>
<%StudentBean studentBean = (StudentBean)session.getAttribute("bean"); %>
  <div class="lecturer_li">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tbody><tr>
		<td width="210" align="center" valign="top" class="p_left">
			<div class="ConsoleLeft fl">
    <div class="ConsoleLeft_userInfo">
        <a href="<%=basePath %>studentservlet?order=update&studentname=${studentbean.studentname}" title="点击进入家园" target="right"><img alt="进入家园" src="<%=studentBean.getStudentface() %>"  width="120" height="120"></a>
        <p class="tc">
            <a href="<%=basePath %>studentservlet?order=update&studentname=${studentbean.studentname}" title="点击进入家园" target="right">${studentbean.studentmobile}</a>
        </p>
            <p>余额：<span class="red">${moneybean.summoney}</span>元</p>
            <p><a href="<%=basePath %>datainfo/chongzhimoney.jsp?userid=${studentbean.studentid}" target="_blank" class="red" style="text-decoration:underline;">去充值</a></p>
            <p><a href="<%=basePath %>systemvo/page1.jsp?studentname=${studentbean.studentname}" target="right" class="blue" style="text-decoration:underline;">修改头像</a></p>
            <p>学霸排行：<a  class="red" target="_balnk" style="text-decoration:underline;">8000</a>名外</p>
        <dl class="NewLeftNav">
        <dt class="NewLeftNav_S">我的学习</dt>
        <dd id="cur_course"><a href="<%=basePath %>courselistservlet?order=list" >课程列表</a></dd>
        <dd id="cur_favorite"><a href="<%=basePath %>courselistservlet?order=mycar" target="right">我的购物车</a></dd>
        <dd id="cur_course"><a href="<%=basePath %>payrecodeservlet?order=list&studentid=${studentbean.studentid}" target="right" style="position:relative;">已买的课程宝贝 <img src="https://static1.51cto.com/edu/images/whitestyle/new_icon_2.png" style="position: absolute;top: 14px;left: 115px;"></a></dd>
        <dd id="cur_favorite"><a href="<%=basePath %>studentservlet?order=update&studentname=${studentbean.studentname}" target="right" >修改资料</a></dd>
        <dd id="cur_course"><a href="<%=basePath %>data/oldstudentpwd.jsp?studentname=${studentbean.studentname}" target="right" >修改密码</a></dd>
        <dd id="cur_ask"><a href="<%=basePath %>studentservlet?order=teacher&studentname=${studentbean.studentname}" target="right" >申请讲师资格</a></dd>
        <dd id="cur_favorite"><a href="<%=basePath %>moneyservlet?order=list&username=${studentbean.studentname}" target="right">充值明细</a></dd>
        <dd id="cur_ask"><a href="<%=basePath %>studentservlet?order=summoney&username=${studentbean.studentname}" target="right">我的余额</a></dd>
        <dd id="cur_code"><a href="<%=basePath %>studentservlet?order=zhifucenter&username=${studentbean.studentname}" target="_blank">支付中心</a></dd>
        <dd id="cur_code"><a href="<%=basePath %>data/checkpwd.jsp?username=${studentbean.studentname}" target="right">设置支付密码</a></dd>
        <dd id="cur_mycoupon"><a href="<%=basePath %>data/checkpassword.jsp?username=${studentbean.studentname}" target="right">修改支付密码</a></dd>
        <dd id="cur_note"><a href="<%=basePath %>newmsgservlet?order=studentlist" target="right">通知公告</a></dd>
        <dd id="cur_ask"><a href="<%=basePath %>courselistservlet?order=studentliuyanlist&id=${studentbean.studentid}" target="right">在线回复</a></dd>
        <div class="ConsoleLeft_Tag_p" style="min-height:20px;">
       </div>
</div>
<script>
     var cur = "index" || "index";
     $("#cur_"+cur).addClass("NewLeftNavCur");
</script>

        </td>
        <td valign="top" class="p_right">
			<div class="admin">
			  <iframe  rameborder="0" src="<%=basePath %>studentservlet?order=update" name="right" width="1000" height="920px"></iframe>
			</div>
        </td>
      </tr>
    </tbody></table>
  </div>
</div>
<script type="text/javascript">
var imgpath		=	'https://static1.51cto.com/edu/images/';
//删除按钮
function DelOne(lession_id){
	var me = this;
  new AutoBox({
    content:'确定删除此学习记录？',
    img:'quest',
    mask:true,
    Yes:'确定',
    No:'取消',
    yc:function(){
      var t = 300;
      $.post(
        '/index.php?do=user&m=delUserLessionLog',
        {'lession_id':lession_id},
        function(data){
          if(data==-1){
            location.href='/index.php?do=msg&m=index&msg=no_login';
          }else if(data == 1){
            alert("删除成功！");
            location.reload(); 
          }else if(data == 0){
            alert("删除失败！");
          }
        }
      );
    }
  })
}

/**
 * 下面是一些基础函数，解决mouseover与mouserout事件不停切换的问题（问题不是由冒泡产生的）
 */
function checkHover(e, target) {
    if (getEvent(e).type == "mouseover") {
        return !contains(target, getEvent(e).relatedTarget
                || getEvent(e).fromElement)
                && !((getEvent(e).relatedTarget || getEvent(e).fromElement) === target);
    } else {
        return !contains(target, getEvent(e).relatedTarget
                || getEvent(e).toElement)
                && !((getEvent(e).relatedTarget || getEvent(e).toElement) === target);
    }
}

function contains(parentNode, childNode) {
    if (parentNode.contains) {
        return parentNode != childNode && parentNode.contains(childNode);
    } else {
        return !!(parentNode.compareDocumentPosition(childNode) & 16);
    }
}
//取得当前window对象的事件
function getEvent(e) {
    return e || window.event;
}
</script>
<div class="Footer">
    <div class="Page">
        <table class="QRcode tc">
            <caption>
                <a href="" title="It课堂"><img src="<%=basePath %>image/itlogo.png" alt="学院" width="194" height="40"/>
            </caption>
            <tr>
                <td>
                    <img src="https://static1.51cto.com/edu/css/../center/images/qrcode.png" alt="学院APP" width="110" height="110"/>
                    <p>学院APP</p>
                </td>
                <td>
                    <img src="https://static1.51cto.com/edu/css/../center/images/qrcode2.png" alt="官方微信" width="110" height="110"/>
                    <p>官方微信</p>
                </td>
            </tr>
        </table>
        <div class="Info fl">
            <div class="Map">
				<a href="<%=basePath %>courselistservlet?order=guanyu" target="_blank">关于我们</a>
                <span>|</span>
                <a href="<%=basePath %>courselistservlet?order=help" target="_blank">帮助中心</a>
                <span>|</span>
                <a href="<%=basePath %>courselistservlet?order=fankui1" target="_blank">意见反馈</a>
                <span>|</span>
                <a href="<%=basePath %>courselistservlet?order=lianxi" target="_blank"  title="联系我们">联系我们</a>
                <span>|</span>
                <a href="<%=basePath %>courselistservlet?order=dengji" target="_blank">课程登记</a>
                <span>|</span>
                <a href="<%=basePath %>courselistservlet?order=gushi" target="_blank">学员故事</a>
                <span>|</span>
                <a href="<%=basePath %>courselistservlet?order=jiaoliu" target="_blank"  title="学员交流">学员交流</a>            
            </div>            
            <p class="Call fl red">176-0797-5702</p>
            <p class="fl callTime">09:00 - 19:00</p>
            <div class="clear"></div>
            <p class="copy">Copyright &copy; 2017-2027 <a href="http://www.51cto.com/" target="_blank">lledu.com</a></p>
        </div>
        <div class="clear"></div>
    </div>
</div>
<div class="mask disp-n" id="AdviceMask"></div>
<div class="Advice disp-n" id="Advice">
    <div class="Main">
        <button class="close" onclick="$('#AdviceMask').hide();$('#Advice').hide();">&nbsp;</button>
        <button id="bizQQ_WPA">&nbsp;</button>
        <h3>可以开发票么？</h3>
        <p>可以的，购买课程或者充值余额后都是可以开具发票的，具体详情点击：<a href="http://bbs.51cto.com/thread-1472105-1.html" target="_blank">我要开发票</a></p>
        <h3>购买的课程可以下载么？</h3>
        <p>目前PC端暂不支持下载课程视频，请手机或者平板电脑下载“学院”APP后再下载视频哦！</p>
        <h3>优惠券如何使用？</h3>
        <p>非折扣课程（不包含1元课程/套餐）可使用，一个订单（可包含多个课程）只可使用一张；优惠券一经使用，不再返还；若被冻结请在PC端删除订单即可返还。</p>
        <p class="mt20">更多问题查询点击 <a href="http://edu.51cto.com/help.html" target="_blank">帮助中心</a></p>
        <p class="mt10">欢迎您提供宝贵意见，对于您的意见我们都会认真、慎重的讨论，每一个意见都是我们更好为您服务的鞭策和激励，感谢您帮助学院成长，<a href="http://edu.51cto.com/user/feedback.html" target="_blank">我要反馈意见</a></p>
    </div>
</div>
<script type="text/javascript">
$("#bizQQ_WPA").click(function(){
    window.open('http://edu.51cto.com/contactqq.html')
})
</script>

<script type="text/javascript" src="https://static1.51cto.com/edu/js/edu-ad.js?v=20161009"></script>
<script type="text/javascript" src="https://static1.51cto.com/edu/js/edu_header.js?v=1.2.2"></script>
<!----------------------数据分析  begin --------------------->
<script type="text/javascript">
    var sessionid = "9ap5qeobn6pff8gkabol4u44m5",
            ip = "182.97.87.71",
            user_id = "12569085",
            source = 0;
</script>
<script type="text/javascript" src="https://static1.51cto.com/edu/js/md5.js"></script>
<script type="text/javascript" src="https://static1.51cto.com/edu/js/tract_public.js?v=10.21"></script>
<script type="text/javascript" src="https://static1.51cto.com/edu/js/pv_tract.js?v=2016092803"></script>
<!----------------------数据分析  end -------------------->
<span style="display:none;">
<script src="https://logs.51cto.com/rizhi/count/count.js"></script>
</span>




<!--qiaohaun-->
<script type="text/javascript"> document.write(unescape("%3Cscript src='https://tongji.51cto.com/cto.js/b57176900a4805e17afc7b8e25a43abf' type='text/javascript'%3E%3C/script%3E")); </script>

<script type="text/javascript">
//百度统计代码
var _hmt = _hmt || [];
(function() {
  var hm = document.createElement("script");
  hm.src = "https://hm.baidu.com/hm.js?8c8abdb71d78d33dfdb885e0bc71dae0";
  var s = document.getElementsByTagName("script")[0]; 
  s.parentNode.insertBefore(hm, s);
})();
</script>
</body>
</html>
