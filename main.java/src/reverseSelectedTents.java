/*
Create a function named reverseSelectedTents that receives tentDesigns as its parameter.

Darci, a diligent tentmaker, is organizing her tent designs. She wants to reverse the order of certain tent types while keeping others in place. Your task is to help Darci by implementing this specific reorganization of her tent designs.

The function should process the input string as follows:
- Reverse the order of 'A' (large) and 'B' (medium) tents.
- Keep 'C' (small) tents in their original positions.
- Skip 'X' (faulty designs) completely.

To achieve this, you need to:
- Iterate through each character in the input string.
- Use continue to skip 'X' tents.
- Collect 'A' and 'B' tents in a separate list or string.
- Reverse the collected 'A' and 'B' tents.
- Reconstruct the final string by placing 'C' tents in their original positions and inserting the reversed 'A' and 'B' tents in the appropriate spots.

Parameter:
-tentDesigns (String): A string where each character represents a tent design. 'A' for large tents, 'B' for medium tents, 'C' for small tents, and 'X' for faulty designs.

The function returns a String representing the reorganized tent designs.

Remember to use basic control flow statements like continue for skipping 'X' tents, and implement a basic string reversal for 'A' and 'B' tents.
 */

import java.util.ArrayList;

class ReverseSelectedTents {
    public static String reverseSelectedTents(String tentDesigns) {
        StringBuilder result = new StringBuilder();
        ArrayList<Character> abTents = new ArrayList<>();

        // Collect 'A' and 'B' tents, skip 'X' tents
        for (char tent : tentDesigns.toCharArray()) {
            if (tent == 'X') {
                continue;
            }
            if (tent == 'A' || tent == 'B') {
                abTents.add(tent);
            }
        }

        // Reverse the collected 'A' and 'B' tents
        int abIndex = abTents.size() - 1;

        // Reconstruct the final string
        for (char tent : tentDesigns.toCharArray()) {
            if (tent == 'X') {
                continue;
            }
            if (tent == 'C') {
                result.append('C');
            } else {
                result.append(abTents.get(abIndex));
                abIndex--;
            }
        }

        return result.toString();
    }
}