import java.util.Scanner;
import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Task 1: Fence Painting
        String[] fenceInput = scanner.nextLine().split(" ");
        int posts = Integer.parseInt(fenceInput[0]);
        int colors = Integer.parseInt(fenceInput[1]);
        long fenceWays = calculateFenceWays(posts, colors);
        System.out.println(fenceWays);
        
        // Task 2: Consecutive Table Numbers
        String[] tableInput = scanner.nextLine().split(" ");
        int[] tables = new int[tableInput.length];
        for (int i = 0; i < tableInput.length; i++) {
            tables[i] = Integer.parseInt(tableInput[i]);
        }
        boolean isConsecutive = checkConsecutive(tables);
        System.out.println(isConsecutive ? "Consecutive" : "Not consecutive");
        
        // Task 3: Magic Square
        int size = Integer.parseInt(scanner.nextLine());
        int[][] magicSquare = generateMagicSquare(size);
        printMagicSquare(magicSquare);
        
        scanner.close();
    }
    
    // Calculate fence painting ways using dynamic programming
    // dp[i][j] = ways to paint i posts where last j posts have same color
    static long calculateFenceWays(int posts, int colors) {
        if (posts == 0) return 0;
        if (posts == 1) return colors;
        
        // dp[i][0] = ways where post i is different from post i-1
        // dp[i][1] = ways where post i is same as post i-1 (but i-1 differs from i-2)
        long[][] dp = new long[posts + 1][2];
        
        dp[1][0] = colors;
        dp[1][1] = 0;
        
        for (int i = 2; i <= posts; i++) {
            // Different from previous: can follow any configuration
            dp[i][0] = (dp[i-1][0] + dp[i-1][1]) * (colors - 1);
            // Same as previous: can only follow "different" configuration
            dp[i][1] = dp[i-1][0];
        }
        
        return dp[posts][0] + dp[posts][1];
    }
    
    // Check if numbers form consecutive sequence
    static boolean checkConsecutive(int[] numbers) {
        if (numbers.length <= 1) return true;
        
        Arrays.sort(numbers);
        
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] != numbers[i-1] + 1) {
                return false;
            }
        }
        
        return true;
    }
    
    // Generate magic square using Siamese method (for odd-sized squares)
    static int[][] generateMagicSquare(int size) {
        int[][] square = new int[size][size];
        
        // Start position: middle of first row
        int row = 0;
        int col = size / 2;
        
        for (int num = 1; num <= size * size; num++) {
            square[row][col] = num;
            
            // Calculate next position: up and right
            int nextRow = (row - 1 + size) % size;
            int nextCol = (col + 1) % size;
            
            // If position is occupied, go down instead
            if (square[nextRow][nextCol] != 0) {
                nextRow = (row + 1) % size;
                nextCol = col;
            }
            
            row = nextRow;
            col = nextCol;
        }
        
        return square;
    }
    
    // Print magic square
    static void printMagicSquare(int[][] square) {
        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square[i].length; j++) {
                if (j > 0) System.out.print(" ");
                System.out.print(square[i][j]);
            }
            System.out.println();
        }
    }
}