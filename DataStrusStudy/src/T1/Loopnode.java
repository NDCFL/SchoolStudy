package T1;

public class Loopnode {

	Node headnode;
	//建表
	public Loopnode() {
		headnode = new Node();
		headnode.next=null;
	}
	public void addnode(String node){
		Node head = headnode;
		if(head.next==null){
			Node no = new Node(node);
			head.next=no;
			no.next=headnode.next;
			return;
		}
		head=head.next; 
		while(head.next!=headnode.next){
			head=head.next;
		}
		Node no = new Node(node);
		no.next=headnode.next;
		head.next=no;
	}
	//查找数据并打印
	public void sysnode(){
		Node node = headnode.next;
		while(node.next!=headnode.next){
			System.out.println(">>>>>>>>>>"+node.name+">>>>>>>>>>");
			node = node.next;
		}
		System.out.println(">>>>>>>>>>"+node.name+">>>>>>>>>>");
	}
	//删除节点数据
	public void delnode(String name){
		Node node = headnode.next;
		while(node.next!=headnode.next){
			if(node.next.name.equals(name)){
				node.next=node.next.next;
				break;
			}else {
				node=node.next;
			}
		}
	}
	//插入一个节点
	public void innode(String oldname,String newnode){
		Node no = headnode.next;
		while(no.next!=headnode.next){
			if(no.name.equals(oldname)){
				Node temp = no;
				Node node = new Node(newnode);
				node.next=temp.next;
				temp.next=node;
				break;
			}else {
				no=no.next;
			}
		}
	}
	public static void main(String[] args) {
		Loopnode loop = new Loopnode();
		loop.addnode("虾米");
//		loop.addnode("小鱼");
//		loop.addnode("大鱼");
//		loop.addnode("人");
//		loop.addnode("吸血鬼");
		loop.sysnode();
//		System.out.println("删除节点数据后如下：");
//		loop.delnode("人");
//		loop.sysnode();
//		System.out.println("插入节点数据后如下：");
//		loop.innode("大鱼","人");
//		loop.sysnode();
	}
}
