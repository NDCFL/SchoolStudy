import java.util.Scanner;
public class lianxi_2 
{
	public static void main(String[] args) 
	{
		//2、编写一个程序，检查变量的值是否大于60。如果是，则打印文本“大于60！”
		int a=0;
		Scanner input = new Scanner(System.in);			
		System.out.println("请输入一个数");
		a=input.nextInt();	
		if(a>=60)
		{
			System.out.println("大于60！");
				
		}else{
			System.out.println("小于60！");
		}
	}
}

