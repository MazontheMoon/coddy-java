/*
Create a function named reversePathSections that receives path as its parameter.

You are on a rocky path leading to an old-fashioned horse stable. The path is represented by a string of characters, where 'R' represents rocks, 'D' represents dirt, and 'G' represents grass. Your task is to reverse the order of characters between each pair of rocks ('R') while keeping the rocks in their original positions.

For example:
- If the input is "RDDDRRGGRRDDDR", the output should be "RDDDRRGGRRDDDR" (unchanged, as there are no characters between the first and second 'R').
- If the input is "RGDDRRDDGR", the output should be "RDDGRRDDGR" (the 'GDD' between the first and second 'R' is reversed to 'DDG').

Parameters:
- path (String): A string representing the path, consisting of 'R', 'D', and 'G' characters.
The function returns a String representing the modified path with sections between rocks reversed.

Constraints:
- The input string will contain only 'R', 'D', and 'G' characters.
- The input string will always start and end with 'R'.
- The input string will have a length between 3 and 100 characters.
*/

import java.util.ArrayList;

class ReversePathSections {
    public static String reversePathSections(String path) {
        ArrayList<Integer> rockIndices = new ArrayList<>();
        StringBuilder result = new StringBuilder(path);

        // Find all rock positions
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == 'R') {
                rockIndices.add(i);
            }
        }

        // Reverse sections between rocks
        for (int i = 0; i < rockIndices.size() - 1; i++) {
            int start = rockIndices.get(i) + 1;
            int end = rockIndices.get(i + 1) - 1;
            reverse(result, start, end);
        }

        return result.toString();
    }

    private static void reverse(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
    }
}