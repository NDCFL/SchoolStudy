import java.util.Scanner; 
public class gongyinshu
	{ 

    public static void main(String[] args){ 

		
        Scanner input = new Scanner(System.in); //�½�һ������ʵ�� 

        System.out.println("���������������");
		int x = input.nextInt();//����nextInt�����Ӽ��̽���һ������ 
		int y = input.nextInt();//����nextInt�����Ӽ��̽���һ������ 
		//��������������m��n���������Լ������С����
		int m,i,a=1;//aΪ��Լ����mΪ��󹫱���
		
		if(x<y){
			m=x;
			x=y;
			y=m;  	
		}
		for(i=1;i<=y;i++){

			if(x%i==0&&y%i==0)

				a=i; 	
		}
		System.out.println("���������������:"+a);
			m=(x*y)/a;
		System.out.println("��������󹫱�����:"+m);
    } 

} 