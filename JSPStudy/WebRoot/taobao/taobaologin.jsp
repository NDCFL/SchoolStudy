<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <style>
	#navigation, #navigation li ul { list-style-type:none; } 
	#navigation li { float:right; text-align:center; position:relative; } 
	#navigation li a:link, #navigation li a:visited { display:block; text-decoration:none; color:#000; width:80px; height:40px; line-height:40px; border:1px medium #fff; border-width:1px 1px 0 0; background:#99ccff;  padding-left:0px; } 
	#navigation li a:hover { color:#ff6633; } 
	#navigation li ul li a:hover { color:#ff6633; background:#ccffff; } 
	#navigation li ul {display:none; position:absolute;top:40px; right:0; margin-top:0; width:40px; } 
  </style>
  <script type="text/javascript">
	  function displaySubMenu(li) { 
			var subMenu = li.getElementsByTagName("ul")[0]; 
			subMenu.style.display = "block"; 
		} 
		function hideSubMenu(li) { 
			var subMenu = li.getElementsByTagName("ul")[0]; 
			subMenu.style.display = "none"; 
		}
  </script>
  <base href="<%=basePath%>">
  <title>My JSP 'taobaologin.jsp' starting page</title>
  </head>
  <body>
    <table border="0" width="100%" bgcolor="#99ccff" height="40">
    	<tr>
    		<td width="300">
    			<table border="0"  width="100%">
    			<tr align="center">
    				<td><a href="">亲,请先登录</a></td>
    				<td><a href="">免费注册</a></td>
    				<td><a href="">手机逛淘宝</a></td>
    			</tr>
    			</table>
		    </td>
		    <td  width="200"></td>
		    <td align="right" width="800">
		    	<table border="0"  width="100%">
    			<tr align="center">
    				<td width="30">
    				<ul id="navigation">
    					<li onmouseover="displaySubMenu(this)" onmouseout="hideSubMenu(this)"> 
							<a href="">我的淘宝</a>
							<ul>
								<li><a href="#">已买到的宝贝</a></li>
								<li><a href="#">我的宝贝</a></li>
							</ul>        	
        				</li>
    				</ul>	
    				</td>
    				<td><a href="">购物车</a></td>
    				<td width="30">
    					<ul id="navigation">
    					<li onmouseover="displaySubMenu(this)" onmouseout="hideSubMenu(this)"> 
							<a href="">收藏夹</a>
							<ul>
								<li><a href="#">收藏的宝贝</a></li>
								<li><a href="#">收藏的店铺</a></li>
							</ul>        	
        				</li>
    				</ul>	
    					
    				</td>
    				<td><a href="">商品分类</a></td>
    				<td width="3" bgcolor="#6699ff"></td>
    				<td><a href="">买家中心</a></td>
    				<td><a href="">联系客服</a></td>
    				<td><a href="">网站导航</a></td>
    				<td width="80"></td>
    			</tr>
    			</table>
		    </td>
  	</table>
  	<table width="1300" height="160" border="0">
  		<tr>
	  		<td width="50"></td>
	  		<td width="160" align="center"><img src="taobaoimg/taobao.jpg"></td>
	  		<td width="80"></td>
	  		<td width="900">
				<table border="0"  height="100">
					<tr height="30"><td><a href="">宝贝</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="">天猫</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="">店铺</a></td></tr>
					<tr><td height="30" colspan="2"><input type="text" style="width:500px;height:40px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" style="width:90px;height:40px" value=" 搜 索 "></td></tr>
					<tr height="20">
						<td height="20">
							<table border="0">
								<tr>
									<td>
										<a href="">新款连衣裙</a>&nbsp;&nbsp;&nbsp;&nbsp;
										<a href="">四件套</a>&nbsp;&nbsp;&nbsp;&nbsp;
										<a href="">潮流T恤</a>&nbsp;&nbsp;&nbsp;&nbsp;
										<a href="">时尚女鞋</a>&nbsp;&nbsp;&nbsp;&nbsp;
										<a href="">短裙</a>&nbsp;&nbsp;&nbsp;&nbsp;
										<a href="">半身裙</a>&nbsp;&nbsp;&nbsp;&nbsp;
										<a href="">男士外套</a>&nbsp;&nbsp;&nbsp;&nbsp;
										<a href="">墙纸</a>&nbsp;&nbsp;&nbsp;&nbsp;
										<a href="">行车自动仪</a>&nbsp;&nbsp;&nbsp;&nbsp;
									</td>
								</tr>
							
							</table>
						</td>
					</tr>
				</table>
			</td>
			<td width="200" align="center" height="20"><img src="taobaoimg/erweima.png"></td>
  		</tr>
  		
  	</table>
  	<table border="5" width="100%" height="500" >
  		<tr>
  			<td width="40"></td>
  			<td width="180">
  				<table width="100%" height="100%" border="0" bgcolor="#ff9933">
  					<tr height="30">
  						<td>
  							<span>
								<a href="" data-cid="1">女装</a> /
								<a href="" data-cid="1">男装</a> /
								<a href="" data-cid="1">内衣</a>
							</span>
  						</td>
  					</tr>
  					<tr height="30">
  						<td>
  							<span>
								<span>
									<a href="" data-cid="1" >鞋靴</a> /
									<a href="" data-cid="1" >箱包</a> /
									<a href="" data-cid="1" >配件</a>
								</span>
							</span>
  						</td>
  					</tr>
  					<tr height="30">
  						<td>
  							<span>
								<a href="">童装玩具</a> /
								<a href="">孕产</a> /
								<a href="">用品</a>
							</span>
  						</td>
  					</tr>
  					<tr height="30">
  						<td>
  							<span>
								<a href="" data-dataid="222878">家电</a> /
								<a href="" data-dataid="222908">数码</a> /
								<a href="" data-dataid="222879">手机</a>
							</span>
  						</td>
  					</tr>
  					<tr height="30">
  						<td>
  							<span>
								<a href="">美妆</a> /
								<a href="">洗护</a> /
								<a href="">保健品</a>
							</span>
  						</td>
  					</tr>
  					<tr height="30">
  						<td>
  							<span>
								<a href="">珠宝</a> /
								<a href="">眼镜</a> /
								<a href="">手表</a>
							</span>
  						</td>
  					</tr>
  					<tr height="30">
  						<td>
  							<span>
								<a href="">运动</a> /
								<a href="">户外</a> /
								<a href="">乐器</a>
							</span>
  						</td>
  					</tr>
  					<tr height="30">
  						<td>
  							<span>
								<a href="">游戏</a> /
								<a href="">动漫</a> /
								<a href="">影视</a>
							</span>
  						</td>
  					</tr>
  					<tr height="30">
  						<td>
  							<span>
								<a href="">美食</a> /
								<a href="">生鲜</a> /
								<a href="">零食</a>

							</span>
  						</td>
  					</tr>
  					<tr height="30">
  						<td>
  							<span>
								<a href="">鲜花</a> /
								<a href="">宠物</a> /
								<a href="">农资</a>
							</span>
  						</td>
  					</tr>
  					<tr height="30">
  						<td>
  							<span>
								<a href="">房产</a> /
								<a href="">装修</a> /
								<a href="">建材</a>
							</span>
  						</td>
  					</tr>
  					<tr height="30">
  						<td>
  							<span>
								<a href="">家具</a> /
								<a href="">家饰</a> /
								<a href="">家纺</a>
							</span>
  						</td>
  					</tr>
  				</table>
  			</td>
  		<td width="1000">
  			<table width="900" height="100%" border="2">
  				<tr height="250">
  					<td width="300" height="100">
						<table border="1" width="100%" height="100%">
							<tr height="200" width="100%"><td>1</td></tr>
							<tr height="50" width="100%"><td>2</td></tr>
						</table>
					</td>
  					<td width="300" height="100">
  						<table border="1" width="100%" height="100%">
							<tr height="200" width="100%"><td>1</td></tr>
							<tr height="50" width="100%"><td>2</td></tr>
						</table>
					</td>
  					<td width="300" height="100">
  						<table border="1" width="100%" height="100%">
							<tr height="200" width="100%"><td>1</td></tr>
							<tr height="50" width="100%"><td>2</td></tr>
						</table>
  					</td>
  				</tr>
  				<tr height="250">
  					<tr height="250">
  					<td width="300" height="100">
						<table border="1" width="100%" height="100%">
							<tr height="200" width="100%"><td>1</td></tr>
							<tr height="50" width="100%"><td>2</td></tr>
						</table>
					</td>
  					<td width="300" height="100">
  						<table border="1" width="100%" height="100%">
							<tr height="200" width="100%"><td>1</td></tr>
							<tr height="50" width="100%"><td>2</td></tr>
						</table>
					</td>
  					<td width="300" height="100">
  						<table border="1" width="100%" height="100%">
							<tr height="200" width="100%"><td>1</td></tr>
							<tr height="50" width="100%"><td>2</td></tr>
						</table>
  					</td>
  				</tr>
  			</table>
s  		</td>
  		</tr>
  	</table>
  </body>
</html>
