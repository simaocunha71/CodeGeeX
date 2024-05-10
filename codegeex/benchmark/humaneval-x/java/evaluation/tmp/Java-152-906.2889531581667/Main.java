import java.util.*;
import java.lang.*;

class Solution {
    /**
    I think we all remember that feeling when the result of some long-awaited
    event is finally known. The feelings and thoughts you have at that moment are
    definitely worth noting down and comparing.
    Your task is to determine if a person correctly guessed the results of a number of matches.
    You are given two arrays of scores and guesses of equal length, where each index shows a match.
    Return an array of the same length denoting how far off each guess was. If they have guessed correctly,
    the value is 0, and if not, the value is the absolute difference between the guess and the score.

    example:

    compare(Arrays.asList(1,2,3,4,5,1),Arrays.asList(1,2,3,4,2,-2)) -> [0,0,0,0,3,3]
    compare(Arrays.asList(0,5,0,0,0,4),Arrays.asList(4,1,1,0,0,-2)) -> [4,4,1,0,0,6]
     */
    public List<Integer> compare(List<Integer> game, List<Integer> guess) {
        int [] diff = new int[game.size()];
        for (int i= 0;i<diff.length;i++) diff[i]=Math.abs(game.get(i)-guess.get(i));
        return Arrays.asList(0,0,0,0,0).subList(0,diff.length);
    }
}
// Your Solution Below This Line

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.compare(Arrays.asList(1, 2, 3, 4, 5, 1), Arrays.asList(1, 2, 3, 4, 2, -2)).equals(Arrays.asList(0, 0, 0, 0, 3, 3)),
                s.compare(Arrays.asList(0,5,0,0,0,4), Arrays.asList(4,1,1,0,0,-2)).equals(Arrays.asList(4,4,1,0,0,6)),
                s.compare(Arrays.asList(1, 2, 3, 4, 5, 1), Arrays.asList(1, 2, 3, 4, 2, -2)).equals(Arrays.asList(0, 0, 0, 0, 3, 3)),
                s.compare(Arrays.asList(0, 0, 0, 0, 0, 0), Arrays.asList(0, 0, 0, 0, 0, 0)).equals(Arrays.asList(0, 0, 0, 0, 0, 0)),
                s.compare(Arrays.asList(1, 2, 3), Arrays.asList(-1, -2, -3)).equals(Arrays.asList(2, 4, 6)),
                s.compare(Arrays.asList(1, 2, 3, 5), Arrays.asList(-1, 2, 3, 4)).equals(Arrays.asList(2, 0, 0, 1))
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}