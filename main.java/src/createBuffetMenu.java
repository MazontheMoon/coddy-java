import java.util.ArrayList;

class CreateBuffetMenu {
    public static String[] createBuffetMenu(String[] vegetarianDishes, String[] nonVegetarianDishes, boolean[] allowed) {
        // Merge the two dish arrays
        String[] mergedDishes = new String[vegetarianDishes.length + nonVegetarianDishes.length];
        
        // Copy vegetarian dishes first
        for (int i = 0; i < vegetarianDishes.length; i++) {
            mergedDishes[i] = vegetarianDishes[i];
        }
        
        // Copy non-vegetarian dishes
        for (int i = 0; i < nonVegetarianDishes.length; i++) {
            mergedDishes[vegetarianDishes.length + i] = nonVegetarianDishes[i];
        }
        
        // Filter dishes based on allowed array
        ArrayList<String> filteredMenu = new ArrayList<>();
        for (int i = 0; i < mergedDishes.length && i < allowed.length; i++) {
            if (allowed[i]) {
                filteredMenu.add(mergedDishes[i]);
            }
        }
        
        // Convert ArrayList to array
        return filteredMenu.toArray(new String[0]);
    }
}
