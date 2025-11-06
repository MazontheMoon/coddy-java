/*
Create a function named analyzePlantSpecimens that receives specimens and threshold as its parameters.

You are a scientist in a well-lit laboratory, examining various plant specimens under a microscope. Your task is to analyze the characteristics of these specimens and determine which ones have significant features.

The function should process the given specimens and return a summary of the analysis.

Parameters:
- specimens (int[][]): A 2D array where each row represents a plant specimen and each column represents a characteristic (e.g., petal count, leaf size, stem length). Each value is an integer between 0 and 1000.
- threshold (int): An integer representing the minimum value for a characteristic to be considered significant. This value is between 0 and 1000.

The function should perform the following steps:
- Iterate through each specimen (row) in the 2D array.
- For each specimen, count how many characteristics (columns) are above or equal to the given threshold.
- Keep track of the total number of specimens and how many have at least one significant characteristic.
- Calculate the percentage of specimens with significant characteristics.
- Return a formatted string with the analysis results.

The function returns a string summarizing the analysis in the following format:

"Total specimens: X, Specimens with significant characteristics: Y, Percentage: Z%"
Where X, Y, and Z are replaced with the appropriate calculated values. Z should be rounded to one decimal place.
 */

import java.util.Arrays;

class AnalyzePlantSpecimens {
    public static String analyzePlantSpecimens(int[][] specimens, int threshold) {
        int totalSpecimens = specimens.length;
        int specimensWithSignificantCharacteristics = 0;

        for (int[] specimen : specimens) {
            boolean hasSignificantCharacteristic = Arrays.stream(specimen)
                    .anyMatch(characteristic -> characteristic >= threshold);
            if (hasSignificantCharacteristic) {
                specimensWithSignificantCharacteristics++;
            }
        }

        double percentage = (double) specimensWithSignificantCharacteristics / totalSpecimens * 100;
        String formattedPercentage = String.format("%.1f", percentage);

        return String.format("Total specimens: %d, Specimens with significant characteristics: %d, Percentage: %s%%",
                totalSpecimens, specimensWithSignificantCharacteristics, formattedPercentage);
    }
}