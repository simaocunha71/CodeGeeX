import java.util.*;
import java.lang.*;

class Solution {
    /**
    Check if in given list of numbers, are any two numbers closer to each other than given threshold.
    >>> hasCloseElements(Arrays.asList(1.0, 2.0, 3.0), 0.5)
    false
    >>> hasCloseElements(Arrays.asList(1.0, 2.8, 3.0, 4.0, 5.0, 2.0), 0.3)
    true
     */
    public boolean hasCloseElements(List<Double> numbers, double threshold) {
        if (numbers == null || numbers.isEmpty()) return false;
        
        Map map = new HashMap();
        for (int i=0;i<numbers.size();++i){
            String s = ""+numbers.get(i);
            int index = s.indexOf('e');
            if(index>-1 && Double.parseDouble(s.substring(0, index)) > threshold) {
                map.put(numbers.get(i), Integer.valueOf(""+map.get(numbers.get(i)))+1);
            } else  map.put(numbers.get(i), Integer.valueOf(""+map.get(numbers.get(i))));
        }
        
        List<Map.Entry> elements = new ArrayList(map.entrySet());
        Collections.sort(elements, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Map.Entry entry1 = (Map.Entry)o1;
                Map.Entry entry2 = (Map.Entry)o2;
                return Double.compare(entry1.getValue(), entry2.getValue());  
            }
        });
        
        int index = 0;
        boolean flag=false;
        while (index<elements.size() && !flag){
            
            String s1 = ""+elements.get(index).key;
            map = new HashMap();
            for (int j=index-i;j>=0;j--){
                String s2 =""+elements.get(j).key;
                int index2 = s2.indexOf('e');
                    if(index2>-1 && Double.parseDouble(s2.substring(0, index2)) > threshold) {
                map.put(elements.get(i).value+" "+elements.get(j+1).key, Integer.valueOf(""+map.get(elements.get(i+1).key)));
                    } else  map.put(elements.get(i).value+" "+elements.get(j+1).key, Integer.valueOf(""+map.get(elements.get(i+1).key)));  
            }
            
            System.out.println("\n"+s1+"\n");

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.hasCloseElements(new ArrayList<>(Arrays.asList(11.0, 2.0, 3.9, 4.0, 5.0, 2.2)), 0.3),
                !s.hasCloseElements(new ArrayList<>(Arrays.asList(1.0, 2.0, 3.9, 4.0, 5.0, 2.2)), 0.05),
                s.hasCloseElements(new ArrayList<>(Arrays.asList(1.0, 2.0, 5.9, 4.0, 5.0)), 0.95),
                !s.hasCloseElements(new ArrayList<>(Arrays.asList(1.0, 2.0, 5.9, 4.0, 5.0)), 0.8),
                s.hasCloseElements(new ArrayList<>(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0, 2.0)), 0.1),
                s.hasCloseElements(new ArrayList<>(Arrays.asList(1.1, 2.2, 3.1, 4.1, 5.1)), 1.0),
                !s.hasCloseElements(new ArrayList<>(Arrays.asList(1.1, 2.2, 3.1, 4.1, 5.1)), 0.5)
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}