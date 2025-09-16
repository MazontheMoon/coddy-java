/*
Create a function named countBirdTypes that receives int[] birdSightings and boolean isRaining as its parameters.

You are an enthusiastic bird watcher braving the elements to observe bird populations. Your task is to count different types of birds and adjust your count based on the weather conditions.

The function should process the bird sightings and adjust the counts based on whether it's raining or not. If it's raining, reduce the count of each bird type by 1 (but not below 0). If it's not raining, increase the count of each bird type by 1.

Parameters:
- birdSightings (int[]): An array representing the number of birds seen for each type. For example, [2, 5, 0, 7, 3] means 2 of type 1, 5 of type 2, and so on.
- isRaining (boolean): A boolean indicating whether it's raining (true) or not (false).

The function returns an integer array representing the adjusted count of birds for each type.
*/
import java.util.Arrays;

class CountBirdTypes {
    public static int[] countBirdTypes(int[] birdSightings, boolean isRaining) {
        int[] adjustedCounts = Arrays.copyOf(birdSightings, birdSightings.length);

        for (int i = 0; i < adjustedCounts.length; i++) {
            if (isRaining) {
                adjustedCounts[i] = Math.max(0, adjustedCounts[i] - 1);
            } else {
                adjustedCounts[i]++;
            }
        }

        return adjustedCounts;
    }
}