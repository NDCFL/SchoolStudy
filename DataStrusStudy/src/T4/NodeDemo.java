package T4;

public class NodeDemo {

	Node node;
	int num = 0;
	int sum=0;
	public NodeDemo(int data) {
		node = new Node(data);
		sum+=data;
	}
	public void addnode(int data){
		Node n = node;
		Node temp = new Node(data);
		while(true){
			if(n.data>data){
				if(n.leftNode!=null){
					n=n.leftNode;
				}else {
					n.leftNode=temp;
					break;
				}
			}else{
				if(n.rightNode!=null){
					n=n.rightNode;
				}else {
					n.rightNode=temp;
					break;
				}
			}
		}
	}
	public int height(Node node){
		if(node==null){
			return 0;
		}else{
			if(height(node.leftNode)>height(node.rightNode)){
				return height(node.leftNode)+1;
			}else {
				return height(node.rightNode)+1;
			}
		}
	}
	public void display(Node node){
//		System.out.println(node.data);//先根遍历
		if(node.leftNode!=null){
//			System.out.println("左走");
			sum+=node.leftNode.data;
			display(node.leftNode);
		}
		System.out.print(node.data+"\t");//中根遍历
		if(node.rightNode!=null){
//			System.out.println("右走");
			sum+=node.rightNode.data;
			display(node.rightNode);
		}
//		System.out.println(node.data);//后根遍历
		num++;
	}
	public void findnode(int data,Node node){
		if(node.leftNode!=null){
			if(node.leftNode.data==data){
				System.out.println("左孩子找到了"+data);
				return;
			}else{
				findnode(data,node.leftNode);
			}
		}
		if(node.rightNode!=null){
			if(node.rightNode.data==data){
				System.out.println("右孩子找到了"+data);
				return;
			}else{
				findnode(data,node.rightNode);
			}
		}
		System.out.println("找不到该数");
	}
	public void maxnode(){
		while(true){
			if(node.rightNode.rightNode!=null){
				node=node.rightNode;
			}else {
				System.out.println("节点的最大值为："+node.rightNode.data);
				break;
			}
		}
	}
	public void minnode(){
		while(true){
			if(node.leftNode.leftNode!=null){
				node=node.leftNode;
			}else {
				System.out.println("节点的最小值为："+node.leftNode.data);
				break;
			}
		}
	}
	public static void main(String[] args) {
		NodeDemo nd = new NodeDemo(10);
		nd.addnode(8);
		nd.addnode(7);
		nd.addnode(3);
		nd.addnode(6);
		nd.addnode(9);
		nd.addnode(1);
		nd.addnode(-10);
		nd.addnode(20);
		nd.addnode(50);
		nd.addnode(40);
		nd.addnode(60);
		nd.addnode(100);
		nd.addnode(80);
		nd.addnode(120);
		
//		nd.addnode(2);
//		nd.addnode(0);
//		nd.addnode(1);
//		nd.addnode(3);
//		nd.addnode(1);
//		nd.addnode(4);
		nd.display(nd.node);
		System.out.println("二叉树的深度为："+nd.height(nd.node));
//		System.out.println("------------------------------------");
//		nd.findnode(19,nd.node);
//		System.out.println("---------节点的最大值-------------");
//		nd.maxnode();
//		System.out.println("---------节点的最小值-----------------");
//		nd.minnode();
		
		System.out.println("总和："+nd.sum);
		System.out.println("总结点数："+nd.num);
		float avg=(float)nd.sum/(float)nd.num;
		System.out.println("节点的平均数："+avg);
	}
	
}
