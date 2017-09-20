package T2;

public class Eatpick {
	public static void main(String[] args) {
		int n=1;
		for (int i = 9; i >0; i-- ){
			n=(n+1)*2;
			System.out.println("第"+i+"天吃了"+n+"个桃");
		}
		System.out.println("一共有"+n+"个桃");
	}
}
