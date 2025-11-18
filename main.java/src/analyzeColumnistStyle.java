/*
Create a function named analyzeColumnistStyle that receives articles and wittyWords as its parameters.

As a witty columnist, you've decided to analyze your writing style using advanced statistical methods. Your task is to create a function that performs complex operations on your articles and returns insightful statistics about your writing style.

The function should perform the following operations:
- Calculate the average word length for each article, considering fractions for hyphenated words (e.g., "well-known" counts as 1.5 words).
- Determine the percentage of words that are puns or wordplays (based on the given list of witty words).
- Find the most frequently used word in each article (excluding common words like "the", "a", "an", etc.).
- Calculate a "wittiness score" for each article based on the following formula:
	- witScore = (avgWordLength * 0.4) + (punPercentage * 0.4) + (uniqueWordPercentage * 0.2)
	- Where uniqueWordPercentage is the percentage of unique words in the article.

Parameters:
- articles (String[][]): A 2D array of strings, where each inner array represents an article. Each string in the inner array is a word from the article.
- wittyWords (String[]): An array of strings containing known puns and wordplays.

The function returns a 2D float array where each inner array contains the following statistics for the corresponding article:
- Average word length
- Percentage of witty words
- Wittiness score

Note:
- Words are case-insensitive. "The" and "the" should be treated as the same word.
- Punctuation should be ignored when calculating word statistics.
- Use efficient array operations like map, filter, and reduce where applicable.
- Round all float values to two decimal places.
*/

import java.util.*;
import java.util.stream.*;

class AnalyzeColumnistStyle {
    public static float[][] analyzeColumnistStyle(String[][] articles, String[] wittyWords) {
        Set<String> wittyWordsSet = Arrays.stream(wittyWords)
                .map(String::toLowerCase)
                .collect(Collectors.toSet());

        float[][] result = new float[articles.length][3];

        for (int i = 0; i < articles.length; i++) {
            String[] article = articles[i];
            List<String> words = Arrays.stream(article)
                    .map(word -> word.replaceAll("[^a-zA-Z-]", "").toLowerCase())
                    .filter(word -> !word.isEmpty())
                    .collect(Collectors.toList());

            float avgWordLength = calculateAvgWordLength(words);
            float wittyPercentage = calculateWittyPercentage(words, wittyWordsSet);
            float uniqueWordPercentage = calculateUniqueWordPercentage(words);

            float witScore = (avgWordLength * 0.4f) + (wittyPercentage * 0.4f) + (uniqueWordPercentage * 0.2f);

            result[i][0] = roundToTwoDecimals(avgWordLength);
            result[i][1] = roundToTwoDecimals(wittyPercentage);
            result[i][2] = roundToTwoDecimals(witScore);
        }

        return result;
    }

    private static float calculateAvgWordLength(List<String> words) {
        float totalLength = 0;
        for (String word : words) {
            if (word.contains("-")) {
                String[] parts = word.split("-");
                totalLength += parts.length + 0.5f * (parts.length - 1);
            } else {
                totalLength += word.length();
            }
        }
        return totalLength / words.size();
    }

    private static float calculateWittyPercentage(List<String> words, Set<String> wittyWords) {
        long wittyCount = words.stream().filter(wittyWords::contains).count();
        return (float) wittyCount / words.size() * 100;
    }

    private static float calculateUniqueWordPercentage(List<String> words) {
        Set<String> uniqueWords = new HashSet<>(words);
        return (float) uniqueWords.size() / words.size() * 100;
    }

    private static float roundToTwoDecimals(float value) {
        return Math.round(value * 100) / 100.0f;
    }
}
