package T1;

public class StudentAgeLink {
	StudentNode studentNode;
	public StudentAgeLink() {
		studentNode = new StudentNode();
		studentNode.next=null;
		studentNode.prior=null;
	}
	public void addstudent(String studentname,int studentid,int age,int classname){
		StudentNode s = studentNode;
		StudentBean bean = new StudentBean();
		bean.setStudentid(studentid);
		bean.setStudentname(studentname);
		bean.setAge(age);
		bean.setClassname(classname);
		StudentNode sn = new StudentNode(bean);
		while(s.next!=null){
			if(s.next.studentBean.getAge()<=sn.studentBean.getAge()){
				s=s.next;
			}else{
				sn.next=s.next;
				s.next.prior=sn;
				s.next=sn;
				sn.prior=s;
				break;
			}
		}
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
		System.out.println("--------------------------------------------------------");
		while(s.prior!=null){
			bean=s.studentBean;
			System.out.println("学号："+bean.getStudentid()+"\t姓名："+bean.getStudentname()+"\t年龄："+bean.getAge()+"\t\t班级："+bean.getClassname()+"班");
			s=s.prior;
		}
	}
//	将存储学生的链表设计为有序的，每次往链表中加学生时，按年龄排序
	public static void main(String[] args) {
		StudentAgeLink sl = new StudentAgeLink();
		sl.addstudent("小明", 1601,21, 1);
		sl.addstudent("小红", 1602,20, 2);
		sl.addstudent("小丽", 1603,12, 3);
		sl.addstudent("李四", 1604,11, 4);
		sl.addstudent("张三", 1605,10, 5);
		sl.display();
	}
}
