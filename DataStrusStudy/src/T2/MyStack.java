package T2;


public class MyStack {

	Node heaNode;
	int num=0;
	public MyStack() {
		heaNode = new Node();
	}
	//新增函数
	public void push(String data){
		Node n = heaNode;
		Node no = new Node(data);
		no.next=n.next;
		n.next=no;
		num++;
	}
	//删除函数
	public String pop(){
		if(isEmpty()){
			System.out.println("堆栈已满！");
			return null;
		}
		Node n = heaNode;
		Node no = n.next;
		n.next=n.next.next;
		num--;
		return no.name;
	}
	//判断是否为空值
	public boolean isEmpty(){
		boolean exis = false;
		Node n = heaNode;
		if(n.next==null){
			exis=true;
		}
		return exis;
	}
	//堆栈的大小
	public int size(){
		return num;
		
	}
	//返回堆栈的栈顶元素
	public String peek(){
		if(isEmpty()){
			System.out.println("堆栈中没有元素了！");
			return null;
		}
		return heaNode.next.name;
	}
	//查找元素
	public int findstack(String data){
		int n=0;
		Node node = heaNode;
		while (!isEmpty()) {
			if(node.next.name.equals(data)){
				System.out.println("在第"+n+"个位置找到了"+data);
				break;
			}
			n++;
		}
		return n;
	}
	public static void main(String[] args) {
		MyStack stack = new MyStack();
		stack.push("虾米");
		stack.push("小鱼");
		stack.push("大鱼");
		stack.push("人");
		stack.push("吸血鬼");
//		stack.findstack("人");
		System.out.println("堆栈中的栈顶元素为："+stack.peek());
		System.out.println("堆栈中的元素个数："+stack.size());
		while(!stack.isEmpty()){
			System.out.println(stack.pop());
		}
		System.out.println("堆栈中的元素个数："+stack.size());
		System.out.println("堆栈中的栈顶元素为："+stack.peek());
	}
}
