package interview;

import java.util.Arrays;

//快速排序

public class QickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] p = { 72, 6, 57, 88, 60, 42, 38, 83, 45, 73, 27, 83, 11, 20, 79,  
                30, 45, 41 };
		QickSort.quickSort(p, 0, p.length - 1);
        System.out.print(Arrays.toString(p));  
	}
	
	public static void quickSort(int[] data, int start, int end) {  
		
        // 一般设置关键数据key为要排序数组的第一个元素，  
        // 挖坑  把data[start]的数据挖出来
        int key = data[start];  
        
        // 设置数组左边的索引，往右移动比key大的数  
        int i = start;  
        
        // 设置数组右边的索引，往左移动比key小的数  
        int j = end;  
        
        // 如果左边索引比右边索引小，则还有数据没有排序  
        while (i < j) {  
        	
        	//找小于或者等于key 的数填刚才挖的左坑 左坑应该比key小 若是从大到小则相反
            while (data[j] > key && j > i) {  
                j--;  
            }  
            //找到，填坑
            data[i] = data[j];  
  
            //找大于或者等于key 的数填写右边的坑 右坑应该比key大 同理
            while (data[i] < key && i < j) {  
                i++;  
            }  
            data[j] = data[i];  
        }  
        
        // 此时 i==j，拿key填此次循环的最后一个坑 
        data[i] = key;  
  
        // 递归调用  
        if (i - 1 > start) {  
            // 递归调用，把key前面的完成排序  
            quickSort(data, start, i - 1);  
        }  
        if (i + 1 < end) {  
            // 递归调用，把key后面的完成排序  
            quickSort(data, i + 1, end);  
        }  
    }  

}
