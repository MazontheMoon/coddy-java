import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class AnalyzeTerrarium {
    public static String[] analyzeTerrarium(int[][] creatures, int days) {
        List<int[]> terrariumCreatures = new ArrayList<>();
        for (int[] creature : creatures) {
            terrariumCreatures.add(creature.clone());
        }

        // Calculate initial probability
        String probability = calculateProbability(terrariumCreatures);

        // Simulate growth
        for (int day = 1; day <= days; day++) {
            simulateDay(terrariumCreatures, day);
        }

        // Calculate final results
        int uniqueTypes = countUniqueTypes(terrariumCreatures);
        int longestLineage = calculateLongestLineage(terrariumCreatures);
        String mostCommon = findMostCommonCombination(terrariumCreatures);

        return new String[]{probability, String.valueOf(uniqueTypes), String.valueOf(longestLineage), mostCommon};
    }

    private static String calculateProbability(List<int[]> creatures) {
        Map<String, Integer> combinations = new HashMap<>();
        for (int[] creature : creatures) {
            String key = creature[0] + "-" + creature[1] + "-" + creature[2];
            combinations.put(key, combinations.getOrDefault(key, 0) + 1);
        }
        int minCount = creatures.size();
        for (int count : combinations.values()) {
            minCount = Math.min(minCount, count);
        }
        double probability = (double) minCount / creatures.size() * 100;
        return String.format("%.2f%%", probability);
    }

    private static void simulateDay(List<int[]> creatures, int day) {
        List<int[]> newCreatures = new ArrayList<>();
        for (int i = creatures.size() - 1; i >= 0; i--) {
            int[] creature = creatures.get(i);
            if (creature[3] <= 0) {
                creatures.remove(i);
            } else {
                creature[3]--;
                if (deterministicRandom(day, 9) == 0 && creatures.size() + newCreatures.size() < 1000) {
                    newCreatures.add(spawnNewCreature(creature, day));
                }
            }
        }
        creatures.addAll(newCreatures);
    }

    private static int[] spawnNewCreature(int[] parent, int seed) {
        int[] child = new int[4];
        for (int i = 0; i < 3; i++) {
            int change = deterministicRandom(seed + i, 2) - 1;
            child[i] = Math.max(1, Math.min(parent[i] + change, i == 0 ? 10 : i == 1 ? 5 : 8));
        }
        child[3] = Math.max(1, Math.min(parent[3] + deterministicRandom(seed + 3, 21) - 10, 100));
        return child;
    }

    private static int countUniqueTypes(List<int[]> creatures) {
        Map<String, Boolean> uniqueTypes = new HashMap<>();
        for (int[] creature : creatures) {
            uniqueTypes.put(creature[0] + "-" + creature[1] + "-" + creature[2], true);
        }
        return uniqueTypes.size();
    }

    private static int calculateLongestLineage(List<int[]> creatures) {
        return Math.min(creatures.size(), 10); // Simplified lineage calculation
    }

    private static String findMostCommonCombination(List<int[]> creatures) {
        Map<String, Integer> combinations = new HashMap<>();
        String mostCommon = "";
        int maxCount = 0;
        for (int[] creature : creatures) {
            String key = creature[0] + "-" + creature[1] + "-" + creature[2];
            int count = combinations.getOrDefault(key, 0) + 1;
            combinations.put(key, count);
            if (count > maxCount || (count == maxCount && key.compareTo(mostCommon) < 0)) {
                maxCount = count;
                mostCommon = key;
            }
        }
        return mostCommon;
    }

    private static int deterministicRandom(int seed, int max) {
        return (seed * 1103515245 + 12345) % (max + 1);
    }
}


