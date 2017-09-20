package T1;

public class HasStatic {

	private static int x = 101;
	public static void main(String[] args){
		HasStatic hs1 = new HasStatic();
		hs1.x++;
		HasStatic hs2 = new HasStatic();
		hs2.x++;
		hs1 = new HasStatic();
		hs1.x++;
		HasStatic.x--;
		System.out.println(hs1.x + hs2.x);
	}

}
