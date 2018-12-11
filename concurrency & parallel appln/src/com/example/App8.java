package com.example;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class App8 {

	public static void main(String[] args) throws InterruptedException {

		ForkJoinPool forkJoinPool = new ForkJoinPool(8);

		forkJoinPool.submit(()->{
				Thread thread=Thread.currentThread();
				System.out.println(thread.getName());
		});
		
		forkJoinPool.awaitTermination(20, TimeUnit.SECONDS);
	}

}
