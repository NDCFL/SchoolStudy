package Listener;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ApplicationListener implements ServletContextListener,ServletContextAttributeListener{

	//销毁application对象
	public void contextDestroyed(ServletContextEvent arg0) {
		WriteLogin("正在销毁一个Application对象");
	}
	//初始化application对象
	public void contextInitialized(ServletContextEvent arg0) {
		WriteLogin("正在初始化Application对象");
	}
	//添加一个application对象
	public void attributeAdded(ServletContextAttributeEvent arg0) {
		WriteLogin(arg0.getName()+"正在添加一个Application对象,值为："+arg0.getValue());
	}
	//删除一个application对象
	public void attributeRemoved(ServletContextAttributeEvent arg0) {
		WriteLogin(arg0.getName()+"正在删除一个Application对象,值为："+arg0.getValue());		
	}
	//修改一个application对象的值
	public void attributeReplaced(ServletContextAttributeEvent arg0) {
		WriteLogin(arg0.getName()+"正在修改一个Application对象,值为："+arg0.getValue());
	}
	@SuppressWarnings("deprecation")
	public void WriteLogin(String record){
		try {
			PrintWriter out = new PrintWriter(new FileOutputStream("f:\\login.log",true));
			out.println(new Date().toLocaleString()+"-----"+record);
			out.close();
		} catch (FileNotFoundException e) {
			System.out.println("书写日志文件出错！");
		}
		
	}

}
