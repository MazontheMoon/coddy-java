/*
Create a function named countStars that receives initialStars and minutes as its parameters.

The function simulates a stargazer counting stars in the night sky on a barren hilltop. For each minute that passes, the stargazer sees one more star.
Use basic increment operators to increase the star count and basic string formatting to create the output message.

Parameters:
- initialStars (int): The number of stars visible at the beginning of the observation.
- minutes (int): The number of minutes spent stargazing.

The function returns a formatted string describing the stargazing experience. The string should include:
- The initial number of stars
- The final number of stars
- The number of minutes spent stargazing

A simple ASCII art representation of stars (use asterisks *)
 */
public class countStars {
    public static String countStars(int initialStars, int minutes) {
        int finalStars = initialStars + minutes;
        String stars = "*".repeat(finalStars);

        return String.format("Initial stars: %d\nFinal stars: %d\nMinutes spent: %d\nStars: %s",
                initialStars, finalStars, minutes, stars);
    }
}
