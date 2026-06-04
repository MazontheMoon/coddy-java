import java.util.*;

class OrganizeByColorPairs {
    public static String[] organizeByColorPairs(String[] plantLabels) {
        Map<String, Integer> colorPairCounts = new HashMap<>();
        
        for (String label : plantLabels) {
            String[] parts = label.split("\\|");
            String color1 = parts[0];
            String color2 = parts[1];
            
            // Create normalized color pair (alphabetically sorted)
            String colorPair;
            if (color1.compareTo(color2) <= 0) {
                colorPair = color1 + " & " + color2;
            } else {
                colorPair = color2 + " & " + color1;
            }
            
            colorPairCounts.put(colorPair, colorPairCounts.getOrDefault(colorPair, 0) + 1);
        }
        
        // Format results
        List<String> results = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : colorPairCounts.entrySet()) {
            String formatted = entry.getKey() + ": " + entry.getValue() + " plants";
            results.add(formatted);
        }
        
        // Sort alphabetically
        Collections.sort(results);
        
        return results.toArray(new String[0]);
    }
}
