package interview;

import java.util.Arrays;
import java.util.Scanner;

//二分查找

public class BinarySearch {

	public static void main(String[] args) {
		int[] p = { 6, 9, 55, 56, 66, 66, 78, 564 };
		Scanner scanner = new Scanner(System.in);
		int key = scanner.nextInt();
		System.out.print(BinarySearch.binarySearch(p, key));  
	}
	public static int binarySearch(int[] a, int key) {
		int length = a.length;
		int low = 0;
        int high = length - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            Comparable<Integer> midVal = (Comparable<Integer>)a[mid];
            int cmp = midVal.compareTo(key);

            if (cmp < 0)
                low = mid + 1;
            else if (cmp > 0)
                high = mid - 1;
            else
                return mid; // key found
        }
        return -(low + 1);  // key not found.
	}

}
