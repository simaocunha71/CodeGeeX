import java.util.*;
import java.lang.*;

class Solution {
    /**
    Given a string of words, return a list of words split on whitespace, if no whitespaces exists in the text you
    should split on commas ',' if no commas exists you should return the number of lower-case letters with odd order in the
    alphabet, ord('a') = 0, ord('b') = 1, ... ord('z') = 25
    Examples
    splitWords("Hello world!") == ["Hello", "world!"]
    splitWords("Hello,world!") == ["Hello", "world!"]
    splitWords("abcdef") == 3
     */
    public Object splitWords(String txt) {
        Set<Character> lowerCase = new HashSet<>();
        int size = Math.max(txt.length(), txt.toUpperCase().length());
        List<Character> uppercase = Arrays.stream(txt).mapToObj(i -> (char) i).collect(Collectors.toList());
        
        String str = txt; // To get the length and not the empty string
        if (!str.contains(" ")) {//If we do not have any spaces then we should split on ,s
            return Arrays.stream(txt).mapToObj((i) -> (char) i).collect(Collectors.toList()); 
        }else{
            List<Character> lowerCaseLetters = Arrays.asList(txt.split(" "));//We have spaces so we split on them
            for (Character c: lowerCaseLetters) {
                if (!lowerCase.contains(c)) {
                    lowerCase.add((char) c);
                    lowerCaseLetters.addAll(Arrays.stream(txt).mapToObj((i) -> (char) i).collect(Collectors.toList()));
                }
            }        
        }        List<Character> ret = new ArrayList<>();  // Our list which we will fill with odd index letters in the alphabet if any exist
        for (int i=0; i<size+1; ++i) {// Looping from 0 to size-1 counting each letter, as 26th being the last one
            char

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                Objects.equals(s.splitWords("Hello world!" ), Arrays.asList("Hello", "world!" )),
                Objects.equals(s.splitWords("Hello,world!" ), Arrays.asList("Hello", "world!" )),
                Objects.equals(s.splitWords("Hello world,!" ), Arrays.asList("Hello", "world,!" )),
                Objects.equals(s.splitWords("Hello,Hello,world !" ), Arrays.asList("Hello,Hello,world", "!" )),
                Objects.equals(s.splitWords("abcdef" ), 3),
                Objects.equals(s.splitWords("aaabb" ), 2),
                Objects.equals(s.splitWords("aaaBb" ), 1),
                Objects.equals(s.splitWords("" ), 0)
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}