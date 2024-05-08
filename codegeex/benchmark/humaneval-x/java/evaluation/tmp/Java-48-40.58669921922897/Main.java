import java.util.*;
import java.lang.*;

class Solution {
    /**
    Checks if given string is a palindrome
    >>> isPalindrome("")
    true
    >>> isPalindrome("aba")
    true
    >>> isPalindrome("aaaaa")
    true
    >>> isPalindrome("zbcd")
    false
     */
    public boolean isPalindrome(String text) {
        if (text.length() == 0 || text.equalsIgnoreCase(""))
            return true;
        
        // Create hashmap of char array[], as keys
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i=0; i < text.length(); i++) {
            Character currChar = text.charAt(i);
            
            if (!map.containsKey(currChar)) // If char is not in the hashmap yet
                map.put(currChar, 1);
            
            else if (map.get(currChar) == 0) // If char already exists & is a palindrome
                return true;
        }
        
        // Increment value of all elements in the hashmap by one
        for (Map.Entry<Character, Integer> curr : map.entrySet()) {
            if (curr.getValue() == 1)
                curr.setValue(2);
            
            else
                return false;
        }
        
        // Return true as all value in hashmap are even
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.isPalindrome(""),
                s.isPalindrome("aba"),
                s.isPalindrome("aaaaa"),
                !s.isPalindrome("zbcd"),
                s.isPalindrome("xywyx"),
                !s.isPalindrome("xywyz"),
                !s.isPalindrome("xywzx")
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}