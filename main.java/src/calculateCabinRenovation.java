/*
Create a function named calculateCabinRenovation that receives floorSections, subfloorThickness, and subfloorLayers as its parameters.

The bosun of an old sailing ship is planning to renovate the cabin's subfloor. Your task is to help calculate the materials needed and determine if the renovation is feasible.

The function should perform the following operations:
- Calculate the total area of the cabin floor by summing up the areas of all rectangular sections.
- Determine the volume of subfloor material needed based on the total area, thickness, and number of layers.
- Calculate the number of standard subfloor panels needed, assuming each panel is 244 cm x 122 cm.
- Determine if there's enough headroom in the cabin after adding the new subfloor layers. The original cabin height is 220 cm, and the minimum acceptable height is 200 cm.

Parameters:
- floorSections (int[][]): A 2D integer array where each inner array represents the dimensions (length and width in centimeters) of a rectangular section of the cabin floor.
- subfloorThickness (float): The thickness of the new subfloor material in centimeters.
- subfloorLayers (int): The number of layers of subfloor to be installed.

The function returns a String in the following format: "totalArea,materialVolume,panelsNeeded,enoughHeadroom" where:
- totalArea is the total floor area in square meters (rounded to 2 decimal places)
- materialVolume is the volume of subfloor material needed in cubic meters (rounded to 2 decimal places)
- panelsNeeded is the number of standard subfloor panels required (rounded up to the nearest whole number)
- enoughHeadroom is a boolean indicating if there's enough headroom after renovation (true if acceptable, false if not)

Use advanced arithmetic operations for precise calculations and rounding.
Implement advanced array slicing to process the input array of dimensions efficiently.
Apply advanced logical operators to determine if there's enough headroom after the renovation.
*/

import java.util.Arrays;

class CalculateCabinRenovation {
    public static String calculateCabinRenovation(int[][] floorSections, float subfloorThickness, int subfloorLayers) {
        // Calculate total area
        double totalArea = Arrays.stream(floorSections)
                .mapToDouble(section -> (section[0] * section[1]) / 10000.0)
                .sum();

        // Calculate material volume
        double materialVolume = totalArea * (subfloorThickness / 100) * subfloorLayers;

        // Calculate panels needed
        double standardPanelArea = 2.44 * 1.22;
        int panelsNeeded = (int) Math.ceil(totalArea / standardPanelArea);

        // Check if there's enough headroom
        boolean enoughHeadroom = (220 - (subfloorThickness * subfloorLayers)) >= 200;

        // Format the result
        return String.format("%.2f,%.2f,%d,%b", totalArea, materialVolume, panelsNeeded, enoughHeadroom);
    }
}