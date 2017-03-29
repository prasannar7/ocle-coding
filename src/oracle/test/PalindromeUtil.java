package oracle.test;

/**
 * Checks if a string is a palindrome.
 *
 * Palindrome is a word, phrase or sentence that reads the same backward or
 * forward. For example, the following string is a palindrome: "Madam, I'm Adam."
 */
public class PalindromeUtil {
	/**
	 * Checks whether passed String is a palindrome or not.
	 *
	 * Requirements:
	 * - Limit the amount of additional consumed memory to O(1).
	 * - Limit complexity to O(n).
	 *
	 * @return true if passed string is palindrome, false - otherwise
	 */
	public static boolean isPalindrome(String str) {
		if(null == str || str.trim().length()==0){
			return false;
		}
		
		int length=str.length();
		int mid=length/2;
		//Considering use case as case sensitive.
		
		//If we want to consider use case as case insensitive. Please uncoment and execute the code
		//str=str.toLowerCase();
		for(int i=0,j=length-1;i<mid&&j!=mid;i++,j--){
			if(str.charAt(i)!=str.charAt(j))
				return false;
		}
		return true;
	}
	
}

