import java.util.Scanner;
public class lianxi_10 
{
	public static void main(String[] args) 
	{
		/*
			10���ֱ���for��while��do��while ����д����,ʵ����ǰn ����Ȼ��֮�͡�
		*/

		int num=0,sum=0;
		Scanner input = new Scanner(System.in);			
		System.out.println("����������Ҫ��ӵ���Ȼ�������ֵ");
		num=input.nextInt();	
		System.out.println("1~100���������£�");
		sum=num*(1+num)/2;
		System.out.print("1�ӵ�"+num+"�ĺ�Ϊ"+sum);
	}
}

