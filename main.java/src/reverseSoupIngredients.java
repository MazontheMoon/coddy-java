/*
Create a function named reverseSoupIngredients that receives ingredients as its parameter.

In a bustling restaurant kitchen, a creative chef is preparing a flavorful soup with a unique twist - reversing the order of ingredients! Your task is to help the chef by implementing this special technique.

The function should take a string of ingredients separated by commas and return a new string with the ingredients in reverse order, still separated by commas.

Parameters:
- ingredients (String): A string containing ingredients separated by commas (e.g., "tomato,onion,carrot,celery").

The function returns a String with the ingredients reversed and still separated by commas (e.g., "celery,carrot,onion,tomato").

Note: The ingredients themselves should not be reversed, only their order in the list.
*/

import java.util.Arrays;

class ReverseSoupIngredients {
    public static String reverseSoupIngredients(String ingredients) {
        String[] ingredientArray = ingredients.split(",");
        StringBuilder reversed = new StringBuilder();

        for (int i = ingredientArray.length - 1; i >= 0; i--) {
            reversed.append(ingredientArray[i]);
            if (i > 0) {
                reversed.append(",");
            }
        }

        return reversed.toString();
    }
}