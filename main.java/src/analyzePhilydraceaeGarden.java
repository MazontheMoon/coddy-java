import java.util.*;

class AnalyzePhilydraceaeGarden {
    public static String[] analyzePhilydraceaeGarden(String[] plants, int plotCount, int maxPlantsPerPlot) {
        String[] result = new String[6];

        // 1. Generate power set size
        result[0] = String.valueOf((1 << plants.length));

        // 2. Calculate distribution ways
        result[1] = String.valueOf(calculateDistributionWays(plants.length, plotCount, maxPlantsPerPlot));

        // 3. Count subsets with Philydraceae
        result[2] = String.valueOf(countPhilydraceaeSubsets(plants));

        // 4. Calculate derangement
        result[3] = calculateDerangement(plants);

        // 5. Calculate Bell number
        result[4] = String.valueOf(calculateBellNumber(plants.length));

        // 6. Calculate Catalan number
        result[5] = String.valueOf(calculateCatalanNumber(plants.length / 2));

        return result;
    }

    private static long calculateDistributionWays(int n, int k, int m) {
        if (n > k * m) return 0;
        long[][] dp = new long[n + 1][k + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                for (int x = 0; x <= Math.min(i, m); x++) {
                    dp[i][j] += dp[i - x][j - 1] * binomialCoefficient(i, x);
                }
            }
        }
        return dp[n][k];
    }

    private static long binomialCoefficient(int n, int k) {
        if (k > n - k) k = n - k;
        long result = 1;
        for (int i = 0; i < k; i++) {
            result *= (n - i);
            result /= (i + 1);
        }
        return result;
    }

    private static int countPhilydraceaeSubsets(String[] plants) {
        int philydraceaeCount = 0;
        for (String plant : plants) {
            if (plant.contains("Philydraceae")) philydraceaeCount++;
        }
        return (1 << plants.length) - (1 << (plants.length - philydraceaeCount));
    }

    private static String calculateDerangement(String[] plants) {
        List<String> derangement = new ArrayList<>(Arrays.asList(plants));
        for (int i = 0; i < derangement.size(); i++) {
            int j = (i + 1) % derangement.size();
            Collections.swap(derangement, i, j);
        }
        return derangement.toString();
    }

    private static long calculateBellNumber(int n) {
        long[][] bell = new long[n + 1][n + 1];
        bell[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            bell[i][0] = bell[i - 1][i - 1];
            for (int j = 1; j <= i; j++) {
                bell[i][j] = bell[i - 1][j - 1] + bell[i][j - 1];
            }
        }
        return bell[n][0];
    }

    private static long calculateCatalanNumber(int n) {
        long catalan = 1;
        for (int i = 0; i < n; i++) {
            catalan = catalan * 2 * (2 * i + 1) / (i + 2);
        }
        return catalan;
    }
}
