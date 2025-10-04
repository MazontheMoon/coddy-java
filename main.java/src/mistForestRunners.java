/*
Create a function named mistForestRunners that receives runners as its parameter.

The function simulates a group of runners progressing through a misty forest path, represented by a 2D array. It should reverse the order of runners and calculate their total distance traveled.

Follow these steps to solve the challenge:
- Reverse the order of runners (reverse the rows of the 2D array)
- Calculate the total distance traveled by each runner
- Return an integer array containing the total distances in the new reversed order

Parameter:
- runners (int[][]): A 2D integer array where each row represents a runner, and each column represents a checkpoint in the misty forest. The values indicate the distance each runner has traveled between checkpoints.
The function returns an integer array containing the total distances traveled by each runner in the reversed order.
*/

import java.util.Arrays;

class MistForestRunners {
    public static int[] mistForestRunners(int[][] runners) {
        int numRunners = runners.length;
        int[] totalDistances = new int[numRunners];

        // Reverse the order of runners
        for (int i = 0; i < numRunners / 2; i++) {
            int[] temp = runners[i];
            runners[i] = runners[numRunners - 1 - i];
            runners[numRunners - 1 - i] = temp;
        }

        // Calculate total distance for each runner
        for (int i = 0; i < numRunners; i++) {
            int sum = 0;
            for (int distance : runners[i]) {
                sum += distance;
            }
            totalDistances[i] = sum;
        }

        return totalDistances;
    }
}