package T1;

public class Text_2 {

	public static void main(String[] args) {

		int a[]={1,2,3,4,5,6,7,8,9,10};//十个元素
		int t;
		for (int i = 0; i < a.length/2; i++) {
			t=a[i];
			a[i]=a[9-i];
			a[9-i]=t;
		}
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+"   ");
		}
	}
}
