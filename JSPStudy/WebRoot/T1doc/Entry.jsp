<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Entry.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
	var arr = [
			"江西省",["赣州市",["南康区","章贡区","赣县","石城县"],"南昌市",["东湖区","西湖区"]],
			"广东省",["广州市",["天河区","荔湾区"],"东莞市",["厚街镇","大岭山镇"]],
			"湖南省",["长沙市",["芙蓉区","天心区"],"常德市",["桃源县","安乡县"]]
	];
	function prov(){
		var province = document.getElementById("province");
		for(var i = 0;i<arr.length;i++){
			var arr1=arr[i];
			//判断元素是普通的值还是数组
			if(!(arr1 instanceof Array)){
				//不是数组的元素放在省的下拉框中
				province.options[province.options.length] = new Option(arr1,arr1);
			}
		}
		citydata();
	}
	//获取省对应的市
	function citydata(){
		//获取选中的省
		var provdata = document.getElementById("province").value;
		//获取显示市的下拉框
		var city = document.getElementById("city");
		for(var i = 0;i<arr.length;i++){
			var arr1=arr[i];
			//只处理一维数组中不是数组的元素
			if(!(arr1 instanceof Array)){
				if(arr1==provdata){
					//获取对应省份的二维数组（所有的市）
					var citydata = arr[i+1];
					//清空市下拉框中所有的选项
					city.options.length=0;
					for(var j=0;j<citydata.length;j++){
						if(!(citydata[j] instanceof Array)){
							city.options[city.options.length] = new Option(citydata[j],citydata[j]);
						}
					}
				}	
			}
		}
		countydata();
	}
	function countydata(){
		//获取县的下拉框
		var county = document.getElementById("county");
		//获取选中的市
		var city = document.getElementById("city").value;
		county.options.length=0;
		for(var i = 0;i<arr.length;i++){
			var arr1=arr[i];
			//省对应的数组才处理（所有的市）
			if(arr1 instanceof Array){
				var citydata = arr[i];
				for(var j=0;j<citydata.length;j++){
					if(!(citydata[j] instanceof Array)){
						var countydata = citydata[j];
						if(countydata==city){
							//获取当前市对应的所有县区
							var items = citydata[j+1];
							for(var k=0;k<items.length;k++){
								county.options[county.options.length] = new Option(items[k],items[k]);
							}
						
						}


						
					}
				}
			}
		}
	
	}
	function yanzheng(){
		if(form1.name.value==""){
			alert("昵称不能为空！");
			form1.name.focus();
			return false;
		}
		if(form1.pass1.value==""){
			alert("密码不能为空！");
			form1.pass1.focus();
			return false;
		}
		if(form1.pass2.value==""){
			alert("确认密码不能为空！");
			form1.pass1.focus();
			return false;
		}
		if(form1.pass1.value!=form1.pass2.value){
			alert("确认密码和密码不一致！");
			return false;
		}
		if(form1.age1.value){
			alert("年龄不能为空！");
			form1.age1.focus();
			return false;
		}
		if(isNaN(form1.age1.value)){
			alert("年龄含有非法字符！");
			form1.age1.focus();
			return false;
		}
		return true;
	
	}
	window.onload=function (){
		setInterval("document.getElementById('time').innerHTML=new Date().toLocaleString()+' 星期'+'日一二三四五六'.charAt(new Date().getDay());",1000);
	}
	</script>
  </head>
  <body onload="prov();" text="blue">
  <form action=""T6doc/usebeandemo1.jsp"" method="post" name="form1" onsubmit="return yanzheng();">
  <font face="华文行楷" color='blue'>
  <center>
  	<table border="0" width="400" height="400" align="center">
	  	
	  		<tr><td align="center" id="time"><h1>用户注册信息</h1></td></tr>
	  		<tr><td >昵&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="name" size="19"></td></tr>
	  		<tr><td>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="password" name="pass1" size="20"></td></tr>
	  		<tr><td>确认密码：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="password" name="pass2" ></td></tr>
	  		<tr><td>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="sex" value="男" checked>男<input type="radio" name="sex" value="女">女</td></tr>
	  		<tr><td>年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;龄：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="age1" size="19"></td></tr>
	  		<tr><td>
	  				课&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;程：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	  					 <input type="checkbox" value="html" name="hobit" id="hobit1">html
						 <input type="checkbox" value="C语言" name="hobit" id="hobit2">C语言
						 <input type="checkbox" value="Java" name="hobit" id="hobit3">Java
						 <input type="checkbox" value="JS" name="hobit" id="hobit4">JS
			</td></tr>
	  		<tr><td>地&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;区：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	  					<select name="province" id="province" onchange="citydata();"></select>
						<select name="city" id="city" onchange="countydata();"></select>
						<select name="county" id="county"></select>
			</td></tr>
			<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" name="sub1" id="sub1" value="提交">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" name="res1" id="res1" value="清空"></td></tr>
  	</table>
  	</center>
  	</font>
  </form>
    
  </body>
</html>
