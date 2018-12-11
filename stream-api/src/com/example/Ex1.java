package com.example;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class MyList<E> implements Iterable<E> {
	// ..
	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {
			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public E next() {
				// TODO Auto-generated method stub
				return null;
			}
		};
	}
}

public class Ex1 {

	public static void main(String[] args) {

		List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		// --------------------------------------------
		// External Iteration
		// --------------------------------------------

		// ------------------------------------------
		// way-1
		// ------------------------------------------
//		int result = 0;
//		for (int i = 0; i < integers.size(); i++) {
////			System.out.println(integers.get(i));
//			int e = integers.get(0);
//			if (e % 2 == 0)
//				result += e;
//		}
//		System.out.println(result);

		// ------------------------------------------
		// way-2: iterable
		// ------------------------------------------
//		Iterator<Integer> iterator = integers.iterator();
//		while (iterator.hasNext()) {
//			Integer e = (Integer) iterator.next();
//			System.out.println(e);
//		}

		// ------------------------------------------
		// way-3: for-each loop
		// ------------------------------------------

//		for (Integer e : integers) {
//			System.out.println(e);
//		}
//
//		MyList<String> myList = new MyList<String>();
//
//		for (String e : myList) {
//			//
//		}

		// ------------------------------------------
		// problems with external iteration
		// ------------------------------------------

		/*
		 * => always sequential 
		 * => imperative style , no easy to read & refactor 
		 * => many immutable variables, leads to race-condition issue in concurrent world
		 */

		// ------------------------------------------
//		// Internal iteration by  stream API
		// ------------------------------------------
		
//		
//		integers
//		.stream()
//		//.parallel()
//		.filter(e->e%2==0)
//		.forEachOrdered(e->System.out.println(e));
		
		
		//--------------------------------------------
		

	}

}
