import java.util.Scanner;
public class lianxi_9 
{
	public static void main(String[] args) 
	{
		/*
			ʹ��for ѭ��������1~100 ֮���������
		*/

		int num=0,count=0;
		//Scanner input = new Scanner(System.in);			
		//System.out.println("��ֱ����������ε����߰��س�������");
		//a=input.nextInt();	
		System.out.println("1~100���������£�");
		for(int i=2;i<100;i++)
		{
			num=0;
			for(int j=2;j<i;j++)
			{
				if(i%j==0)
				{
					num=1;		
				}			
			}
			if(num==0)
			{
				System.out.print(i+"\t");
				count++;			
			}
			if(count%5==0)
			{
				System.out.println();	
			
			}
		}
		
		System.out.print("1~100������һ����"+count+"��");
	}
}

