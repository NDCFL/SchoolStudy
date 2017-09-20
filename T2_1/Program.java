
import java.util.Scanner; 

public class Program
	{ 

    public static void main(String[] args){ 

        Scanner input = new Scanner(System.in); //新建一个输入实例 

        System.out.println("请输入一个三位数字："); 

        int myNumber = input.nextInt();    //调用nextInt方法从键盘接收一个整数 

        int a=myNumber/100%10;    

        int b=myNumber/10%10;  

        int c=myNumber%10; 
		
       System.out.println(a); 
	   System.out.println(b); 
	   System.out.println(c); 

    } 

} 