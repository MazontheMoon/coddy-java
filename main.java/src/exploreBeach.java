class ExploreBeach {
    public static int exploreBeach(String[] seaCreatures, int maxObservations) {
        int observationCount = 0;
        
        for (String creature : seaCreatures) {
            if (creature.equals("jellyfish")) {
                break;  // Stop exploring if a jellyfish is encountered
            }
            if (creature.equals("seaweed")) {
                continue;  // Skip seaweed and continue exploring
            }
            // Count other creatures as interesting
            observationCount++;
            
            if (observationCount >= maxObservations) {
                break;  // Stop if maximum observations reached
            }
        }
        
        return observationCount;
    }
}