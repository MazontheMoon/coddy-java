class TrackPlantGrowth {
    public static String trackPlantGrowth(int initialHeight, int days, String plantName) {
        int currentHeight = initialHeight;
        
        for (int day = 1; day <= days; day++) {
            if (day % 3 == 0) {
                currentHeight *= 2;
            } else if (day % 2 == 1) {
                currentHeight++;
            } else {
                currentHeight--;
            }
        }
        
        String growthDescription;
        if (currentHeight > initialHeight) {
            growthDescription = "The plant grew taller.";
        } else if (currentHeight < initialHeight) {
            growthDescription = "The plant shrunk.";
        } else {
            growthDescription = "The plant remained the same height.";
        }
        
        return "Plant: " + plantName + ", Initial height: " + initialHeight + " cm, Final height: " + currentHeight + " cm, " + growthDescription;
    }
}
