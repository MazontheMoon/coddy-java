/*
Create a function named ancientGatewayCode that receives int[] input as its parameter.

You are standing before a traditional Chinese gateway that emanates an aura of ancient wisdom. Inscribed on the gateway is a puzzle encoded in an array of integers. To unlock the secrets of this wisdom, you need to reverse the array and apply a special transformation.

The function should perform the following steps:
- Reverse the entire input array.
- After reversing, apply the following transformation to each element:
- Increment even-indexed elements by 1
- Decrement odd-indexed elements by 1

Parameters:
- input (int[]): An array of integers. The length of the array will be between 1 and 100, inclusive.
The function returns an int[] representing the transformed array after applying the reversal and the special increment/decrement pattern.
 */

import java.util.Arrays;

class AncientGatewayCode {
    public static int[] ancientGatewayCode(int[] input) {
        // Step 1: Reverse the entire input array
        for (int i = 0; i < input.length / 2; i++) {
            int temp = input[i];
            input[i] = input[input.length - 1 - i];
            input[input.length - 1 - i] = temp;
        }

        // Step 2: Apply the transformation
        for (int i = 0; i < input.length; i++) {
            if (i % 2 == 0) {
                // Increment even-indexed elements
                input[i]++;
            } else {
                // Decrement odd-indexed elements
                input[i]--;
            }
        }

        return input;
    }
}