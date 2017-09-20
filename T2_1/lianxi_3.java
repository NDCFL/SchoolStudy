import java.util.Scanner;
public class lianxi_3 
{
	public static void main(String[] args) 
	{
		/*
			写一条for 语句，计数条件为n 从100~200，步长为2；然后再用while 语句实现同样的循环。

		*/
		int sum=0;
		for(int i=100;i<=200;i+=2)
		{
			sum+=i;	
				
		}
		System.out.println("for语句：\n100~200的偶数和为"+sum);
		sum=0;
		int i=100;
		while(i<=200)
		{
			sum+=i;
			i+=2;
		
		}
		System.out.println("while语句：\n100~200的偶数和为"+sum);
		sum=0;
		i=100;
		
		do{
			sum+=i;
			i+=2;
		
		}while(i<=200);
		System.out.println("do.....while语句：\n100~200的偶数和为"+sum);


		
		
	}
}

