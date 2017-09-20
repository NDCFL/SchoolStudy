package T5.sort;

public class Select_Sort {

	int data[];
	public Select_Sort() {
		data = new int[]{10,9,3,7,6,5,4,9,2,1};
	}
	public Select_Sort(int data[]) {
		this.data=data;
	}
	public int getminindex(int data[],int firstindex){
		int index=firstindex;
		int min=data[firstindex];
		for(int i=firstindex;i<data.length ;i++){
			if(data[i]<min){
				min=data[i];
				index=i;
			}
		}
		return index;
	}
	public void sort(int data[]){
		int temp;
		for(int i=0;i<data.length;i++){
			int index=getminindex(data, i);
			System.out.println("第"+(i+1)+"次排序");
			if(index!=i){
				temp=data[index];
				data[index]=data[i];
				data[i]=temp;
			}
			print();
			System.out.println();
		}
		
	}
	public void print(){
		for (int i : data) {
			System.out.print(i+"\t");
		}
	}
	public static void main(String[] args) {
		Select_Sort ss = new Select_Sort();
		System.out.println("源数据如下");
		ss.print();
		long oldtime = System.currentTimeMillis();
		System.out.println("\n排序后的数据如下");
		ss.sort(ss.data);
		System.out.println("排序共花费时间："+(System.currentTimeMillis()-oldtime)+"毫秒");
	}
}
