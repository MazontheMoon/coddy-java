import java.util.ArrayList;
import java.util.Collections;

class CreateFranchiseMenu {
    public static String[] createFranchiseMenu(String[] basePizzas, String[] gourmetToppings) {
        ArrayList<String> menu = new ArrayList<>();
        
        // Create all combinations using nested loops
        for (String basePizza : basePizzas) {
            for (String topping : gourmetToppings) {
                menu.add(basePizza + " + " + topping);
            }
        }
        
        // Reverse the menu
        Collections.reverse(menu);
        
        // Convert to array and return
        return menu.toArray(new String[0]);
    }
}
