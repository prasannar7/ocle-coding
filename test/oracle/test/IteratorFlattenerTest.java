package oracle.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Provides sufficient test coverage for oracle.test.IteratorFlattener class.
 */
public class IteratorFlattenerTest {
	
	public static void main(String[] args) {
		testIteratorOfIteratorsForIntegers();
		testIteratorOfIteratorsForStrings();
		testIteratorOfIteratorsWithEmptyList();
		testIteratorOfIteratorsWithOneNonEmptyListAndOneEmptyList();
	}
	
	/*
	 * This test case is used to test iterator of iterators with Integers
	 */
	public static void testIteratorOfIteratorsForIntegers(){
		System.out.println("\n");
		System.out.println("Test case :: IteratorFlattenerTest :: testIteratorOfIteratorsForIntegers >>> start");
		List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(5, 6, 7, 8));
        System.out.println("Lists and there elements....,");
        System.out.println(list1.toString().replace("[", "{").replace("]", "}"));
        System.out.println(list2.toString().replace("[", "{").replace("]", "}"));
        List<Iterator<Integer>> combined = new ArrayList<>(Arrays.asList(list1.iterator(), list2.iterator()));
        System.out.println("After combining iterators....,");
        System.out.println("{ "+list1.toString().replace("[", "{").replace("]", "}, ")+list2.toString().replace("[", "{").replace("]", "}")+" }");
		IteratorFlattener<Integer> ioi = new IteratorFlattener<>(combined.iterator());
		System.out.println("Iterate through iterator of iterators....,");
		System.out.print("{");
        while (ioi.hasNext()) {
        	Object itr = ioi.next();
			System.out.print(" "+itr+" ");
       }
        System.out.println("}");
        System.out.println("Test case :: IteratorFlattenerTest :: testIteratorOfIteratorsForIntegers <<< end");
	}
	
	/*
	 * This test case is used to test iterator of iterators with String
	 */
	public static void testIteratorOfIteratorsForStrings(){
		System.out.println("\n");
		System.out.println("Test case :: IteratorFlattenerTest :: testIteratorOfIteratorsForStrings >>> start");
		List<String> list1 = new ArrayList<>(Arrays.asList("India", "USA", "UK", "Italy"));
        List<String> list2 = new ArrayList<>(Arrays.asList("France", "Germany", "Switzerland", "Newzealand"));
        System.out.println("Lists and there elements....,");
        System.out.println(list1.toString().replace("[", "{").replace("]", "}"));
        System.out.println(list2.toString().replace("[", "{").replace("]", "}"));
        List<Iterator<String>> combined = new ArrayList<>(Arrays.asList(list1.iterator(), list2.iterator()));
        System.out.println("After combining iterators....,");
        System.out.println("{ "+list1.toString().replace("[", "{").replace("]", "}, ")+list2.toString().replace("[", "{").replace("]", "}")+" }");
		IteratorFlattener<String> ioi = new IteratorFlattener<>(combined.iterator());
		System.out.println("Iterate through iterator of iterators....,");
		System.out.print("{");
        while (ioi.hasNext()) {
        	Object itr = ioi.next();
			System.out.print(" "+itr+" ");
       }
        System.out.println("}");
        System.out.println("Test case :: IteratorFlattenerTest :: testIteratorOfIteratorsForStrings <<< end");
	}
	
	/*
	 * This test case is used to test iterator of iterators with empty lists
	 */
	public static void testIteratorOfIteratorsWithEmptyList(){
		System.out.println("\n");
		System.out.println("Test case :: IteratorFlattenerTest :: testIteratorOfIteratorsWithEmptyList >>> start");
		List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        System.out.println("Lists and there elements....,");
        System.out.println(list1.toString().replace("[", "{").replace("]", "}"));
        System.out.println(list2.toString().replace("[", "{").replace("]", "}"));
        List<Iterator<String>> combined = new ArrayList<>(Arrays.asList(list1.iterator(), list2.iterator()));
        System.out.println("After combining iterators....,");
        System.out.println("{ "+list1.toString().replace("[", "{").replace("]", "}, ")+list2.toString().replace("[", "{").replace("]", "}")+" }");
		IteratorFlattener<String> ioi = new IteratorFlattener<>(combined.iterator());
		System.out.println("Iterate through iterator of iterators....,");
		System.out.print("{");
        while (ioi.hasNext()) {
        	Object itr = ioi.next();
			System.out.print(" "+itr+" ");
       }
        System.out.println("}");
        System.out.println("Test case :: IteratorFlattenerTest :: testIteratorOfIteratorsWithEmptyList <<< end");
	}
	
	/*
	 * This test case is used to test iterator of iterators with one non empty list and empty lists
	 */
	public static void testIteratorOfIteratorsWithOneNonEmptyListAndOneEmptyList(){
		System.out.println("\n");
		System.out.println("Test case :: IteratorFlattenerTest :: testIteratorOfIteratorsWithOneNonEmptyListAndOneEmptyList >>> start");
		List<String> list1 = new ArrayList<>(Arrays.asList("India", "USA", "UK", "Italy"));
        List<String> list2 = new ArrayList<>();
        System.out.println("Lists and there elements....,");
        System.out.println(list1.toString().replace("[", "{").replace("]", "}"));
        System.out.println(list2.toString().replace("[", "{").replace("]", "}"));
        List<Iterator<String>> combined = new ArrayList<>(Arrays.asList(list1.iterator(), list2.iterator()));
        System.out.println("After combining iterators....,");
        System.out.println("{ "+list1.toString().replace("[", "{").replace("]", "}, ")+list2.toString().replace("[", "{").replace("]", "}")+" }");
		IteratorFlattener<String> ioi = new IteratorFlattener<>(combined.iterator());
		System.out.println("Iterate through iterator of iterators....,");
		System.out.print("{");
        while (ioi.hasNext()) {
        	Object itr = ioi.next();
			System.out.print(" "+itr+" ");
       }
        System.out.println("}");
        System.out.println("Test case :: IteratorFlattenerTest :: testIteratorOfIteratorsWithOneNonEmptyListAndOneEmptyList <<< end");
	}
	
}
