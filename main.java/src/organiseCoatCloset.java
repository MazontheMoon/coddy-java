class OrganizeCoatCloset {
    public static String[] organizeCoatCloset(String[] items) {
        // Count each type of item
        int heavyCoatCount = 0;
        int lightCoatCount = 0;
        int bootsCount = 0;
        
        // Count items using nested loops approach
        for (int i = 0; i < items.length; i++) {
            String item = items[i];
            if (item.equals("heavy coat")) {
                heavyCoatCount++;
            } else if (item.equals("light coat")) {
                lightCoatCount++;
            } else if (item.equals("boots")) {
                bootsCount++;
            }
        }
        
        // Create result array
        String[] result = new String[items.length];
        int index = 0;
        
        // Add heavy coats first
        for (int i = 0; i < heavyCoatCount; i++) {
            result[index] = "heavy coat";
            index++;
        }
        
        // Add light coats second
        for (int i = 0; i < lightCoatCount; i++) {
            result[index] = "light coat";
            index++;
        }
        
        // Add boots last
        for (int i = 0; i < bootsCount; i++) {
            result[index] = "boots";
            index++;
        }
        
        return result;
    }
}