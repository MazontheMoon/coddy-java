

import java.util.*;

class AnalyzeMarineManuscript {
    public static String analyzeMarineManuscript(String[] paragraphs, int minKeywordFrequency, String[] keywords) {
        Map<String, Integer> keywordCount = new HashMap<>();
        int[] keywordsPerParagraph = new int[paragraphs.length];
        int totalKeywords = 0;
        int totalWords = 0;

        // Count keywords and words
        for (int i = 0; i < paragraphs.length; i++) {
            String[] words = paragraphs[i].toLowerCase().split("\\s+");
            totalWords += words.length;
            for (String word : words) {
                for (String keyword : keywords) {
                    if (word.equals(keyword.toLowerCase())) {
                        keywordCount.put(keyword, keywordCount.getOrDefault(keyword, 0) + 1);
                        keywordsPerParagraph[i]++;
                        totalKeywords++;
                        break;
                    }
                }
            }
        }

        // Find frequent keywords
        List<String> frequentKeywords = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : keywordCount.entrySet()) {
            if (entry.getValue() > minKeywordFrequency) {
                frequentKeywords.add(entry.getKey());
            }
        }

        // Find paragraphs with most keywords
        int maxKeywords = Arrays.stream(keywordsPerParagraph).max().orElse(0);
        List<Integer> paragraphsWithMostKeywords = new ArrayList<>();
        for (int i = 0; i < keywordsPerParagraph.length; i++) {
            if (keywordsPerParagraph[i] == maxKeywords) {
                paragraphsWithMostKeywords.add(i + 1);
            }
        }

        // Calculate peculiarity score
        double peculiarityScore = (double) (totalKeywords * keywordCount.size()) / totalWords;

        // Prepare the result string
        StringBuilder result = new StringBuilder();
        result.append("Total keywords: ").append(totalKeywords).append("\n");
        result.append("Frequent keywords: ").append(String.join(", ", frequentKeywords)).append("\n");
        result.append("Paragraphs with most keywords: ").append(paragraphsWithMostKeywords.stream()
                .map(String::valueOf)
                .collect(java.util.stream.Collectors.joining(", "))).append("\n");
        result.append("Peculiarity score: ").append(String.format("%.2f", peculiarityScore));

        return result.toString();
    }
}
