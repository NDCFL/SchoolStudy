import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.ht.bean.StudentVo;

public class JsonServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost1(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String str = "{\"message\":\"JSON格式数据\"}";
		System.out.println(str);
		out.println(str);
		out.flush();
		out.close();
	}

	public void doPost2(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String str = "{";
		// 传递集合数据
		str += "\"stud\":[";
		str += "{\"studid\":\"1001\",\"studname\":\"张三\",\"age\":\"20\"},";
		str += "{\"studid\":\"1002\",\"studname\":\"李四\",\"age\":\"22\"},";
		str += "{\"studid\":\"1003\",\"studname\":\"小丽\",\"age\":\"23\"}";
		str += "]";
		str += "}";
		System.out.println(str);
		out.println(str);
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		StudentVo s1 = new StudentVo(1,"1001","张三","宏图201601班");
		StudentVo s2 = new StudentVo(2,"1002","小丽","宏图201601班");
		StudentVo s3 = new StudentVo(3,"1003","李小龙","宏图201601班");
		StudentVo s4 = new StudentVo(4,"1004","张三疯","宏图201601班");
		
		List<StudentVo> studList = new ArrayList<StudentVo>();
		studList.add(s1);
		studList.add(s2);
		studList.add(s3);
		studList.add(s4);
		//调用第三方的jar包，把对象转换为json格式的字符串
		String data = JSON.toJSONString(studList);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		System.out.println(data);
		out.println(data);
		out.flush();
		out.close();
	}
}
