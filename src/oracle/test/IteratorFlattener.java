package oracle.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * "Flattens" nested sub-iterators into an iterator in a depth-first manner.
 *
 * Requirements:
 *  - Limit the amount of additional consumed memory to O(1).
 *
 * Example: an iterator {{1,2},{3},{4,5}} which has three sub-iterators with
 * 2, 1 and 2 elements correspondingly, presents values in this order:
 * {1, 2, 3, 4, 5}
 */
public class IteratorFlattener<E> implements Iterator<E> {
    // implement code here ...
	private Iterator<Iterator<E>> iterator;
    private Iterator<E> currentIterator;
    public IteratorFlattener(Iterator<Iterator<E>> root) {
       // implement code here ...
    	this.iterator = root;
        this.currentIterator = null;
    }

    /**
     * Returns {@code true} if the iteration has more elements.
     *
     * @return {@code true} if the iteration has more elements
     */
    public boolean hasNext() {
        // implement code here ...
    	
        if (currentIterator == null) {
           if (iterator.hasNext()) {
              currentIterator = iterator.next();
           } else {
              return false;
           }
        }

        while(!currentIterator.hasNext() && iterator.hasNext()) {
           currentIterator = iterator.next();
        }

        return currentIterator.hasNext();
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     * @throws NoSuchElementException if the iteration has no more elements
     */
    public E next() {
        // implement code here ...
    	return currentIterator.next();
    }

    /**
     * Removes from the underlying collection the last element returned
     * by this iterator (optional operation). This method can be called
     * only once per call to {@link #next}.
     *
     * @throws IllegalStateException if the {@code next} method has not
     *         yet been called, or the {@code remove} method has already
     *         been called after the last call to the {@code next}
     *         method
     */
    public void remove() {
        // impement code here ...
    }
    
    public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(3);
		list2.add(4);
		
		Iterator<Integer> iterator1 = list.iterator();
		Iterator<Integer> iterator2 = list.iterator();
		Iterator<Iterator<Integer>> root = new Iterator<Iterator<Integer>>() {
			
			@Override
			public Iterator<Integer> next() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return false;
			}
		};
		
	}
}

