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
        Set<Character> vowels = new HashSet<>();
        for (char c:text.toCharArray()) {
            if (Character.isLetter(c)) {
                for (int i=0;i<=26;++i) {
                    char ch = (char)('a'+i);
                    if (c==ch) vowels.add(new Character(c));
                    else break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<text.length();++i) {
            char c = text.charAt(i);
            if (!vowels.contains(new Character(c))) sb.append(c);
        }
        return sb.toString();
    }
    
    removeDuplicates is a function that takes string and returns string without duplicates.
    >>> removeDuplicates("abcdefghijklm")
    "abcdghi"
    >>> removeDuplicates(new StringBuilder().append("a").append("b").append("c").append("d").append("e").toString())
    ***/
    public String removeDuplicates(String text) {
        HashSet<Character> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (char c:text.toCharArray()) set.add(c);
        sb.append(c).append(""); // ignore empty character
        
        StringBuilder sb2 = new StringBuilder().append('

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