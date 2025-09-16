/*
Create a function named analyzeSpecimens that receives jars as its parameter.

You are an assistant to an underdog scientist in a laboratory, helping to analyze jarfuls of specimens. Your task is to process the data from these jars and provide a comprehensive analysis.

The function should perform the following operations:
- Calculate the total number of specimens in all jars.
- Find the index of the row (jar set) with the highest number of specimens.
- Reverse the order of specimens in each row.
- Calculate the average number of specimens per jar (rounded down to the nearest integer).

Parameters:
- jars (int[][]): A 2D array where each sub-array represents a set of jars, and each integer represents the number of specimens in a jar.

The function returns a String containing the analysis results in the following format:
"Total specimens: [total], Highest row: [row_index], Reversed data: [reversed_2d_array], Average per jar: [average]"

Note: The [reversed_2d_array] in the output should be represented as a string version of the 2D array.
*/

import java.util.Arrays;

class AnalyzeSpecimens {
    public static String analyzeSpecimens(int[][] jars) {
        // Calculate total specimens
        int totalSpecimens = 0;
        for (int[] row : jars) {
            for (int specimen : row) {
                totalSpecimens += specimen;
            }
        }

        // Find index of row with highest number of specimens
        int highestRowIndex = 0;
        int maxSpecimens = 0;
        for (int i = 0; i < jars.length; i++) {
            int rowSum = Arrays.stream(jars[i]).sum();
            if (rowSum > maxSpecimens) {
                maxSpecimens = rowSum;
                highestRowIndex = i;
            }
        }

        // Reverse order of specimens in each row
        int[][] reversedJars = new int[jars.length][];
        for (int i = 0; i < jars.length; i++) {
            reversedJars[i] = new int[jars[i].length];
            for (int j = 0; j < jars[i].length; j++) {
                reversedJars[i][j] = jars[i][jars[i].length - 1 - j];
            }
        }

        // Calculate average specimens per jar
        int totalJars = 0;
        for (int[] row : jars) {
            totalJars += row.length;
        }
        int averagePerJar = totalSpecimens / totalJars;

        // Prepare the output string
        String reversedDataStr = Arrays.deepToString(reversedJars);

        return String.format("Total specimens: %d, Highest row: %d, Reversed data: %s, Average per jar: %d",
                totalSpecimens, highestRowIndex, reversedDataStr, averagePerJar);
    }
}