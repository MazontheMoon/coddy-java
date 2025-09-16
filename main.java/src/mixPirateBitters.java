/*
Create a function named mixPirateBitters that receives numIngredients and mixingPattern as its parameters.
Your task is to simulate a pirate's slapdash attempt at mixing bitters for a rum cocktail aboard their weathered ship. The function should return a string that describes the mixing process and the final concoction.
Use a loop to iterate through the mixing pattern, keeping track of the current ingredient. For each action in the pattern, add a line to the output string describing what happened. After processing all actions, add a final line about the readiness of the bitters.

Parameters:
- numIngredients (int): The number of ingredients available for mixing (1 to 10).
- mixingPattern (String): A string consisting of 'S' for stir and 'P' for pour, representing the mixing actions.

The function should process the mixing pattern as follows:

- If the action is 'S', add "Stirred ingredient X" to the output.
- If the action is 'P', add "Poured ingredient X" to the output.
- X is the current ingredient number, which should cycle back to 1 after reaching numIngredients.
- After processing all actions, add a final line: "Arrr! The bitters be ready with Y ingredients!", where Y is the total number of unique ingredients used.

The function returns a string containing all the mixing steps and the final statement, with each step on a new line.
*/
import java.util.HashSet;

class MixPirateBitters {
    public static String mixPirateBitters(int numIngredients, String mixingPattern) {
        StringBuilder output = new StringBuilder();
        int currentIngredient = 1;
        HashSet<Integer> usedIngredients = new HashSet<>();

        for (char action : mixingPattern.toCharArray()) {
            if (action == 'S') {
                output.append("Stirred ingredient ").append(currentIngredient).append("\n");
            } else if (action == 'P') {
                output.append("Poured ingredient ").append(currentIngredient).append("\n");
            }
            usedIngredients.add(currentIngredient);
            currentIngredient = (currentIngredient % numIngredients) + 1;
        }

        output.append("Arrr! The bitters be ready with ").append(usedIngredients.size()).append(" ingredients!");
        return output.toString();
    }
}
