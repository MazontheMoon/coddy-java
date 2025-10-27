/*
Create a function named findInsect that receives insects and targetInsect as its parameters.

The function simulates a botanist's observation of unusual insects on a garden hedge. It should count how many times the target insect appears in the array and record its position(s) in the hedge (array index).

Your task is to implement this function that combines basic string comparison and array manipulation to help the botanist in their research.

Parameters:
- insects (String[]): An array of strings representing different insect species found on the hedge.
- targetInsect (String): A string representing the specific insect the botanist is looking for.

The function should return a string in the format: "Found X time(s) at position(s): Y", where X is the number of occurrences and Y is a comma-separated list of positions (array indices).

If the target insect is not found, the function should return "Not found".

Example:

String[] insects = {"butterfly", "ladybug", "ant", "ladybug", "beetle"};
String targetInsect = "ladybug";
String result = findInsect(insects, targetInsect);
// result should be: "Found 2 time(s) at position(s): 1, 3"
*/

import java.util.ArrayList;
import java.util.List;

class FindInsect {
    public static String findInsect(String[] insects, String targetInsect) {
        List<Integer> positions = new ArrayList<>();
        int count = 0;

        for (int i = 0; i < insects.length; i++) {
            if (insects[i].equals(targetInsect)) {
                count++;
                positions.add(i);
            }
        }

        if (count == 0) {
            return "Not found";
        } else {
            StringBuilder result = new StringBuilder();
            result.append("Found ").append(count).append(" time(s) at position(s): ");
            for (int i = 0; i < positions.size(); i++) {
                result.append(positions.get(i));
                if (i < positions.size() - 1) {
                    result.append(", ");
                }
            }
            return result.toString();
        }
    }
}