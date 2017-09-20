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
        .poppup-item{display:none;position:absolute;top:20%;left:20%;background:rgba(0,0,0,.9);opacity:0.9;border:1px solid #459ef4;width:213px;padding:24px 15px 24px 33px;z-index:100;font-family:"microsoft yahei";}
        .right-popup{padding:24px 33px 24px 15px;}
        .item-title{height:74px}
        .item-title img{float:left;width:74px;height:74px;margin-right:15px}
        .item-title .cons{float:left;margin-left:6px;}
        .item-title h4{font-size:18px;font-weight:bold;color:#23ff28;line-height:26px;white-space:nowrap;overflow:hidden;text-overflow:ellipsis;}
        .item-title .cons p{font-size:14px;color:#da951c;line-height:30px}
        .item-desc{padding:12px 0;color:#369ff9;font-size:14px;line-height:22px}
        .clearfix:after { visibility: hidden; display: block; font-size: 0; content: " "; clear: both; height: 0; } .clearfix {zoom:1;}
        .item-desc div{line-height:22px;word-wrap : break-word ;word-break:break-all;margin-bottom:10px;}

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
                    <a href="index.shtml" target="_blank" title="王者荣耀首页">王者荣耀首页</a>
                    <span>&gt;</span>
                    <label>英雄介绍</label>
                </div>
                <h3 class="herolist-title">英雄介绍</h3>
                <ul class="herolist-nav">
                    <li class="current"><a href="<%=path%>/yx.jsp" target="_blank">英雄</a></li>
                    <li><a href="<%=path%>/dj.jsp" target="_blank">局内道具</a></li>
                    <li><a href="<%=path%>/fs.jsp" target="_blank">召唤师技能</a></li>
                </ul>
            </div>
            <!-- 位置信息 E -->
            <!-- 英雄介绍 S -->
            <div class="herolist-box">
                <div class="clearfix herolist-types">
                    <ul class="types-left">
                        <li>综合</li>
                        <li>定位</li>
                    </ul>
                    <ul class="clearfix types-ms">
                        <li data-ptype="10">
                            <span class="ms-radio"><i class="i"></i></span>
                            <label>本周免费</label>
                        </li>
                        <li data-ptype="11">
                            <span class="ms-radio"><i class="i"></i></span>
                            <label>新手推荐</label>
                        </li>
                    </ul>
                    <ul class="clearfix types-ms">
                        <li class="current" data-type="0">
                            <span class="ms-radio"><i class="i"></i></span>
                            <label>全部</label>
                        </li>
                        <li data-type="3">
                            <span class="ms-radio"><i class="i"></i></span>
                            <label>坦克</label>
                        </li>
                        <li data-type="1">
                            <span class="ms-radio"><i class="i"></i></span>
                            <label>战士</label>
                        </li>
                        <li data-type="4">
                            <span class="ms-radio"><i class="i"></i></span>
                            <label>刺客</label>
                        </li>
                        <li data-type="2">
                            <span class="ms-radio"><i class="i"></i></span>
                            <label>法师</label>
                        </li>
                        <li data-type="5">
                            <span class="ms-radio"><i class="i"></i></span>
                            <label>射手</label>
                        </li>
                        <li data-type="6">
                            <span class="ms-radio"><i class="i"></i></span>
                            <label>辅助</label>
                        </li>
                    </ul>
                    <div class="herosearch">
                        <input type="text" id="search" name="search" class="herosearch-input" value="请输入你想要搜索的英雄名">
                        <a href="javascript:void(0);" class="herosearch-icon" title="点击搜索" id="searchBtn"></a>
                    </div>
                </div>

                <div class="herolist-content">
                    <p id="JErroTips" style="display:none;">输入英雄不存在，请重新输入</p>
                    <ul class="herolist clearfix"><li><a href="herodetail/195.shtml" target="_blank"><img src="http://game.gtimg.cn/images/yxzj/img201606/heroimg/195/195.jpg" width="91px" alt="百里玄策">百里玄策</a></li><li><a href="herodetail/196.shtml" target="_blank"><img src="http://game.gtimg.cn/images/yxzj/img201606/heroimg/196/196.jpg" width="91px" alt="百里守约">百里守约</a></li><li><a href="herodetail/193.shtml" target="_blank"><img src="http://game.gtimg.cn/images/yxzj/img201606/heroimg/193/193.jpg" width="91px" alt="铠">铠</a></li><li><a href="herodetail/189.shtml" target="_blank"><img src="http://game.gtimg.cn/images/yxzj/img201606/heroimg/189/189.jpg" width="91px" alt="鬼谷子">鬼谷子</a></li><li><a href="herodetail/182.shtml" target="_blank"><img src="http://game.gtimg.cn/images/yxzj/img201606/heroimg/182/182.jpg" width="91px" alt="干将莫邪">干将莫邪</a></li><li><a href="herodetail/187.shtml" target="_blank"><img src="http://game.gtimg.cn/images/yxzj/img201606/heroimg/187/187.jpg" width="91px" alt="东皇太一">东皇太一</a></li><li><a href="herodetail/191.shtml" target="_blank"><img src="http://game.gtimg.cn/images/yxzj/img201606/heroimg/191/191.jpg" width="91px" alt="大乔">大乔</a></li><li><a href="herodetail/192.shtml" target="_blank"><img src="http://game.gtimg.cn/images/yxzj/img201606/heroimg/192/192.jpg" width="91px" alt="黄忠">黄忠</a></li><li><a href="herodetail/190.shtml" target="_blank"><img src="http://game.gtimg.cn/images/yxzj/img201606/heroimg/190/190.jpg" width="91px" alt="诸葛亮">诸葛亮</a></li><li><a href="herodetail/180.shtml" target="_blank"><img src="http://game.gtimg.cn/images/yxzj/img201606/heroimg/180/180.jpg" width="91px" alt="哪吒">哪吒</a></li><li><a href="herodetail/186.shtml" target="_blank"><img src="http://game.gtimg.cn/images/yxzj/img201606/heroimg/186/186.jpg" width="91px" alt="太乙真人">太乙真人</a></li><li><a href="herodetail/184.shtml" target="_blank"><img src="http://game.gtimg.cn/images/yxzj/img201606/heroimg/184/184.jpg" width="91px" alt="蔡文姬">蔡文姬</a></li><li><a href="herodetail/183.shtml" target="_blank"><img src="http://game.gtimg.cn/images/yxzj/img201606/heroimg/183/183.jpg" width="91px" alt="雅典娜">雅典娜</a></li><li><a href="herodetail/178.shtml" target="_blank"><img src="http://game.gtimg.cn/images/yxzj/img201606/heroimg/178/178.jpg" width="91px" alt="杨戬">杨戬</a></li><li><a href="herodetail/177.shtml" target="_blank"><img src="http://game.gtimg.cn/images/yxzj/img201606/heroimg/177/177.jpg" width="91px" alt="成吉思汗">成吉思汗</a></li><li><a href="herodetail/175.shtml" target="_blank"><img src="http://game.gtimg.cn/images/yxzj/img201606/heroimg/175/175.jpg" width="91px" alt="钟馗">钟馗</a></li><li><a href="herodetail/174.shtml" target="_blank"><img src="http://game.gtimg.cn/images/yxzj/img201606/heroimg/174/174.jpg" width="91px" alt="虞姬">虞姬</a></li><li><a href="herodetail/173.shtml" target="_blank"><img src="http://game.gtimg.cn/images/yxzj/img201606/heroimg/173/173.jpg" width="91px" alt="李元芳">李元芳</a></li><li><a href="herodetail/171.shtml" target="_blank"><img src="http://game.gtimg.cn/images/yxzj/img201606/heroimg/171/171.jpg" width="91px" alt="张飞">张飞</a></li><li><a href="herodetail/170.shtml" target="_blank"><img src="http://game.gtimg.cn/images/yxzj/img201606/heroimg/170/170.jpg" width="91px" alt="刘备">刘备</a></li><li><a href="herodetail/169.shtml" target="_blank"><img src="http://game.gtimg.cn/images/yxzj/img201606/heroimg/169/169.jpg" width="91px" alt="后羿">后羿</a></li><li><a href="herodetail/168.shtml" target="_blank"><img src="http://game.gtimg.cn/images/yxzj/img201606/heroimg/168/168.jpg" width="91px" alt="牛魔">牛魔</a></li><li><a href="herodetail/167.shtml" target="_blank"><img src="http://game.gtimg.cn/images/yxzj/img201606/heroimg/167/167.jpg" width="91px" alt="孙悟空">孙悟空</a></li><li><a href="herodetail/166.shtml" target="_blank"><img src="http://game.gtimg.cn/images/yxzj/img201606/heroimg/166/166.jpg" width="91px" alt="亚瑟">亚瑟</a></li><li><a href="herodetail/163.shtml" target="_blank"><img src="http://game.gtimg.cn/images/yxzj/img201606/heroimg/163/163.jpg" width="91px" alt="橘右京">橘右京</a></li><li><a href="herodetail/162.shtml" target="_blank"><img src="http://game.gtimg.cn/images/yxzj/img201606/heroimg/162/162.jpg" width="91px" alt="娜可露露">娜可露露</a></li><li><a href="herodetail/157.shtml" target="_blank"><img src="http://game.gtimg.cn/images/yxzj/img201606/heroimg/157/157.jpg" width="91px" alt="不知火舞">不知火舞</a></li><li><a href="herodetail/156.shtml" target="_blank"><img src="http://game.gtimg.cn/images/yxzj/img201606/heroimg/156/156.jpg" width="91px" alt="张良">张良</a></li><li><a href="herodetail/154.shtml" target="_blank"><img src="http://game.gtimg.cn/images/yxzj/img201606/heroimg/154/154.jpg" width="91px" alt="花木兰">花木兰</a></li><li><a href="herodetail/153.shtml" target="_blank"><img src="http://game.gtimg.cn/images/yxzj/img201606/heroimg/153/153.jpg" width="91px" alt="兰陵王">兰陵王</a></li><li><a href="herodetail/152.shtml" target="_blank"><img src="http://game.gtimg.cn/images/yxzj/img201606/heroimg/152/152.jpg" width="91px" alt="王昭君">王昭君</a></li><li><a href="herodetail/150.shtml" target="_blank"><img src="http://game.gtimg.cn/images/yxzj/img201606/heroimg/150/150.jpg" width="91px" alt="韩信">韩信</a></li><li><a href="herodetail/149.shtml" target="_blank"><img src="http://game.gtimg.cn/images/yxzj/img201606/heroimg/149/149.jpg" width="91px" alt="刘邦">刘邦</a></li><li><a href="herodetail/148.shtml" target="_blank"><img src="http://game.gtimg.cn/images/yxzj/img201606/heroimg/148/148.jpg" width="91px" alt="姜子牙">姜子牙</a></li><li><a href="herodetail/146.shtml" target="_blank"><img src="http://game.gtimg.cn/images/yxzj/img201606/heroimg/146/146.jpg" width="91px" alt="露娜">露娜</a></li><li><a href="herodetail/144.shtml" target="_blank"><img src="http://game.gtimg.cn/images/yxzj/img201606/heroimg/144/144.jpg" width="91px" alt="程咬金">程咬金</a></li><li><a href="herodetail/142.shtml" target="_blank"><img src="http://game.gtimg.cn/images/yxzj/img201606/heroimg/142/142.jpg" width="91px" alt="安琪拉">安琪拉</a></li><li><a href="herodetail/141.shtml" target="_blank"><img src="http://game.gtimg.cn/images/yxzj/img201606/heroimg/141/141.jpg" width="91px" alt="貂蝉">貂蝉</a></li><li><a href="herodetail/140.shtml" target="_blank"><img src="http://game.gtimg.cn/images/yxzj/img201606/heroimg/140/140.jpg" width="91px" alt="关羽">关羽</a></li><li><a href="herodetail/139.shtml" target="_blank"><img src="http://game.gtimg.cn/images/yxzj/img201606/heroimg/139/139.jpg" width="91px" alt="老夫子">老夫子</a></li><li><a href="herodetail/136.shtml" target="_blank"><img src="http://game.gtimg.cn/images/yxzj/img201606/heroimg/136/136.jpg" width="91px" alt="武则天">武则天</a></li><li><a href="herodetail/135.shtml" target="_blank"><img src="http://game.gtimg.cn/images/yxzj/img201606/heroimg/135/135.jpg" width="91px" alt="项羽">项羽</a></li><li><a href="herodetail/134.shtml" target="_blank"><img src="http://game.gtimg.cn/images/yxzj/img201606/heroimg/134/134.jpg" width="91px" alt="达摩">达摩</a></li><li><a href="herodetail/133.shtml" target="_blank"><img src="http://game.gtimg.cn/images/yxzj/img201606/heroimg/133/133.jpg" width="91px" alt="狄仁杰">狄仁杰</a></li><li><a href="herodetail/132.shtml" target="_blank"><img src="http://game.gtimg.cn/images/yxzj/img201606/heroimg/132/132.jpg" width="91px" alt="马可波罗">马可波罗</a></li><li><a href="herodetail/131.shtml" target="_blank"><img src="http://game.gtimg.cn/images/yxzj/img201606/heroimg/131/131.jpg" width="91px" alt="李白">李白</a></li><li><a href="herodetail/130.shtml" target="_blank"><img src="http://game.gtimg.cn/images/yxzj/img201606/heroimg/130/130.jpg" width="91px" alt="宫本武藏">宫本武藏</a></li><li><a href="herodetail/129.shtml" target="_blank"><img src="http://game.gtimg.cn/images/yxzj/img201606/heroimg/129/129.jpg" width="91px" alt="典韦">典韦</a></li><li><a href="herodetail/128.shtml" target="_blank"><img src="http://game.gtimg.cn/images/yxzj/img201606/heroimg/128/128.jpg" width="91px" alt="曹操">曹操</a></li><li><a href="herodetail/127.shtml" target="_blank"><img src="http://game.gtimg.cn/images/yxzj/img201606/heroimg/127/127.jpg" width="91px" alt="甄姬">甄姬</a></li><li><a href="herodetail/126.shtml" target="_blank"><img src="http://game.gtimg.cn/images/yxzj/img201606/heroimg/126/126.jpg" width="91px" alt="夏侯惇">夏侯惇</a></li><li><a href="herodetail/124.shtml" target="_blank"><img src="http://game.gtimg.cn/images/yxzj/img201606/heroimg/124/124.jpg" width="91px" alt="周瑜">周瑜</a></li><li><a href="herodetail/123.shtml" target="_blank"><img src="http://game.gtimg.cn/images/yxzj/img201606/heroimg/123/123.jpg" width="91px" alt="吕布">吕布</a></li><li><a href="herodetail/121.shtml" target="_blank"><img src="http://game.gtimg.cn/images/yxzj/img201606/heroimg/121/121.jpg" width="91px" alt="芈月">芈月</a></li><li><a href="herodetail/120.shtml" target="_blank"><img src="http://game.gtimg.cn/images/yxzj/img201606/heroimg/120/120.jpg" width="91px" alt="白起">白起</a></li><li><a href="herodetail/119.shtml" target="_blank"><img src="http://game.gtimg.cn/images/yxzj/img201606/heroimg/119/119.jpg" width="91px" alt="扁鹊">扁鹊</a></li><li><a href="herodetail/118.shtml" target="_blank"><img src="http://game.gtimg.cn/images/yxzj/img201606/heroimg/118/118.jpg" width="91px" alt="孙膑">孙膑</a></li><li><a href="herodetail/117.shtml" target="_blank"><img src="http://game.gtimg.cn/images/yxzj/img201606/heroimg/117/117.jpg" width="91px" alt="钟无艳">钟无艳</a></li><li><a href="herodetail/116.shtml" target="_blank"><img src="http://game.gtimg.cn/images/yxzj/img201606/heroimg/116/116.jpg" width="91px" alt="阿轲">阿轲</a></li><li><a href="herodetail/115.shtml" target="_blank"><img src="http://game.gtimg.cn/images/yxzj/img201606/heroimg/115/115.jpg" width="91px" alt="高渐离">高渐离</a></li><li><a href="herodetail/114.shtml" target="_blank"><img src="http://game.gtimg.cn/images/yxzj/img201606/heroimg/114/114.jpg" width="91px" alt="刘禅">刘禅</a></li><li><a href="herodetail/113.shtml" target="_blank"><img src="http://game.gtimg.cn/images/yxzj/img201606/heroimg/113/113.jpg" width="91px" alt="庄周">庄周</a></li><li><a href="herodetail/112.shtml" target="_blank"><img src="http://game.gtimg.cn/images/yxzj/img201606/heroimg/112/112.jpg" width="91px" alt="鲁班七号">鲁班七号</a></li><li><a href="herodetail/111.shtml" target="_blank"><img src="http://game.gtimg.cn/images/yxzj/img201606/heroimg/111/111.jpg" width="91px" alt="孙尚香">孙尚香</a></li><li><a href="herodetail/110.shtml" target="_blank"><img src="http://game.gtimg.cn/images/yxzj/img201606/heroimg/110/110.jpg" width="91px" alt="嬴政">嬴政</a></li><li><a href="herodetail/109.shtml" target="_blank"><img src="http://game.gtimg.cn/images/yxzj/img201606/heroimg/109/109.jpg" width="91px" alt="妲己">妲己</a></li><li><a href="herodetail/108.shtml" target="_blank"><img src="http://game.gtimg.cn/images/yxzj/img201606/heroimg/108/108.jpg" width="91px" alt="墨子">墨子</a></li><li><a href="herodetail/107.shtml" target="_blank"><img src="http://game.gtimg.cn/images/yxzj/img201606/heroimg/107/107.jpg" width="91px" alt="赵云">赵云</a></li><li><a href="herodetail/106.shtml" target="_blank"><img src="http://game.gtimg.cn/images/yxzj/img201606/heroimg/106/106.jpg" width="91px" alt="小乔">小乔</a></li><li><a href="herodetail/105.shtml" target="_blank"><img src="http://game.gtimg.cn/images/yxzj/img201606/heroimg/105/105.jpg" width="91px" alt="廉颇">廉颇</a></li></ul>
                </div>
            </div>
            <!-- 英雄介绍 E -->
        </div>
    </div>

</div>

</body>
</html>
