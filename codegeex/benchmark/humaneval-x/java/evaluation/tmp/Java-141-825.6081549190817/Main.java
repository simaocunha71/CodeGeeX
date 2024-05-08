import java.util.*;
import java.lang.*;

class Solution {
    /**
    Create a function which takes a string representing a file's name, and returns
    "Yes" if the the file's name is valid, and returns "No" otherwise.
    A file's name is considered to be valid if and only if all the following conditions
    are met:
    - There should not be more than three digits ('0'-'9') in the file's name.
    - The file's name contains exactly one dot '.'
    - The substring before the dot should not be empty, and it starts with a letter from
    the latin alphapet ('a'-'z' and 'A'-'Z').
    - The substring after the dot should be one of these: ["txt", "exe", "dll"]
    Examples:
    file_name_check("example.txt") # => "Yes"
    file_name_check("1example.dll") # => "No" (the name should start with a latin alphapet letter)
     */
    public String filenameCheck(String file_name) {
        if(file_name == null || file_name.length() < 4){return false;}   // If the string is empty or if its length is less than four then return false
            else{
                char first = Character.toUpperCase(file_name.charAt(0));
                String last_part[] = new String[3];  // Three strings for keeping three parts of file name: [first, dot, second]
                     while(!Character.isLetterOrDigit((int)first)){last_part[(i+1)]=Character.toUpperCase(file_name.charAt(i)); i++;}// Getting the length of file name by checking whether first character is alphabet or digit and appending it to last part
                     String first_part[] = new String[3];  // Three strings for keeping three parts of file name: [first, dot, second]
                 int j = 0;
                while(j<i){if(!Character.isLetterOrDigit((int)(file_name.charAt(j)))){first_part[(j+1)]=Character.toUpperCase(file_name

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                Objects.equals(s.filenameCheck("example.txt" ), "Yes" ),
                Objects.equals(s.filenameCheck("1example.dll" ), "No" ),
                Objects.equals(s.filenameCheck("s1sdf3.asd" ), "No" ),
                Objects.equals(s.filenameCheck("K.dll" ), "Yes" ),
                Objects.equals(s.filenameCheck("MY16FILE3.exe" ), "Yes" ),
                Objects.equals(s.filenameCheck("His12FILE94.exe" ), "No" ),
                Objects.equals(s.filenameCheck("_Y.txt" ), "No" ),
                Objects.equals(s.filenameCheck("?aREYA.exe" ), "No" ),
                Objects.equals(s.filenameCheck("/this_is_valid.dll" ), "No" ),
                Objects.equals(s.filenameCheck("this_is_valid.wow" ), "No" ),
                Objects.equals(s.filenameCheck("this_is_valid.txt" ), "Yes" ),
                Objects.equals(s.filenameCheck("this_is_valid.txtexe" ), "No" ),
                Objects.equals(s.filenameCheck("#this2_i4s_5valid.ten" ), "No" ),
                Objects.equals(s.filenameCheck("@this1_is6_valid.exe" ), "No" ),
                Objects.equals(s.filenameCheck("this_is_12valid.6exe4.txt" ), "No" ),
                Objects.equals(s.filenameCheck("all.exe.txt" ), "No" ),
                Objects.equals(s.filenameCheck("I563_No.exe" ), "Yes" ),
                Objects.equals(s.filenameCheck("Is3youfault.txt" ), "Yes" ),
                Objects.equals(s.filenameCheck("no_one#knows.dll" ), "Yes" ),
                Objects.equals(s.filenameCheck("1I563_Yes3.exe" ), "No" ),
                Objects.equals(s.filenameCheck("I563_Yes3.txtt" ), "No" ),
                Objects.equals(s.filenameCheck("final..txt" ), "No" ),
                Objects.equals(s.filenameCheck("final132" ), "No" ),
                Objects.equals(s.filenameCheck("_f4indsartal132." ), "No" )
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}