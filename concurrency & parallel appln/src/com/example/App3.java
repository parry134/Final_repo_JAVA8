package com.example;

class CounterBox {
	private long count = 0;

	private static Object key = new Object();

	public void increment() {
		synchronized (key) {
			count++; // read + increment + write
		}
	}

	public long get() {
		return count;
	}
}

public class App3 {

	public static void main(String[] args) throws InterruptedException {

		CounterBox counterBox = new CounterBox();

		Runnable target = () -> {
			for (int i = 0; i < 1000; i++) {
				counterBox.increment();
			}
		};

		Thread[] threads = new Thread[1000];
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(target);
			threads[i].start();
		}
		for (int i = 0; i < threads.length; i++) {
			threads[i].join();
		}

		long finalCount = counterBox.get();
		System.out.println(finalCount); // 1000 * 1000 ==> 1000000

	}

}
