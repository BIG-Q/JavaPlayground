package com.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	public static void main(String[] args) {
		int[] nums = { -4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};

		threeSum(nums);
		
		
	}

	public static List<List<Integer>> threeSum(int[] nums) {
List<List<Integer>> rs = new ArrayList<List<Integer>>();
        
        if(nums == null || nums.length < 3){
            return rs;
        }
        
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length-2;i++){
            if(i == 0 || nums[i] != nums[i-1]){
            	int low = i+1;
            	int high = nums.length -1;
            	
            	int sum = 0 - nums[i];
            	
            	while(low < high){
            		int add = nums[low] + nums[high];
            		
            		if(add == sum){
            			rs.add(Arrays.asList(nums[i], nums[low], nums[high]));
            			
            			while(low < high && nums[low] == nums[low+1]){
            				low++;
            			}
            			
            			while(low < high && nums[high] == nums[high-1]){
            				high--;
            			}
            			
            			low++;
            			high--;
            		}
            		else if(add < sum){
            			low++;
            		}
            		else {
            			high--;
            		}
            	}            	
            }
        }
        
        return rs;
	}
}
