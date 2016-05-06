package interview;

//动态规划，算出最长递增子序列 ，可以不连续

public class LongestIncreasingSubsequence1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] data = {5, 3, 4, 8, 6, 7, 8};
		System.out.println(longestIncreasingSubsequence(data, data.length));
	}
	/**
     * Seq为序列
     * n为序列长度
     * 状态方程：d[i]
     * 状态转移方程：d[i] = {d[j] + 1}(j < i, if(seq[j] < seq[i]))
     * return max{d[i]}
     * */
    public static int longestIncreasingSubsequence(int[] Seq, int n) {
        int[] d = new int[n];
        int max = 0;
        for(int i = 0; i < n; i++) {
            d[i] = 1;
            for(int j = i; j >= 0; j--) {
                if((Seq[i] > Seq[j])) {
                    d[i] = d[j] + 1;
                    break;
                }
            }
            if(max < d[i]) {
                max = d[i];
            }        
        }
        return max;
                                                                                                                  
    }

}
