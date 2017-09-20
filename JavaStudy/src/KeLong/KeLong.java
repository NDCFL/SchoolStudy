package KeLong;

public class KeLong implements Cloneable{

	private String nameString="陈飞龙";
	private int age = 21;
	
	public KeLong(String nameString,int age) {
		this.age=age;
		this.nameString= nameString;
	}
	public String getNameString() {
		return nameString;
	}
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		KeLong result = (KeLong)super.clone();
		return result;
	}
}
