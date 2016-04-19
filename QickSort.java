package interview;

import java.util.Arrays;

//��������

public class QickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] p = { 72, 6, 57, 88, 60, 42, 38, 83, 45, 73, 27, 83, 11, 20, 79,  
                30, 45, 41 };
		QickSort.quickSort(p, 0, p.length - 1);
        System.out.print(Arrays.toString(p));  
	}
	
	public static void quickSort(int[] data, int start, int end) {  
		
        // һ�����ùؼ�����keyΪҪ��������ĵ�һ��Ԫ�أ�  
        // �ڿ�  ��data[start]�������ڳ���
        int key = data[start];  
        
        // ����������ߵ������������ƶ���key�����  
        int i = start;  
        
        // ���������ұߵ������������ƶ���keyС����  
        int j = end;  
        
        // �������������ұ�����С����������û������  
        while (i < j) {  
        	
        	//��С�ڻ��ߵ���key ������ղ��ڵ���� ���Ӧ�ñ�keyС ���ǴӴ�С���෴
            while (data[j] > key && j > i) {  
                j--;  
            }  
            //�ҵ������
            data[i] = data[j];  
  
            //�Ҵ��ڻ��ߵ���key ������д�ұߵĿ� �ҿ�Ӧ�ñ�key�� ͬ��
            while (data[i] < key && i < j) {  
                i++;  
            }  
            data[j] = data[i];  
        }  
        
        // ��ʱ i==j����key��˴�ѭ�������һ���� 
        data[i] = key;  
  
        // �ݹ����  
        if (i - 1 > start) {  
            // �ݹ���ã���keyǰ����������  
            quickSort(data, start, i - 1);  
        }  
        if (i + 1 < end) {  
            // �ݹ���ã���key������������  
            quickSort(data, i + 1, end);  
        }  
    }  

}
