<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/9/5
  Time: 19:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>HUI - 下拉刷新</title>
    <meta name="keywords" content="HUI - 下拉刷新" />
    <meta name="description" content="HUI - 下拉刷新" />
    <meta name="robots" content="index, follow" />
    <meta name="googlebot" content="index, follow" />
    <meta property="qc:admins" content="565347177760374526654" />
    <link rel="stylesheet" type="text/css" href="http://www.hcoder.net/public/main.css" />
    <link rel="stylesheet" type="text/css" href="http://at.alicdn.com/t/font_pe3taublceuerk9.css"></link>
    <link rel="shortcut icon" type="image/x-icon" href="http://www.hcoder.net/favicon.ico" />
    <script type="text/javascript" src="http://libs.baidu.com/jquery/1.10.2/jquery.js"></script>
    <meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <script>
        var _hmt = _hmt || [];
        (function() {var hm = document.createElement("script"); hm.src = "//hm.baidu.com/hm.js?3cecdb545ed6ae876700503d61528301"; var s = document.getElementsByTagName("script")[0]; s.parentNode.insertBefore(hm, s);})();
    </script>
</head>
<body>
<div id="header">
    <div class="cWrap">
        <div id="logo">
            <a href="/"><img src="http://static.hcoder.net/public/images/logo.png" /></a>
        </div>
        <div id="nav">
            <a href="/" id="navIndex">首页</a>
            <a href="/course" id="navCourse">课程中心</a>
            <a href="/share" id="navShare">问答&amp;分享</a>
            <a href="/books" id="navBook">读书</a>
            <a href="/hcwt" id="navHcwt">公众号框架</a>
            <a href="/hui" id="navMui">HUI</a>
            <a href="/h" id="navHjs">H.JS</a>
            <a href="/api" id="navHOA">开放源</a>
            <a href="javascript:void(0);" onclick="sLogin();" id="loginHeader">+ 登录</a>
        </div>
    </div>
    <div id="dMenu" class="iconfont icon-caidan"></div>
    <div id="regHeader" style="display:none;" onclick="sReg();"></div>
