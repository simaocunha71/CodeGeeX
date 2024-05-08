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
        if (lst1 == null || lst1.isEmpty()) return lst2; // if Lst1 is empty, then return list of strings in lst 2
        
        if(lst2 == null || lst2.isEmpty()){ // else if lst2 is empty, then return all the strings of lst1
            ArrayList<String> totalList = new ArrayList<>();// create a new arraylist to store the result
            
            for (String s : lst1) {
                String checkStr = "";
                checkStr += s; // concatenate each string into one
                
                if(checkStr.length() > 0){ // if total length of chars in all strings of lst1 is greater than the length of lst2, then return lst1
                    totalList.add(checkStr);
                }else{return lst1;}// else if it's not, then return lst1 with total strings less than the other list
            }
            
            return totalList; // return new arraylist that stores all strings of lst1 with total numbers

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