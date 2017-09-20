<%@ page contentType="text/html;charset=utf-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="gbk"/>
    <title>王者荣耀</title>
    <link href="http://game.gtimg.cn/images/yxzj/web201706/css/comm-v1.css" rel="stylesheet"/>
    <link rel="stylesheet" type="text/css" href="http://pvp.qq.com/web201605/css/hero.css"/>
    <style>
        .poppup-item {
            display: none;
            position: absolute;
            top: 20%;
            left: 20%;
            background: rgba(0, 0, 0, .9);
            opacity: 0.9;
            border: 1px solid #459ef4;
            width: 213px;
            padding: 24px 15px 24px 33px;
            z-index: 100;
            font-family: "microsoft yahei";
        }

        .right-popup {
            padding: 24px 33px 24px 15px;
        }

        .item-title {
            height: 74px
        }

        .item-title img {
            float: left;
            width: 74px;
            height: 74px;
            margin-right: 15px
        }

        .item-title .cons {
            float: left;
            margin-left: 6px;
        }

        .item-title h4 {
            font-size: 18px;
            font-weight: bold;
            color: #23ff28;
            line-height: 26px;
            white-space: nowrap;
            overflow: hidden;
            text-overflow: ellipsis;
        }

        .item-title .cons p {
            font-size: 14px;
            color: #da951c;
            line-height: 30px
        }

        .item-desc {
            padding: 12px 0;
            color: #369ff9;
            font-size: 14px;
            line-height: 22px
        }

        .clearfix:after {
            visibility: hidden;
            display: block;
            font-size: 0;
            content: " ";
            clear: both;
            height: 0;
        }

        .clearfix {
            zoom: 1;
        }

        .item-desc div {
            line-height: 22px;
            word-wrap: break-word;
            word-break: break-all;
            margin-bottom: 10px;
        }

    </style>
</head>
<body class="old-header">

