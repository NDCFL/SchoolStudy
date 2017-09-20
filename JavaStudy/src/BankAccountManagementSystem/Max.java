package BankAccountManagementSystem;
import java.util.Scanner;
public class Max {
/**
 * 
 *
	创建一个类，为该类定义三个构造函数，分别执行下列操作：  
 1、传递两个整数值并找出其中较大的一个值   
 2、传递三个double值并求出其乘积   
 3、传递两个字符串值并检查其是否相同   
 4、在main方法中测试构造函数的调用  

 * */
	
	public Max(int a,int b){
		
		int max=a>b?a:b;
		System.out.println("a"+"="+a+"\t"+"b"+"="+b+";"+"\t"+"最大值max="+max);
	}
	public Max(double a,double b,double c){
		
		double sum=a*b*c;
		System.out.println("a"+"="+a+"\t"+"b"+"="+b+"\t"+"c"+"="+c+";"+"乘积sum="+sum);
	}
	public Max(String a,String b){
		
		if(a.equals(b)){
			System.out.println(a+"\t"+b+"\t"+a+"="+b);
			
		}else{
			System.out.println("两串字符不相等");
		}
	}
	public static void main(String[] agrs){
		int a,b;
		double A,B,C;
		String c,d;
		Scanner in = new Scanner(System.in);
		System.out.println("请输入两个整数");
		a=in.nextInt();
		b=in.nextInt();
		Max max=new Max(a,b);
		System.out.println("请输入三个整数");
		A=in.nextDouble();
		B=in.nextDouble();
		C=in.nextDouble();
		Max max1=new Max(A,B,C);
		System.out.println("请输入两串字符数");
		c=in.next();
		d=in.next();
		Max max2=new Max(c,d);
	}
}
