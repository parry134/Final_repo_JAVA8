package com.example;

import java.util.stream.IntStream;

public class Ex3 {

	public static boolean isEven(int n) {
		Thread thread=Thread.currentThread();
		System.out.println(thread.getName() +" filtering " + n);
		return n % 2 == 0;
	}

	public static int tranform(int n) {
		Thread thread=Thread.currentThread();
		System.out.println(thread.getName() + " tranforming " + n);
		return n*n;
	}

	public static void main(String[] args) {

		
		System.out.println(Runtime.getRuntime().availableProcessors());
		
//		stream ==> build/create --> intermediate-op1  --> intermediate-op2 --> terminal-operation

		//build
		IntStream intStream = IntStream.of(1, 2, 3, 5, 4, 7, 6); 

		// compose with as many intermediate operations
		intStream=intStream
					.filter(Ex3::isEven)
					.map(Ex3::tranform)
					.limit(2);
			
		//terminal operation
		intStream
		//.parallel()
		.forEach(System.out::println);
		
//		intStream
//		.forEach(System.out::println);  // error , stream already closed
		

	}

}
