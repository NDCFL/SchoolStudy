package T5;

public class Throws {
	static int amethod(int a,int b){
		if (b==0) {
			throw new ArithmeticException();
		}else {
			return a/b;
		}
		
	}
	public static void main(String[] args) {
		System.out.println(amethod(14,7));
		System.out.println(amethod(14,0));
	}
}
