/*
Create a function named examineCurio that receives itemName as its parameter.

The function simulates a cautious visitor examining a curious item in an antique shop. It should return a modified version of the item name that reflects the visitor's careful examination.

Follow these steps to create the examined version of the item name:
- Create a new string to store the examined version of the item name.
- Iterate through each character in the original item name:
- If the character is a vowel (a, e, i, o, u - case insensitive), add it twice to the examined name.
- If it's a consonant, add it once to the examined name.
- If it's a space, add three periods (...) to represent careful pausing.

Return the examined name string.

Parameters:
- itemName (String): The name of the antique item to be examined.

The function returns a String representing the examined version of the item name.
*/

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class ExamineCurio {
    public static String examineCurio(String itemName) {
        StringBuilder examinedName = new StringBuilder();
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

        for (char c : itemName.toLowerCase().toCharArray()) {
            if (vowels.contains(c)) {
                examinedName.append(c).append(c);
            } else if (c == ' ') {
                examinedName.append("...");
            } else {
                examinedName.append(c);
            }
        }

        return examinedName.toString();
    }
}

