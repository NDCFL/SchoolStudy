package Test;

public class InsertSortDemo {

	int data[];
	public InsertSortDemo() {
		data = new int[]{10,9,8,7,6,5,4,1,2,3};
	}
	public InsertSortDemo(int data[]) {
		this.data = data;
	}
	public void sort(){
		int temp=0,j=0;
		for(int i=0;i<data.length;i++){
			temp = data[i];
			j=i-1;
			while(j>=0 && data[j]>temp){
				data[j+1] = data[j];
				j--;
			}
			data[j+1]=temp;
		}
		
	}
	public void print(){
		for (int en : data) {
			System.out.print(en+"\t");
		}
	}
	public static void main(String[] args) {
		InsertSortDemo is = new InsertSortDemo();
		is.sort();
		is.print();
	}
	
}
