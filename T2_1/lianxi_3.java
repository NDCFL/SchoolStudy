import java.util.Scanner;
public class lianxi_3 
{
	public static void main(String[] args) 
	{
		/*
			дһ��for ��䣬��������Ϊn ��100~200������Ϊ2��Ȼ������while ���ʵ��ͬ����ѭ����

		*/
		int sum=0;
		for(int i=100;i<=200;i+=2)
		{
			sum+=i;	
				
		}
		System.out.println("for��䣺\n100~200��ż����Ϊ"+sum);
		sum=0;
		int i=100;
		while(i<=200)
		{
			sum+=i;
			i+=2;
		
		}
		System.out.println("while��䣺\n100~200��ż����Ϊ"+sum);
		sum=0;
		i=100;
		
		do{
			sum+=i;
			i+=2;
		
		}while(i<=200);
		System.out.println("do.....while��䣺\n100~200��ż����Ϊ"+sum);


		
		
	}
}

