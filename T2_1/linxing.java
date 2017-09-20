public class linxing 
{
	public static void main(String[] args) 
	{
		int hang,zhongjian,kongge,xinhao,i,j;
  System.out.print("请输入一个行数");
  zhongjian=hang/2+1;
  for(i=1;i<=zhongjian;i++)
  {
  		xinhao=i*2-1;
  		kongge=(hang-xinhao)/2;
  		for(j=0;j<kongge;j++)
  		{
  				System.out.print(" ");
  		}
  		for(j=1;j<=xinhao;j++)
  		{
  				System.out.print("*");
  				
  		}
  		System.out.print("\n");
  	}
  	for(i=zhongjian-1;i>0;i--){
  		xinhao=i*2-1;
  		kongge=(hang-xinhao)/2;
  		for(j=0;j<kongge;j++){
  				System.out.print(" ");
  		}for(j=1;j<=xinhao;j++){
  				System.out.print("*");
  				
  		}
  		System.out.print("\n");
  		}

	}
	System.out.println(" ");
}
