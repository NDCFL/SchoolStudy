package T4;

public class Person {
	static int count;
	String name;
	int age;
	public Person(){
		this.count=this.count+1;
		System.out.println("通过该类申明的第"+count+"个对象");
	}
	public Person(String name,int age){
		this.age=age;
		this.name=name;
		this.count=this.count+1;
		System.out.println("通过该类申明的第"+count+"个对象");
		
	}
	public void display(){
		System.out.println("name:"+name+"\t"+"age:"+age);
	}
}
