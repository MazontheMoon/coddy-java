import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String operation = scanner.nextLine().trim();
        String data = scanner.nextLine().trim();
        
        if (operation.equals("1")) {
            // Find first available platform (first 1 in the array)
            String[] platforms = data.split(" ");
            int result = -1;
            for (int i = 0; i < platforms.length; i++) {
                if (platforms[i].equals("1")) {
                    result = i;
                    break;
                }
            }
            System.out.println(result);
            
        } else if (operation.equals("2")) {
            // Check if four numbers can make 24
            String[] parts = data.split(" ");
            int[] nums = new int[4];
            for (int i = 0; i < 4; i++) {
                nums[i] = Integer.parseInt(parts[i]);
            }
            boolean canMake24 = canMake24(nums);
            System.out.println(canMake24 ? "true" : "false");
            
        } else if (operation.equals("3")) {
            // Calculate Stirling number of the second kind
            String[] parts = data.split(" ");
            int n = Integer.parseInt(parts[0]);
            int k = Integer.parseInt(parts[1]);
            long result = stirling(n, k);
            System.out.println(result);
        }
    }
    
    // Check if four numbers can make 24 using +, -, *, /
    private static boolean canMake24(int[] nums) {
        double[] doubles = new double[4];
        for (int i = 0; i < 4; i++) {
            doubles[i] = nums[i];
        }
        return solve(doubles);
    }
    
    private static boolean solve(double[] nums) {
        if (nums.length == 1) {
            return Math.abs(nums[0] - 24.0) < 1e-6;
        }
        
        // Try all pairs
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                double a = nums[i];
                double b = nums[j];
                
                // Create new array without i and j
                double[] remaining = new double[nums.length - 1];
                int idx = 0;
                for (int k = 0; k < nums.length; k++) {
                    if (k != i && k != j) {
                        remaining[idx++] = nums[k];
                    }
                }
                
                // Try all operations
                double[] operations = {a + b, a - b, b - a, a * b};
                for (double result : operations) {
                    remaining[remaining.length - 1] = result;
                    if (solve(remaining)) return true;
                }
                
                // Division (avoid division by zero)
                if (Math.abs(b) > 1e-6) {
                    remaining[remaining.length - 1] = a / b;
                    if (solve(remaining)) return true;
                }
                if (Math.abs(a) > 1e-6) {
                    remaining[remaining.length - 1] = b / a;
                    if (solve(remaining)) return true;
                }
            }
        }
        
        return false;
    }
    
    // Calculate Stirling number of the second kind S(n, k)
    private static long stirling(int n, int k) {
        if (n == 0 && k == 0) return 1;
        if (n == 0 || k == 0) return 0;
        if (k > n) return 0;
        if (k == 1 || k == n) return 1;
        
        // Use dynamic programming
        long[][] dp = new long[n + 1][k + 1];
        
        // Base cases
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        dp[0][0] = 1;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.min(i, k); j++) {
                if (j == 1) {
                    dp[i][j] = 1;
                } else if (i == j) {
                    dp[i][j] = 1;
                } else {
                    // S(n,k) = k*S(n-1,k) + S(n-1,k-1)
                    dp[i][j] = j * dp[i - 1][j] + dp[i - 1][j - 1];
                }
            }
        }
        
        return dp[n][k];
    }
}
