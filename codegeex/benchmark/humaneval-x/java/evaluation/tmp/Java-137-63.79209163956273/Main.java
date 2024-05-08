import java.util.*;
import java.lang.*;

class Solution {
    /**
    Create a function that takes integers, floats, or strings representing
    real numbers, and returns the larger variable in its given variable type.
    Return None if the values are equal.
    Note: If a real number is represented as a string, the floating point might be . or ,

    compareOne(1, 2.5) -> Optional.of(2.5)
    compareOne(1, "2,3") -> Optional.of("2,3")
    compareOne("5,1", "6") -> Optional.of("6")
    compareOne("1", 1) -> Optional.empty()
     */
    public Optional<Object> compareOne(Object a, Object b) {
        if (a == null || b == null) return Optional.of(Optional.ofNullable(a).orElse(b));
       //If one of the number is an integer and other is a string then return the Integer value
       if ((a instanceof Integer))
           return Optional.of(a);
        else{
            if (b instanceof String) {
                //convert given float/integer to string and check whether it is greater than provided one
                String strA = "" + ((Integer) a).toString();
                String strB = "" + ((String) b).toString();
                return Optional.of(strcmp(strA, strB));}
            else{
                //convert given float/integer to string and check whether it is greater than provided one
                String strA = "" + ((Double) a).toString();
                String strB = "" + ((String) b).toString();
                return Optional.of(strcmp(strA, strB));}
        }
    }
     //method to compare two string values
    private static int strcmp(String a, String b){
       if (a == null || a =="0"){
            if (b!=null) return -1;
         }else {
             Integer iA=Integer.parseInt(a);
             Integer iB=Integer.parseInt(b);
           //return the integer value that is greater than other given integer by one
               return(iA-1)>>(iB-1)?

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                (int) s.compareOne(1, 2).get() == 2,
                (double) s.compareOne(1, 2.5).get() == 2.5,
                (int) s.compareOne(2, 3).get() == 3,
                (int) s.compareOne(5, 6).get() == 6,
                (String) s.compareOne(1, "2,3").get() == "2,3",
                (String) s.compareOne("5,1", "6").get() == "6",
                (String) s.compareOne("1", "2").get() == "2",
                s.compareOne("1", 1).isEmpty()
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}