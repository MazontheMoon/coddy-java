/*
Create a function named categorizeSpecimens that receives specimens, largeThreshold, rareColorCode, and complexThreshold as its parameters.

As a curious naturalist in a quiet laboratory, you're tasked with examining and categorizing unusual specimens. Your function will analyze various attributes of these specimens and perform specific operations on them.

Parameters:
- specimens (int[][]): A 2D integer array representing the specimens and their attributes. Each row represents a specimen, and the columns represent:
	- Column 0: Size of the specimen
	- Column 1: Color code of the specimen
	- Column 2: Number of appendages of the specimen
- largeThreshold (int): The minimum size for a specimen to be considered "large"
- rareColorCode (int): The color code that identifies "rare" specimens
- complexThreshold (int): The minimum number of appendages for a specimen to be considered "complex"

Your function should perform the following operations:
- Count the number of "large" specimens (those with size greater than or equal to largeThreshold).
- Identify all "rare" specimens (those with a color code matching rareColorCode) and change their color code to -1.
- Calculate the average number of appendages for all "complex" specimens (those with appendages greater than or equal to complexThreshold).
Create a new integer array containing the indices of all specimens that are both "large" and "rare".
Sort the original specimens array based on the size of the specimens in descending order.
The function returns a string array containing the following information:

The count of "large" specimens.
The average number of appendages for "complex" specimens (rounded to two decimal places).
The sorted specimens array (converted to a string representation).
The new array containing indices of "large" and "rare" specimens (converted to a string representation).
Note: When converting arrays to string representations, use the format "[element1, element2, ...]" for 1D arrays and "[[row1elem1, row1elem2, ...], [row2elem1, row2elem2, ...], ...]" for 2D arrays.
*/

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class CategorizeSpecimens {
    public static String[] categorizeSpecimens(int[][] specimens, int largeThreshold, int rareColorCode, int complexThreshold) {
        int largeCount = 0;
        int complexCount = 0;
        double complexAppendagesSum = 0;
        ArrayList<Integer> largeAndRareIndices = new ArrayList<>();

        // Step 1, 2, 3, and 4
        for (int i = 0; i < specimens.length; i++) {
            if (specimens[i][0] >= largeThreshold) {
                largeCount++;
                if (specimens[i][1] == rareColorCode) {
                    largeAndRareIndices.add(i);
                }
            }
            if (specimens[i][1] == rareColorCode) {
                specimens[i][1] = -1;
            }
            if (specimens[i][2] >= complexThreshold) {
                complexCount++;
                complexAppendagesSum += specimens[i][2];
            }
        }

        // Step 5: Sort specimens
        Arrays.sort(specimens, (a, b) -> Integer.compare(b[0], a[0]));

        // Prepare results
        String[] result = new String[4];
        result[0] = String.valueOf(largeCount);
        result[1] = complexCount > 0 ? String.format("%.2f", complexAppendagesSum / complexCount) : "0.00";
        result[2] = Arrays.deepToString(specimens);
        result[3] = Arrays.toString(largeAndRareIndices.toArray());

        return result;
    }
}
