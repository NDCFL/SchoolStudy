<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">

	<title>物流管理软件系统</title>
	<meta name="description" content="禾唐卖家云的产品[云erp]是我们十年沉淀的精心之作，商家可一键管理店铺，并准确掌握店铺的整理运营情况,并且功能覆盖进销存的全部流程。"/>
	<meta name="keywords" content="在线erp系统, erp系统, erp系统平台,网店erp系统, 网店erp管理系统, 企业erp系统软件, 电子商务erp系统, 电商erp排名" />

	<link rel="icon" href="/favicon.png" type="image/png">
	<link href="<%=basePath%>cs/reset.css" rel="stylesheet">
	<link href="<%=basePath%>cs/site.css" rel="stylesheet">
	<link href="<%=basePath%>cs/animate.min.css" rel="stylesheet">
	<link href="<%=basePath%>cs/swiper.min.css" rel="stylesheet">
	<link href="<%=basePath%>cs/main.css" rel="stylesheet">
	<link href="<%=basePath%>cs/page.css" rel="stylesheet">
	<link href="<%=basePath%>cs/news_block.css" rel="stylesheet">
	<style>
		.hiddened {
			top: -86px;
		}

		.showed {
			top: 0;
			z-index: 9999;
		}
	</style>


		

		<!--[if lt IE 9]>
			<script src="//cdn.jsdelivr.net/html5shiv/3.7.3/html5shiv.js"></script>
			<script src="//cdn.jsdelivr.net/respond/1.4.2/respond.min.js"></script>
			<![endif]-->
			
			<script type='text/javascript'>
				var _vds = _vds || [];
				window._vds = _vds;
				(function(){
					_vds.push(['setAccountId', 'a08a1f134b3a606f']);
					(function() {
						var vds = document.createElement('script');
						vds.type='text/javascript';
						vds.async = true;
						vds.src = ('https:' == document.location.protocol ? 'https://' : 'http://') + 'dn-growing.qbox.me/vds.js';
						var s = document.getElementsByTagName('script')[0];
						s.parentNode.insertBefore(vds, s);
					})();
				})();
			</script>


		</head>
		<body>
			<div class="header">
				<div class="inner">
					<div class="logo">
						<a href="/"><img src="<%=basePath%>wuliu/20161011102802_11205.png" alt="卖家云-商家全渠道管理云平台" /></a>
					</div>
					<div class="nav">
						<ul>
							<li>
								<a href="/" >首页
									<ul>
									</ul>
								</a>
							</li>
							<li>
								<a href="erp" class="sel">产品
									<ul>

										<li><a href="erp"> <p>- 云ERP -</p></a></li>
										<li>
											<a href="/custom">
												<p>- 企业定制 -</p>
											</a>
										</li>
										<li>
											<a href="/scene">
												<p>- 使用场景 -</p>
											</a>
										</li>
									</ul>
								</a>
							</li>
							<li>
								<a href="/service" >服务
									<ul>

									</ul>
								</a>
							</li>
							<li>
								<a href="/industry" >解决方案
									<ul>

										<li><a href="/industry"><p>- 行业方案 -</p></a></li>
										<li>
											<a href="/case">
												<p>- 成功案例 -</p>
											</a>
										</li>
									</ul>
								</a>
							</li>
							<li>
								<a href="/about" >关于我们
									<ul>

										<li><a href="/about"><p>-公司介绍-</p></a></li>
										<li>
											<a href="/Blog">
												<p>-新闻资讯-</p>
											</a>
										</li>
									</ul>
								</a>
							</li>
						</ul>
					</div>
					<div class="login">
						<a href="javascript:;" rel="nofollow" onclick="to_register()" id="shenqing0">免费注册</a>
						<a href="<%=basePath %>HTML5/index.jsp" target="_blank" rel="nofollow" id="denglu">快速登录</a>
					</div>
					<div class="cl"></div>
				</div>
			</div>
			<div id="body">
			<!--
				Flash messages allow you to display once-off status messages to users, e.g. form
				validation errors, success messages, etc
			-->
			<!-- The content block should contain the body of your template's content-->
			<div id="banner">
	<div class="swiper-container swiper-container-top swiper-container-horizontal">
		<div class="swiper-wrapper" style="transform: translate3d(-2392px, 0px, 0px); transition-duration: 0ms;">
			<div class="swiper-slide swiper-slide-duplicate" data-swiper-slide-index="1" style="width: 1196px;">
				<div class="parallax-bg" style="background-image:url(<%=basePath%>wuliu/20161125112400_16256.jpg)"> alt="卖家云-在线进销存,免费进销存,进销存系统,进销存软件免费版,进销存软件,进销存平台"</div>

				<div class="text" style="z-index:10;margin-left:-514px;top:400px;">
					<a href="javascript:;" onclick="to_register()" id="shenqing1" rel="nofollow">立即使用</a>
				</div>
				<span class="video_open" style="margin-left:-380px;top:418px;"><img src="<%=basePath%>wuliu/video_2.png" alt="免费进销存系统视频介绍"></span>
			</div>

			<div class="swiper-slide swiper-slide-prev" data-swiper-slide-index="0" style="width: 1196px;">
				<div class="parallax-bg" style="background-image:url(<%=basePath%>wuliu/20161117161516_98926.jpg)" alt="卖家云-在线进销存,免费进销存,进销存系统,进销存软件免费版,进销存软件,进销存平台"></div>

				<div class="text" style="z-index:10;margin-left:-64px;top:400px;">
					<a href="javascript:;" onclick="to_register()" id="shenqing1" rel="nofollow">立即使用</a>
				</div>
				<span class="video_open" style="margin-left:-63px;top:480px;"><img src="<%=basePath%>wuliu/video_2.png" alt="在线进销存软件免费版视频介绍"></span>
			</div>
			<div class="swiper-slide swiper-slide-active" data-swiper-slide-index="1" style="width: 1196px;">
				<div class="parallax-bg" style="background-image:url(<%=basePath%>wuliu/20161125112400_16256.jpg)" alt="卖家云-在线进销存,免费进销存,进销存系统,进销存软件免费版,进销存软件,进销存平台"></div>

				<div class="text" style="z-index:10;margin-left:-514px;top:400px;">
					<a href="javascript:;" onclick="to_register()" id="shenqing1" rel="nofollow">立即使用</a>
				</div>
				<span class="video_open" style="margin-left:-380px;top:418px;"><img src="<%=basePath%>wuliu/video_2.png" alt="免费进销存系统视频介绍"></span>
			</div>
			<div class="swiper-slide swiper-slide-duplicate swiper-slide-next" data-swiper-slide-index="0" style="width: 1196px;">
				<div class="parallax-bg" style="background-image:url(<%=basePath%>wuliu/20161117161516_98926.jpg)" alt="卖家云-在线进销存,免费进销存,进销存系统,进销存软件免费版,进销存软件,进销存平台"></div>

				<div class="text" style="z-index:10;margin-left:-64px;top:400px;">
					<a href="javascript:;" onclick="to_register()" id="shenqing1" rel="nofollow">立即使用</a>
				</div>
				<span class="video_open" style="margin-left:-63px;top:480px;"><img src="<%=basePath%>wuliu/video_2.png" alt="在线进销存软件免费版视频介绍"></span>
			</div>
		</div>
		<!-- Add Pagination -->
		<div class="swiper-pagination swiper-container-blue swiper-pagination-top swiper-white-box swiper-pagination-clickable swiper-pagination-bullets"><span class="swiper-pagination-bullet"></span><span class="swiper-pagination-bullet swiper-pagination-bullet-active"></span></div>
	</div>