<div class="">
    <!-- 内容区域1 S -->
    <div class="zkcontent">
        <div class="zk-con-box">
            <!-- 位置信息 S -->
            <div class="zk-con1 zk-con">

                <h3 class="herolist-title">局内道具</h3>
                <ul class="herolist-nav">
                    <li><a href="<%=path%>/yx.jsp" target="_blank">英雄</a></li>
                    <li class="current"><a href="<%=path%>/dj.jsp" target="_blank">局内道具</a></li>
                    <li><a href="<%=path%>/fs.jsp" target="_blank">召唤师技能</a></li>
                </ul>
            </div>
            <!-- 位置信息 E -->
            <!-- 物品 S -->
            <div class="herolist-box">
                <div class="clearfix herolist-types item-types">
                    <ul class="clearfix types-ms">
                        <li class="current" data-type="0">
                            <span class="ms-radio"><i class="i"></i></span>
                            <label>全部</label>
                        </li>
                        <li data-type="1">
                            <span class="ms-radio"><i class="i"></i></span>
                            <label>攻击</label>
                        </li>
                        <li data-type="2">
                            <span class="ms-radio"><i class="i"></i></span>
                            <label>法术</label>
                        </li>
                        <li data-type="3">
                            <span class="ms-radio"><i class="i"></i></span>
                            <label>防御</label>
                        </li>
                        <li data-type="4">
                            <span class="ms-radio"><i class="i"></i></span>
                            <label>移动</label>
                        </li>
                        <li data-type="5">
                            <span class="ms-radio"><i class="i"></i></span>
                            <label>打野</label>
                        </li>
                        <li data-type="7">
                            <span class="ms-radio"><i class="i"></i></span>
                            <label>辅助</label>
                        </li>
                    </ul>
                    <div class="herosearch itemsearch">
                        <input type="text" id="search" name="search" class="herosearch-input"
                               placeholder="请输入你想要搜索的道具名">
                        <a href="javascript:void(0);" class="herosearch-icon" id="searchBtn"></a>
                    </div>
                </div>

                <div class="herolist-content">
                    <ul class="clearfix herolist" id="Jlist-details">
                        <li><a href="#none" data-href="1111.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/1111.jpg" width="91px" alt="铁剑">铁剑</a>
                        </li>
                        <li><a href="#none" data-href="1112.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/1112.jpg" width="91px" alt="匕首">匕首</a>
                        </li>
                        <li><a href="#none" data-href="1113.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/1113.jpg" width="91px"
                                alt="搏击拳套">搏击拳套</a></li>
                        <li><a href="#none" data-href="1114.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/1114.jpg" width="91px"
                                alt="吸血之镰">吸血之镰</a></li>
                        <li><a href="#none" data-href="1116.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/1116.jpg" width="91px"
                                alt="雷鸣刃">雷鸣刃</a></li>
                        <li><a href="#none" data-href="1117.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/1117.jpg" width="91px"
                                alt="冲能拳套">冲能拳套</a></li>
                        <li><a href="#none" data-href="1121.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/1121.jpg" width="91px"
                                alt="风暴巨剑">风暴巨剑</a></li>
                        <li><a href="#none" data-href="1122.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/1122.jpg" width="91px" alt="日冕">日冕</a>
                        </li>
                        <li><a href="#none" data-href="1123.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/1123.jpg" width="91px"
                                alt="狂暴双刃">狂暴双刃</a></li>
                        <li><a href="#none" data-href="1124.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/1124.jpg" width="91px" alt="陨星">陨星</a>
                        </li>
                        <li><a href="#none" data-href="1131.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/1131.jpg" width="91px"
                                alt="破甲弓">破甲弓</a></li>
                        <li><a href="#none" data-href="1126.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/1126.jpg" width="91px" alt="末世">末世</a>
                        </li>
                        <li><a href="#none" data-href="1127.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/1127.jpg" width="91px"
                                alt="名刀・司命">名刀・司命</a></li>
                        <li><a href="#none" data-href="1128.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/1128.jpg" width="91px"
                                alt="冰霜长矛">冰霜长矛</a></li>
                        <li><a href="#none" data-href="1129.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/1129.jpg" width="91px"
                                alt="速击之枪">速击之枪</a></li>
                        <li><a href="#none" data-href="11210.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/11210.jpg" width="91px"
                                alt="制裁之刃">制裁之刃</a></li>
                        <li><a href="#none" data-href="1132.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/1132.jpg" width="91px"
                                alt="泣血之刃">泣血之刃</a></li>
                        <li><a href="#none" data-href="1133.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/1133.jpg" width="91px"
                                alt="无尽战刃">无尽战刃</a></li>
                        <li><a href="#none" data-href="1134.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/1134.jpg" width="91px"
                                alt="宗师之力">宗师之力</a></li>
                        <li><a href="#none" data-href="1135.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/1135.jpg" width="91px"
                                alt="闪电匕首">闪电匕首</a></li>
                        <li><a href="#none" data-href="1136.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/1136.jpg" width="91px" alt="影刃">影刃</a>
                        </li>
                        <li><a href="#none" data-href="1137.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/1137.jpg" width="91px"
                                alt="暗影战斧">暗影战斧</a></li>
                        <li><a href="#none" data-href="1138.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/1138.jpg" width="91px" alt="破军">破军</a>
                        </li>
                        <li><a href="#none" data-href="11311.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/11311.jpg" width="91px"
                                alt="纯净苍穹">纯净苍穹</a></li>
                        <li><a href="#none" data-href="91040.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/91040.jpg" width="91px"
                                alt="逐日之弓">逐日之弓</a></li>
                        <li><a href="#none" data-href="1125.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/1125.jpg" width="91px"
                                alt="破魔刀">破魔刀</a></li>
                        <li><a href="#none" data-href="1211.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/1211.jpg" width="91px"
                                alt="咒术典籍">咒术典籍</a></li>
                        <li><a href="#none" data-href="1212.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/1212.jpg" width="91px"
                                alt="蓝宝石">蓝宝石</a></li>
                        <li><a href="#none" data-href="1213.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/1213.jpg" width="91px"
                                alt="炼金护符">炼金护符</a></li>
                        <li><a href="#none" data-href="1214.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/1214.jpg" width="91px"
                                alt="圣者法典">圣者法典</a></li>
                        <li><a href="#none" data-href="1216.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/1216.jpg" width="91px"
                                alt="元素杖">元素杖</a></li>
                        <li><a href="#none" data-href="1221.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/1221.jpg" width="91px" alt="大棒">大棒</a>
                        </li>
                        <li><a href="#none" data-href="1229.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/1229.jpg" width="91px"
                                alt="破碎圣杯">破碎圣杯</a></li>
                        <li><a href="#none" data-href="1223.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/1223.jpg" width="91px"
                                alt="光辉之剑">光辉之剑</a></li>
                        <li><a href="#none" data-href="1224.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/1224.jpg" width="91px"
                                alt="魅影面罩">魅影面罩</a></li>
                        <li><a href="#none" data-href="1225.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/1225.jpg" width="91px"
                                alt="进化水晶">进化水晶</a></li>
                        <li><a href="#none" data-href="1222.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/1222.jpg" width="91px"
                                alt="血族之书">血族之书</a></li>
                        <li><a href="#none" data-href="1227.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/1227.jpg" width="91px"
                                alt="炽热支配者">炽热支配者</a></li>
                        <li><a href="#none" data-href="12211.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/12211.jpg" width="91px"
                                alt="梦魇之牙">梦魇之牙</a></li>
                        <li><a href="#none" data-href="1231.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/1231.jpg" width="91px"
                                alt="虚无法杖">虚无法杖</a></li>
                        <li><a href="#none" data-href="1232.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/1232.jpg" width="91px"
                                alt="博学者之怒">博学者之怒</a></li>
                        <li><a href="#none" data-href="1239.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/1239.jpg" width="91px" alt="辉月">辉月</a>
                        </li>
                        <li><a href="#none" data-href="1233.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/1233.jpg" width="91px"
                                alt="回响之杖">回响之杖</a></li>
                        <li><a href="#none" data-href="1234.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/1234.jpg" width="91px"
                                alt="冰霜法杖">冰霜法杖</a></li>
                        <li><a href="#none" data-href="1235.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/1235.jpg" width="91px"
                                alt="痛苦面具">痛苦面具</a></li>
                        <li><a href="#none" data-href="1236.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/1236.jpg" width="91px"
                                alt="巫术法杖">巫术法杖</a></li>
                        <li><a href="#none" data-href="1226.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/1226.jpg" width="91px" alt="圣杯">圣杯</a>
                        </li>
                        <li><a href="#none" data-href="1237.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/1237.jpg" width="91px"
                                alt="时之预言">时之预言</a></li>
                        <li><a href="#none" data-href="1238.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/1238.jpg" width="91px"
                                alt="贤者之书">贤者之书</a></li>
                        <li><a href="#none" data-href="1240.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/1240.jpg" width="91px"
                                alt="噬神之书">噬神之书</a></li>
                        <li><a href="#none" data-href="1311.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/1311.jpg" width="91px"
                                alt="红玛瑙">红玛瑙</a></li>
                        <li><a href="#none" data-href="1312.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/1312.jpg" width="91px" alt="布甲">布甲</a>
                        </li>
                        <li><a href="#none" data-href="1313.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/1313.jpg" width="91px"
                                alt="抗魔披风">抗魔披风</a></li>
                        <li><a href="#none" data-href="1314.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/1314.jpg" width="91px"
                                alt="提神水晶">提神水晶</a></li>
                        <li><a href="#none" data-href="1321.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/1321.jpg" width="91px"
                                alt="力量腰带">力量腰带</a></li>
                        <li><a href="#none" data-href="1322.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/1322.jpg" width="91px"
                                alt="熔炼之心">熔炼之心</a></li>
                        <li><a href="#none" data-href="1323.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/1323.jpg" width="91px"
                                alt="神隐斗篷">神隐斗篷</a></li>
                        <li><a href="#none" data-href="1324.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/1324.jpg" width="91px"
                                alt="雪山圆盾">雪山圆盾</a></li>
                        <li><a href="#none" data-href="1325.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/1325.jpg" width="91px"
                                alt="守护者之铠">守护者之铠</a></li>
                        <li><a href="#none" data-href="1724.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/1724.jpg" width="91px"
                                alt="近卫荣耀">近卫荣耀</a></li>
                        <li><a href="#none" data-href="1723.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/1723.jpg" width="91px"
                                alt="奔狼纹章">奔狼纹章</a></li>
                        <li><a href="#none" data-href="1327.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/1327.jpg" width="91px"
                                alt="反伤刺甲">反伤刺甲</a></li>
                        <li><a href="#none" data-href="1328.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/1328.jpg" width="91px"
                                alt="血魔之怒">血魔之怒</a></li>
                        <li><a href="#none" data-href="1331.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/1331.jpg" width="91px"
                                alt="红莲斗篷">红莲斗篷</a></li>
                        <li><a href="#none" data-href="1332.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/1332.jpg" width="91px"
                                alt="霸者重装">霸者重装</a></li>
                        <li><a href="#none" data-href="1333.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/1333.jpg" width="91px"
                                alt="不祥征兆">不祥征兆</a></li>
                        <li><a href="#none" data-href="1334.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/1334.jpg" width="91px"
                                alt="不死鸟之眼">不死鸟之眼</a></li>
                        <li><a href="#none" data-href="1335.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/1335.jpg" width="91px"
                                alt="魔女斗篷">魔女斗篷</a></li>
                        <li><a href="#none" data-href="1336.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/1336.jpg" width="91px"
                                alt="极寒风暴">极寒风暴</a></li>
                        <li><a href="#none" data-href="13310.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/13310.jpg" width="91px"
                                alt="冰痕之握">冰痕之握</a></li>
                        <li><a href="#none" data-href="1337.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/1337.jpg" width="91px"
                                alt="贤者的庇护">贤者的庇护</a></li>
                        <li><a href="#none" data-href="1338.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/1338.jpg" width="91px"
                                alt="暴烈之甲">暴烈之甲</a></li>
                        <li><a href="#none" data-href="1411.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/1411.jpg" width="91px"
                                alt="神速之靴">神速之靴</a></li>
                        <li><a href="#none" data-href="1421.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/1421.jpg" width="91px"
                                alt="影忍之足">影忍之足</a></li>
                        <li><a href="#none" data-href="1422.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/1422.jpg" width="91px"
                                alt="抵抗之靴">抵抗之靴</a></li>
                        <li><a href="#none" data-href="1423.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/1423.jpg" width="91px"
                                alt="冷静之靴">冷静之靴</a></li>
                        <li><a href="#none" data-href="1424.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/1424.jpg" width="91px"
                                alt="秘法之靴">秘法之靴</a></li>
                        <li><a href="#none" data-href="1425.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/1425.jpg" width="91px"
                                alt="急速战靴">急速战靴</a></li>
                        <li><a href="#none" data-href="1426.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/1426.jpg" width="91px"
                                alt="疾步之靴">疾步之靴</a></li>
                        <li><a href="#none" data-href="1511.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/1511.jpg" width="91px"
                                alt="狩猎宽刃">狩猎宽刃</a></li>
                        <li><a href="#none" data-href="1521.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/1521.jpg" width="91px"
                                alt="游击弯刀">游击弯刀</a></li>
                        <li><a href="#none" data-href="1522.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/1522.jpg" width="91px"
                                alt="巡守利斧">巡守利斧</a></li>
                        <li><a href="#none" data-href="1523.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/1523.jpg" width="91px"
                                alt="追击刀锋">追击刀锋</a></li>
                        <li><a href="#none" data-href="1531.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/1531.jpg" width="91px"
                                alt="符文大剑">符文大剑</a></li>
                        <li><a href="#none" data-href="1532.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/1532.jpg" width="91px"
                                alt="巨人之握">巨人之握</a></li>
                        <li><a href="#none" data-href="1533.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/1533.jpg" width="91px"
                                alt="贪婪之噬">贪婪之噬</a></li>
                        <li><a href="#none" data-href="1714.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/1714.jpg" width="91px"
                                alt="鼓舞之盾">鼓舞之盾</a></li>
                        <li><a href="#none" data-href="1713.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/1713.jpg" width="91px"
                                alt="风灵纹章">风灵纹章</a></li>
                        <li><a href="#none" data-href="1722.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/1722.jpg" width="91px"
                                alt="救赎之翼">救赎之翼</a></li>
                        <li><a href="#none" data-href="1712.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/1712.jpg" width="91px"
                                alt="风之轻语">风之轻语</a></li>
                        <li><a href="#none" data-href="1721.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/1721.jpg" width="91px" alt="极影">极影</a>
                        </li>
                        <li><a href="#none" data-href="1711.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/1711.jpg" width="91px"
                                alt="凤鸣指环">凤鸣指环</a></li>
                        <li><a href="#none" data-href="1701.shtml"><img
                                src="http://game.gtimg.cn/images/yxzj/img201606/itemimg/1701.jpg" width="91px"
                                alt="学识宝石">学识宝石</a></li>
                    </ul>
                </div>
            </div>
            <!-- 物品 E -->
        </div>
    </div>


</div>

</body>
</html>
