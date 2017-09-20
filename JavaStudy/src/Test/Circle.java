package Test;

public class Circle implements Shape{

	@Override
	public double area(double value) {
		return value;
	}
	public void  Circle(int width,int height){
		double value = width*height;
		area(value);
	}
}
