package T1;
public class AddNode {

	Node headnode ;
	public AddNode() {
		headnode = new Node();
		headnode.next=null;
	}
	//新增节点
	public void addnode(String node){
		Node n = headnode;
		while (n.next!=null) {
			n=n.next;
		}
		Node addnode = new Node(node);
		n.next=addnode;
	}
	//遍历打印所有节点
	public void displaynode(){
		Node headNode = headnode;
		while (headNode.next!=null) {
			System.out.println(headNode.next.name+"----->");
			headNode=headNode.next;
		}
	}
	//删除节点
	public void delnode(String delnode){
		Node headNode = headnode;
		while (headNode.next!=null){
			if(headNode.next.name.equals(delnode)){
				//找到要删除的节点
				headNode.next=headNode.next.next;
				break;
			}else {
				//否则继续查找
				headNode=headNode.next;
			}
		}
	}
	//寻找总节点个数
	public int nodesize(){
		int n=0;
		Node headNode = headnode; 
		while (headNode.next!=null) {
			headNode=headNode.next;
			n++;			
		}
		return n;
	}
	//插入节点
	public void innode(String innode,String downnode){
		//innode代表你要插入的节点的上一个，downnode代表插入的节点
		Node headNode = headnode;
		while (headNode.next!=null) {
			if(headNode.next.name.equals(innode)){
				//找到了要插入的节点
			    //将找到的节点暂时保存起来
				Node tempnode = headNode.next;
				//实例化一个你要插入的节点
				Node addnode = new Node(downnode);
				//操作节点
				addnode.next=tempnode.next;
				tempnode.next=addnode;
				break;
			}else {
				headNode = headNode.next;
			}
		}
	}
	//修改节点
	public void updatenode(String oldnode,String newnode){
		Node headNode = headnode;
		while (headNode!=null) {
			if(headNode.next.name.equals(oldnode)){
				//找到了节点,并临时保存
				headNode.next.name=newnode;
				break;
			}else {
				headNode=headNode.next;
			}
		}
	}
	//查找节点的位置
	public int nodeindex(String node){
		int n=0;
		Node headNode = headnode;
		while(headNode.next!=null){
			n++;
			if(headNode.next.name.equals(node)){
				System.out.println("找到了该节点！");
				break;
			}else {
				headNode = headNode.next;
			}
		}
		return n;
	}
	public static void main(String[] args) {
		AddNode add = new AddNode();
		add.addnode("组长");
		add.addnode("部门经理");
		add.addnode("主管副总");
		add.addnode("总经理");
		System.out.println("原始节点如下：");
		add.displaynode();
		int index = add.nodeindex("部门经理");
		System.out.println("在第"+index+"个位置找到了");
//		add.delnode("部门经理");
//		System.out.println("--------删除部门经理节点后的数据-------");
//		add.displaynode();
//		add.innode("组长","部门经理");
//		System.out.println("--------插入部门经理节点后的数据-------");
//		add.displaynode();
//		System.out.println("----------节点总数-------");
//		System.out.println("节点总数："+add.nodesize());
//		System.out.println("----------更改节点--------");
//		add.updatenode("组长", "老大");
//		add.displaynode();
	}
}
