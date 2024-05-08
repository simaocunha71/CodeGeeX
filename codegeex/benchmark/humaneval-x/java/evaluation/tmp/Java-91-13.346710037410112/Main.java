import java.util.*;
import java.lang.*;

class Solution {
    /**
    You'll be given a string of words, and your task is to count the number
    of boredoms. A boredom is a sentence that starts with the word "I".
    Sentences are delimited by '.', '?' or '!'.

    For example:
    >>> isBored("Hello world")
    0
    >>> isBored("The sky is blue. The sun is shining. I love this weather")
    1
     */
    public int isBored(String S) {
        Set<String> set = new HashSet<>();
        for (char i : S.toLowerCase().toCharArray()) {
            if (i=='.' || i=='?' || i=='!') 
                continue;
            String temp = Character.toString(i);
            set.add(temp);
        }
        return set.size();
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.isBored("Hello world") == 0,
                s.isBored("Is the sky blue?") == 0,
                s.isBored("I love It !") == 1,
                s.isBored("bIt") == 0,
                s.isBored("I feel good today. I will be productive. will kill It") == 2,
                s.isBored("You and I are going for a walk") == 0
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}