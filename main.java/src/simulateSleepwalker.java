import java.util.Arrays;

class SimulateSleepwalker {
    public static int[][] simulateSleepwalker(int[][] room, int startX, int startY, int steps) {
        int rows = room.length;
        int cols = room[0].length;
        int currentX = startX;
        int currentY = startY;

        for (int step = 0; step < steps; step++) {
            int[] nextMove = getNextMove(room, currentX, currentY);
            int nextX = currentX + nextMove[0];
            int nextY = currentY + nextMove[1];

            if (isValidMove(room, nextX, nextY)) {
                if (room[currentX][currentY] > 2) {
                    room[currentX][currentY]--;
                }
                currentX = nextX;
                currentY = nextY;
            }
        }

        room[currentX][currentY] = -1;

        for (int i = 0; i < rows; i++) {
            sortRow(room[i]);
        }

        return room;
    }

    private static int[] getNextMove(int[][] room, int x, int y) {
        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        double minIntensity = Double.MAX_VALUE;
        int[] bestMove = {0, 0};

        for (int[] dir : directions) {
            int newX = x + dir[0];
            int newY = y + dir[1];
            if (isValidMove(room, newX, newY)) {
                double avgIntensity = getAverageIntensity(room, newX, newY);
                if (avgIntensity < minIntensity) {
                    minIntensity = avgIntensity;
                    bestMove = dir;
                }
            }
        }

        return bestMove;
    }

    private static boolean isValidMove(int[][] room, int x, int y) {
        return x >= 0 && x < room.length && y >= 0 && y < room[0].length && room[x][y] != 1;
    }

    private static double getAverageIntensity(int[][] room, int x, int y) {
        int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 0}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        int sum = 0;
        int count = 0;

        for (int[] dir : directions) {
            int newX = x + dir[0];
            int newY = y + dir[1];
            if (isValidMove(room, newX, newY)) {
                sum += room[newX][newY];
                count++;
            }
        }

        return (double) sum / count;
    }

    private static void sortRow(int[] row) {
        int n = row.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (row[j] != 1 && row[j] != -1 && row[j + 1] != 1 && row[j + 1] != -1 && row[j] < row[j + 1]) {
                    int temp = row[j];
                    row[j] = row[j + 1];
                    row[j + 1] = temp;
                }
            }
        }
    }
}
