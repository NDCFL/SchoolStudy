package T12;

import java.io.Serializable;

public class Student implements Serializable{

	private int ID;
	private String name;
	private int age;
	private char sex;
	public Student() {
		
	}
	public Student(int ID,String name,int age,char sex) {
		this.ID = ID;
		this.name = name;
		this.age = age;
		this.sex = sex;
	}
	public int getID() {
		return ID;
	}
	public void setID(int id) {
		ID = id;
	}
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
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		
		return "学号："+this.ID+"\t姓名："+this.name+"\t\t性别："+this.sex+"\t\t年龄："+this.age;
	}
	
}
