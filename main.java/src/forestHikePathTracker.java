/*
Create a function named forestHikePathTracker that receives elevations as its parameter.

This function aims to simulate tracking the path of a hiker through a dawn forest. The elevations array represents the elevation at various segments of the forest trail.

Your task is to modify the elevations array and return it such that each element is increased by 1 if it is considered a 'low elevation' segment (i.e., the elevation value is less than 5). Elements with a value of 5 or greater should remain unchanged.

Parameters:
- elevations (int[]): An array of integers representing the elevations of the trail segments. You can assume that all values in the array are non-negative.

The function should return the modified elevations array where each 'low elevation' segment (value less than 5) is increased by 1.
*/

class ForestHikePathTracker {
    public static int[] forestHikePathTracker(int[] elevations) {
        for (int i = 0; i < elevations.length; i++) {
            if (elevations[i] < 5) {
                elevations[i]++;
            }
        }
        return elevations;
    }
}