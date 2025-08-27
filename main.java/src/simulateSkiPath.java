/*
Create a function named simulateSkiPath that receives heights and startPosition as its parameters.

The function simulates a skier's path down a slope using array manipulation. It should return a string that represents the skier's path down the slope, using 'O' to represent the skier and '-' for the parts of the slope the skier doesn't occupy.

The skier will always move downhill, meaning they will move to the next lower height. If there are multiple lower heights available, the skier will choose the closest one. If there are no lower heights available, the skier stops.

Parameters:

- heights (int[]): An integer array representing the heights of different points on the ski slope.
- startPosition (int): An integer representing the starting position of the skier on the slope.

The function returns a string representing the skier's path down the slope.

Example:
int[] heights = {5, 4, 3, 2, 1};
int startPosition = 0;
String result = simulateSkiPath(heights, startPosition);
// result should be:
// "O----\n-O---\n--O--\n---O-\n----O"
In this example, the skier starts at position 0 and moves down the slope, always choosing the next lower height.

Remember to handle cases where the skier might stop before reaching the end of the slope if there are no lower heights available.
*/
import java.util.Arrays;

class SimulateSkiPath {
    public static String simulateSkiPath(int[] heights, int startPosition) {
        StringBuilder result = new StringBuilder();
        int currentPosition = startPosition;
        int currentHeight = heights[startPosition];

        for (int i = 0; i < heights.length; i++) {
            char[] row = new char[heights.length];
            Arrays.fill(row, '-');
            row[currentPosition] = 'O';
            result.append(new String(row));

            if (i < heights.length - 1) {
                result.append("\n");
                int nextPosition = findNextPosition(heights, currentPosition, currentHeight);
                if (nextPosition == currentPosition) {
                    break;
                }
                currentPosition = nextPosition;
                currentHeight = heights[currentPosition];
            }
        }

        return result.toString();
    }

    private static int findNextPosition(int[] heights, int currentPosition, int currentHeight) {
        int leftDiff = Integer.MAX_VALUE;
        int rightDiff = Integer.MAX_VALUE;
        int leftPos = currentPosition;
        int rightPos = currentPosition;

        for (int i = currentPosition - 1; i >= 0; i--) {
            if (heights[i] < currentHeight) {
                leftDiff = currentPosition - i;
                leftPos = i;
                break;
            }
        }

        for (int i = currentPosition + 1; i < heights.length; i++) {
            if (heights[i] < currentHeight) {
                rightDiff = i - currentPosition;
                rightPos = i;
                break;
            }
        }

        if (leftDiff < rightDiff) {
            return leftPos;
        } else if (rightDiff < leftDiff) {
            return rightPos;
        } else {
            return currentPosition;
        }
    }
}
