/*
Write a function rearrangeDisplay that takes items and recipe1, recipe2 and returns a formatted string with the reversed items and recipe comparison.

You're organizing your bakery display case by reversing the order of items (moving back items to front) and checking if two recipe names match exactly.

Parameters:
- items (String[]): Array of bakery item names to reverse
- recipe1 (String): First recipe name to compare
- recipe2 (String): Second recipe name to compare

Returns: String with reversed items and comparison result. Format: Items: [item1, item2, item3] Recipes match: true
*/

class RearrangeDisplay {
    public static String rearrangeDisplay(String[] items, String recipe1, String recipe2) {
        // Reverse the items array
        String[] reversedItems = new String[items.length];
        for (int i = 0; i < items.length; i++) {
            reversedItems[i] = items[items.length - 1 - i];
        }

        // Build the items string
        StringBuilder itemsStr = new StringBuilder("Items: [");
        for (int i = 0; i < reversedItems.length; i++) {
            itemsStr.append(reversedItems[i]);
            if (i < reversedItems.length - 1) {
                itemsStr.append(", ");
            }
        }
        itemsStr.append("]");

        // Check if recipes match
        boolean recipesMatch = recipe1.equals(recipe2);

        // Return formatted string
        return itemsStr.toString() + "\nRecipes match: " + recipesMatch;
    }
}