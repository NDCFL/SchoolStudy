import java.util.Scanner;
public class lianxi_7 
{
	public static void main(String[] args) 
	{
		/*7、从键盘输入三角形的三边长，
		（1）判断这三边是否能够构成三角形；
		（2）如果是等腰三角形，请说明是等腰三角形；
		（3）如果是等边三角形，请说明是等边三角形；
		*/

		int a,b,c,t=0;
		Scanner input = new Scanner(System.in);			
		System.out.println("请分别输入三角形的三边按回车键隔开");
		a=input.nextInt();	
		b=input.nextInt();
		c=input.nextInt();
		if(b<c){
			t=b;
			b=c;
			c=t;
		}
		if(a<c){
			t=a;
			a=c;
			c=t;
		}
		if(b>a){
			t=b;
			b=a;
			a=t;
		}
		if((b+c)>a)//a最大，b其次c最小
		{
			if(a==b && b==c)
			{
				System.out.println("这三个数可以构成三角形");
				System.out.println("该三角形是等边三角形");		
			}
			else if(a==b || a==c || b==c)
			{
				System.out.println("这三个数可以构成三角形");
				System.out.println("该三角形是等腰三角形");	
			
			}else
			{
				System.out.println("这三个数可以构成三角形");
				System.out.println("不是特殊三角形三角形");
			
			}
								
		}
		else
		{			
			System.out.println("这三个数不可以构成三角形");		
		}		
	}
}

