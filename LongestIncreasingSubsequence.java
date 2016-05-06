package interview;

//网上搜到一个，但是不懂原理，期待某天偶尔查看时能懂
public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] data = {5, 3, 4, 8, 6, 7};
		System.out.println(longestIncreasingSubsequence(data, data.length));
	}
	/**
     * Seq为序列
     * n为序列长度
     * */
    public static int longestIncreasingSubsequence(int[] Seq, int n) {
        int[] d = new int[n];
        int max = 0;
        for(int i = 0; i < n; i++) {
            d[i] = 1;
            for(int j = 0; j < i; j++) {
                if((Seq[i] > Seq[j]) && (d[j] + 1) > d[i]) {
                    d[i] = d[j] + 1;
                }
            }
            if(max < d[i]) {
                max = d[i];
            }        
        }
        return max;
    }
}
