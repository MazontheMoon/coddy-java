import java.util.*;

class GetAllUniqueCrops {
    public static String[] getAllUniqueCrops(String[][] gardenPlots) {
        Set<String> uniqueCrops = new HashSet<>();
        
        // Flatten all crop arrays and add to set to remove duplicates
        for (String[] plot : gardenPlots) {
            for (String crop : plot) {
                uniqueCrops.add(crop);
            }
        }
        
        // Convert to array and sort alphabetically
        String[] result = uniqueCrops.toArray(new String[0]);
        Arrays.sort(result);
        
        return result;
    }
}
