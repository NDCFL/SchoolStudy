package T6;

import java.util.Arrays;


public class TwoFind {

	int data[];
	public TwoFind() {
		data = new int[]{10,9,3,7,6,5,4,-9,2,53,43,544,35,4654,46,456,546,546,546,345,433,453,3,45,3,354,3,35,345,5,4,45,123,234,2234,234,2342,34,23,42,4,23,42,34,23,5434545,6,353456,43,46,4356,456,43,4,56,45,6,456,454,6757,756,5,6754,4567,456756,7,5675,567,567,56,7,567,5,67,5,67,56,7,6,6,454,546,45,4,45,456,45,46,54,65,4,56,65,45,6,457,854,4,54,548,45,7,8,74,6,57,58,65,-41,54,5,5,545,65,};
	}
	public TwoFind(int data[]) {
		this.data=data;
	}
	public void find(int value){
		int left=0;
		int right = data.length-1;
		int mid=0;
		mid=(left+right)/2;
		if(data[left]==value){
			System.out.print("在第"+1+"个位置找到了该数据！");
			System.err.print(value);
			return;
		}
		if(data[right]==value){
			System.out.print("在第"+right+"个位置找到了该数据！");
			System.err.print(value);
			return;
		}
		if(data[mid]==value){
			System.out.print("在第"+mid+"个位置找到了该数据！");
			System.err.print(value);
			return;
		}
		for(int group=right/2;group>0;group/=2){
			for(int i=group;i<=right;i++){
				for(int j=i-group;j>=0;j-=group){
					if(data[j]==value){
						System.out.print("在第"+j+"个位置找到了该数据！");
						System.err.print(value);
						return;
					}
				}
			}
		}
		System.out.println("没有该数据");
	}
	public static void main(String[] args) {
		TwoFind f = new TwoFind();
		f.find(-41);
	}
}
