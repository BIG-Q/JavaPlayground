package com.java8;

public class ValidPerfectSquare {
	public static void main(String[] args) {
		boolean rs = isPerfectSquare(808201);
	}
	
	public static boolean isPerfectSquare(int num) {
        long start = 1;
        long end = num;
        
        while(start <= end) {
            long target = (end + start) >>> 1;
            
            long square = target * target;
            
            if(square == num) {
                return true;
            }
            else if(square > num || square < 0){
                end = target-1;
            }
            else {
                start = target+1;
            }
        }
        
        return false;
    }
}
