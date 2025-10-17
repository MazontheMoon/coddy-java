/*
Create a function named protectSandcastles that receives sandcastles and waveHeight as its parameters.

This function simulates protecting sandcastles from waves by modifying their heights.

Given an array of sandcastle heights, the function takes two inputs: an integer array sandcastles and an integer waveHeight. For each sandcastle, if its height is less than or equal to waveHeight, it is set to 0; otherwise, it decreases by waveHeight.

Parameters:

sandcastles (int[]): An array of integers representing the heights of the sandcastles.
waveHeight (int): An integer representing the height of the incoming wave.
The function returns the modified sandcastles array after the wave has passed.
 */

class ProtectSandcastles {
    public static int[] protectSandcastles(int[] sandcastles, int waveHeight) {
        for (int i = 0; i < sandcastles.length; i++) {
            if (sandcastles[i] <= waveHeight) {
                sandcastles[i] = 0;
            } else {
                sandcastles[i] -= waveHeight;
            }
        }
        return sandcastles;
    }
}

