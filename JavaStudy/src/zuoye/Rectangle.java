package zuoye;
import java.util.Scanner;
public class Rectangle {
/**
 * 一：  
	（1）创建Rectangle类，添加属性width、height；  
	（2）在Rectangle类中添加两种方法计算矩形的周长和面积； 
	（3）编程利用Rectangle输出一个矩形的周长和面积

 * */
	float width,height,sum,sum1;
	public void zhouchang(){
		sum=(height+width)*2;
		System.out.println("长="+width);
		System.out.println("高="+height);
		System.out.println("周长="+sum);
	}
	public void mianji(){
		sum1=(height*width);
		System.out.println("长="+width);
		System.out.println("高="+height);
		System.out.println("面积="+sum1);
		
	}
	public static void main(String[] agrs){
		Rectangle juxing=new Rectangle();
		Scanner in =new Scanner(System.in);
		System.out.println("请输入矩形的长和高");
		juxing.height=in.nextFloat();
		juxing.width=in.nextFloat();
		juxing.zhouchang();
		juxing.mianji();
		
	}
	
}
