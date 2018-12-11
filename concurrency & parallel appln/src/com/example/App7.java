package com.example;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class App7 {

	public static void main(String[] args) {

		Callable<String> foodTask = () -> {
			System.out.println("start preparing food");
			TimeUnit.SECONDS.sleep(3);
			System.out.println("Food ready....");
			// return "BIRYANI";
			throw new IllegalArgumentException("oops, no biryani");
		};

		ExecutorService executorService = Executors.newFixedThreadPool(2);
		Future<String> future = executorService.submit(foodTask);

		System.out.println("is going to wait for food..");

		try {
			String food = future.get();
			System.out.println("main-thread, yummy -" + food);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

	}

}
