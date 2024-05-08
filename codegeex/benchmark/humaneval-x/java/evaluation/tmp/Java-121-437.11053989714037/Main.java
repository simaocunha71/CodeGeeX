import java.util.*;
import java.lang.*;

class Solution {
    /**
    Given a non-empty list of integers, return the sum of all of the odd elements that are in even positions.

    Examples
    solution(Arrays.asList(5, 8, 7, 1)) ==> 12
    solution(Arrays.asList(3, 3, 3, 3, 3)) ==> 9
    solution(Arrays.asList(30, 13, 24, 321)) ==>0
     */
    public int solution(List<Integer> lst) {
        if (lst == null || lst.size() <= 0 ) return -1; // check parameter validity
        int sum = 0;
        for(int num: lst){//for each element in the list, find its position and calculate the sum of odd numbers at even position.
            if ((num % 2) != 0 && (num % 2) == 1){//check for the case where we have an odd number that is also at odd positions
                int pos = 0; //position
                while(pos < lst.size()){ //for each position, check if it is even and if so add it to sum
                    if (lst.get(pos) % 2 == 0 && lst.get(pos) != 0 ){//check for any even num that is at even position
                        pos++; //increment the position to the next odd element.
                    }else {
                        break;//if we come across an even number and it is not at even place, break with continue.
                    }
                }
                if (lst.get(pos) != 0 && lst.get(pos) % 2 == 1 ){
                    sum += lst.get(pos);
                }
            }
        }
        return sum;//return the total sum of odd numbers which are also at even positions in the given list.
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.solution(Arrays.asList(5, 8, 7, 1)) == 12,
                s.solution(Arrays.asList(3, 3, 3, 3, 3)) == 9,
                s.solution(Arrays.asList(30, 13, 24, 321)) == 0,
                s.solution(Arrays.asList(5, 9)) == 5,
                s.solution(Arrays.asList(2, 4, 8)) == 0,
                s.solution(Arrays.asList(30, 13, 23, 32)) == 23,
                s.solution(Arrays.asList(3, 13, 2, 9)) == 3
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}