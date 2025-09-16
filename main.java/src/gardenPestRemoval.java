/*
Create a function named gardenPestRemoval that receives garden and threshold as its parameters.

This function aims to simulate the removal of pests from a garden represented as a 2D array of integers. Each cell value in the garden array represents the number of pests in that section of the garden.

To determine the total pest count, follow these steps:
- Iterate through each cell in the garden array.
- For each cell, check if the sum of the pest counts in the surrounding cells (up, down, left, right) is less than or equal to the given threshold.
- If the condition is met, add the pest count of the current cell to the total pest count.
- After calculating the total pest count, reverse the digits of the count to obtain the final output.

Parameters:
- garden (int[][]): A 2D array representing different sections of a garden. Each cell contains a non-negative integer indicating the number of pests in that section. The maximum size of the garden array is 10x10.
- threshold (int): A non-negative integer representing the maximum allowed sum of pest counts in the surrounding cells for a cell to be included in the total pest count.

The function returns an integer which is the reversed digits of the total pest count calculated based on the provided rules.
*/

class GardenPestRemoval {
    public static int gardenPestRemoval(int[][] garden, int threshold) {
        int rows = garden.length;
        int cols = garden[0].length;
        int totalPestCount = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int surroundingPestCount = 0;

                // Check the surrounding cells
                if (i > 0) {
                    surroundingPestCount += garden[i - 1][j]; // Up
                }
                if (i < rows - 1) {
                    surroundingPestCount += garden[i + 1][j]; // Down
                }
                if (j > 0) {
                    surroundingPestCount += garden[i][j - 1]; // Left
                }
                if (j < cols - 1) {
                    surroundingPestCount += garden[i][j + 1]; // Right
                }

                // Check if the surrounding pest count is less than or equal to the threshold
                if (surroundingPestCount <= threshold) {
                    totalPestCount += garden[i][j];
                }
            }
        }

        // Reverse the digits of the total pest count
        int reversedCount = 0;
        while (totalPestCount > 0) {
            reversedCount = reversedCount * 10 + totalPestCount % 10;
            totalPestCount /= 10;
        }

        return reversedCount;
    }
}

