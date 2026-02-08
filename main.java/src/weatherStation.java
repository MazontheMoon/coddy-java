import java.util.Scanner;
import java.util.TreeSet;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read grid dimensions
        String[] dimensions = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);
        
        // Read the flood map
        int[][] grid = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            String[] rowData = scanner.nextLine().split(" ");
            for (int j = 0; j < cols; j++) {
                grid[i][j] = Integer.parseInt(rowData[j]);
            }
        }
        
        // Count flood regions using flood fill
        int floodRegions = countFloodRegions(grid, rows, cols);
        
        // Read number of volunteers
        int numVolunteers = Integer.parseInt(scanner.nextLine());
        
        // Read and format volunteer names
        String[] volunteers = new String[numVolunteers];
        for (int i = 0; i < numVolunteers; i++) {
            volunteers[i] = toTitleCase(scanner.nextLine());
        }
        
        // Read N for ugly number
        int n = Integer.parseInt(scanner.nextLine());
        
        // Calculate Nth ugly number
        long nthUgly = getNthUglyNumber(n);
        
        // Print results
        System.out.println(floodRegions);
        for (String volunteer : volunteers) {
            System.out.println(volunteer);
        }
        System.out.println(nthUgly);
        
        scanner.close();
    }
    
    // Flood fill algorithm to count connected regions
    private static int countFloodRegions(int[][] grid, int rows, int cols) {
        boolean[][] visited = new boolean[rows][cols];
        int count = 0;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    floodFill(grid, visited, i, j, rows, cols);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    // Recursive flood fill helper
    private static void floodFill(int[][] grid, boolean[][] visited, int row, int col, int rows, int cols) {
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            return;
        }
        if (visited[row][col] || grid[row][col] == 0) {
            return;
        }
        
        visited[row][col] = true;
        
        // Check all 4 directions (horizontal and vertical only)
        floodFill(grid, visited, row - 1, col, rows, cols); // up
        floodFill(grid, visited, row + 1, col, rows, cols); // down
        floodFill(grid, visited, row, col - 1, rows, cols); // left
        floodFill(grid, visited, row, col + 1, rows, cols); // right
    }
    
    // Convert string to title case
    private static String toTitleCase(String input) {
        String[] words = input.split(" ");
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 0) {
                String word = words[i].toLowerCase();
                word = Character.toUpperCase(word.charAt(0)) + word.substring(1);
                result.append(word);
                if (i < words.length - 1) {
                    result.append(" ");
                }
            }
        }
        
        return result.toString();
    }
    
    // Calculate Nth ugly number using dynamic programming
    private static long getNthUglyNumber(int n) {
        TreeSet<Long> uglySet = new TreeSet<>();
        uglySet.add(1L);
        
        long currentUgly = 1L;
        
        for (int i = 0; i < n; i++) {
            currentUgly = uglySet.pollFirst();
            
            uglySet.add(currentUgly * 2);
            uglySet.add(currentUgly * 3);
            uglySet.add(currentUgly * 5);
        }
        
        return currentUgly;
    }
}
