package T6;


public class FindValue {

	int data[];
	public FindValue() {
		data = new int[]{10,9,3,7,6,5,4,9,2,1};
	}
	public FindValue(int data[]) {
		this.data=data;
	}
	public void findvalue(int temp){
		for(int i=0;i<data.length;i++){
			if(data[i]==temp){
				System.err.print(temp);
				System.out.print("在第"+(i+1)+"个位置找到了");
				return;
			}
		}
		System.err.println("数据中没有你要查找的数据！");
	}
	public static void main(String[] args) {
		FindValue f = new FindValue();
		f.findvalue(5);
	}
}
