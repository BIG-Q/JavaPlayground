package com.java8;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class Java8Streams {
	public static void main(String[] args) {
		List<String> strList = Arrays.asList("abc", "", "bcd", "", "defg", "jk");
		
		long count = strList.stream().filter(x -> x.isEmpty()).count();
		
		long num  = strList.stream().filter(x -> x.length() > 3).count();
		
		List<String> filtered = strList.stream().filter( x -> !x.isEmpty()).collect(Collectors.toList());
		
		List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.","Canada");
		
		String joinedStr = G7.stream().map(x -> x.toUpperCase()).collect(Collectors.joining(", "));
		System.out.println(joinedStr);
		
		List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
		
		IntSummaryStatistics stats = primes.stream().mapToInt((x) -> x).summaryStatistics();
		
		System.out.println("Highest prime number in List : " + stats.getMax());
        System.out.println("Lowest prime number in List : " + stats.getMin());
        System.out.println("Sum of all prime numbers : " + stats.getSum());
        System.out.println("Average of all prime numbers : " + stats.getAverage());
	}
}
