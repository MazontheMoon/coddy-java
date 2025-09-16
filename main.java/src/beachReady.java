/*
Create a function named beachReady that receives currentItems and requiredItems as its parameters.

This function checks if you have all the necessary items packed for a day at the beach.

To solve this challenge:
- Iterate through each item in the requiredItems array.
- Check if each required item exists in the currentItems array.
- If any required item is not found, return false.
- If all required items are found, return true.

Parameters:
- currentItems (String[]): Items you currently have packed.
- requiredItems (String[]): Items required for a beach day.
- The function returns a boolean value:
   - true if all required items are present.
   - false if any required item is missing.
*/

class BeachReady {
    public static boolean beachReady(String[] currentItems, String[] requiredItems) {
        for (String requiredItem : requiredItems) {
            boolean found = false;
            for (String currentItem : currentItems) {
                if (currentItem.equals(requiredItem)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }
        return true;
    }
}