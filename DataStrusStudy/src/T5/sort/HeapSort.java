package T5.sort;


public class HeapSort {
	int data[];

	public HeapSort() {
		data = new int[] { 8, 19, 2, 3, 100, 99, 1000, 888, -1, 0 };
	}

	public HeapSort(int data[]) {
		this.data = data;
	}

	// 堆排序
	public void sort() {
		int len = data.length - 1;
		initTree(len);// 初始化稳定堆
		change(data, 0, len);// 交换第一个元素和本轮最后一个元素
		// 二叉树排序
		for (int i=len;i>1;i--) {// 循环length - 2次
			int index=0;
			while (2*index+1<i) {// 只要有左孩子节点就可能产生交换，进入循环
				if (2*index+2<i) {// 左右孩子都有
					int max = index; // 默认是父节点的下标
					if (data[max] < data[2 * index + 1]) {
						max = 2 * index + 1; // 返回左孩子的下标
					}
					if (data[max] < data[2 * index + 2]) {
						max = 2 * index + 2; // 返回右孩子的下标
					}
					if (max != index) {
						change(data, index, max);
						index = max;
					} else {
						break;// max==index，表示节点最大，下面的堆都是稳定的，不用继续循环
					}
				}
				if (2 * index + 1 < i && 2 * index + 2 >= i) {// 只有左孩子，没有右孩子
					if (data[index] < data[2 * index + 1]) {
						change(data, index, 2 * index + 1);
					} else {
						break;// 2 * index + 1==index，表示节点最大，下面的堆都是稳定的，不用继续循环
					}
				}
			}
			print();
			change(data, 0, i - 1);// 交换第一个元素和本轮最后一个元素
			print();
		}
	}
	//初始化堆
	public void initTree(int len){
		int length = len-1;
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
			initTree(len);
		}
	}

	// 交换数组中两个数的方法，因为要多次用到，封装成一个方法；
	public void change(int[] a, int min, int max) {
		int temp = a[min];
		a[min] = a[max];
		a[max] = temp;
	}

	public void print() {
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + "\t");
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		HeapSort sort = new HeapSort();
		System.out.println("排序之前：");
		sort.print();
		System.out.println("========================");
		sort.initTree(sort.data.length);
		sort.sort();
		sort.print();
	}
}
