package T4;
import java.util.Scanner;
public class A {
/**
 * 
	猜数字游戏：一个类A有一个成员变量v，有一个初值100。
	定义一个类，对A类的成员变量v进行猜。如果大了则提示大了，小了则提示小了。
	等于则提示猜测成功。 

 * */
	int v=100;
	public class Caiche{
		public void display(){
			int a;
			do{
				Scanner in= new Scanner(System.in);
				System.out.println("请输入一个数");
				a=in.nextInt();
				if(a<v){
					System.out.println("小了");
				}else if(a>v){
					System.out.println("大了");
				}else{
					System.out.println("猜对了");
					System.out.println("其实v的值为"+v);
				}
			}while(a!=100);
			
		}
	}
	public static void main(String [] agrs){
		A t1=new A();
		A.Caiche t2=t1.new Caiche();
		t2.display();
	}
}
