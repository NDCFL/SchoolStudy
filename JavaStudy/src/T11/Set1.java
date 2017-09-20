package T11;

import java.util.HashSet;
import java.util.Iterator;

public class Set1 {

	public static void main(String[] args) {
		int a[]={1,1,2,2,5,8,9,4,1,2,5,8,9};
		HashSet<Integer> hSet = new HashSet<Integer>();
		for (int i = 0; i < a.length; i++) {
			hSet.add(a[i]);
		}
		Iterator<Integer> it = hSet.iterator();
		while (it.hasNext()) {
			System.out.print(it.next()+"  ");
			
		}
		
	}
}
