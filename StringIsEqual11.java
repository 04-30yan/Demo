package interview;

import java.util.Scanner;


//判断一个字符串中的所有元素是否都不相同

public class StringIsEqual11 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		int[] container;
		int count = 0;
	    if(str != null & str !="") {
	    	container = new int[256];//考虑直接使用boolean[] container = new boolean(256);默认初始化为false，没有出现过设为true
	    	for(int i = 0; i < str.length(); i++) {
				int hash = str.charAt(i);
				int j = hash % 256;
				if(container[j] == 0) {
					container[hash % 256] = hash;
				}
				else{
					count = -1;
					break;
				}
			}
	    }
	}
}
