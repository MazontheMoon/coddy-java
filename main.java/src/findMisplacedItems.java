/*
Create a function named findMisplacedItems that receives rooms, items, and probabilities as its parameters.

Our hapless homeowner, Bob, often misplaces his everyday items around his house, leading to comical confusion. Your task is to help Bob by implementing a function that simulates his search for misplaced items, incorporating elements of game theory and string comparison.

The function should simulate Bob's search through the rooms of his house, trying to find the misplaced items. Use the given probabilities to determine if an item is found in a room. If an item is found, it should be removed from the search list. The search continues until all items are found or all rooms have been searched.

Parameters:
- rooms (String[]): An array of room names in Bob's house.
- items (String[]): An array of items Bob is looking for.
- probabilities (int[][]): A 2D array where - probabilities[i][j] represents the probability (as a percentage) of finding item j in room i.

The function returns a String[] containing the results of the search. Each element in the returned array should be in one of these formats:
- For found items: "Found [item] in [room]"
- For items not found: "[item] not found"

To determine if an item is found, generate a random number between 1 and 100 for each item in each room. If this number is less than or equal to the corresponding probability, the item is considered found.

Note: Use java.util.Random for generating random numbers. Initialize the Random object with a seed value of 42 to ensure consistent results across different runs.

Ensure your implementation efficiently handles the arrays and incorporates game theory by considering the probabilities to optimize the search strategy.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

class FindMisplacedItems {
    public static String[] findMisplacedItems(String[] rooms, String[] items, int[][] probabilities) {
        Random random = new Random(42);
        List<String> results = new ArrayList<>();
        boolean[] foundItems = new boolean[items.length];

        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < items.length; j++) {
                if (!foundItems[j]) {
                    int randomNum = random.nextInt(100) + 1;
                    if (randomNum <= probabilities[i][j]) {
                        results.add("Found " + items[j] + " in " + rooms[i]);
                        foundItems[j] = true;
                    }
                }
            }
        }

        for (int j = 0; j < items.length; j++) {
            if (!foundItems[j]) {
                results.add(items[j] + " not found");
            }
        }

        return results.toArray(new String[0]);
    }
}