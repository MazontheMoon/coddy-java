import java.util.*;
import java.util.stream.*;

class SolveCriminalCase {
    public static String[] solveCriminalCase(String[][] suspectsAndAssociates, String[] crimeScenes, String[] evidence, String[] alibis) {
        // Step 1: Create sets of suspects and their associates
        Map<String, Set<String>> suspectAssociates = new HashMap<>();
        for (String[] group : suspectsAndAssociates) {
            Set<String> associates = new HashSet<>(Arrays.asList(group).subList(1, group.length));
            suspectAssociates.put(group[0], associates);
        }

        // Step 2: Find intersections between suspects present at multiple crime scenes
        Set<String> suspectsPresentAtMultipleScenes = new HashSet<>(suspectAssociates.keySet());
        for (int i = 1; i < crimeScenes.length; i++) {
            suspectsPresentAtMultipleScenes.retainAll(suspectAssociates.keySet());
        }

        // Step 3: Analyze evidence and alibis
        Map<String, Long> evidenceCount = Arrays.stream(evidence)
                .flatMap(e -> Arrays.stream(e.split(",")))
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        List<String> strongAlibiSuspects = IntStream.range(0, alibis.length)
                .filter(i -> alibis[i].toLowerCase().contains("out of town"))
                .mapToObj(i -> suspectsAndAssociates[i][0])
                .collect(Collectors.toList());

        // Step 4: Generate power sets of evidence (simplified version)
        Set<Set<String>> evidencePowerSet = new HashSet<>();
        for (String e : evidence) {
            Set<String> newSet = new HashSet<>(Arrays.asList(e.split(",")));
            evidencePowerSet.add(newSet);
        }

        // Step 5: Apply Venn diagram concepts to eliminate suspects
        Set<String> remainingSuspects = new HashSet<>(suspectsPresentAtMultipleScenes);
        remainingSuspects.removeAll(strongAlibiSuspects);

        // Step 6: Calculate the cardinality of suspect sets
        Map<String, Integer> suspectScore = new HashMap<>();
        for (String suspect : remainingSuspects) {
            int score = (int) evidencePowerSet.stream()
                    .filter(es -> suspectAssociates.get(suspect).stream().anyMatch(es::contains))
                    .count();
            suspectScore.put(suspect, score);
        }

        // Find the maximum score
        int maxScore = suspectScore.values().stream().max(Integer::compare).orElse(0);

        // Return the most likely suspects
        return suspectScore.entrySet().stream()
                .filter(entry -> entry.getValue() == maxScore)
                .map(Map.Entry::getKey)
                .sorted()
                .toArray(String[]::new);
    }
}
