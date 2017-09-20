package T5.sort;

public class MergeSort{
	int a[];
	public MergeSort() {
		a = new int[]{8,19,2,3,100,99,1000,888,-1,0};
	}
	public MergeSort(int a[]) {
		this.a = a;
	}
	public void Merge(int[] array, int low, int mid, int high) {
	    int i = low; 
	    int j = mid + 1; 
	    int k = 0; 
	    int[] array2 = new int[high - low + 1]; 
	    while (i <= mid && j <= high) {
	        if (array[i] <= array[j]) {
	            array2[k] = array[i];
	            i++;
	            k++;
	        } else {
	            array2[k] = array[j];
	            j++;
	            k++;
	        }
	    }
	    while (i <= mid) {
	        array2[k] = array[i];
	        i++;
	        k++;
	    }
	    while (j <= high) {
	        array2[k] = array[j];
	        j++;
	        k++;
	    }
	    for (k = 0, i = low; i <= high; i++, k++) {
	        array[i] = array2[k];
	    }
	}
	public void MergePass(int[] array, int gap, int length) {
	    int i = 0;
	    for (i = 0; i + 2 * gap - 1 < length; i = i + 2 * gap) {
	        Merge(array, i, i + gap - 1, i + 2 * gap - 1);
	    }
	    if (i + gap - 1 < length) {
	        Merge(array, i, i + gap - 1, length - 1);
	    }
	}

	public int[] sort(int[] list) {
	    for (int gap = 1; gap < list.length; gap = 2 * gap) {
	        MergePass(list, gap, list.length);
	        System.out.println("gap = " + gap + ":\t");
	    }
	    print();
	    return list;
	}
	public void print(){
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+"\t");
		}
		System.out.println("");
	}
	public static void main(String[] args) {
		MergeSort sort = new MergeSort();
		System.out.println("排序之前：");
		sort.print();
		System.out.println("========================");
		sort.sort(sort.a);
	}
}
