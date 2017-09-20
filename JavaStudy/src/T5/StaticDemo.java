package T5;

import java.util.Scanner;

public class StaticDemo {
/**
 * 【练习题】14.Static关键字与普通变量的区别： 
	创建一个名称为StaticDemo的类，并声明一个静态变量和一个普通变量。
	对变量分别赋予10和5的初始值。在main()方法中输出变量值。  

 * */
	static int a;
	int b;
	public  StaticDemo(int b) {
		this.b=b;
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("请输入两个整数");
		a=input.nextInt();
		int b=input.nextInt();
		StaticDemo t1 = new StaticDemo(b);
		System.out.println("a="+a);
		System.out.println("b="+t1.b);
		System.out.println("交换后的数据如下表示：");
		a=a+b;
		b=a-b;
		a=a-b;
		System.out.println("a="+a);
		System.out.println("b="+b);
		
		
	}
}
