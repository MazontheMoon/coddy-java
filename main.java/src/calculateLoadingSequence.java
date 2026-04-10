import java.util.*;

class CalculateLoadingSequence {
    public static String calculateLoadingSequence(String[] boxes, int maxWeight) {
        // Map to store total weight per section
        Map<Integer, Integer> sectionWeights = new HashMap<>();
        
        // Process each box
        for (String box : boxes) {
            String[] parts = box.split(":");
            String room = parts[0];
            int weight = Integer.parseInt(parts[1]);
            
            // Calculate hash for room (sum of ASCII values % 4)
            int hash = 0;
            for (char c : room.toCharArray()) {
                hash += (int) c;
            }
            int section = hash % 4;
            
            // Add weight to the section
            sectionWeights.put(section, sectionWeights.getOrDefault(section, 0) + weight);
        }
        
        // Filter sections that don't exceed maxWeight and sort by weight descending
        List<Map.Entry<Integer, Integer>> validSections = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : sectionWeights.entrySet()) {
            if (entry.getValue() <= maxWeight) {
                validSections.add(entry);
            }
        }
        
        // Sort by weight in descending order (heaviest first)
        validSections.sort((a, b) -> b.getValue().compareTo(a.getValue()));
        
        // Build result string
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < validSections.size(); i++) {
            if (i > 0) {
                result.append(",");
            }
            result.append(validSections.get(i).getKey());
        }
        
        return result.toString();
    }
}
