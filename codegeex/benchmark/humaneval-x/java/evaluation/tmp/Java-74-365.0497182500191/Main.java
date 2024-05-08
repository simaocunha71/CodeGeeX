import java.util.*;
import java.lang.*;

class Solution {
    /**
    Write a function that accepts two lists of strings and returns the list that has
    total number of chars in the all strings of the list less than the other list.

    if the two lists have the same number of chars, return the first list.

    Examples
    totalMatch(Arrays.asList(), Arrays.asList()) -> []
    totalMatch(Arrays.asList("hi", "admin"), Arrays.asList("hI", "Hi")) -> ["hI", "Hi"]
    totalMatch(Arrays.asList("hi", "admin"), Arrays.asList("hi", "hi", "admin", "project")) -> ["hi", "admin"]
    totalMatch(Arrays.asList("hi", "admin"), Arrays.asList("hI", "hi", "hi")) -> ["hI", "hi", "hi"]
    totalMatch(Arrays.asList("4"), Arrays.asList("1", "2", "3", "4", "5")) -> ["4"]
     */
    public List<String> totalMatch(List<String> lst1, List<String> lst2) {
        // your code here
        Set<String> set1 = new HashSet();
        for (int i=0;i < lst1.size();i++) set1.add(lst1.get(i));
        
        String [] arr1 = set1.toArray(new String[set1.size()]);
        Set<String> set2 = new HashSet();
        for (int i=0;i < lst2.size();i++) set2.add(lst2.get(i));
        
        String [] arr2 = set2.toArray(new String[set2.size()]);
        List<String> result1 = new ArrayList<>(); 
        for (int i=0;i < lst1.size();i++) {
            int len1 = 1+lst1.get(i).length();
            int len2 = 1+lst2.get(i).length();
            if (len1<len2) result1.add(lst1.get(i));

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.totalMatch(new ArrayList<>(List.of()), new ArrayList<>(List.of())).equals(List.of()),
                s.totalMatch(new ArrayList<>(Arrays.asList("hi", "admin")), new ArrayList<>(Arrays.asList("hi", "hi"))).equals(Arrays.asList("hi", "hi")),
                s.totalMatch(new ArrayList<>(Arrays.asList("hi", "admin")), new ArrayList<>(Arrays.asList("hi", "hi", "admin", "project"))).equals(Arrays.asList("hi", "admin")),
                s.totalMatch(new ArrayList<>(List.of("4")), new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5"))).equals(List.of("4")),
                s.totalMatch(new ArrayList<>(Arrays.asList("hi", "admin")), new ArrayList<>(Arrays.asList("hI", "Hi"))).equals(Arrays.asList("hI", "Hi")),
                s.totalMatch(new ArrayList<>(Arrays.asList("hi", "admin")), new ArrayList<>(Arrays.asList("hI", "hi", "hi"))).equals(Arrays.asList("hI", "hi", "hi")),
                s.totalMatch(new ArrayList<>(Arrays.asList("hi", "admin")), new ArrayList<>(Arrays.asList("hI", "hi", "hii"))).equals(Arrays.asList("hi", "admin")),
                s.totalMatch(new ArrayList<>(List.of()), new ArrayList<>(List.of("this"))).equals(List.of()),
                s.totalMatch(new ArrayList<>(List.of("this")), new ArrayList<>(List.of())).equals(List.of())
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}