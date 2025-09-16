/*
Create a function named mountainTrailAscent that receives trail as its parameter.

The function simulates a group of friends ascending a mountain trail. The trail is represented by a 2D array where each row represents a segment of the trail, and each integer in the row represents the elevation at that point.

Your task is to calculate the total elevation gain for the entire journey. To do this, follow these steps:
- Reverse the order of elements in each row of the 2D array to simulate the group ascending the trail.
- Calculate the elevation gain for each row by summing up the positive differences between consecutive elements.
- Sum up the elevation gains from all rows to get the total elevation gain for the entire journey.

Parameters:
- trail (int[][]): A 2D array representing the elevation of the trail at different points. Each row represents a segment of the trail, and each integer represents the elevation at that point.

The function returns an integer representing the total elevation gain for the entire journey.

Constraints:
- The trail will be a 2D array with dimensions n x m, where 1 ≤ n, m ≤ 100.
- Each element in the trail will be a non-negative integer representing the elevation at that point (0 ≤ elevation ≤ 10000).

Note: The friends always start from the first element (left) and move towards the last element (right) in each row of the reversed array.
*/

import java.util.Arrays;

class MountainTrailAscent {
    public static int mountainTrailAscent(int[][] trail) {
        int totalElevationGain = 0;

        for (int[] segment : trail) {
            // Reverse the segment
            for (int i = 0; i < segment.length / 2; i++) {
                int temp = segment[i];
                segment[i] = segment[segment.length - 1 - i];
                segment[segment.length - 1 - i] = temp;
            }

            // Calculate elevation gain for this segment
            for (int i = 1; i < segment.length; i++) {
                int elevationDifference = segment[i] - segment[i - 1];
                if (elevationDifference > 0) {
                    totalElevationGain += elevationDifference;
                }
            }
        }

        return totalElevationGain;
    }
}