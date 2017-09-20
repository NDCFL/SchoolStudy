package zuoye;
import java.util.Scanner;
public class Tixing {
	float a,b,c,area;
	public float jisuan(){
		return (a+b)*c/2;
	}
	public static void main(String[] agrs){
		Tixing tixing = new Tixing();
		Scanner input = new Scanner(System.in);
		System.out.println("请输入梯形的上底下底和高");
		tixing.a=input.nextFloat();
		tixing.b=input.nextFloat();
		tixing.c=input.nextFloat();
		System.out.println("梯形的面积"+tixing.jisuan());
		
		
	} 
}
