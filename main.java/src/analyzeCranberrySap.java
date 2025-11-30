/*
Create a function named analyzeCranberrySap that receives sapReadings and targetFrothLevel as its parameters.

Your task is to analyze and process cranberry sap samples in a botanical laboratory, focusing on the frothing characteristics of an Oxycoccus (cranberry) species.

Follow these steps to analyze the sap:

Adjust the sap readings using increment and decrement operators:
- For even readings, use the pre-increment operator (++x).
- For odd readings, use the post-decrement operator (x--).
- Sort the adjusted readings in descending order using any efficient sorting algorithm.
- Process the sorted array using a loop with break and continue statements:
	- If a reading is greater than twice the targetFrothLevel, break the loop.
	- If a reading is less than half the targetFrothLevel, continue to the next iteration.
	- Otherwise, adjust the reading by adding the targetFrothLevel to it.

Parameters:
- sapReadings (int[]): An array of integers representing the initial sap readings from various samples.
- targetFrothLevel (int): An integer representing the target frothing level for the sap.

The function returns an int[] containing the processed sap readings after analysis.
*/

import java.util.Arrays;

class AnalyzeCranberrySap {
    public static int[] analyzeCranberrySap(int[] sapReadings, int targetFrothLevel) {
        // Step 1: Adjust sap readings
        for (int i = 0; i < sapReadings.length; i++) {
            if (sapReadings[i] % 2 == 0) {
                sapReadings[i] = ++sapReadings[i];
            } else {
                sapReadings[i] = sapReadings[i]--;
            }
        }

        // Step 2: Sort in descending order
        Arrays.sort(sapReadings);
        for (int i = 0; i < sapReadings.length / 2; i++) {
            int temp = sapReadings[i];
            sapReadings[i] = sapReadings[sapReadings.length - 1 - i];
            sapReadings[sapReadings.length - 1 - i] = temp;
        }

        // Step 3: Process the sorted array
        for (int i = 0; i < sapReadings.length; i++) {
            if (sapReadings[i] > 2 * targetFrothLevel) {
                break;
            }
            if (sapReadings[i] < targetFrothLevel / 2) {
                continue;
            }
            sapReadings[i] += targetFrothLevel;
        }

        return sapReadings;
    }
}