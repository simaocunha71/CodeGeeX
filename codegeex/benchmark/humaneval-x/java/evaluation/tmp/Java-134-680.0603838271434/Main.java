import java.util.*;
import java.lang.*;

class Solution {
    /**
    Create a function that returns true if the last character
    of a given string is an alphabetical character and is not
    a part of a word, and false otherwise.
    Note: "word" is a group of characters separated by space.

    Examples:
    checkIfLastCharIsALetter("apple pie") -> false
    checkIfLastCharIsALetter("apple pi e") -> true
    checkIfLastCharIsALetter("apple pi e ") -> false
    checkIfLastCharIsALetter("") -> false
     */
    public boolean checkIfLastCharIsALetter(String txt) {
        if (txt.length() == 0) return false;
        
        Scanner sc = new Scanner(System.in);
        String wordEnding = sc.next(); //gets last char of string inputted by user
        System.out.println("The ending is " + wordEnding);
        return checkIfLastCharIsALetter(wordEnding, txt) || !checkIfLetter(wordEnding, txt);
    }
    
    private boolean checkIfLastCharIsALetter(String char1, String str){
        if (char1.equals(" ")) { //checks if the string ends with a space and returns false because spaces are not letters
            return false;
        }
        
        int index = str.lastIndexOf(char1);
        System.out.println("The last character is: " + char1);
        String wordSurroundedBySpaces = str.substring(0,index) + " " + str.substring(index + 1); //concatenates spaces to the end of string and starts from beginning (no index)
        System.out.println("The concatenated string with the space in it is: " + wordSurroundedBySpaces);
        
        char1 = str.charAt(index - 1); //gets last character before it
        System.out.println("The previous letter to the one you inputted (" + char1 + ") is: " + (str.substring(0, index - 2))); //concatenates string but starts from beginning and ends at the desired char
        

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.checkIfLastCharIsALetter("apple" ) == false,
                s.checkIfLastCharIsALetter("apple pi e" ) == true,
                s.checkIfLastCharIsALetter("eeeee" ) == false,
                s.checkIfLastCharIsALetter("A" ) == true,
                s.checkIfLastCharIsALetter("Pumpkin pie " ) == false,
                s.checkIfLastCharIsALetter("Pumpkin pie 1" ) == false,
                s.checkIfLastCharIsALetter("" ) == false,
                s.checkIfLastCharIsALetter("eeeee e " ) == false,
                s.checkIfLastCharIsALetter("apple pie" ) == false,
                s.checkIfLastCharIsALetter("apple pi e " ) == false
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}