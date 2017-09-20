package T1;

import java.util.Scanner;


public class StudentLink {

	StudentNode studentNode;
	public StudentLink() {
		studentNode = new StudentNode();
		studentNode.next=null;
	}
	public void addstudent(String studentname,int studentid,int age,int classname){
		StudentNode s = studentNode;
		StudentBean bean = new StudentBean();
		while(s.next!=null){
			s=s.next;
		}
		bean.setStudentid(studentid);
		bean.setStudentname(studentname);
		bean.setAge(age);
		bean.setClassname(classname);
		StudentNode sn = new StudentNode(bean);
		s.next=sn;
	}
	public void display(){
		StudentNode s = studentNode;
		StudentBean bean = new StudentBean();
		while(s.next!=null){
			bean=s.next.studentBean;
			System.out.println("学号："+bean.getStudentid()+"\t姓名："+bean.getStudentname()+"\t年龄："+bean.getAge()+"\t\t班级："+bean.getClassname()+"班");
			s=s.next;
		}
	}
//	5.3.可以按学号，名字查找学生
	public void findstudent(){
		int studentid ;
		String studentname;
		while (true){
			System.out.println("请选择查找方式：输入1按学号查找，输入2按姓名查找,输入3退出程序");
			int n;
			Scanner in = new Scanner(System.in);
			n=in.nextInt();
			if(n==1){
				System.out.println("请输入学号");
				studentid=in.nextInt();
				StudentNode sn = studentNode;
				StudentBean bean=new StudentBean();
				while (sn.next!=null) {
					if(sn.next.studentBean.getStudentid()==studentid){
						bean=sn.next.studentBean;
						System.out.println("学号："+bean.getStudentid()+"\t姓名："+bean.getStudentname()+"\t年龄："+bean.getAge()+"\t\t班级："+bean.getClassname()+"班");
						break;
					}else {
						sn=sn.next;
					}
				}
			}else if(n==2){
				System.out.println("请输入姓名");
				studentname=in.next();
				StudentNode sn = studentNode;
				StudentBean bean=new StudentBean();
				while (sn.next!=null) {
					if(sn.next.studentBean.getStudentname().equals(studentname)){
						bean=sn.next.studentBean;
						System.out.println("学号："+bean.getStudentid()+"\t姓名："+bean.getStudentname()+"\t年龄："+bean.getAge()+"\t\t班级："+bean.getClassname()+"班");
						break;
					}else {
						sn=sn.next;
					}
				}
			}else if(n==3){
				System.out.println("程序已完成！");
				return;
			}
		}
	}
//	5.4.查出节点中年龄最小的学生
	public void minstudent(){
		StudentNode sn = studentNode;
		int minage=100;
		StudentBean bean = new StudentBean();
		while (sn.next!=null) {
			bean = sn.next.studentBean;
			if(bean.getAge()<minage){
				minage=bean.getAge();
			}
			sn=sn.next;
		}
		StudentNode s = studentNode;
		while (s.next!=null) {
			if(s.next.studentBean.getAge()==minage){
				System.out.println("学号："+s.next.studentBean.getStudentid()+"\t姓名："+s.next.studentBean.getStudentname()+"\t年龄："+s.next.studentBean.getAge()+"\t\t班级："+s.next.studentBean.getClassname()+"班");
			}
			s=s.next;
		}
	}
//	5.5.可以按学号，名字删除节点
	public void delnose(String name){
		StudentNode s = studentNode;
		while (s.next!=null) {
			if(s.next.studentBean.getStudentname().equals(name)){
				s.next=s.next.next;
				break;
			}else {
				s=s.next;
			}
		}
	}
//	5.7.给定两个学生的学号，将他们的位置互换一下
	public void huannode(int oldnode,int newnode){
		StudentNode s = studentNode;
		StudentNode tempold = null  ;
		StudentNode tempnew = null ;
		StudentBean temp = null;
		while (s.next!=null) {
			if(s.next.studentBean.getStudentid()==oldnode){
				tempold = s.next;
			}else if(s.next.studentBean.getStudentid()==newnode){
				tempnew = s.next;
			}
			s=s.next;
		}
		temp=tempnew.studentBean;
		tempnew.studentBean=tempold.studentBean;
		tempold.studentBean=temp;
	}
	//插入学生信息
	public void innode(String oldname,String studentname,int studentid,int age,int classname){
		StudentNode student = studentNode;
		StudentBean bean = new StudentBean();
		while(student.next!=null){
			if(student.next.studentBean.getStudentname().equals(oldname)){
				StudentNode sn = student.next;
				bean.setStudentid(studentid);
				bean.setStudentname(studentname);
				bean.setAge(age);
				bean.setClassname(classname);
				StudentNode s = new StudentNode(bean);
				s.next=sn.next;
				sn.next=s;
				break;
			}else {
				student=student.next;
			}
		}
	}
	public static void main(String[] args) {
		StudentLink sl = new StudentLink();
		sl.addstudent("小明", 1601,21, 1);
		sl.addstudent("小红", 1602,20, 2);
		sl.addstudent("小丽", 1603,12, 3);
		sl.addstudent("李四", 1604,11, 4);
		sl.display();
		System.out.println("------年龄最小的学生信息如下：------");
		sl.findstudent(); 
//		sl.minstudent();
//		System.out.println("-------删除李四的学生信息------");
//		sl.delnose("李四");
//		sl.display();
		System.out.println("-------数据的交换后------");
//		sl.huannode(1604, 1601);
//		sl.huannode(1602, 1601);
//		sl.display();
		sl.huannode(1603, 1601);
		sl.display();
//		System.out.println("插入后的数据如下：");
//		sl.innode("小明", "小龙", 1605, 10, 5);
//		sl.innode("小龙", "小龙1", 1606, 19, 6);
//		sl.display();
	}
}
