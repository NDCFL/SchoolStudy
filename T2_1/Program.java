
import java.util.Scanner; 

public class Program
	{ 

    public static void main(String[] args){ 

        Scanner input = new Scanner(System.in); //�½�һ������ʵ�� 

        System.out.println("������һ����λ���֣�"); 

        int myNumber = input.nextInt();    //����nextInt�����Ӽ��̽���һ������ 

        int a=myNumber/100%10;    

        int b=myNumber/10%10;  

        int c=myNumber%10; 
		
       System.out.println(a); 
	   System.out.println(b); 
	   System.out.println(c); 

    } 

} 