import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the number of scores
        int n = Integer.parseInt(scanner.nextLine());
        
        // Read the scores
        String[] scoreStrings = scanner.nextLine().split(" ");
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            scores[i] = Integer.parseInt(scoreStrings[i]);
        }
        
        // Read the target score to find
        int target = Integer.parseInt(scanner.nextLine());
        
        // Check 1: Are scores in descending order?
        boolean isDescending = true;
        for (int i = 0; i < n - 1; i++) {
            if (scores[i] <= scores[i + 1]) {
                isDescending = false;
                break;
            }
        }
        
        // Check 2: Find the position of target score
        int position = -1;
        for (int i = 0; i < n; i++) {
            if (scores[i] == target) {
                position = i;
                break;
            }
        }
        
        // Check 3: Is it a geometric sequence?
        boolean isGeometric = true;
        if (n >= 2) {
            // Need at least 2 elements for a geometric sequence
            // Check if first element is 0 (would cause division by zero)
            if (scores[0] == 0) {
                isGeometric = false;
            } else {
                double ratio = (double) scores[1] / scores[0];
                
                for (int i = 1; i < n - 1; i++) {
                    if (scores[i] == 0) {
                        isGeometric = false;
                        break;
                    }
                    double currentRatio = (double) scores[i + 1] / scores[i];
                    // Use a small epsilon for floating point comparison
                    if (Math.abs(currentRatio - ratio) > 0.0001) {
                        isGeometric = false;
                        break;
                    }
                }
            }
        }
        // If n < 2, it's considered geometric (trivially true for 1 element)
        
        // Print results
        System.out.println(isDescending);
        System.out.println(position);
        System.out.println(isGeometric);
    }
}
