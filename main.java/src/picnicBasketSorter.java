/*
Create a function named picnicBasketSorter that receives picnicItems, start, and end as its parameters.

This function sorts the items alphabetically and selects a specific range of items for a smaller basket.

The function should:
- Sort the picnicItems array alphabetically.
- Create a new array for the selected range of items.
- Copy items from the sorted picnicItems array, from index start (inclusive) to end (exclusive), into the new array.

Return the new array containing the sorted and sliced subset of picnic items.

Parameters:
- picnicItems (String[]): An array of item names.
- start (int): The starting index for slicing (inclusive).
- end (int): The ending index for slicing (exclusive).

Returns a String[] containing the sorted and sliced subset of picnic items.
*/

import java.util.Arrays;

class PicnicBasketSorter {
    public static String[] picnicBasketSorter(String[] picnicItems, int start, int end) {
        // Sort the picnicItems array in alphabetical order
        Arrays.sort(picnicItems);

        // Create a new array to store the selected range of items
        String[] selectedItems = new String[end - start];

        // Copy the items from the sorted picnicItems array into the new array
        for (int i = start; i < end; i++) {
            selectedItems[i - start] = picnicItems[i];
        }

        // Return the new array containing the sorted and sliced subset of picnic items
        return selectedItems;
    }
}
