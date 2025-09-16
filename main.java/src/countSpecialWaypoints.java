/*
Create a function named countSpecialWaypoints that receives waypointNumbers as its parameter.

This function counts the number of 'special' waypoint numbers in the given array. A waypoint number is 'special' if it is even and divisible by 3.

To solve this, iterate through each element in the waypointNumbers array. For each element, check if it:
- Is even (divisible by 2).
- Is divisible by 3.
- If both conditions are met, increment a counter. Return the final counter value.

Parameters:
- waypointNumbers (int[]): An array of positive integers (1 to 100 elements).

The function returns an integer representing the count of 'special' waypoint numbers in the array.
*/

class CountSpecialWaypoints {
    public static int countSpecialWaypoints(int[] waypointNumbers) {
        int count = 0;
        for (int num : waypointNumbers) {
            if (num % 2 == 0 && num % 3 == 0) {
                count++;
            }
        }
        return count;
    }
}