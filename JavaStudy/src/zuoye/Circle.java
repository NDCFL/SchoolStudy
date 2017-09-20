package zuoye;
import java.util.Scanner;
public class Circle {
/*
	(1)定义一个圆形类Circle
	属性：
	    半径 radius : double
        构造方法：
            Circle(double r)
        方法：
            求周长：public double findPerimeter()
            求面积：public double findArea()
	    定义一个测试类TestCircle
	    在测试类的主方法中创建两个Circle对象c1,c2，
	    其中c1的半径为2.5，c2的半径为10，
	    分别输出c1和c2各自的周长和面积。
*/
	double radius;
	public double zhouchang(double radius){
		return (2*radius*Math.PI);
		
	}
	public double mianji(double radius){
		return (radius*radius*Math.PI);
		
	}
	public static void main(String[] agrs){
		Circle C1=new Circle();
		Circle C2=new Circle();
		Scanner in =new Scanner(System.in);
		double sum,sum1;
		System.out.println("请输入圆1的半径");
		C1.radius=in.nextDouble();
		System.out.println("请输入圆2的半径");
		C2.radius=in.nextDouble();
		sum=C1.zhouchang(C1.radius);
		sum1=C1.mianji(C1.radius);
		sum=C2.zhouchang(C2.radius);
		sum1=C2.mianji(C2.radius);
		System.out.println("圆1的面积周长如下：");
		System.out.println("半径："+C1.radius);
		System.out.println("周长："+sum);
		System.out.println("面积："+sum1);
		System.out.println("圆2的面积周长如下：");
		System.out.println("半径："+C2.radius);
		System.out.println("周长："+sum);
		System.out.println("面积："+sum1);
	}
}
