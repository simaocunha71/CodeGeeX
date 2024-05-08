import java.util.*;
import java.lang.*;

class Solution {
    /**
    Test if given string is a palindrome
     */
    public boolean isPalindrome(String string) {
        int i = 0;
        int j = string.length() - 1;
        while (i < j) {
            if (string.charAt(i)!= string.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    /**
    Find the shortest palindrome that begins with a supplied string.
    Algorithm idea is simple:
    - Find the longest postfix of supplied string that is a palindrome.
    - Append to the end of the string reverse of a string prefix that comes before the palindromic suffix.
    >>> makePalindrome("")
    ""
    >>> makePalindrome("cat")
    "catac"
    >>> makePalindrome("cata")
    "catac"
     */
    public String makePalindrome(String string) {
        char[] s = string.toCharArray();
        Arrays.sort(s);
        
        for (int j=0; j<s.length-2; j++) {  // skip last two characters that are not palindromes
            String str = new String(s,j,2);
            
            if (isPalindrome(str)) {
                return string+"."+str;
        
        return string+"."+".".toCharArray()[0]; // just to make sure that at least something is returned
    
    public static void main(String[] args) {
        Solution s = new Solution();
        
        System.out.println(s.makePalindrome(""));
        System.out.println(s.makePalindrome("cat"));
        System.out.println(s.makePalindrome("cata"));
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                Objects.equals(s.makePalindrome(""), ""),
                Objects.equals(s.makePalindrome("x"), "x"),
                Objects.equals(s.makePalindrome("xyz"), "xyzyx"),
                Objects.equals(s.makePalindrome("xyx"), "xyx"),
                Objects.equals(s.makePalindrome("jerry"), "jerryrrej")
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}