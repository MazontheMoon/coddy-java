/*
Create a function named organizeFlowerCollection that receives newFlowers, existingCollection, and rareFlower as its parameters.

Ezra, a passionate botanist, has just returned from a field expedition where he collected new flower specimens. He wants to organize his collection by combining the new flowers with his existing collection, while following specific rules.

Your task is to help Ezra organize his flower collection according to these rules:
- Combine the new flowers with the existing collection.
- Remove any duplicate flowers.
- Stop adding new flowers once the rare flower is encountered in the new flowers array.

Parameters:
- newFlowers (String[]): An array of strings representing the names of new flowers Ezra collected during the expedition.
- existingCollection (String[]): An array of strings representing the names of flowers in Ezra's existing collection.
- rareFlower (String): A string representing the name of the rare flower Ezra is particularly interested in.

The function should return a String[] containing the updated collection of flower names, with duplicates removed and new flowers added only up to (and including) the rare flower.

Note: If the rare flower is not found in the new flowers array, all new flowers should be added to the collection.
 */

import java.util.*;

class OrganizeFlowerCollection {
    public static String[] organizeFlowerCollection(String[] newFlowers, String[] existingCollection, String rareFlower) {
        Set<String> uniqueFlowers = new LinkedHashSet<>(Arrays.asList(existingCollection));

        for (String flower : newFlowers) {
            uniqueFlowers.add(flower);
            if (flower.equals(rareFlower)) {
                break;
            }
        }

        return uniqueFlowers.toArray(new String[0]);
    }
}