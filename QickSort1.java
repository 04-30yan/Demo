/**
 * 
 */
package interview;

import java.util.Arrays;

/**
 * @version 2 
 * 修复死循环
 */
public class QickSort1 {

	public static void main(String[] args) {
		//18个
		int[] p = { 72, 6, 57, 88, 60, 42, 38, 83, 45, 73, 27, 83, 11, 20, 79,  
                30, 45, 41 };
		QickSort1.quickSort(p, 0, p.length - 1);
        System.out.print(Arrays.toString(p));  
	}
	
	public static void quickSort(int[] data, int start, int end) {  
		int key = data[start];
		int i = start;
		int j = end;
		while(i < j) {
				while(i < j && data[j] >= key) {
					j--;
				}
				data [i] = data[j];
				
				while(i < j && data[i] < key) {
					i++;
				}
				data[j] = data[i];
		}
		data[i] = key;
		if(i - 1 > start) {
			quickSort(data, start, i-1);
		}
		if(i + 1 < end) {
			quickSort(data, i + 1, end);
		}
	}
}

