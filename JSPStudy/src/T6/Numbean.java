package T6;

public class Numbean {

	private int num1,num2,num3,num4;

	public int getNum1() {
		return num1;
	}

	public void setNum1(int num1) {
		this.num1 = num1;
	}

	public int getNum2() {
		return num2;
	}

	public void setNum2(int num2) {
		this.num2 = num2;
	}

	public int getNum3() {
		return num3;
	}

	public void setNum3(int num3) {
		this.num3 = num3;
	}
	public int result(int num1,int num2,int num4){
		//num4为操作符
		switch(num4){
			case 1:
				num3=num1+num2;	
				break;
			case 2:
				num3=num1-num2;	
				break;
			case 3:
				num3=num1*num2;	
				break;
			case 4:
				num3=num1/num2;	
				break;
			case 5:
				num3=num1%num2;	
				break;
		}
		return num3;
	}

	public int getNum4() {
		return num4;
	}

	public void setNum4(int num4) {
		this.num4 = num4;
	}
}
