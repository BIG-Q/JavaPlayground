package com.java8;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
	public static int findMaxLength(int[] nums) {
		if (nums == null || nums.length <= 1) {
			return 0;
		}

		int sum = 0, max = 0;
		
		Map<Integer, Integer> sumPos = new HashMap<Integer, Integer>();
		sumPos.put(0, -1);
		
		for(int i = 0; i < nums.length; i++){
			sum += 2*nums[i] -1;
			
			if(sumPos.containsKey(sum)){
				max = Math.max(max, i-sumPos.get(sum));
			}
			else {
				sumPos.put(sum, i);
			}
		}

		return max;
	}

	public static void main(String[] args) {
		int[] nums = { 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 1, 0, 1, 1, 1,1 };

		findMaxLength(nums);
	}
}
