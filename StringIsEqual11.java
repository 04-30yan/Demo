package interview;

import java.util.Scanner;


//�ж�һ���ַ����е�����Ԫ���Ƿ񶼲���ͬ

public class StringIsEqual11 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		int[] container;
		int count = 0;
	    if(str != null & str !="") {
	    	container = new int[256];//����ֱ��ʹ��boolean[] container = new boolean(256);Ĭ�ϳ�ʼ��Ϊfalse��û�г��ֹ���Ϊtrue
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
