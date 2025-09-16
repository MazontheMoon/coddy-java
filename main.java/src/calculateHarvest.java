/*
Create a function named calculateHarvest that receives rows, columns, and yieldPerPlant as parameters.

This function calculates the estimated total harvest yield for a farmer's field based on the number of rows, columns, and the average yield per plant.

To calculate the total yield, multiply the number of rows by the number of columns to determine the total number of plants. Then, multiply the total number of plants by the yieldPerPlant to obtain the estimated total harvest yield.

Parameters:
- rows (int): The number of rows in the field. Positive integer.
- columns (int): The number of columns in the field. Positive integer.
- yieldPerPlant (float): The average yield per plant. Positive float.

Returns a float value representing the estimated total harvest yield.
*/

class CalculateHarvest {
    public static float calculateHarvest(int rows, int columns, float yieldPerPlant) {
        int totalPlants = rows * columns;
        float totalYield = totalPlants * yieldPerPlant;
        return totalYield;
    }
}