</div>
<div id="cTopLine"></div>
<div id="HUI_Nav_Menus">
    <a href="/course">课程中心</a>
    <a href="/share">问答&amp;分享</a>
    <a href="/books">读书</a>
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
        <dt>HUI 介绍</dt>
        <dd><a href="/hui/docs" id="huiDl_218">HUI 介绍及下载</a></dd>
        <dd><a href="/hui/docs220.html" id="huiDl_220">HUI 部署及文档结构</a></dd>
        <dd><a href="/hui/docs348.html" id="huiDl_348">HUI 更新日志</a></dd>
    </dl>
    <dl>
        <dt>基础组件</dt>
        <dd><a href="/hui/docs221.html" id="huiDl_221">基础布局、头部、返回按钮、普通列表、数字标示</a></dd>
        <dd><a href="/hui/docs315.html" id="huiDl_315">头部导航及菜单</a></dd>
        <dd><a href="/hui/docs237.html" id="huiDl_237">底部导航及新消息提示</a></dd>
        <dd><a href="/hui/docs229.html" id="huiDl_229">按钮及Loading按钮</a></dd>
        <dd><a href="/hui/docs311.html" id="huiDl_311">Toast 提示框</a></dd>
        <dd><a href="/hui/docs219.html" id="huiDl_219">模态对话框</a></dd>
        <dd><a href="/hui/docs230.html" id="huiDl_230">switch 开关</a></dd>
        <dd><a href="/hui/docs236.html" id="huiDl_236">Loading 动画</a></dd>
        <dd><a href="/hui/docs312.html" id="huiDl_312">Action Sheet</a></dd>
        <dd><a href="/hui/docs270.html" id="huiDl_270">数字输入框</a></dd>
        <dd><a href="/hui/docs231.html" id="huiDl_231">进度条动画</a></dd>
        <dd><a href="/hui/docs234.html" id="huiDl_234">滑块</a></dd>
        <dd><a href="/hui/docs277.html" id="huiDl_277">星级评分</a></dd>
        <dd><a href="/hui/docs283.html" id="huiDl_283">popoverMsg</a></dd>
    </dl>
    <dl>
        <dt>常用组件</dt>
        <dd><a href="/hui/docs222.html" id="huiDl_222">媒体列表</a></dd>
        <dd><a href="/hui/docs313.html" id="huiDl_313">图片列表</a></dd>
        <dd><a href="/hui/docs314.html" id="huiDl_314">折叠面板</a></dd>
        <dd><a href="/hui/docs224.html" id="huiDl_224">Tab 选项卡</a></dd>
        <dd><a href="/hui/docs225.html" id="huiDl_225">轮播组件</a></dd>
        <dd><a href="/hui/docs226.html" id="huiDl_226">图片懒加载</a></dd>
        <dd><a href="/hui/docs268.html" id="huiDl_268">下拉刷新</a></dd>
        <dd><a href="/hui/docs269.html" id="huiDl_269">上拉加载</a></dd>
        <dd><a href="/hui/docs284.html" id="huiDl_284">picker</a></dd>
        <dd><a href="/hui/docs280.html" id="huiDl_280">区域滚动</a></dd>
        <dd><a href="/hui/docs278.html" id="huiDl_278">select 美化</a></dd>
        <dd><a href="/hui/docs235.html" id="huiDl_235">图片预览及缩放</a></dd>
        <dd><a href="/hui/docs276.html" id="huiDl_276">瀑布流</a></dd>
        <dd><a href="/hui/docs316.html" id="huiDl_316">全文折叠</a></dd>
        <dd><a href="/hui/docs232.html" id="huiDl_232">图标及九宫格布局</a></dd>
        <dd><a href="/hui/docs321.html" id="huiDl_321">侧滑菜单</a></dd>
    </dl>
    <dl>
        <dt>表单元素及验证</dt>
        <dd><a href="/hui/docs227.html" id="huiDl_227">常用表单元素</a></dd>
        <dd><a href="/hui/docs228.html" id="huiDl_228">表单验证</a></dd>
    </dl>
    <dl>
        <dt>事件</dt>
        <dd><a href="/hui/docs261.html" id="huiDl_261">hui.ready()</a></dd>
        <dd><a href="/hui/docs262.html" id="huiDl_262">hui.plusReady()</a></dd>
        <dd><a href="/hui/docs239.html" id="huiDl_239">click</a></dd>
        <dd><a href="/hui/docs240.html" id="huiDl_240">dblclick</a></dd>
        <dd><a href="/hui/docs241.html" id="huiDl_241">longTap</a></dd>
        <dd><a href="/hui/docs317.html" id="huiDl_317">change</a></dd>
        <dd><a href="/hui/docs318.html" id="huiDl_318">onScroll、scroll</a></dd>
        <dd><a href="/hui/docs242.html" id="huiDl_242">on - 为后追加的元素绑定事件</a></dd>
        <dd><a href="/hui/docs243.html" id="huiDl_243">滑动事件</a></dd>
        <dd><a href="/hui/docs274.html" id="huiDl_274">resize</a></dd>
        <dd><a href="/hui/docs244.html" id="huiDl_244">自定义事件绑定及触发</a></dd>
    </dl>
    <dl>
        <dt>元素选择、遍历</dt>
        <dd><a href="/hui/docs245.html" id="huiDl_245">选择器</a></dd>
        <dd><a href="/hui/docs247.html" id="huiDl_247">筛选器</a></dd>
        <dd><a href="/hui/docs246.html" id="huiDl_246">父子元素选择</a></dd>
        <dd><a href="/hui/docs249.html" id="huiDl_249">遍历选中元素</a></dd>
        <dd><a href="/hui/docs255.html" id="huiDl_255">选中元素数量</a></dd>
        <dd><a href="/hui/docs346.html" id="huiDl_346">元素索引值获取 index()</a></dd>
    </dl>
    <dl>
        <dt>dom操作</dt>
        <dd><a href="/hui/docs248.html" id="huiDl_248">样式操作 css()</a></dd>
        <dd><a href="/hui/docs250.html" id="huiDl_250">属性操作 attr()</a></dd>
        <dd><a href="/hui/docs251.html" id="huiDl_251">HTML内容操作 html()</a></dd>
        <dd><a href="/hui/docs252.html" id="huiDl_252">值操作 val()</a></dd>
        <dd><a href="/hui/docs253.html" id="huiDl_253">class 操作</a></dd>
        <dd><a href="/hui/docs254.html" id="huiDl_254">show()、hide()</a></dd>
        <dd><a href="/hui/docs256.html" id="huiDl_256">对象克隆、追加</a></dd>
        <dd><a href="/hui/docs259.html" id="huiDl_259">删除元素、动画</a></dd>
        <dd><a href="/hui/docs267.html" id="huiDl_267">获取窗口信息</a></dd>
        <dd><a href="/hui/docs272.html" id="huiDl_272">偏移值获取</a></dd>
        <dd><a href="/hui/docs275.html" id="huiDl_275">判断元素展示状态</a></dd>
        <dd><a href="/hui/docs273.html" id="huiDl_273">控制窗口滚动条</a></dd>
    </dl>
    <dl>
        <dt>扩展</dt>
        <dd><a href="/hui/docs271.html" id="huiDl_271">插件扩展</a></dd>
    </dl>
    <dl>
        <dt>AJAX</dt>
        <dd><a href="/hui/docs263.html" id="huiDl_263">AJAX 说明</a></dd>
    </dl>
    <dl>
        <dt>h5+ App 开发专用</dt>
        <dd><a href="/hui/docs264.html" id="huiDl_264">创建窗口(预加载)</a></dd>
        <dd><a href="/hui/docs265.html" id="huiDl_265">打开及关闭窗口</a></dd>
        <dd><a href="/hui/docs266.html" id="huiDl_266">窗口返回处理</a></dd>
        <dd><a href="/hui/docs320.html" id="huiDl_320">子窗口创建、侧滑切换</a></dd>
        <dd><a href="/hui/docs347.html" id="huiDl_347">沉浸式状态栏</a></dd>
    </dl>
    <dl>
        <dt>常用界面</dt>
        <dd><a href="/hui/docs223.html" id="huiDl_223">动态图文组合</a></dd>
        <dd><a href="/hui/docs281.html" id="huiDl_281">索引列表</a></dd>
        <dd><a href="/hui/docs285.html" id="huiDl_285">图片裁切及上传</a></dd>
        <dd><a href="/hui/docs286.html" id="huiDl_286">APP启动动画</a></dd>
        <dd><a href="/hui/docs238.html" id="huiDl_238">手势密码</a></dd>
        <dd><a href="/hui/docs282.html" id="huiDl_282">用户注册</a></dd>
        <dd><a href="/hui/docs319.html" id="huiDl_319">用户中心</a></dd>
        <dd><a href="/hui/docs322.html" id="huiDl_322">搜索界面</a></dd>
    </dl>
