package Test;

public class QuickSortDemo {

	int data[];
	public QuickSortDemo() {
		data = new int[]{10,9,8,7,6,5,4,1,2,3};
	}
	public QuickSortDemo(int data[]) {
		this.data = data;
	}
	public int getIndex(int leftindex,int rightindex){
		int temp = data[leftindex];
		while(leftindex<rightindex){
			while(leftindex < rightindex && data[rightindex]>temp){
				rightindex--;
			}
			if(leftindex<rightindex){
				data[leftindex++]=data[rightindex];
			}
			while(leftindex < rightindex && data[leftindex]<temp){
				leftindex++;
			}
			if(leftindex<rightindex){
				data[rightindex--]=data[leftindex];
			}
			data[leftindex]=temp;
		}
		return leftindex;
	}
	public void sort(int leftindex,int rightindex){
		int index = 0;
		if(leftindex<rightindex){
			index = getIndex(leftindex, rightindex);
			sort(leftindex, index-1);
			sort(index+1, rightindex);
		}
	}
	public void print(){
		for (int en : data) {
			System.out.print(en+"\t");
		}
	}
	public static void main(String[] args) {
		QuickSortDemo qs = new QuickSortDemo();
		qs.sort(0, qs.data.length-1);
		qs.print();
	}
}
