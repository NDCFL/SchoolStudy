package Test;

public class Student {

	private String name;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	// 无参数
	public Student() {

	}

	public Student(String name) {

		this.name=name;
	}

	public Student(String name, int age) {
		this.name=name;
		this.age=age;
	}
	
	public static void main(String[] args) {

		Student stud = new Student("战三",23);
		System.out.println(stud.getName());
		System.out.println(stud.getAge());
	}
}
