import java.util.*;
import java.lang.*;

class Solution {
    /**
    We have an array 'arr' of N integers arr[1], arr[2], ..., arr[N].The
    numbers in the array will be randomly ordered. Your task is to determine if
    it is possible to get an array sorted in non-decreasing order by performing
    the following operation on the given array:
        You are allowed to perform right shift operation any number of times.

    One right shift operation means shifting all elements of the array by one
    position in the right direction. The last element of the array will be moved to
    the starting position in the array i.e. 0th index.

    If it is possible to obtain the sorted array by performing the above operation
    then return true else return False.
    If the given array is empty then return true.

    Note: The given list is guaranteed to have unique elements.

    For Example:

    moveOneBall(Arrays.asList(3, 4, 5, 1, 2))==>true
    Explanation: By performin 2 right shift operations, non-decreasing order can
                 be achieved for the given array.
    moveOneBall(Arrays.asList(3, 5, 4, 1, 2))==>False
    Explanation:It is not possible to get non-decreasing order for the given
                array by performing any number of right shift operations.
     */
    public boolean moveOneBall(List<Integer> arr) {
        if (arr == null || arr.isEmpty()) return true;
        
        Arrays.sort(arr);  //time O(NlogN)
        Queue<Integer> queue = new LinkedQueue<>();   //time O(N)
        for (int i = 0; i < arr.size(); i++) {
            while (!queue.isEmpty() && !(queue.peek().compareTo(arr.get(i)) >= 0));
            if (queue.isEmpty()) return false;
            
            int val = queue.removeFirst();
            if (val == arr.get(i) - 1) {
                queue.addLast

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.moveOneBall(new ArrayList<>(Arrays.asList(3, 4, 5, 1, 2))) == true,
                s.moveOneBall(new ArrayList<>(Arrays.asList(3, 5, 10, 1, 2))) == true,
                s.moveOneBall(new ArrayList<>(Arrays.asList(4, 3, 1, 2))) == false,
                s.moveOneBall(new ArrayList<>(Arrays.asList(3, 5, 4, 1, 2))) == false,
                s.moveOneBall(new ArrayList<>(Arrays.asList())) == true
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}