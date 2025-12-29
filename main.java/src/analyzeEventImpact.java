/*Create a function named analyzeEventImpact that receives speakers, ratings, and keywords as its parameters.

Your task is to analyze the impact of presentations delivered at a community aggregator event. You'll process audience feedback and evaluate each presentation's effectiveness using advanced array operations and set theory concepts.

Parameters:

speakers (String[][]): A 2D array where each inner array contains two elements: the speaker's name and their presentation topic. For example: [["John", "AI"], ["Sarah", "Blockchain"]]
ratings (int[][]): A 2D array where each inner array represents the audience ratings for a presentation. The order corresponds to the speakers array. For example: [[8, 7, 9], [6, 8, 7]]
keywords (String[]): An array of unique keywords mentioned across all presentations.
The function should return a String[] containing analysis results for each speaker, including:

The speaker's name and topic
The average rating of their presentation
The impact score (calculated using set theory)
A classification of the presentation ("Semifabulous", "Impressive", or "Average")
To solve this challenge, you need to:

Use advanced array operations like map, filter, and reduce to process the input data.
Implement set theory concepts to calculate the impact score:
Create sets of keywords for each presentation (you can assume that each word in the topic is a keyword)
Calculate the intersection and union of these sets with the overall keyword set
Use set operations to determine the uniqueness and relevance of each presentation
Develop a classification system based on the average rating and impact score
Format the output string for each speaker with the required information
Use the following guidelines for classification:

"Semifabulous": Average rating >= 8.0 and Impact score >= 0.7
"Impressive": Average rating >= 7.0 and Impact score >= 0.5
"Average": All other cases
The impact score should be calculated as follows: (size of intersection between presentation keywords and overall keywords) / (size of union between presentation keywords and overall keywords)

Ensure your solution uses functional programming paradigms for arrays and set operations. You may use Java's built-in Set interface and its implementations for set operations.

*/

Create a function named analyzeEventImpact that receives speakers, ratings, and keywords as its parameters.

Your task is to analyze the impact of presentations delivered at a community aggregator event. You'll process audience feedback and evaluate each presentation's effectiveness using advanced array operations and set theory concepts.

Parameters:

speakers (String[][]): A 2D array where each inner array contains two elements: the speaker's name and their presentation topic. For example: [["John", "AI"], ["Sarah", "Blockchain"]]
ratings (int[][]): A 2D array where each inner array represents the audience ratings for a presentation. The order corresponds to the speakers array. For example: [[8, 7, 9], [6, 8, 7]]
keywords (String[]): An array of unique keywords mentioned across all presentations.
The function should return a String[] containing analysis results for each speaker, including:

The speaker's name and topic
The average rating of their presentation
The impact score (calculated using set theory)
A classification of the presentation ("Semifabulous", "Impressive", or "Average")
To solve this challenge, you need to:

Use advanced array operations like map, filter, and reduce to process the input data.
Implement set theory concepts to calculate the impact score:
Create sets of keywords for each presentation (you can assume that each word in the topic is a keyword)
Calculate the intersection and union of these sets with the overall keyword set
Use set operations to determine the uniqueness and relevance of each presentation
Develop a classification system based on the average rating and impact score
Format the output string for each speaker with the required information
Use the following guidelines for classification:

"Semifabulous": Average rating >= 8.0 and Impact score >= 0.7
"Impressive": Average rating >= 7.0 and Impact score >= 0.5
"Average": All other cases
The impact score should be calculated as follows: (size of intersection between presentation keywords and overall keywords) / (size of union between presentation keywords and overall keywords)

Ensure your solution uses functional programming paradigms for arrays and set operations. You may use Java's built-in Set interface and its implementations for set operations.

Here's a code snippet to help you get started:


import java.util.*;
import java.util.stream.*;

public class Solution {
    public static String[] analyzeEventImpact(String[][] speakers, int[][] ratings, String[] keywords) {
        // Your code here
    }

    // Helper method to calculate average
    private static double calculateAverage(int[] array) {
        return Arrays.stream(array).average().orElse(0.0);
    }

    // Helper method to calculate impact score
    private static double calculateImpactScore(Set presentationKeywords, Set overallKeywords) {
        Set intersection = new HashSet<>(presentationKeywords);
        intersection.retainAll(overallKeywords);
        
        Set union = new HashSet<>(presentationKeywords);
        union.addAll(overallKeywords);
        
        return (double) intersection.size() / union.size();
    }
}

