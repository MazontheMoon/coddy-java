import java.util.*;

class AnalyzeConsistentSales {
    public static int[] analyzeConsistentSales(int[][] salesData, int minThreshold, int criticalMinimum) {
        if (salesData == null || salesData.length == 0 || salesData[0].length == 0) {
            return new int[0];
        }
        
        int numCoffeeTypes = salesData[0].length;
        boolean[] isConsistent = new boolean[numCoffeeTypes];
        Arrays.fill(isConsistent, true);
        
        for (int day = 0; day < salesData.length; day++) {
            // Calculate total sales for this day
            int totalSales = 0;
            for (int coffee = 0; coffee < numCoffeeTypes; coffee++) {
                totalSales += salesData[day][coffee];
            }
            
            // If total sales < criticalMinimum, stop analysis immediately
            if (totalSales < criticalMinimum) {
                break;
            }
            
            // Skip days with zero total sales
            if (totalSales == 0) {
                continue;
            }
            
            // Check each coffee type against minThreshold
            for (int coffee = 0; coffee < numCoffeeTypes; coffee++) {
                if (salesData[day][coffee] < minThreshold) {
                    isConsistent[coffee] = false;
                }
            }
        }
        
        // Collect indices of consistent coffee types
        List<Integer> consistentIndices = new ArrayList<>();
        for (int i = 0; i < numCoffeeTypes; i++) {
            if (isConsistent[i]) {
                consistentIndices.add(i);
            }
        }
        
        // Convert to array
        int[] result = new int[consistentIndices.size()];
        for (int i = 0; i < consistentIndices.size(); i++) {
            result[i] = consistentIndices.get(i);
        }
        
        return result;
    }
}