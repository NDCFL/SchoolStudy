package T5;

public class Use {
	public static void main(String[] args) {
		String str=null;
		int strLength=0;
		try {
			strLength=str.length();
		} catch (NullPointerException e) {
			System.out.println("所求长度出现异常，为空");
		}
		System.out.println("str的长度="+strLength);
		
	}
}
