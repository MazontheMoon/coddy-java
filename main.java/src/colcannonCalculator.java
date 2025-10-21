/*
Create a function named colcannonCalculator that receives servings as its parameter.

Imagine you're a signalman at a quaint railway station in Ireland, and you've decided to analyze your lunchtime feast of colcannon (a traditional Irish dish made with mashed potatoes and cabbage). Your task is to implement a function that performs various calculations on the servings of colcannon.

The function should do the following:
- Reverse the order of the servings array (representing eating from the last serving to the first).
- Calculate the total number of potatoes in all servings.
- Calculate the average number of potatoes per serving (rounded to two decimal places).
- Find the difference between the largest and smallest serving.

Parameters:
- servings (int[]): An array where each element represents the number of potatoes in a serving of colcannon. The array will contain between 1 and 100 elements, and each element will be a positive integer between 1 and 1000.

The function returns a String containing the following information, each on a new line:
- The reversed array (elements separated by spaces)
- The total number of potatoes
- The average number of potatoes per serving (rounded to two decimal places)
- The difference between the largest and smallest serving

Note: Use String.format("%.2f", value) to round the average to two decimal places.
 */

import java.util.Arrays;

class ColcannonCalculator {
    public static String colcannonCalculator(int[] servings) {
        // Reverse the array
        int[] reversed = new int[servings.length];
        for (int i = 0; i < servings.length; i++) {
            reversed[i] = servings[servings.length - 1 - i];
        }

        // Calculate total potatoes
        int total = Arrays.stream(servings).sum();

        // Calculate average
        double average = (double) total / servings.length;

        // Find difference between largest and smallest serving
        int max = Arrays.stream(servings).max().getAsInt();
        int min = Arrays.stream(servings).min().getAsInt();
        int difference = max - min;

        // Prepare the result string
        StringBuilder result = new StringBuilder();

        // 1. Reversed array
        for (int i = 0; i < reversed.length; i++) {
            result.append(reversed[i]);
            if (i < reversed.length - 1) {
                result.append(" ");
            }
        }
        result.append("\n");

        // 2. Total potatoes
        result.append(total).append("\n");

        // 3. Average potatoes per serving
        result.append(String.format("%.2f", average)).append("\n");

        // 4. Difference between largest and smallest serving
        result.append(difference);

        return result.toString();
    }
}