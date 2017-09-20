<%@ page contentType="text/html;charset=utf-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="gbk" />
    <title>王者荣耀</title>
    <link href="http://game.gtimg.cn/images/yxzj/web201706/css/comm-v1.css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="http://pvp.qq.com/web201605/css/hero.css" />
    <style>
        /*召唤师技能*/
        .imgtextlist{float:left;width:940px;padding:30px 0 0;margin-left:-14px;margin-right:-20px;position:relative}
        .imgtextlist li{float:left;width:116px;height:120px;margin-bottom:22px;text-align:center;line-height:15px;cursor:pointer;position:relative;overflow:hidden}
        .imgtextlist img{display:block;margin:0 auto 7px; width: 85px; height: 85px; border-radius: 10px 0 10px 0;border: 3px solid #1E84E7}
        .sbg .commico-search{position:absolute;top:50%;left:50%;margin:-12px 0 0 -12px}
        .imgtextlist .current{color:#00A383}
        .imgtextlist .current img{ border:3px solid #00A383; }
        .imgtextlist a{color:#666}
        .imgtextlist a:hover{color:#00A383;text-decoration:none}
        .imgtextlist li.loading{width:100%;cursor:default;color:#CC3F11;font-size:14px}

        .spell-list{float:left;width:43%;padding-left:16px;margin-right:0;border-right:1px solid #F0F0F0}
        .spell-defail{float:left;width:50%;padding-top:30px;padding-left:40px}
        .spell-title{overflow:hidden;zoom:1}
        .spell-title img{float:left;margin-right:20px}
        .spell-title h4{float:left;width:60%;font-size:16px;color:#00A383;line-height:30px}
        .spell-title .cons{float:left;width:60%;color:#9A9A9A;line-height:30px;font-size:14px}
        .spell-desc{padding:20px 0;line-height:18px;color:#333;font-size:14px}
    </style>
</head>
<body class="old-header">

<div class="">
    <div class="zkcontent">
        <div class="zk-con-box">
            <!-- 位置信息 S -->
            <div class="zk-con1 zk-con">
                <div class="con1-pos">
                    <i class="tb1 icon fl"></i>
                    <a href="http://pvp.qq.com/" target="_blank" title="王者荣耀首页">王者荣耀首页</a>
                    <span>&gt;</span>
                    <label>召唤师技能</label>
                </div>
                <h3 class="herolist-title">召唤师技能</h3>
                <ul class="herolist-nav">
                    <li><a href="<%=path%>/yx.jsp" target="_blank">英雄</a></li>
                    <li><a href="<%=path%>/dj.jsp" target="_blank">局内道具</a></li>
                    <li class="current"><a href="<%=path%>/fs.jsp" target="_blank">召唤师技能</a></li>
                </ul>
            </div>
            <!-- 位置信息 E -->
            <!-- 召唤师技能 S -->
            <div class="herolist-box">
                <div class="clearfix herolist-types item-types">
                    <ul id="spellList" class="imgtextlist spell-list"><li id="80104" class=""><img src="http://game.gtimg.cn/images/yxzj/img201606/summoner/80104.jpg" alt="惩击"><p>惩击</p></li><li id="80108" class=""><img src="http://game.gtimg.cn/images/yxzj/img201606/summoner/80108.jpg" alt="斩杀"><p>斩杀</p></li><li id="80110" class=""><img src="http://game.gtimg.cn/images/yxzj/img201606/summoner/80110.jpg" alt="狂暴"><p>狂暴</p></li><li id="80109" class=""><img src="http://game.gtimg.cn/images/yxzj/img201606/summoner/80109.jpg" alt="疾跑"><p>疾跑</p></li><li id="80102" class=""><img src="http://game.gtimg.cn/images/yxzj/img201606/summoner/80102.jpg" alt="治疗术"><p>治疗术</p></li><li id="80105" class=""><img src="http://game.gtimg.cn/images/yxzj/img201606/summoner/80105.jpg" alt="干扰"><p>干扰</p></li><li id="80103"><img src="http://game.gtimg.cn/images/yxzj/img201606/summoner/80103.jpg" alt="晕眩"><p>晕眩</p></li><li id="80107" class=""><img src="http://game.gtimg.cn/images/yxzj/img201606/summoner/80107.jpg" alt="净化"><p>净化</p></li><li id="80121" class=""><img src="http://game.gtimg.cn/images/yxzj/img201606/summoner/80121.jpg" alt="弱化"><p>弱化</p></li><li id="80115" class="current"><img src="http://game.gtimg.cn/images/yxzj/img201606/summoner/80115.jpg" alt="闪现"><p>闪现</p></li></ul>
                    <div id="spellDefail" class="spell-defail"><div class="spell-title"><img src="http://game.gtimg.cn/images/yxzj/img201606/summoner/80115-big.jpg" alt="闪现"><h4>闪现</h4><p class="cons">LV.19解锁</p></div><div class="spell-desc">120秒CD：向指定方向位移一段距离</div></div>

                </div>
            </div>
            <!-- 召唤师技能 E -->
        </div>
    </div>
</div>
</body>
</html>