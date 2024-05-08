import java.util.*;
import java.lang.*;

class Solution {
    /**
    Given list of numbers (of at least two elements), apply a linear transform to that list,
    such that the smallest number will become 0 and the largest will become 1
    >>> rescaleToUnit(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0))
    [0.0, 0.25, 0.5, 0.75, 1.0]
     */
    public List<Double> rescaleToUnit(List<Double> numbers) {
        // Your code here
        List<Double> list = new LinkedList<>();
	for (int i=0;i<=numbers.size()-2;++i){
            Double x = numbers.get(i);
            if((x>=1&&x<=3)||(x==2)){
                if((i+1>=0&&i+1<numbers.size())&&(numbers.get(i+1)>=0.04&&numbers.get(i+1)<=0.96)) {
	            list.add(0.5);
	        } else{
	            list.add((x*x));
	        }
	    }else if((x>=3&&x<=5)||(x==4)){
                if((i+1>=0&&i+1<numbers.size())&&(numbers.get(i+1)>=0.96&&numbers.get(i+1)<=1)) {
                    list.add((x*x));
	        } else{
	            list.add(0.5);
	        }
	    }else if(x==1){
                if((i>=0&&i<numbers.size())&&(numbers.get(i)>=0.25&&numbers.get(i)<=0.96)) {
	            list.add((x*x));
	        } else{
	            list.add(1);
	        }
                break;
	    }else{
	        if((x>=0&&x<=2)||(x==3)){
                   

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.rescaleToUnit(new ArrayList<>(Arrays.asList(2.0, 49.9))).equals(Arrays.asList(0.0, 1.0)),
                s.rescaleToUnit(new ArrayList<>(Arrays.asList(100.0, 49.9))).equals(Arrays.asList(1.0, 0.0)),
                s.rescaleToUnit(new ArrayList<>(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0))).equals(Arrays.asList(0.0, 0.25, 0.5, 0.75, 1.0)),
                s.rescaleToUnit(new ArrayList<>(Arrays.asList(2.0, 1.0, 5.0, 3.0, 4.0))).equals(Arrays.asList(0.25, 0.0, 1.0, 0.5, 0.75)),
                s.rescaleToUnit(new ArrayList<>(Arrays.asList(12.0, 11.0, 15.0, 13.0, 14.0))).equals(Arrays.asList(0.25, 0.0, 1.0, 0.5, 0.75))
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}