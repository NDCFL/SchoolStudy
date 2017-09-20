public class wanshu  
{
	public static void main(String[] args) 
	{
		/*
    	完数：所有的因子相加等于这个数本身
    	6=1+2+3
    */
		int i,j,a,b,c;
		System.out.println("1000以内的完数如下：\n");
		for(i=6;i<=1000;i++)
		{
			a=0;
			//求i对应的所有的因子
			for(j=2;j<=i;j++)
			{
				if(i%j==0)
				{
					
					a+=i/j;
				}
			}
			if(i==a)
			{
				//该循环语句的作用就是打印结果
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
