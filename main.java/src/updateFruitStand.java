class UpdateFruitStand {
    public static String[] updateFruitStand(String[][] inventory, String[] soldFruits) {
        // Create a copy of inventory to work with
        String[][] updatedInventory = new String[inventory.length][3];
        for (int i = 0; i < inventory.length; i++) {
            updatedInventory[i][0] = inventory[i][0]; // fruit name
            updatedInventory[i][1] = inventory[i][1]; // stock
            updatedInventory[i][2] = inventory[i][2]; // price
        }
        
        double totalRevenue = 0.0;
        
        // Process each sold fruit
        for (String soldFruit : soldFruits) {
            // Find the fruit in inventory and update stock
            for (int i = 0; i < updatedInventory.length; i++) {
                if (updatedInventory[i][0].equals(soldFruit)) {
                    int currentStock = Integer.parseInt(updatedInventory[i][1]);
                    double price = Double.parseDouble(updatedInventory[i][2]);
                    
                    if (currentStock > 0) {
                        // Reduce stock by 1
                        updatedInventory[i][1] = String.valueOf(currentStock - 1);
                        // Add to total revenue
                        totalRevenue += price;
                    }
                    break;
                }
            }
        }
        
        // Create result array
        String[] result = new String[inventory.length + 1];
        
        // Add updated inventory to result
        for (int i = 0; i < updatedInventory.length; i++) {
            result[i] = updatedInventory[i][0] + "," + updatedInventory[i][1] + "," + updatedInventory[i][2];
        }
        
        // Add total revenue
        result[inventory.length] = "Total Revenue: " + String.format("%.2f", totalRevenue);
        
        return result;
    }
}
