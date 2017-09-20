package zuoye;

public class User_3 {
/*
 * 二
	（1）设计一个User类，其中包括用户名、口令等属性
	以及构造方法（至少重载2 个）。
	获取和设置口令的方法，显示和修改用户名的方法等。
	编写应用程序测试User类。  
 * */
 	String kouling;
	String admit;
	String name;
	String sex;
	String birthday;
	static int count=0;
	public void yuanshi(){
		this.kouling="抢红包";
		this.admit ="学生1";
		this.name ="张三";
		this.sex ="男";
		this.birthday="1990年6月5号";
		System.out.println("原始数据如下：");
		System.out.println("用户名："+this.admit);
		System.out.println("口令："+this.kouling);
		System.out.println("姓名："+this.name);
		System.out.println("性别："+this.sex);
		System.out.println("生日："+this.birthday);
		count++;
	}
	public void yuanshi(String admit,String name,String sex,String birthday){
		this.admit =admit;
		this.name =name;
		this.sex =sex;
		this.birthday=birthday;
		System.out.println("更改后的数据如下：");
		System.out.println("口令："+this.kouling);
		System.out.println("用户名："+this.admit);
		System.out.println("姓名："+this.name);
		System.out.println("性别："+this.sex);
		System.out.println("生日："+this.birthday);
		count++;
	}
	
	
}
