/*
Create a function named realignEquipment that receives equipment and increment as its parameters.

As a deep-sea explorer, you need to realign your equipment before an unbooked dive into the bathypelagic zone. This function will help you adjust the settings of your equipment.

The function should perform the following operations:
- Increment each element in the equipment array by the value of increment.
- Reverse the order of the rows in the equipment array.

Parameters:
- equipment (int[][]): A 2D array of integers representing the current settings of your deep-sea explorer equipment. Each row represents a different piece of equipment, and each column represents a specific setting.
- increment (int): An integer value by which each setting should be increased. This value can be positive or negative.

The function returns a 2D integer array representing the realigned equipment settings after performing the required operations.

Constraints:
- The number of rows in the equipment array will be between 1 and 100.
- The number of columns in the equipment array will be between 1 and 100.
- The increment value will be between -100 and 100.

Remember, precise calibration is crucial for a successful dive into the depths of the ocean. Good luck, explorer!
*/

import java.util.Arrays;

class RealignEquipment {
    public static int[][] realignEquipment(int[][] equipment, int increment) {
        int rows = equipment.length;
        int cols = equipment[0].length;

        // Create a new array to store the result
        int[][] result = new int[rows][cols];

        // Increment each element and reverse the order of rows
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[rows - 1 - i][j] = equipment[i][j] + increment;
            }
        }

        return result;
    }
}