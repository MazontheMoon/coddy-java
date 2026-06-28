class ProcessLunchRush {
    public static int[][] processLunchRush(int[] ingredients, int[] chefShifts, int[][] orders, int displayCount) {
        // Process each order
        for (int[] order : orders) {
            int chefId = order[0];
            
            // Subtract ingredient amounts from available quantities
            for (int i = 1; i < order.length; i++) {
                ingredients[i - 1] -= order[i];
            }
            
            // Increment chef shift counter
            chefShifts[chefId]++;
        }
        
        // Return the last displayCount orders
        int startIndex = Math.max(0, orders.length - displayCount);
        int resultLength = Math.min(displayCount, orders.length);
        
        int[][] result = new int[resultLength][];
        for (int i = 0; i < resultLength; i++) {
            result[i] = orders[startIndex + i];
        }
        
        return result;
    }
}
