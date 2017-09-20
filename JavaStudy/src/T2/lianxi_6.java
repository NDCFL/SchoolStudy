package T2;

import java.util.Scanner;
public class lianxi_6 
{
	public static void main(String[] args) 
	{
		/*6��
			�Ӽ���������2 �����ҳ�������
			�Ӽ���������3 �����ҳ�������
			�Ӽ���������3 ��������ǴӴ�С������4��
		*/

		int a,b,max,c,t=0;
		Scanner input = new Scanner(System.in);			
		System.out.println("������}����");
		a=input.nextInt();	
		b=input.nextInt();
		max=a>b?a:b;
		System.out.println(a+","+b+"}�����е����ֵΪ"+max);
		System.out.println("�����������");
		a=input.nextInt();	
		b=input.nextInt();
		c=input.nextInt();
		max=a>b?a:b;
		max=max>c?max:c;
		System.out.println(a+","+b+","+c+"������е����ֵΪ"+max);
		System.out.println("�����������");
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
		System.out.println("a,b,c��˳����:"+a+","+b+","+c);

		
		
	}
}

