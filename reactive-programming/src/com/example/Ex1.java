package com.example;

import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import rx.Observable;

//---------------------------------------------
// producer/publisher  component
//---------------------------------------------

class List<E> implements Iterable<E> {
	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {
			@Override
			public boolean hasNext() {
				return false;
			}

			@Override
			public E next() {
				return null;
			}
		};
	}
}

class Producer {

	public String getItem() {
		System.out.println("producer  : returned single-item");
		return "item-1";
	}

	public Iterable<String> getItems() {
		Iterable<String> list = new List();
		return list;
	}

	public Future<String> getItemAsync() {
		Callable<String> task = () -> {
			TimeUnit.SECONDS.sleep(3);
			System.out.println("producer  : pushing single-item");
			return "Item-1";
		};
		ExecutorService executorService = Executors.newFixedThreadPool(1);
		return executorService.submit(task);
	}

	public Observable<String> getItemsAsync() {
		Observable<String> stream = Observable.create(subscriber -> {
			int i = 0;
			while (true) {
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				i++;
				if (i == 50) {
					System.out.println("producer  : pushing error");
					subscriber.onError(new IllegalArgumentException("item-error"));
					break;
				} else {
					System.out.println("producer  : pushing item");
					subscriber.onNext("item" + i);
				}
				if(i==10) {
					subscriber.onCompleted();
					break;
				}
			}
		});
		return stream;
	}

}

//---------------------------------------------
//consumer/subscriber  component
//---------------------------------------------

class Consumer {

	Producer producer = new Producer();

	public void doSomething() {

		// --------------------------------------
		// PULL / synchronous communication
		// --------------------------------------

		// way-1: for single-item

//		String item = producer.getItem(); // pull / sync
//		System.out.println("consumer  : pulling single-item => " + item);

		// ---------------------------------------

//		way-2: for multiple-item

//		Iterator<String> it = producer.getItems().iterator();
//		while (it.hasNext()) {
//			String e = (String) it.next(); // pull
//			System.out.println(e);
//		}

		// ---------------------------------------

		// --------------------------------------
		// PUSH / asynchronous communication
		// --------------------------------------

		// way-1: for single-item

//		Future<String> future = producer.getItemAsync();
//		String item = null;
//		try {
//			item = future.get();
//			System.out.println("consumer  : got single-item async=> " + item);
//		} catch (InterruptedException | ExecutionException e) {
//			e.printStackTrace();
//		}

		// ---------------------------------------

//		way-2: for multiple-item

		Observable<String> stream = producer.getItemsAsync();
		stream.subscribe(
				item -> System.out.println("consumer  : got item async=> " + item),
				error -> System.out.println("consumer  : got error => "+error),
				() -> System.out.println("tanks producer for all items")
				);

	}

}

public class Ex1 {

	public static void main(String[] args) {

		Consumer consumer = new Consumer();
		consumer.doSomething();

	}

}
