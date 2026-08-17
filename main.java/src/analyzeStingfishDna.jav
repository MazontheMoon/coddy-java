import java.util.Arrays;

class AnalyzeStingfishDNA {
    public static String analyzeStingfishDNA(String[] sequence1, String[] sequence2) {
        // Concatenate sequence1 and sequence2
        String[] combinedSequence = new String[sequence1.length + sequence2.length];
        System.arraycopy(sequence1, 0, combinedSequence, 0, sequence1.length);
        System.arraycopy(sequence2, 0, combinedSequence, sequence1.length, sequence2.length);
        
        // Reverse the order of elements
        for (int i = 0; i < combinedSequence.length / 2; i++) {
            String temp = combinedSequence[i];
            combinedSequence[i] = combinedSequence[combinedSequence.length - 1 - i];
            combinedSequence[combinedSequence.length - 1 - i] = temp;
        }
        
        // Join all elements into a single string, separated by spaces
        return String.join(" ", combinedSequence);
    }
}