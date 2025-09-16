/*
Create a function named waterRarePlants that receives plantHeights and targetHeight as its parameters.

You are a resilient gardener tending to unusual plants in your backyard. Your goal is to determine how many days it will take for all your rare plants to reach or exceed a target height.

Each day, you water all the plants. When watered, each plant grows by a number of units equal to its current height modulo 3 plus 1. This means:
- If a plant's height modulo 3 is 0, it grows by 1 unit
- If a plant's height modulo 3 is 1, it grows by 2 units
- If a plant's height modulo 3 is 2, it grows by 3 units
- Continue this process daily until all plants reach or exceed the target height.

Parameters:
- plantHeights (int[]): An array representing the current heights of the plants. Each element is a positive integer.
- targetHeight (int): A positive integer representing the desired height for all plants.

The function returns an integer representing the number of days it takes for all plants to reach or exceed the target height.
*/

import java.util.Arrays;

class WaterRarePlants {
    public static int waterRarePlants(int[] plantHeights, int targetHeight) {
        int days = 0;
        while (!allPlantsReachedTarget(plantHeights, targetHeight)) {
            for (int i = 0; i < plantHeights.length; i++) {
                plantHeights[i] += (plantHeights[i] % 3) + 1;
            }
            days++;
        }
        return days;
    }

    private static boolean allPlantsReachedTarget(int[] plantHeights, int targetHeight) {
        for (int height : plantHeights) {
            if (height < targetHeight) {
                return false;
            }
        }
        return true;
    }
}