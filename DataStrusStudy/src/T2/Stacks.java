package T2;

import java.util.Stack;

public class Stacks {

	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		stack.push("组长");
		stack.push("部门经理");
		stack.push("主管副总");
		stack.push("总经理");
		stack.push("董事长");
		while(!stack.isEmpty()){
			System.out.println(stack.pop()+"批准");
		}
	}
}
