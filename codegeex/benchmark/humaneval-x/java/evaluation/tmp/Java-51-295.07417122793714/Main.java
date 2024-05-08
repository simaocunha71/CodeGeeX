import java.util.*;
import java.lang.*;

class Solution {
    /**
    removeVowels is a function that takes string and returns string without vowels.
    >>> removeVowels("")
    ""
    >>> removeVowels("abcdef\nghijklm")
    "bcdf\nghjklm"
    >>> removeVowels("abcdef")
    "bcdf"
    >>> removeVowels("aaaaa")
    ""
    >>> removeVowels("aaBAA")
    "B"
    >>> removeVowels("zbcd")
    "zbcd"
     */
    public String removeVowels(String text) {
        Set<Character> set = new HashSet<>();
        for (int i=0; i<=text.length()-1;i++) {
            if (!text.contains("aeiouy")){
                set.add((char)(text.toLowerCase().charAt(i)));
            }
            
        }
        
        StringBuilder sb = new StringBuilder();
        for (Character ch : text.toUpperCase()) {
            if (set.contains(ch)) {
                sb.append(ch);
            }
        }
        return sb.toString().toLowerCase();
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                Objects.equals(s.removeVowels(""), ""),
                Objects.equals(s.removeVowels("abcdef\nghijklm"), "bcdf\nghjklm"),
                Objects.equals(s.removeVowels("fedcba"), "fdcb"),
                Objects.equals(s.removeVowels("eeeee"), ""),
                Objects.equals(s.removeVowels("acBAA"), "cB"),
                Objects.equals(s.removeVowels("EcBOO"), "cB"),
                Objects.equals(s.removeVowels("ybcd"), "ybcd")
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}