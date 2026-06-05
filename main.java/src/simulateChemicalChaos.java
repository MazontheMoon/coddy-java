import java.util.Arrays;

class SimulateChemicalChaos {
    public static String[][] simulateChemicalChaos(String[][] grid) {
        String[][] result = new String[grid.length][];
        
        for (int i = 0; i < grid.length; i++) {
            result[i] = new String[grid[i].length];
            for (int j = 0; j < grid[i].length; j++) {
                result[i][j] = grid[i][grid[i].length - 1 - j];
            }
        }
        
        return result;
    }
}
