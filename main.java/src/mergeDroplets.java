/*
Create a function named mergeDroplets that receives int[] droplets as its parameter.

The function simulates the process of water droplets forming and merging on a window pane. It takes an array representing the initial sizes of water droplets and merges them based on a simple rule, mimicking the calm observation of condensation patterns.

The merging process follows this rule: If a droplet is smaller than or equal to its right neighbor, it merges with that neighbor, creating a new droplet with the combined size. This process is performed from left to right, updating the array as it goes. The merging continues until no more merges are possible (i.e., each droplet is larger than its right neighbor or it's the rightmost droplet).

Parameters:
- droplets (int[]): An array representing the initial sizes of water droplets.

The function returns an integer array representing the sizes of the droplets after all possible merges have occurred.

For example:
If the input is [2, 3, 1, 4, 2], the output should be [5, 1, 6].
Explanation: First, 2 merges with 3 to become 5. Then, 1 merges with 4 to become 5. Finally, 5 merges with 2 to become 7. The resulting array is [5, 1, 6].

Note: The function should modify the input array in-place and return the modified array. The length of the returned array may be smaller than the input array due to merges.
*/

import java.util.ArrayList;

class MergeDroplets {
    public static int[] mergeDroplets(int[] droplets) {
        if (droplets == null || droplets.length <= 1) {
            return droplets;
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < droplets.length; i++) {
            int current = droplets[i];
            while (i < droplets.length - 1 && current <= droplets[i + 1]) {
                current += droplets[i + 1];
                i++;
            }
            result.add(current);
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}