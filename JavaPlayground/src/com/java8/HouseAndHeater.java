package com.java8;

import java.util.Arrays;

public class HouseAndHeater {
	public static void main(String[] args) {
		int[] houses = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20, 40, 38, 27, 33};
		int[] heaters= {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20, 40, 38, 27, 33};
		
		int result = findRadius(houses, heaters);
		
		System.out.println(result);
	}
	
    public static int findRadius(int[] houses, int[] heaters) {
        int radius = -1;
        
        Arrays.sort(houses);
        Arrays.sort(heaters);
        
        int j = 0;
        for(int i=0;i < houses.length;i++){
            while(j < heaters.length -1 && Math.abs(houses[i] - heaters[j]) >= Math.abs(houses[i] - heaters[j+1])){
                j++;
            }
            
            radius = Math.max(radius, Math.abs(houses[i] - heaters[j]));
        }
        
        return radius;
    }
}
