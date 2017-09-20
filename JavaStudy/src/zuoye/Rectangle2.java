package zuoye;
import java.util.Scanner;
public class Rectangle2 {
	float height,width;
	public float zhouchang(float height,float width){
		return ((height+width)*2);
	}
	public float mianji(float height,float width){
		return (height*width);
	}
	public static void main(String[] agrs){
		Rectangle2 juxing=new Rectangle2();
		float sum,sum1;
		Scanner p =new Scanner(System.in);
		System.out.println("请输入矩形的长和高");
		juxing.height=p.nextFloat();
		juxing.width=p.nextFloat();
		sum=juxing.zhouchang(juxing.width,juxing.height);
		sum1=juxing.mianji(juxing.width,juxing.height);
		System.out.println("长："+juxing.width);
		System.out.println("高："+juxing.height);
		System.out.println("面积："+sum1);
		System.out.println("周长："+sum);
	}
}
