import java.util.*;
import java.lang.*;

class Solution {
    /**
    Out of list of strings, return the longest one. Return the first one in case of multiple
    strings of the same length. Return None in case the input list is empty.
    >>> longest(List.of())
    Optional.empty
    >>> longest(Arrays.asList("a", "b", "c"))
    Optional[a]
    >>> longest(Arrays.asList("a", "bb", "ccc"))
    Optional[ccc]
     */
    public Optional<String> longest(List<String> strings) {
        // Your Code Here
        if (strings == null || strings.isEmpty())
            return Optional.of(null);
        else {
            String maximum = "";
            int maxlen = 0;
            for (String string : strings) {
                if (!string.equals("")) {
                    if ((!maximum.equals("") && longestHelper(maximum, true)) || (maximum == "" && !string.equals(""))) {
                        maxlen = maximum.length() < string.length() ? string.length() : maximum.length();
                        maximum = string;
                    } else if (!string.equals("")) {
                        maxlen = string.length() > maximum.length() ? string.length() : maximum.length();
                        maximum = string;
                    }
                }
            }
            return Optional.of(maximum);
        }
    }
    
    private boolean longestHelper(String a, boolean isLargest) {
        if (a == null || a.equals("")) {
            return false;
        } else if (!longestHelper(String.valueOf(isLargest), false)) {
            return true;
        } else if (string.length() < a.length()) {
            return false;
        } else {
            return true;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.longest(new ArrayList<>(List.of())).isEmpty(),
                Objects.equals(s.longest(new ArrayList<>(Arrays.asList("x", "y", "z"))).get(), "x"),
                Objects.equals(s.longest(new ArrayList<>(Arrays.asList("x", "yyy", "zzzz", "www", "kkkk", "abc"))).get(), "zzzz")
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}