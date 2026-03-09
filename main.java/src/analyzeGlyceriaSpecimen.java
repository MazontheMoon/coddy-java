import java.util.*;

class AnalyzeGlyceriaSpecimen {
    public static String analyzeGlyceriaSpecimen(String geneticSequence, int[] markerLengths) {
        long overallHash = calculateRollingHash(geneticSequence);
        StringBuilder report = new StringBuilder();
        String overallRarity = "";
        int maxRarityCount = 0;

        for (int length : markerLengths) {
            Set<Long> uniqueHashes = new HashSet<>();
            Map<String, Integer> substringFrequency = new HashMap<>();

            for (int i = 0; i <= geneticSequence.length() - length; i++) {
                String substring = geneticSequence.substring(i, i + length);
                long hash = calculateRollingHash(substring);
                uniqueHashes.add(hash);
                substringFrequency.put(substring, substringFrequency.getOrDefault(substring, 0) + 1);
            }

            int totalSubstrings = geneticSequence.length() - length + 1;
            int uniqueCount = uniqueHashes.size();
            double uniquePercentage = (double) uniqueCount / totalSubstrings * 100;

            String rarity;
            if (uniquePercentage < 10) rarity = "Common";
            else if (uniquePercentage < 30) rarity = "Rare";
            else if (uniquePercentage < 60) rarity = "Very Rare";
            else rarity = "Extremely Rare";

            if (uniqueCount > maxRarityCount) {
                maxRarityCount = uniqueCount;
                overallRarity = rarity;
            }

            String mostFrequentMarker = Collections.max(substringFrequency.entrySet(), Map.Entry.comparingByValue()).getKey();

            report.append(String.format("Length %d: %d unique markers (%s), Most frequent: %s\n", 
                          length, uniqueCount, rarity, mostFrequentMarker));
        }

        return String.format("Overall rarity: %s\n%s", overallRarity, report.toString());
    }

    private static long calculateRollingHash(String s) {
        long hash = 0;
        long p = 31;
        long m = 1_000_000_009;
        long pPow = 1;

        for (char c : s.toCharArray()) {
            hash = (hash + (c - 'A' + 1) * pPow) % m;
            pPow = (pPow * p) % m;
        }

        return hash;
    }
}
