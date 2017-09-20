package T4;

public class Wd_1_Polygon {
	//3.创建Polygon类，定义方法，并实现方法重载
	String name;
	String sex;
	int age;
	int cardid;
	//初始化
	public Wd_1_Polygon(){
		name="";
		sex="";
		age=0;
		cardid=0;
		
	}
	//更改条件重载一个
	public Wd_1_Polygon(String name){
		this.name=name;
	}
	//更改条件重载二个
	public Wd_1_Polygon(String name,String sex){
		this.name=name;
		this.sex=sex;
	}
	//更改条件重载三个
	public Wd_1_Polygon(String name,String sex,int age){
		this.name=name;
		this.sex=sex;
		this.age=age;
	}
	//更改条件重载四个
	public Wd_1_Polygon(String name,String sex,int age,int cardid){
		this.name=name;
		this.sex=sex;
		this.age=age;
		this.cardid=cardid;
	}
	//显示重载效果
	public void display(){
		System.out.println("name:"+name+"\t"+"sex:"+sex+"\t"+"age:"+age+"\t"+"cardid:"+cardid+"\t");
	}
	public static void main(String [] agrs){
		Wd_1_Polygon wd_1_Polygon = new Wd_1_Polygon();
		System.out.println("默认效果：");
		wd_1_Polygon.display();
		System.out.println("------------------------------------------------");
		System.out.println("更改条件重载一个的效果：");
		Wd_1_Polygon wd_2_Polygon = new Wd_1_Polygon("长留");
		wd_2_Polygon.display();
		System.out.println("------------------------------------------------");
		System.out.println("更改条件重载二个的效果：");
		Wd_1_Polygon wd_3_Polygon = new Wd_1_Polygon("青云","女");
		wd_3_Polygon.display();
		System.out.println("------------------------------------------------");
		System.out.println("更改条件重载三个的效果：");
		Wd_1_Polygon wd_4_Polygon = new Wd_1_Polygon("青釭剑","男",17);
		wd_4_Polygon.display();
		System.out.println("------------------------------------------------");
		System.out.println("更改条件重载三个的效果：");
		Wd_1_Polygon wd_5_Polygon = new Wd_1_Polygon("青釭剑","男",17,55);
		wd_5_Polygon.display();
		System.out.println("------------------------------------------------");
		
		
	}
}
