/*
Create a function named analyzePlantDNA that receives dnaSequence and segments as its parameters.

This function extracts specific segments from a given DNA sequence and combines them into a single string.

The DNA sequence is a string of nucleotide bases (A, T, C, G). The segments parameter is a 2D integer array, where each inner array contains two elements: the start index (inclusive) and the end index (exclusive) of a segment to extract from the DNA sequence.

Extract the specified segments from the DNA sequence and concatenate them in the order they appear in the segments array. The resulting string should contain only the combined extracted segments.

Parameters:
- dnaSequence (String): The DNA sequence of the plant.
- segments (int[][]): A 2D integer array where each inner array represents a segment to extract. The first element is the start index (inclusive), and the second element is the end index (exclusive).

The function returns a String representing the combined extracted segments from the DNA sequence.
*/

class AnalyzePlantDNA {
    public static String analyzePlantDNA(String dnaSequence, int[][] segments) {
        StringBuilder result = new StringBuilder();
        for (int[] segment : segments) {
            int startIndex = segment[0];
            int endIndex = segment[1];
            String extractedSegment = dnaSequence.substring(startIndex, endIndex);
            result.append(extractedSegment);
        }
        return result.toString();
    }
}