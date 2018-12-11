package com.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App5 {

	public static void main(String[] args) throws InterruptedException {

		// JDK 1.5

		// Executor/Thread-pool Framework
		// ==> separates thread management from application code

		ExecutorService executorService = Executors.newCachedThreadPool();

		Runnable task = () -> {
			String name = Thread.currentThread().getName();
			System.out.println(name + " started task..");
			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(name + " finised task..");
		};

		for (int i = 0; i < 5; i++) {
			executorService.submit(task);
		}

		
		executorService.awaitTermination(20, TimeUnit.SECONDS);
		executorService.shutdown();

	}

}
