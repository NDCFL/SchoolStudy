package T11;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

public class Map_1 {

	public static void main(String[] args) {
		Hashtable<String, list_2> ht = new Hashtable<String, list_2>();
		list_2 lt1 = new list_2("1","苹果","2.5","赣州");
		list_2 lt2 = new list_2("2","香蕉","2.5","赣州");
		list_2 lt3 = new list_2("3","雪梨","2.5","赣州");
		list_2 lt4 = new list_2("4","凤梨","2.5","赣州");
		list_2 lt5 = new list_2("5","橘子","2.5","赣州");
		list_2 lt6 = new list_2("6","柚子","2.5","赣州");
		list_2 lt7 = new list_2("7","苹果","2.5","赣州");
		ht.put("1",lt1 );
		ht.put("2",lt2 );
		ht.put("3",lt3 );
		ht.put("4",lt4 );
		ht.put("5",lt5 );
		ht.put("6",lt6 );
		ht.put("7",lt7 );
		Set<String> st = ht.keySet();
		Iterator<String> iterator = st.iterator();
		while (iterator.hasNext()) {
			System.out.println(ht.get(iterator.next()));
		}
	}
}
