/*
Create a function named harvestCotton that receives plotSize and plotState as its parameters.

As a business consultant preparing for an important meeting at a cotton farm, you've been asked to create a simulation of the cotton harvesting process. Your task is to implement a function that calculates the total amount of cotton that can be harvested from a square plot of land.

The function should follow these harvesting rules:
- Only "ripe" plants can be harvested.
- A plant can only be harvested if it has at least one adjacent "ripe" neighbor (horizontally or vertically, not diagonally).
- After harvesting a plant, its state changes to "empty".
- Each harvested plant yields 1 unit of cotton.
- The harvesting process should continue until no more plants can be harvested according to these rules.

Parameters:
- plotSize (int): An integer representing the size of the square plot (N x N). The plot size can range from 1 to 10.
- plotState (String[]): A string array representing the initial state of each plant in the plot. The size of this array should be plotSize * plotSize. Each element in the array can be "ripe", "unripe", or "empty".

The function returns an integer representing the total amount of cotton harvested.

To solve this challenge, you'll need to use nested loops to iterate through the plot and conditional statements to check the harvesting conditions.
Remember to update the plot state as you harvest and keep track of the total cotton harvested.
 */
import java.util.Arrays;

class HarvestCotton {
    public static int harvestCotton(int plotSize, String[] plotState) {
        String[][] plot = new String[plotSize][plotSize];
        int index = 0;
        for (int i = 0; i < plotSize; i++) {
            for (int j = 0; j < plotSize; j++) {
                plot[i][j] = plotState[index++];
            }
        }

        int totalHarvested = 0;
        boolean harvested;

        do {
            harvested = false;
            for (int i = 0; i < plotSize; i++) {
                for (int j = 0; j < plotSize; j++) {
                    if (plot[i][j].equals("ripe") && hasAdjacentRipe(plot, i, j)) {
                        plot[i][j] = "empty";
                        totalHarvested++;
                        harvested = true;
                    }
                }
            }
        } while (harvested);

        return totalHarvested;
    }

    private static boolean hasAdjacentRipe(String[][] plot, int row, int col) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int newRow = row + dx[i];
            int newCol = col + dy[i];

            if (newRow >= 0 && newRow < plot.length && newCol >= 0 && newCol < plot[0].length) {
                if (plot[newRow][newCol].equals("ripe")) {
                    return true;
                }
            }
        }

        return false;
    }
}