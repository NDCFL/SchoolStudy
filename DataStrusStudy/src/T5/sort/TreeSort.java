package T5.sort;

public class TreeSort {

	int data[];
	public TreeSort() {
		data = new int[]{10,9,3,7,6,5,4,8,2,1};
	}
	public TreeSort(int data[]) {
		this.data=data;
	}
	//打印函数
	public void print(){
		for (int i : data) {
			System.out.print(i+"\t");
		}
	}
	//交换函数
	public void change(int data[],int min,int max){
		int temp=data[min];
		data[min]=data[max];
		data[max]=temp;
	}
	public void initTree(){
		int length = data.length-1;
		boolean ischange=false;
		for(int i=(length-1)/2;i>=0;i--){
			int leftChild=2*i+1;
			int rightChild=leftChild+1;
			int max;
			if(leftChild<=length){
				max=leftChild;
				if(rightChild<=length){
					if(data[leftChild]<data[rightChild]){
						max=rightChild;
					}
				}
				if(data[max]>data[i]){
					ischange=true;
					change(data, max, i);
				}
			}
		}
		if(ischange){
			//递归初始化
			initTree();
		}
	}      
	public void sort(){
		int len = data.length-1;
		//初始化堆
		initTree();
		//交换头结点和子节点
		change(data,0,len);
		for(int i=len;i>1;i--){
			int index=0;
			//有左孩子的情况
			while(2*index+1<i){
				if(2*index+2<i){
					//头结点如果小于左孩子
					int max=index;
					if(data[max]<data[2*index+1]){
						max=2*index+1;
					}
					if(data[max]<data[2*index+2]){
						max=2*index+2;
					}
					//表明不是同一个节点就进行交换
					if(max!=index){
						change(data, index, max);
						index=max;
					}else {
						break;
					}
				}
				//无左孩子，有右孩子的情况
				if(2*index+1<i && 2*index+2>=i){
					if(data[index]<data[2*index+1]){
						change(data, index, 2*index+1);
					}else {
						break;
					}
				}
			}
			change(data, 0, i-1);
		}
	}
	public static void main(String[] args) {
		TreeSort ts = new TreeSort();
		ts.initTree();
		ts.sort();
		ts.print();
	}
}
