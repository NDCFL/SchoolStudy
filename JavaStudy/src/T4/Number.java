package T4;
import java.util.Scanner;
public class Number {
/**
	 * 【练习题】04.构造方法 
	编写Java程序，模拟简单的计算器。 
	定义名为Number的类，其中有两个整型数据成员n1和n2，应声明为私有。
	编写构造方法，赋予n1和n2初始值，再为该类定义
	加（addition）、减（subtration）、乘（multiplication）、除（division）
	等公有成员方法，分别对两个成员变量执行加、减、乘、除的运算。 
	在main方法中创建Number类的对象，调用各个方法，并显示计算结果。  
 * */
	private int n1,n2;
	public Number(){
		Scanner in = new Scanner(System.in);
		System.out.println("请输入两个整数");
		n1=in.nextInt();
		n2=in.nextInt();
	}
	public int addition(){
		return n1+n2;
	}
	public int subtration(){
		return n1-n2;
	}
	public int multiplication(){
		return n1*n2;
	}
	public int division(){
		return n1/n2;
	}
	public static void main(String[] agrs){
		try {
			Number no1=new Number();
			int A=no1.addition();
			int B=no1.subtration();
			int C=no1.multiplication();
			int D=no1.division();
			System.out.println("n1"+"="+no1.n1+"\t"+"n2"+"="+no1.n2);
			System.out.println(no1.n1+"+"+no1.n2+"="+A);
			System.out.println(no1.n1+"-"+no1.n2+"="+B);
			System.out.println(no1.n1+"*"+no1.n2+"="+C);
			System.out.println(no1.n1+"/"+no1.n2+"="+D);
		} catch (Exception e) {
			System.out.println("你输入的有误");
		}
	}
	
	
	
}
