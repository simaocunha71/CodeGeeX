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
        char[] a = s.toCharArray();
        for (int i=0;i<a.length-1; i++) {
            if ((Character.isLetter(a[i]) || !Character.isWhitespace(a[i])) && (Character.isUpperCase(a[i+1]) || Character.isLowerCase(a[i+1]))) {
                StringBuffer sb = new StringBuffer();
                sb.append((a[i]).toUpperCase());
                for (int j=0;j<a.length-2-1;j++) {
                    if (!Character.isWhitespace(a[j]) && Character.isLowerCase(a[j+1])) {
                        sb.append((a[i]).toUpperCase());
                    } else {
                        sb.append((a[i]).toLowerCase());
                    }
                }
                a[i] = sb.toString().charAt(0);
            }
        }
        return new String(a);
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