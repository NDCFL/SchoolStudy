package T1;

public class TwoNode {

	TwoWayNode headnode;
	public TwoNode() {
		headnode = new TwoWayNode();
		headnode.next=null;
		headnode.prior=null;
	}
	//新增节点
	public void addnode(String name){
		TwoWayNode node = headnode;
		while(node.next!=null){
			node=node.next;
		}
		TwoWayNode two = new TwoWayNode(name);
		node.next=two;
		two.prior=node;
	}
	//遍历查找数据
	public void sysnode(){
		TwoWayNode node = headnode;
		System.out.println("正序查找");
		while(node.next!=null){
			System.out.println("@@@@@@@@@@@"+node.next.name+"@@@@@@@@@@@");
			node=node.next;
		}
		System.out.println("逆序查找");
		while(node.prior!=headnode){
			System.out.println("@@@@@@@@@@@"+node.name+"@@@@@@@@@@@");
			node=node.prior;
		}
		System.out.println("@@@@@@@@@@@"+node.name+"@@@@@@@@@@@");
		
	}
	//删除节点
	public void delnode(String name){
		TwoWayNode head = headnode;
		while(head.next!=null){
			if(head.next.name.equals(name)){
				head.next.next.prior=head.next.prior;
				head.next=head.next.next;
				break;
			}else {
				head=head.next;
			}
		}
	}
	//插入节点
	public void innode(String oldname,String newname){
		TwoWayNode head = headnode;
		while(head.next!=null){
			if(head.next.name.equals(oldname)){
				TwoWayNode node = head.next;
				TwoWayNode no = new TwoWayNode(newname);
				no.next=node.next;
				node.next.prior=no;
				no.prior=node;
				node.next=no;
				break;
			}else {
				head=head.next;
			}
		}
	}
	public static void main(String[] args) {
		TwoNode t = new TwoNode();
		t.addnode("虾米");
		t.addnode("小鱼");
		t.addnode("大鱼");
		t.addnode("人");
		t.addnode("吸血鬼");
		t.sysnode();
		System.out.println("-----------------");
		t.delnode("人");
		t.sysnode();
		System.out.println("-----------------");
		t.innode("大鱼","人");
		t.sysnode();
	}
}
