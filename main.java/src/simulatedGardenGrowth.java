class SimulateGardenGrowth {
    public static int simulateGardenGrowth(int numDays, int initialPlants, float[] growthProbabilities, float[] decayProbabilities) {
        int currentPlants = initialPlants;
        
        for (int day = 0; day < numDays; day++) {
            int newPlants = (int) (currentPlants * growthProbabilities[day]);
            int decayedPlants = (int) (currentPlants * decayProbabilities[day]);
            
            currentPlants += newPlants - decayedPlants;
        }
        
        return currentPlants;
    }
}
