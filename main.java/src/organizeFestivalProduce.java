/*Write a function organizeFestivalProduce that takes produceEntries and returns a formatted festival report string.

The function filters out produce with "heartrot" status, then distributes healthy items in round-robin fashion across three festival categories: Display, Cooking, and Take-Home.

Logic:

Parse each entry to extract name and status from "name:status" format
Filter out any items with "heartrot" status
Assign remaining items cyclically: 1st→Display, 2nd→Cooking, 3rd→Take-Home, 4th→Display, etc.
Format output with each category on separate lines, items comma-separated
Parameters:

produceEntries (String[]): Array of produce entries in "name:status" format
Returns: Formatted festival report string. Format: Display: item1, item2 Cooking: item3, item4 Take-Home: item5, item6*/

import java.util.ArrayList;
import java.util.List;

class OrganizeFestivalProduce {
    public static String organizeFestivalProduce(String[] produceEntries) {
        List<String> display = new ArrayList<>();
        List<String> cooking = new ArrayList<>();
        List<String> takeHome = new ArrayList<>();
        
        int categoryIndex = 0;
        
        for (String entry : produceEntries) {
            String[] parts = entry.split(":");
            String name = parts[0];
            String status = parts[1];
            
            if (!status.equals("heartrot")) {
                if (categoryIndex % 3 == 0) {
                    display.add(name);
                } else if (categoryIndex % 3 == 1) {
                    cooking.add(name);
                } else {
                    takeHome.add(name);
                }
                categoryIndex++;
            }
        }
        
        StringBuilder result = new StringBuilder();
        result.append("Display: ").append(String.join(", ", display)).append("\n");
        result.append("Cooking: ").append(String.join(", ", cooking)).append("\n");
        result.append("Take-Home: ").append(String.join(", ", takeHome));
        
        return result.toString();
    }
}
