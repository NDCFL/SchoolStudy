package T1;

public class Node {

	//节点数据类型和名称
	String name;
	//节点的下一个节点的地址
	Node next;
	public Node() {
		
	}
	public Node(String name) {
		this.name = name;
		next=null;
	}
	
}
