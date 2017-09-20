package T4;

public class StaticPerson {
	public static void main(String [] agrs){
		System.out.println("Person count="+Person.count);
		Person p1=new Person();
		p1.display();
		System.out.println("----------------------------------");
		Person p2=new Person();
		p2.display();
		System.out.println("----------------------------------");
		Person p3=new Person("Java",15);
		p3.display();
		System.out.println("----------------------------------");
		Person p4=new Person("java",+16);
		p4.display();
		System.out.println("----------------------------------");
		System.out.println("Person count="+Person.count);
	}
}
