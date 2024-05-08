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
        if (a == null || b == null) return Optional.of(b);
        if (a instanceof Float && b instanceof Integer) // a Float and b is Integer
            return Optional.of((float) Math.max(a.doubleValue(), b));
        else if (a instanceof Double && b instanceof Long) {// a Double and b is Long
            return Optional.of((double) Math.max(a.doubleValue(), ((Long) b).intValue()));
        }
        return Optional.empty();
    }
}

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