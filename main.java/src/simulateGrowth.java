/*
Create a function named simulateGrowth that receives initialHeights, transpirationRates, soilConductivity, and cycles as its parameters.

The function simulates plant growth in an experimental greenhouse, considering transpiration rates and soil electrical conductivity. It uses game theory to model competition between plants for resources.

Implement the following steps:

Convert binary-encoded transpiration rates to decimal.
Convert hexadecimal soil conductivity values to decimal.
Apply a game theory algorithm to determine resource allocation based on transpiration rates and soil conductivity.
Use array slicing to update plant heights efficiently during each growth cycle.
Calculate growth for the specified number of cycles.
Parameters:

initialHeights (int[]): Initial heights of plants in centimeters.
transpirationRates (String[]): Binary-encoded transpiration rates of plants.
soilConductivity (String[]): Hexadecimal-encoded electrical conductivity of soil for each plant.
cycles (int): Number of growth cycles to simulate.
The function returns a 2D integer array where each sub-array represents the height progression of a single plant over time.
*/

import java.util.Arrays;

class SimulateGrowth {
    public static int[][] simulateGrowth(int[] initialHeights, String[] transpirationRates, String[] soilConductivity, int cycles) {
        int n = initialHeights.length;
        int[][] growthProgression = new int[n][cycles + 1];

        // Convert binary transpiration rates to decimal
        int[] transpirationDecimal = new int[n];
        for (int i = 0; i < n; i++) {
            transpirationDecimal[i] = Integer.parseInt(transpirationRates[i], 2);
        }

        // Convert hexadecimal soil conductivity to decimal
        int[] conductivityDecimal = new int[n];
        for (int i = 0; i < n; i++) {
            conductivityDecimal[i] = Integer.parseInt(soilConductivity[i], 16);
        }

        // Initialize growth progression with initial heights
        for (int i = 0; i < n; i++) {
            growthProgression[i][0] = initialHeights[i];
        }

        // Simulate growth for each cycle
        for (int cycle = 1; cycle <= cycles; cycle++) {
            int[] resourceAllocation = allocateResources(transpirationDecimal, conductivityDecimal);

            for (int i = 0; i < n; i++) {
                int growth = calculateGrowth(resourceAllocation[i], transpirationDecimal[i], conductivityDecimal[i]);
                growthProgression[i][cycle] = growthProgression[i][cycle - 1] + growth;
            }
        }

        return growthProgression;
    }

    private static int[] allocateResources(int[] transpirationRates, int[] soilConductivity) {
        int n = transpirationRates.length;
        int[] allocation = new int[n];
        int totalResources = Arrays.stream(transpirationRates).sum() + Arrays.stream(soilConductivity).sum();

        for (int i = 0; i < n; i++) {
            allocation[i] = (transpirationRates[i] + soilConductivity[i]) * 100 / totalResources;
        }

        return allocation;
    }

    private static int calculateGrowth(int resourceAllocation, int transpirationRate, int soilConductivity) {
        return (resourceAllocation * transpirationRate * soilConductivity) / 1000;
    }
}