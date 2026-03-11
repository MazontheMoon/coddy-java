import java.util.*;

class NatureWorkbookCollaboration {
    public static String natureWorkbookCollaboration(String[] studentNames, String[] observations, int[] observationTimes, boolean[] usedSpecialEquipment) {
        // Count observation types using a hash map
        Map<String, Integer> observationCounts = new HashMap<>();
        for (String observation : observations) {
            observationCounts.put(observation, observationCounts.getOrDefault(observation, 0) + 1);
        }

        // Find the most common observation
        String mostCommonObservation = Collections.max(observationCounts.entrySet(), Map.Entry.comparingByValue()).getKey();

        // Find the student with the most unique observations
        Map<String, Set<String>> studentUniqueObservations = new HashMap<>();
        for (int i = 0; i < studentNames.length; i++) {
            studentUniqueObservations.computeIfAbsent(studentNames[i], k -> new HashSet<>()).add(observations[i]);
        }
        String studentMostUnique = Collections.max(studentUniqueObservations.entrySet(), (a, b) -> Integer.compare(a.getValue().size(), b.getValue().size())).getKey();

        // Calculate collaboration score
        double collaborationScore = calculateCollaborationScore(studentNames, observations, observationTimes, usedSpecialEquipment);

        // Generate summary
        return String.format("Most common observation: %s\nStudent with most unique observations: %s\nCollaboration score: %.2f", 
                             mostCommonObservation, studentMostUnique, collaborationScore);
    }

    private static double calculateCollaborationScore(String[] studentNames, String[] observations, int[] observationTimes, boolean[] usedSpecialEquipment) {
        double baseScore = 0;
        Set<String> uniqueObservations = new HashSet<>();

        for (int i = 0; i < studentNames.length; i++) {
            // Individual contribution
            baseScore += observationTimes[i] * (usedSpecialEquipment[i] ? 1.5 : 1.0);

            // Unique contribution
            if (uniqueObservations.add(observations[i])) {
                baseScore += 10;
            }
        }

        // Group synergy: reward for diversity of observations
        double synergyFactor = (double) uniqueObservations.size() / observations.length;
        return baseScore * (1 + synergyFactor);
    }
}
