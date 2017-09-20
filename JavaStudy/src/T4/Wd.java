package T4;
import java.util.Scanner;
public class Wd {
	//2.实现类的继承
	private int a;
	private int b;
	public Wd(){}
	public Wd(int a,int b){
		this.a=a;
		this.b=b;
	}
	public int getSum(){
		return a+b;
	}
	public int getYushu(){
		return a%b;
	}
	public int getCha(){
		return a-b;
	}
	public int getJi(){
		return a*b;
	}
	public int getChu(){
		return a/b;
	}
	public static void main(String [] agrs){
		Wd wd=new Wd();
		Scanner in = new Scanner(System.in);
		System.out.println("请输入两个整数");
		wd.a=in.nextInt();
		wd.b=in.nextInt();
		System.out.println("a+b="+wd.getSum());
		System.out.println("a-b="+wd.getCha());
		System.out.println("a*b="+wd.getJi());
		System.out.println("a/b="+wd.getChu());
		System.out.println("a%b="+wd.getYushu());
		System.out.println("------------------");
		System.out.println("请输入两个整数");
		int a=in.nextInt();
		int b=in.nextInt();
		Wd wd1=new Wd(a,b);
		System.out.println("a+b="+wd1.getSum());
		System.out.println("a-b="+wd1.getCha());
		System.out.println("a*b="+wd1.getJi());
		System.out.println("a/b="+wd1.getChu());
		System.out.println("a%b="+wd1.getYushu());
		
	}
}
