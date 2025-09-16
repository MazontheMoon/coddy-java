/*
Create a function named adjustMultivibratorFrequency that receives initialFrequencies and adjustments as its parameters.

In a dimly lit laboratory, a curious scientist is experimenting with a multivibrator circuit and wants to increase its frequency. Your task is to help the scientist by implementing a function that adjusts the frequency settings of the multivibrator.

The function should perform the following steps:
- Find the maximum value in the initialFrequencies array.
- Create a new array that concatenates the maximum value (repeated based on the length of the adjustments array) with the adjustments array.
- Return the new array representing the updated frequencies.

Parameters:
- initialFrequencies (int[]): An array of integers representing the initial frequency settings of the multivibrator.
- adjustments (int[]): An array of integers representing the adjustment values to be applied to the frequency.

The function returns an integer array (int[]) representing the updated frequencies after adjustment.

Constraints:
- The length of initialFrequencies will be between 1 and 100, inclusive.
- The length of adjustments will be between 1 and 100, inclusive.
- All values in both arrays will be non-negative integers less than or equal to 1000.
*/

import java.util.Arrays;

class AdjustMultivibratorFrequency {
    public static int[] adjustMultivibratorFrequency(int[] initialFrequencies, int[] adjustments) {
        int maxFrequency = Arrays.stream(initialFrequencies).max().getAsInt();
        int[] result = new int[adjustments.length + adjustments.length];

        Arrays.fill(result, 0, adjustments.length, maxFrequency);
        System.arraycopy(adjustments, 0, result, adjustments.length, adjustments.length);

        return result;
    }
}