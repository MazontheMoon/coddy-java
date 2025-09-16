/*
Create a function named arrangeBotanicalSpecimens that receives leafVeinCounts as its parameter.

During a stroll through a botanical garden, you've collected leaf specimens and counted their veins. Now, it's time to analyze and arrange your findings.

Your task is to identify "special leaves" (leaves with a prime number of veins), count them, and sort all the specimens based on their vein counts.

Parameters:
- leafVeinCounts (int[]): An array of integers representing the number of veins in each leaf specimen.

The function should return a string in the format: "Special leaves: X, Sorted specimens: [Y, Z, ...]" where X is the count of special leaves, and [Y, Z, ...] is the sorted array of leaf vein counts.

Follow these steps to solve the challenge:
- Implement a method to check if a number is prime.
- Count the number of special leaves in the input array.
- Sort the input array in ascending order.
- Format and return the result string.
*/

import java.util.Arrays;

class ArrangeBotanicalSpecimens {
    public static String arrangeBotanicalSpecimens(int[] leafVeinCounts) {
        int specialLeaves = countSpecialLeaves(leafVeinCounts);
        Arrays.sort(leafVeinCounts);

        return String.format("Special leaves: %d, Sorted specimens: %s",
                specialLeaves,
                Arrays.toString(leafVeinCounts));
    }

    private static int countSpecialLeaves(int[] leafVeinCounts) {
        int count = 0;
        for (int veinCount : leafVeinCounts) {
            if (isPrime(veinCount)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
