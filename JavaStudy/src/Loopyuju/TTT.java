package Loopyuju;

import java.util.Scanner;

public class TTT {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in= new Scanner(System.in);
		int a=in.nextInt();
		int b= in.nextInt();
		int min = a>b?b:a;
		for(int i=min;i>0;i--){
			if(a%i==0 && b%i==0){
				System.err.println();
			}
		}

	}

}
