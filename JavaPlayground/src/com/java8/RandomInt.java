package com.java8;

import java.util.Random;

public class RandomInt {
	public static void main(String[] args) {
		Random ran  = new Random();
		
		int i = ran.nextInt(1);
		
		System.out.println("i = "  + i);
		
		i = ran.nextInt(1);
		
		System.out.println("i = "  + i);
		
		i = ran.nextInt(1);
		
		System.out.println("i = "  + i);
		
		i = ran.nextInt(2);
		
		System.out.println("i = "  + i);
	}
}
