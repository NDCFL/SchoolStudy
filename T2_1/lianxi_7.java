import java.util.Scanner;
public class lianxi_7 
{
	public static void main(String[] args) 
	{
		/*7���Ӽ������������ε����߳���
		��1���ж��������Ƿ��ܹ����������Σ�
		��2������ǵ��������Σ���˵���ǵ��������Σ�
		��3������ǵȱ������Σ���˵���ǵȱ������Σ�
		*/

		int a,b,c,t=0;
		Scanner input = new Scanner(System.in);			
		System.out.println("��ֱ����������ε����߰��س�������");
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
		if((b+c)>a)//a���b���c��С
		{
			if(a==b && b==c)
			{
				System.out.println("�����������Թ���������");
				System.out.println("���������ǵȱ�������");		
			}
			else if(a==b || a==c || b==c)
			{
				System.out.println("�����������Թ���������");
				System.out.println("���������ǵ���������");	
			
			}else
			{
				System.out.println("�����������Թ���������");
				System.out.println("��������������������");
			
			}
								
		}
		else
		{			
			System.out.println("�������������Թ���������");		
		}		
	}
}

