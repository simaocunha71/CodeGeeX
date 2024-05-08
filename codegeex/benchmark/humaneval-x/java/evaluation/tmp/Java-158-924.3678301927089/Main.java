import java.util.*;
import java.lang.*;

class Solution {
    /**
    Write a function that accepts a list of strings.
    The list contains different words. Return the word with maximum number
    of unique characters. If multiple strings have maximum number of unique
    characters, return the one which comes first in lexicographical order.

    findMax(["name", "of", "string"]) == "string"
    findMax(["name", "enam", "game"]) == "enam"
    findMax(["aaaaaaa", "bb" ,"cc"]) == ""aaaaaaa"
     */
    public String findMax(List<String> words) {
        Set<Character> chars = new HashSet<>();
        for (String s:words ) {
            for (char c : s.toCharArray() ) {
                chars.add(c);
            }
        }
        int max = 0;
        String result = "";
        for (Character c : chars ) {
            if ( result .equals("")) continue;
            if (result.length() > max) {
                return result;
            } else if (result.length() == 1 && !c.isLetter()) {
                    continue;
            } else if (!c.isDigit() ) {
                if (result.length()+1 > max) {
                    max = result.length();
                    return result;
                }
            } 
            result += c;
        }
        return "";
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.findMax(new ArrayList<>(Arrays.asList("name", "of", "string"))).equals("string"),
                s.findMax(new ArrayList<>(Arrays.asList("name", "enam", "game"))).equals("enam"),
                s.findMax(new ArrayList<>(Arrays.asList("aaaaaaa", "bb", "cc"))).equals("aaaaaaa"),
                s.findMax(new ArrayList<>(Arrays.asList("abc", "cba"))).equals("abc"),
                s.findMax(new ArrayList<>(Arrays.asList("play", "this", "game", "of", "footbott"))).equals("footbott"),
                s.findMax(new ArrayList<>(Arrays.asList("we", "are", "gonna", "rock"))).equals("gonna"),
                s.findMax(new ArrayList<>(Arrays.asList("we", "are", "a", "mad", "nation"))).equals("nation"),
                s.findMax(new ArrayList<>(Arrays.asList("this", "is", "a", "prrk"))).equals("this"),
                s.findMax(new ArrayList<>(List.of("b"))).equals("b"),
                s.findMax(new ArrayList<>(Arrays.asList("play", "play", "play"))).equals("play")
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}