package com.dzone.detectDeadlocks;

import java.util.concurrent.TimeUnit;

public class DeadlockTest {
	public static void main(String[] args) {
		DeadlocksDetector detector = new DeadlocksDetector(
				new DeadlockConsoleHandler(), 5, TimeUnit.SECONDS);

		detector.start();

		final Object lock1 = new Object();
		final Object lock2 = new Object();

		Thread th1 = new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized (lock1) {
					System.out.println("Thread1 acquires lock1");
					try {
						TimeUnit.MILLISECONDS.sleep(500);
					} catch (Exception e) {
						// TODO: handle exception
					}
					
					synchronized (lock2) {
						System.out.println("Thread1 acquires lock2");
					}
				}
			}
		});
		
		th1.start();
		
		Thread th2 = new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized (lock2) {
					System.out.println("Thread2 acquires lock2");
					try {
						TimeUnit.MILLISECONDS.sleep(500);
					} catch (Exception e) {
						// TODO: handle exception
					}
					
					synchronized (lock1) {
						System.out.println("Thread2 acquires lock1");
					}
				}
			}
		});
		
		th2.start();
	}
}
