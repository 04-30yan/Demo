package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ArrayCopy {
	
	int i = 0;
	int j = 1;
	//为什么这里是不可以的 进行赋值 把下面的这句话注释就ok
	//但是在函数里面就OK，虽然一般不会这么写但是为什么？编译器规定？=>都不是函数 编译器都不知道什么时候执行
	//i = j;
	
	public static void main(String[] args){
		int[] a = {4,7,9,7,6,7};
				
		int[] b = {5,0,0,6,1,6,2,2,4};
		System.out.println(Arrays.toString(intersect(a,b)));
	}
	
	 public static int[] intersect(int[] nums1, int[] nums2) {
	        HashMap<Integer, Integer> numMap = new HashMap<>();
	        ArrayList<Integer> result = new ArrayList<>();
	        int[] maxNum = nums1;
	        
	        if(nums1.length < nums2.length) {
	           maxNum = nums2;
	           nums2 = nums1;
	        }
	        
	        for(int i = 0; i < maxNum.length; i++) {
	            if(numMap.containsKey(maxNum[i]))
	                numMap.put(maxNum[i], numMap.get(maxNum[i]) + 1);
	            else
	                numMap.put(maxNum[i], 1);
	        }
	        
	        for(int i = 0; i < nums2.length; i++) {
	           if(numMap.containsKey(nums2[i]) && (numMap.get(nums2[i]) > 0)) {
	               result.add(nums2[i]);
	               numMap.put(nums2[i], numMap.get(nums2[i]) - 1);
	           }
	        }
	        
	        int[] r = new int[result.size()];
	        for(int i = 0; i < result.size(); i++) {
	            r[i] = result.get(i);
	        }
	        
	        return r;
	    }
}
