/*
Write a function organizeEquipment that takes equipment and returns a 2D string array organizing sports equipment by sport and condition.

The function parses equipment entries, groups items by sport, filters out damaged items, and sorts remaining items by condition priority within each sport.

Logic:
-Parse each equipment string to extract sport, item, and condition
-Group items by sport, excluding any with "damaged" condition
-Sort items within each sport by condition priority: "excellent", "good", "fair", "poor"
-Return as 2D array where each row contains all items for one sport

Parameters:
- equipment (String[]): Array of equipment entries in format "sport-item-condition"

Returns: 2D string array where each row contains items for one sport, sorted by condition. 

Format: [["basketball-ball-excellent", "basketball-hoop-good"], ["soccer-ball-fair", "soccer-cleats-poor"]]
*/

import java.util.*;

class OrganizeEquipment {
    public static String[][] organizeEquipment(String[] equipment) {
        // Map to group equipment by sport
        Map<String, List<String>> sportGroups = new HashMap<>();
        
        // Condition priority mapping
        Map<String, Integer> conditionPriority = new HashMap<>();
        conditionPriority.put("excellent", 0);
        conditionPriority.put("good", 1);
        conditionPriority.put("fair", 2);
        conditionPriority.put("poor", 3);
        
        // Parse equipment and group by sport
        for (String item : equipment) {
            String[] parts = item.split("-");
            if (parts.length >= 3) {
                String sport = parts[0];
                String condition = parts[parts.length - 1];
                
                // Skip damaged items
                if (!condition.equals("damaged")) {
                    sportGroups.computeIfAbsent(sport, k -> new ArrayList<>()).add(item);
                }
            }
        }
        
        // Sort items within each sport by condition priority
        for (List<String> items : sportGroups.values()) {
            items.sort((a, b) -> {
                String conditionA = a.substring(a.lastIndexOf("-") + 1);
                String conditionB = b.substring(b.lastIndexOf("-") + 1);
                return Integer.compare(
                    conditionPriority.getOrDefault(conditionA, 999),
                    conditionPriority.getOrDefault(conditionB, 999)
                );
            });
        }
        
        // Convert to 2D array
        String[][] result = new String[sportGroups.size()][];
        int index = 0;
        
        // Sort sports alphabetically for consistent output
        List<String> sortedSports = new ArrayList<>(sportGroups.keySet());
        sortedSports.sort(String::compareTo);
        
        for (String sport : sortedSports) {
            List<String> items = sportGroups.get(sport);
            result[index] = items.toArray(new String[0]);
            index++;
        }
        
        return result;
    }
}
