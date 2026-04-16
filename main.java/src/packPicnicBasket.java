import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class PackPicnicBasket {
    public static String packPicnicBasket(String[] items, int[] quantities, int maxWeight) {
        List<String> packedItems = new ArrayList<>();
        int totalWeight = 0;

        for (int i = 0; i < items.length; i++) {
            int itemWeight = quantities[i];
            if (totalWeight + itemWeight <= maxWeight) {
                packedItems.add(items[i] + ": " + quantities[i]);
                totalWeight += itemWeight;
            }
        }

        if (packedItems.isEmpty()) {
            return "Basket is too heavy!";
        }

        Collections.sort(packedItems);

        return String.join("\n", packedItems);
    }
}
