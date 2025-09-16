/*
Create a function named copyMachineGlitch that receives words and behavior as its parameters.

The function simulates a malfunctioning office copy machine that randomly duplicates or skips words in a sentence. It processes the input words according to the behavior array and returns a single string with the "copied" sentence.

Parameters:
- words (String[]): An array of strings representing the original sentence split into individual words.
- behavior (int[]): An array of integers determining how the copy machine treats each word:
- If the number is 0, the word is skipped.
- If the number is 1, the word is copied normally.
- If the number is greater than 1, the word is duplicated that many times.

The function returns a string representing the "copied" sentence with words separated by a single space, without leading or trailing spaces.

Important Notes:
- The words and behavior arrays will always have the same length.
- The behavior array will only contain non-negative integers.
- You may assume that the input arrays will not be empty.
- The maximum length for each word is 20 characters.
- The maximum length for the input arrays is 100 elements.

To solve this challenge, you'll need to use basic array manipulation, string formatting, and control flow statements. Consider using StringBuilder for efficient string concatenation.
*/

import java.util.ArrayList;
import java.util.List;

class CopyMachineGlitch {
    public static String copyMachineGlitch(String[] words, int[] behavior) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            int repeat = behavior[i];
            if (repeat > 0) {
                for (int j = 0; j < repeat; j++) {
                    result.add(words[i]);
                }
            }
        }

        return String.join(" ", result);
    }
}
