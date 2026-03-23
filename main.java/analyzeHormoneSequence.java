
import java.util.*;

class AnalyzeHormoneSequence {
    public static String[] analyzeHormoneSequence(String[] hormoneSequences, int minLength) {
        Map<String, Integer> substringCount = new HashMap<>();
        
        for (String sequence : hormoneSequences) {
            if (sequence.length() < minLength) continue;
            
            for (int i = 0; i < sequence.length(); i++) {
                for (int j = i + 3; j <= sequence.length(); j++) {
                    String substring = sequence.substring(i, j);
                    substringCount.put(substring, substringCount.getOrDefault(substring, 0) + 1);
                }
            }
        }
        
        int maxCount = 0;
        List<String> mostFrequent = new ArrayList<>();
        
        for (Map.Entry<String, Integer> entry : substringCount.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostFrequent.clear();
                mostFrequent.add(entry.getKey());
            } else if (entry.getValue() == maxCount) {
                mostFrequent.add(entry.getKey());
            }
        }
        
        Collections.sort(mostFrequent);
        
        String frequentSubstrings = String.join(",", mostFrequent);
        char predictedHormone = mostFrequent.get(0).charAt(mostFrequent.get(0).length() - 1);
        
        return new String[]{frequentSubstrings, String.valueOf(predictedHormone)};
    }
}

