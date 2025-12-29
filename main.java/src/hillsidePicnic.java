/*Create a function named hillsidePicnic that receives items, quantities, flowers, and maxItems as its parameters.

Imagine you're planning a picnic on a peaceful, grassy hillside. Your task is to arrange the perfect picnic setup using the given items, their quantities, and the flowers found on the hillside.

The function should perform the following operations:

Combine the items and their quantities into a single array called combinedArray, where each element is a string in the format "item:quantity".
Search through the combinedArray to find items with a quantity greater than 1 and add them to a new array called sharedItems.
Create a flower arrangement by concatenating all the flowers in the input array, separated by commas.
Generate a picnic arrangement by combining the sharedItems array with the flower arrangement, ensuring that the total number of elements doesn't exceed maxItems.
If the number of elements in the picnic arrangement is less than maxItems, fill the remaining spots with "grass" elements.
Parameters:

items (String[]): An array of strings representing various picnic items (e.g., "blanket", "basket", "sandwiches", "fruits").
quantities (int[]): An array of integers representing the quantity of each item. This array has the same length as items.
flowers (String[]): An array of strings representing different types of flowers found on the hillside.
maxItems (int): An integer representing the maximum number of items allowed in a picnic arrangement.
The function returns a String array representing the final picnic arrangement.

Note: Ensure your implementation handles edge cases such as empty input arrays or when maxItems is less than or equal to zero.*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class HillsidePicnic {
    public static String[] hillsidePicnic(String[] items, int[] quantities, String[] flowers, int maxItems) {
        if (items == null || quantities == null || flowers == null || maxItems <= 0 ||
            items.length != quantities.length) {
            return new String[0];
        }

        // Step 1: Combine items and quantities
        String[] combinedArray = new String[items.length];
        for (int i = 0; i < items.length; i++) {
            combinedArray[i] = items[i] + ":" + quantities[i];
        }

        // Step 2: Find shared items
        List<String> sharedItems = new ArrayList<>();
        for (int i = 0; i < quantities.length; i++) {
            if (quantities[i] > 1) {
                sharedItems.add(combinedArray[i]);
            }
        }

        // Step 3: Create flower arrangement
        String flowerArrangement = String.join(",", flowers);

        // Step 4 & 5: Generate picnic arrangement
        List<String> picnicArrangement = new ArrayList<>(sharedItems);
        picnicArrangement.add(flowerArrangement);

        // Fill remaining spots with "grass"
        while (picnicArrangement.size() < maxItems) {
            picnicArrangement.add("grass");
        }

        // Trim if exceeds maxItems
        if (picnicArrangement.size() > maxItems) {
            picnicArrangement = picnicArrangement.subList(0, maxItems);
        }

        return picnicArrangement.toArray(new String[0]);
    }
}
