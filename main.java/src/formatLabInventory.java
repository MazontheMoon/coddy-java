class FormatLabInventory {
    public static String formatLabInventory(String[] equipment) {
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < equipment.length; i++) {
            int reverseIndex = equipment.length - 1 - i;
            result.append("Item ").append(i + 1).append(": ").append(equipment[reverseIndex]);
            
            if (i < equipment.length - 1) {
                result.append("\n");
            }
        }
        
        return result.toString();
    }
}
