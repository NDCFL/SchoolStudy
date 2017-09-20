package T5.sort;


public class insert_sort {

	int data[];
	public insert_sort() {
		data = new int[]{10,9,3,7,6,5,4,-3,2,1};
	}
	public insert_sort(int data[]) {
		this.data=data;
	}
	public void print(){
		for (int i : data) {
			System.out.print(i+"\t");
		}
	}
	public void sort(int data[]){
		int temp,j,k=0;
		for(int i=0;i<data.length;i++){
			temp=data[i]; 
			j=i-1;
			while(j>=0 && data[j]>temp){
				data[j+1]=data[j];
				j--;
				System.out.println("\n第"+(++k)+"次排序");
				print();
				System.out.println();
			}
			System.out.println("------------------------------------");
			data[j+1]=temp;
			print();
		}
	}
	public static void main(String[] args) {
		insert_sort is = new insert_sort();
		System.out.println("源数据");
		is.print();
		long oldtime = System.currentTimeMillis();
		System.out.println("\n排序后的数据");
		is.sort(is.data);
		System.out.println("\n程序共花费时间："+(System.currentTimeMillis()-oldtime)+"毫秒");
	}
}
