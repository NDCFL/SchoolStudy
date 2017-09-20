import java.util.Scanner;
public class lianxi_1 
{
	public static void main(String[] args) 
	{
		//1、编写一个程序，检查一个字符变量的值是否为T 或t。
		String str;
		Scanner input = new Scanner(System.in);			
		System.out.println("请输入一个字符");
		str=input.next();	
		if(str.equals("T"))
		{
			System.out.println("你输入的是T");
				
		}else{
			System.out.println("你输入的是t");
		}
	}
}

