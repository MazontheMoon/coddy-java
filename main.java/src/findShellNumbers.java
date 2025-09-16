/*
Create a function named findShellNumbers that receives an integer n as its parameter.

An archaeologist has discovered ancient shell-shaped musical instruments in a dusty museum. These shells contain sequences of numbers that follow a special pattern. Your task is to help the archaeologist identify these special numbers, which we'll call "Shell Numbers".

A number is considered a "Shell Number" if it meets the following criteria:
- It is divisible by the sum of its digits.
- The sum of its digits contains at least one even digit.
- Your function should find all Shell Numbers from 1 to n (inclusive).

Parameters:
- n (int): The upper limit of the range to search for Shell Numbers. (1 ≤ n ≤ 1000)

The function should return an integer array containing all the Shell Numbers found in ascending order.
*/

import java.util.ArrayList;
import java.util.List;

class FindShellNumbers {
    public static int[] findShellNumbers(int n) {
        List<Integer> shellNumbers = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            int digitSum = sumOfDigits(i);
            if (i % digitSum == 0 && hasEvenDigit(digitSum)) {
                shellNumbers.add(i);
            }
        }

        return shellNumbers.stream().mapToInt(Integer::intValue).toArray();
    }

    private static int sumOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    private static boolean hasEvenDigit(int num) {
        while (num > 0) {
            if ((num % 10) % 2 == 0) {
                return true;
            }
            num /= 10;
        }
        return false;
    }
}