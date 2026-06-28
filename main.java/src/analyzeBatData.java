import java.util.Arrays;
import java.text.DecimalFormat;

class AnalyzeBatData {
    public static String analyzeBatData(String[] species, int[][] coordinates, String healthData) {
        // Reverse species names
        String[] reversedSpecies = new String[species.length];
        for (int i = 0; i < species.length; i++) {
            reversedSpecies[i] = new StringBuilder(species[i]).reverse().toString();
        }

        // Calculate average distance
        double totalDistance = 0;
        int pairCount = 0;
        for (int i = 0; i < coordinates.length; i++) {
            for (int j = i + 1; j < coordinates.length; j++) {
                totalDistance += calculateDistance(coordinates[i], coordinates[j]);
                pairCount++;
            }
        }
        double averageDistance = pairCount > 0 ? totalDistance / pairCount : 0;

        // Analyze health data
        int healthy = 0, sick = 0, vaccinated = 0;
        for (char c : healthData.toCharArray()) {
            if (c == 'H') healthy++;
            else if (c == 'S') sick++;
            else if (c == 'V') vaccinated++;
        }
        int total = healthData.length();

        // Format the output
        DecimalFormat df = new DecimalFormat("#.##");
        String reversedSpeciesStr = Arrays.toString(reversedSpecies);
        String healthPercentages = String.format("H:%.2f%%, S:%.2f%%, V:%.2f%%",
                (double) healthy / total * 100,
                (double) sick / total * 100,
                (double) vaccinated / total * 100);

        return String.format("Reversed species: %s, Average distance: %s, Health percentages: %s",
                reversedSpeciesStr, df.format(averageDistance), healthPercentages);
    }

    private static double calculateDistance(int[] point1, int[] point2) {
        return Math.sqrt(Math.pow(point2[0] - point1[0], 2) + Math.pow(point2[1] - point1[1], 2));
    }
}

