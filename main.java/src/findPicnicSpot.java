/*
Create a function named findPicnicSpot that receives parkMap and groupSize as its parameters.

You're planning a cookish gathering in a populously crowded park. Your task is to find a suitable picnic spot for your group. The park's layout is represented by a string where 'O' indicates an empty spot and 'X' represents an occupied spot. You need to find a consecutive series of empty spots that can accommodate your entire group.

Use basic substring and array slicing techniques to solve this challenge. Iterate through the parkMap string to find the first occurrence of consecutive empty spots that match your group size.

Parameters:
- parkMap (String): A string representing the park layout. 'O' represents an empty spot and 'X' represents an occupied spot.
- groupSize (int): An integer representing the number of consecutive spots needed for your group.

The function should return a substring of consecutive 'O's that can fit the group. If there isn't enough consecutive space for the group, return the string "No spot available".
*/

class FindPicnicSpot {
    public static String findPicnicSpot(String parkMap, int groupSize) {
        int consecutiveEmptySpots = 0;
        for (int i = 0; i < parkMap.length(); i++) {
            if (parkMap.charAt(i) == 'O') {
                consecutiveEmptySpots++;
                if (consecutiveEmptySpots == groupSize) {
                    return parkMap.substring(i - groupSize + 1, i + 1);
                }
            } else {
                consecutiveEmptySpots = 0;
            }
        }
        return "No spot available";
    }
}