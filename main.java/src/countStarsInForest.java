/*
Create a function named countStarsInForest that receives sky and maxCount as its parameters.

The function simulates counting stars in a night sky over a peaceful forest glade. It should count the stars until either the end of the sky is reached or the maximum count is achieved.

Loop through the array, counting the stars (represented by 1s) until either the end of the array is reached or the maximum count is achieved. If the maximum count is reached before the end of the array, replace all remaining elements with 0s, simulating falling asleep and no longer seeing stars.

Parameters:

sky (int[]): An array representing the night sky, where each element is either 0 (no star) or 1 (star).
maxCount (int): The maximum number of stars to count before falling asleep.
The function returns the modified int[] representing the night sky after the counting session.
*/

import java.util.Arrays;

class CountStarsInForest {
    public static int[] countStarsInForest(int[] sky, int maxCount) {
        int count = 0;
        int i = 0;

        while (i < sky.length && count < maxCount) {
            if (sky[i] == 1) {
                count++;
            }
            i++;
        }

        if (count == maxCount && i < sky.length) {
            Arrays.fill(sky, i, sky.length, 0);
        }

        return sky;
    }
}
