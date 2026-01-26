class LandDivisionOptimizer {
    public static int[][] landDivisionOptimizer(int[][] propertyMap, int minArea, float[] aspectRatioRange) {
        int rows = propertyMap.length;
        int cols = propertyMap[0].length;
        
        // Check if the entire property map satisfies the constraints
        if (isValidPlot(propertyMap, minArea, aspectRatioRange)) {
            return propertyMap;
        }
        
        // Divide the property map into smaller plots
        for (int i = 1; i < rows; i++) {
            int[][] upperPlot = getSubArray(propertyMap, 0, 0, i, cols);
            int[][] lowerPlot = getSubArray(propertyMap, i, 0, rows - i, cols);
            
            if (isValidDivision(upperPlot, lowerPlot, minArea, aspectRatioRange)) {
                return combineArrays(landDivisionOptimizer(upperPlot, minArea, aspectRatioRange),
                                    landDivisionOptimizer(lowerPlot, minArea, aspectRatioRange));
            }
        }
        
        for (int j = 1; j < cols; j++) {
            int[][] leftPlot = getSubArray(propertyMap, 0, 0, rows, j);
            int[][] rightPlot = getSubArray(propertyMap, 0, j, rows, cols - j);
            
            if (isValidDivision(leftPlot, rightPlot, minArea, aspectRatioRange)) {
                return combineArrays(landDivisionOptimizer(leftPlot, minArea, aspectRatioRange),
                                    landDivisionOptimizer(rightPlot, minArea, aspectRatioRange));
            }
        }
        
        // No valid division found
        return new int[0][0];
    }
    
    private static boolean isValidPlot(int[][] plot, int minArea, float[] aspectRatioRange) {
        int rows = plot.length;
        int cols = plot[0].length;
        int area = rows * cols;
        float aspectRatio = (float) cols / rows;
        
        if (area < minArea || aspectRatio < aspectRatioRange[0] || aspectRatio > aspectRatioRange[1]) {
            return false;
        }
        
        int ownerId = plot[0][0];
        for (int[] row : plot) {
            for (int cell : row) {
                if (cell != ownerId) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private static boolean isValidDivision(int[][] plot1, int[][] plot2, int minArea, float[] aspectRatioRange) {
        return isValidPlot(plot1, minArea, aspectRatioRange) && isValidPlot(plot2, minArea, aspectRatioRange);
    }
    
    private static int[][] getSubArray(int[][] array, int startRow, int startCol, int rows, int cols) {
        int[][] subArray = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                subArray[i][j] = array[startRow + i][startCol + j];
            }
        }
        return subArray;
    }
    
    private static int[][] combineArrays(int[][] array1, int[][] array2) {
        int rows1 = array1.length;
        int cols1 = array1[0].length;
        int rows2 = array2.length;
        int cols2 = array2[0].length;
        
        int[][] combinedArray = new int[rows1 + rows2][Math.max(cols1, cols2)];
        
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols1; j++) {
                combinedArray[i][j] = array1[i][j];
            }
        }
        
        for (int i = 0; i < rows2; i++) {
            for (int j = 0; j < cols2; j++) {
                combinedArray[rows1 + i][j] = array2[i][j];
            }
        }
        
        return combinedArray;
    }
}
