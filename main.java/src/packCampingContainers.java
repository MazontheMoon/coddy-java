/*
Create a function named packCampingContainers that receives items and maxItemsPerContainer as its parameters.

Your task is to pack items into sealable containers for a weekend camping trip with friends. You need to organize the items efficiently while following safety guidelines.

Pack the items into containers according to these rules:
- Each container can hold up to maxItemsPerContainer items.
- If an item is "matches" or "lighter", it should be packed separately in its own container for safety reasons.
- A container is considered "sealed" when it's full or contains a safety item (matches or lighter).
- Stop packing when all items are packed or when 5 containers have been filled, whichever comes first.

Parameters:
- items (String[]): An array of strings representing the items to be packed.
- maxItemsPerContainer (int): An integer representing the maximum number of items that can fit in each container.
- The function returns a String array where each string represents a sealed container and its contents. Each container string should start with "SEALED:" followed by the items in the container, separated by commas.

Use array manipulation to keep track of the items and containers. Implement break and continue statements to handle special cases like safety items and container limits.
*/
import java.util.ArrayList;
import java.util.Arrays;

class PackCampingContainers {
    public static String[] packCampingContainers(String[] items, int maxItemsPerContainer) {
        ArrayList<String> containers = new ArrayList<>();
        ArrayList<String> currentContainer = new ArrayList<>();

        for (String item : items) {
            if (containers.size() >= 5) {
                break;
            }

            if (item.equals("matches") || item.equals("lighter")) {
                if (!currentContainer.isEmpty()) {
                    containers.add("SEALED:" + String.join(",", currentContainer));
                    currentContainer.clear();
                }
                containers.add("SEALED:" + item);
                continue;
            }

            currentContainer.add(item);

            if (currentContainer.size() == maxItemsPerContainer) {
                containers.add("SEALED:" + String.join(",", currentContainer));
                currentContainer.clear();
            }
        }

        if (!currentContainer.isEmpty()) {
            containers.add("SEALED:" + String.join(",", currentContainer));
        }

        return containers.toArray(new String[0]);
    }
}