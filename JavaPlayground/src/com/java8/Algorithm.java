package com.java8;

import java.util.HashMap;
import java.util.Map;


public class Algorithm {
	public static void main(String[] args) {
		int[] nums = {0, 3, 2, 0};
		twoSum(nums, 0);		
	}

	public static int[] twoSum(int[] nums, int target) {
	        Map<Integer,Integer> valToIndice = new HashMap<Integer, Integer>();
			
	        for(int i = 0; i < nums.length; i++){
	        	int component = target - nums[i]; 
	        			
	        	if(valToIndice.containsKey(component)) {	        		
	        		return new int[]{nums[component], i};
	        	}
	        	
	        	valToIndice.put(nums[i], i);
	        }
		
	        return null;
	    }
}
