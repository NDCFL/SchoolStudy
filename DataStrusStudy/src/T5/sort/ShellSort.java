package T5.sort;

public class ShellSort {

	int data[];
	public ShellSort() {
		data = new int[] { 10, 9, 3, 7, 6, 5, 4, -3, 2, 1 };
	}
	public ShellSort(int data[]) {
		this.data = data;
	}
	public void sort() {
		int temp, len = data.length;
		for (int group=len/2;group>0;group/=2) {
			for (int i=group;i<len;i++) {
				for (int j=i-group;j>=0;j-=group) {
					if (data[j]>data[j+group]) {
						temp = data[j];
						data[j] = data[j+group]; 
						data[j+group] = temp;
						System.out.print("j="+j+";i="+i+";group="+group+"\n");
						play();
						System.out.println();
					}
				}
			}
			System.out.println("-----------------------------------------");
		}
	}
	public void play(){
		for (int p : data) {
			System.out.print(p+"\t");
		}
	}
	public static void main(String[] args) {
		ShellSort ss = new ShellSort();
		long oldtime = System.currentTimeMillis();
		ss.sort();
		ss.play();
		System.out.println("\n程序共花费时间："+(System.currentTimeMillis()-oldtime)+"毫秒");
	}
}
