package test;

public class LongestCommonSubstr {
	public static void main(String[] args) {
		String str1 = "13399";
		String str2 = "882339";
		System.out.println(getLCSLen(str1, str2));
		
		
	}
	
	public static int getLCSLen(String str1, String str2) {
		int lenMax = 0;
		int end1 = 0;
		String result = "";
		if((str1 == null || str1.equals("")) || (str2 == null || str2.equals(""))) {
			return 0;
		}else {
			char[] cStr1 = str1.toCharArray();
			char[] cStr2 = str2.toCharArray();
			int len1 = cStr1.length;
			int len2 = cStr2.length;
			int[][] len = new int [len1 + 1][len2 + 1];
			
			for(int i = 1; i <= len1; i++) {
				for(int j = 1; j <= len2; j++) {
					if (cStr1[i - 1] == cStr2[j - 1]) {
						len[i][j] = len[i - 1][j - 1] + 1;
					}
					if(lenMax < len[i][j]) {
						lenMax = len[i][j];
						end1 = i; 
					}
				}	
			}
			

			result = str1.substring(end1-lenMax, end1);
			System.out.println(result);
			
		}
		
		
		return lenMax;
	}
}
