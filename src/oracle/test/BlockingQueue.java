package oracle.test;

import java.util.LinkedList;
import java.util.List;

/**
 * Provides waiting thread-safe access to a java.util.Queue instance.
 *
 * Requirements:
 * - Usage of API from java.util.concurrent packageis prohibited.
 * - Limit the amount of additional consumed memory to O(1).
 * - The implementation is supposed to be acceptable for usage in a highly
 * multi-thread environment.
 *
 * Useful tips a.k.a. common pitfalls:
 * - Please note that you do not need to implement java.util.Queue.
 * - Readiness to accept or provide elements is solely dependent on the
 * underlying queue. Any additional queue capacity limitations break contract
 * defined in the javadoc.
 */
public class BlockingQueue<E> {
    // implement code here ...
	/*
	 * Queue to hold elements.
	 */
	private List<E> queue;
	
	/*
	 * Maximum number of elements queue can hold.
	 */
	private int  maxSize;
	
    /**
     * @param queue The underlying "wrapped" queue.
     * @param maxSize The maximum size of the queue.
     */
    public BlockingQueue(int maxSize) {
        // implement code here ...
    	this.maxSize = maxSize;
        this.queue = new LinkedList<E>();
    }

    
    /**
     * Inserts the specified element into the underlying queue, waiting if
     * necessary for the underlying queue to be ready to accept new elements.
     * @param e the element to insert.
     * @throws InterruptedException 
     */
    public synchronized void push(E e) throws InterruptedException {
        // implement code here ...
    	/*
    	 * Check space is available in queue or not.
    	 */
		if (queue.size() == maxSize) {
			this.wait();
		}

		/*
		 * When space is available, insert element and notify all waiting threads.
		 */
		queue.add(e);
		this.notifyAll();
    }

    /**
     * Retrieves and removes the head of the underlying queue, waiting if
     * necessary until it is capable of providing an element.
     * @return the retrieved element
     * @throws InterruptedException 
     */
    public synchronized E pull() throws InterruptedException {
        // implement code here ...
    	/*
    	 * Check element is available or not. If element is not available then wait element to be available.
    	 */
		if (queue.size() == 0) {
			this.wait();
		}

		/*
		 * When element is available, remove the element and notify all the waiting threads.
		 */
		E element = queue.remove(0);
		this.notifyAll();
		return element;
    }
    
}
