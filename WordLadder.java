package test;

public class WordLadder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arr = new String[4];
		
		arr[0] = new String("adadddd");
		arr[1] = new String("dcccce");
		arr[2] = new String("gf");
		arr[3] = new String("ffk");
		System.out.println(test(arr));
	}
	
	public static int test(String[] arr) {
		int length = arr.length;
		int[] ends = new int[256];
		
		for(int i = 0; i < length; i++) {
			int strLength = arr[i].length();
			ends[arr[i].charAt(strLength - 1)]++;
		}
		
		int head = 0;
		for(int i = 0; i < length; i++) {
			if(ends[arr[i].charAt(0)] == 0 && head == 0) {
				ends[arr[i].charAt(0)]--;
				head++;
			}else if(ends[arr[i].charAt(0)] > 0) {
				ends[arr[i].charAt(0)]--;
			}else {
				return -1;
			}
			
		}
		/**
		for(int i = 0; i < 26; i++) {
			if(ends[i] < 0) {
				head++;
			}else if(ends[i] > 0) {
				end++;
			}
		}
		if(head <=1 && end <= 1) {
			return 1;
		}
		*/
		return 1;
	}
	
	

}
