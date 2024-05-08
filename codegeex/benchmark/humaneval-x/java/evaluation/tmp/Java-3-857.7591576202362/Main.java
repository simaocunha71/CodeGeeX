import java.util.*;
import java.lang.*;

class Solution {
    /**
    You're given a list of deposit and withdrawal operations on a bank account that starts with
    zero balance. Your task is to detect if at any point the balance of account fallls below zero, and
    at that point function should return True. Otherwise it should return False.
    >>> belowZero(Arrays.asList(1, 2, 3))
    false
    >>> belowZero(Arrays.asList(1, 2, -4, 5))
    true
     */
    public boolean belowZero(List<Integer> operations) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < operations.size(); i++)
            map.put(operations.get(i), map.getOrDefault(operations.get(i-1), 0)+1);
        //for each operation and its previous operation, check if balance goes below zero
        for (int i = 0; i < operations.size(); i++) {
            int currBal = 0;
            
            //check if current operation is a withdrawal
            boolean isWrithdrawal = false;
            if(operations.get(i)%2==1){
                isWrithdrawal = true;
            } else {
                currBal += operations.get(i);  //balance decreases by the operation amount
                continue;
            }
            
            //check if previous operation was a withdrawal or deposit
            boolean prevIsDeposit = (map.putIfAbsent(operations.get(i-1),0)+1) == 0;
            while(!isWrithdrawal && !prevIsDeposit){
                if(currBal < 0){
                    return true;
                } else {
                    currBal += operations.get(i);//balance decreases by operation amount (not +1)
                    
                    prevIsDeposit = map.putIfAbsent(operations.get(i-1),0)+1 == 0; // check if previous was a withdrawal or deposit
                }
            }
       

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                !s.belowZero(new ArrayList<>(Arrays.asList())),
                !s.belowZero(new ArrayList<>(Arrays.asList(1, 2, -3, 1, 2, -3))),
                s.belowZero(new ArrayList<>(Arrays.asList(1, 2, -4, 5, 6))),
                !s.belowZero(new ArrayList<>(Arrays.asList(1, -1, 2, -2, 5, -5, 4, -4))),
                s.belowZero(new ArrayList<>(Arrays.asList(1, -1, 2, -2, 5, -5, 4, -5))),
                s.belowZero(new ArrayList<>(Arrays.asList(1, -2, 2, -2, 5, -5, 4, -4)))
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}