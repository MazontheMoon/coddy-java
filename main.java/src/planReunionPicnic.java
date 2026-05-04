import java.util.Arrays;

class PlanReunionPicnic {
    public static String planReunionPicnic(String[] familyNames, String[] foodItems, String[] activities) {
        // Create guest list string
        String guestList = "Guest List: " + Arrays.toString(familyNames);
        
        // Combine food items and activities into one array
        String[] combinedItems = new String[foodItems.length + activities.length];
        System.arraycopy(foodItems, 0, combinedItems, 0, foodItems.length);
        System.arraycopy(activities, 0, combinedItems, foodItems.length, activities.length);
        
        // Create items string
        String items = "Items: " + Arrays.toString(combinedItems);
        
        // Return formatted planning summary
        return guestList + "\n" + items;
    }
}
