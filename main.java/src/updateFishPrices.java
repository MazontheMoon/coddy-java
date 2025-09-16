/*
Create a function named updateFishPrices that receives fishWeights and basePricePerKg as its parameters.

You are a fisherman at a coastal market, and you need to update the price tags on freshly caught coalfish. Your task is to create a function that calculates the new prices based on the weight of each fish and a base price per kilogram.

Use nested loops to process the 2D array of fish weights and calculate their new prices according to the following rules:
- For fish weighing less than 500 grams: base price per kg
- For fish weighing 500 grams or more but less than 1000 grams: base price per kg + 10% premium
- For fish weighing 1000 grams or more: base price per kg + 20% premium

Parameters:
- fishWeights (int[][]): A 2D array where each element represents the weight of a fish in grams.
- basePricePerKg (int): The base price per kilogram of coalfish in cents.

The function returns a 2D integer array with the same dimensions as the input, where each element represents the updated price of the corresponding fish in cents.

Note: Round down any fractional cents to the nearest integer.
*/

import java.util.Arrays;

class UpdateFishPrices {
    public static int[][] updateFishPrices(int[][] fishWeights, int basePricePerKg) {
        int rows = fishWeights.length;
        int cols = fishWeights[0].length;
        int[][] updatedPrices = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int weight = fishWeights[i][j];
                double pricePerGram = basePricePerKg / 1000.0;
                double price;

                if (weight < 500) {
                    price = weight * pricePerGram;
                } else if (weight < 1000) {
                    price = weight * pricePerGram * 1.1;
                } else {
                    price = weight * pricePerGram * 1.2;
                }

                updatedPrices[i][j] = (int) price;
            }
        }

        return updatedPrices;
    }
}