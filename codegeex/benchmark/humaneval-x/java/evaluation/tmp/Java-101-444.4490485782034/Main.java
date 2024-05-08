import java.util.*;
import java.lang.*;

class Solution {
    /**
    You will be given a string of words separated by commas or spaces. Your task is
    to split the string into words and return an array of the words.
    
    For example:
    words_string("Hi, my name is John").equals(Arrays.asList("Hi", "my", "name", "is", "John"]
    words_string("One, two, three, four, five, six").equals(Arrays.asList("One", "two", "three", "four", "five", "six"]
     */
    public List<String> wordStrings(String s) {
        ArrayList<String> result = new ArrayList<>();
        
        for (String word: s.split("\\s+")) 
            if (!word.isEmpty()) result.add(word);
            
        return Collections.unmodifiableList(result);
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.wordStrings("Hi, my name is John" ).equals(Arrays.asList("Hi", "my", "name", "is", "John" )),
                s.wordStrings("One, two, three, four, five, six" ).equals(Arrays.asList("One", "two", "three", "four", "five", "six" )),
                s.wordStrings("Hi, my name" ).equals(Arrays.asList("Hi", "my", "name" )),
                s.wordStrings("One,, two, three, four, five, six," ).equals(Arrays.asList("One", "two", "three", "four", "five", "six" )),
                s.wordStrings("" ).equals(List.of()),
                s.wordStrings("ahmed     , gamal" ).equals(Arrays.asList("ahmed", "gamal" ))
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}