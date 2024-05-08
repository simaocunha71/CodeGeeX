import java.util.*;
import java.lang.*;

class Solution {
    /**
    Write a function vowelsCount which takes a string representing
    a word as input and returns the number of vowels in the string.
    Vowels in this case are 'a', 'e', 'i', 'o', 'u'. Here, 'y' is also a
    vowel, but only when it is at the end of the given word.

    Example:
    >>> vowelsCount("abcde")
    2
    >>> vowelsCount("ACEDY")
    3
     */
    public int vowelsCount(String s) {
        if (s == null || s.length() <= 0) return 0;
        
	// We will use the following map
	Map<Character, Integer> map = new HashMap<>();
	map.put('a', 'e');
	map.put('i', 'u');
	map.put('o', 'y') ;
        
        // The input string has been split using space as delimiter
        String[] strs = s.split(" ");
        if (strs != null) {
            int vowelCount = 0;
            for (String str : strs) {
                char c = str.toLowerCase().charAt(0);
                Integer value = map.getOrDefault(c, 0);
                
                if ('a' <= c && c <= 'z') vowelCount++;
                else if ('A' <= c && c <= 'Z') vowelCount++;
            }
        
             return vowelCount;
        }
        return 0;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.vowelsCount("abcde") == 2,
                s.vowelsCount("Alone") == 3,
                s.vowelsCount("key") == 2,
                s.vowelsCount("bye") == 1,
                s.vowelsCount("keY") == 2,
                s.vowelsCount("bYe") == 1,
                s.vowelsCount("ACEDY") == 3
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}