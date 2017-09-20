package T2;

import java.util.Scanner;
public class lianxi_2 
{
	public static void main(String[] args) 
	{
		int a=0;
		Scanner input = new Scanner(System.in);			
		System.out.println("请输入数字");
		a=input.nextInt();	
		if(a>=60)
		{
			System.out.println("a大于等于60");
				
		}else{
			System.out.println("a<60");
		}
	}
}

