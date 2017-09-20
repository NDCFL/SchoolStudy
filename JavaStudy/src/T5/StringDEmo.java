package T5;

public class StringDEmo {

	public static void main(String[] args) {
		int a[]={2,3,5,7,11,13};
		int b[]={1001,1002,1003,1004,1005,1006,1007};
		System.arraycopy(a, 0, b, 2, 4);
		for (int i = 0; i < b.length; i++) {
			System.out.println(i+"拷贝为："+b[i]);
		}
		String  string="hello word";
	}
}
