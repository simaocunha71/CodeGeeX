import java.util.*;
import java.lang.*;

class Solution {
    /**
    Task
    We are given two strings s and c, you have to deleted all the characters in s that are equal to any character in c
    then check if the result string is palindrome.
    A string is called palindrome if it reads the same backward as forward.
    You should return a tuple containing the result string and true/false for the check.
    Example
    For s = "abcde", c = "ae", the result should be ("bcd",false)
    For s = "abcdef", c = "b"  the result should be ("acdef",false)
    For s = "abcdedcba", c = "ab", the result should be ("cdedc",true)
     */
    public List<Object> reverseDelete(String s, String c) {
        Set<Character> charsInC = new HashSet<>();
        char[] r1 = s.toCharArray();
        boolean isPalindrome=false;
        for (char ch : r1){
            if (ch == c[0]){
                charsInC.add(ch);
            } else {
                break;
            }
        }
        List<Object> result = new ArrayList<>();
        int i=s.length()-2, j=-1;
        while(i>=j)
        {
            if (charsInC.contains(s.charAt(i)) && charsInC.remove(s.charAt(i))){
                System.out.println("Removed "+s.charAt(i));
                result.add((String) s.substring(0, i+1));
            } else {
                j++;
            }
        if (Character.isPalindrome(s)){
            isPalindrome=true;
        }
            System.out.println(result);
        }
        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.reverseDelete("abcde", "ae" ).equals(Arrays.asList("bcd", false)),
                s.reverseDelete("abcdef", "b" ).equals(Arrays.asList("acdef", false)),
                s.reverseDelete("abcdedcba", "ab" ).equals(Arrays.asList("cdedc", true)),
                s.reverseDelete("dwik", "w" ).equals(Arrays.asList("dik", false)),
                s.reverseDelete("a", "a" ).equals(Arrays.asList("", true)),
                s.reverseDelete("abcdedcba", "" ).equals(Arrays.asList("abcdedcba", true)),
                s.reverseDelete("abcdedcba", "v" ).equals(Arrays.asList("abcdedcba", true)),
                s.reverseDelete("vabba", "v" ).equals(Arrays.asList("abba", true)),
                s.reverseDelete("mamma", "mia" ).equals(Arrays.asList("", true))
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}