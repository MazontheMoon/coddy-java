/*
Create a function named dreamFestivalSorter that receives boothLoudness as its parameter.

You are attending a noisy festival celebrating ancient dream interpretation techniques. Various booths are set up, each with a different loudness level. Your task is to process this information to gain insights about the festival layout.

The function should perform two operations on the input array:
- Reverse the order of the array elements. This simulates walking through the festival from the opposite direction.
- Sort the reversed array in ascending order (from quietest to loudest).

These operations will help organize the festival data for better dream interpretation analysis.

Parameters:
- boothLoudness (int[]): An array of integers representing the loudness levels of different dream interpretation booths. Each integer in the array corresponds to the loudness of a booth.

The function returns an int[] array containing the booth loudness levels reversed and then sorted in ascending order.

Note: You may use built-in Java methods for array manipulation and sorting.
*/

import java.util.Arrays;

class DreamFestivalSorter {
    public static int[] dreamFestivalSorter(int[] boothLoudness) {
        // Step 1: Reverse the order of the array elements
        for (int i = 0; i < boothLoudness.length / 2; i++) {
            int temp = boothLoudness[i];
            boothLoudness[i] = boothLoudness[boothLoudness.length - 1 - i];
            boothLoudness[boothLoudness.length - 1 - i] = temp;
        }

        // Step 2: Sort the reversed array in ascending order
        Arrays.sort(boothLoudness);

        return boothLoudness;
    }
}