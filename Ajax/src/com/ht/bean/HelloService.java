package com.ht.bean;

/*
 * DWR步骤：
 * 1.导包
 * 2.在web.xml中配置DWRServlet
 * 3.编写服务器组件
 * 4.在dwr.xml中配置服务器组件
 * 		javascript="指定服务组件的名称，在页面中调用时需要使用该名称helloService"
 * 		<create creator="new" javascript="helloService">
			<param name="class" value="com.ht.bean.HelloService" />
			默认情况下所有的公有函数都可以调用
			允许在页面调用的函数
			<include method="sayHello"/>

		</create>
	5.在页面调用，必须加载engine.js和util.js文件
	<script type="text/javascript" src="dwr/engine.js"></script>
    <script type="text/javascript" src="dwr/util.js"></script>
    必须加载当前页面需要调用的服务组件
    <script type="text/javascript" src="dwr/interface/helloService.js"></script>
    
    1.创建测试函数，
    2.创建回调函数;
 * */
public class HelloService {

	public String sayHello(String name){
		System.out.println(name);
		return "你好，"+name;
	}
	public String sayHello1(String name){
		System.out.println(name);
		return "你好，"+name +",欢迎访问本站";
	}
	public String sayHello2(String name){
		System.out.println(name);
		return "你好，"+name +",你是第一个访问本站的用户";
	}
	public String sayHello3(String name){
		System.out.println(name);
		return "你好，"+name+",到处逛逛吧！";
	}
}
