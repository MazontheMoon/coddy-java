import java.util.Scanner;
import java.util.LinkedHashSet;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read volunteer name
        String name = scanner.nextLine();
        
        // Read multiplier
        int multiplier = Integer.parseInt(scanner.nextLine());
        
        // Read supply quantities
        String[] quantities = scanner.nextLine().split(" ");
        
        // Read number for Catalan calculation
        int n = Integer.parseInt(scanner.nextLine());
        
        // Task 1: Remove duplicate letters from name (keep first occurrence)
        String cleanedName = removeDuplicates(name);
        System.out.println(cleanedName);
        
        // Task 2: Multiply each quantity by the multiplier
        for (int i = 0; i < quantities.length; i++) {
            int quantity = Integer.parseInt(quantities[i]);
            int result = quantity * multiplier;
            if (i < quantities.length - 1) {
                System.out.print(result + " ");
            } else {
                System.out.println(result);
            }
        }
        
        // Task 3: Calculate nth Catalan number
        long catalan = calculateCatalan(n);
        System.out.println(catalan);
        
        scanner.close();
    }
    
    // Remove duplicate characters, keeping only first occurrence
    private static String removeDuplicates(String str) {
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        for (char c : str.toCharArray()) {
            set.add(c);
        }
        StringBuilder result = new StringBuilder();
        for (char c : set) {
            result.append(c);
        }
        return result.toString();
    }
    
    // Calculate nth Catalan number: C(n) = (2n)! / ((n+1)! * n!)
    private static long calculateCatalan(int n) {
        if (n <= 1) {
            return 1;
        }
        
        // Using dynamic programming approach to avoid overflow
        // C(n) = C(0)*C(n-1) + C(1)*C(n-2) + ... + C(n-1)*C(0)
        // Or more efficiently: C(n) = (2*(2n-1)/(n+1)) * C(n-1)
        long[] catalan = new long[n + 1];
        catalan[0] = 1;
        catalan[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            catalan[i] = 0;
            for (int j = 0; j < i; j++) {
                catalan[i] += catalan[j] * catalan[i - 1 - j];
            }
        }
        
        return catalan[n];
    }
}
