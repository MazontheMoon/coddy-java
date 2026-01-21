import java.util.*;

class OrganizeGarageSale {
    public static float[] organizeGarageSale(int[] conditions, float[] basePrices, String[] categories) {
        List<String> distinctCategories = new ArrayList<>();
        List<Float> categoryTotals = new ArrayList<>();
        
        // First pass: identify distinct categories in order of first appearance
        for (int i = 0; i < categories.length; i++) {
            if (conditions[i] < 3) {
                continue;
            }
            
            String category = categories[i];
            if (!distinctCategories.contains(category)) {
                distinctCategories.add(category);
                categoryTotals.add(0.0f);
            }
        }
        
        // Second pass: calculate totals for each category
        for (int i = 0; i < categories.length; i++) {
            if (conditions[i] < 3) {
                continue;
            }
            
            float price = basePrices[i];
            String category = categories[i];
            
            // Apply pricing rules
            if (category.equals("antique")) {
                price *= 1.2f; // +20% markup
            } else if (category.equals("shambles")) {
                price *= 0.9f; // -10% discount
            }
            
            // Find category index and add to total
            int categoryIndex = distinctCategories.indexOf(category);
            categoryTotals.set(categoryIndex, categoryTotals.get(categoryIndex) + price);
        }
        
        // Convert to array
        float[] result = new float[categoryTotals.size()];
        for (int i = 0; i < categoryTotals.size(); i++) {
            result[i] = categoryTotals.get(i);
        }
        
        return result;
    }
}
