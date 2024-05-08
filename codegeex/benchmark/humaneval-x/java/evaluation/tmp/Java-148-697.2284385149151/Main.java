import java.util.*;
import java.lang.*;

class Solution {
    /**
    There are eight planets in our solar system: the closerst to the Sun
    is Mercury, the next one is Venus, then Earth, Mars, Jupiter, Saturn,
    Uranus, Neptune.
    Write a function that takes two planet names as strings planet1 and planet2.
    The function should return a tuple containing all planets whose orbits are
    located between the orbit of planet1 and the orbit of planet2, sorted by
    the proximity to the sun.
    The function should return an empty tuple if planet1 or planet2
    are not correct planet names.
    Examples
    bf("Jupiter", "Neptune") ==> ["Saturn", "Uranus"]
    bf("Earth", "Mercury") ==> ["Venus"]
    bf("Mercury", "Uranus") ==> ["Venus", "Earth", "Mars", "Jupiter", "Saturn"]
     */
    public List<String> bf(String planet1, String planet2) {
        Map<String, Integer> map = new HashMap<>();
        map.put("Mercury", 5);
        map.put("Venus", 4);
        map.put("Earth", 3);
        map.put("Mars", 1);
        map.put("Jupiter", 0);
        map.put("Saturn", -4);
        map.put("Uranus", -5);
        map.put("Neptune", -6);
        List<String> result = new ArrayList<>();
        if (planet1 != null && planet2 != null) {
            for (int i = 0; i < map.size(); ++i) {
                if ((map.get(planet1).compareTo(map.get(planet2)) > 0) && !planetsMatch(map.get(planet1), map.get(planet2))) { // Check the distance between planet1 and planet2
                    for (int j = i + 1; j < map.size(); ++j) {
                

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.bf("Jupiter", "Neptune").equals(Arrays.asList("Saturn", "Uranus")),
                s.bf("Earth", "Mercury").equals(List.of("Venus")),
                s.bf("Mercury", "Uranus").equals(Arrays.asList("Venus", "Earth", "Mars", "Jupiter", "Saturn")),
                s.bf("Neptune", "Venus").equals(Arrays.asList("Earth", "Mars", "Jupiter", "Saturn", "Uranus")),
                s.bf("Earth", "Earth").equals(List.of()),
                s.bf("Mars", "Earth").equals(List.of()),
                s.bf("Jupiter", "Makemake").equals(List.of())
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}