import java.util.*;
import java.lang.*;

class Solution {
    /**
    You have to write a function which validates a given date string and
    returns true if the date is valid otherwise false.
    The date is valid if all of the following rules are satisfied:
    1. The date string is not empty.
    2. The number of days is not less than 1 or higher than 31 days for months 1,3,5,7,8,10,12. And the number of days is not less than 1 or higher than 30 days for months 4,6,9,11. And, the number of days is not less than 1 or higher than 29 for the month 2.
    3. The months should not be less than 1 or higher than 12.
    4. The date should be in the format: mm-dd-yyyy

    for example:
    validDate("03-11-2000") => true
    validDate("15-01-2012") => false
    validDate("04-0-2040") => false
    validDate("06-04-2020") => true
    validDate("06/04/2020") => false
     */
    public boolean validDate(String date) {
        if (date == null || date.length() <= 0) return false;
        Scanner sc=new Scanner(date);
        int month=sc.nextInt();
        String dayString=sc.next();
        int days=Integer.parseInt(dayString);
        sc.next();
        String year=sc.next();
        int year_int = Integer.valueOf(year).intValue(); 
        
        switch (month) {
            case 1:
                if ((days < 1 && days > 31)) return false;
                break;
            
            case 2:
                if ((days < 1 && days > 29)) return false;
                break;
            case 3:
                if ((days < 1 && days > 31)) return false;
                break;
            case 4:
               

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.validDate("03-11-2000" ) == true,
                s.validDate("15-01-2012" ) == false,
                s.validDate("04-0-2040" ) == false,
                s.validDate("06-04-2020" ) == true,
                s.validDate("01-01-2007" ) == true,
                s.validDate("03-32-2011" ) == false,
                s.validDate("" ) == false,
                s.validDate("04-31-3000" ) == false,
                s.validDate("06-06-2005" ) == true,
                s.validDate("21-31-2000" ) == false,
                s.validDate("04-12-2003" ) == true,
                s.validDate("04122003" ) == false,
                s.validDate("20030412" ) == false,
                s.validDate("2003-04" ) == false,
                s.validDate("2003-04-12" ) == false,
                s.validDate("04-2003" ) == false
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}