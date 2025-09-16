/*
Create a function named getItemsToPack that receives packingList and itemsPacked as parameters.

This function helps the Smith family ensure they have packed everything for their picnic by checking items off their packing list.

The function should return a new array containing items from packingList that are not in itemsPacked. These are the items that still need to be packed.

When comparing items, the function should be case-insensitive.

Parameters:
- packingList (String[]): The initial list of items to pack.
- itemsPacked (String[]): The items already packed.

The function returns a String[] containing items from packingList that are not in itemsPacked. If all items are packed, it returns an empty array.
*/

import java.util.ArrayList;
import java.util.List;

class GetItemsToPack {
    public static String[] getItemsToPack(String[] packingList, String[] itemsPacked) {
        List<String> itemsToPackList = new ArrayList<>();

        for (String item : packingList) {
            boolean isPacked = false;
            for (String packedItem : itemsPacked) {
                if (item.equalsIgnoreCase(packedItem)) {
                    isPacked = true;
                    break;
                }
            }
            if (!isPacked) {
                itemsToPackList.add(item);
            }
        }

        String[] itemsToPack = new String[itemsToPackList.size()];
        itemsToPack = itemsToPackList.toArray(itemsToPack);

        return itemsToPack;
    }
}
