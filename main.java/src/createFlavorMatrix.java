/*
Create a function named createFlavorMatrix that receives mainIngredients and seasonings as its parameters.
Your task is to create a culinary flavor matrix by combining main ingredients with various seasonings. This matrix will represent unique flavor combinations, simulating a culinary experiment in the kitchen.
The function should create and return a 2D array where each element is a combination of a main ingredient and a seasoning. Follow these steps:

- Create a 2D string array with dimensions: number of main ingredients × number of seasonings.
- Use nested loops to iterate through both input arrays.
- For each combination, concatenate the main ingredient with the seasoning, separated by a space and a plus sign.
- Store each combination in the corresponding cell of the 2D array.

Parameters:
- mainIngredients (String[]): An array of strings representing the main ingredients.
- seasonings (String[]): An array of strings representing the seasonings.

The function returns a 2D string array (String[][]) representing the flavor matrix.
*/
import java.util.Arrays;

class CreateFlavorMatrix {
    public static String[][] createFlavorMatrix(String[] mainIngredients, String[] seasonings) {
        int rows = mainIngredients.length;
        int cols = seasonings.length;
        String[][] flavorMatrix = new String[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                flavorMatrix[i][j] = mainIngredients[i] + " + " + seasonings[j];
            }
        }

        return flavorMatrix;
    }
}