</div>

<div id="page">
	<div class="product_4">
		<div class="pro4_top">
			<div class="inner">
				<div id="news_list">

					2016“双十一”承载订单12,035,921笔，日交易额破24亿
					<div style="display:none;">
						<p></p>
						<p></p>
					</div>
				</div>
			</div>
			<div class="cl"></div>
		</div>

		<div class="pro4_1">

			<div class="title_box">
				<h2><p>轻松打理你的店铺</p></h2>
				<p>无需实施安装，功能全面，注册即可准确掌握店铺的整体运营情况</p>
				<div style="display:none;">
					<p></p>
					<p></p>
				</div>
			</div>

			<div class="pro41_sbox">
				<div class="inner">
					<div class="pro41_left">
						<img src="<%=basePath%>wuliu/20161124120221_19522.png" alt="进销存系统软件">
					</div>
					<div class="pro41_right">
						<h2><p class="title">跨平台多店铺同时管理</p></h2>
						<h2><p class="title">库存实时同步易打理</p></h2>
						<p>一步注册卖家云，将电商店铺、微商店铺、<br> 跨境电商店铺、商超实体店铺对接至卖家云平台，
							<br> 通过SAAS化平台的操作，整合资源统一管理。
							<br></p>
						<p class="text" style="line-height:24px;">全渠道、全流程统一管理，订单分秒同步<br> 成为网店与实体店间的强力纽带！
							<br></p>
						<a href="/scene">实例场景</a>
						<a href="javascript:;" id="shenqing2" onclick="to_register()" rel="nofollow">立即使用</a>
					</div>
					<div class="cl"></div>
				</div>
			</div>
			<div class="pro41_sbox">

				<div class="inner">
					<div class="pro41_left">
						<h2><p class="title">智能经营模式</p></h2>
						<h2><p class="title">为卖家节省运营成本</p></h2>
						<div style="display:none;">
							<p></p>
							<p></p>
						</div>
						<p>（例）智能物流：系统结合订单重量计算，<br> 来比较不同物流之间的成本,
							<br> 并且会为商户提供最合适、快捷的物流选择。
							<br></p>
						<p class="text" style="line-height:24px;">智能节省模式优化云ERP产品细节<br> 通过多种数字模型，为店铺提供智能运营方案！
							<br></p>
						<a href="/scene">实例场景</a>
						<a href="javascript:;" id="shenqing3" onclick="to_register()" rel="nofollow">立即使用</a>
					</div>
					<div class="pro41_right">
						<img src="<%=basePath%>wuliu/20161124120203_44466.png" alt="免费进销存系统">
					</div>
					<div class="cl"></div>
				</div>
			</div>
			<div class="pro41_sbox">
				<div class="inner">

					<div class="pro41_left">
						<img src="<%=basePath%>wuliu/20161124120153_98423.png" alt="在线进销存系统">
					</div>
					<div class="pro41_right">
						<h2><p class="title">系统坚实稳定</p></h2>
						<h2><p class="title">零卡顿、零漏单护航各种大促</p></h2>
						<div style="display:none;">
							<p></p>
							<p></p>
						</div>
						<p>2016年卖家云平稳迎战双十一，<br> 成功为数万家企业完成订单量12,035,921笔，
							<br> 日交易额破24亿。
							<br></p>
						<p class="text" style="line-height:24px;">全新的卖家云，系统稳固再升级<br> 支持单店单日订单量达百万！
							<br></p>
						<a href="/scene">实例场景</a>
						<a href="javascript:;" id="shenqing4" onclick="to_register()" rel="nofollow">立即使用</a>
					</div>
					<div class="cl"></div>
				</div>
			</div>
		</div>

		<div class="pro4_2" id="pro">
			<div class="title_box">
				<h2><p>功能覆盖进销存全流程</p></h2>
				<p>SAAS化管理线上、线下店铺，无需下载软件，注册即可多端同步，随时随地使用</p>
				<div style="display:none;">
					<p></p>
					<p></p>
				</div>
			</div>
			<div class="pro42_box">
				<div class="inkPhoBox">
					<div class="main">
						<div class="left">
							<div class="mod18">
								<span id="prevTop" class="btn prev"></span>
								<span id="nextTop" class="btn next"></span>
								<div class="bigImgBox">
									<div id="picBox" class="picBox">
										<ul class="cf" style="width: 7568px;">
											<li>
												<img src="<%=basePath%>wuliu/20161011080547_97703.jpg" alt="在线进销存订单管理系统">
												<p>订单管理</p>
												<p>支持订单自动下载、批量导入处理<br> 支持订单拆分合并、电子面单、热敏打印、快递单号自动回填
													<br> 订单异常提醒、退换货处理、操作日志等
													<br></p>
												<div style="display:none;">
													<p></p>
													<p></p>
												</div>
												<a href="javascript:;" id="shen0" onclick="to_register()" rel="nofollow">立即使用</a>
											</li>
											<li>
												<img src="<%=basePath%>wuliu/20161011080807_24252.jpg" alt="在线进销存订单管理系统">
												<p>仓储管理</p>
												<p>支持库位库存管理、盘点调拨<br> 库存预警、出入库统计、订单称重
													<br> 多仓多点管理、支持扫码枪、支持热敏打印等
													<br></p>
												<div style="display:none;">
													<p></p>
													<p></p>
												</div>
												<a href="javascript:;" id="shen1" onclick="to_register()" rel="nofollow">立即使用</a>
											</li>
											<li>
												<img src="<%=basePath%>wuliu/20161011080915_11414.jpg" alt="在线进销存订单管理系统">
												<p>财务管理</p>
												<p>支持收付款单管理、采购单审核结算<br> 库存成本管理、应退款管理
													<br> 还可以在报表中心页面可以自定义生成报表等
													<br></p>
												<div style="display:none;">
													<p></p>
													<p></p>
												</div>
												<a href="javascript:;" id="shen2" onclick="to_register()" rel="nofollow">立即使用</a>
											</li>
											<li>
												<img src="<%=basePath%>wuliu/20161011081011_92617.jpg" alt="在线进销存订单管理系统">
												<p>采购管理</p>
												<p>支持添加采购计划、生成采购单<br> 有采购单入库，添加采购退货单等
													<br></p>
												<div style="display:none;">
													<p></p>
													<p></p>
												</div>
												<a href="javascript:;" id="shen3" onclick="to_register()" rel="nofollow">立即使用</a>
											</li>
											<li>
												<img src="<%=basePath%>wuliu/20161011081108_49179.jpg" alt="在线进销存订单管理系统">
												<p>售后管理</p>
												<p>支持退换货提醒、售中退款<br> 售后退款、退款退货、售后状态查看等
													<br></p>
												<div style="display:none;">
													<p></p>
													<p></p>
												</div>
												<a href="javascript:;" id="shen4" onclick="to_register()" rel="nofollow">立即使用</a>
											</li>
											<li>
												<img src="<%=basePath%>wuliu/20161011081151_60619.jpg" alt="在线进销存订单管理系统">
												<p>会员管理</p>
												<p>可为店铺会员进行活动推广<br> 积分管理等日常客户维护操作、支持设定多维度的互动推送
													<br> 如会员等级、生日、区域等
													<br></p>
												<div style="display:none;">
													<p></p>
													<p></p>
												</div>
												<a href="javascript:;" id="shen5" onclick="to_register()" rel="nofollow">立即使用</a>
											</li>
											<li>
												<img src="<%=basePath%>wuliu/20161011081306_71594.jpg" alt="在线进销存订单管理系统">
												<p>供销管理</p>
												<p>支持实时链接经销商，同步资源<br> 支持多维度分销管理；支持基于大数据的智能供销匹配方案
													<br> 为供应商、经销商之间搭建合作桥梁，或经人工进行高匹配度供销撮合
													<br></p>
												<div style="display:none;">
													<p></p>
													<p></p>
												</div>
												<a href="javascript:;" id="shen6" onclick="to_register()" rel="nofollow">立即使用</a>
											</li>
											<li>
												<img src="<%=basePath%>wuliu/20161011081403_83682.jpg" alt="在线进销存订单管理系统">
												<p>运营日报</p>
												<p>支持基于微信的日报发送<br> 包含运营情况、行业热文、干货等
													<br> 同时还会向商户提供当日最新的所订阅内容
													<br></p>
												<div style="display:none;">
													<p></p>
													<p></p>
												</div>
												<a href="javascript:;" id="shen7" onclick="to_register()" rel="nofollow">立即使用</a>
											</li>
											<li>
												<img src="<%=basePath%>wuliu/20161011081449_38586.jpg" alt="在线进销存订单管理系统">
												<p>实体店管理</p>
												<p>打通线下实体店<br> 真正做到线上线下全渠道管理
													<br> 支持门店添加删减、店铺同步等操作
													<br></p>
												<div style="display:none;">
													<p></p>
													<p></p>
												</div>
												<a href="javascript:;" id="shen8" onclick="to_register()" rel="nofollow">立即使用</a>
											</li>
											<li>
												<img src="<%=basePath%>wuliu/20161011081606_43576.jpg" alt="在线进销存订单管理系统">
												<p>员工管理</p>
												<p>支持员工角色权限分配与控制、组织管理<br> 子账号建立或删除、站内信权限等
													<br></p>
												<div style="display:none;">
													<p></p>
													<p></p>
												</div>
												<a href="javascript:;" id="shen9" onclick="to_register()" rel="nofollow">立即使用</a>
											</li>
											<li>
												<img src="<%=basePath%>wuliu/20161011081649_51745.jpg" alt="在线进销存订单管理系统">
												<p>商品管理</p>
												<p>支持一键商品初始化、促销管理<br> 商品组合、全渠道智能库存
													<br> 同步、sku码管理、商品统计及热销商品统计等
													<br></p>
												<div style="display:none;">
													<p></p>
													<p></p>
												</div>
												<a href="javascript:;" id="shen10" onclick="to_register()" rel="nofollow">立即使用</a>
											</li>
										</ul>
									</div>
								</div>
								<div class="smImgBox" style="margin-left:-60px;">
									<span id="prev" class="btn prev"></span>
									<span id="next" class="btn next"></span>
									<div id="listBox" class="listBox">
										<ul class="cf" style="width: 1512px;">


											<li class="on">
												<img src="<%=basePath%>wuliu/abb_1.png" alt="在线进销存订单管理系统" class="buyao">
												<img src="<%=basePath%>wuliu/20161011083621_59523.png" alt="在线进销存订单管理系统" class="add_hover">
												<p>订单管理</p>
											</li>
											<div style="display:none;">
												<p></p>
												<p></p>
											</div>

											<li>
												<img src="<%=basePath%>wuliu/abb_2.png" alt="在线进销存订单管理系统" class="buyao">
												<img src="<%=basePath%>wuliu/20161011083637_99637.png" alt="在线进销存订单管理系统" class="add_hover">
												<p>仓储管理</p>
											</li>
											<div style="display:none;">
												<p></p>
												<p></p>
											</div>

											<li>
												<img src="/img/abb_3.png" alt="在线进销存订单管理系统" class="buyao">
												<img src="<%=basePath%>wuliu/20161011083654_55013.png" alt="在线进销存订单管理系统" class="add_hover">
												<p>财务管理</p>
											</li>
											<div style="display:none;">
												<p></p>
												<p></p>
											</div>

											<li>
												<img src="<%=basePath%>wuliu/abb_4.png" alt="在线进销存订单管理系统" class="buyao">
												<img src="<%=basePath%>wuliu/20161011083746_59677.png" alt="在线进销存订单管理系统" class="add_hover">
												<p>采购管理</p>
											</li>
											<div style="display:none;">
												<p></p>
												<p></p>
											</div>

											<li>
												<img src="<%=basePath%>wuliu/abb_5.png" alt="在线进销存订单管理系统" class="buyao">
												<img src="<%=basePath%>wuliu/20161011083800_37652.png" alt="在线进销存订单管理系统" class="add_hover">
												<p>售后管理</p>
											</li>
											<div style="display:none;">
												<p></p>
												<p></p>
											</div>

											<li>
												<img src="<%=basePath%>wuliu/abb_6.png" alt="在线进销存订单管理系统" class="buyao">
												<img src="<%=basePath%>wuliu/20161011083814_77818.png" alt="在线进销存订单管理系统" class="add_hover">
												<p>会员管理</p>
											</li>
											<div style="display:none;">
												<p></p>
												<p></p>
											</div>

											<li>
												<img src="<%=basePath%>wuliu/abb_7.png" alt="在线进销存订单管理系统" class="buyao">
												<img src="<%=basePath%>wuliu/20161011083827_28009.png" alt="在线进销存订单管理系统" class="add_hover">
												<p>供销管理</p>
											</li>
											<div style="display:none;">
												<p></p>
												<p></p>
											</div>

											<li>
												<img src="<%=basePath%>wuliu/abb_8.png" alt="在线进销存订单管理系统" class="buyao">
												<img src="<%=basePath%>wuliu/20161011083841_87393.png" alt="在线进销存订单管理系统" class="add_hover">
												<p>运营日报</p>
											</li>
											<div style="display:none;">
												<p></p>
												<p></p>
											</div>

											<li>
												<img src="<%=basePath%>wuliu/abb_9.png" alt="在线进销存订单管理系统" class="buyao">
												<img src="<%=basePath%>wuliu/20161011083856_16951.png" alt="在线进销存订单管理系统" class="add_hover">
												<p>实体店管理</p>
											</li>
											<div style="display:none;">
												<p></p>
												<p></p>
											</div>

											<li>
												<img src="<%=basePath%>wuliu/abb_10.png" alt="在线进销存订单管理系统" class="buyao">
												<img src="<%=basePath%>wuliu/20161011083908_21162.png" alt="在线进销存订单管理系统" class="add_hover">
												<p>员工管理</p>
											</li>
											<div style="display:none;">
												<p></p>
												<p></p>
											</div>

											<li>
												<img src="<%=basePath%>wuliu/abb_11.png" alt="在线进销存订单管理系统" class="buyao">
												<img src="<%=basePath%>wuliu/20161011083921_45576.png" alt="在线进销存订单管理系统" class="add_hover">
												<p>商品管理</p>
											</li>
											<div style="display:none;">
												<p></p>
												<p></p>
											</div>
										</ul>
									</div>
								</div>
								<div class="clear"></div>
							</div>
							<div class="clear"></div>
						</div>
						<div class="clear"></div>
					</div>
				</div>
			</div>
		</div>

		<div class="pro4_3">
			<div class="title_box">

				<h2><p>他们这样描述卖家云ERP</p></h2>
				<p>你的选择与陪伴，是我们不断前行、努力的动力和理由</p>
				<div style="display:none;">
					<p></p>
					<p></p>
				</div>
			</div>
			<div class="text_box">

				<div class="text_sbox">
					<div class="ts_top">
						<p>卖家云ERP的管理系统，很实用，并且方便操作，功能也很全面，系统功能和其他ERP软件相比，更强大更全面，体验也更好，数据更安全，售后服务也很好。</p>
					</div>
					<div style="display:none;">
						<p></p>
						<p></p>
					</div>
					<div class="ts_btm">
						<div class="tsb_left">
							<img src="<%=basePath%>wuliu/20161011085144_26457.png" alt="云erp进销存平台-福建光电">
						</div>
						<div class="tsb_right">
							<p><span>福建光电</span><span>品质为先、工匠精神，专业光盘生产厂家</span></p>
							<p>@ 云ERP</p>
						</div>
						<div class="cl"></div>
					</div>
				</div>
				<div class="text_sbox">
					<div class="ts_top">
						<p>卖家云ERP是朋友介绍的，系统比较全面，俱备了目前市场上电商系统大部分功能，最重要的是售后非常好，不像一些牌子挺大的，但是售后很不好，所以选择了卖家云，很实用！</p>
					</div>
					<div style="display:none;">
						<p></p>
						<p></p>
					</div>
					<div class="ts_btm">
						<div class="tsb_left">
							<img src="<%=basePath%>wuliu/20161011085041_73663.png" alt="云erp进销存平台-妮狄娅">
						</div>
						<div class="tsb_right">
							<p><span>妮狄娅</span><span>25年家居服专业外贸出口服务商</span></p>
							<p>@ 云ERP</p>
						</div>
						<div class="cl"></div>
					</div>
				</div>
				<div class="cl"></div>
			</div>
		</div>

		<div class="pro4_4">
			<div class="inner">

				<a href="case"><img src="<%=basePath%>wuliu/20161011091402_45032.jpg" alt="进销存软件案例-佳雪"></a>
				<a href="case"><img src="<%=basePath%>wuliu/20161011091326_99829.jpg" alt="进销存软件案例-采诗"></a>
				<a href="case"><img src="<%=basePath%>wuliu/20161011091302_90120.jpg" alt="进销存软件案例-探路者"></a>
				<a href="case"><img src="<%=basePath%>wuliu/20161011091240_41206.jpg" alt="进销存系统案例-北极狐"></a>
				<a href="case"><img src="<%=basePath%>wuliu/20161011091224_31920.jpg" alt="进销存系统案例-周大福"></a>
				<a href="case"><img src="<%=basePath%>wuliu/20161011091158_19085.jpg" alt="进销存系统案例-康佳"></a>
				<a href="case">查看更多&gt;</a>
			</div>
		</div>
	</div>
