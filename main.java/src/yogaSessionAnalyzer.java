/*
Create a function named yogaSessionAnalyzer that receives yogaMovesDescriptions and complexityLevels as its parameters.

The function should analyze a yoga session focusing on core strength and flexibility, performed in a park setting. It will compare yoga moves, calculate a difficulty score, and create a session narrative.

Your task is to implement the following operations:
- Calculate similarity scores between each pair of yoga move descriptions using advanced string comparison techniques. 
- Consider factors such as common words, sequence similarity, or other relevant metrics.
- Compute an overall session difficulty score using bit manipulation on the complexity levels.
- Create a narrative that concatenates all move descriptions into a smooth session flow, emphasizing core strength and flexibility.

Parameters:
- yogaMovesDescriptions (String[]): An array containing descriptions of different yoga moves, each focusing on core strength and flexibility.
- complexityLevels (int[]): An array of integers representing the complexity level of each corresponding yoga move description. -Each integer is between 1 and 10, inclusive.

The function returns a String containing three sections:
- Similarity scores for each pair of move descriptions.
- An overall session difficulty score based on bit manipulation of complexity levels.
- A narrative concatenating all move descriptions into a smooth session flow.

Important implementation details:
For string comparison, you may use techniques like Levenshtein distance, Jaccard similarity, or custom algorithms that consider word overlap and sequence.
For bit manipulation, use bitwise operations (AND, OR, XOR, shift) on the complexity levels to derive a single difficulty score.
For the narrative, create a flowing description that logically connects the moves, highlighting transitions and focus on core strength and flexibility.
Ensure your implementation is efficient and stays within the 20-49 lines of code range.
*/

import java.util.Arrays;

class YogaSessionAnalyzer {
    public static String yogaSessionAnalyzer(String[] yogaMovesDescriptions, int[] complexityLevels) {
        StringBuilder result = new StringBuilder();
        
        // Calculate similarity scores
        result.append("Similarity Scores:\n");
        for (int i = 0; i < yogaMovesDescriptions.length; i++) {
            for (int j = i + 1; j < yogaMovesDescriptions.length; j++) {
                double similarity = calculateSimilarity(yogaMovesDescriptions[i], yogaMovesDescriptions[j]);
                result.append(String.format("%.2f between '%s' and '%s'\n", similarity, yogaMovesDescriptions[i], yogaMovesDescriptions[j]));
            }
        }
        
        // Calculate session difficulty score
        int difficultyScore = calculateDifficultyScore(complexityLevels);
        result.append("\nSession Difficulty Score: ").append(difficultyScore).append("\n");
        
        // Create session narrative
        result.append("\nSession Narrative:\n");
        result.append("Begin your core-strengthening and flexibility-enhancing yoga session in the serene park setting. ");
        for (String move : yogaMovesDescriptions) {
            result.append(move).append(". Transition smoothly to the next pose, focusing on your breath. ");
        }
        result.append("Complete your session feeling refreshed and energized.");
        
        return result.toString();
    }
    
    private static double calculateSimilarity(String s1, String s2) {
        int maxLength = Math.max(s1.length(), s2.length());
        return (maxLength - levenshteinDistance(s1, s2)) / (double) maxLength;
    }
    
    private static int levenshteinDistance(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) dp[i][0] = i;
        for (int j = 0; j <= s2.length(); j++) dp[0][j] = j;
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                dp[i][j] = Math.min(dp[i - 1][j - 1] + (s1.charAt(i - 1) == s2.charAt(j - 1) ? 0 : 1),
                                    Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
            }
        }
        return dp[s1.length()][s2.length()];
    }
    
    private static int calculateDifficultyScore(int[] complexityLevels) {
        int score = 0;
        for (int level : complexityLevels) {
            score |= (1 << level);
        }
        return Integer.bitCount(score);
    }
}
