/*
Create a function named sortPicnicItems that receives items as its parameter.

This function aims to organize the items you are bringing to a picnic in a park near a boulder. To ensure everything fits nicely in your picnic basket, you want to sort the items alphabetically.

The function should take the unsorted array of picnic items, sort them in alphabetical order, and return the sorted array.

Parameter:
- items (String[]): An unsorted array of strings, where each string represents an item you are planning to bring to the picnic.

The function returns a String[] which is the alphabetically sorted version of the input array.
*/

import java.util.Arrays;

class SortPicnicItems {
    public static String[] sortPicnicItems(String[] items) {
        Arrays.sort(items);
        return items;
    }
}