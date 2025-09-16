/*
Create a function named prepareEquipment that receives equipment and newItem as its parameters.

A group of vulcanologists is preparing for their research expedition near an active volcano. They need to manage their equipment inventory efficiently. Your task is to implement a function that helps them organize their equipment list.

The function should perform the following operations:
- Check if the new item already exists in the equipment array.
- If the item doesn't exist, add it to the end of the array.
- If the item already exists, move it to the end of the array (removing it from its current position and adding it to the end).
- Return the updated equipment array.

Parameters:
- equipment (String[]): An array of strings representing the current list of equipment items.
- newItem (String): A string representing the new item to be added or moved in the equipment list.

The function returns a String[] representing the updated equipment list after the operations have been performed.

Constraints:
- The length of equipment will be between 0 and 100.
- Each element in equipment and newItem will be a non-empty string with a length of at most 20 characters.
- The strings in equipment are case-sensitive and should be treated as unique identifiers.
*/

import java.util.ArrayList;
import java.util.Arrays;

class PrepareEquipment {
    public static String[] prepareEquipment(String[] equipment, String newItem) {
        ArrayList<String> equipmentList = new ArrayList<>(Arrays.asList(equipment));

        // Check if the new item already exists
        int existingIndex = equipmentList.indexOf(newItem);

        if (existingIndex != -1) {
            // If the item exists, remove it from its current position
            equipmentList.remove(existingIndex);
        }

        // Add the new item to the end of the list
        equipmentList.add(newItem);

        // Convert ArrayList back to array and return
        return equipmentList.toArray(new String[0]);
    }
}