package T7;

import java.util.Random;

public class NumBean {

	private int value;
	private int count;
	public int getValue() {
		value = new Random().nextInt(100);
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public void src(){
		count++;
	}
	public void reset(){
		value=-1;
		count=0;
	}
}
