import java.util.HashSet;
import java.util.Set;

class CountSpecialPatterns {
    public static int countSpecialPatterns(int[][] garden, int hour, int targetSum) {
        int count = 0;
        int n = garden.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                count += countPatternsFromCell(garden, i, j, hour, targetSum);
            }
        }

        return count;
    }

    private static int countPatternsFromCell(int[][] garden, int row, int col, int hour, int targetSum) {
        int count = 0;
        int[] dx, dy;

        switch (hour) {
            case 12: dx = new int[]{1, 0}; dy = new int[]{0, 1}; break;
            case 3: dx = new int[]{0, 1}; dy = new int[]{1, 0}; break;
            case 6: dx = new int[]{-1, 0}; dy = new int[]{0, -1}; break;
            case 9: dx = new int[]{0, -1}; dy = new int[]{-1, 0}; break;
            default: dx = new int[]{1, 1, -1, -1}; dy = new int[]{1, -1, 1, -1}; break;
        }

        for (int d = 0; d < dx.length; d++) {
            count += countInDirection(garden, row, col, dx[d], dy[d], targetSum);
        }

        return count;
    }

    private static int countInDirection(int[][] garden, int row, int col, int dx, int dy, int targetSum) {
        int count = 0;
        int n = garden.length;
        int sum = 0;
        int start = garden[row][col];

        if (!isPrime(start)) return 0;

        while (row >= 0 && row < n && col >= 0 && col < n) {
            sum += garden[row][col];
            if (sum == targetSum && isFibonacci(garden[row][col])) {
                count++;
            }
            if (sum >= targetSum) break;
            row += dx;
            col += dy;
        }

        return count;
    }

    private static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    private static boolean isFibonacci(int n) {
        return isPerfectSquare(5 * n * n + 4) || isPerfectSquare(5 * n * n - 4);
    }

    private static boolean isPerfectSquare(int n) {
        int sqrt = (int) Math.sqrt(n);
        return sqrt * sqrt == n;
    }
}

