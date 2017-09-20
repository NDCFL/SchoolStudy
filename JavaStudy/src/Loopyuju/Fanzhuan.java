package Loopyuju;

public class Fanzhuan {

	public static void main(String args[]) {
		String s = "java@123456@";
		int n = s.indexOf("@");
		int k = s.indexOf("@", 5);
		String s2 = s.substring(n + 1, k);
		System.out.println(s2);

	}

}