</div>

		</div>
		<div class="up_foot">
			<div class="up_box">
				<span class="popover-container" href="javascript:;">
					<div class="inner_box a1">
						<div class="inner">

							<div class="left">
								<img src="<%=basePath%>wuliu/20161011112710_26798.png" alt="卖家云erp软件官方微信"/>
							</div>
							<div class="right">
								<p>官方微信</p>
								<p>手机扫描左侧二维码</p>
								<p>随时获得最新资讯，还有优惠活动哦！</p>
							</div>
							<div class="cl"></div>
						</div>
					</div>
				</span>
				<span class="popover-container" href="javascript:;">
					<div class="inner_box a2">
						<div class="inner">

							<div class="left">
								<img src="<%=basePath%>wuliu/20161011112743_69273.png" alt="卖家云erp软件官方微博"/>
							</div>
							<div class="right">
								<p>官方微博</p>
								<p>手机扫描左侧二维码</p>
								<p>随时获得最新资讯，还有优惠活动哦！</p>
							</div>
							<div class="cl"></div>
						</div>
					</div>
				</span>
				<span class="popover-container" href="javascript:;">
					<div class="inner_box a3">
						<div class="inner">

							<a href="javascript:;" onclick="ysf.open()" rel="nofollow">马上咨询</a>
							<p>资深服务服团队一对一为您服务，点击上方按钮咨询吧！</p>
						</div>
					</div>
				</span>
				<span class="popover-container" href="javascript:;">
					<div class="inner_box a4">
						<div class="inner">

							<div class="text_box">
								<p>-成都（西南）-</p>
								<p>[028-86110906]</p>
							</div>
							<div style="display:none;">
								<p></p>
								<p></p>
							</div>
							<div class="text_box">
								<p>-上海（华东）-</p>
								<p>[010-58103284]</p>
							</div>
							<div style="display:none;">
								<p></p>
								<p></p>
							</div>
							<div class="text_box">
								<p>-北京（总部）-</p>
								<p>[010-58103284]</p>
							</div>
							<div style="display:none;">
								<p></p>
								<p></p>
							</div>
							<div class="text_box">
								<p>-广州（华南）-</p>
								<p>[020-87798846]</p>
							</div>
							<div style="display:none;">
								<p></p>
								<p></p>
							</div>
							<div class="cl"></div>
						</div>
					</div>
				</span>
				<span class="popover-container" href="javascript:;">
					<div class="inner_box a5">
						<div class="inner">
							<div class="text_box">

								<p>-企业邮箱-</p>
								<p>[ hetang@bjhetang.com ]</p>
								<div style="display:none;">
									<p>[ hetang@bjhetang.com ]</p>
									<p></p>
								</div>
							</div>
						</div>
					</div>
				</span>
				<span class="popover-container" href="javascript:;">
					<div class="inner_box a6" style="height:auto">
						<div class="news_block">
							<div class="news_block_content">
								<div class="left-bar">
									<div class="primary-thumb-container swiper-container">
										<div class="swiper-wrapper">
											<div class="swiper-slide">
												<div class="thumb">
												    <img src="<%=basePath%>wuliu/SC-TtoUM6W_v47WP.jpeg">
												    <div class="title"><a href="/blog/post/erp-2">答疑：门店管理erp什么版本好？才能让你在新零售时代快人一步！</a></div>
												</div>
											</div>
											<div class="swiper-slide">
												<div class="thumb">
												    <img src="<%=basePath%>wuliu/y1hQhzE0qzrhb5nX.png">
												    <div class="title"><a href="/blog/post/593a018cf509be2355288a14">网店运营技巧：拯救店铺里滞销的好货</a></div>
												</div>
											</div>
											<div class="swiper-slide">
												<div class="thumb">
												    <img src="<%=basePath%>wuliu/XxAbo2hTQButE4ZO.png">
												    <div class="title"><a href="/blog/post/erp-9">干货：挑选一款适合自己的店铺ERP一定要看这9个标准！</a></div>
												</div>
											</div>
											<div class="swiper-slide">
												<div class="thumb">
												    <img src="<%=basePath%>wuliu/FUMJQjKrbG5-kmIb.png">
												    <div class="title"><a href="/blog/post/erp-1">【亚马逊erp推荐】想提升亚马逊店铺的销量？试试这两招！</a></div>
												</div>
											</div>
											<div class="swiper-slide">
												<div class="thumb">
												    <img src="<%=basePath%>wuliu/0FJ6HQ6WiBcR_0mi.png">
												    <div class="title"><a href="/blog/post/5938e3f6f509be2355288a10">咋办：老老实实开店做生意，却被恶意买家“碰瓷儿”给差评？</a></div>
												</div>
											</div>
										</div>
										<div class="swiper-scrollbar"></div>
									</div>
									<div class="secondary-thumb-container">
										<div class="secondary-thumb"><div class="thumb">
    <img src="/uploads<%=basePath%>wuliu/20161226/20161226094426_26235.png">
    <div class="title"><a href="/blog/post/5934c00224959d213487177d">都说了解千人千面，真的吗？！</a></div>
