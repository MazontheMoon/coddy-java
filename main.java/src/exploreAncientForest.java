import java.util.*;

class ExploreAncientForest {
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static final double SPROUT_CHANCE = 0.1;
    private static final int MAX_HEIGHT = 10;

    public static int exploreAncientForest(int[][] forest, int steps, int[] preferredHeights) {
        int rows = forest.length;
        int cols = forest[0].length;
        Set<Integer> preferredSet = new HashSet<>();
        for (int height : preferredHeights) {
            preferredSet.add(height);
        }

        double maxProbability = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                maxProbability = Math.max(maxProbability, dfs(forest, i, j, steps, preferredSet, new boolean[rows][cols]));
            }
        }

        return (int) Math.floor(maxProbability * 100);
    }

    private static double dfs(int[][] forest, int row, int col, int steps, Set<Integer> preferredSet, boolean[][] visited) {
        if (steps == 0) {
            return 0;
        }

        visited[row][col] = true;
        double probability = preferredSet.contains(forest[row][col]) ? 1 : 0;

        double maxChildProbability = 0;
        for (int[] dir : DIRECTIONS) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (isValid(forest, newRow, newCol) && !visited[newRow][newCol]) {
                int[][] newForest = updateForest(forest);
                maxChildProbability = Math.max(maxChildProbability, dfs(newForest, newRow, newCol, steps - 1, preferredSet, visited));
            }
        }

        visited[row][col] = false;
        return probability + (1 - probability) * maxChildProbability;
    }

    private static boolean isValid(int[][] forest, int row, int col) {
        return row >= 0 && row < forest.length && col >= 0 && col < forest[0].length;
    }

    private static int[][] updateForest(int[][] forest) {
        int[][] newForest = new int[forest.length][forest[0].length];
        for (int i = 0; i < forest.length; i++) {
            for (int j = 0; j < forest[0].length; j++) {
                if (forest[i][j] == 0) {
                    newForest[i][j] = Math.random() < SPROUT_CHANCE ? 1 : 0;
                } else if (forest[i][j] == MAX_HEIGHT - 1) {
                    newForest[i][j] = 0;
                } else {
                    newForest[i][j] = forest[i][j] + 1;
                }
            }
        }
        return newForest;
    }
}