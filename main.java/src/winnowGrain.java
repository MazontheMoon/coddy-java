import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class WinnowGrain {
    public static int[] winnowGrain(int[] field, int windStrength, int harvestThreshold) {
        // Step 1: Remove negative numbers
        List<Integer> positiveNumbers = new ArrayList<>();
        for (int num : field) {
            if (num >= 0) {
                positiveNumbers.add(num);
            }
        }

        // Step 2: Apply wind effect
        Collections.rotate(positiveNumbers, -windStrength);

        // Step 3: Calculate Farmer's Lucky Number
        int luckyNumber = sumOfDigits(windStrength) * positiveNumbers.size();

        // Step 4: Replace prime numbers with Lucky Number
        for (int i = 0; i < positiveNumbers.size(); i++) {
            if (isPrime(positiveNumbers.get(i))) {
                positiveNumbers.set(i, luckyNumber);
            }
        }

        // Step 5: Keep numbers >= harvestThreshold
        List<Integer> harvestedGrains = new ArrayList<>();
        for (int num : positiveNumbers) {
            if (num >= harvestThreshold) {
                harvestedGrains.add(num);
            }
        }

        // Step 6: Sort in descending order
        Collections.sort(harvestedGrains, Collections.reverseOrder());

        // Step 7: Convert to array and return
        return harvestedGrains.stream().mapToInt(Integer::intValue).toArray();
    }

    private static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    private static int sumOfDigits(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
