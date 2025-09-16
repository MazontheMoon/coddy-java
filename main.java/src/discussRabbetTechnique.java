/*
Create a function named discussRabbetTechnique that receives groupA and groupB as its parameters.

The function simulates a lively discussion among woodworkers about the proper technique for cutting rabbets. Each group of woodworkers has their opinions on the ideal depth for rabbets, measured in millimeters.

Your task is to combine the opinions of both groups and adjust them based on a simple rule to reach a consensus:
- If a suggested depth is less than 5mm, increase it by 1mm (cut slightly deeper).
- If a suggested depth is more than 15mm, decrease it by 1mm (cut slightly shallower).
- Leave depths between 5mm and 15mm (inclusive) unchanged.

Parameters:
- groupA (int[]): An array of integers representing the first group's opinions on rabbet depths in millimeters.
- groupB (int[]): An array of integers representing the second group's opinions on rabbet depths in millimeters.

The function returns an integer array representing the final adjusted and combined opinions on rabbet depths.

To solve this challenge, you should:
- Concatenate the two input arrays to combine all opinions.
- Iterate through the combined array, adjusting depths as per the given rule.
- Use basic increment (++) and decrement (--) operators for adjusting the depths.
*/

import java.util.Arrays;

class DiscussRabbetTechnique {
    public static int[] discussRabbetTechnique(int[] groupA, int[] groupB) {
        int[] combined = new int[groupA.length + groupB.length];
        System.arraycopy(groupA, 0, combined, 0, groupA.length);
        System.arraycopy(groupB, 0, combined, groupA.length, groupB.length);

        for (int i = 0; i < combined.length; i++) {
            if (combined[i] < 5) {
                combined[i]++;
            } else if (combined[i] > 15) {
                combined[i]--;
            }
        }

        return combined;
    }
}