public class sushu 
{
	public static void main(String[] args) 
	{
		int i,j;
		int flag=0,n=0;
		System.out.println("1��100֮�ڵ���������");
		//��ѭ����������е���
		
		for(i=101;i<=200;i++)
		{
			flag=0;
			//��ѭ������i�ǲ�������
			for(j=2;j<i;j++)
			{
				if(i%j==0)
				{
					flag=1;
					break;	
				}
			}
			//������
			if(flag==0)
			{
				System.out.println("������"+i);
				n++;
			}
		}
		System.out.println("��������"+n);
	}
}
