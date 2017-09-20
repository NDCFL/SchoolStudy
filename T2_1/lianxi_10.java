import java.util.Scanner;
public class lianxi_10 
{
	public static void main(String[] args) 
	{
		/*
			10、分别用for，while，do…while 语句编写程序,实现求前n 个自然数之和。
		*/

		int num=0,sum=0;
		Scanner input = new Scanner(System.in);			
		System.out.println("请输入你所要想加的自然数的最大值");
		num=input.nextInt();	
		System.out.println("1~100的素数如下：");
		sum=num*(1+num)/2;
		System.out.print("1加到"+num+"的和为"+sum);
	}
}

