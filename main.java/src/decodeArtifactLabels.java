/*
Create a function named decodeArtifactLabels that receives String[] encodedLabels and String decodeKey as its parameters.

As a curious collector in an antique shop, you've discovered a set of artifacts with mysterious encoded labels. Your task is to decode these labels to reveal the true names of the artifacts.

The decoding process involves the following steps:
- Reverse each encoded label.
- Remove any character from the reversed label that appears in the decode key.
- Capitalize the first letter of the resulting string and make the rest lowercase.

Parameters:
- encodedLabels (String[]): An array of encoded artifact labels.
- decodeKey (String): A string containing characters to be removed from the reversed labels.

The function returns a String array containing the decoded artifact labels.

For example, if the encoded label is "esaVtneicnA" and the decode key is "ci", the decoding process would be:
- Reverse: "AncientVase"
- Remove 'c' and 'i': "AnentVase"
- Capitalize first letter, rest lowercase: "Anentvase"
*/

import java.util.*;

class DecodeArtifactLabels {
    public static String[] decodeArtifactLabels(String[] encodedLabels, String decodeKey) {
        String[] decodedLabels = new String[encodedLabels.length];
        Set<Character> keyChars = new HashSet<>();

        for (char c : decodeKey.toCharArray()) {
            keyChars.add(c);
        }

        for (int i = 0; i < encodedLabels.length; i++) {
            StringBuilder reversed = new StringBuilder(encodedLabels[i]).reverse();
            StringBuilder decoded = new StringBuilder();

            for (char c : reversed.toString().toCharArray()) {
                if (!keyChars.contains(c)) {
                    decoded.append(c);
                }
            }

            String result = decoded.toString();
            if (!result.isEmpty()) {
                result = Character.toUpperCase(result.charAt(0)) + result.substring(1).toLowerCase();
            }

            decodedLabels[i] = result;
        }

        return decodedLabels;
    }
}
