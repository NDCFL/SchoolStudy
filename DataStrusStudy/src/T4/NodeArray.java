package T4;


public class NodeArray {

//	10,8,7,3,1，-10,6,20,90,100
	int data[];
	int size;
	public NodeArray(int root) {
		size=33;
		data = new int[size];
		data[1]=root;
	}
	public NodeArray(int root,int size) {
		this.size=size;
		data = new int[size];
		data[1]=root;
	}
	public void addNode(int adddata){
		int i=1;//初始化下标值为1，空出下标为0的数据
		while(true){
			if(data[i]>adddata){
				i=2*i;//左孩子的数据新增
				if(data[i]==0){
					data[i]=adddata;
					break;
				}
			}else {
				i=2*i+1;
				if(data[i]==0){
					data[i]=adddata;
					break;
				}
			}
		}
	}
	public void display(){
		for (int i = 0; i < size; i++) {
			System.out.println("data["+i+"]="+data[i]);
		}
	}
	
	public static void main(String[] args) {
		NodeArray tree = new NodeArray(10);
		tree.addNode(8);
		tree.addNode(7);
		tree.addNode(20);
		tree.addNode(90);
		tree.addNode(100);
		tree.addNode(3);
		tree.addNode(6);
		tree.addNode(1);
		tree.addNode(-10);
		tree.display();
	}
}
