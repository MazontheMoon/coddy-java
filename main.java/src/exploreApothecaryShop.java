/*
Create a function named exploreApothecaryShop that receives String[] shelves, int curiosityLevel, and String searchItem as its parameters.

The function simulates a curious visitor exploring an old-fashioned apothecary shop. It should return a formatted string describing the visitor's exploration, including the number of items examined, whether the specific item was found, and a list of interesting items discovered.

Follow these steps to implement the function:
- Iterate through the shelves array, examining items based on the curiosityLevel (e.g., curiosity level 5 means examining half the items).
- Use the break statement to stop the exploration if the searchItem is found.
- Use the continue statement to skip items that are deemed uninteresting (items shorter than 5 characters).
- Create a list of interesting items (items containing the letter 'e' or 'a').
- Format the exploration report using advanced string formatting techniques.

Parameters:
- shelves (String[]): An array representing the shelves in the shop, where each element is a potion or ingredient name.
- curiosityLevel (int): An integer representing the visitor's curiosity level (1-10).
- searchItem (String): A string representing a specific item the visitor is looking for.

The function returns a formatted string that describes the visitor's exploration of the shop.
 */

import java.util.ArrayList;
import java.util.List;

class ExploreApothecaryShop {
    public static String exploreApothecaryShop(String[] shelves, int curiosityLevel, String searchItem) {
        int itemsExamined = 0;
        boolean itemFound = false;
        List<String> interestingItems = new ArrayList<>();
        int itemsToExamine = Math.round((float) shelves.length * curiosityLevel / 10);

        for (String item : shelves) {
            if (itemsExamined >= itemsToExamine) {
                break;
            }

            if (item.length() < 5) {
                continue;
            }

            itemsExamined++;

            if (item.equals(searchItem)) {
                itemFound = true;
                break;
            }

            if (item.toLowerCase().contains("e") || item.toLowerCase().contains("a")) {
                interestingItems.add(item);
            }
        }

        StringBuilder report = new StringBuilder();
        report.append(String.format("Exploration Report:\n"));
        report.append(String.format("Items examined: %d\n", itemsExamined));
        report.append(String.format("'%s' %s\n", searchItem, itemFound ? "was found!" : "was not found."));
        report.append(String.format("Interesting items discovered: %d\n", interestingItems.size()));

        for (int i = 0; i < interestingItems.size(); i++) {
            report.append(String.format("  %d. %s\n", i + 1, interestingItems.get(i)));
        }

        return report.toString().trim();
    }
}