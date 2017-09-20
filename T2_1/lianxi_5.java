import java.util.Scanner;
public class lianxi_5 
{
	public static void main(String[] args) 
	{
		//5、从键盘上输入两个整数，由用户回答它们的和，差，积，商和取余运算结果，并统计出正确答案的个数。
		int a,b,count=0,sum;
		Scanner input = new Scanner(System.in);			
		System.out.println("请输入两个数");
		a=input.nextInt();	
		b=input.nextInt();
		
		System.out.println("请输入两个数的和");
		sum=input.nextInt();
		if(sum==(a+b))
		{
			count++;				
		}
		System.out.println("请输入两个数的差");
		sum=input.nextInt();
		if(sum==(a-b))
		{
			count++;
			
		}
		System.out.println("请输入两个数的积");
		sum=input.nextInt();
		if(sum==(a*b))
		{
			count++;
			
		}
		System.out.println("请输入两个数的商");
		sum=input.nextInt();
		if(sum==(a/b))
		{
			count++;
			
		}
		System.out.println("请输入两个数的模");
		sum=input.nextInt();
		if(sum==(a%b))
		{
			count++;
			
		}
		System.out.println("你做对了"+count+"个");
		int t;
		t=count;
		if(t==5)
		{
			System.out.println("全对喔！你好厉害");	
			
		}
		if(t<5)
		{
			System.out.println("有错喔！没关系对照答案算过吧！");
			System.out.println("a跟b的和："+a+"+"+b+"="+(a+b));
			System.out.println("a跟b的差："+a+"-"+b+"="+(a-b));
			System.out.println("a跟b的积："+a+"*"+b+"="+(a*b));
			System.out.println("a跟b的商："+a+"/"+b+"="+(a/b));
			System.out.println("a跟b的取模："+a+"%"+b+"="+(a%b));		
		}
	}
}

