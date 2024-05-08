import java.util.*;
import java.lang.*;

class Solution {
    /**
    Input to this function is a string representing musical notes in a special ASCII format.
    Your task is to parse this string and return list of integers corresponding to how many beats does each
    not last.

    Here is a legend:
    "o" - whole note, lasts four beats
    "o|" - half note, lasts two beats
    ".|" - quater note, lasts one beat

    >>> parseMusic("o o| .| o| o| .| .| .| .| o o")
    [4, 2, 1, 2, 2, 1, 1, 1, 1, 4, 4]
     */
    public List<Integer> parseMusic(String string) {
        List<Integer> list = new ArrayList<>();
        int i=0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        if (string.length() == 0 || !string.contains("o") && !string.contains(".|")) {
            return list;
        }
        
        while(i< string.length()) {
           char c = string.charAt(i);
           map.putIfAbsent(c,1);
           i++;
        }
        for (Character key : map.keySet() ) {
            list.add((int)map.get(key));
        }
        return list;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.parseMusic("").equals(List.of()),
                s.parseMusic("o o o o").equals(Arrays.asList(4, 4, 4, 4)),
                s.parseMusic(".| .| .| .|").equals(Arrays.asList(1, 1, 1, 1)),
                s.parseMusic("o| o| .| .| o o o o").equals(Arrays.asList(2, 2, 1, 1, 4, 4, 4, 4)),
                s.parseMusic("o| .| o| .| o o| o o|").equals(Arrays.asList(2, 1, 2, 1, 4, 2, 4, 2))
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}