/*
Create a function named prepareCakeOrder that receives cakesOrdered and availableIngredients as its parameters.

You are a cake maker in a small-town bakery facing unexpected challenges. Your task is to prepare as many cakes as possible based on the order and available ingredients.

Follow these rules:
- Each cake requires exactly 3 ingredients.
- Skip any spoiled ingredient (represented by the string "spoiled" in the ingredient array).
- Stop making cakes if there are not enough ingredients for a full cake.
- Use basic control flow (continue for spoiled ingredients) and string formatting to solve this challenge.

Parameters:
- cakesOrdered (int): The number of cakes ordered (1 ≤ cakesOrdered ≤ 100).
- availableIngredients (String[]): Array of available ingredients (1 ≤ availableIngredients.length ≤ 300).

The function returns a string in the format: "Made X cakes with ingredients: [ingredient1, ingredient2, ingredient3, ...]", where X is the number of cakes successfully made, and the ingredients list contains all the ingredients used in the order they were used.
*/

import java.util.ArrayList;
import java.util.List;

class PrepareCakeOrder {
    public static String prepareCakeOrder(int cakesOrdered, String[] availableIngredients) {
        List<String> usedIngredients = new ArrayList<>();
        int cakesMade = 0;
        int ingredientCount = 0;

        for (String ingredient : availableIngredients) {
            if (ingredient.equals("spoiled")) {
                continue;
            }

            usedIngredients.add(ingredient);
            ingredientCount++;

            if (ingredientCount == 3) {
                cakesMade++;
                ingredientCount = 0;

                if (cakesMade == cakesOrdered) {
                    break;
                }
            }
        }

        return String.format("Made %d cakes with ingredients: %s", cakesMade, usedIngredients.toString());
    }
}