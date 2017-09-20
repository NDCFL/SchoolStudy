public class sushu 
{
	public static void main(String[] args) 
	{
		int i,j;
		int flag=0,n=0;
		System.out.println("1到100之内的素数如下");
		//外循环，检测所有的数
		
		for(i=101;i<=200;i++)
		{
			flag=0;
			//内循环测试i是不是素数
			for(j=2;j<i;j++)
			{
				if(i%j==0)
				{
					flag=1;
					break;	
				}
			}
			//是素数
			if(flag==0)
			{
				System.out.println("素数有"+i);
				n++;
			}
		}
		System.out.println("素数个数"+n);
	}
}
