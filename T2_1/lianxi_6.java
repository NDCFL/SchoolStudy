import java.util.Scanner;
public class lianxi_6 
{
	public static void main(String[] args) 
	{
		/*6、
			从键盘上输入2 个数，找出最大的数；
			从键盘上输入3 个数，找出最大的数；
			从键盘上输入3 个数，把他们从大到小排列起来；
		*/

		int a,b,max,c,t=0;
		Scanner input = new Scanner(System.in);			
		System.out.println("请输入两个数");
		a=input.nextInt();	
		b=input.nextInt();
		max=a>b?a:b;
		System.out.println(a+","+b+"两个数中的最大值为"+max);
		System.out.println("请输入三个数");
		a=input.nextInt();	
		b=input.nextInt();
		c=input.nextInt();
		max=a>b?a:b;
		max=max>c?max:c;
		System.out.println(a+","+b+","+c+"三个数中的最大值为"+max);
		System.out.println("请输入三个数");
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
		System.out.println("a,b,c的顺序是:"+a+","+b+","+c);

		
		
	}
}

