import java.util.*;

class AnalyzePipridaeSightings {
    public static int[][] analyzePipridaeSightings(int[][] sightings, int minDuration) {
        Map<Integer, List<int[]>> birdMap = new HashMap<>();

        // Filter and group sightings
        for (int[] sighting : sightings) {
            if (sighting[2] >= minDuration) {
                birdMap.putIfAbsent(sighting[0], new ArrayList<>());
                birdMap.get(sighting[0]).add(sighting);
            }
        }

        // Calculate averages and totals
        List<int[]> results = new ArrayList<>();
        for (Map.Entry<Integer, List<int[]>> entry : birdMap.entrySet()) {
            int birdId = entry.getKey();
            List<int[]> birdSightings = entry.getValue();
            int totalHeight = 0;
            int totalDuration = 0;

            for (int[] sighting : birdSightings) {
                totalHeight += sighting[1];
                totalDuration += sighting[2];
            }

            int avgHeight = Math.round((float) totalHeight / birdSightings.size());
            results.add(new int[]{birdId, avgHeight, totalDuration});
        }

        // Sort results
        results.sort((a, b) -> Integer.compare(b[2], a[2]));

        // Return top 3 or fewer
        int resultSize = Math.min(3, results.size());
        int[][] topResults = new int[resultSize][];
        for (int i = 0; i < resultSize; i++) {
            topResults[i] = results.get(i);
        }

        return topResults;
    }
}
