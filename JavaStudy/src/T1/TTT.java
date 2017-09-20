package T1;

public class TTT {

	/**
	 * @param args
	 */
	private static int x = 101;
	public static void main(String[] args) {
		TTT hs1 = new TTT();
		System.out.println(hs1);
		hs1.x++;//102=x
		TTT hs2 = new TTT();
		hs2.x++;//103=hs1
		hs1 = new TTT();
		hs1.x++;//104=hs2
		TTT.x--;//103=hs1=hs2
		System.out.println(hs1.x + hs2.x);
		System.out.println("hs1.x="+hs1.x + "hs2.x="+hs2.x);
	}

}
