<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="pragma" content="no-cache" />
<title>乐家具商城登录界面</title>
<link rel="shortcut icon" href="http://image.meilele.com/favicon.ico" />
<link rel="icon" href="http://image.meilele.com/favicon.ico" />
<link rel="stylesheet" href="http://image.meilele.com/css/mll.common.new.min.css?20161107" /><style type="text/css">
    .inline_block{display:inline-block;*zoom=1}.yahei{font-family:"Microsoft YaHei","SimHei"}.clearfix:after{content:" ";display:block;clear:both;height:0}
.clearfix{zoom:1}.none{display:none}.user_header .nav{width:180px;padding-top:40px;text-align:right}header{position:relative;width:1190px;margin:0 auto;text-align:left}
.main{padding:72px 0;min-width:1190px}.bg-red{background:#cf000e}aside{position:relative;width:306px;min-height:400px;background:#fff;padding:27px}.main .content{margin:0 auto;width:1070px;position:relative}
.switch-type{position:relative;width:306px;overflow:hidden}.main .content aside .login-switch{position:relative;font-size:16px;font-weight:bold;color:#888;border-bottom:1px solid #d1d1d1;width:459px}
.main .content aside .login-switch li{position:relative;float:left;width:153px;text-align:center;padding:13px 0;cursor:pointer}.main .content aside .login-switch .i-new{position:absolute;top:4px}
.main .content aside .login-switch li.on{margin-bottom:-1px;color:#cf000e;border-bottom:2px solid #cf000e}.main .content aside .login-switch .switch-mobile{color:#333;text-align:left;margin-bottom:-1px;border-bottom:2px solid #fff}
.main .content aside .login-form{width:306px;overflow:hidden;position:relative}.main .content aside .login-form .login-type{position:relative;width:918px;left:-306px}
.main .content aside .login-form .login-weixin,.main .content aside .login-form .login-pwd,.main .content aside .login-form .login-mobile,.main .content aside .login-form .login-account,.main .content aside .login-form .login-quick{width:306px}
.main .content aside .login-form .login-weixin{height:298px;padding-top:53px;text-align:center}.main .content aside .login-form .qr-code{position:relative}
.main .content aside .login-form .qr-code .qr-mark{position:absolute;background:rgba(0,0,0,.5);width:174px;height:174px;left:66px;top:0}.main .content aside .login-form .qr-mark i{display:block;width:48px;height:48px;background:url('http://image.meilele.com/themes/paipai/images/allPuzzle.png') -123px -53px no-repeat;margin:63px auto 0}
.main .content aside .login-form .login-pwd{padding-top:25px}.main .content aside .login-form .login-pwd{padding-top:25px}.main .content aside .login-form .login-mobile{padding-top:12px}
.main .content aside .login-form .input-group{position:relative;height:40px;border:1px solid #ddd;overflow:hidden;line-height:40px}.main .content aside .login-form .input-group input{float:left;height:20px;font-size:13px;width:254px;border:0;padding:10px 0;margin:0}
.main .content aside .login-form .input-group .i-user{float:left;width:19px;height:19px;background:url('http://image.meilele.com/themes/paipai/images/allPuzzle.png') 0 -30px no-repeat;margin:10px}
.main .content aside .login-form .input-group .i-pwd{float:left;width:19px;height:19px;background:url('http://image.meilele.com/themes/paipai/images/allPuzzle.png') -21px -30px no-repeat;margin:10px}
.main .content aside .login-form .input-group .i-captcha{float:left;width:19px;height:19px;background:url('http://image.meilele.com/themes/paipai/images/allPuzzle.png') -42px -30px no-repeat;margin:10px}
.main .content aside .login-form .input-group .i-phone{float:left;width:19px;height:20px;background:url('http://image.meilele.com/themes/paipai/images/allPuzzle.png') -63px -30px no-repeat;margin:10px}
.main .content aside .login-form .input-group .refresh-btn{color:#4a92f5}.main .content aside .login-form .input-group .refresh-btn:hover{text-decoration:none;color:#4a92f5!important}
.login-pwd .checkbox-group{height:21px;line-height:21px}.login-pwd .checkbox-group .i-checkbox{float:left;width:21px;height:21px;background:url('http://image.meilele.com/themes/paipai/images/allPuzzle.png') -84px -30px no-repeat;margin-right:4px;cursor:pointer}
.login-pwd .checkbox-group .i-checkbox.checked{background-position:-107px -30px}.login-pwd .checkbox-group .remchk{display:none}.submit-btn{display:block;height:42px;line-height:42px;background-color:#cf000e;text-align:center;font-size:16px;font-weight:bold;color:#fff;border-radius:3px;margin:10px 0 0}
.submit-btn:hover{text-decoration:none;color:#fff!important}.regist-group{margin:20px 0 30px}.regist-group a:hover{text-decoration:none;color:#4a92f5!important}
.captcha-img{margin:5px}.checkbox-group{font-size:13px}.other-group .other-login{width:179px;border-right:1px solid #e6e6e6}.other-group .mobile-login{padding-left:20px;_padding-left:10px}
.other-group dt{margin-bottom:10px}.i-qq,.i-weibo,.i-weixin,.i-zhifubao,.i-taobao,.i-mobile{display:block;width:28px;height:28px;margin-right:5px;background:url('http://image.meilele.com/themes/paipai/images/allPuzzle.png') no-repeat}
.i-qq{background-position:0 0}.i-weibo{background-position:-28px 0}.i-weixin{background-position:-56px 0;cursor:pointer}.i-zhifubao{background-position:-86px 0}
.i-taobao{background-position:-114px 0}.i-mobile{background-position:-143px 0}.main .content aside .login-form .sms-btn{background:#f0f0f0;color:#333;height:34px;width:110px;text-align:center;line-height:34px;border-radius:3px;margin-top:3px}
.main .content aside .login-form .sms-btn:hover{color:#333!important;text-decoration:none}.main .content aside .login-form .sms-disabled{color:#999!important;cursor:default!important}
.main .content aside .login-form .sms-disabled:hover{color:#999!important}.input_error{background-color:#fff3f3;border-color:#c9033b!important;color:#c9033b}
.input_error input{border-color:#fff3f3!important;background-color:#fff3f3;color:#c9033b!important}.error_tip{font-size:12px;margin:5px 0 4px}.black{color:#333!important}
.gray{color:#b2b2b2}.select-username{position:relative}.select-username ul{box-sizing:border-box;position:absolute;background:#fff;width:306px;border:1px solid #ddd;border-top:0;left:-1px;top:40px;*top:41px;z-index:10}
.select-username ul li{padding:2px 5px;height:42px;line-height:40px;cursor:pointer}.select-username ul li:hover{background:#ededed}.select-icon{position:absolute;display:block;overflow:hidden;background:url('http://image.meilele.com/images/login-select-icon.png');width:16px;height:9px;top:16px;right:11px;_right:41px;background-position-y:-9px;cursor:pointer}
#JS_username{_display:block}.icon-open{background-position-y:0}.third-party .content .bind-tips{text-align:center;font-size:14px;color:#555;margin-bottom:30px}
.third-party .content .bind-tips span{color:#e62318}.third-party .content aside{border:1px solid #ddd;min-height:398px;width:304px}.third-party .content{padding:0 75px;width:920px}
.third-party .content aside .login-switch{width:306px}.third-party .content aside .login-form .login-account{width:306px}.third-party .content aside .login-form .login-type{width:612px;left:0}
.third-party .content aside .login-form .login-account,.third-party .content aside .login-form .login-quick{padding-top:25px}.third-party .content aside .login-form .other-group{text-align:right;margin-top:20px}
.third-party .content aside .login-form .other-group span{color:#666}.third-party .content aside .login-form .other-group a{color:#4a92f5}.third-party .content aside .login-form .other-group a:hover{color:#4a92f5!important;text-decoration:none}
.third-party .content aside .third-party-header{font-size:16px;color:#666;font-weight:bold;padding:13px 0;border-bottom:1px solid #d1d1d1}.third-party .content aside .third-party-body .third-party-avatar{margin-top:90px;text-align:center}
.third-party .content aside .third-party-username{text-align:center;color:#333;margin:20px;font-size:14px}.third-party .content .arrow{position:relative;top:202px;left:64px;width:72px;height:49px;background:url('http://image.meilele.com/themes/paipai/images/allPuzzle.png') 0 -50px no-repeat}
.third-party-header .t-logo{float:left;width:20px;height:20px;background:url('');margin-right:6px;margin-top:1px}.third-party-header .tl1{background-position:-20px 0}
.third-party-header .tl3{background-position:-60px 0}.third-party-header .tl4{background-position:-40px 0}.third-party-header .tl8{background-position:-80px 0}
/*jinzeze*227743:2016-09-01 18:30:49*/</style>
<script>if(/ipad_from=1/.test(location.search+location.hash+document.cookie)||window._ipad_from){window._ipad_from=true;window.__notAd=1;window._not_back_to_top=true;}window.getCookie=function(a){var e;if(document.cookie&&document.cookie!==""){var d=document.cookie.split(";");var f=d.length;for(var c=0;c<f;c++){var b=d[c].replace(/(^\s*)|(\s*$)/g,"");if(b.substring(0,a.length+1)==(a+"=")){e=decodeURIComponent(b.substring(a.length+1));break;}}}return e;};window.setCookie=function(a,e,d,c,g){d=d||365;g=g||"/";var b=location.host.split(".");if(b.length==3){b.shift();}c=c?";domain="+c:(";domain=."+(b.join(".")));var f=new Date();f.setTime(f.getTime()+parseInt(d,10)*24*60*60*1000);document.cookie=a+"="+encodeURIComponent(e)+(d=="session"?"":";expires="+f.toGMTString())+c+";path="+g;};window._mllga=function(a){var g=(Math.random()+"").replace("0.","").substr(0,9)-0;var e=parseInt(new Date()/1000);var d=(Math.random()+"").replace("0.","").substr(0,9)-0;var f={utmwv:"5.6.0dc",utms:1,utmn:g,utmhn:location.host,utme:"8(COOKIE)9("+document.cookie.replace(/[()]/g,"")+")11(2)",utmcs:"UTF-8",utmdt:"notset",utmhid:e,utmp:location.host+location.pathname+location.search,utmht:+new Date(),utmac:"UA-48396005-1",utmcc:"__utma=165027242."+d+"."+e+"."+e+"."+e+".1;+__utmz=165027242."+e+".1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none)"};for(var c in a){if(a[c]!==undefined){f[c]=a[c];}}var h=[];for(var c in f){h.push(c+"="+encodeURIComponent(f[c]));}var b=new Image();b.src="http://stats.g.doubleclick.net/__utm.gif?"+h.join("&");};(function(){window.onerror=function(e,d,b){window.onerror._root=window.onerror._root||{};var c=encodeURIComponent(e+"").replace(/\W/g,"");if(window.onerror._root[c]){return;}_mllga({utme:"8(COOKIE)9("+document.cookie.replace(/[()]/g,"")+")11(2)",utmdt:navigator.userAgent+"||"+e+"||"+d+"||"+b,utmac:"UA-48396005-1"});window.onerror._root[c]=true;};var a=function(){setTimeout(function(){window._gaq=window._gaq||[];window._ana=window._ana||[];if(_ana.push==Array.prototype.push){throw new Error("亲，_ana未初始！");}if(_gaq.push==Array.prototype.push){throw new Error("亲，_gaq未初始！");}},10000);};if(window.addEventListener){window.addEventListener("load",a,false);}else{if(window.attachEvent){window.attachEvent("onload",a);}}})();(function(){if(window.__notAd){return;}var c=document.createElement("script");c.type="text/javascript";c.async=true;var b=document.getElementsByTagName("script")[0];var a=new Date();c.src="http://image.meilele.com/js/recad.min.js?"+a.getFullYear()+a.getMonth()+a.getDate();b.parentNode.insertBefore(c,b);})();window._gaq=window._gaq||[];window.MLLgaq=window.MLLgaq||[];window._onReadyList=window._onReadyList||[];window._ana=window._ana||[];_ana.baseTime=_ana.baseTime;_gaq.push(["_setAccount","UA-10173353-1"]);_gaq.push(["_setDomainName","meilele.com"]);(function(i){if(getCookie("MLL_CID")){_gaq.push(["_setCustomVar",1,"CID",getCookie("MLL_CID"),2]);}var l=(location.search+"").replace("?","").split("&");var g={};for(var b=0,a=l.length;b<a;b++){var j=l[b].split("=");g[j[0]]=j[1];}var h=((location.hash+"").replace("#","")).split("#")[0].split("&");for(var b=0,a=h.length;b<a;b++){var j=h[b].split("=");h[j[0]]=j[1];}var f="";if(location.pathname.indexOf("/category-9999/")>=0&&g.keywords){f=g.keywords;}else{if(h.kw||g.kw){f=h.kw||g.kw;}}try{f=decodeURIComponent(f);}catch(c){}if(f&&window._ana){_ana.push(["trackEvent","siteSearch",f]);}})(window);(function(){if(window._IS_GET_TAG){return;}window._IS_GET_TAG=true;var b="utag";var a=18;if(/^\/article/i.test(location.pathname)){b="atag";}window._onReadyList=window._onReadyList||[];_onReadyList.push(function(){$.ajax({url:"/java_api/jmll/tag/getTag.do?u="+encodeURIComponent(location.pathname),cache:true,dataType:"json",success:function(o){var e=$.cookie(b)||"";var n=o||{};var h={},i=[],c=[],j=[];var m=function(k){k=k-0;k="00"+k.toString(36);return k.substr(k.length-2,2);};e=e.split("*");for(var g=0,d=e.length;g<d;g++){if(e[g]&&e[g].length==5){var l=e[g].substr(0,3);var f=parseInt(e[g].substr(3,2),36);h[l]={key:l,number:f};i.push(h[l]);}}for(var g in n){if(h[g]){h[g].number+=n[g];}else{h[g]={key:g,number:n[g]};}h[g].thisPage=true;c.push(h[g]);}c.sort(function(p,k){return k.number-p.number;});for(g=0,d=c.length;g<d;g++){j.push(c[g].key+m(c[g].number));}for(g=0,d=i.length;g<d;g++){if(!i[g].thisPage){j.push(i[g].key+m(i[g].number));}}if(j.length>a){j.length=a;}$.cookie(b,j.join("*"),{expires:90,domain:".meilele.com",path:"/"});window._SITETAGS={tags:h,thisPageTag:n};if(window._SITETAGSCALLBACK){_SITETAGSCALLBACK(_SITETAGS);}}});});})();(function(){if(!window.getCookie("MLL_CID")||!window.getCookie("MA_si")){new Image().src="/_b.gif?_="+new Date().getTime().toString(36);}var b=parseInt(window.getCookie("_SC_"))||0,a=parseInt(window.getCookie("_SD_"))||0;if(!window.getCookie("_SC_")){new Image().src="/_c.gif?_="+new Date().getTime().toString(36);}else{!a&&window.setCookie("_SC_",b+1,3650,".meilele.com");}window.setCookie("_SD_",a+1,"session",".meilele.com");})();
/*leihao:2016-11-21 17:46:13*//*laidezhong:2014-12-02 19:44:58*/</script>
<script>!function(a,b){function c(a,b){var c=a.createElement("p"),d=a.getElementsByTagName("head")[0]||a.documentElement;return c.innerHTML="x<style>"+b+"</style>",d.insertBefore(c.lastChild,d.firstChild)}function d(){var a=t.elements;return"string"==typeof a?a.split(" "):a}function e(a,b){var c=t.elements;"string"!=typeof c&&(c=c.join(" ")),"string"!=typeof a&&(a=a.join(" ")),t.elements=c+" "+a,j(b)}function f(a){var b=s[a[q]];return b||(b={},r++,a[q]=r,s[r]=b),b}function g(a,c,d){if(c||(c=b),l){return c.createElement(a)}d||(d=f(c));var e;return e=d.cache[a]?d.cache[a].cloneNode():p.test(a)?(d.cache[a]=d.createElem(a)).cloneNode():d.createElem(a),!e.canHaveChildren||o.test(a)||e.tagUrn?e:d.frag.appendChild(e)}function h(a,c){if(a||(a=b),l){return a.createDocumentFragment()}c=c||f(a);for(var e=c.frag.cloneNode(),g=0,h=d(),i=h.length;i>g;g++){e.createElement(h[g])}return e}function i(a,b){b.cache||(b.cache={},b.createElem=a.createElement,b.createFrag=a.createDocumentFragment,b.frag=b.createFrag()),a.createElement=function(c){return t.shivMethods?g(c,a,b):b.createElem(c)},a.createDocumentFragment=Function("h,f","return function(){var n=f.cloneNode(),c=n.createElement;h.shivMethods&&("+d().join().replace(/[\w\-:]+/g,function(a){return b.createElem(a),b.frag.createElement(a),'c("'+a+'")'})+");return n}")(t,b.frag)}function j(a){a||(a=b);var d=f(a);return !t.shivCSS||k||d.hasCSS||(d.hasCSS=!!c(a,"article,aside,dialog,figcaption,figure,footer,header,hgroup,main,nav,section{display:block}mark{background:#FF0;color:#000}template{display:none}")),l||i(a,d),a}var k,l,m="3.7.3",n=a.html5||{},o=/^<|^(?:button|map|select|textarea|object|iframe|option|optgroup)$/i,p=/^(?:a|b|code|div|fieldset|h1|h2|h3|h4|h5|h6|i|label|li|ol|p|q|span|strong|style|table|tbody|td|th|tr|ul)$/i,q="_html5shiv",r=0,s={};!function(){try{var a=b.createElement("a");a.innerHTML="<xyz></xyz>",k="hidden" in a,l=1==a.childNodes.length||function(){b.createElement("a");var a=b.createDocumentFragment();return"undefined"==typeof a.cloneNode||"undefined"==typeof a.createDocumentFragment||"undefined"==typeof a.createElement}()}catch(c){k=!0,l=!0}}();var t={elements:n.elements||"abbr article aside audio bdi canvas data datalist details dialog figcaption figure footer header hgroup main mark meter nav output picture progress section summary template time video",version:m,shivCSS:n.shivCSS!==!1,supportsUnknownElements:l,shivMethods:n.shivMethods!==!1,type:"default",shivDocument:j,createElement:g,createDocumentFragment:h,addElements:e};a.html5=t,j(b),"object"==typeof module&&module.exports&&(module.exports=t)}("undefined"!=typeof window?window:this,document);
/*mazengliang:2016-06-16 14:49:59*/</script>
<style>
    .ipad_root,.c-mask {min-width: 1190px;}
</style>
<c:if test="${msg!=null}">
	<script type="text/javascript">
		alert("${msg}");
	</script>
</c:if>
</head>
<body>
<header class="login-header">
    <div id="" class="user_header clearfix" style="padding:15px 0px;">
	<div class="logo Left" style="background: url(<%=basePath %>images/face.png) 0 0 no-repeat;width:160px;height:52px"><a href="/" title="返回美乐乐首页"><img style="background:none" src="http://image.meilele.com/images/blank.gif" width="160" height="52" border="0" alt="美乐乐"></a></div>
	<div id="" class="nav Right">
		<a href="<%=basePath %>data/face.jsp">返回首页</a>
		|
		<a href="/article_cat-4/article-656.html" target="_blank">帮助中心</a>
	</div>
</div></header>
<div class="main bg-red">
    <div class="content clearfix">
        <article class="Left">
            <a href="<%=basePath %>data/face.jsp" title="体验馆6周年庆" target="_blank">
                <img alt="体验馆6周年庆" src="<%=basePath %>images/bg.png" style="background-color:transparent;" width="620" height="454"  />
            </a>
        </article>
        <aside class="Right" id="JS_loginForm">
            <form action="<%=basePath %>loginservlet?order=login" method="post" name="form1">
            	<div class="yahei">
                <div class="switch-type">
                    <ul class="login-switch clearfix">
                        <li class="switch-acount JS_switch-key on" data-switch-index="1">账号登录</li>
                    </ul>
                </div>
                <div class="login-form">
                    <div class="login-type clearfix">
                        
                        <div class="login-weixin Left">
                            <div class="qr-code">
                                <img id="JS_QR_CODE" src="" alt="" width="174" height="174">
                            </div>
                        </div>
                        
                        <div id="JS_login_pwd" class="login-pwd Left">
                            <div class="input-group select-username" style="overflow:inherit">
                                <label class="i-user" for="username"></label>
                                <input class="yahei gray" name="username" type="text">
                            </div>
                            <p class="error_tip red">&nbsp;</p>
                            <div class="input-group">
                                <label class="i-pwd" for="password"></label>
                                <input class="yahei black" name="password" type="password" AutoComplete="off">
                            </div>
                            <p class="error_tip red">&nbsp;</p>

                            <div class="input-group none">
                                <label class="i-captcha" for="captcha"></label><input maxlength="4" class="Left yahei gray" name="captcha" type="text" style="width:150px">
                                <a class="Left" href="javascript:void(0);"><img class="captcha-img" width="60" height="30" id="JS_validCode"  src="http://img004.mllres.com/themes/paipai/images/blank.gif" title="看不清换一张" alt="验证码"/></a>
                                <a class="Left refresh-btn" href="javascript:void(0);" id="JS_refreshBtn">换一张</a>
                            </div>
                            <p class="error_tip red none">&nbsp;</p>

                            <div class="checkbox-group gray">
                                <input type="checkbox"><span>自动登录</span>
                            </div>
                            <input type="submit" style="margin-top:30px;width:300px" class="submit-btn" id="JS_register" tabindex="18" value="登录"></input>
                            <div class="regist-group clearfix">
                                <a class="gray Left" href="<%=basePath %>data/zhuce.jsp">注册</a><a class="gray Right" href="/user/?act=get_password">忘记密码?</a>
                            </div>
                            <div class="other-group gray">
                                <dl class="Left other-login">
                                    <dt>使用合作账号登录：</dt>
                                    <dd class="clearfix other-login">
                                        <a class="i-qq Left"></a>
                                        <a class="i-weibo Left"></a>
                                        <span class="i-weixin Left JS_switch-key J-weixin-request" data-switch-index="0"></span>
                                        <a class="i-zhifubao Left" ></a>
                                    </dd>
                                </dl>
                                <dl class="Left mobile-login">
                                    <dt>您还可以选择：</dt>
                                    <dd style="line-height:29px;cursor:pointer" class="JS_switch-key" data-switch-index="2">
                                        <a class="i-mobile Left" href="javascript:;"></a>手机快捷登录
                                    </dd>
                                </dl>
                            </div>
                        </div>
                        
                        <div id="JS_login_mobile" class="login-mobile Left">
                            <div class="input-group">
                                <label class="i-phone" for="mobile"></label>
                                <input class="yahei gray" name="username" type="text">
                            </div>
                            <p class="error_tip red">&nbsp;</p>
                            <div class="input-group">
                                <label class="i-pwd" for="captcha"></label><input maxlength="6" class="Left yahei gray" name="mobileCaptcha" type="text" style="width:150px">
                                <a class="Left sms-btn" href="javascript:void(0);">获取短信验证码</a>
                            </div>
                            <p class="error_tip red">&nbsp;</p>
                            <input type="hidden" name="captchaType" value="sendPwd">
                            <a style="margin-top:30px;" class="submit-btn" href="javascript:;">登录</a>
                            <div class="regist-group clearfix">
                                <a class="gray Right JS_switch-key" data-switch-index="1" href="javascript:;">返回账号登录>></a>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
            
            </form>
        </aside>
    </div>
</div>
<div class="footer-box">

    <div class="footer">
        <div class="footer-icon">
            <div class="w"> 
                <a  target="_blank" title="网商+体验馆" rel="nofollow" class="icon-map"><p class="icon-bg i1"></p><p class="icon-title">网商+体验馆</p></a><a  target="_blank" title="100%正品" rel="nofollow" class="icon-map"><p class="icon-bg i3"></p><p class="icon-title">100%正品</p></a><a  target="_blank" title="双重质检" rel="nofollow" class="icon-map"><p class="icon-bg i4"></p><p class="icon-title">双重质检</p></a><a  target="_blank" title="全球化采购" rel="nofollow" class="icon-map"><p class="icon-bg i5"></p><p class="icon-title">全球化采购</p></a><a  target="_blank" title="无理由退货" rel="nofollow" class="icon-map"><p class="icon-bg i6"></p><p class="icon-title">无理由退货</p></a><a  target="_blank" title="贵就赔" rel="nofollow" class="icon-map"><p class="icon-bg i7"></p><p class="icon-title">贵就赔</p></a><a  target="_blank" title="万千口碑" rel="nofollow" class="icon-map"><p class="icon-bg i8"></p><p class="icon-title">万千口碑</p></a>
            </div>
        </div>
    </div>

    <div class="footer-copy">
        <div class="link-container">
                            <div class="w">
                    <div class="copy-index clearfix" style="padding-top:0">
                        <div class="fl">
                            <p>
                                 <a  target="_blank" title="装修效果图">装修效果图</a> | 
                                 <a  target="_blank" title="家具图片">家具图片</a> | 
                                 <a  target="_blank" title="家居资讯">家居资讯</a> | 
                                 <a  target="_blank" title="生活百科">生活百科</a> | 
                                 <a  target="_blank" title="家私导购">家私导购</a> | 
                                 <a  target="_blank" title="品牌展厅">品牌展厅</a> | 
                                 <a  target="_blank" title="装修论坛">装修论坛</a> | 
                                 <a  target="_blank" title="furniture store">furniture store</a> | 
                                 <a  target="_blank" title="客服中心" rel="nofollow">客服中心</a> | 
                                 <a  target="_blank" title="网站地图">网站地图</a> | 
                                 <a  target="_blank" title="友情链接" rel="nofollow">友情链接</a> |
                                 <a  target="_blank" title="更多">更多</a>
                            </p>
                            <p>
                                <span class="yen">&copy; 2017-2027 </span><span id="JS_footer_copyright">乐家具商城</span> 版权所有，并保留所有权利。<a href="/" target="_blank" class="gray" rel="nofollow">ICP备案证书号：赣ICP备08008334号</a>
                            </p>
                        </div>
                        <div class="fr credit">
                            <a target="_blank" ><span><i class="c1"></i>诚信网站示范企业</span></a>
                            <a target="_blank" ><span><i class="c2"></i>可信网站信用评价</span></a>
                            <span><i class="c3"></i>经营网站备案信息</span>
                        </div>
                    </div>
                </div>
        </div>
    </div>
</div>


<script>
(function($){
	var lists = [
		[ 'checkPrize' , 'checkprize.min.js?0116g'],
		[ 'sendSms' , 'sendsms2.min.js?160307'],
		[ 'sendSmsGoods' , 'sendSmsGoods.min.js?20170205'],
		[ 'codeSms' , 'codesms.min.js?20170316'], // 二维码短信
		[ 'orderQuery' , 'orderquery.min.js?0116g'],
		[ 'addToCart' , 'addtocart.min.js?201508188'],
		[ 'costDownTip' , 'costdowntip.min.js?160823'],
		[ 'searchKey' , 'searchkey.min.js?20161103'],
		[ 'getComment' , 'getcomment.min.js?0801'],
		[ 'goodsComment' , 'goodscomment.min.js?0905'],
		[ 'quickBuy' , 'quickbuy.min.js?0812'],
		[ 'onlineVideo' , 'onlinevideo.min.js?0410'],
		// [ 'wholehouse' , 'mini_qwg.min.js?1205'],
		[ 'visitYBJ' , 'ybjvisit.min.js?0910'],
		[ 'mobileCaptcha','mobilecaptcha.min.js?060119'],
		[ 'shipRegion','ship_region.min.js?0715'],
		[ 'bonus','bonus.min.js?0520'],
		[ 'sendPrize','sendPrize.min.js?20160805'],
		// 发送购物车到手机
		[ 'cartSms','cartsms.min.js?0108'],
		// 红包预售
		['couponPresell', 'coupon_presell.min.js?20170205'],
        //城市选择
        ['cityLayer', 'cityLayer.min.js?20170321'],
        //老用户采集弹框
        ['oldClient', 'oldClient.min.js?20161125'],
        ['customBoxExtend','customBoxExtend.min.js?20170306'],
        //红包页面 红包
        ['redEnvelope','redEnvelope.min.js?20170205']
	];
	var kk = lists.length;
	for(var k = 0 ; k < kk ; k++) {
		var key  = lists[k][0];
		var file = lists[k][1];
		$[ key ] = (function( key , file ){
			return function(){
				var params = arguments;
                $.req( file , function(){
                    $[key].apply( $ , params );
                })
			}
		})( key , file );
	}
	//特殊
	$.showLoginBox = function(callback,refresh,phone_num){
		if ($.cookie("meilele_login") == "1" && $.cookie("ECS[username]") ) {
			if (typeof callback == "function"){
				callback({
					"username": $.cookie("ECS[username]"),
					"email": $.cookie("ECS[email]")
				});
			}
			return;
		}
		$.req( 'showloginbox.min.js?0428' , function(){
			$.showLoginBox( callback,refresh,phone_num );
		});
	}
    
	if( window._ipad_from ){
		$.addToCart = function(mainGoodsId,goodsData){
			if( goodsData ){
				var tmpH = [];
				for(var k in goodsData){
					var data = goodsData[k];
					if( $.isNumeric(data) ){
						tmpH.push( k+':'+data );
					} else {
						var tmp = [];
						tmp.push(k);
						tmp.push(data.number || 1);
						tmpH.push( tmp.join(':') );
					}
				};
				tmpH = tmpH.join(',');
				window.open("/addToCart/"+tmpH);
			}
		}
		$.cookie('ipad_from',1,{domain:location.host});
	}
})(jQuery);
</script>




<script>
    (function(){
        var that = this;
        if($.cookie('currentCity')) {
            return;
        }
        $.ajax({
            url:'http://api.map.baidu.com/location/ip?ak=R1CsBhbOHZyefZKArjicj741l7K36eyV',
            dataType: 'jsonp',
            success: function(json) {
                if(json && json.address) {
                    var addr = json.address.split('|')[2];
                    $.cookie('currentCity',addr,{
                        path: "/",
                        expires: 365,
                        domain: '.meilele.com'
                    });
                } else {
                    $.cookie('currentCity','北京');
                }
            },error: function() {
                $.cookie('currentCity','北京');
            }
        })
    })()
</script>
<script>
//老用户号码采集优化
(function(popout){
    window.oldClientPopout = popout;
    var s = document.createElement("script");s.type = "text/javascript";s.async = true;s.src = "http://image.meilele.com/js/ocl.invoke.min.js?20161122";
    var s0 = document.getElementsByTagName("script")[0];s0.parentNode.insertBefore(s, s0);
})('1');
</script>

<script>window.M = window.M || {};if($.addToCart)M.addToCart = $.addToCart</script>
<script>
window._onReadyList = window._onReadyList || [];
window._onReadyList.push( function(){
	if( !/downAppIsShow\=1/.test( document.cookie ) && /ipad|ipod|iphone|android/i.test(navigator.userAgent)){
		$(window).on("load",function(){
			$.ajax({
				url:"/mll_api/api/appCenter?contentAdCode=zztcgg_yd&jumpAdCode=default_appjump&c=mobile_visit_www",
				dataType:"script"/*,
				error:function(){
					console.log(arguments)
				}*/
			})
		});
	}
} );
</script><script type="text/javascript">
var isGoodsIndex = ('' || '') ? true : false;
if (!isGoodsIndex) {
	window.__showCart = Boolean('');//商品详情页购物车
	window.__QUIZ = false; 
	_LOAD_SCRIPT_($.__IMG + '/themes/paipai/js/back_to_top.min.js?20161124');
}
</script>


<script>    
    //此处必须用enter和leave！用hover或者mouseover和mouseout会重复触发产生垃圾对象或者销毁多余对象!
    $('#JS_hide_city_menu_11').on({
        'mouseenter': function() {
            $.cityLayer({from:'2016版首页',target:'JS_hide_city_menu_11',siteName:'DY_site_name'})
        },
        'mouseleave': function() {
            for(k in $.cityLayerPointer) {
                $.cityLayerPointer[k].removeCityLayer();
            }
        }
    })
</script>
<script>

    $(function () {
        //顶部导航
        $('.site-nav .drop-title').parent().on({
            'mouseenter': function () {
                jQuery(this).addClass('hover')
            },
            'mouseleave': function () {
                jQuery(this).removeClass('hover')
            }
        });
    })
</script>

<script>
    (function($){
        var py = $.cookie('region_pinyin');
        if ( py ) {
            $('#JS_Header_Home_Link').attr('href', '/'+ py +'/');
            $('#JS_mll_head_menu_expr').attr('href', '/'+ py +'/expr.html');
        } else {
            $('#JS_Header_Home_Link').attr('href', '/');
            $('#JS_mll_head_menu_expr').attr('href', '/expr.html');
        }
    })(jQuery);
    
    function toggleExprName(d) {
        d = d || document;
        var m = d.getElementById('JS_n_head_menu_expr');
        var py = $.cookie('region_pinyin');
        var is_vertual = $.cookie('region_virtual');
        if (py) {
            var homeLink = d.getElementById('JS_Header_Home_Link'),
                logoLink = d.getElementById('JS_Header_Logo_link_home');
            homeLink && homeLink.setAttribute('href', '/' + py + '/');
            logoLink && logoLink.setAttribute('href', '/' + py + '/');
        }
        if (py && m && is_vertual != 1) {
            m.setAttribute('href', '/' + py + '/expr.html');
            m.innerHTML = '体验馆<img src="' + M.__IMG + '/images/hot2015.gif" style="position:absolute;background:none;right:0px;top:-5px;" />';
        } else if (py && m && is_vertual == 1) {
            m.setAttribute('href', '/topic/2014_zsjm01.html?from=nav');
            m.innerHTML = '招商加盟<img src="' + M.__IMG + '/images/new2015.gif" style="position:absolute;background:none;right:0px;top:-5px;" />';
        }
    }
    window._onReadyList = window._onReadyList || [];
    _onReadyList.push(toggleExprName, function () {
        var domain = $.hash().domainFrom;
        if (!/meilele\.com/.test(location.host) || domain) {
            var d = document.getElementById('JS_Header_Logo_link_home');
            d.setAttribute('href', 'http://' + (domain || location.host));
            d.setAttribute('target', '_top');
        }
    });
    
    $(function(){
        //初始化三级菜单
        $('.menu-panel').on({
            'mouseenter': function () {
                $('#JS_mll_menu_map').show();
            },
            'mouseleave': function () {
                $('#JS_mll_menu_map').hide();
            }
        })
        var globalMenu = $('#JS_mll_menu_map');
        globalMenu.menu({
            activate: function (item) {
                var _this = $(item);
                if (!_this.data('imgLoaded')) {
                    var img = _this.find('.sub img');
                    img.prop('src', img.attr('menu-lazy-src')).removeAttr('menu-lazy-src');
                    _this.data('imgLoaded', 1);
                }
                _this.addClass('hover').find('.sub').stop().animate({
                    'padding-left': '10px',
                    'opacity': '1'
                }, 200);

                var ie6 = !-[1, ] && !window.XMLHttpRequest;
                if (ie6) {
                    if (_this.hasClass('large-class')) {
                        globalMenu.css('width', '975px');
                    } else {
                        globalMenu.css('width', '845px');
                    }
                }
            },
            deactivate: function (item) {
                var _this = $(item);
                _this.removeClass('hover').find('.sub').stop().animate({
                    'padding-left': 0,
                    'opacity': '.8'
                }, 200);
            },
            rowSelector: 'li.map-item',
            exitMenu: function (menu) {
                var menu = $(menu);
                var cur = menu.find('.hover');
                var curSub = cur.find('.sub');
                cur.find('em').stop().animate({
                    'padding-left': 0,
                    'opacity': 0
                }, 200);
                cur.removeClass('hover');

                var ie6 = !-[1, ] && !window.XMLHttpRequest;
                if (ie6) {
                    globalMenu.css('width', '200px');
                }
            },
            firstDelay: 100
        });
    })
</script>

<script>
//热搜数据初始化
window.HOTSearchWordDATA;
    $(document).ready(function () {
        $('#JS_MLL_search_header_input').click(function () {
            historySearch('JS_MLL_search_header_input', 'JS_search_history');
             jQuery.searchKey('JS_MLL_search_header_input', 'JS_search_suggest','JS_search_history'); 
            $('#JS_MLL_search_header_input').unbind('click');
            $(this).addClass('search-input-focus');
            return false;
        });
        
        $('body').on('click',function(e){
            e=e || window.event;
            var target=e.target || e.srcElement;
            if ($(target).attr('data-target') != 'search') {
                $('#JS_search_history').hide();
            }
        });
    });
    
    function historySearch(inputId,showId){
        var inputDom = $('#'+inputId);
        var showDom = $('#'+showId);

        if (!inputDom.val()) {
            var data=$.cookie('search_h');
            var _html='<div data-target="search" class="Left h-search"><h6 data-target="search">最近搜过</h6>'
            if (data) {
                data=unescape(data);
                var arr=data.split('*#');
                arr=arr.reverse();
                for(var i=0;i<arr.length;i++){
                     _html+='<a onclick="window._gaq.push([\'_trackEvent\',\'2016美乐乐搜索\',\'搜索历史记录\',\'click\']);" target="_blank" href="/category-9999/?keywords='+arr[i]+'">'+arr[i]+'</a>';
                 }
            }else{
                 _html+='<h1>还没有搜索记录！</h1>'
            }
            _html+='</div>';
              function renderHotSearch(data){
                _html+='<div data-target="search" class="Left hot-search"><h6 data-target="search">正在热搜中</h6><div data-target="search">'
                if (data) {
                    for(var i=0;i<data.length;i++){
                        //字数大于7个用省略号替换
                        if (data[i].name.length>7) {
                            var cutName=data[i].name.substring(0,6)+'...'
                            _html+='<a onclick="window._gaq.push([\'_trackEvent\',\'2016美乐乐搜索\',\'热门搜索\',\'click\']);" target="_blank" title="'+data[i].name+'" class="hot-product" href="'+data[i].url+'">'+cutName+'</a>'
                        }else{
                          _html+='<a onclick="window._gaq.push([\'_trackEvent\',\'2016美乐乐搜索\',\'热门搜索\',\'click\']);" target="_blank" title="'+data[i].name+'" class="hot-product" href="'+data[i].url+'">'+data[i].name+'</a>'  
                        }
                    }
                } 
                _html+='</div></div>'  
            } 
            if (window.HOTSearchWordDATA) {
                renderHotSearch(window.HOTSearchWordDATA);
            }else{
                 $.ajax({
                    url: '/solr_api/hotSearchWord/',
                    type: 'GET',
                    dataType: 'json',
                    async:false,
                    success: function(json) {
                        window.HOTSearchWordDATA=json.hotSearchWordList;
                         renderHotSearch(json.hotSearchWordList);
                    },
                    error: function() {

                    }
                });
            }


            showDom.append(_html);
            showDom.show();
        }
    }

    function addHistory(dom){
         var val = $(dom).text();
         var charVal=val;
        //搜索历史记录存cookie
         if (val && charVal.replace(/[^\x00-\xff]/g, "**").length<31) {
                    var cval = $.cookie('search_h');
                    if (cval) {
                        cval = unescape(cval);
                        cval = cval.split('*#');
                        cval = removeElement(cval, val);
                        if (cval.length > 9) {
                            cval.shift();
                        }
                        cval = cval.join('*#');
                        cval += '*#' + val
                    } else {
                        cval = val + '*#'
                    }
                    cval = escape(cval);
                    $.cookie('search_h', cval, {path: '/', expires: 365});
                }
    }
      //去除数组中的某个元素 
    function removeElement(arr, val) {
        var newarr = [];
        for (var i = 0; i < arr.length; i++) {
            if (arr[i] != val) {
                newarr.push(arr[i]);
            }
        }
        return newarr;
    }
</script>

<script>
    $(function () {
        //初始化购物车
        jQuery('#JS_cart,#JS_cart2').hover(function(){
                Cart.show(this)
           },function(){
                Cart.hide(this)
           });
        Cart.init();
    })
</script>




<script>
    ;(function () {
        var linkcity = $('#link_city');
        var linkfri = $('#link_fri');
        var moreCityBtn = $('#more_city');
        var moreFriBtn = $('#more_fri');

        if (linkcity.find('.link-content').height() > 20) {
            moreCityBtn.css('display', 'block');
            moreCityBtn.click(function () {
                moreCityBtn.hide();
                linkcity.css('height', 'auto');
            })
        }
        if (linkfri.find('.link-content').height() > 20) {
            moreFriBtn.css('display', 'block');
            moreFriBtn.click(function () {
                moreFriBtn.hide();
                linkfri.css('height', 'auto');
            })
        }
    })()
    ;(function () { //清除电信广告
        function checkIframe(nLen) {
            if (nLen > 10) return; //最多检测10 秒钟
            var bRemove = false;
            var oIframes = document.getElementsByTagName('iframe');
            var oIframe = null;
            if (oIframes == null || oIframes.length == 0) {
                window.setTimeout(function () {
                    checkIframe(nLen + 1)
                }, 1000);
                return;
            }
            var nLength = oIframes.length;
            for (var i = 0; i < nLength; i++) {
                oIframe = oIframes[i];
                var strSRC = oIframe.src;
                if (/72link/.test(strSRC)) {
                    setTimeout(function () {
                        location.reload();
                    }, 1000)
                    throw new Error('发现电信广告');
                }

            }
            if (!bRemove) window.setTimeout(function () {
                checkIframe(nLen + 1)
            }, 1000);
        }
        window.setTimeout(function () {
            checkIframe(0)
        }, 100);
    })();
    //JS域名验证
    (function () {
        function checkEnd(endStr) {
            var url = location.host,
                flag;
            for (var i = 0; i < endStr.length; i++) {
                var d = url.length - endStr[i].length;
                if (d >= 0 && url.lastIndexOf(endStr[i]) == d)
                    return true;
            }
            return false
        }
        var urlList = ['\x2e\x6d\x65\x69\x6c\x65\x6c\x65\x2e\x63\x6f\x6d',
                       '\x2e\x68\x65\x6e\x67\x79\x65\x72\x2e\x63\x6f\x6d'];
        if (!checkEnd(urlList)) {
            location.href = '\x68\x74\x74\x70\x3a\x2f\x2f\x77\x77\x77\x2e\x6d\x65\x69\x6c\x65\x6c\x65\x2e\x63\x6f\x6d'
        }
    })()
</script><script type="text/javascript">
var img = new Image();
if(!/ECS_ID\=/.test(document.cookie) || /autoLogin\=/.test(document.cookie))img.src ='/ecsid_maker/?_='+(new Date()).getTime();
</script>
<script type="text/javascript">
    (function(a){if(!a){return;}a.fn.placeholder=function(j){var d={txt:"",cssStr:"",focusClsName:undefined,focusFun:undefined,blurFun:undefined,clsName:undefined};
var c=a.extend({},d,j||{});var b=a(this);var f=b.prop("type");f=f?(f!="password"&&f!="text"?"text":f):"text";if(f=="text"){b.val(c.txt);b.focus(function(k){h(b,c.focusFun);
}).blur(function(){i(b,c.blurFun);});}else{var e;if(!b.next("input").length){e=a("<input />").addClass(c.clsName&&c.clsName.join?c.clsName.join(" "):"");
}else{e=b.next("input").eq(0);}var g={show:{display:""},hide:{display:"none"}};e.focus(function(k){e.css(g.hide);b.css(g.show).focus();c.focusFun&&c.focusFun();
}).val(c.txt);b.css(g.hide).after(e).blur(function(){b.val()?void (0):(e.css(g.show)&&b.css(g.hide));c.blurFun&&c.blurFun();});}function h(l,k){l.val()==c.txt&&l.val("").addClass(c.focusClsName&&c.focusClsName.join?c.focusClsName.join(" "):"");
k&&k();}function i(l,k){l.val()==""?l.val(c.txt).removeClass(c.focusClsName&&c.focusClsName.join?c.focusClsName.join(" "):""):k&&k();}b.setTxt=function(k){if(!b.next("input").length){b.val()==c.txt&&b.val(k);
}else{b.next("input").eq(0).val(k);}c.txt=k;return b;};b.getText=function(){return c.txt;};b.setParam=function(m,l){c[m]=l;return b;};b.getParam=function(l){return c[l];
};return b;};})($);(function(n,k){var A=(n.location.search+"").match(/redirect_url=(.*)&?/ig);A=A?decodeURIComponent(A[0].split("=")[1]):"/";var y=n.document.referrer+"";
y=decodeURIComponent(y)||"/";if(y.match(/act=((login)|(register)|(get_password)|(modify_mobile)|(modify_email)|(modify_tradepwd)|(verify_mobile)|(verify_email)|(set_tradepwd))/ig)){y="/";
}var p={},l={email:/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/ig,tel:/^1\d{10}$/ig},C=false,B=false,w="",E;p.loginPwd=k(".login-pwd");p.loginMobile=k(".login-mobile");
p.loginForm=k(".login-form");p.username=p.loginPwd.find('input[name="username"]');p.usernameGroup=p.username.parent();p.password=p.loginPwd.find('input[name="password"]');
p.passwordGroup=p.password.parent();p.captcha=p.loginPwd.find('input[name="captcha"]');p.captchaGroup=p.captcha.parent();p.validCode=k("#JS_validCode");
p.remchk=k(".i-checkbox");p.remchkGroup=k(".checkbox-group");p.mobile=p.loginMobile.find('input[name="username"]');p.mobileGroup=p.mobile.parent();p.smsPwd=p.loginMobile.find('input[name="mobileCaptcha"]');
p.smsPwdGroup=p.smsPwd.parent();p.switchBtn=k(".JS_switch-key");p.username=h(p.username,{txt:"用户名/手机号/邮箱",clsName:["gray"],focusClsName:["black"],focusFun:function(){o(p.usernameGroup);
}});p.password=h(p.password,{txt:"密码",clsName:["yahei","gray"],focusFun:function(){o(p.passwordGroup);}}).keyup(function(u){if(u.keyCode==13&&!(u.ctrlKey||u.shiftKey||u.altKey)){k("#JS_login_pwd .submit-btn").click();
}}).prop("name","password");p.captcha=h(p.captcha,{txt:"验证码",clsName:["gray"],focusClsName:["black"],focusFun:function(){o(p.captchaGroup);}});p.mobile=h(p.mobile,{txt:"手机号",clsName:["gray"],focusClsName:["black"],focusFun:function(){o(p.mobileGroup);
}});p.smsPwd=h(p.smsPwd,{txt:"验证码",clsName:["gray"],focusClsName:["black"],ocusFun:function(){o(p.smsPwdGroup);}});p.username.setParam("blurFun",function(G){var F=p,H=F.username.val(),u="您输入的账户名不存在，请核对后重新输入。";
if(H==F.username.getText()){return false;}x("/dubbo_api/user/login/isRegistered",{username:k.trim(H)},function(I){if(I.chapterFlag){d();}else{j();}},function(I){if((I.msg).indexOf("不存在")!=-1){g(F.usernameGroup,u);
j();}});});p.mobile.setParam("blurFun",function(H){var G=p,I=G.mobile.val(),F=I.match(l.tel),u="您输入的手机号不存在，请核对后重新输入。";if(I==G.mobile.getText()){return false;
}if(F==null){g(G.mobileGroup,"您输入的手机号不正确，请核对后重新输入。");C=false;return false;}x("/dubbo_api/user/login/isRegistered",{username:k.trim(I)},function(J){if(J.chapterFlag){d();
}else{j();}},function(J){if((J.msg).indexOf("不存在")!=-1){g(G.mobileGroup,u);j();}});});var e=k.cookie("rember_username")||"";var z=k.cookie("sendSmsPhone")||"";
p.switchBtn.on("click",function(H){var G=k(this).data("switch-index"),F=-1,u=k(".login-type"),I=p;o();p.switchBtn.removeClass("on");k(this).addClass("on");
switch(G){case 0:k(".switch-weixin").addClass("on");break;case 1:k(".login-switch").stop(true).animate({left:"0px"},200).css("border-bottom","1px solid #d1d1d1");
k(".switch-acount").addClass("on");break;case 2:k(".login-switch").stop(true).animate({left:306*F+"px"},200).css("border-bottom","1px solid #fff");if(z){I.mobile.val(z).addClass("black");
}else{I.mobile.val("").blur();}var J=function(){return 0;};k(".sms-btn").unbind().on("click",function(N){var M=this;if(J()==0){var K=k.trim(I.mobile.val()),L=K.match(l.tel);
if(L==null){g(I.mobileGroup,"您输入的手机号不正确，请核对后重新输入。");return false;}k(this).html("正在发送...");x("/dubbo_api/user/password/sendPassword",{captchaType:"sendPwd",phoneNumber:I.mobile.val()},function(O){J=s(k(M));
},function(O){k(M).removeClass("sms-disabled").html("获取手机动态密码");k.alert((O&&O.msg)||"获取失败！");});}});break;}u.stop(true).animate({left:306*F*G+"px"},200);
});k(".submit-btn").on("click",function(H){var G=k(this).parent().hasClass("login-pwd"),u=k(this).parent().hasClass("login-mobile"),F;if(this["f"]){return false;
}if(G&&c("pwd")){if(!p.captchaGroup.hasClass("none")&&!B){return;}this["f"]=1;F=b("#JS_login_pwd");q.call(this,F);}if(u&&c("mobile")){this["f"]=1;F=b("#JS_login_mobile");
q.call(this,F);}});function q(u){var F=this;F.innerHTML="正在验证";x("/dubbo_api/user/login/login_ajax",u,function(H){var I=p;if(u[""]=="密码"){k.cookie("rember_username",I.username.val(),{expires:365});
}else{k.cookie("sendSmsPhone",I.mobile.val(),{expires:365});}j();k.setWindowName("js","parseGaData","_trackEvent","userLogin",n.document.referrer,"网页登录");
if(H.bindCode){var G="";A=="/"?G="/user/?act=binding":G="/user/?act=binding&redirect_url="+encodeURIComponent(A);n.location.href=m(G);}else{n.location.href=m(H.url);
}},function(I){var G,H='<ul id="JS_select_username" class="none">';if(I.error==6||I.error==7){if(k(".select-icon").length){k("#JS_select_username").remove();
k(".select-icon").remove();}k.alert(I.msg,{onOk:function(){G=I.userName.split(",");p.username.val(G[0]);for(var K=0,J=G.length;K<J;K++){H+="<li>"+G[K]+"</li>";
}H+="</ul>";p.username.after('<i class="select-icon"></i>').after(H);v();}});}else{k.alert(I&&I.msg);}if(I.chapterFlag){d();}else{j();}},function(G){},function(G){F.f=0;
F.innerHTML="登录";});}function d(){p.captchaGroup.removeClass("none").next().removeClass("none");i();}function j(){p.captchaGroup.addClass("none").next().addClass("none");
}function x(G,J,H,u,I,F){return t({url:G||"",data:J||{},ok:H||function(K){},failed:u||function(K){k.alert(K);},error:I||function(K){k.alert("网络错误，请刷新后重试。");
},com:F});}function t(u){var F={url:"",type:"POST",dataType:"json",failed:function(H){k.alert(H&&H.msg);},error:function(H){k.alert("网络错误，请刷新后重试。");},beforeSend:function(){return true;
},ok:function(H){return true;},data:{}};var G=k.extend({},F,u||{});G.data._=new Date().getTime();return k.ajax({url:G.url,type:G.type,dataType:G.dataType,data:G.data,success:function(H){if(H.error=="0"){G.ok(H);
C=true;}else{G.failed(H);C=false;}},error:function(H){k.alert("网络错误，请刷新后重试。");C=false;},beforeSend:G.beforeSend,complete:G.com});}function s(F){var u=120;
typeof E!="undefined"&&clearInterval(E);E=setInterval(function(){if(u>=0){F.addClass("sms-disabled").text((u--)+"秒后重新获取");}else{F.removeClass("sms-disabled").text("获取短信验证码");
u=0;typeof E!="undefined"&&clearInterval(E);}},1000);return function(){return u;};}function h(F,u){return F.placeholder?F.placeholder(u):null;}function c(H){var I=p,K,F,J,u,G;
C=true;if(H=="pwd"){K=I.username.val();F=I.password.val();J=I.captcha.val();if(k.trim(K)==""||K==I.username.getText()){g(I.usernameGroup,"请输入"+I.username.getText());
C=false;return C;}if(k.trim(F)==""||F==I.password.getText()){g(I.passwordGroup,"请输入"+I.password.getText());C=false;return C;}if(!I.captchaGroup.hasClass("none")){if(k.trim(J)==""||J==I.captcha.getText()){g(I.captchaGroup,"请填写验证码。");
C=false;return C;}}}if(H=="mobile"){u=I.mobile.val();G=I.smsPwd.val();if(k.trim(u)==""||u==I.mobile.getText()){g(I.mobileGroup,"请输入"+I.mobile.getText());
C=false;return C;}else{if(u.match(l.tel)==null){g(I.mobileGroup,"您输入的手机号不正确，请核对后重新输入。");C=false;return C;}}if(!I.smsPwd.hasClass("none")){if(k.trim(G)==""||G==I.smsPwd.getText()){g(I.smsPwdGroup,"请填写短信验证码。");
C=false;return C;}}}return C;}function g(F,H){var G=F.next("p.error_tip");if(G.length){G.html(H).css("visibility","visible");}else{var u=k('<p class="error_tip red"></p>').html(H);
F.after(u.clone());errorTip=null;}F.addClass("input_error");C=false;}function o(u){if(u){u.next(".error_tip").css("visibility","hidden");}else{p.loginForm.find(".input_error").removeClass("input_error");
p.loginForm.find(".error_tip").css("visibility","hidden");return;}u.removeClass("input_error");}function b(H){var u=k(H).find("input[type!=checkbox]");
var G={};G.handler="web";if(H=="#JS_login_pwd"){var F=p.remchk.hasClass("checked");if(F){G.autoLogin=1;}}u.each(function(I,J){G[J.name]=J.value;});return G;
}function a(H,G,F){var u=A;if(G&&u){G+=(G.indexOf("?")>=0?"&":"?")+(F||"redirect_uri")+"="+encodeURIComponent(u);G=G.replace(/'|\"/ig,"");}k.setWindowName("js","parseGaData","_trackEvent","apiLogin",this.innerHTML,"网页_"+document.referrer);
return G;}function m(u){if(u){return u;}if(A.match(/act=((modify_mobile)|(modify_email)|(modify_tradepwd)|(verify_mobile)|(verify_email)|(set_tradepwd))/ig)){A="/";
}return(A=="/"?y:A);}if(k.cookie("rember_username")){var r=k.cookie("rember_username");var D=p;D.username.val(r).addClass("black");x("/dubbo_api/user/login/isRegistered",{username:k.trim(r)},function(u){},function(u){if(u.chapterFlag){d();
}else{j();}});}function i(){var u=k("#JS_validCode");k.getCaptcha(u.prop("src","http://image.meilele.com/images/blank.gif"));p.captcha[0].focus();p.captcha.val("");}k("#JS_validCode,#JS_refreshBtn").click(function(F){F=F||event;
var u=F.srcElement||F.target;if(u.id=="JS_validCode"||u.id=="JS_refreshBtn"){i();}});k.checkCaptcha(p.captcha,{success:function(u){o(p.captchaGroup);B=true;
},error:function(u){g(p.captchaGroup,"&nbsp");B=false;}});k(document).on("click",".other-login a",function(u){this.href=a(this,this.href,"back_url");});
function v(){var u=p;u.selectBtn=k(".select-icon");u.BindUser=k("#JS_select_username");u.selectBtn.unbind().on("click",function(){if(k(this).hasClass("icon-open")){k(this).removeClass("icon-open");
u.BindUser.addClass("none");}else{k(this).addClass("icon-open");u.BindUser.removeClass("none");}});u.BindUser.find("li").unbind().on("click",function(){p.username.val(k(this).text());
});k("body").unbind().on("click",function(F){if(F.target.className!="select-icon icon-open"){u.selectBtn.removeClass("icon-open");u.BindUser.addClass("none");
}});}p.remchk.click(function(){if(k(this).hasClass("checked")){k(this).removeClass("checked");p.remchkGroup.css("color","");}else{k(this).addClass("checked");
p.remchkGroup.css("color","#cf000e");}});var f=true;k(".J-weixin-request").click(function(){if(f){f=false;var u=(n.location.search+"").match(/redirect_url=(.*)&?/ig);
u=!!u?u[0].split("=")[1]:"";k.get("/dubbo_api/user/newThird/createQrcode?type=login&back_url="+u,function(F){if(F&&F.error==0){k("#JS_QR_CODE").prop("src",F.url);
}var G=function(I){var H="";I?H="/dubbo_api/user/newThird/isLogin?state="+I:H="/dubbo_api/user/newThird/isLogin";k.ajax({url:H,dataType:"json",cache:"false",success:function(J){if(J){if(J.state==0){if(!k(".qr-mark").length){k("#JS_QR_CODE").after('<div class="qr-mark"></div>');
k("#JS_QR_TEXT").text("二维码获取失败,请刷新页面重试！");}}if(J.state==1){G(J.state);}if(J.state==2){G(J.state);if(!k(".qr-mark").length){k("#JS_QR_CODE").after('<div class="qr-mark"><i></i></div>');
k("#JS_QR_TEXT").text("扫描成功，请在手机上点击登录！");}}else{if(J.state==3){location.href=J.url;}}}else{if(!k(".qr-mark").length){k("#JS_QR_CODE").after('<div class="qr-mark"></div>');
k("#JS_QR_TEXT").text("二维码获取失败,请刷新页面重试！");}}},error:function(){if(!k(".qr-mark").length){k("#JS_QR_CODE").after('<div class="qr-mark"></div>');k("#JS_QR_TEXT").text("二维码获取失败,请刷新页面重试！");
}}});};G();});}});})(window,$);
/*jinzeze*234430:2016-10-17 15:26:02*/</script>
<div id="static_dynamic" name="static_dynamic" page_sn="user" rgn_id="" debug=""></div>
<script type="text/javascript">window.static_dynamic && static_dynamic();</script><div id="INIT_Fchat2" class="" style="display: none;width: 58px;height: 127px;right: 5px;top: 190px;_top: expression(eval(document.documentElement.scrollTop+190));background: url(http://image.meilele.com/images/201405/1401178094439.png) 0 0;_background: url(http://image.meilele.com/images/201405/140117892382.gif) 0 0;cursor: pointer;font-size: 12px;z-index: 1500;position: fixed;_position: absolute;overflow: hidden;"><div class="FC_btns FC_number" style="margin-left:24px;margin-top:-1px;" id="JS_FC_number2"></div></div>
<script type="text/javascript">
(function(){
	window.mchat = window.mchat || {};

	
	var d = document.getElementById('INIT_Fchat2');
	if( (d && mchat.config) || window._ipad_from ){
		d.style.display = 'none';
	}
	var date = new Date();
	d.onclick = function(){
		if( mchat.show ){
			mchat.show();
		}else{
			if (window.isGoodsIndex) {
				$.ajax({
					url:'http://image.meilele.com/js/mll/chatFloat_new.min.js?'+date.getFullYear()+date.getMonth()+date.getDate(),
					cache:true,
					dataType:'script'
				});
			} else {
				$.ajax({
					url:'http://image.meilele.com/js/mll/chatFloat.min.js?'+date.getFullYear()+date.getMonth()+date.getDate(),
					cache:true,
					dataType:'script'
				});
			}
		}
	}
	setTimeout(function(){
		if ( !mchat.config  || !mchat.config.background_main ) {
			$('#INIT_Fchat2').trigger('click');
		}
	},1500);
})();
</script>

</body>
</html>

<!--
duanzheng*247511:2017-01-05 14:59:46
-->