package T4.T41;

public class StaticDemo {
/**
 * 【练习题】14.Static关键字与普通变量的区别： 
	创建一个名称为StaticDemo的类，并声明一个静态变量和一个普通变量。
	对变量分别赋予10和5的初始值。在main()方法中输出变量值。  
 * */
	int a=10;
	public static int b=5;
	public StaticDemo(){
		a=10;
	}
	public static void main(String[] agrs){
		StaticDemo t1=new StaticDemo();
		System.out.println("a="+t1.a);
		System.out.println("b="+b);
	}
}
