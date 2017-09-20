package Test;


public class Link {

	/*
	 * 3.用链表实现二叉树的功能，要求如下：
		1.创建节点类；
		2.实现新增节点功能；
		3.实现先根遍历节点功能；
		4.实现中根遍历节点功能；
		5.实现后根遍历节点功能；
	 * */
	Linknode headnode;
	public Link(int data) {
		headnode = new Linknode(data);
	}
	public void addnode(int data){
		Linknode node = headnode;
		Linknode n = new Linknode(data);
		while(true){
			if(node.data>data){
				//左孩子
				if(node.leftchild!=null){
					node=node.leftchild;
				}else {
					node.leftchild=n;
					break;
				}
			}else{
				//右孩子
				if(node.rightchild!=null){
					node=node.rightchild;
				}else {
					node.rightchild=n;
					break;
				}
			}
		}
	}
	//先根遍历
	public void sysnode(Linknode node){
		System.out.print(node.data+"    ");
		if(node.leftchild!=null){
			sysnode(node.leftchild);
		}
		if(node.rightchild!=null){
			sysnode(node.rightchild);
		}
	}
	//中根遍历
	public void sysnode1(Linknode node){
		if(node.leftchild!=null){
			sysnode1(node.leftchild);
		}
		System.out.print(node.data+"    ");
		if(node.rightchild!=null){
			sysnode1(node.rightchild);
		}
	}
	//后根遍历
	public void sysnode2(Linknode node){
		if(node.leftchild!=null){
			sysnode2(node.leftchild);
		}
		if(node.rightchild!=null){
			sysnode2(node.rightchild);
		}
		System.out.print(node.data+"    ");
	}
	public static void main(String[] args) {
		Link link = new Link(4);
		link.addnode(2);
		link.addnode(1);
		link.addnode(3);
		link.addnode(6);
		link.addnode(5);
		link.addnode(7);
		System.out.print("先根遍历:");
		link.sysnode(link.headnode);
		System.out.print("\n中根遍历:");
		link.sysnode1(link.headnode);
		System.out.print("\n后根遍历:");
		link.sysnode2(link.headnode);
	}
}
