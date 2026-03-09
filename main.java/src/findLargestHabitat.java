import java.util.Arrays;

class FindLargestHabitat {
    public static int findLargestHabitat(String[][] lakeGrid, String targetSpecies) {
        if (lakeGrid == null || lakeGrid.length == 0 || lakeGrid[0].length == 0) {
            return 0;
        }

        int rows = lakeGrid.length;
        int cols = lakeGrid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int maxHabitat = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j] && isMatch(lakeGrid[i][j], targetSpecies)) {
                    int size = dfs(lakeGrid, visited, i, j, targetSpecies);
                    maxHabitat = Math.max(maxHabitat, size);
                }
            }
        }

        return maxHabitat;
    }

    private static int dfs(String[][] lakeGrid, boolean[][] visited, int row, int col, String targetSpecies) {
        if (row < 0 || row >= lakeGrid.length || col < 0 || col >= lakeGrid[0].length 
                || visited[row][col] || !isMatch(lakeGrid[row][col], targetSpecies)) {
            return 0;
        }

        visited[row][col] = true;
        int size = 1;

        size += dfs(lakeGrid, visited, row + 1, col, targetSpecies);
        size += dfs(lakeGrid, visited, row - 1, col, targetSpecies);
        size += dfs(lakeGrid, visited, row, col + 1, targetSpecies);
        size += dfs(lakeGrid, visited, row, col - 1, targetSpecies);

        return size;
    }

    private static boolean isMatch(String cell, String targetSpecies) {
        if (cell.isEmpty()) {
            return false;
        }
        String[] targetWords = targetSpecies.toLowerCase().split(" ");
        String cellLower = cell.toLowerCase();
        return Arrays.stream(targetWords).anyMatch(cellLower::contains);
    }
}
