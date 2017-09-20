<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>云朵课堂-在线教育网校系统/网校搭建/在线教育解决方案</title>
    <meta name="description" content="网校系统，在线教育，在线教育平台，搭建网校，网上教育平台，网校平台，在线辅导平台，网校搭建,教育云平台,远程教学软件，创建网校，MOOC系统，教育云，网络教育平台，在线授课，在线教育平台有哪些。">
    <meta name="keywords" content="云朵课堂，昱新科技，昱新教育，北京昱新科技，CRM系统，学员报名系统，教学运营系统，教务运营平台，网校搭建,直播平台，录播课程，在线题库，在线直播，直播课，视频课，题库，让你拥有自己的域名和独立的品牌!一分钟上线你的网校">
    <meta name="author" content="chopin,xb.sun.8813@gmail.com">
    <link rel="stylesheet" type="text/css" href="css/base.css">
    <link rel="stylesheet" type="text/css" href="css/animate.css">
    <link rel="stylesheet" type="text/css" href="css/lightbox.css">
    <link rel="stylesheet" type="text/css" href="css/idangerous.swiper.css">
    <link rel="shortcut icon" href="image/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" type="text/css" href="css/index.css">
    <script type="text/javascript" src="js/html5.js"></script>
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript">
        var _hmt = _hmt || [];
        (function() {
            var hm = document.createElement("script");
            hm.src = "js/hm.js";
            var s = document.getElementsByTagName("script")[0];
            s.parentNode.insertBefore(hm, s);
        })();
 function gotoRegister() {
            var url = 'yunduo/registerPage.html';
            var params = location.href.split("?")[1];
            
                url += '?';
                url += "utm_url=" + encodeURI(location.href);
            //location.href=url;
            window.open(url);
        }

  
        function gotoOffer() {
            var url = 'price.html';
            var params = location.href.split("?")[1];
            if (params) {
                url += '?' + params;
                url += "&utm_url=" + encodeURI(location.href);
            }

            //location.href=url;
            window.open(url);
        }
        $(document).on("scroll", function() {
            var scrollTop = $(document).scrollTop();
            if (scrollTop >= 422) {
                $(".nav").addClass("nav2");
            } else {
                $(".nav").removeClass("nav2");
            }
        })

       var thisUrl=window.location.href;
     function addlxContent(){
        var name=$("#lxPhoe").val();
        var mobile=$("#lxMobile").val();
        var email=$("#lxContent").val();
        var qq=$("#lxQQ").val();
        isOk=isRightMobile(mobile);
        if(isOk){
            $.ajax({
                url: "http://manage.yunduoketang.com/leaveWords",
                type: "get",
                dataType: "jsonp",
                data:{
                    "name":name,
                    "mobile":mobile,
                    "qq":qq,
                    "contens":email,
                    "thisUrl":thisUrl
                },
                jsonp: "callback",
                success: function(data) {
                    
                },
                complete:function(){
                    alert("留言成功,我们会尽快给您联系");
                }
            });
        }
    }
    function addSqContent(type){
        if(type){
            sqName = $("#sqName"+type).val();
            sqMobile = $("#sqMobile"+type).val();
            isOk=isRightMobile(sqMobile);
            if(isOk){
                $.ajax({
                    url: "http://manage.yunduoketang.com/leaveWords",
                    type: "get",
                    dataType: "jsonp",
                    data:{
                        "name":sqName,
                        "mobile":sqMobile,
                        "thisUrl":thisUrl
                    },
                    jsonp: "callback",
                    success: function(data) {
                       
                    },
                    complete:function(){
                        alert("留言成功");
                    }
                });
            }
        }
    }
    function isRightMobile(mobile){
        if(mobile.length<=0){
            alert("请输入手机号");
            return false;
        }
        if(isNaN(mobile)){
            alert("请输入正确的手机号");
            return false;
        }
        if(mobile.length!=11){
            alert("请输入正确的手机号");
            return false;
        }
        var myMobile = /^(((13[0-9]{1})|(14[0-9]{1})|(15[0-9]{1})|(17[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
        if(!myMobile.test(mobile)) 
        { 
            alert('请输入有效的手机号码！'); 
            return false;
        } 
        return true;
    }


    </script>
    <!--[if lt IE 10]>
    <script src="js/ie8.js"></script>
    <![endif]-->
    <script>
        var _hmt = _hmt || [];

        (function() {

            var hm = document.createElement("script");

            hm.src = "//hm.baidu.com/hm.js?e23da8729371a8208597067d4c986ad0";

            var s = document.getElementsByTagName("script")[0];

            s.parentNode.insertBefore(hm, s);

        })();

    </script>
</head>

<body>
 <div class="body" style="background-color:grey">
   <img src="images/pic3/banner.jpg" height="500">
 </div>
 <div class="body" style="background-color:grey">
   <img src="images/pic3/banner.jpg" height="500">
 			<section class="ft" style="background-color:grey">
            <img src="images/pic3/banner.jpg" height="500">
            <div class="f-box">
                <p class="title">即刻启程：开启您的在线教育网校</p>
                <p class="caption">互联网让学习更加便利，云朵课堂让所有机构5分钟拥有自己独立网校，我们生活在一个充满无限可能的时代，在线教育让人人都能享受优质教育的机会， 我们的理想，就是将世界上最优质的教育资源，专递到地球的每一个角落。
                </p>
                <br>
                <a href="javascript:void(0);" onclick="doyoo.util.openChat('g=10057197')">开通网校点击咨询</a>
                <a href="javascript:gotoRegister();" style="margin-left:20px;">点击注册免费试用</a>
            </div>
        </section>
     	
     </div>
        <header>
        <div class="nav w1259">
            <div class="logo"><img src="images/logo.png"></div>
            <div class="links">
                <a href="#" class="">首页</a>
                <a href="#live" class="">在线直播 </a>
                <a href="#video" class="">在线录播</a>
                <a href="#erp" class="">教学ERP</a>
                <a href="price.html" target="_blank" class="">服务报价</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a href="javascript:gotoRegister();" style="border:solid 2px #fff;border-radius:5px;">免费试用</a>
                <a href="http://manage.yunduoketang.com/login" target="_blank" class="" style="">登录</a>
                <b href="javascript:void(0);" style="color:#fff; font-size: 18px"><img src="images/pic1/phone_ico.png"
                                                            style="margin:3px 10px -2px 30px">400-965-8366</b>
            </div>
        </div>
    </header>
    <div class="body">
        <section class="sec1">
            <div class="title-newly">在线教育迎来“风口”时代，大数据，催生大市场</div>
            <div class="chart-content">
                <div class="chart-box">
                    <div class="chart-title"><span>7000</span>多万在线教育用户，以<span>15%</span>的速度增长</div>
                    <div id="usersnum" class="echa" style="height:280px;width: 460px;"></div>
                    <div class="exp">
                        <p>据艾瑞咨询数据显示，2014年在线教育用户规模为7769.9</p>

                        <p>万人，同比增长16%，未来几年，在线教育用户将保持15%</p>

                        <p>以上的速度继续增长，到2017年将达到1.2亿人</p>
                    </div>
                </div>
                <div class="chart-box" style="padding-bottom:50px;">
                    <div class="chart-title"><span>900</span>多亿的在线教育市场规模</div>
                    <div id="marketsize" class="echa" style="height:280px"></div>
                    <div class="exp">
                        <p>2014年在线教育市场规模达到998亿，同比增长速度为</p>

                        <p>18.9%， 随着在线教育用户群体的不断扩大，还将有更大的发</p>

                        <p>展， 预计到2017年达1733.9亿</p>
                    </div>
                </div>
            </div>
            <div class="clear"></div>
        </section>
        
        <section class="sec3 q_box">
            <div class="cont">
                <div class="img fl"><img src="./images/pic6/benfit_02.png" alt="" /></div>
                <div class="right fr tt wow fadeInUp animated" style="visibility: visible; animation-name: fadeInUp;">
                    <div class="title" style="height: 90px; line-height: 90px; padding-top: 50px;">多终端切换 学员任意选择学习方式</div>
                    <p>支持手机APP、微信网校、Pad、PC网页端等多种终端接入，学员数据自动同步到云端各终端自由切换，无论Windows、MAC操系统，网页都可使用，IE、Safari、Chrome主流浏览器全兼容打开，手机APP 微信网校同步使用</p>
                </div>
            </div>
            <div class="ueser-box" style="padding-bottom: 40px;">
                <div class="urser-cont clear">
                    <div class="user-icon user-icon1"><img src="images/pic6/iconfont-teacher.png" alt=""></div>
                    <div class="uer-info user-name">
                        <input type="text" id="sqName3" placeholder="输入姓名">
                    </div>
                    <div class="user-icon"><img src="images/pic6/iconfont-dianhua.png" alt=""></div>
                    <div class="uer-info user-phone">
                        <input type="text" id="sqMobile3" placeholder="输入电话">
                    </div>
                    <div class="try user-btn"><a href="javascript:void(0);" onclick="javascript:addSqContent(3);">免费开通试用</a></div>
                    <div class="set-school user-btn"><a href="javascript:void(0);" onclick="doyoo.util.openChat('g=10057179')">搭建网校咨询</a>
                    </div>
                </div>
            </div>
        </section>
        <section class="sec4 q_box">
            <div class="itm-wrap">
                <div class="itm">
                    <div class="itm-block wow bounceInLeft animated" style="margin-bottom: 70px; visibility: visible; animation-delay: 0.1s; animation-name: bounceInLeft;" data-wow-duration="0.5" data-wow-delay="0.1s">
                        <h1>节省研发资金投入</h1>

                        <p>无需组建研发团队，云朵课堂帮您节省百万研发费用 </p>
                    </div>
                    <div class="itm-block wow bounceInLeft animated" data-wow-duration="0.5" data-wow-delay="0.3s" style="visibility: visible; animation-delay: 0.3s; animation-name: bounceInLeft;">
                        <h1>节省硬件资金投入</h1>

                        <p>无需购买服务器、机柜、机房、带宽，帮您每年节省十几万</p>
                    </div>
                </div>
                <div class="itm img wow rubberBand animated q_sprit" style="visibility: visible; animation-name: rubberBand;">
                    <div class="words">
                        <h1>没有技术团队也能拥有<br>自己独立网校平台</h1>

                        <p>
                            云课堂提供专业的SAAS服务，大大降低了教 育培训的机构进入在线教育行业的门槛
                            <br>让教育机构无需百万研发资金投入，仅需千
                            <br>元就能快速、高质量的开展自主品牌的
                            <br>在线教育课程
                        </p>
                        <a class="btn btn-primary" href="javascript:gotoRegister()" onclick="event.stopPropagation();" style="border: none; background:none;">点击注册免费试用</a>
                    </div>
                </div>
                <div class="itm">
                    <div class="itm-block wow bounceInRight animated" style="margin-bottom: 70px; visibility: visible; animation-delay: 0.1s; animation-name: bounceInRight;" data-wow-duration="0.2" data-wow-delay="0.1s">
                        <h1>无需长时间等待</h1>

                        <p>无需半年以上研发时间，即刻布局在线教育市场，抢占市场先机</p>
                    </div>
                    <div class="itm-block wow bounceInRight animated" data-wow-duration="0.5" data-wow-delay="0.3s" style="visibility: visible; animation-delay: 0.3s; animation-name: bounceInRight;">
                        <h1>网校终身免费升级</h1>

                        <p>用户体验和系统功能每周迭代更新，专业团队24小时全方位服务</p>
                    </div>
                </div>
                <div class="ueser-box" style="padding-bottom: 40px;">
                    <div class="urser-cont clear">
                        <div class="user-icon user-icon1"><img src="images/pic6/iconfont-teacher.png" alt=""></div>
                        <div class="uer-info user-name">
                            <input type="text" id="sqName4" placeholder="输入姓名">
                        </div>
                        <div class="user-icon"><img src="images/pic6/iconfont-dianhua.png" alt=""></div>
                        <div class="uer-info user-phone">
                            <input type="text" id="sqMobile4" placeholder="输入电话">
                        </div>
                        <div class="try user-btn"><a href="javascript:void(0);" onclick="javascript:addSqContent(4);">免费开通试用</a></div>
                        <div class="set-school user-btn"><a href="javascript:void(0);" onclick="doyoo.util.openChat('g=10057179')">搭建网校咨询</a>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <section class="sec5">
            <div style="width:1100px;" class="w1100 clear">
                <div class="fl">
                    <div class="content">
                        <div class="cc tt wow fadeInDown">
                            <img src="images/pic1/pic1_r13_c4.png" alt="">

                            <p>独立设置网校域名</p>
                        </div>
                        <div class="cc tt wow fadeInDown">
                            <img src="images/pic1/pic1_r13_c14.png" alt="">

                            <p>自定义域名LOGO</p>
                        </div>
                        <div class="cc n-border tt wow fadeInDown">
                            <img src="images/pic1/pic1_r14_c19.png" alt="">

                            <p>自定义网校模板</p>
                        </div>
                        <div class="cc-line"></div>
                        <div class="cc tt wow fadeInUp">
                            <img src="images/pic1/pic1_r14_c26.png" alt="">

                            <p>42台云服务器部署</p>
                        </div>
                        <div class="cc tt wow fadeInUp">
                            <img src="images/pic1/pic1_r14_c35.png" alt="">

                            <p>200百兆带宽保障</p>
                        </div>
                        <div class="cc n-border tt wow fadeInUp">
                            <img src="images/pic1/pic1_r14_c40.png" alt="">

                            <p>在线支付即时到账</p>
                        </div>
                    </div>
                </div>
                <div class="fr" style="width: 500px">
                    <div class="tt wow fadeInUp">
                        <div class="title">云朵课堂为您提供在线教育
                            <br/>一站式专业解决方案</div>
                        <div class="sub-title">提供一站式建站服务：服务器，空间，程序安装，可全部由我们提供</div>
                        <div class="sub-title">您只需要购买服务，提供域名，即刻拥有自己在线教育站点</div>
                        <div class="btns">
                            <a class="btn btn-primary" href="javascript:void(0);" onclick="doyoo.util.openChat('g=10057183')">索取网校解决方案</a>
                            <a class="btn btn-primary" href="javascript:gotoRegister();">点击注册免费试用</a>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <section class="sec6" id="live">

            <div class="tt wow fadeInUp">

                <div class="title">直播授课沟通无障碍 在线课堂胜过真实课堂</div>

            </div>

            <div class="live-btn">

                <ul class="live-btn-box">
                    <li class="flip-container">
                        <div href="#" class="flipper">
                            <div class="front ">
                                <div class="btn-pic p1"></div>
                                <p>3分屏教学互动直播</p>
                            </div>
                            <div class="back ">
                                <div>模拟真实课堂的教学环境,老师与学员实现互动，简单易用的授课工具支持PPT、视频、语音、文字等</div>
                            </div>
                        </div>
                    </li>
                    <li class="flip-container">
                        <div href="#" class="flipper">
                            <div class="front ">
                                <div class="btn-pic p2"></div>
                                <p>电子白板与PPT随意切换</p>
                            </div>
                            <div class="back ">
                                <div>电子白板与课件PPT自由切换，重点内容标注支持画笔工具、字体、橡皮擦、一键清空等工具</div>
                            </div>
                        </div>
                    </li>
                    <li class="flip-container">
                        <div href="#" class="flipper">
                            <div class="front ">
                                <div class="btn-pic p3"></div>
                                <p>直播课程随时回看</p>
                            </div>
                            <div class="back ">
                                <div>直播教学中支持全屏录制，方便学员复习和未能到场的学员补习，随时回看上课内容，按需查漏补缺</div>
                            </div>
                        </div>
                    </li>
                    <li class="flip-container">
                        <div href="#" class="flipper">
                            <div class="front ">
                                <div class="btn-pic p4"></div>
                                <p>调研问卷电子投票</p>
                            </div>
                            <div class="back ">
                                <div>老师发起投票后实时统计投票结果查看，投票人数统计，个人选项查看，人数占比统计，选项占比统计</div>
                            </div>
                        </div>
                    </li>
                    <li class="flip-container">
                        <div href="#" class="flipper">
                            <div class="front ">
                                <div class="btn-pic p5"></div>
                                <p>学生举手在线答疑</p>
                            </div>
                            <div class="back ">
                                <div>课堂反馈的机制：学员对课程有问题时可以举手提问，经过允许后发言老师或助教进行在线答疑</div>
                            </div>
                        </div>
                    </li>
                    <li class="flip-container">
                        <div href="#" class="flipper">
                            <div class="front ">
                                <div class="btn-pic p6"></div>
                                <p>课程内容资料共享</p>
                            </div>
                            <div class="back ">
                                <div>老师可以在直播教室里面共享课程资料给学员，支持ppt，word，excel，pdf,swf等常用电子文件格式</div>
                            </div>
                        </div>
                    </li>
                    <li class="flip-container">
                        <div href="#" class="flipper">
                            <div class="front ">
                                <div class="btn-pic p7"></div>
                                <p>桌面共享界面同步</p>
                            </div>
                            <div class="back ">
                                <div>老师可将自己电脑桌面共享给学员，随时使用本地MP3、MP4多媒体文件辅助教学或进行软件操作的演示</div>
                            </div>
                        </div>
                    </li>
                    <li class="flip-container">
                        <div href="#" class="flipper">
                            <div class="front ">
                                <div class="btn-pic p8"></div>
                                <p>把控集体讨论内容</p>
                            </div>
                            <div class="back ">
                                <div>教师为直接教室里最高权限人，讨论区后台可监控学员文字交流信息，设置全部学员查看或老师单独查看</div>
                            </div>
                        </div>
                    </li>
                    <li class="flip-container">
                        <div href="#" class="flipper">
                            <div class="front ">
                                <div class="btn-pic p9"></div>
                                <p>视频/音频在线互动</p>
                            </div>
                            <div class="back ">
                                <div>师生间多元化沟通交流：学员可以通过视频或语音与老师进行沟通交流，课堂互动提高直播教学质量</div>
                            </div>
                        </div>
                    </li>
                    <li class="flip-container">
                        <div href="#" class="flipper">
                            <div class="front ">
                                <div class="btn-pic pic10"></div>
                                <p>助教老师辅助教学</p>
                            </div>
                            <div class="back ">
                                <div>直播课程过程中助教可以辅助直播老师把控课程进程，对学员进行课堂秩序维护或问题答疑</div>
                            </div>
                        </div>
                    </li>
                    <li class="flip-container">
                        <div href="#" class="flipper">
                            <div class="front ">
                                <div class="btn-pic p11"></div>
                                <p>1对1视频互动教学</p>
                            </div>
                            <div class="back ">
                                <div>专属私教的高端教学，封闭式、无打扰、无延时、全方面，可以实时共享各类课件和沟通工具</div>
                            </div>
                        </div>
                    </li>
                    <li class="flip-container">
                        <div href="#" class="flipper">
                            <div class="front ">
                                <div class="btn-pic p12"></div>
                                <p>300万人同时在线</p>
                            </div>
                            <div class="back ">
                                <div>强大系统能力可同时承载万人在线直播依然高清流畅，视频互动语音交流，让所有人都可以参与进来</div>
                            </div>
                        </div>
                    </li>
                    <li class="flip-container">
                        <div href="#" class="flipper">
                            <div class="front ">
                                <div class="btn-pic p13"></div>
                                <p>海量教学视频空间</p>
                            </div>
                            <div class="back ">
                                <div>自动录制永久存储，直播系统标配10T存储空间，可无限扩展全运营商视频加速支持，超过1.2T自有带宽储备</div>
                            </div>
                        </div>
                    </li>
                    <li class="flip-container">
                        <div href="#" class="flipper">
                            <div class="front ">
                                <div class="btn-pic p14"></div>
                                <p>两大操作系统全兼容</p>
                            </div>
                            <div class="back ">
                                <div>教师无需安装客户端，无论Windows、MAC操系统，打开网页即可使用，IE、Safari、Chrome主流浏览器全兼容</div>
                            </div>
                        </div>
                    </li>
                    <li class="flip-container">
                        <div href="#" class="flipper">
                            <div class="front ">
                                <div class="btn-pic pic15"></div>
                                <p>手机移动终端支持</p>
                            </div>
                            <div class="back ">
                                <div>支持电脑、iPad和手机的使用，实现碎片化学习和碎片化管理</div>
                            </div>
                        </div>
                    </li>
                </ul>
                <div class="clear"></div>

            </div>

            <div class="btns">

                <a class="btn btn-primary" href="javascript:void(0);" onclick="doyoo.util.openChat('g=10057180')">在线直播点击咨询</a>

                <a class="btn btn-primary" href="javascript:gotoRegister();">免费体验直播系统</a>

            </div>
        </section>
        <section class="sec7" id="video">
            <div class="tt wow fadeInUp">
                <div class="title">录播授课9项辅助教学功能 在线教学更随心</div>
                <div class="sub-title">提供专业的学习体验，绝不仅是视频浏览，包含课程大纲、自动上次</div>
                <div class="sub-title">播放、收藏、评论打分等功能，还有相关资料、重点提醒、章节选择</div>
            </div>
            <div class="content w1259">
                <div class="cc">
                    <img class="k12 wow flipInY" src="images/pic4/icon_11_r1_c1.png">

                    <p>自定义章节学习</p>
                </div>
                <div class="cc">
                    <img class="zy wow flipInY" src="images/pic4/icon_11_r1_c4.png">

                    <p>课程笔记回看</p>
                </div>
                <div class="cc">
                    <img class="jy wow flipInY" src="images/pic4/icon_11_r1_c8.png">

                    <p>课程内容收藏</p>
                </div>
                <div class="cc">
                    <img class="yy wow flipInY" src="images/pic4/icon_11_r1_c12.png">

                    <p>课程评论打分</p>
                </div>
                <div class="cc">
                    <img class="xq wow flipInY" src="images/pic4/icon_11_r1_c15.png">

                    <p>学习进度跟踪</p>
                </div>
                <div class="cc">
                    <img class="xq wow flipInY" src="images/pic4/icon_11_r1_c17.png">

                    <p>防录屏安全设置</p>
                </div>
            </div>
            <div class="content w1259">
                <div class="cc">
                    <img class="k12 wow flipInY" src="images/pic4/icon_11_r3_c1.png">

                    <p>课程观看有效期</p>
                </div>
                <div class="cc">
                    <img class="zy wow flipInY" src="images/pic4/icon_11_r3_c3.png">

                    <p>观看次数限制</p>
                </div>
                <div class="cc">
                    <img class="jy wow flipInY" src="images/pic4/icon_11_r3_c7.png"></img>

                    <p>课件共享下载</p>
                </div>
                <div class="cc">
                    <img class="yy wow flipInY" src="images/pic4/icon_11_r3_c11.png"></img>

                    <p>移动终端查看</p>
                </div>
                <div class="cc">
                    <img class="xq wow flipInY" src="images/pic4/icon_11_r3_c15.png"></img>

                    <p>视频秒速缓冲</p>
                </div>
                <div class="cc">
                    <img class="xq wow flipInY" src="images/pic4/icon_11_r3_c17.png"></img>

                    <p>多格式视频上传</p>
                </div>
            </div>
            <div class="btns">
                <a class="btn btn-primary" href="javascript:void(0);" onclick="doyoo.util.openChat('g=10057181')">录播功能点击咨询</a>
                <a class="btn btn-primary" href="javascript:gotoRegister();">点击注册免费试用</a>
            </div>
        </section>
        <section class="sec9">
            <div class="content w1259 bgf8" style="background-color:grey">
                <div class="title">网校考试题库功能&nbsp;随堂测验智能组卷</div>

                <div class="sub-title">老师随时组织知识竞赛、布置课外作业、安排章节练习、随堂测验</div>

                <div class="sub-title">智能组卷、答卷评阅与成绩管理等众多功能</div>

                <div class="center-box clear">
                    <div class="bgimg1">
                        <p>多种题库管理模块</p>

                        <p class="bgimg-con">提供单选题、多选题、填空题、判断题、简单题、案例题等多种类型试题编制工具，并能对试题进行分类管理。</p>

                        <div onclick="doyoo.util.openChat('g=10057178')" class="low-btn low-1">点击了解详情</div>
                    </div>
                    <div class="bgimg2">
                        <p>自定义考试管理模块</p>

                        <p class="bgimg-con">试卷管理中管理员可选取题库中的试题进行组卷，问卷功能灵活，用户可自定义试卷标题、分值、时间、难度系数等。</p>

                        <div onclick="doyoo.util.openChat('g=10057178')" class="low-btn low-2">点击了解详情</div>
                    </div>
                    <div class="bgimg3">
                        <p>自动阅卷与评卷</p>

                        <p class="bgimg-con">根据试卷不同的题型进行识别，若为客观题将提供系统自动阅卷功能；若为主观题，将为管理员提供评卷功能。</p>

                        <div onclick="doyoo.util.openChat('g=10057178')" class="low-btn low-3">点击了解详情</div>
                    </div>
                </div>
            </div>
        </section>
        
       
        <section class="sec13">

            <div class="tt wow fadeInUp">

                <div class="title">从建站到上课一站式研发服务 &nbsp;&nbsp;邀你免费体验</div>

                <div class="sub-title">10秒注册完成，支持PC、pad、手机微信 在线体验</div>

                <div class="sub-title">赠送20个直播并发 20GB空间/流量</div>

            </div>

            <div class="online-btn">

                <ul class="online-btn-box">
                    <li class="">
                        <div>
                            <img src="images/pic5/fan_pic_03.png" alt="" />
                        </div>
                        <p>独立域名网校</p>
                    </li>
                    <li class="">
                        <div>
                            <img src="images/pic5/fan_pic_05.png" alt="" />
                        </div>
                        <p>在线直播课程</p>
                    </li>
                    <li class="">
                        <div>
                            <img src="images/pic5/fan_pic_07.png" alt="" />
                        </div>
                        <p>录播课程学习</p>
                    </li>
                    <li class="">
                        <div>
                            <img src="images/pic5/fan_pic_09.png" alt="" />
                        </div>
                        <p>在线考试题库</p>
                    </li>
                    <li class="">
                        <div>
                            <img src="images/pic5/fan_pic_11.png" alt="" />
                        </div>
                        <p>师生讨论小组</p>
                    </li>
                    <li class="border-r">
                        <div>
                            <img src="images/pic5/fan_pic_14.png" alt="" />
                        </div>
                        <p>直播公开课</p>
                    </li>
                    <li class="">
                        <div>
                            <img src="images/pic5/fan_pic_22.png" alt="" />
                        </div>
                        <p>课程收藏评论</p>
                    </li>
                    <li class="">
                        <div>
                            <img src="images/pic5/fan_pic_25.png" alt="" />
                        </div>
                        <p>手机微信课堂</p>
                    </li>
                    <li class="">
                        <div>
                            <img src="images/pic5/fan_pic_29.png" alt="" />
                        </div>
                        <p>在线支付交易</p>
                    </li>
                    <li class="">
                        <div>
                            <img src="images/pic5/fan_pic_23.png" alt="" />
                        </div>
                        <p>短信邮件通知</p>
                    </li>
                    <li class="">
                        <div>
                            <img src="images/pic5/fan_pic_31.png" alt="" />
                        </div>
                        <p>教学资源管理</p>
                    </li>
                    <li class="border-r">
                        <div>
                            <img src="images/pic5/fan_pic_27.png" alt="" />
                        </div>
                        <p>智能排课功能</p>
                    </li>
                    <li class="border-b">
                        <div>
                            <img src="images/pic5/fan_pic_42.png" alt="" />
                        </div>
                        <p>学员档案管理</p>
                    </li>
                    <li class="border-b">
                        <div>
                            <img src="images/pic5/fan_pic_44.png" alt="" />
                        </div>
                        <p>用户权限管理</p>
                    </li>
                    <li class="border-b">
                        <div>
                            <img src="images/pic5/fan_pic_46.png" alt="" />
                        </div>
                        <p>新闻资讯公告</p>
                    </li>
                    <li class="border-b">
                        <div>
                            <img src="images/pic5/fan_pic_48.png" alt="" />
                        </div>
                        <p>数据报表统计</p>
                    </li>
                    <li class="border-b">
                        <div>
                            <img src="images/pic5/fan_pic_39.png" alt="" />
                        </div>
                        <p>网校营销设置</p>
                    </li>
                    <li class="border-r border-b">
                        <div>
                            <img src="images/pic5/fan_pic_41.png" alt="" />
                        </div>
                        <p>网校模板配置</p>
                    </li>
                </ul>
                <div class="clear"></div>

            </div>

            <div class="ueser-box" style="padding-bottom: 40px;">
                <div class="urser-cont clear">
                    <div class="user-icon user-icon1"><img src="images/pic6/iconfont-teacher.png" alt=""></div>
                    <div class="uer-info user-name">
                        <input type="text" id="sqName13" placeholder="输入姓名">
                    </div>
                    <div class="user-icon"><img src="images/pic6/iconfont-dianhua.png" alt=""></div>
                    <div class="uer-info user-phone">
                        <input type="text" id="sqMobile13" placeholder="输入电话">
                    </div>
                    <div class="try user-btn"><a href="javascript:void(0);" onclick="javascript:addSqContent(13);">免费开通试用</a></div>
                    <div class="set-school user-btn"><a href="javascript:void(0);" onclick="doyoo.util.openChat('g=10057179')">搭建网校咨询</a>
                    </div>
                </div>
            </div>

        </section>
        <section class="sec14 q_box">
            <div class="tt wow fadeInUp">
                <div class="title">自定义界面展示 多套风格可供选择</div>
                <div class="sub-title">系统配置多套精美模板可供选择，仅需一键更换应用
                    <br>模板，轻松的进行模板界面自定义修改</div>
            </div>
            <div class="content">
                <a class="arrow-left" href="javascript:void(0);"></a>
                <a class="arrow-right" href="javascript:void(0);"></a>

                <div class="swiper-container">
                    <div class="swiper-wrapper clear">
                        <div class="swiper-slide">
                            <a href="images/sample4.jpg" class="show show2" data-lightbox="roadtrip">
                                <img src="images/sample4.jpg" width="100%" alt="">
                                <span>
                                <button>查看示例</button>
                            </span>
                            </a>
                        </div>
                        <div class="swiper-slide">
                            <a href="images/sample5.jpg" class="show show2" data-lightbox="roadtrip">
                                <img src="images/sample5.jpg" width="100%" alt="">
                                <span>
                                <button>查看示例</button>
                            </span>
                            </a>
                        </div>
                        <div class="swiper-slide">
                            <a href="images/sample1.jpg" class="show show1" data-lightbox="roadtrip">
                                <img src="images/sample1.jpg" width="100%" alt="">
                                <span>
                                <button>查看示例</button>
                            </span>
                            </a>
                        </div>
                        <div class="swiper-slide">
                            <a href="images/sample2.jpg" class="show show2" data-lightbox="roadtrip">
                                <img src="images/sample2.jpg" width="100%" alt="">
                                <span>
                                <button>查看示例</button>
                            </span>
                            </a>
                        </div>
                        <div class="swiper-slide">
                            <a href="images/sample3.jpg" class="show show1" data-lightbox="roadtrip">
                                <img src="images/sample3.jpg" width="100%" alt="">
                                <span>
                                    <button>查看示例</button>
                                </span>
                            </a>
                        </div>
                        <div class="swiper-slide">
                            <a href="images/sample4.jpg" class="show show2" data-lightbox="roadtrip">
                                <img src="images/sample4.jpg" width="100%" alt="">
                                <span>
                                <button>查看示例</button>
                            </span>
                            </a>
                        </div>
                        <div class="swiper-slide">
                            <a href="images/sample5.jpg" class="show show2" data-lightbox="roadtrip">
                                <img src="images/sample5.jpg" width="100%" alt="">
                                <span>
                                <button>查看示例</button>
                            </span>
                            </a>
                        </div>
                        <div class="swiper-slide">
                            <a href="images/sample1.jpg" class="show show1" data-lightbox="roadtrip">
                                <img src="images/sample1.jpg" width="100%" alt="">
                                <span>
                                <button>查看示例</button>
                            </span>
                            </a>
                        </div>
                        <div class="swiper-slide">
                            <a href="images/sample2.jpg" class="show show2" data-lightbox="roadtrip">
                                <img src="images/sample2.jpg" width="100%" alt="">
                                <span>
                                <button>查看示例</button>
                            </span>
                            </a>
                        </div>
                    </div>
                </div>
                <div class="pagination"></div>
            </div>
        </section>
        <section class="sec15 q_box" id="erp">
            <div class="tt wow fadeInUp">
                <div class="title" style="color: #1C6E8B; height: 112px; line-height: 112px;">节约成本 网校ERP功能 省去教务老师时间</div>
            </div>
            <div class="q_sprit" style="width:1056px;">
                <div class="q_item item1 animated flipInY wow tt" style=" visibility: visible; animation-delay: 0.3s; animation-name: flipInY;" data-wow-duration="0.5" data-wow-delay="0.3s">
                    <strong>排课系统</strong>
                    <span>面授课程智能排课老 师教室合理安排 </span>
                </div>
                <div class="q_item item2 animated flipInY wow tt" style=" visibility: visible; animation-delay: 0.3s; animation-name: flipInY;" data-wow-duration="0.5" data-wow-delay="0.3s">
                    <strong>上课通知</strong>
                    <span>学员通知不在漏掉系统 提醒自动短信邮件通知 </span>
                </div>
                <div class="q_item item3 animated flipInY wow tt" style=" visibility: visible; animation-delay: 0.3s; animation-name: flipInY;" data-wow-duration="0.5" data-wow-delay="0.3s">
                    <strong>代报服务</strong>
                    <span>代报材料收集，不会丢失任何学员数据 </span>
                </div>
                <div class="q_item item4 animated flipInY wow tt" style=" visibility: visible; animation-delay: 0.3s; animation-name: flipInY;" data-wow-duration="0.5" data-wow-delay="0.3s">
                    <strong>分期催费</strong>
                    <span>支持学费分期管理 催缴提醒不会丢失</span>
                </div>
                <div class="q_item item5 animated flipInY wow tt" style=" visibility: visible; animation-delay: 0.3s; animation-name: flipInY;" data-wow-duration="0.5" data-wow-delay="0.3s">
                    <strong>报名收费</strong>
                    <span>学员报名，支付宝、微信转账、银联转账  </span>
                </div>
            </div>
            <div class="ueser-box" style="padding-bottom: 40px;">
                <div class="urser-cont clear">
                    <div class="user-icon user-icon1"><img src="images/pic6/iconfont-teacher.png" alt=""></div>
                    <div class="uer-info user-name">
                        <input type="text" id="sqName15" placeholder="输入姓名">
                    </div>
                    <div class="user-icon"><img src="images/pic6/iconfont-dianhua.png" alt=""></div>
                    <div class="uer-info user-phone">
                        <input type="text" id="sqMobile15" placeholder="输入电话">
                    </div>
                    <div class="try user-btn"><a href="javascript:void(0);" onclick="javascript:addSqContent(15);">免费开通试用</a></div>
                    <div class="set-school user-btn"><a href="javascript:void(0);" onclick="doyoo.util.openChat('g=10057179')">搭建网校咨询</a>
                    </div>
                </div>
            </div>

        </section>
        <section class="sec17">
            <div class="title">云朵课堂符合国际信息安全TCSEC标准A类等级</div>
            <div class="sub-title">网校安全稳定性，您的担心我们都会提前想到,我们采用
                <br/>国际信息安全标准保障您的使用安全</div>
            <div class="cont">
                <div class="cont-itm tt wow bounceInLeft" data-wow-delay="0.5s">
                    <h3>学员账户安全性</h3>
                    <div class="words">
                        在数据存储和传输安全方面，用户使用过程中的密码全部通过 最安全的MD5加密算法,避免在使用过程中密码泄露，为机构的信息提供100%安全保障。内部管理中，机构账户数据全部加密我们也无法查看
                    </div>
                    <a href="javascript:void(0);" onclick="doyoo.util.openChat('g=10057189')">网校安全咨询</a>
                </div>
                <div class="cont-itm tt wow bounceInLeft">
                    <h3>视频课程安全性</h3>

                    <div class="words">
                        拥有完善的视频保护机制，添加水印、防下载、ID跑马灯效果， 视频加密，用来有效防止盗链、录屏、下载等盗版途径用作商业用途，切实做到版权无忧
                    </div>
                    <a href="javascript:void(0);" onclick="doyoo.util.openChat('g=10057189')">网校安全咨询</a>
                </div>
                <div class="cont-itm tt wow bounceInRight" data-wow-delay="0.2s">
                    <h3>网校系统稳定性</h3>

                    <div class="words">
                        为保护网校系统安全，在设计中采用了多层次的安全防护措施,顺利通过阿里渗透式测试，使系统最大限度地不被黑客和有意破坏者攻击
                    </div>
                    <a href="javascript:void(0);" onclick="doyoo.util.openChat('g=10057189')">网校安全咨询</a>
                </div>
                <div class="cont-itm tt wow bounceInRight" data-wow-delay="0.5s">
                    <h3>多重安全性保障</h3>

                    <div class="words">
                        采用阿里专业的云盾防火墙和安骑士防护系统，为云朵课堂提供安全防护策略、木马文件检测、 高危漏洞检测和修复，并对系统的安全进行实时监控和管理
                    </div>
                    <a href="javascript:void(0);" onclick="doyoo.util.openChat('g=10057189')">网校安全咨询</a>
                </div>
            </div>
        </section>
        <section class="sec18 q_box">
            <div class="tt wow fadeInUp">
                <div class="title">我们提供私有定制服务&nbsp;&nbsp;满足您的独特需求</div>
                <div class="sub-title">多模块多功能供您选择，多种主流网校风格任你选</div>
                <div class="sub-title">尊贵定制化功能、量身打造您的独立网校</div>
            </div>
            <div class="content" style="position:relative;">
                <ul>
                    <li>
                        <div><img src="images/pic1/pic1_r11_c5.png" />

                            <p>职业教育类</p>
                        </div>
                        <div><img src="images/pic1/pic1_r11_c24.png" />

                            <p>兴趣培训类</p>
                        </div>
                    </li>
                </ul>
                <a class="arrow-left" href="javascript:void(0);"></a>
                 <a class="arrow-right" href="javascript:void(0);"></a>
            </div>
            <div class="btns" style="margin-top: 0;">
                <a class="btn btn-primary" href="javascript:void(0);" onclick="doyoo.util.openChat('g=10057182')">更多模板点击查看</a>
                <a class="btn btn-primary" href="javascript:gotoRegister();">点击注册免费试用</a>
            </div>
        </section>
        <section class="sec19">
            <img src="images/pic6/seven.png" alt="" />
            <div class="w1100">
                <div class="title tt wow slideInUp">十年以上教育系统研发经验 提供专业品质保障</div>
                <h3 class="tt wow rotateIn">团队来自新东方、尚德机构、对啊网、淘宝同学</h3>

                <div class="words">我们为一线教育机构提供超过十年的技术支撑成
                    <br/>功打造业内知名的在线教育平台</div>
            </div>
        </section>
        <section class="sec20">
            <div class="fadeInUp wow tt">
                <div class="title" style="height: 100px; line-height: 100px; margin-bottom: 60px;">为所有在线教育用户提供独立网校</div>
            </div>
            <div class="cont">
                <div class="img q_sprit"></div>
                <p class="q_text pulse animated wow tt" data-wow-duration="0.5" data-wow-delay="0.2s" style="visibility: visible; animation-name: pulse;animation-delay: 0.2s;">免费搭建独立网校 当天即可招生上课</p>
                <div class="q_left part">
                    <div class="item1 q_sprit bounceInLeft animated wow tt" data-wow-duration="0.5" data-wow-delay="0.3s" style="visibility: visible; animation-name: bounceInLeft; animation-delay: 0.3s;">
                        <div>
                            <h3>K12培训类</h3>
                            <p>小学、中学、初中、高中各类学科辅助培训支持1对1教学</p>
                        </div>
                    </div>
                    <div class="item2 q_sprit bounceInLeft animated wow tt" data-wow-duration="0.5" data-wow-delay="0.5s" style="visibility: visible; animation-delay: 0.5s; animation-name: bounceInLeft;">
                        <div>
                            <h3>IT职业培训类</h3>
                            <p>会计、人力资源、心理、经济师、建造师、证券等各种成人证书培训</p>
                        </div>
                    </div>
                    <div class="item3 q_sprit bounceInLeft animated wow tt" data-wow-duration="0.5s" data-wow-delay="0.7s" style="visibility: visible; animation-duration: 0.7s; animation-delay: 0.5s; animation-name: bounceInLeft;">
                        <div>
                            <h3>学历培训类</h3>
                            <p>自学考试、高起专、专接本、远程函授、成考、考研培训等成人学历培训</p>
                        </div>
                    </div>
                </div>
                <div class="q_right part">
                    <div class="item1 q_sprit bounceInLeft animated wow tt" data-wow-duration="0.5s" ata-wow-delay="0.3s" style="visibility: visible; animation-duration: 0.5s; animation-delay: 0.3s; animation-name: bounceInRight;">
                        <div style="margin-top:-1px;">
                            <h3>语言类培训</h3>
                            <p>英语四、六级、托福、雅思、韩语、日语、法语等其他语言类培训教学</p>
                        </div>
                    </div>
                    <div class="item2 q_sprit bounceInLeft animated wow tt" data-wow-duration="0.5s" data-wow-delay="0.5s" style="visibility: visible; animation-duration: 0.5s; animation-delay: 0.5s; animation-name: bounceInLeft;">
                        <div style="margin-top: -1px;">
                            <h3>兴趣类培训</h3>
                            <p>舞蹈、瑜伽、手动DIY美术、摄影、美妆、健身减肥等视频在线教学</p>
                        </div>
                    </div>
                    <div class="item3 q_sprit bounceInLeft animated wow tt" data-wow-duration="0.5s" ata-wow-delay="0.7s" style="visibility: visible; animation-duration: 0.5s; animation-delay: 0.7s; animation-name: bounceInRight;">
                        <div style="margin-top: -1px;">
                            <h3>其他类培训</h3>
                            <p>金融行业、医疗内训、电子商务、IT高科技、网络媒体等视频在线教学</p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="btns">
                <a class="btn btn-primary" href="javascript:void(0);" onclick="doyoo.util.openChat('g=10057181')">企业案例点击查看</a>
                <a class="btn btn-primary" href="javascript:gotoRegister();">点击注册免费试用</a>
            </div>
        </section>
        <section class="sec21">
            <div class="tt wow fadeInUp">
                <div class="title">拥有独立网校 全面提高您的品牌影响力</div>
            </div>
            <div class="w1100">
                <div class="up-cont clear">
                    <div class="cont-itm">
                        <h3>建立品牌影响力</h3>

                        <div class="cont-itm-word">
                            独立私有的网校，学生直接访问您的域名即可登录上课，品牌宣传效果更好，提高机构在市场的知名度
                        </div>
                    </div>
                    <div class="cont-itm">
                        <h3>提升学员的粘性</h3>

                        <div class="cont-itm-word">
                            个性化的互动学习方法，增强学员活跃度，提升学员粘性
                        </div>
                    </div>
                    <div class="cont-itm">
                        <h3>增加市场覆盖率</h3>

                        <div class="cont-itm-word">
                            通过快速建立网络教学课堂，不受地域限制，面向全国招生，大大降低地域扩张成本
                        </div>
                    </div>
                    <div class="cont-itm">
                        <h3>提升学员转化率</h3>

                        <div class="cont-itm-word">
                            个性化教学服务，课程安排更灵活，满足不同层次学员需求，提升转化率
                        </div>
                    </div>
                    <div class="cont-itm">
                        <h3>提高教学利润率</h3>

                        <div class="cont-itm-word">
                            提高教学资源利用率、降低运营成本,增加机构的利润率
                        </div>
                    </div>
                </div>
                <div class="down-cont">
                    <div class="ueser-box">
                        <div class="urser-cont clear">
                            <div class="user-icon user-icon1"><img src="images/pic6/iconfont-teacher.png" alt=""></div>
                            <div class="uer-info user-name">
                                <input type="text" id="sqName1" placeholder="输入姓名">
                            </div>
                            <div class="user-icon"><img src="images/pic6/iconfont-dianhua.png" alt=""></div>
                            <div class="uer-info user-phone">
                                <input type="text" id="sqMobile1" placeholder="输入电话">
                            </div>
                            <div class="try user-btn"><a href="javascript:void(0);" onclick="javascript:addSqContent(1);">免费开通试用</a>
                            </div>
                            <div class="set-school user-btn"><a href="javascript:void(0);" onclick="doyoo.util.openChat('g=10057179')">搭建网校咨询</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <section class="sec22">
            <div class="up-cont">
                <div class="tt wow fadeInUp">
                    <div class="title">在线教育没有经验怎么做？常见热门问题回答</div>
                </div>
                <div class="hide-box">
                    <div class="m-title title1">如何做好在线教育培训盈利？</div>
                    <div class="m-title title2">如何5分钟搭建独立网校平台？</div>
                    <div class="m-title title3">如何提升在线教育学员导流？</div>
                    <div class="m-title title4">如何开设直播公开课招生？</div>
                    <div class="m-title title5">如何开设高出勤率的直播课堂？</div>
                    <div class="m-title title6">如何录制授学员欢迎录播课程？</div>
                    <div class="m-title title7">如何提升网校的学员报名续费率？</div>
                    <div class="m-title title8">如何实施线上线下结合的运营模式？</div>
                    <div class="m-title title9">如何减少投入增加网校的利润率？</div>
                    <div class="m-title title10">免费用户如何转化为收费学员？</div>
                </div>
            </div>
            <div class="down-cont">
                <div class="ueser-box">
                    <div class="urser-cont clear">
                        <div class="user-icon user-icon1"><img src="images/pic6/iconfont-teacher.png" alt=""></div>
                        <div class="uer-info user-name">
                            <input type="text" id="sqName1" placeholder="输入姓名">
                        </div>
                        <div class="user-icon"><img src="images/pic6/iconfont-dianhua.png" alt=""></div>
                        <div class="uer-info user-phone">
                            <input type="text" id="sqMobile1" placeholder="输入电话">
                        </div>
                        <div class="try user-btn"><a href="javascript:void(0);" onclick="javascript:addSqContent(1);">免费开通试用</a>
                        </div>
                        <div class="set-school user-btn"><a href="javascript:void(0);" onclick="doyoo.util.openChat('g=10057179')">搭建网校咨询</a>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <section class="sec23" style="padding-bottom:50px;">
            <div class="content">
                <div class="hang">
                    <div class="bg-img wow tt bounceInLeft">111</div>
                    <div class="wenzi position-r wow tt bounceInRight">
                        <div class="title">终身免费升级服务 我们一直伴您前行</div>
                        <p>每周四版本迭代更新版本，在线解决方案不断升级。</p>

                        <p>免费使用系统所有升级功能，无需支付任何升级费用。</p>

                        <p>在线教育方案的领跑者，让你时刻处于行业领先水平。</p>
                    </div>
                </div>
                <div class="hang">
                    <div class="wenzi wow tt bounceInLeft" data-wow-delay="0.2s">
                        <div class="title"> 仅收取同行业20%的服务费
                            <br> 让教育机构都拥有专业独立网校</div>
                        <p>我们只收取服务器、带宽和空间使用的费用， 以极高的
                            <br>性价比提供教学内容存储、视频点播方案， 让您以最低
                            <br>的成本进军在线教育市场。</p>

                        <div class="btns">
                            <a class="btn btn-primary" href="javascript:void(0);" onclick="doyoo.util.openChat('g=10057194')">服务费用点击咨询</a>
                            <a class="btn btn-primary" href="javascript:gotoRegister();">点击注册免费试用</a>
                        </div>
                    </div>
                    <div class="tu wow tt bounceInRight" data-wow-delay="0.2s">
                        <img src="images/pic3/pci3_r17_c23.png" alt="">
                    </div>
                </div>
            </div>
        </section>
       
        <section class="sec26">
            <div class="title">多次获得新闻媒体报导，在线教育SAAS服务的领跑者</div>
            <div class="content">
                <div class="text">
                    <div class="left">
                        <div class="pic">
                            <img src="images/pic3/pic3.1_r2_c1.png" width="505" height="368" alt="">

                            <div class="wenzi">云朵课堂：服务培训机构向在线教育转化</div>
                        </div>
                    </div>
                    <div class="right">
                        <div class="hang">
                            <div class="pic">
                                <img src="images/pic3/pic3.1_r1_c9.png" width="280" height="182" alt="">

                                <div class="wenzi rightwenzi">中国又一个千亿级的 . . .</div>
                            </div>
                            <div class="pic">
                                <img src="images/pic3/pic3.1_r2_c13.png" width="280" height="182" alt="">

                                <div class="wenzi rightwenzi">为线下机构建网校 . . .</div>
                            </div>
                        </div>
                        <div class="hang">
                            <div class="pic">
                                <img src="images/pic3/pic3.1_r4_c9.png" width="280" height="182" alt="">

                                <div class="wenzi rightwenzi">在线教育行业解码</div>
                            </div>
                            <div class="pic">
                                <img src="images/pic3/pic3.1_r4_c13.png" width="280" height="182" alt="">

                                <div class="wenzi rightwenzi">互联网激活教育“巨变”</div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <section class="ft">
            <img src="images/pic3/footerpic.png" height="100%">

            <div class="f-box">
                <p class="title">即刻启程：开启您的在线教育网校</p>

                <p class="caption">互联网让学习更加便利，云朵课堂让所有机构5分钟拥有自己独立网校，我们生活在一个充满无限可能的时代，在线教育让人人都能享受优质教育的机会， 我们的理想，就是将世界上最优质的教育资源，专递到地球的每一个角落。
                </p>
                <br>

                <a href="javascript:void(0);" onclick="doyoo.util.openChat('g=10057197')">开通网校点击咨询</a>
                <a href="javascript:gotoRegister();" style="margin-left:20px;">点击注册免费试用</a>
            </div>
        </section>
    </div>
    <footer class="t-footer">
        <div class="cont">
            <ul class="clear">
                <li><a href="aboutus.html" target="_blank">关于我们</a><i>|</i></li>
                <li><a href="javascript:void(0)">产品服务</a><i>|</i></li>
                <li><a href="javascript:void(0)">产品服务</a><i>|</i></li>
                <li><a href="javascript:void(0)">成功案例</a></li>
            </ul>
            <h2>24小时服务热线：400-9658-366</h2>

            <p>email:sales@yuuxin.com</p>

            <div>
                <p class="fl">北京市朝阳区安贞门渔阳置业大厦B座405室</p>

                <p class="fr" style="font-size: 12px">Copyright 2014-2015.北京昱新科技有限公司　版权所有 京ICP备15011506号</p>
            </div>
            <img class="foot-logo" src="http://yunduoketang.oss-cn-beijing.aliyuncs.com/tulan/images/logo.png"></img>
        </div>
    </footer>
</body>
<script type="text/javascript" src="js/my.js"></script>
<script type="text/javascript" src="js/jquery-ui.js"></script>
<script type="text/javascript" src="js/wow.min.js"></script>
<script type="text/javascript" src="js/jquery.cbpQTRotator.js"></script>
<script type="text/javascript" src="js/jquery.parallax-1.1.3.js"></script>
<script type="text/javascript" src="js/jquery.scrollTo.min.js"></script>
<script type="text/javascript" src="js/jquery.sticky.js"></script>
<script type="text/javascript" src="js/smoothscroll.js"></script>
<script type="text/javascript" src="js/waypoints.min.js"></script>
<script type="text/javascript" src="js/echarts-all.js"></script>
<script type="text/javascript" src="js/barcharts.js"></script>
<script type="text/javascript" src="js/lightbox.js"></script>
<script type="text/javascript" src="js/idangerous.swiper.min.js"></script>
<script type="text/javascript" src="js/index.js"></script>
<script type="text/javascript" charset="utf-8" src="js/10051886.js"></script>


</html>
