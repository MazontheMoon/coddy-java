/*
Create a function named findQuietestSpot that receives noiseLevel as its parameter.

Imagine you're enjoying a serene lunch break in a lush botanical garden. As you stroll through the garden, you notice that each spot has a different noise level. Your task is to find the quietest spot for your peaceful lunch.

The function should iterate through the array to find the spot with the minimum noise level. If there are multiple spots with the same minimum noise level, the function should return the index of the first occurrence.

Parameters:
- noiseLevel (int[]): An array of integers representing the noise levels at different spots in the garden. Each integer represents the noise level at that particular spot. The array will have a maximum length of 100, and all noise levels are non-negative integers.

The function returns an integer representing the index of the quietest spot (the spot with the lowest noise level).
*/

class FindQuietestSpot {
    public static int findQuietestSpot(int[] noiseLevel) {
        if (noiseLevel == null || noiseLevel.length == 0) {
            return -1; // Return -1 for invalid input
        }

        int quietestSpot = 0;
        int minNoise = noiseLevel[0];

        for (int i = 1; i < noiseLevel.length; i++) {
            if (noiseLevel[i] < minNoise) {
                minNoise = noiseLevel[i];
                quietestSpot = i;
            }
        }

        return quietestSpot;
    }
}