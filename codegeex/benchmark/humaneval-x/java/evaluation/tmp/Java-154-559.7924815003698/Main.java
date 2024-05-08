import java.util.*;
import java.lang.*;

class Solution {
    /**
    You are given 2 words. You need to return true if the second word or any of its rotations is a substring in the first word
    cycpatternCheck("abcd","abd") => false
    cycpatternCheck("hello","ell") => true
    cycpatternCheck("whassup","psus") => false
    cycpatternCheck("abab","baa") => true
    cycpatternCheck("efef","eeff") => false
    cycpatternCheck("himenss","simen") => true
     */
    public boolean cycpatternCheck(String a, String b) {
        if (a.length() == 0 || b.length() == 0 ) return true;
        int len = Math.min(b.length(), a.length());
        Deque<Character> s1 = new ArrayDeque();
        for (int i=0; i < len; ++i) {
            char c = b.charAt(i);
            if (c == b.charAt(i)) { // not rotated
                s1.push(c);
            } else {
                Deque<Character> q1 = new ArrayDeque();
                while (!s1.isEmpty()) { 
                    char c1 = s1.removeLast();
                    if (a.indexOf(c1) != -1){
                        for (int j=0; j < a.length(); ++j) {
                            Character c2 = a.charAt(j);
                            if (c2 == c1 && q1.isEmpty()) return true;
                            Deque<Character> q3 = new ArrayDeque(); // q3 is rotated
                            while (!q1.isEmpty()){
                                char c4 = q1.removeLast();
                                if (a.indexOf(c4) != -1 && c2 == c4) { 
                                    return true;
                                } else { 
                                    int start = Math.max(0,j-len+q1.size());
                                    for (int j3=start; j3 <= j; ++j3){

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.cycpatternCheck("xyzw", "xyw") == false,
                s.cycpatternCheck("yello", "ell") == true,
                s.cycpatternCheck("whattup", "ptut") == false,
                s.cycpatternCheck("efef", "fee") == true,
                s.cycpatternCheck("abab", "aabb") == false,
                s.cycpatternCheck("winemtt", "tinem") == true
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}