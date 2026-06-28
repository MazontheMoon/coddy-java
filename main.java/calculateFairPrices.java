class CalculateFairPrices {
    public static int[] calculateFairPrices(int[] basePrices, int[] haggleAttempts, boolean[] sellerTolerance, float[] saleProbabilities) {
        int[] fairPrices = new int[basePrices.length];
        
        for (int i = 0; i < basePrices.length; i++) {
            int basePrice = basePrices[i];
            int attempts = haggleAttempts[i];
            boolean tolerant = sellerTolerance[i];
            float saleProb = saleProbabilities[i];
            
            // Calculate discount percentage: min(haggleAttempts * 5, 25)
            int discountPercentage = Math.min(attempts * 5, 25);
            
            // Apply discount only if seller is tolerant AND sale probability >= 0.7
            if (tolerant && saleProb >= 0.7) {
                double discountedPrice = basePrice * (1.0 - discountPercentage / 100.0);
                fairPrices[i] = (int) Math.round(discountedPrice);
            } else {
                // Use base price if seller is intolerant OR sale probability < 0.7
                fairPrices[i] = basePrice;
            }
        }
        
        return fairPrices;
    }
}
