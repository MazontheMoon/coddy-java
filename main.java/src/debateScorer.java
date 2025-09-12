/*
Create a function named debateScorer that receives scores as its parameter.

In a lively university collegium debate, arguments are presented and scored. Your task is to analyze these scores using basic arithmetic operations and array manipulation.

The function should perform the following operations:
- Calculate the average score of all arguments (rounded down to the nearest integer).
- Find the highest and lowest scores.
- Calculate the sum of all scores that are above the average.
- Reverse the order of scores to represent a counterargument phase.

Parameters:
- scores (int[]): An array of integers representing the scores of different arguments presented in the debate. The array will contain at least one integer.

The function returns an integer array containing four elements in the following order:
- The average score (rounded down to the nearest integer)
- The highest score
- The lowest score
- The sum of scores above the average
Note: The reversal of the array should be done within the function to simulate a counterargument phase, but it shouldn't be part of the return value.

Constraints:
The input array will contain at least one integer.
The scores can be both positive and negative integers.
*/

import java.util.Arrays;

public class debateScorer {
    public static int[] debateScorer(int[] scores) {
        // Calculate average score
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        int average = sum / scores.length;

        // Find highest and lowest scores
        int highest = scores[0];
        int lowest = scores[0];
        for (int score : scores) {
            if (score > highest) highest = score;
            if (score < lowest) lowest = score;
        }

        // Calculate sum of scores above average
        int sumAboveAverage = 0;
        for (int score : scores) {
            if (score > average) sumAboveAverage += score;
        }

        // Reverse the array (for counterargument phase)
        for (int i = 0; i < scores.length / 2; i++) {
            int temp = scores[i];
            scores[i] = scores[scores.length - 1 - i];
            scores[scores.length - 1 - i] = temp;
        }

        // Return the required values
        return new int[]{average, highest, lowest, sumAboveAverage};
    }
}
