package T2;

public class OneChain {

	Node headnode;
	public OneChain() {
		headnode=new Node();
		headnode.next=null;
	}
	public void addnode(String string){
		Node head=headnode;
		if(head.next==null){
			Node node = new Node(string);
			head.next=node;
			node.next=headnode.next;
			return;
		}
		head=head.next;
		while(head.next!=headnode.next){
			head=head.next;
		}
		Node node = new Node(string);
		head.next=node;
		node.next=headnode.next;
	}
	public void sysnode(){
		Node head = headnode.next;
		while(head.next!=headnode.next){
			System.out.println(head.name);
			head=head.next;
		}
		System.out.println(head.name);
	}
	public void  innode(String oldnode,String newnode){
		Node node = headnode.next;
		while(node.next!=headnode.next){
			if(node.next.name.equals(oldnode)){
				Node no = node.next;
				Node n = new Node(newnode);
				n.next=no.next;
				no.next=n;
				break;
			}else {
				node=node.next;
			}
		}
		
	}
	public static void main(String[] args) {
		OneChain one = new OneChain();
		one.addnode("你好");
		one.addnode("你们好");
		one.addnode("我好");
		one.innode("你们好", "大家好");
		one.sysnode();
	}
	
}
