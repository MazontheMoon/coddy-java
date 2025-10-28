/*
Create a function named vampireBatCode that receives message as its parameter.

Your task is to convert the input message into a special "vampire bat code" based on the following rules:
- Replace all vowels (a, e, i, o, u) with the number of times they appear in the message (case-insensitive).
- Replace spaces with underscore "_".
- Reverse the entire resulting string.
- Add "BAT" at the beginning and end of the final string.

Parameters:
- message (String): A string containing the secret message to be encoded. It will be 1 to 100 characters long, containing only letters, spaces, and punctuation.

The function returns a String representing the encoded message.

Note: Your solution should use basic string manipulation techniques and work with counting occurrences (special numbers). Ensure your implementation is within 10-19 lines of code.
 */

import java.util.HashMap;

class VampireBatCode {
    public static String vampireBatCode(String message) {
        HashMap<Character, Integer> vowelCount = new HashMap<>();
        String vowels = "aeiou";
        StringBuilder result = new StringBuilder();

        for (char c : message.toLowerCase().toCharArray()) {
            if (vowels.indexOf(c) != -1) {
                vowelCount.put(c, vowelCount.getOrDefault(c, 0) + 1);
            }
        }

        for (char c : message.toCharArray()) {
            char lc = Character.toLowerCase(c);
            if (vowels.indexOf(lc) != -1) {
                result.append(vowelCount.get(lc));
            } else if (c == ' ') {
                result.append('_');
            } else {
                result.append(c);
            }
        }

        return "BAT" + result.reverse().toString() + "BAT";
    }
}
