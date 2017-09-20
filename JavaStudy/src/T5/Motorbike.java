package T5;

public class Motorbike extends Vehicle{
	
	public  String numOfWheels(String name){
		return name;
		
	}
	public void shuanglunche(String name,String color,String place, int num){
		this.name=name;
		this.color=color;
		this.place=place;
		this.num=num;
		
	}
	public void play(){
		System.out.println("品牌:"+this.name+"\t"+"颜色:"+this.color+"\t\t"+"价格:"+this.place+"\t"+"轮子数:"+this.num);
	}
}
