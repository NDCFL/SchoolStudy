package Test;

import java.util.Scanner;


public class StrusStud {

	/*
	 * 1.实现链表的如下操作：
	1.创建一个学生类；
	2.创建节点类，把学生类当做节点的数据域
	3.创建链表类；
	4.实现新增节点功能；
	5.删除节点功能；
	6.遍历节点功能；
	7.创建测试类，测试链表的功能；
		 * */
	StrusNode headnode;
	StudentBean nodeBean;
	public StrusStud() {
		headnode = new StrusNode();
		headnode.next=null;
	} 
	public void addnode(String studentname,int studentid,int age,int classname){
		//获取头结点
		StrusNode node=headnode;
		//实例化学生类
		StudentBean studbean = new StudentBean();
		while(node.next!=null){
			node = node.next;
		}
		studbean.setStudentid(studentid);
		studbean.setStudentname(studentname);
		studbean.setAge(age);
		studbean.setClassname(classname);
		StrusNode sn = new StrusNode(studbean);
		node.next=sn;
		
	}
	//遍历的输出信息
	public void sysplay(){
		//获取头结点
		StrusNode node=headnode;
		StudentBean bean = new StudentBean();
		while(node.next!=null){
			bean=node.next.studentBean;
			System.out.println("学号："+bean.getStudentid()+"\t姓名："+bean.getStudentname()+"\t年龄："+bean.getAge()+"\t\t班级："+bean.getClassname()+"班");
			node=node.next;
		}
		
	}
//	(按学号来)删除节点
	public void delstudent(){
		StrusNode node = headnode;
		while(node.next!=null){
			while(true){
				System.out.println("请选择删除方式：输入1按学号删除，输入2按姓名删除,输入3退出程序");
				Scanner input = new Scanner(System.in);
				int n=0;
				n=input.nextInt();
				if(n==1){
					System.out.println("请输入学号");
					int studid=input.nextInt();
					if(node.next.studentBean.getStudentid()==studid){
						node.next=node.next.next;
						sysplay();
						break;
					}else{
						node=node.next;
					}
				}else if(n==2){
					System.out.println("请输入姓名");
					String studname=input.next();
					if(node.next.studentBean.getStudentname().equals(studname)){
						node.next=node.next.next;
						sysplay();
						break;
					}else{
						node=node.next;
					}
				}else if(n==3){
					System.out.println("程序已完成！");
					return;
				}
			}
		}
		
	}
	
}
