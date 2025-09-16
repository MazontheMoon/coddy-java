/*
Create a function named categorizeCreature that receives creatureName as its parameter.

Imagine you're a curious child exploring a magical garden. You've discovered a way to give special names to the tiny creatures you find. Your task is to create a function that takes the name of a garden creature, reverses it, and then adds a special category based on how long the reversed name is.

Here's how to solve this magical naming puzzle:
- First, reverse the name of the creature.
- Count how many letters are in the reversed name.
- Based on the length of the reversed name, add a special category:
   - If the reversed name has 1-3 letters: add "Tiny" in front
   - If it has 4-6 letters: add "Small" in front
   - If it has 7-9 letters: add "Medium" in front
   - If it has 10 or more letters: add "Large" in front
- Return the category followed by a space and then the reversed name.

Parameters:
- creatureName (String): The name of the garden creature you want to categorize. It will only contain lowercase letters.

The function returns a String that contains the category and the reversed name, separated by a space.
*/
import java.util.Collections;
import java.util.stream.Collectors;

class CategorizeCreature {
    public static String categorizeCreature(String creatureName) {
        String reversedName = new StringBuilder(creatureName).reverse().toString();
        int length = reversedName.length();
        String category;

        if (length >= 10) {
            category = "Large";
        } else if (length >= 7) {
            category = "Medium";
        } else if (length >= 4) {
            category = "Small";
        } else {
            category = "Tiny";
        }

        return category + " " + reversedName;
    }
}
