package T5.sort;

import java.util.Arrays;
public class RadixSort {
	public static void main(String[] args) {  
        Integer[] array = new Integer[] { 1200, 292, 121, 72, 233, 44, 12 };  
        radixSort(array, 10, 4);  
        System.out.println("排序后的数组：");  
        print(array);  
    }    
    public static void radixSort(Integer []array, int radix, int d){
        Integer[] tempArray = new Integer[array.length];  
        Integer[] count = new Integer[radix];  
        int rate = 1;
        for (int i = 0; i < d; i++) {  
            Arrays.fill(count, 0);
            System.arraycopy(array, 0, tempArray, 0, array.length);  
            for (int j = 0; j < array.length; j++) {  
                int subKey = (tempArray[j] / rate) % radix;  
                count[subKey]++;
            }  
            for (int j = 1; j < radix; j++) {  
                count[j] = count[j] + count[j - 1]; 
            }  
            for (int m = array.length - 1; m >= 0; m--) {  
                int subKey = (tempArray[m] / rate) % radix;  
                array[--count[subKey]] = tempArray[m]; 
            }  
            rate *= radix;   
            System.out.print("第" + (i+1) + "次：");
            print(array);
        }  
    }
    public static void print(Integer[] array) {  
        for (int i = 0; i < array.length; i++) {  
            System.out.print(array[i] + "\t");  
        }  
        System.out.println();  
    }  
}
