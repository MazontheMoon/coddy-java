import java.util.ArrayList;
import java.util.List;

class GenerateWildGardenNumber {
    public static String generateWildGardenNumber(int days, float temperature, boolean hasRained, String dominantPlant) {
        // Step 1: Calculate base number
        int baseNumber = findNearestPrime((int) Math.round(days * temperature));

        // Step 2: Apply growth factor
        double modifiedBase = hasRained ? baseNumber * 1.5 : baseNumber * 0.8;

        // Step 3: Generate special number
        int specialNumber = findClosestPerfectSquare(dominantPlant.chars().sum());

        // Step 4: Combine and find nearest Fibonacci
        int combinedNumber = (int) Math.round(modifiedBase + specialNumber);
        int fibonacciNumber = findNearestFibonacci(combinedNumber);

        // Step 5: Create string representation
        String result = insertHyphens(String.valueOf(fibonacciNumber));
        return result + " (Fibonacci)";
    }

    private static int findNearestPrime(int n) {
        if (n <= 2) return 2;
        int lower = n, upper = n;
        while (true) {
            if (isPrime(lower)) return lower;
            if (isPrime(upper)) return upper;
            lower--;
            upper++;
        }
    }

    private static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    private static int findClosestPerfectSquare(int n) {
        int root = (int) Math.round(Math.sqrt(n));
        return root * root;
    }

    private static int findNearestFibonacci(int n) {
        if (n <= 0) return 0;
        int a = 0, b = 1;
        while (b < n) {
            int temp = b;
            b = a + b;
            a = temp;
        }
        return (n - a) > (b - n) ? b : a;
    }

    private static String insertHyphens(String number) {
        StringBuilder result = new StringBuilder(number);
        for (int i = result.length() - 3; i > 0; i -= 3) {
            result.insert(i, '-');
        }
        return result.toString();
    }
}
