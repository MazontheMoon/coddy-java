import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the plant's scientific name (letters only)
        String plantName = scanner.nextLine();
        
        // Read the maximum catalog ID N for Hamming numbers
        int N = scanner.nextInt();
        
        // Read the two bed dimensions A and B
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        
        // TODO: Task 1 - Generate all letter-case permutations of plantName
        // Hint: Use recursion or iteration to generate all combinations
        // Store results in a list and sort them lexicographically
        List<String> casePermutations = new ArrayList<>();
        // Your code here to generate permutations
        
        // Output case permutations
        for (String perm : casePermutations) {
            System.out.println(perm);
        }
        
        // TODO: Task 2 - Find all Hamming numbers up to N
        // Hint: Hamming numbers only have prime factors 2, 3, and 5
        // You can generate them systematically or check each number
        List<Integer> hammingNumbers = new ArrayList<>();
        // Your code here to find Hamming numbers
        
        // Output Hamming numbers
        for (int i = 0; i < hammingNumbers.size(); i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(hammingNumbers.get(i));
        }
        System.out.println();
        
        // TODO: Task 3 - Calculate extended GCD
        // Hint: Use the Extended Euclidean Algorithm
        // Find GCD and coefficients X, Y such that A*X + B*Y = GCD
        int gcd = 0;
        int x = 0;
        int y = 0;
        // Your code here to calculate extended GCD
        
        // Output extended GCD result
        System.out.println("GCD: " + gcd + ", X: " + x + ", Y: " + y);
        
        scanner.close();
    }
}
