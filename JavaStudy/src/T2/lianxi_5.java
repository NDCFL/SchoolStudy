package T2;

import java.util.Scanner;
public class lianxi_5 
{
	public static void main(String[] args) 
	{
		//5���Ӽ���������}���������û��ش����ǵĺͣ�����̺�ȡ��������ͳ�Ƴ���ȷ�𰸵ĸ���
		int a,b,count=0,sum;
		Scanner input = new Scanner(System.in);			
		System.out.println("������}����");
		a=input.nextInt();	
		b=input.nextInt();
		
		System.out.println("������}����ĺ�");
		sum=input.nextInt();
		if(sum==(a+b))
		{
			count++;				
		}
		System.out.println("������}����Ĳ�");
		sum=input.nextInt();
		if(sum==(a-b))
		{
			count++;
			
		}
		System.out.println("������}����Ļ�");
		sum=input.nextInt();
		if(sum==(a*b))
		{
			count++;
			
		}
		System.out.println("������}�������");
		sum=input.nextInt();
		if(sum==(a/b))
		{
			count++;
			
		}
		System.out.println("������}�����ģ");
		sum=input.nextInt();
		if(sum==(a%b))
		{
			count++;
			
		}
		System.out.println("�������"+count+"��");
		int t;
		t=count;
		if(t==5)
		{
			System.out.println("ȫ��ร������");	
			
		}
		if(t<5)
		{
			System.out.println("�д�ร�û��ϵ���մ����ɣ�");
			System.out.println("a��b�ĺͣ�"+a+"+"+b+"="+(a+b));
			System.out.println("a��b�Ĳ"+a+"-"+b+"="+(a-b));
			System.out.println("a��b�Ļ�"+a+"*"+b+"="+(a*b));
			System.out.println("a��b���̣�"+a+"/"+b+"="+(a/b));
			System.out.println("a��b��ȡģ��"+a+"%"+b+"="+(a%b));		
		}
	}
}

