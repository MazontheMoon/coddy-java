import java.util.*;

class MothPopulationSimulation {
    public static String[] mothPopulationSimulation(int initialPopulation, int[] lightIntensities, int simulationDays, float growthRate, float migrationProbability) {
        int areas = lightIntensities.length;
        Map<Integer, Integer> population = new HashMap<>();
        Random random = new Random();

        // Initially distribute moths evenly
        int mothsPerArea = initialPopulation / areas;
        for (int i = 0; i < areas; i++) {
            population.put(i, mothsPerArea);
        }

        // Simulation loop
        for (int day = 0; day < simulationDays; day++) {
            Map<Integer, Integer> newPopulation = new HashMap<>(population);

            // Growth and migration
            for (int area = 0; area < areas; area++) {
                int moths = population.get(area);
                // Growth
                moths += Math.round(moths * growthRate);

                // Migration
                for (int i = 0; i < moths; i++) {
                    if (random.nextFloat() < migrationProbability) {
                        int targetArea = calculateTargetArea(area, population, lightIntensities);
                        newPopulation.put(area, newPopulation.get(area) - 1);
                        newPopulation.put(targetArea, newPopulation.get(targetArea) + 1);
                    }
                }
            }

            population = newPopulation;
        }

        // Prepare result
        String[] result = new String[areas];
        for (int i = 0; i < areas; i++) {
            result[i] = "Area " + i + ": " + population.get(i) + " moths";
        }

        return result;
    }

    private static int calculateTargetArea(int currentArea, Map<Integer, Integer> population, int[] lightIntensities) {
        int areas = lightIntensities.length;
        double[] scores = new double[areas];

        int totalPopulation = population.values().stream().mapToInt(Integer::intValue).sum();
        double avgPopulation = (double) totalPopulation / areas;

        for (int i = 0; i < areas; i++) {
            if (i == currentArea) continue;

            // Light intensity factor (prefer medium intensities)
            double lightFactor = 1 - Math.abs(5 - lightIntensities[i]) / 5.0;

            // Population density factor (avoid overcrowded areas)
            double densityFactor = 1 - (population.get(i) / avgPopulation);

            // Distance factor (prefer nearby areas)
            double distanceFactor = 1.0 / (1 + Math.abs(i - currentArea));

            scores[i] = lightFactor * densityFactor * distanceFactor;
        }

        // Select target area based on scores
        double totalScore = Arrays.stream(scores).sum();
        double randomValue = Math.random() * totalScore;
        double cumulativeScore = 0;

        for (int i = 0; i < areas; i++) {
            cumulativeScore += scores[i];
            if (cumulativeScore > randomValue) {
                return i;
            }
        }

        return currentArea; // Fallback to current area
    }
}
