package oracle.test;

import java.util.Random;
import java.util.Scanner;

/**
 * Provides sufficient test coverage for oracle.test.BlockingQueue class.
 */
public class BlockingQueueTest {
    
	public static void main(String[] args) throws InterruptedException {
		testBlockingQueueWithTwoThreadsSequentialReadWrite();
		testBlockingQueueWithTwoThreadsAndRandomReadWrite();
		testBlockingQueueWithMultipleThreads();
	}
	
	/*
	 * This test case is used to test BlockingQueue with two threads and read write are sequential. 
	 * One thread is to push data to queue and the other thread is to pull data from queue.
	 * 
	 */
	public static void testBlockingQueueWithTwoThreadsSequentialReadWrite(){
		System.out.println("Test case :: testBlockingQueueWithTwoThreadsSequentialReadWrite");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter Queue size...,");
		int size=scanner.nextInt();
		BlockingQueue<Integer> b=new BlockingQueue<Integer>(size);
		
		Thread producer = new Thread() {
			int executionLenth=0;
			Random rand = new Random();
			public void run() {
				try {
					while(true){
						int value = rand.nextInt();
						System.out.println("push() > "+ value);
						b.push(value);
						if(executionLenth==size){
							break;
						}
						executionLenth++;
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		
		Thread consumer = new Thread() {
			int executionLenth=0;
			public void run() {
				try {
					while(true){
						System.out.println("pull() < "+b.pull());
						if(executionLenth==size){
							break;
						}
						executionLenth++;
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		
		producer.start();
		consumer.start();
	}
	
	/*
	 * This test case is used to test BlockingQueue with two threads and read write are sequential. 
	 * One thread is to push data to queue and the other thread is to pull data from queue.
	 * 
	 */
	public static void testBlockingQueueWithTwoThreadsAndRandomReadWrite(){
		System.out.println("Test case :: testBlockingQueueWithTwoThreadsAndRandomReadWrite");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter Queue size...,");
		int size=scanner.nextInt();
		BlockingQueue<Integer> b=new BlockingQueue<Integer>(size);
    	
		Thread consumer = new Thread() {
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
		
		Thread producer = new Thread() {
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
    	
		producer.start();
		consumer.start();
	}
	
	/*
	 * This test case is used to test BlockingQueue with multiple(random) threads. 
	 * Randomly generating threads based on the randomly generated boolean value.
	 * 
	 */
	public static void testBlockingQueueWithMultipleThreads(){
		System.out.println("Test case :: testBlockingQueueWithMultipleThreads");
		int SIMULATION_LENGTH=100;
		BooleanSource producerProbability = new BooleanSource(0.5);
		BooleanSource consumerProbability = new BooleanSource(0.5);
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter Queue size...,");
		int size=scanner.nextInt();
		BlockingQueue<Integer> b=new BlockingQueue<Integer>(size);
		for (int t = 0; t <= SIMULATION_LENGTH; t++) {
			
			if(producerProbability.random()) {
				Thread producer = new Thread() {
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
				producer.start();
			}
		
			if(consumerProbability.random()){
				Thread consumer = new Thread() {
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
				consumer.start();
			}
		}
	}
}
