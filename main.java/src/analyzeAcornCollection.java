/*
Create a function named analyzeAcornCollection that receives acornString as its parameter.

In this challenge, you'll help a curious squirrel analyze its acorn collection in an autumn forest. The squirrel wants to know more about the types of acorns it has gathered.

Your task is to implement a function that processes a string representing the squirrel's acorn collection and returns a summary of the collection.

Parameters:
- acornString (String): A string containing letters representing different types of acorns. 'R' for red acorns, 'B' for brown acorns, 'W' for white acorns, and 'G' for rare golden acorns. For example: "RRBWRBBBWRG"

The function should perform the following tasks:
- Count the total number of acorns (which is the length of the input string).
- Count the occurrences of each type of acorn.
- Determine the most common type of acorn.
- Check if any golden acorns (G) are present.

The function returns a string describing the squirrel's acorn collection in the following format:
"Total acorns: [total], Most common: [color] ([count]), Golden acorns found: [Yes/No]"

Where:
- [total] is the total number of acorns
- [color] is the color of the most common acorn type (Red, Brown, or White)
- [count] is the count of the most common acorn type
- [Yes/No] indicates whether golden acorns were found or not
- If there's a tie for the most common acorn type, use the color that comes first alphabetically.
*/

import java.util.HashMap;

class AnalyzeAcornCollection {
    public static String analyzeAcornCollection(String acornString) {
        int total = acornString.length();
        HashMap<Character, Integer> counts = new HashMap<>();
        counts.put('R', 0);
        counts.put('B', 0);
        counts.put('W', 0);
        counts.put('G', 0);

        for (char acorn : acornString.toCharArray()) {
            counts.put(acorn, counts.get(acorn) + 1);
        }

        char mostCommon = 'B';
        int maxCount = counts.get('B');

        if (counts.get('R') > maxCount || (counts.get('R') == maxCount && 'R' < mostCommon)) {
            mostCommon = 'R';
            maxCount = counts.get('R');
        }
        if (counts.get('W') > maxCount || (counts.get('W') == maxCount && 'W' < mostCommon)) {
            mostCommon = 'W';
            maxCount = counts.get('W');
        }

        String color = mostCommon == 'R' ? "Red" : (mostCommon == 'B' ? "Brown" : "White");
        String goldenFound = counts.get('G') > 0 ? "Yes" : "No";

        return String.format("Total acorns: %d, Most common: %s (%d), Golden acorns found: %s",
                total, color, maxCount, goldenFound);
    }
}