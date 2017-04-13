package com.java8;

public class ReverseInteger {
	public static int reverseInteger(int num){
		if(num / 10 == 0){
			return num;
		}
		
		String reverse = "";
		int left = num;
		
		while(left/10 > 0){
			int digit = left%10;
			if(digit != 0){
				reverse = reverse + digit;	
			}
			
			left = (left - digit) / 10;
		}
		
		reverse = reverse + left;
		
		return Integer.parseInt(reverse);
	}
	
	public static void main(String[] args) {
		int x = 123;
		int y = 3211;
		
		int z = 867921;
		
		System.out.println(reverseInteger(x));
		System.out.println(reverseInteger(y));
		System.out.println(reverseInteger(z));
	}
}
