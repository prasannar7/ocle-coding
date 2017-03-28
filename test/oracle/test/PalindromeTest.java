package oracle.test;

import java.util.Scanner;

/**
 * Provides sufficient test coverage for oracle.test.PalindromeUtil class.
 */
public class PalindromeTest {
    // implement code here ...
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
	}
	
	/*
	 * This test case is used to test whether the given string is palindrome or not
	 */
	public static void testGivenIsPalindrome(String str){
		boolean isPalindrome=PalindromeUtil.isPalindrome(str);
		if(isPalindrome){
			System.out.println("Given string is a palindrome.");
		}else{
			System.out.println("Given string is not a palindrome.");
		}
	}
	
	/*
	 * Positive test case 
	 */
	public static void testIsPalindromePositive(){
		String str="madam";
		boolean isPalindrome=PalindromeUtil.isPalindrome(str);
		if(isPalindrome){
			System.out.println("String is a palindrome.");
		}else{
			System.out.println("String is not a palindrome.");
		}
	}
	
	/*
	 * Positive test case 
	 */
	public static void testIsPalindromeNegative(){
		String str="bottle";
		boolean isPalindrome=PalindromeUtil.isPalindrome(str);
		if(isPalindrome){
			System.out.println("String is a palindrome.");
		}else{
			System.out.println("String is not a palindrome.");
		}
	}
}
