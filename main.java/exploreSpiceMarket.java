import java.util.ArrayList;
import java.util.Collections;

class ExploreSpiceMarket {
    public static String[] exploreSpiceMarket(String[] spices, boolean isAdventurous) {
        ArrayList<String> collection = new ArrayList<>();
        
        for (String spice : spices) {
            if (spice.length() > 4) {
                collection.add(spice);
            }
        }
        
        if (!isAdventurous) {
            Collections.reverse(collection);
        }
        
        return collection.toArray(new String[0]);
    }
}
