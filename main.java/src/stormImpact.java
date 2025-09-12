/*
Create a function named stormImpact that receives orchard and intensity as its parameters.

The function simulates the impact of a storm on an avocado orchard and returns the new layout of the orchard after the storm.

The orchard is represented by a string where 'A' represents a healthy avocado tree, 'a' represents a damaged avocado tree, and '-' represents an empty space. The storm's intensity determines how many trees are affected.

Follow these steps to implement the function:
- Convert the input string to a character array for easier manipulation.
- Iterate through the array, simulating the storm's impact:
- If the current character is 'A', there's a chance (based on storm intensity) it will be changed to 'a'.
- If the current character is 'a', there's a chance it will be changed to '-'.
- Empty spaces ('-') remain unchanged.
- Convert the modified character array back to a string and return it.
To determine if a tree is affected, use the following formula: if (i % (10 - intensity) == 0), where i is the current index in the array.

Parameters:
- orchard (String): A string representing the initial layout of the orchard.
- intensity (int): An integer between 1 and 9 representing the storm's intensity.

The function returns a String representing the new layout of the orchard after the storm.
 */
import java.util.Arrays;

public class stormImpact {
    public static String stormImpact(String orchard, int intensity) {
        char[] trees = orchard.toCharArray();

        for (int i = 0; i < trees.length; i++) {
            if (i % (10 - intensity) == 0) {
                if (trees[i] == 'A') {
                    trees[i] = 'a';
                } else if (trees[i] == 'a') {
                    trees[i] = '-';
                }
            }
        }

        return new String(trees);
    }
}
