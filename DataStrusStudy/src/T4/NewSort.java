package T4;

import java.util.Random;

import T5.sort.BSort1;
import T5.sort.QuickSort;

public class NewSort {
	int data[];

	public NewSort() {
		data = new int[] { 10, 9, 3, 7, 6, 5, 4, -3, 2, 1 };
	}

	public NewSort(int data[]) {
		this.data = data;
	}

	public void sort() {
		int len = data.length;
		for (int group = len / 2; group > 0; group /= 2) {
			for (int i = 0; i < len / 2; i++) {
				for (int j = 0; j < len / 2; j++) {
					change(data, i, j);
				}
			}
			for (int i = len / 2; i < len; i++) {
				for (int j = len / 2; j < len; j++) {
					change(data, i, j);
				}
			}
		}
		for (int i = 0; i < len - 1; i++) {
			for (int j = i + 1; j <= len - 1; j++) {
				change(data, i, j);
			}
		}
	}

	public void change(int data[], int i, int j) {
		if (data[i] > data[j]) {
			int temp = data[i];
			data[i] = data[j];
			data[j] = temp;
		}
	}

	public void print() {
		for (int i : data) {
			System.out.print(i + "\t");
		}
	}

	public static void main(String[] args) {
		int data[] = new int[10000];
		int len = data.length;
		Random r = new Random();
		for (int i = 0; i < len; i++) {
			data[i] = r.nextInt();
		}
		long oldtime = System.currentTimeMillis();
//		NewSort ns = new NewSort(data);
//		ns.sort();
//		ns.print();
//		BSort1 bs = new BSort1(data);
//		bs.sort();
//		bs.print();
		QuickSort qs = new QuickSort(data);
		qs.sort(data, 0, data.length-1, data.length);
		for (int i : data) {
			System.out.print(i + "\t");
		}
		System.out.println("\n程序共花费时间："
				+ (System.currentTimeMillis() - oldtime) + "毫秒");
	}
}
