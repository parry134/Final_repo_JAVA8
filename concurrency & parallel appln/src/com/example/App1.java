package com.example;

import java.util.Scanner;

public class App1 {

	public static void doIO() {
		Scanner sc = new Scanner(System.in);
		System.out.println("give me ur name");
		String name = sc.nextLine();
		System.out.println("hello " + name);
		sc.close();
	}

	public static void doComputation() {
		double result = 0.0;
		for (int i = 0; i < 100; i++) {
			result += i;
		}
		System.out.println("result : " + result);
	}

	public static void main(String[] args) {

		Thread thread = Thread.currentThread();
		System.out.println(thread.getName() + " start..");

		// step-1: IO
		System.out.println("------------------------  : IO ");
		doIO();
		System.out.println("------------------------");

		// step-2: Computation
		System.out.println("------------------------  : Computation");
		doComputation();
		System.out.println("------------------------");

	}

}
