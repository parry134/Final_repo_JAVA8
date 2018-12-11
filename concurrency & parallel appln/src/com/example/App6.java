package com.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class App6 {

	public static void main(String[] args) {

		// Lock API

		ReentrantLock lock = new ReentrantLock();
		ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock(false);

		Runnable task = () -> {
			try {
//				lock.lock();
				readWriteLock.writeLock();
				System.out.println("got lock, now im sleeping");
				try {
					TimeUnit.SECONDS.sleep(3);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("going home");
			} finally {
//				lock.unlock();
			}
		};

		ExecutorService executorService = Executors.newFixedThreadPool(2);
		executorService.submit(task);
		executorService.submit(task);

	}

}
