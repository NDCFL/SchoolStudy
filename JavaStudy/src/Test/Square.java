package Test;

import java.awt.geom.Area;

public class Square implements Shape{

	public void Square(int r){
		double value = Math.PI*r*r;
		area(value);
		System.out.println(value);
	}

	@Override
	public double area(double value) {
		System.out.println(value);
		return value;
	}
}
