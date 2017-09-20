import java.util.Scanner;
public class lianxi_12  
{
	public static void main(String[] args) 
	{
		int a,b,c,d,t=0;
		Scanner input = new Scanner(System.in);	
		System.out.println("请输入四个数");
		a=input.nextInt();
		b=input.nextInt();
		c=input.nextInt();
		d=input.nextInt();
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
		if(d>a)
		{
			System.out.println("最大值为"+d);	
		
		}else
		{
			System.out.println("最大值为"+a);
		
		}
		System.out.println("最小值为"+d);
	}
}
