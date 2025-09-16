/*
Create a function named analyzeCrystals that receives int[] crystalPurity and int threshold as its parameters.

The function simulates a scientist examining an array of crystal samples under a microscope. Each element in the crystalPurity array represents the purity level of a crystal sample. The scientist wants to find the first crystal sample that meets or exceeds the purity threshold, while skipping any contaminated samples.

Your task is to implement the following logic:
- Iterate through the crystalPurity array.
- Skip any negative values (they represent contaminated samples) using the continue statement.
- If a sample meets or exceeds the threshold, stop the search using the break statement.
- Return the index of the first crystal that meets or exceeds the threshold.
- If no suitable crystal is found, return -1.

Parameters:
- crystalPurity (int[]): An array of integers representing the purity levels of crystal samples.
- threshold (int): The minimum purity level required for a crystal to be considered suitable.

The function returns an integer representing the index of the first suitable crystal or -1 if no suitable crystal is found.
*/

class AnalyzeCrystals {
    public static int analyzeCrystals(int[] crystalPurity, int threshold) {
        for (int i = 0; i < crystalPurity.length; i++) {
            if (crystalPurity[i] < 0) {
                continue;
            }
            if (crystalPurity[i] >= threshold) {
                return i;
            }
        }
        return -1;
    }
}