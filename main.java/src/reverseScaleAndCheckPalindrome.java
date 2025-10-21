/*
Create a function named reverseScaleAndCheckPalindrome that receives scales as its parameter.

In a vibrant Barrio neighborhood, a passionate musician is teaching his students about musical scales and the concept of palindromes. He wants to create a function that reverses each scale in a list of scales and checks if the reversed scale forms a palindrome.

A scale is considered a palindrome if it reads the same forwards and backwards. For example, the scale ["do", "re", "mi", "re", "do"] is a palindrome because when reversed, it remains the same.

Parameters:
- scales (String[][]): A 2D array where each inner array represents a musical scale with string elements as notes.

The function should perform the following steps for each scale:
- Reverse the order of notes in the scale.
- Check if the reversed scale is identical to the original scale (ignoring case).
- If it is identical, consider it a palindrome; otherwise, it's not a palindrome.

The function returns a String array where each element is either "Palindrome" if the reversed scale is a palindrome, or "Not a palindrome" if it's not.

Note: The comparison should be case-insensitive, meaning "Do" and "do" should be considered the same note.
 */

import java.util.Arrays;

class ReverseScaleAndCheckPalindrome {
    public static String[] reverseScaleAndCheckPalindrome(String[][] scales) {
        String[] result = new String[scales.length];

        for (int i = 0; i < scales.length; i++) {
            String[] originalScale = scales[i];
            String[] reversedScale = reverseScale(originalScale);

            if (isPalindrome(originalScale, reversedScale)) {
                result[i] = "Palindrome";
            } else {
                result[i] = "Not a palindrome";
            }
        }

        return result;
    }

    private static String[] reverseScale(String[] scale) {
        String[] reversed = new String[scale.length];
        for (int i = 0; i < scale.length; i++) {
            reversed[i] = scale[scale.length - 1 - i];
        }
        return reversed;
    }

    private static boolean isPalindrome(String[] original, String[] reversed) {
        if (original.length != reversed.length) {
            return false;
        }

        for (int i = 0; i < original.length; i++) {
            if (!original[i].equalsIgnoreCase(reversed[i])) {
                return false;
            }
        }

        return true;
    }
}