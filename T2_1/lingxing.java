import java.util.Scanner; 
public class lingxing 
{
	public static void main(String[] args) 
	{
		  int zhongjian,kongge,xinhao,i,j;
		  Scanner input = new Scanner(System.in); //�½�һ������ʵ�� 
		  System.out.println("������������");
		  int hang = input.nextInt();
		  zhongjian=hang/2+1;
		  for(i=1;i<=zhongjian;i++)
		  {
				xinhao=i*2-1;
				kongge=(hang-xinhao)/2;
				for(j=0;j<kongge;j++)
				{
						System.out.printf(" ");
				}
				for(j=1;j<=xinhao;j++)
				{
						System.out.printf("*");
						
				}
				System.out.printf("\n");
			}
			for(i=zhongjian-1;i>0;i--){
				xinhao=i*2-1;
				kongge=(hang-xinhao)/2;
				for(j=0;j<kongge;j++){
						System.out.printf(" ");
				}for(j=1;j<=xinhao;j++){
						System.out.printf("*");
						
				}
				System.out.printf("\n");
				}
			
	}
}
