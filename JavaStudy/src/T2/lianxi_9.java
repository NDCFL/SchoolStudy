package T2;

import java.util.Scanner;
public class lianxi_9 
{
	public static void main(String[] args) 
	{
		/*
			使用for 循环语句求出1~100 之间的质数。
		*/

		int num=0,count=0;
		//Scanner input = new Scanner(System.in);			
		//System.out.println("请分别输入三角形的三边按回车键隔开");
		//a=input.nextInt();	
		System.out.println("1~100的素数如下：");
		for(int i=2;i<100;i++)
		{
			num=0;
			for(int j=2;j<i;j++)
			{
				if(i%j==0)
				{
					num=1;		
				}			
			}
			if(num==0)
			{
				System.out.print(i+"\t");
				count++;			
			}
			if(count%5==0)
			{
				System.out.println();	
			
			}
		}
		
		System.out.print("1~100的素数一共有"+count+"个");
	}
}

