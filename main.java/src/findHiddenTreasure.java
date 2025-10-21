/*
Create a function named findHiddenTreasure that receives String[] drawerContents and String itemToFind as its parameters.

Imagine a curious child exploring an old drawer filled with mysterious objects and faded photographs. The child is on a quest to find a specific item hidden among these objects. Your task is to help the child by implementing a function that searches for the hidden treasure.

The function should search through the array of drawer contents and check if any of the objects contain the sought-after item as a substring. The search should be case-insensitive.

Parameters:
- drawerContents (String[]): An array of strings, each representing an object in the drawer (e.g., ["old photograph", "rusty key", "faded letter"]).
- itemToFind (String): A string representing the item the child is looking for (e.g., "treasure map").

The function returns a String. If the item is found, it should return the full description of the object containing the item. If the item is not found, it should return the message "Item not found in the drawer."

Note: The search should be case-insensitive, meaning "MAP" should match "map" or "Map".
 */

import java.util.Arrays;

class FindHiddenTreasure {
    public static String findHiddenTreasure(String[] drawerContents, String itemToFind) {
        return Arrays.stream(drawerContents)
                .filter(item -> item.toLowerCase().contains(itemToFind.toLowerCase()))
                .findFirst()
                .orElse("Item not found in the drawer.");
    }
}