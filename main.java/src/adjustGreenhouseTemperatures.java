/*
Create a function named adjustGreenhouseTemperatures that receives temperatures and targetTemp as its parameters.

The function simulates a greenhouse temperature control system. Due to an unreliable enclosure, some sections of the greenhouse are not maintaining the desired temperature. Your task is to adjust the temperatures based on the target temperature.

Parameters:
- temperatures (int[]): An array representing the current temperatures in different sections of the greenhouse.
- targetTemp (int): The target temperature for all sections of the greenhouse.

The function should perform the following operations:
 - Iterate through the array of current temperatures.

For each section:
 - If the temperature is below the target, increase it by 2 degrees.
 - If the temperature is above the target, decrease it by 1 degree.
 - If the temperature is exactly at the target, leave it unchanged.
 - Return a new array with the adjusted temperatures.

The function returns an int[] representing the adjusted temperatures after the control system has made changes.
*/

import java.util.Arrays;

class AdjustGreenhouseTemperatures {
    public static int[] adjustGreenhouseTemperatures(int[] temperatures, int targetTemp) {
        int[] adjustedTemperatures = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            if (temperatures[i] < targetTemp) {
                adjustedTemperatures[i] = temperatures[i] + 2;
            } else if (temperatures[i] > targetTemp) {
                adjustedTemperatures[i] = temperatures[i] - 1;
            } else {
                adjustedTemperatures[i] = temperatures[i];
            }
        }

        return adjustedTemperatures;
    }
}