</div>
</div>
										<div class="secondary-thumb"><div class="thumb">
    <img src="<%=basePath%>wuliu/20161219/20161219154117_71314.png">
    <div class="title"><a href="/blog/post/5934c00224959d213487177c">店铺装修 - 抓住用户的第一印象</a></div>
</div>
</div>
										<div class="secondary-thumb"><div class="thumb">
    <img src="<%=basePath%>wuliu/20161219/20161219150643_15408.png">
    <div class="title"><a href="/blog/post/5934c00224959d213487177b">店铺装修 - 字体的处理</a></div>
</div>
</div>
									</div>
								</div>
								<div class="right-bar">
									<h4>新闻资讯</h4>
									<div class="title-container">
										<div class="title"><a href="/blog/post/5934c00224959d213487177a">粉丝变粉条：小卖家应该掌握的小投入大产出！！</a></div>
										<div class="sub-title">
											184天1小时31分钟前
										</div>
									</div>
									<div class="title-container">
										<div class="title"><a href="/blog/post/4">商家干货分享：4招逆袭的亚马逊卖家</a></div>
										<div class="sub-title">
											184天1小时45分钟前
										</div>
									</div>
									<div class="title-container">
										<div class="title"><a href="javascript:void(0);">我只是想让你赚钱的时候，爽一点</a></div>
										<div class="sub-title">
											186天1小时38分钟前
										</div>
									</div>
									<div class="title-container">
										<div class="title"><a href="javascript:void(0);">经营书店，让一个初中文化的糙汉子变成了读书人</a></div>
										<div class="sub-title">
											186天1小时45分钟前
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</span>
			</div>
		</div>
		<div id="footer" style="margin-top:0">
			<div class="footer_top">
				<div class="inner">
					<div class="logo_1">
						<a href="/">
							<img src="<%=basePath%>wuliu/20161011113715_12353.png" alt="卖家云-免费erp,erp系统,erp软件,erp管理软件,erp管理系统平台,erp">
						</a>
					</div>
					<div class="nav_1">
						<p>产品&amp;解决方案</p>
						<ul>
							<li><a href="javascript:void(0);" target="_blank"> 云ERP </a></li>
							<li><a href="javascript:void(0);" target="_blank"> 企业定制 </a></li>
							<li><a href="javascript:void(0);" target="_blank"> 使用场景 </a></li>
							<li><a href="javascript:void(0);" target="_blank"> 行业方案 </a></li>
							<li><a href="javascript:void(0);" target="_blank"> 成功案例 </a></li>
							<li><a href="javascript:void(0);" target="_blank">公司介绍</a></li>
							<li><a href="javascript:void(0);" target="_blank">新闻资讯</a></li>
						</ul>
					</div>
					<div class="nav_2">
						<p>商务合作</p>
						<ul>
							<li>联系电话：176-0797-5702</li>
							<li>联系邮箱：weiwd@bjhetang.com</li>
						</ul>
						<div style="display:none;">
							<p>联系电话：176-0797-5702</p>
							<p>联系邮箱：weiwd@bjhetang.com</p>
						</div>
					</div>
					<div class="cl"></div>
				</div>
			</div>
			<div class="footer_btm" style="background: #313435">
				<div class="inner">
					©2017&nbsp;公司&nbsp;京ICP备13012226号-3&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;北京市昌平区立汤路188号北方明珠大厦2-2020室（住宅楼）
					<div style="display:none;">
						<p>©2017 公司 京ICP备13012226号-3</p>
						<p></p>
					</div>
				</div>
			</div>
		</div>
		<div class="video_shade">
			<div class="video_box">
				<i class="video_close">关闭</i>
				<embed src='http://player.youku.com/player.php/sid/XMTgyMjYwMDE1Ng==/v.swf' allowFullScreen='true' quality='high' width='100%' height='100%' align='middle' allowScriptAccess='always' type='application/x-shockwave-flash'></embed>
			</div>
		</div>

		<script src="<%=basePath%>Wj/jquery/jquery-1.11.3.min.js"></script>
		<script src="<%=basePath%>Wj/bootstrap/bootstrap-3.3.5.min.js"></script>
		<script src="<%=basePath%>Wj/kefu.js" type="text/javascript"></script>
		<script src="<%=basePath%>Wj/swiper.min.js"></script>
		<script src="<%=basePath%>Wj/main.js" type="text/javascript" charset="utf-8"></script>

		<script src="<%=basePath%>Wj/form.js" type="text/javascript"></script>

		

		<script src="<%=basePath%>Wj/jqueryPhoto.js" type="text/javascript"></script>
		<script src="<%=basePath%>Wj/product_4.js" type="text/javascript"></script>
	</body>
	</html>

