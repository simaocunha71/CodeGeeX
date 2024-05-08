import java.util.*;
import java.lang.*;

class Solution {
    /**
    You are given a string s.
    if s[i] is a letter, reverse its case from lower to upper or vise versa,
    otherwise keep it as it is.
    If the string contains no letters, reverse the string.
    The function should return the resulted string.
    Examples
    solve("1234") = "4321"
    solve("ab") = "AB"
    solve("#a@C") = "#A@c"
     */
    public String solve(String s) {
        StringBuilder result = new StringBuilder();
        for (int i=0;i<s.length();++i){ 
            char c = s.charAt(i);
            
            if (isLetter(c)) { 
                // Reverse the case of each letter
                // Note: the result must be in original order,
                //       you do not need to reverse back after reversing
                result.append((char) ((Character.toUpperCase(c) ^ Character.toLowerCase(c)) & 0x5f)); 
            } else {
                // If the char is a letter, just append it with out doing any change
                result.append(s.charAt(i)); 
            }
        } 
        
        return result.toString();
    }
    
    private boolean isLetter(char c) {
        // Character set for valid letters according to the Java API: 
        // https://docs.oracle.com/javase/7/docs/api/java/lang/Character.html#isLetter(char):boolean
        return (c>='a' && c<='z') || (c>='A' && c<='Z');
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                Objects.equals(s.solve("AsDf"), "aSdF"),
                Objects.equals(s.solve("1234"), "4321"),
                Objects.equals(s.solve("ab"), "AB"),
                Objects.equals(s.solve("#a@C"), "#A@c"),
                Objects.equals(s.solve("#AsdfW^45"), "#aSDFw^45"),
                Objects.equals(s.solve("#6@2"), "2@6#"),
                Objects.equals(s.solve("#$a^D"), "#$A^d"),
                Objects.equals(s.solve("#ccc"), "#CCC")
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}