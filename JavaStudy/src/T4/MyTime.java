package T4;

import java.util.Scanner;

public class MyTime {
/**
 * 练习题】03.类的成员变量与方法、构造方法 
在程序中，经常要对时间进行操作，但是并没有时间类型的数据。
那么，我们可以自己实现一个时间类，来满足程序中的需要。 
定义名为MyTime的类，其中应有三个整型成员：时（hour），分（minute），秒（second）
，为了保证数据的安全性，这三个成员变量应声明为私有。 为MyTime类定义构造方法，
以方便创建对象时初始化成员变量。 再定义diaplay方法，用于将时间信息打印出来。  
为MyTime类添加以下方法： 
addSecond(int sec) addMinute(int min) addHour(int hou) 
subSecond(int sec) subMinute(int min) subHour(int hou) 
分别对时、分、秒进行加减运算。  

 * */
	private int hour,minute,second;//私有的整型变量值
	public MyTime(){
		hour=3;
		minute=5;
		second=4;
	}
	public int addSecond(int second){
		return (this.second+second);
	}
	public int subMinute(int minnute){
		return (this.minute-minute);
	}
	public int addHour(int hour){
		return (this.hour+hour);
	}
	public int subSecond(int second){
		return (this.second-second);
	}
	public int addMinute(int minnute){
		return (this.minute+minute);
	}
	public int subHour(int hour){
		return (this.hour-hour);
	}
	public void display(){
		System.out.println("h:m:s");
		System.out.println(hour+":"+minute+":"+second);
	}
	public static void main(String [] agrs){
		int a,b,c,A,B,C;
		MyTime time=new MyTime();
		Scanner in = new Scanner(System.in);
		time.display();
		System.out.println("----------------");
		do{
			System.out.println("请输入要加的小时值,分钟值，秒钟值");
			a=in.nextInt();
			b=in.nextInt();
			c=in.nextInt();
			time.addHour(a);
			time.addMinute(b);
			time.addSecond(c);
			if(time.hour+a>=0 && time.hour+a<=24 && time.minute+b>=0 && time.minute+b<=60 && time.second+c>=0 && time.second+c<=60){
				a+=time.hour;
				b+=time.minute;
				c+=time.second;
				System.out.println("小时，分钟，秒钟相加后的结果如下");
				System.out.println(a+":"+b+":"+c);
			}else{
				System.out.println("你输入的有误，不符合规则，重新输入");
			}
			System.out.println("请输入要减的小时值,分钟值，秒钟值");
			A=in.nextInt();
			B=in.nextInt();
			C=in.nextInt();
			time.subMinute(A);
			time.subMinute(B);
			time.subSecond(C);
			if(time.hour-A>=0 && time.hour-A<=24 && time.minute-B>=0 && time.minute-B<=60 && time.second-C>=0 && time.second-C<=60){
				A=time.hour-A;
				B=time.minute-B;
				C=time.second-C;
				System.out.println("小时，分钟，秒钟相加后的结果如下");
				System.out.println(A+":"+B+":"+C);
			}else{
				System.out.println("你输入的有误，不符合规则，重新输入");
			}	
		
		}while(true);
	}
	
}
