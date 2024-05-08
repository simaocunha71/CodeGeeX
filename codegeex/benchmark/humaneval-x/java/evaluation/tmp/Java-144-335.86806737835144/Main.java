import java.util.*;
import java.lang.*;

class Solution {
    /**
    Your task is to implement a function that will simplify the expression
    x * n. The function returns true if x * n evaluates to a whole number and false
    otherwise. Both x and n, are string representation of a fraction, and have the following format,
    <numerator>/<denominator> where both numerator and denominator are positive whole numbers.

    You can assume that x, and n are valid fractions, and do not have zero as denominator.

    simplify("1/5", "5/1") = true
    simplify("1/6", "2/1") = false
    simplify("7/10", "10/2") = false
     */
    public boolean simplify(String x, String n) {
        // your code here
        int num;
        float den, result=0.0f;
        try{
            num=Integer.parseInt(n);
            den=Float.parseFloat(x);
            if (den<1||num<0){
                return false;
            }
            if (!den) {
                return false;
            }
            if ((den%1!=0)){
                result=(float)(num/(((long)den)*(long)10));
            }else{
                result=(float) num/(long) den;
            }
        }catch(Exception e){
            return false;
        }
        if (result==0.0f||result==1.0f) {//if there is no remainder then we can say that it is a whole number
                                               //or else we cannot consider it as whole
            return result==1.0f?true:false;
        }else{
        	return result == 2.0f;// if we find remainder = 2 (a remainder of 2
                                    // is not considered as a whole number) then it would be simplified to 2.
            return false;
        }  
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.simplify("1/5", "5/1") == true,
                s.simplify("1/6", "2/1") == false,
                s.simplify("5/1", "3/1") == true,
                s.simplify("7/10", "10/2") == false,
                s.simplify("2/10", "50/10") == true,
                s.simplify("7/2", "4/2") == true,
                s.simplify("11/6", "6/1") == true,
                s.simplify("2/3", "5/2") == false,
                s.simplify("5/2", "3/5") == false,
                s.simplify("2/4", "8/4") == true,
                s.simplify("2/4", "4/2") == true,
                s.simplify("1/5", "5/1") == true,
                s.simplify("1/5", "1/5") == false
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}