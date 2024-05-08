import java.util.*;
import java.lang.*;

class Solution {
    /**
    Write a function that returns true if the given number is the multiplication of 3 prime numbers
    and false otherwise.
    Knowing that (a) is less then 100.
    Example:
    isMultiplyPrime(30) == true
    30 = 2 * 3 * 5
     */
    public boolean isMultiplyPrime(int a) {
        if(a <= 0){return false;}
         else{  int n=1;
            boolean flag=false;  while((n<=100)&&(!flag)){
             for(int i=2;i<101;i++){
             	if (a%i == 0 && a!=i){
                    flag = true;   break;} } n++;}return flag;}
         }  public static void main(String[] args) {
        Solution solution = new Solution();
          System.out.println("Enter any number: " + System.in());
            int num=10;
                    for (int i = 2; i < 101; i++) {
                if (a % i == 0 && a != i) {
                   flag = true; break;}
                else{ }}}
         return;
     }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                !s.isMultiplyPrime(5),
                s.isMultiplyPrime(30),
                s.isMultiplyPrime(8),
                !s.isMultiplyPrime(10),
                s.isMultiplyPrime(125),
                s.isMultiplyPrime(3 * 5 * 7),
                !s.isMultiplyPrime(3 * 6 * 7),
                !s.isMultiplyPrime(9 * 9 * 9),
                !s.isMultiplyPrime(11 * 9 * 9),
                s.isMultiplyPrime(11 * 13 * 7)
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}