/*
Create a function named bazaarInventory that receives inventory and queries as its parameters.

This function manages a merchant's inventory in a medieval marketplace. Items have unique names, and some are categorized with a '#' symbol. The function processes search queries to retrieve items by exact names or categories.

Steps:
- Create a hash table for inventory items, using item names as keys and their indices as values. For categorized items (indicated by '#'), use the category as the key.
- Process each query in the queries array:
- If the query is a single word, retrieve matching items from the hash table.
- If the query starts with '#', retrieve items belonging to that category.
- Store retrieved items in a new array within the output 2D array. If no items match, add an empty array.
- Sort items within each inner array alphabetically.

Parameters:
- inventory (String[]): Array of item names in the merchant's inventory.
- queries (String[]): Array of search queries for specific items or categories.

The function returns a 2D array of strings (String[][]), where each inner array contains names of items matching the corresponding query, sorted alphabetically. If no items match, the inner array is empty.
 */

import java.util.*;

class BazaarInventory {
    public static String[][] bazaarInventory(String[] inventory, String[] queries) {
        Map<String, List<Integer>> hashTable = new HashMap<>();

        // Build the hash table
        for (int i = 0; i < inventory.length; i++) {
            String item = inventory[i];
            if (item.startsWith("#")) {
                String category = item;
                hashTable.putIfAbsent(category, new ArrayList<>());
                hashTable.get(category).add(i);
            } else {
                hashTable.putIfAbsent(item, new ArrayList<>());
                hashTable.get(item).add(i);
            }
        }

        String[][] output = new String[queries.length][];

        // Process the queries
        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            List<String> matchingItems = new ArrayList<>();

            if (query.startsWith("#")) {
                List<Integer> indices = hashTable.getOrDefault(query, new ArrayList<>());
                for (int index : indices) {
                    matchingItems.add(inventory[index]);
                }
            } else {
                List<Integer> indices = hashTable.getOrDefault(query, new ArrayList<>());
                for (int index : indices) {
                    matchingItems.add(inventory[index]);
                }
            }

            Collections.sort(matchingItems);
            output[i] = matchingItems.toArray(new String[0]);
        }

        return output;
    }
}
