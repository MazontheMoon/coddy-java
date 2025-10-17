/*
Create a function named calculateDebateScore that receives String[] binaryScores and int qualificationThreshold as its parameters.

You are tasked with developing a scoring system for a lively debate competition at a university campus. The system will calculate a debater's total score based on binary representations of judges' scores and determine if the debater qualifies for the next round.

Your function should perform the following steps:
-Convert each binary score in the binaryScores array to its decimal equivalent.
-Calculate the sum of all the converted decimal scores.
-Determine if the debater qualifies for the next round by comparing the total score to the qualificationThreshold.

Parameters:
-binaryScores (String[]): An array of strings, where each string represents a judge's score in binary format. Each binary score will be a valid binary number.
-qualificationThreshold (int): An integer representing the minimum total score required to qualify for the next round.
The function should return a string in the format: "Total Score: X, Qualified: true/false", where X is the sum of decimal scores and the boolean indicates whether the debater qualified for the next round.

To convert a binary string to decimal, you can use the following method:
int decimal = Integer.parseInt(binaryString, 2);

Note: You don't need to handle invalid input. Assume that all input will be valid according to the specified constraints.
 */

class CalculateDebateScore {
    public static String calculateDebateScore(String[] binaryScores, int qualificationThreshold) {
        int totalScore = 0;

        for (String binaryScore : binaryScores) {
            int decimalScore = Integer.parseInt(binaryScore, 2);
            totalScore += decimalScore;
        }

        boolean qualified = totalScore >= qualificationThreshold;

        return "Total Score: " + totalScore + ", Qualified: " + qualified;
    }
}
