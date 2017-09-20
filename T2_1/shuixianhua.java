public class shuixianhua  
{
	public static void main(String[] args) 
	{
		int a,b,c,p=100,count=0;
		for(p=100;p<1000;p++)
		{
			a=p/100%100;
			b=p/10%10;
			c=p/1%10;
		
			if(p==(a*a*a+b*b*b+c*c*c))
			{
				System.out.print(p+"\t");
				count++;
			}
 	
		}
		System.out.println();
		System.out.println("100到1000之间的水仙花数有"+count+"个");
	}
}
