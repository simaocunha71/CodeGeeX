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
        ArrayList<String> res = new ArrayList<>();
        for (int i=0;i<=txt.length()-1;i++){
            if (Character.isSpaceChar(txt.charAt(i))){
                StringBuilder sb = new StringBuilder();
                String s = txt.substring(i,txt.length());
                while(!s.equals("")){
                    sb.append(s);
                    i += s.length()+1;//increase index by length of string + 1 for white space to next string
                    s = txt.substring(i,txt.length());//reuse the substring
                }
                res.add(sb.toString().toLowerCase());
            } else {
                StringBuilder sb2 = new StringBuilder();
                String s2 = txt.substring(i,txt.length());
                while(!s2.equals("")){
                    sb2.append(s2);
                    i += s2.length()+1;//increase index by length of string + 1 for white space to next string
                    s2 = txt.substring(i,txt.length());//reuse the substring
                }
                res.add(sb2.toString().toLowerCase());
            }
        }
        return res;
    }
}

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