package oracle.test;

import java.util.Random;
import java.util.Scanner;

/**
 * Provides sufficient test coverage for oracle.test.BlockingQueue class.
 */
public class BlockingQueueTest {
    
	public static void main(String[] args) throws InterruptedException {
		testBlockingQueueWithMultipleThreads();
	}
	
	/*
	 * This test case is used to test BlockingQueue with two threads. 
	 * One thread is to push data to queue and the other thread is to pull data from queue.
	 * 
	 */
	public static void testBlockingQueueWithTwoThreads(){
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter Queue size...,");
		int size=scanner.nextInt();
		BlockingQueue<Integer> b=new BlockingQueue<Integer>(size);
    	
		Thread threadPull = new Thread() {
			int executionLenth=0;
			public void run() {
				try {
					while(true){
						System.out.println("pull() < "+b.pull());
						if(executionLenth==100){
							break;
						}
						executionLenth++;
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		
		Thread threadPush = new Thread() {
			int executionLenth=0;
			Random rand = new Random();
			public void run() {
				try {
					while(true){
						int value = rand.nextInt();
						System.out.println("push() > "+ value);
						b.push(value);
						if(executionLenth==100){
							break;
						}
						executionLenth++;
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
    	
		threadPush.start();
		threadPull.start();
	}
	
	public static void testBlockingQueueWithMultipleThreads(){
		int SIMULATION_LENGTH=100;
		BooleanSource pushThread = new BooleanSource(0.5);
		BooleanSource pullThread = new BooleanSource(0.5);
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter Queue size...,");
		int size=scanner.nextInt();
		BlockingQueue<Integer> b=new BlockingQueue<Integer>(size);
		for (int t = 0; t <= SIMULATION_LENGTH; t++) {
			
			if (pushThread.random()) {
				Thread threadPush = new Thread() {
					int executionLenth=0;
					Random rand = new Random();
					public void run() {
						try {
							while(true){
								int value = rand.nextInt();
								System.out.println("push() > "+ value);
								b.push(value);
								if(executionLenth==100){
									break;
								}
								executionLenth++;
							}
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				};
				threadPush.start();
			}
		
			if(pullThread.random()){
				Thread threadPull = new Thread() {
					int executionLenth=0;
					public void run() {
						try {
							while(true){
								System.out.println("pull() > "+b.pull());
								if(executionLenth==100){
									break;
								}
								executionLenth++;
							}
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				};
				threadPull.start();
			}
		}
	}
}
