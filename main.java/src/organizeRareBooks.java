import java.util.*;

class OrganizeRareBooks {
    public static String[] organizeRareBooks(int[] pages, float[] ages, String[] titles) {
        int n = pages.length;
        double[] rarityScores = new double[n];
        double[][] probabilities = new double[n][3];
        String[] sections = {"Arithmetic", "Geometric", "Harmonic"};
        String[] result = new String[n];

        // Calculate rarity scores
        for (int i = 0; i < n; i++) {
            rarityScores[i] = (Math.sin(pages[i]) * Math.cos(ages[i]) * Math.log(pages[i] + ages[i])) / Math.pow(Math.E, (pages[i] / 1000.0));
        }

        // Calculate initial probabilities
        for (int i = 0; i < n; i++) {
            double sum = Math.abs(rarityScores[i]) + Math.pow(rarityScores[i], 2) + 1 / (Math.abs(rarityScores[i]) + 1);
            probabilities[i][0] = Math.abs(rarityScores[i]) / sum;
            probabilities[i][1] = Math.pow(rarityScores[i], 2) / sum;
            probabilities[i][2] = (1 / (Math.abs(rarityScores[i]) + 1)) / sum;
        }

        // Apply Bayes' theorem and arrange books
        int[] sectionCounts = new int[3];
        for (int i = 0; i < n; i++) {
            int bestSection = 0;
            double maxProbability = 0;
            for (int j = 0; j < 3; j++) {
                if (sectionCounts[j] < 0.4 * n && probabilities[i][j] > maxProbability) {
                    maxProbability = probabilities[i][j];
                    bestSection = j;
                }
            }
            sectionCounts[bestSection]++;
            result[i] = titles[i] + " - " + sections[bestSection];
        }

        return result;
    }
}
