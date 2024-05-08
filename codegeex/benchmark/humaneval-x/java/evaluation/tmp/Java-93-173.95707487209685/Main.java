import java.util.*;
import java.lang.*;

class Solution {
    /**
    Write a function that takes a message, and encodes in such a
    way that it swaps case of all letters, replaces all vowels in
    the message with the letter that appears 2 places ahead of that
    vowel in the english alphabet.
    Assume only letters.

    Examples:
    >>> encode("test")
    "TGST"
    >>> encode("This is a message")
    "tHKS KS C MGSSCGG"
     */
    public String encode(String message) {
        char[] c = message.toCharArray();
        int i;
        char ch, prevCh;
        // swap case
        for (int j=0;j<c.length;j++) {
            if (Character.isLowerCase(c[j])) {
                c[j] += 32;
            }
            else {
                c[j] -= 32;
            }
        }
        char[] chs = new char[message.length()];
        for (int j=0;j<ch.length;j++) {
            i = j + 1;
            if ((i+1) < ch.length && Character.isLetter(c[j]) && !Character.isDigit(c[j])) {
                prevCh = (char)(((int) c[j] - 'a') % 26);
                chs[j] = (prevCh + character(i))%26;
            }
            else {
                chs[j] = (character(i+1));
            }
        }
        return new String(chs);
    }
    
    private int character(int i) {
        int ch = ('z' - 'a') + 1; //z == 26, so
                                   //a - z is 25.
        if (i >= 24 && i <= 30) {
            return 'A'.charAt(ch) - 'A'; // 24-29 are the
                                          // vowels.
        }
        else {
           

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                Objects.equals(s.encode("TEST"), "tgst"),
                Objects.equals(s.encode("Mudasir"), "mWDCSKR"),
                Objects.equals(s.encode("YES"), "ygs"),
                Objects.equals(s.encode("This is a message"), "tHKS KS C MGSSCGG"),
                Objects.equals(s.encode("I DoNt KnOw WhAt tO WrItE"), "k dQnT kNqW wHcT Tq wRkTg")
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}