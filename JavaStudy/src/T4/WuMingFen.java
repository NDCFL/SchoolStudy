package T4;

class WuMingFen {
/**
 * 
为“无名的粉”写一个类：class WuMingFen 要求： 
1.有三个属性：面码:String theMa  粉的分量(两)：int quantity    
     是否带汤：boolean likeSoup 
2.写一个构造方法，以便于简化初始化过程，如： 
 WuMingFen f1 = new WuMingFen("牛肉",3,true); 
 3.重载构造方法，使得初始化过程可以多样化：  WuMingFen f2 = new WuMingFen("牛肉",2); 
4.如何使得下列语句构造出来的粉对象是酸辣面码、2两、带汤的？ 
 WuMingFen f3 = new WuMingFen(); 
5.写一个普通方法：check()，用于查看粉是否符合要求。即：将对象的三个属性打印在控制台上。   

* */
	String theMa;
	int quantity;
	boolean likeSoup;
	public WuMingFen(){//f3
		theMa="酸辣面码";
		quantity=2;
		likeSoup=true;
	}
	public WuMingFen(String name,int quantity,boolean likeSoup){//f1
		this.theMa=theMa;
		this.quantity=quantity;
		this.likeSoup=likeSoup;
	}
	public WuMingFen(String name,int quantity){//f2
		this.theMa=theMa;
		this.quantity=quantity;
	}
	public void check(){
		System.out.println("theMa="+theMa+"\t"+"quantity"+quantity+"\t"+"likeSoup"+likeSoup);
	}
	public static void main(String[] agrs){
		WuMingFen f1 = new WuMingFen("牛肉",3,true);
		WuMingFen f2 = new WuMingFen("牛肉",2);
		WuMingFen f3 = new WuMingFen();
		System.out.println("theMa="+f1.theMa+"\t"+"quantity="+f1.quantity+"\t"+"likeSoup="+f1.likeSoup);
		System.out.println("theMa="+f2.theMa+"\t"+"quantity="+f2.quantity+"\t"+"likeSoup="+f2.likeSoup);
		System.out.println("theMa="+f3.theMa+"\t"+"quantity="+f3.quantity+"\t"+"likeSoup="+f3.likeSoup);
	}
}
