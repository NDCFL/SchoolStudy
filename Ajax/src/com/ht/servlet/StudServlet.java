package com.ht.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.ht.base.BaseDAO;
import com.ht.bean.StudVo;

public class StudServlet extends HttpServlet {
/*
 * create table student
	(
		studid int primary key,
		studname varchar(20),
		sex varchar(4) default '男',
		cardid varchar(18),
		age int,
		classname varchar(30)
	)
 * */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		BaseDAO base = new BaseDAO();
		if(action.equals("add")){
			String studid = request.getParameter("studid");
			String studname = request.getParameter("studname");
			String cardno = request.getParameter("cardno");
			String classname = request.getParameter("classname");
			String age = request.getParameter("age");
			String sex = request.getParameter("sex");
			StudVo s = new StudVo();
			s.setAge(Integer.parseInt(age));
			s.setCardid(cardno);
			s.setClassname(classname);
			s.setSex(sex);
			s.setStudid(Integer.parseInt(studid));
			s.setStudname(studname);
			base.add(s);
			
			//查询学生资料列表
			List<StudVo> studList = base.studList();
			String data = JSON.toJSONString(studList);
			System.out.println(data);
			out.println(data);
		}else if(action.equals("list")){
			//查询学生资料列表
			List<StudVo> studList = base.studList();
			String data = JSON.toJSONString(studList);
			System.out.println(data);
			out.println(data);
		}else if(action.equals("del")){
			String studid = request.getParameter("studid");
			base.del(studid);
			List<StudVo> studList = base.studList();
			String data = JSON.toJSONString(studList);
			System.out.println(data);
			out.println(data);
		}else if(action.equals("update")){
			String studid = request.getParameter("studid");
			StudVo stud = base.findStudById(studid);
			String data = JSON.toJSONString(stud);
			System.out.println(data);
			out.println(data);
		}else if(action.equals("updatesave")){
			String studid = request.getParameter("studid");
			String studname = request.getParameter("studname");
			String cardno = request.getParameter("cardno");
			String classname = request.getParameter("classname");
			String age = request.getParameter("age");
			String sex = request.getParameter("sex");
			StudVo s = new StudVo();
			s.setAge(Integer.parseInt(age));
			s.setCardid(cardno);
			s.setClassname(classname);
			s.setSex(sex);
			s.setStudid(Integer.parseInt(studid));
			s.setStudname(studname);
			base.update(s);
			List<StudVo> studList = base.studList();
			String data = JSON.toJSONString(studList);
			System.out.println(data);
			out.println(data);
		}
		out.flush();
		out.close();
	}

}
