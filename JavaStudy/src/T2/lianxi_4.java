package T2;

import java.util.Scanner;
public class lianxi_4 
{
	public static void main(String[] args) 
	{
		/*
			4����дһ�γ�������ʱ���û����ʡ��㿼�˶��ٷ֣���0~100����������������ж���ȼ�����ʾ��4���ж��>����£�
			�ȼ�={�ţ�90~100 �֣���|��80~89 �֣����У�60~69 �֣����0~59 �֣���}

		*/
		int num=0;
		Scanner input = new Scanner(System.in);			
		System.out.println("���������");
		num=input.nextInt();	
		if(num>=90)
		{
			System.out.println("��ĳɼ�����"+num);
				
		}else if(num>=80 && num<90)
		{
			System.out.println("��ĳɼ���|"+num);
				
		}else if(num>=70 && num<80)
		{
			System.out.println("��ĳɼ�|��"+num);
				
		}else if(num>=60 && num<70)
		{
			System.out.println("��ĳɼ�����"+num);
				
		}else{
			
			System.out.println(num+"������ร�");
		}
		
		
	}
}

