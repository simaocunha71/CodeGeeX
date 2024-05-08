import java.util.*;
import java.lang.*;

class Solution {
    /**
    Return list of all prefixes from shortest to longest of the input string
    >>> allPrefixes("abc")
    ["a", "ab", "abc"]
     */
    public List<String> allPrefixes(String string) {
        List<String> result = new ArrayList<>();
        
        // We will append prefixes to a list, and will sort them from shortest one to longest one.
        // We will start with an empty string that we will fill up later on.
        StringBuffer emptyPrefix = new StringBuffer();
            
        // Iterate through all characters of the input string.
        for (int i = 0; i < string.length(); ++i) {
            char currentChar = string.charAt(i);
            
            if (Character.isLetterOrDigit(currentChar)) {
                emptyPrefix.append(currentChar); // Add character to the end of our prefixes list
            } else {
                StringBuffer tmp = new StringBuffer();
                tmp.append(emptyPrefix, ""); // Get all characters from our prefixes list and append them into a substring
                result.add(tmp.toString()); // Add all strings that we have to the output list - it's sorted now
                emptyPrefix = new StringBuffer();
            }
        }
        
        return Collections.unmodifiableList(result);
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.allPrefixes("").equals(List.of()),
                s.allPrefixes("asdfgh").equals(Arrays.asList("a", "as", "asd", "asdf", "asdfg", "asdfgh")),
                s.allPrefixes("WWW").equals(Arrays.asList("W", "WW", "WWW"))
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}