import java.util.Arrays;

class SimulateParadeFormation {
    public static int[][] simulateParadeFormation(int gridSize, int[][] initialPositions, int transformationCount, String[] transformations) {
        int[][] grid = new int[gridSize][gridSize];
        
        // Initialize the grid with initial positions
        for (int[] position : initialPositions) {
            grid[position[0]][position[1]] = position[2];
        }
        
        // Apply transformations
        for (int i = 0; i < transformationCount; i++) {
            String transformation = transformations[i];
            if (transformation.equals("R90")) {
                grid = rotate90(grid);
            } else if (transformation.equals("FLIP_H")) {
                grid = flipHorizontal(grid);
            } else if (transformation.equals("FLIP_V")) {
                grid = flipVertical(grid);
            } else if (transformation.startsWith("SHIFT_R")) {
                int n = Integer.parseInt(transformation.split(" ")[1]);
                grid = shiftRight(grid, n);
            } else if (transformation.startsWith("SHIFT_D")) {
                int n = Integer.parseInt(transformation.split(" ")[1]);
                grid = shiftDown(grid, n);
            }
        }
        
        return grid;
    }
    
    private static int[][] rotate90(int[][] grid) {
        int n = grid.length;
        int[][] rotated = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotated[j][n - 1 - i] = grid[i][j];
            }
        }
        return rotated;
    }
    
    private static int[][] flipHorizontal(int[][] grid) {
        int n = grid.length;
        int[][] flipped = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                flipped[i][n - 1 - j] = grid[i][j];
            }
        }
        return flipped;
    }
    
    private static int[][] flipVertical(int[][] grid) {
        int n = grid.length;
        int[][] flipped = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                flipped[n - 1 - i][j] = grid[i][j];
            }
        }
        return flipped;
    }
    
    private static int[][] shiftRight(int[][] grid, int n) {
        int size = grid.length;
        n = n % size;
        int[][] shifted = new int[size][size];
        for (int i = 0; i < size; i++) {
            System.arraycopy(grid[i], size - n, shifted[i], 0, n);
            System.arraycopy(grid[i], 0, shifted[i], n, size - n);
        }
        return shifted;
    }
    
    private static int[][] shiftDown(int[][] grid, int n) {
        int size = grid.length;
        n = n % size;
        int[][] shifted = new int[size][size];
        System.arraycopy(grid, size - n, shifted, 0, n);
        System.arraycopy(grid, 0, shifted, n, size - n);
        return shifted;
    }
}
