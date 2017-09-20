package T5;

import java.util.Scanner;

public class Exsetption {
	/**
	 * 自己动手编写一个数组越界的异常。如果抛出异常，就输出index out of bound! 
	 * 在catch语句里实现输出异常信息
		编写代码，再main()方法中调用类CCircle中的方法，计算圆的面积。
		并且自己定义一 个异常类，如果半径为负值，抛出自己定义的异常。
		（在类CCircle中判断并抛出异常）
	 * */
	public double CCircle(double r) {
		return r*Math.PI;
	}
	public static void main(String[] args) {
		int a[]={1,2,3,4,5};
		Exsetption exsetption = new Exsetption();
		Scanner input = new Scanner(System.in);
		System.out.println("请输入半径");
		double r=input.nextDouble();
		try { 
			for (int i = 0; i <=a.length; i++) {
				System.out.println(a[i]);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			//e.printStackTrace();
			//System.out.println(e.getMessage());
			if (r<0) {
				System.out.println("输入错误");
			}else {
				System.out.println(exsetption.CCircle(r));
			}
			System.out.println("数组越界");
			
		}finally{
			System.out.println("End............");
		}
	}
}
