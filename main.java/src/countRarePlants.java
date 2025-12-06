/*
Create a function named countRarePlants that receives islandAreas and rarePlant as its parameters.

As a curious explorer documenting rare plants on a remote island, you need to count the occurrences of a specific rare plant in different areas of the island.

Your task is to implement the function that takes a 2D array representing different areas of the island and the name of a rare plant. The function should return an array containing the count of the rare plant in each area of the island.

Parameters:
- islandAreas (String[][]): A 2D array representing different areas of the island, where each element is a plant species name.
- rarePlant (String): The name of the rare plant species to search for.

The function returns an integer array where each element represents the count of the rare plant in the corresponding area (row) of the island.
*/

import java.util.Arrays;

class CountRarePlants {
    public static int[] countRarePlants(String[][] islandAreas, String rarePlant) {
        int[] result = new int[islandAreas.length];
        
        for (int i = 0; i < islandAreas.length; i++) {
            int count = 0;
            for (String plant : islandAreas[i]) {
                if (plant.equals(rarePlant)) {
                    count++;
                }
            }
            result[i] = count;
        }
        
        return result;
    }
}