</div><div class="cWrap" style="padding:18px 0px 20px 0px;" id="docMain">
    <table width="100%" cellspacing="0" cellpadding="0" border="0">
        <tr>
            <td width="300" valign="top">
                <div style="width:300px;">&nbsp;</div>
            </td>
            <td valign="top">
                <div class="huiContent" style="padding-bottom:38px;">
                    <p><strong>演示样例(需要在移动设备下体验)</strong></p><p id="huiPhoneInDoc"><iframe width="305" height="500" src="http://www.hcoder.net/huiv2/refresh.html" frameborder="0" scrolling="auto"></iframe></p><p><strong>说明</strong><br/>需要引用 hui-refresh-load-more.js<br/></p><pre class="brush:html;toolbar:false">&lt;script&nbsp;src=&quot;js/hui-refresh-load-more.js&quot;&nbsp;type=&quot;text/javascript&quot;&nbsp;charset=&quot;utf-8&quot;&gt;&lt;/script&gt;</pre><p><br/><strong>核心函数&nbsp;hui.refresh(&#39;#refreshContainer&#39;, refresh);</strong><br/>功能：实现下拉刷新。<br/>参数：<br/>1、刷新针对的核心dom元素；<br/>2、刷新时执行的函数；<br/><br/><strong>hui.endRefresh();</strong><br/>在刷新完成后使用hui.endRefresh();函数结束刷新及其动画效果。<br/><br/><strong>完整代码示例</strong><br/></p><pre class="brush:html;toolbar:false">&lt;!DOCTYPE&nbsp;html&gt;
&lt;html&gt;
&lt;head&gt;
&lt;meta&nbsp;charset=&quot;utf-8&quot;&gt;
&lt;meta&nbsp;name=&quot;viewport&quot;&nbsp;content=&quot;initial-scale=1.0,&nbsp;maximum-scale=1.0,&nbsp;user-scalable=no&quot;&nbsp;/&gt;
&lt;title&gt;HUI&nbsp;&lt;/title&gt;
&lt;link&nbsp;rel=&quot;stylesheet&quot;&nbsp;type=&quot;text/css&quot;&nbsp;href=&quot;css/hui.css&quot;&nbsp;/&gt;
&lt;/head&gt;
&lt;body&nbsp;background=&quot;#f4f5f6;&quot;&gt;
&lt;header&nbsp;class=&quot;hui-header&quot;&gt;
&nbsp;&nbsp;&nbsp;&nbsp;&lt;div&nbsp;id=&quot;hui-back&quot;&gt;&lt;/div&gt;
&nbsp;&nbsp;&nbsp;&nbsp;&lt;h1&gt;HUI&nbsp;下拉刷新&lt;/h1&gt;
&lt;/header&gt;
&lt;div&nbsp;class=&quot;hui-wrap&quot;&gt;
&nbsp;&nbsp;&nbsp;&nbsp;&lt;div&nbsp;class=&quot;hui-center-title&quot;&nbsp;style=&quot;margin-top:15px;&quot;&gt;&lt;h1&gt;演示示例&lt;/h1&gt;&lt;/div&gt;
&nbsp;&nbsp;&nbsp;&nbsp;&lt;div&nbsp;id=&quot;refreshContainer&quot;&nbsp;class=&quot;hui-refresh&quot;&nbsp;style=&quot;padding:0px&nbsp;10px;&quot;&gt;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;div&nbsp;class=&quot;hui-refresh-icon&quot;&gt;&lt;/div&gt;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;div&nbsp;class=&quot;hui-refresh-content&nbsp;hui-list&quot;&gt;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;ul&nbsp;id=&quot;list&quot;&gt;&lt;/ul&gt;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;/div&gt;
&nbsp;&nbsp;&nbsp;&nbsp;&lt;/div&gt;
&lt;/div&gt;
&lt;script&nbsp;type=&quot;text/javascript&quot;&nbsp;src=&quot;js/hui.js&quot;&gt;&lt;/script&gt;
&lt;script&nbsp;src=&quot;js/hui-refresh-load-more.js&quot;&nbsp;type=&quot;text/javascript&quot;&nbsp;charset=&quot;utf-8&quot;&gt;&lt;/script&gt;
&lt;script&nbsp;type=&quot;text/javascript&quot;&gt;
hui.refresh(&#39;#refreshContainer&#39;,&nbsp;refresh);
function&nbsp;refresh(){
&nbsp;&nbsp;&nbsp;&nbsp;if(hui.refreshNumber&nbsp;&lt;&nbsp;1){hui.loading(&#39;加载中...&#39;);}
&nbsp;&nbsp;&nbsp;&nbsp;hui.get(
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&#39;http://hoa.hcoder.net/index.php?user=hcoder&amp;pwd=hcoder&amp;m=list1&amp;page=1&#39;,
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;function(res){
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;var&nbsp;data&nbsp;=&nbsp;res.split(&#39;--hcSplitor--&#39;);
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;var&nbsp;html&nbsp;=&nbsp;&#39;&#39;;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;for(var&nbsp;i&nbsp;=&nbsp;0;&nbsp;i&nbsp;&lt;&nbsp;data.length;&nbsp;i++){
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;html&nbsp;+=&nbsp;&#39;&lt;li&gt;&#39;+data[i]+&#39;&lt;/li&gt;&#39;;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;hui(&#39;#list&#39;).html(html);
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;hui.endRefresh();
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;//关闭loading
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;hui.loading(&#39;加载中...&#39;,&nbsp;true);
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;},
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;function(){
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;hui.loading(&#39;加载中...&#39;,&nbsp;true);
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;nbsp;&nbsp;&nbsp;&nbsp;hui.upToast(&#39;连接服务器失败！&#39;);
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;hui.endRefresh();
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}
&nbsp;&nbsp;&nbsp;&nbsp;);
}
&lt;/script&gt;
&lt;/body&gt;
&lt;/html&gt;</pre>			</div>
                <div id="footerLine"></div>
                <div id="footer">
                    <a href="/course">教程</a>|
                    <a href="/share">交流分享</a>|
                    <a href="javascript:void(0);">客服QQ : 275300091</a>|
                    <span style="padding-left:12px;">QQ交流群 : 2群 340610532 (满), 1群 335126794 (千人群)</span>
                    <br />
                    CopyRight &copy; 2017 - 2020 Hcoder.net - 致力于中国web开发行业发展&nbsp;&nbsp;&nbsp;&nbsp;陕ICP备14004669号-2
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
                </script>			</td>
        </tr>
    </table>
</div>
<script type="text/javascript" src="http://www.hcoder.net/public/scripts/common.js"></script>
<script type="text/javascript" src="http://www.hcoder.net/public/scripts/prettify.js" charset="UTF-8"></script>
<script type="text/javascript" src="http://www.hcoder.net/public/scripts/jquery.zclip.js" charset="UTF-8"></script>
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
