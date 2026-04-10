class GenerateMarketStatus {
    public static String generateMarketStatus(String weatherCondition, String inventoryLevel, String dayOfWeek) {
        StringBuilder status = new StringBuilder();
        
        // Determine market status
        String marketStatus;
        if (inventoryLevel.equals("empty")) {
            marketStatus = "CLOSED - Restocking in progress";
        } else {
            marketStatus = "OPEN";
        }
        
        status.append("MARKET STATUS: ").append(marketStatus).append("\n");
        
        // Weather section
        status.append("WEATHER: ").append(weatherCondition);
        if (weatherCondition.equals("rainy")) {
            status.append(" - RAIN PROTOCOL: Use covered stations only");
        }
        status.append("\n");
        
        // Inventory section
        status.append("INVENTORY: ").append(inventoryLevel);
        if (inventoryLevel.equals("low")) {
            status.append(" LIMITED STOCK");
        }
        status.append("\n");
        
        // Hours section
        status.append("HOURS: Standard 9 AM - 6 PM");
        if (dayOfWeek.equals("Saturday") || dayOfWeek.equals("Sunday")) {
            status.append(" Extended hours until 8 PM");
        }
        
        return status.toString();
    }
}
