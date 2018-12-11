package com.example;

import java.util.Arrays;
import java.util.List;


/*
 * 
 * 
 * 
 */

public class App9 {
	
	public static boolean isEven(int n) {
		Thread thread=Thread.currentThread();
		System.out.println(thread+ " : filtering "+n);
		return n%2==0;
	}
	public static int tranform(int n) {
		Thread thread=Thread.currentThread();
		System.out.println(thread+ " : mapping "+n);
		return n*n;
	}

	public static void main(String[] args) {

		// java-8 : parallel-stream

		List<Integer> integers = Arrays.asList(
				1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
				11, 22, 33, 44, 55, 66, 77, 88, 99, 100
				);
		
		System.out.println(
		
				integers
				//.parallelStream()
				.stream()
				.parallel()
				.filter(App9::isEven)
				.mapToDouble(App9::tranform)
				.sum()

				
		);
		

	}

}
