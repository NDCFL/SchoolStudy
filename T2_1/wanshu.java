public class wanshu  
{
	public static void main(String[] args) 
	{
		/*
    	���������е�������ӵ������������
    	6=1+2+3
    */
		int i,j,a,b,c;
		System.out.println("1000���ڵ��������£�\n");
		for(i=6;i<=1000;i++)
		{
			a=0;
			//��i��Ӧ�����е�����
			for(j=2;j<=i;j++)
			{
				if(i%j==0)
				{
					
					a+=i/j;
				}
			}
			if(i==a)
			{
				//��ѭ���������þ��Ǵ�ӡ���
				for(j=2;j<=i;j++)
				{
					if(i%j==0)
					{
						if(i==j){
							System.out.print("+"+i/j);	
						}else{
							System.out.print("+"+i/j);
						}
					}
				}
				System.out.println("="+i);
			}
		}
	}
}
