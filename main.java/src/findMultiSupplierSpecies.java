import java.util.*;

class FindMultiSupplierSpecies {
    public static String[] findMultiSupplierSpecies(String[][] supplierInventories, String pattern) {
        // Map to track species and which suppliers have them
        Map<String, Set<Integer>> speciesSuppliers = new HashMap<>();
        
        // Go through each supplier's inventory
        for (int i = 0; i < supplierInventories.length; i++) {
            for (String species : supplierInventories[i]) {
                // Check if species contains the pattern
                if (species.contains(pattern)) {
                    // Add this supplier to the set of suppliers for this species
                    speciesSuppliers.computeIfAbsent(species, k -> new HashSet<>()).add(i);
                }
            }
        }
        
        // Find species that appear in at least 2 suppliers
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Set<Integer>> entry : speciesSuppliers.entrySet()) {
            if (entry.getValue().size() >= 2) {
                result.add(entry.getKey());
            }
        }
        
        // Sort alphabetically
        Collections.sort(result);
        
        // Convert to array
        return result.toArray(new String[0]);
    }
}
