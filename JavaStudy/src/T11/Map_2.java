package T11;

import java.util.HashMap;

public class Map_2 {

	public static void main(String[] args) {
		HashMap map = new HashMap();
		map.put("name",null);
		map.put("name","Jack");
		System.out.println(map.get("name"));
	}
}
