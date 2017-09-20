package zuoye;
public class Student {
	String name;
	int age;
	String sex;
	String aihao;
	String addr;
	String minzu;
	String shengao;
	String tizhong;
	String tel;
	String QQ;
	String zhiye;
	String wenping;
	String shengri;
	String geyan;
	String xiangwang;
	String mengxiang;
	String xiangfa;
	public void display()
	{
		System.out.println("姓名:"+name);
		System.out.println("年龄:"+age);
		System.out.println("性别:"+sex);
		
	}
	public static void main(String[] args)
	{
		Student chenfeilong=new Student();
		System.out.println("\t\t\t\t陈飞龙的个人简历\t\t");
		System.out.println();
		chenfeilong.name="陈飞龙";
		chenfeilong.age=20;
		chenfeilong.sex="男";
		chenfeilong.aihao="唱歌";
		chenfeilong.addr="江西";
		chenfeilong.minzu="汉族";
		chenfeilong.shengao="173CM";
		chenfeilong.tizhong="50Kg";
		chenfeilong.tel="15679760329";
		chenfeilong.QQ="275300091";
		chenfeilong.zhiye="学生";
		chenfeilong.wenping="大学";
		chenfeilong.shengri="1997.09.23";
		chenfeilong.xiangfa="快乐";
		chenfeilong.geyan="努力奋斗就是成功的一半";
		chenfeilong.xiangwang="逆风飞翔的鸟儿才会活得更精彩";
		chenfeilong.mengxiang="成为一名顶级的软件开发工程师";
		System.out.println("\t\t姓名\t"+chenfeilong.name+"\t\t"+"年龄\t"+chenfeilong.age);
		System.out.println("\t\t_____________________________________________");
		System.out.println();
		System.out.println("\t\t性别\t"+chenfeilong.sex+"\t\t"+"爱好\t"+chenfeilong.aihao);
		System.out.println("\t\t_____________________________________________");		System.out.println();
		System.out.println("\t\t地址\t"+chenfeilong.addr+"\t\t"+"民族\t"+chenfeilong.minzu);
		System.out.println("\t\t_____________________________________________");
		System.out.println("\t\t身高\t"+chenfeilong.shengao+"\t\t"+"体重\t"+chenfeilong.tizhong);
		System.out.println("\t\t_____________________________________________");
		System.out.println("\t\t电话\t"+chenfeilong.tel+"\t"+"QQ\t"+chenfeilong.QQ);
		System.out.println("\t\t_____________________________________________");
		System.out.println("\t\t职业\t"+chenfeilong.zhiye+"\t\t"+"文凭\t"+chenfeilong.wenping);
		System.out.println("\t\t_____________________________________________");
		System.out.println("\t\t生日\t"+chenfeilong.shengri+"\t"+"想法\t"+chenfeilong.xiangfa);
		System.out.println("\t\t_____________________________________________");;
		System.out.println("\t\t格言\t"+chenfeilong.geyan);
		System.out.println("\t\t_____________________________________________");
		System.out.println("\t\t向往\t"+chenfeilong.xiangwang);
		System.out.println("\t\t_____________________________________________");
		System.out.println("\t\t梦想\t"+chenfeilong.mengxiang);
		System.out.println("\t\t_____________________________________________");
	}
}
