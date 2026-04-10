import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SimulateAldrovanadaGrowth {
    public static String[][] simulateAldrovanadaGrowth(int days, int[] initialPopulation, float[] growthRates, int initialAldrovanda, float trapSuccessRate) {
        String[][] result = new String[days][];
        int[] population = Arrays.copyOf(initialPopulation, initialPopulation.length);
        int aldrovanda = initialAldrovanda;

        for (int day = 0; day < days; day++) {
            List<String> dayReport = new ArrayList<>();
            int bellNumber = calculateBellNumber(day + 1);
            int derangement = calculateDerangement(day + 1);
            int catalanNumber = calculateCatalanNumber(day + 1);

            dayReport.add(String.format("Day %d: Aldrovanda population: %d", day + 1, aldrovanda));
            dayReport.add(String.format("Microenvironments: %d", bellNumber));
            dayReport.add(String.format("Plant rearrangements: %d", derangement));
            dayReport.add(String.format("Branching patterns: %d", catalanNumber));

            int totalPopulation = Arrays.stream(population).sum() + aldrovanda;
            int successfulTraps = (int) (aldrovanda * trapSuccessRate * (totalPopulation - aldrovanda) / totalPopulation);
            dayReport.add(String.format("Successful traps: %d", successfulTraps));

            int pollinationProbability = calculateCombination(aldrovanda, 2) / totalPopulation;
            dayReport.add(String.format("Pollination probability: %d%%", pollinationProbability));

            int trapArrangements = calculatePermutation(aldrovanda, Math.min(aldrovanda, 5));
            dayReport.add(String.format("Trap closure arrangements: %d", trapArrangements));

            for (int i = 0; i < population.length; i++) {
                population[i] += Math.round(population[i] * growthRates[i]);
            }
            aldrovanda += Math.round(aldrovanda * 0.05f) + successfulTraps / 10;

            result[day] = dayReport.toArray(new String[0]);
        }

        return result;
    }

    private static int calculateBellNumber(int n) {
        int[] bell = new int[n + 1];
        bell[0] = bell[1] = 1;
        for (int i = 2; i <= n; i++) {
            bell[i] = 0;
            for (int j = 0; j < i; j++) {
                bell[i] += calculateCombination(i - 1, j) * bell[j];
            }
        }
        return bell[n];
    }

    private static int calculateDerangement(int n) {
        if (n <= 1) return 0;
        if (n == 2) return 1;
        return (n - 1) * (calculateDerangement(n - 1) + calculateDerangement(n - 2));
    }

    private static int calculateCatalanNumber(int n) {
        return calculateCombination(2 * n, n) / (n + 1);
    }

    private static int calculateCombination(int n, int k) {
        if (k > n - k) k = n - k;
        int result = 1;
        for (int i = 0; i < k; i++) {
            result *= (n - i);
            result /= (i + 1);
        }
        return result;
    }

    private static int calculatePermutation(int n, int r) {
        int result = 1;
        for (int i = 0; i < r; i++) {
            result *= (n - i);
        }
        return result;
    }
}
