/*
Create a function named morningGardenWalk that receives flowers as its parameter.

The function simulates a peaceful morning walk through a dewy garden, where you encounter various flowers. Each flower is represented by a number in the input array. Your task is to identify the "happy flowers" (represented by happy numbers) and calculate their sum.

A happy number is defined by the following process:
- Starting with any positive integer, replace the number by the sum of the squares of its digits.
- Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle that does not include 1.

For example, 19 is a happy number because:

1² + 9² = 82
8² + 2² = 68
6² + 8² = 100
1² + 0² + 0² = 1

Your function should iterate through the input array, check if each number is a happy number, and add it to the sum if it is.

Parameters:
- flowers (int[]): An array of positive integers representing the flowers encountered during the walk.

The function returns an integer representing the sum of all happy numbers found in the input array.
*/

import java.util.HashSet;

class MorningGardenWalk {
    public static int morningGardenWalk(int[] flowers) {
        int sum = 0;
        for (int flower : flowers) {
            if (isHappyNumber(flower)) {
                sum += flower;
            }
        }
        return sum;
    }

    private static boolean isHappyNumber(int n) {
        HashSet<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = sumOfSquaresOfDigits(n);
        }
        return n == 1;
    }

    private static int sumOfSquaresOfDigits(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }
}