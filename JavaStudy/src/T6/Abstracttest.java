package T6;

public class Abstracttest extends Abstract_1{

	
	public static void main(String[] args) {
		Abstract_1 a = new Abstracttest();
		a.max(5, 6);
		a.min();
	}

	@Override
	public void min() {
		this.a =13;
		this.b=9;
		
		System.out.println("我是重写方法");
		max(a, b);
	}
}
