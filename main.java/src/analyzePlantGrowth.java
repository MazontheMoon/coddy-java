/*
Create a function named analyzePlantGrowth that receives int[] growthMeasurements and int threshold as its parameters.

You are a scientist in a laboratory studying plant growth using a volumeter. Your task is to analyze the daily growth measurements of a plant sample and determine its growth pattern.

Analyze the growth measurements based on the following criteria:
- If the plant's growth exceeds the threshold on all days, return "Consistent growth".
- If the plant's growth is below the threshold on all days, return "Stunted growth".
- If the plant's growth alternates between above and below the threshold (regardless of the order), return "Alternating growth".
- For any other growth pattern, return "Irregular growth".

Parameters:
- growthMeasurements (int[]): An array representing daily growth measurements (in millimeters) of a plant over a week.
- threshold (int): The minimum growth threshold (in millimeters) for considering a day's growth as significant.

The function returns a string describing the plant's growth pattern.
*/

import java.util.Arrays;

class AnalyzePlantGrowth {
    public static String analyzePlantGrowth(int[] growthMeasurements, int threshold) {
        boolean allAbove = true;
        boolean allBelow = true;
        boolean alternating = true;
        boolean prevAbove = growthMeasurements[0] >= threshold;

        for (int i = 0; i < growthMeasurements.length; i++) {
            boolean currentAbove = growthMeasurements[i] >= threshold;

            if (currentAbove) {
                allBelow = false;
            } else {
                allAbove = false;
            }

            if (i > 0 && currentAbove == prevAbove) {
                alternating = false;
            }

            prevAbove = currentAbove;
        }

        if (allAbove) {
            return "Consistent growth";
        } else if (allBelow) {
            return "Stunted growth";
        } else if (alternating) {
            return "Alternating growth";
        } else {
            return "Irregular growth";
        }
    }
}