/*
Write a function organizeFairLayout that takes respiratoryBooths, hotIssueBooths, rowSize and returns a 2D string array representing the final booth layout.

The function creates a snake-pattern layout by merging booth types alternately, arranging them in rows, and reversing every other row for optimal visitor flow.

Logic:

Merge the two arrays by alternating: first respiratory booth, first hot-issue booth, second respiratory booth, second hot-issue booth, etc.
If one array is longer, append remaining booths to the end
Split the merged list into rows of the specified size
Reverse every other row (rows at indices 1, 3, 5, etc.) to create a snake pattern
Parameters:

respiratoryBooths (String[]): Array of respiratory health booth names
hotIssueBooths (String[]): Array of current health issue booth names
rowSize (int): Number of booths per row
Returns: 2D string array with booth layout in snake pattern. Format: [["Booth1", "Booth2"], ["Booth4", "Booth3"]]
*/

import java.util.*;

class OrganizeFairLayout {
    public static String[][] organizeFairLayout(String[] respiratoryBooths, String[] hotIssueBooths, int rowSize) {
        // Merge the two arrays by alternating
        List<String> merged = new ArrayList<>();
        int i = 0, j = 0;
        
        while (i < respiratoryBooths.length && j < hotIssueBooths.length) {
            merged.add(respiratoryBooths[i++]);
            merged.add(hotIssueBooths[j++]);
        }
        
        // Add remaining booths from respiratory array
        while (i < respiratoryBooths.length) {
            merged.add(respiratoryBooths[i++]);
        }
        
        // Add remaining booths from hot issue array
        while (j < hotIssueBooths.length) {
            merged.add(hotIssueBooths[j++]);
        }
        
        // Calculate number of rows needed
        int numRows = (merged.size() + rowSize - 1) / rowSize;
        String[][] result = new String[numRows][];
        
        // Split into rows
        for (int row = 0; row < numRows; row++) {
            int startIndex = row * rowSize;
            int endIndex = Math.min(startIndex + rowSize, merged.size());
            int currentRowSize = endIndex - startIndex;
            
            result[row] = new String[currentRowSize];
            for (int col = 0; col < currentRowSize; col++) {
                result[row][col] = merged.get(startIndex + col);
            }
            
            // Reverse every other row (rows at indices 1, 3, 5, etc.)
            if (row % 2 == 1) {
                Collections.reverse(Arrays.asList(result[row]));
            }
        }
        
        return result;
    }
}