package T4;


public class TreeDemo {

	int data;
	TreeDemo left;
	TreeDemo right;
	public TreeDemo(int data) {
		this.data =data;
		this.left =null;
		this.right=null;
	}
	public static TreeDemo addnode(int input[]){
		TreeDemo root = null;
		TreeDemo tempDemo=null;
		for (int i = 0; i < input.length; i++) {
			if(root==null){
				root=tempDemo=new TreeDemo(input[i]);
			}else {
				tempDemo=root;
				while(tempDemo.data!=input[i]){
					if(input[i]<tempDemo.data){
						if(tempDemo.left!=null){
							tempDemo=tempDemo.left;
						}else {
							tempDemo.left=new TreeDemo(input[i]);
						}
					}else {
						if(tempDemo.right!=null){
							tempDemo=tempDemo.right;
						}else {
							tempDemo.right=new TreeDemo(input[i]);
						}
					}
				}
			}
		}
		return root;
	}
	public static void preorder(TreeDemo tree){
		if(tree!=null){
			System.out.print(tree.data+"   ");
			preorder(tree.left);
			preorder(tree.right);
		}
	}
	public  static void midorder(TreeDemo tree){
		if(tree!=null){
			midorder(tree.left);
			System.out.print(tree.data+"   ");
			midorder(tree.right);
		}
	}
	public static void posorder(TreeDemo tree){
		if(tree!=null){
			posorder(tree.left);
			posorder(tree.right);
			System.out.print(tree.data+"   ");
		}
	} 
	public static void main(String[] args) {
		int[] input = { 1,2,3,4,5,6,7};
		TreeDemo t = addnode(input);
		System.out.print("先根遍历如下：");
		preorder(t);
		System.out.print("\n中根遍历如下：");
		midorder(t);
		System.out.print("\n后根遍历如下：");
		posorder(t);
	}
}
