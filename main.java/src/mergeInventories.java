/*
Write a function mergeInventories that takes inventories (String[][]) and maxItems (int) and returns a String array containing merged instrument inventories.

The function processes department inventories sequentially, skipping empty ones and stopping when encountering an inventory exceeding the maximum item limit.

Logic:

Iterate through each department inventory in order
Skip empty inventories (length 0) and continue processing
If an inventory has more than maxItems items, stop processing entirely (exclude it and all remaining inventories)
Concatenate all valid inventories into a single result array
Parameters:

inventories (String[][]): 2D array where each sub-array represents one department's instrument list
maxItems (int): Maximum number of items allowed per department inventory
Returns: String array containing all instruments from processed departments in order. Format: ["Piano", "Guitar", "Violin"]
*/

import java.util.ArrayList;
import java.util.List;

class MergeInventories {
    public static String[] mergeInventories(String[][] inventories, int maxItems) {
        List<String> result = new ArrayList<>();
        
        for (String[] inventory : inventories) {
            // Skip empty inventories
            if (inventory.length == 0) {
                continue;
            }
            
            // If inventory exceeds maxItems, stop processing entirely
            if (inventory.length > maxItems) {
                break;
            }
            
            // Add all items from this inventory to result
            for (String item : inventory) {
                result.add(item);
            }
        }
        
        return result.toArray(new String[0]);
    }
}
