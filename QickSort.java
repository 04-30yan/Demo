package interview;

import java.util.Arrays;

//快速排序


/**
 * @version 1
 * 这个测试用例有重复的数字，在某次子循环中data[start] == data[end],导致循环比较，退不出循环，一直运行
 * QickSort1解决
 */
public class QickSort {

	public static void main(String[] args) {
		//18个
		int[] p = { 72, 6, 57, 88, 60, 42, 38, 83, 45, 73, 27, 83, 11, 20, 79,  
                30, 45, 41 };
		QickSort.quickSort(p, 0, p.length - 1);
        System.out.print(Arrays.toString(p));  
	}
	
	public static void quickSort(int[] data, int start, int end) {  
		int key = data[start];
		int i = start;
		int j = end;
		while(i < j) {
			while(data[j] > key && i < j) {
				j--;
			}
			data [i] = data[j];
			while(data[i] < key && i < j) {
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
