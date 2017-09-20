package T5;

public class Car extends Vehicle{
	
	public  String numOfWheels(String name){
		return name;
		
	}
	public void silunche(String name,String color,String place, int num){
		this.name=name;
		this.color=color;
		this.place=place;
		this.num=num;
		
	}
	public void display(){
		System.out.println("品牌:"+this.name+"\t\t"+"颜色:"+this.color+"\t\t"+"价格:"+this.place+"\t\t"+"轮子数:"+this.num);
	}
}
