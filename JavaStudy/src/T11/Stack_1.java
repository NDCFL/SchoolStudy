package T11;

import java.util.Collection;
import java.util.Collections;
import java.util.Stack;

public class Stack_1 {

	public static void main(String[] args) {
		
		Stack<String> sk = new Stack<String>();
		//新增元素
		sk.push("dfxh");
		sk.push("ertgr");
		sk.push("ertge");
		sk.push("erte");
		sk.push("esrt");
		sk.push("esrtf");
		sk.push("esrtf");
		System.out.println("首元素为："+sk.peek());
		//查看大小
		System.out.println("size="+sk.size());
		while (!sk.isEmpty()) {
			Collections.reverse(sk);
			//取出元素并删除元素
			System.out.println("aaaa="+sk.pop());
		}
		System.out.println("size="+sk.size());
	}
	
}
