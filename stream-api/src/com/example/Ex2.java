package com.example;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class Ex2 {

	public static void main(String[] args) {

		// How to create stream ?

		// -----------------------------------------------
		// way-1: from individual elements
		// -----------------------------------------------

//		Stream.of(1,2,3,4,5,6,7,8,9,10)
//		.forEach(System.out::println);

		// -----------------------------------------------
		// way-2: from array
		// -----------------------------------------------

//		Integer[] integers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };
//		Arrays.stream(integers).forEach(System.out::println);

		// -----------------------------------------------

		// -----------------------------------------------
		// way-3: from collections
		// -----------------------------------------------

//		List<Integer> list=Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0 );
//		list
//		.stream()
//		.forEach(System.out::println);

		// -----------------------------------------------

		// -----------------------------------------------
		// way-4: from computation
		// -----------------------------------------------

		// a. generate

//		Random random = new Random();
//		Stream<Integer> stream=Stream.generate(() -> {
//			return random.nextInt();
//		});
//		
//		
//		stream
//		.peek(e->System.out.println("before filter : "+e))
//		.filter(e->e>0)
//		.peek(e->System.out.println("after filter : "+e))
//		.limit(10)
//		.forEach(System.out::println); // terminal operation

		
		// b. iterate
//		
//		Stream
//		.iterate(0, e->e+1)
//		.limit(10)
//		.forEach(System.out::println);
//		
		

	}

}
