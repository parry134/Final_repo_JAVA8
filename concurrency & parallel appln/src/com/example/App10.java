package com.example;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/*
 *  how many threads i can create ?
 *  
 *  
 *  
 *   ==> for computational intensive work...
 *   ==> for IO intensive work
 *   
 *   
 *   
 *   			       # of cores			
 *   # of threads <=  ------------  
 *                     blocking-factor
 *   
 *                       
 *   
 *  0 < blocking-factor < 1
 *     
 *     
 * 
 * 
 */

class Ex {

	public static double doComputation(int n) {
		double result = 0;
		for (int i = 0; i < 10000; i++) {
			for (int j = 0; j < 1000; j++) {
				result += Math.sqrt(n);
			}
		}
		return result;
	}

} 

public class App10 {

	public static void main(String[] args) throws InterruptedException {
		
		ForkJoinPool forkJoinPool=new ForkJoinPool(1000);
		
		
				
		forkJoinPool.submit(()->{
			System.out.println(
			IntStream.range(1, 1000)
			.parallel()
			.mapToDouble(Ex::doComputation)
			.sum()
			);
		});
			
	   
		
		forkJoinPool.awaitTermination(15,TimeUnit.SECONDS);

	}

}
