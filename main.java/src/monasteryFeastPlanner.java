import java.util.*;

class MonasteryFeastPlanner {
    public static String monasteryFeastPlanner(String ingredients, int monkCount, int dayOfWeek) {
        Map<String, Integer> ingredientMap = parseIngredients(ingredients);
        int totalIngredients = ingredientMap.values().stream().mapToInt(Integer::intValue).sum();
        
        List<String> feastPlan = new ArrayList<>();
        boolean isFastingDay = (dayOfWeek == 1 || dayOfWeek == 3 || dayOfWeek == 5);
        
        for (Map.Entry<String, Integer> entry : ingredientMap.entrySet()) {
            String ingredient = entry.getKey();
            int quantity = entry.getValue();
            
            if (isFastingDay && isVegetable(ingredient)) {
                quantity = Math.min(quantity, monkCount);
            } else if (!isFastingDay) {
                quantity = Math.min(quantity, monkCount / 2 + 1);
            }
            
            if (quantity > 0) {
                feastPlan.add(ingredient + ":" + quantity);
                monkCount -= quantity;
            }
            
            if (monkCount <= 0) break;
        }
        
        // If we still need more food, add remaining ingredients
        if (monkCount > 0) {
            for (Map.Entry<String, Integer> entry : ingredientMap.entrySet()) {
                String ingredient = entry.getKey();
                int quantity = entry.getValue();
                if (!feastPlan.contains(ingredient + ":" + quantity) && quantity > 0) {
                    feastPlan.add(ingredient + ":" + quantity);
                    monkCount -= quantity;
                }
                if (monkCount <= 0) break;
            }
        }
        
        return String.join(",", feastPlan);
    }
    
    private static Map<String, Integer> parseIngredients(String ingredients) {
        Map<String, Integer> ingredientMap = new LinkedHashMap<>();
        String[] pairs = ingredients.split(",");
        for (String pair : pairs) {
            String name = pair.replaceAll("\\d", "");
            int quantity = Integer.parseInt(pair.replaceAll("\\D", ""));
            ingredientMap.put(name, quantity);
        }
        return ingredientMap;
    }
    
    private static boolean isVegetable(String ingredient) {
        return ingredient.equals("carrots") || ingredient.equals("onions") || ingredient.equals("potatoes");
    }
}