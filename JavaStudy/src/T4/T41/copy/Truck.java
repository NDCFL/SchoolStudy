package T4.T41.copy;
import T4.Vehicles;
public class Truck extends Vehicles {
/**
 * 编写Truck（卡车）类继承于Vehicles类，增加float型成员属性load（载重），
还应增加成员方法showTruck（在控制台显示卡车的信息），并编写构造方法。 
在main方法中测试以上各类。  
 * */
	float load;
	public void showTruck(){
		this.brand="保时捷";
		this.color="白色";
		this.load=56.5f;
	}
	public Truck(){
		this.brand="法拉利";
		this.color="黑色";
		this.load=54.8f;
	}
	public Truck(String brand){
		this.brand=brand;
	}
	public void display(){
		System.out.println("brand="+this.brand+"\t"+"color="+this.color+"\t"+"load="+this.load);
	}
	public static void main(String[] agrs){
		Vehicles t1= new Vehicles();
		t1.run();
		t1.showInfo();
		Truck t2=new Truck();
		t2.display();
		t2.showTruck();
		t2.display();
		Truck t3=new Truck("蓝色");
		t3.display();
		
	}
	
}
