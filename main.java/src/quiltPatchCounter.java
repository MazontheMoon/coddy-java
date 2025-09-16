/*
Create a function named quiltPatchCounter that receives quiltPattern as its parameter.

The function should count the number of special "patches" in the given quilt pattern. A special patch is defined as a substring that starts with a vowel (a, e, i, o, u) and ends with a prime number (2, 3, 5, or 7). The substring should be at least 3 characters long.

To solve this problem, follow these steps:
- Iterate through the quilt pattern string.
- When you find a vowel, check if there's a prime number (2, 3, 5, or 7) at least two positions after it.
- If a special patch is found, increment the counter.
- Continue this process until you've checked the entire string.

Parameters:
- quiltPattern (String): A string representing a quilt pattern, consisting of lowercase letters and numbers.

The function returns an integer, which is the count of special patches found in the quilt pattern.
*/

import java.util.Arrays;

class QuiltPatchCounter {
    public static int quiltPatchCounter(String quiltPattern) {
        int count = 0;
        String vowels = "aeiou";
        int[] primes = {2, 3, 5, 7};

        for (int i = 0; i < quiltPattern.length() - 2; i++) {
            if (vowels.indexOf(quiltPattern.charAt(i)) != -1) {
                for (int j = i + 2; j < quiltPattern.length(); j++) {
                    char endChar = quiltPattern.charAt(j);
                    if (Character.isDigit(endChar)) {
                        int endNum = Character.getNumericValue(endChar);
                        if (Arrays.binarySearch(primes, endNum) >= 0) {
                            count++;
                            break;
                        }
                    }
                }
            }
        }

        return count;
    }
}