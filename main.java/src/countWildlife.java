import java.util.Arrays;

class CountWildlife {
    public static int[] countWildlife(String[] observations, int daysToAnalyze) {
        int[] counts = new int[4]; // [bees, hummingbirds, moths, wasps]
        
        // Determine the number of days to analyze
        int daysToProcess = Math.min(daysToAnalyze, observations.length);
        
        // Process the most recent days
        for (int i = observations.length - daysToProcess; i < observations.length; i++) {
            String day = observations[i];
            for (char wildlife : day.toCharArray()) {
                switch (wildlife) {
                    case 'B':
                        counts[0]++;
                        break;
                    case 'H':
                        counts[1]++;
                        break;
                    case 'M':
                        counts[2]++;
                        break;
                    case 'W':
                        counts[3]++;
                        break;
                }
            }
        }
        
        return counts;
    }
}
