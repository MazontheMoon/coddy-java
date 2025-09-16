/*
Create a function named countDataInMaze that receives maze, rows, cols, and dataPoint as its parameters.

The function should analyze a string representation of a data maze and count the occurrences of a specific data point. This challenge simulates a statistician navigating through a maze of data to extract meaningful insights.

The data maze is represented as a single string, where each row is concatenated. You need to navigate through this string as if it were a 2D grid, using the provided row and column information. Use nested loops to iterate through the maze and substring operations to check for the presence of the data point.

Parameters:
- maze (String): A string representing the data maze (2D grid of characters).
- rows (int): An integer representing the number of rows in the maze.
- cols (int): An integer representing the number of columns in the maze.
- dataPoint (String): A string representing the data point to search for.

The function returns an integer representing the count of occurrences of the data point in the maze.
*/

class CountDataInMaze {
    public static int countDataInMaze(String maze, int rows, int cols, String dataPoint) {
        int count = 0;
        int dataPointLength = dataPoint.length();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j <= cols - dataPointLength; j++) {
                int startIndex = i * cols + j;
                int endIndex = startIndex + dataPointLength;

                if (endIndex <= maze.length() && maze.substring(startIndex, endIndex).equals(dataPoint)) {
                    count++;
                }
            }
        }

        return count;
    }
}