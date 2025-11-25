/*
Create a function named plumpCushions that receives numCushions and desiredPlumpness as its parameters.

The function simulates a candle maker's cushion plumping process in their cozy workshop. It should return an array representing the state of each cushion after plumping.

The candle maker starts with each cushion at a plumpness level of 1 and continues plumping until the desired plumpness level is reached. Use loops to iterate through the cushions and increase their plumpness, and use conditional statements to describe the state of each cushion.

Parameters:
- numCushions (int): The number of cushions to plump (1 to 10 cushions).
- desiredPlumpness (int): The desired plumpness level (1 to 5, where 1 is barely plump and 5 is very plump).

The function returns a String array, where each element describes the final state of a cushion.

Use the following descriptions for each plumpness level:
1: "barely plump"
2: "slightly plump"
3: "moderately plump"
4: "very plump"
5: "extremely plump"
If the input parameters are outside the specified ranges, return an empty array.
*/

import java.util.Arrays;

class PlumpCushions {
    public static String[] plumpCushions(int numCushions, int desiredPlumpness) {
        if (numCushions < 1 || numCushions > 10 || desiredPlumpness < 1 || desiredPlumpness > 5) {
            return new String[0];
        }

        String[] cushionStates = new String[numCushions];
        Arrays.fill(cushionStates, "barely plump");

        for (int plumpness = 1; plumpness < desiredPlumpness; plumpness++) {
            for (int i = 0; i < numCushions; i++) {
                cushionStates[i] = getPlumpnessDescription(plumpness + 1);
            }
        }

        return cushionStates;
    }

    private static String getPlumpnessDescription(int plumpness) {
        switch (plumpness) {
            case 1:
                return "barely plump";
            case 2:
                return "slightly plump";
            case 3:
                return "moderately plump";
            case 4:
                return "very plump";
            case 5:
                return "extremely plump";
            default:
                return "";
        }
    }
}