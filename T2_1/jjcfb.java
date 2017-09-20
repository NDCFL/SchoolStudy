public class jjcfb 
{
	public static void main(String[] args) 
	{
		int i,j,sum=1;
		for(i=0;i<=9;i++)
		{
			sum=1;
			for(j=1;j<=i;j++)
			{
				sum=i*j;
				System.out.print(j+"*"+i+"="+sum+"  ");
				
			}	
			System.out.print("\n");
			
		} 
		
	}
}
