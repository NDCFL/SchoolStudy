package T10;

import java.util.Scanner;

public class Max {
	int a,b;
	public Max(int a,int b) {
		this.a=a;
		this.b=b;
	}
	public void play(){
		System.out.println("a="+a+"\t"+"b="+b);
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("请输入两个数");
		int A=in.nextInt();
		int B=in.nextInt();
		Max max = new Max(A,B);
		max.play();
	}
}
