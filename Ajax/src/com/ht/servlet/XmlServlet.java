package com.ht.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class XmlServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 封装成XML文件格式
		 * 学号	姓名		年龄		性别		班级名称
		 * 1001	张三		20		男		宏图1601班
		 * 
		 * 
		 * */
		
		response.setContentType("text/xml;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<?xml version='1.0' encoding='utf-8' ?>");
		out.print("<studentList>");
		out.print("<student><studid>1001</studid><studname>张三</studname><age>20</age><sex>男</sex><classname>宏图201601班</classname></student>");
		out.print("<student><studid>1002</studid><studname>李四</studname><age>22</age><sex>男</sex><classname>宏图201602班</classname></student>");
		out.print("<student><studid>1003</studid><studname>王五</studname><age>21</age><sex>男</sex><classname>宏图201601班</classname></student>");
		out.print("<student><studid>1004</studid><studname>小丽</studname><age>16</age><sex>女</sex><classname>宏图201603班</classname></student>");
		out.print("<student><studid>1005</studid><studname>黄蓉</studname><age>18</age><sex>女</sex><classname>宏图201604班</classname></student>");
		out.print("</studentList>");
		out.flush();
		out.close();
	}

}
