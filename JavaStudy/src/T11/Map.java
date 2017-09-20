package T11;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

public class Map {

	public static void main(String[] args) {
		Hashtable<String, list_2> ht = new Hashtable<String, list_2>();
		list_2 lt = new list_2("1001","战三","200","武汉");
		list_2 lt1 = new list_2("1002","里三","210","武汉");
		list_2 lt2 = new list_2("1003","王三","200","江西");
		list_2 lt3 = new list_2("1004","战六月","450","青岛");
		list_2 lt4 = new list_2("1005","发的","670","北京");
		list_2 lt5 = new list_2("1006","战三","240","重庆");
		list_2 lt6 = new list_2("1007","战三","220","江苏");
		ht.put("1001", lt);
		ht.put("1002", lt1);
		ht.put("1003", lt2);
		ht.put("1004", lt3);
		ht.put("1005", lt4);
		ht.put("1006", lt5);
		//获取所有的键值对
		Set<String> key = ht.keySet(); 
		Iterator<String> iterator = key.iterator();
		while (iterator.hasNext()) {
			System.out.println(ht.get(iterator.next()));
			
		}
		
	}
}
