import java.util.*;
import java.lang.*;

class Solution {
    /**
    Input is a space-delimited string of numberals from 'zero' to 'nine'.
    Valid choices are 'zero', 'one', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight' and 'nine'.
    Return the string with numbers sorted from smallest to largest
    >>> sortNumbers("three one five")
    "one three five"
     */
    public String sortNumbers(String numbers) {
        if (numbers == null || numbers.length() < 1) return numbers;
      
        String[] numbersArray = numbers.trim().split(" ");
        //create a new ArrayList of strings with the sorted numberals.
        List<String> sortedNumbersList = new ArrayList<>();
        for (int i = 0; i < numbersArray.length; i++) {
            if (!(numbersArray[i].equals("zero") && numbersArray[i].equals("one")) && !(numbersArray[i]
                    .equals("two") && numbersArray[i].equals("three")) && !(numbersArray[i]
                    .equals("four") && numbersArray[i].equals("five")) && !(numbersArray[i]
                    .equals("six") && numbersArray[i].equals("seven")) && !(numbersArray[i]
                    .equals("eight") && numbersArray[i].equals("nine"))) {
                sortedNumbersList.add(numbersArray[i]);
            } else if (numbersArray[i].equals("zero") || numbersArray[i].equals("one")) {
                sortedNumbersList.add("zero");
                sortedNumbersList.add("one");
                break; //end of for loop to skip the rest of the numberals, since you already added both zero and one in it.
            } else if (numbersArray[i].equals("two") || numbersArray[i].equals("three")) {
                sortedNumbersList.add("two");
                sortedNumbersList.add("three");
                break; //end of for loop to skip the rest of the numberals, since you already added both two and three in it.
            } else if (

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.sortNumbers("").equals(""),
                s.sortNumbers("three").equals("three"),
                s.sortNumbers("three five nine").equals("three five nine"),
                s.sortNumbers("five zero four seven nine eight").equals("zero four five seven eight nine")
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}