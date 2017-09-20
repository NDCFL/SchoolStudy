package T6;

import java.io.UnsupportedEncodingException;

public class Countbean {

	private String name;
	private int count;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCount() {
		count++;
		return count;
	}
}
