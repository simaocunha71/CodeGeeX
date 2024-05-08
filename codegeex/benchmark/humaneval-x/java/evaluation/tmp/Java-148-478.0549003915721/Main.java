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
        ArrayList<String> planets = new ArrayList<>();
        
        for (int index = 0; index < planetNames.length(); index++) {
            int indexDistance = Math.abs(planet1.compareTo(planetNames[index]));
            
            if (indexDistance > index) { // Check if the planetName is between planet1 and planet2
                for (int i = 0; i < planetNames.length(); i++) {
                    int dist = Math.abs(planet2.compareTo(planetNames[i]));
                    
                    if (indexDistance + dist <= index) { // Check if the distance is smaller than the current index (which contains planets between planet1 and planet2)
                        String tempPlanet = planetNames[i];
                        
                        if (!planets.contains(tempPlanet)) {
                            planets.add(tempPlanet);
                        }
                    }
                }
            }
        }
    
        // Sort the list in order of proximity to the sun
        Collections.sort

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