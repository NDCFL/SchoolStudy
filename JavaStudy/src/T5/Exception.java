package T5;

import sun.reflect.generics.tree.IntSignature;

public class Exception {
	public static void printlengthVoid() {
		String str=null;
		int strLength=str.length();
		System.out.println("strLength的长度"+str.length());
	}
	public static void main(String[] args) {
		printlengthVoid();
	}
	
}
