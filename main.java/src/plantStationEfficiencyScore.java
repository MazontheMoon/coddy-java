import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the size of the matrix
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the newline after the number
        
        // Initialize the matrix
        int[][] matrix = new int[n][n];
        
        // Read the matrix rows
        for (int i = 0; i < n; i++) {
            String[] values = scanner.nextLine().trim().split("\\s+");
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(values[j]);
            }
        }
        
        // Calculate the trace (sum of diagonal elements)
        int trace = 0;
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }
        
        // Output the efficiency score
        System.out.println(trace);
    }
}