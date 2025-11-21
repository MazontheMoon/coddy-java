/*
Create a function named mirrorNeurons that receives grid and actions as its parameters.

This function simulates the activity of mirror neurons, which fire both when we perform an action and when we observe someone else performing the same action.

The grid parameter is a 2D array of neurons, where each cell contains an integer representing the neuron’s activity level. The actions parameter is a list of strings, where each string represents a specific movement observed (e.g., "smile", "frown", "wave").

For each action in the actions list, the function should:
- Reverse the rows in the grid to simulate the mirroring effect of observing an action.
- Increase the activity level of all neurons in the grid by 1.

Parameters:
- grid (int[][]): A 2D integer array representing the initial activity levels of the neurons. Dimensions: 1x1 to 10x10. Each integer: 1 to 100.
- actions (String[]): An array of strings, where each string represents a specific movement observed. Each action is a non-empty string of lowercase letters.
The function should return a 2D integer array representing the final neuron activity levels after processing all the observed actions.
*/

class MirrorNeurons {
    public static int[][] mirrorNeurons(int[][] grid, String[] actions) {
        for (String action : actions) {
            // Mirror the activity by reversing the rows in the grid
            for (int i = 0; i < grid.length / 2; i++) {
                int[] temp = grid[i];
                grid[i] = grid[grid.length - 1 - i];
                grid[grid.length - 1 - i] = temp;
            }

            // Increase the activity level of all neurons by 1
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    grid[i][j]++;
                }
            }
        }

        return grid;
    }
}