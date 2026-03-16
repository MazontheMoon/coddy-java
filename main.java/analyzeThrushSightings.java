import java.util.Arrays;

class AnalyzeThrushSightings {
    public static String analyzeThrushSightings(int days, int[][] dailySightings, String[] speciesNames) {
        int[] totalSightings = new int[speciesNames.length];
        int totalThrushes = 0;
        String binarySightings = "";

        for (int i = 0; i < days; i++) {
            for (int j = 0; j < speciesNames.length; j++) {
                totalSightings[j] += dailySightings[i][j];
                totalThrushes += dailySightings[i][j];
                binarySightings += Integer.toBinaryString(dailySightings[i][j]) + " ";
            }
        }

        int maxSightings = 0;
        String mostFrequentSpecies = "";
        for (int i = 0; i < speciesNames.length; i++) {
            if (totalSightings[i] > maxSightings) {
                maxSightings = totalSightings[i];
                mostFrequentSpecies = speciesNames[i];
            }
        }

        double averageThrushes = (double) totalThrushes / days;
        String formattedAverage = String.format("%.2f", averageThrushes);

        StringBuilder rarityScores = new StringBuilder();
        for (int i = 0; i < speciesNames.length; i++) {
            double rarityScore = (1 - ((double) totalSightings[i] / totalThrushes)) * 100;
            rarityScores.append(speciesNames[i]).append(": ").append(String.format("%.2f", rarityScore)).append("%\n");
        }

        return String.format("Total thrushes spotted: %d (Binary: %s)\n" +
                        "Most frequently spotted species: %s\n" +
                        "Average thrushes spotted per day: %s\n" +
                        "Rarity Scores:\n%s",
                totalThrushes, binarySightings.trim(), mostFrequentSpecies, formattedAverage, rarityScores.toString());
    }
}

