/*
Create a function named countFlowersAndPainLevel that receives flowerCounts and painLevel as its parameters.

Imagine you're a gardener having a peaceful day in the garden, picking flowers each hour. Suddenly, you experience an unexpected stomach ache. This function should take an array of the number of flowers you picked each hour and the level of your stomach pain, then return a new array that includes all the flower counts followed by the pain level.

Parameters:
- flowerCounts (int[]): An array representing the number of flowers picked each hour.
- painLevel (int): An integer representing the level of stomach pain, from 1 to 10.

The function returns an int[] array, which is the concatenation of flowerCounts and painLevel.
*/

import java.util.Arrays;

class CountFlowersAndPainLevel {
    public static int[] countFlowersAndPainLevel(int[] flowerCounts, int painLevel) {
        int[] result = Arrays.copyOf(flowerCounts, flowerCounts.length + 1);
        result[result.length - 1] = painLevel;
        return result;
    }
}