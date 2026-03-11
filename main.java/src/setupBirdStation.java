class SetupBirdStation {
    public static int[] setupBirdStation(int[][] morningData, int[][] eveningData, int goldenEyeCount, int[] eyecupStock) {
        int rows = morningData.length;
        int cols = morningData[0].length;
        
        // Create merged 2D array
        int[][] merged = new int[rows][cols];
        
        // Process each row (day)
        for (int i = 0; i < rows; i++) {
            // Pre-increment goldenEyeCount before adding to first column
            ++goldenEyeCount;
            
            // Merge the data and add goldenEyeCount to first column
            for (int j = 0; j < cols; j++) {
                merged[i][j] = morningData[i][j] + eveningData[i][j];
                if (j == 0) {
                    merged[i][j] += goldenEyeCount;
                }
            }
            
            // Post-decrement goldenEyeCount after processing each row
            goldenEyeCount--;
        }
        
        // Flatten the merged 2D array
        int[] flattened = new int[rows * cols];
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                flattened[index++] = merged[i][j];
            }
        }
        
        // Concatenate with eyecup stock
        int[] result = new int[flattened.length + eyecupStock.length];
        
        // Copy flattened data
        for (int i = 0; i < flattened.length; i++) {
            result[i] = flattened[i];
        }
        
        // Copy eyecup stock
        for (int i = 0; i < eyecupStock.length; i++) {
            result[flattened.length + i] = eyecupStock[i];
        }
        
        return result;
    }
}