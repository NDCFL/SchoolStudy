package T4;
import java.util.Scanner;
public class Vehicle {
/**
	请定义一个交通工具(Vehicle)的类，其中有: 属性：速度(speed)，
	体积(size)等等 方法：移动(move())，设置速度(setSpeed(int speed))，
	加速speedUp(),减速speedDown()等等. 
	最后在测试类Vehicle中的main()中实例化一个交通工具对象，
	并通过方法给它初始化speed,size的值，
	并且通过打印出来。另外，调用加速，减速的方法对速度进行改变。  

 * */
	int spreed,size;
	public void move(){
		int shudu,tiji;
		Scanner in = new Scanner(System.in);
		System.out.println("请输入速度,体积");
		shudu=in.nextInt();//速度
		tiji=in.nextInt();//体积
		System.out.println("速度为:"+shudu+"\t"+"体积为:"+tiji);
	}
	public void setSpeed(int spreed){
		this.spreed=spreed;
		System.out.println("速度为："+this.spreed);
	}
	public int spreedUp(int spreed){
		int a;
		Scanner in = new Scanner(System.in);
		System.out.println("请输入你要加的速度值");
		a=in.nextInt();//速度
		return a+spreed;
	}
	public int spreedDown(int spreed){
		int b;
		Scanner in = new Scanner(System.in);
		System.out.println("请输入你要减的速度值");
		b=in.nextInt();//速度
		return spreed-b;
	}
	
}
