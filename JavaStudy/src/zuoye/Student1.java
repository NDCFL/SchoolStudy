package zuoye;

public class Student1 {
/*
 * 三
（1）定义一个student类,其中包括用户名、
	姓名、性别、出生年月等属行
	以及init()——初始化各属性、display()——显示各属性、
	modify()——修改姓名等方法。实现并测试这个类。
 * 
 * */
	String admit;
	String name;
	String sex;
	String birthday;
	public void init(){//初始化各个属性
		this.admit ="学生1";
		this.name ="张三";
		this.sex ="男";
		this.birthday="1990年6月5号";
		
	}
	public void display(){
		System.out.println("原始数据如下：");
		System.out.println("用户名："+this.admit);
		System.out.println("姓名："+this.name);
		System.out.println("性别："+this.sex);
		System.out.println("生日："+this.birthday);
		
	}
	public void modify(String admit,String name,String sex,String birthday){
		this.admit =admit;
		this.name =name;
		this.sex =sex;
		this.birthday=birthday;
		System.out.println("修改后的信息如下：");
		System.out.println("用户名："+this.admit);
		System.out.println("姓名："+this.name);
		System.out.println("性别："+this.sex);
		System.out.println("生日："+this.birthday);
	}
	public static void main(String[] args){
		Student1 xuesheng=new Student1();
		xuesheng.init();
		xuesheng.display();
		xuesheng.modify("学生二","李四","女","2016年2月2号");
		
	}
}
