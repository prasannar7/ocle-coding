package oracle.test;

import java.util.Scanner;

/**
 * Provides sufficient test coverage for oracle.test.PalindromeUtil class.
 */
public class PalindromeTest {
	public static void main(String[] args) {
		testStringIsPalindrome();
		String str="madam";
		testGivenIsPalindrome(str);
		testIsPalindromePositive();
		testIsPalindromeNegative();
	}
	
	/*
	 * This test case is used to test whether the string entered is palindrome or not.
	 */
	public static void testStringIsPalindrome(){
		System.out.println("\n");
		System.out.println("Test case :: PalindromeTest :: testStringIsPalindrome >>> start");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter your string...,");
		String str=scanner.nextLine();
		boolean isPalindrome=PalindromeUtil.isPalindrome(str);
		if(isPalindrome){
			System.out.println("Entered string is a palindrome.");
		}else{
			System.out.println("Entered string is not a palindrome.");
		}
		System.out.println("Test case :: PalindromeTest :: testStringIsPalindrome <<< end");
		System.out.println("\n");
	}
	
	/*
	 * This test case is used to test whether the given string is palindrome or not
	 */
	public static void testGivenIsPalindrome(String str){
		System.out.println("\n");
		System.out.println("Test case :: PalindromeTest :: testGivenIsPalindrome >>> start");
		boolean isPalindrome=PalindromeUtil.isPalindrome(str);
		if(isPalindrome){
			System.out.println("Given string is a palindrome.");
		}else{
			System.out.println("Given string is not a palindrome.");
		}
		System.out.println("Test case :: PalindromeTest :: testGivenIsPalindrome <<< end");
		System.out.println("\n");
	}
	
	/*
	 * Positive test case where string is a palindrome.
	 */
	public static void testIsPalindromePositive(){
		System.out.println("\n");
		System.out.println("Test case :: PalindromeTest :: testIsPalindromePositive >>> start");
		String str="madam";
		boolean isPalindrome=PalindromeUtil.isPalindrome(str);
		if(isPalindrome){
			System.out.println("String is a palindrome.");
		}else{
			System.out.println("String is not a palindrome.");
		}
		System.out.println("Test case :: PalindromeTest :: testIsPalindromePositive <<< end");
		System.out.println("\n");
	}
	
	/*
	 * Negative test case where string is not a palindrome.
	 */
	public static void testIsPalindromeNegative(){
		System.out.println("\n");
		System.out.println("Test case :: PalindromeTest :: testIsPalindromeNegative >>> start");
		String str="bottle";
		boolean isPalindrome=PalindromeUtil.isPalindrome(str);
		if(isPalindrome){
			System.out.println("String is a palindrome.");
		}else{
			System.out.println("String is not a palindrome.");
		}
		System.out.println("Test case :: PalindromeTest :: testIsPalindromeNegative <<< end");
		System.out.println("\n");
	}
}
