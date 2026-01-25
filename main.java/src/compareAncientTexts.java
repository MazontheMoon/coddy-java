import java.util.HashMap;
import java.util.Map;

class CompareAncientTexts {
    public static boolean compareAncientTexts(String fragment1, String fragment2, int method) {
        switch (method) {
            case 1:
                return bitPatternSimilarity(fragment1, fragment2);
            case 2:
                return substringFrequencyAnalysis(fragment1, fragment2);
            case 3:
                return characterSetComparison(fragment1, fragment2);
            default:
                return false;
        }
    }

    private static boolean bitPatternSimilarity(String fragment1, String fragment2) {
        int matchingBits = 0;
        int totalBits = 0;
        int minLength = Math.min(fragment1.length(), fragment2.length());

        for (int i = 0; i < minLength; i++) {
            int xor = fragment1.charAt(i) ^ fragment2.charAt(i);
            matchingBits += Integer.bitCount(~xor & 0xFF);
            totalBits += 8;
        }

        double similarityScore = (double) matchingBits / totalBits;
        return similarityScore > 0.7;
    }

    private static boolean substringFrequencyAnalysis(String fragment1, String fragment2) {
        Map<String, Integer> freq1 = getSubstringFrequency(fragment1);
        Map<String, Integer> freq2 = getSubstringFrequency(fragment2);

        int matchingSubstrings = 0;
        int totalSubstrings = freq1.size() + freq2.size();

        for (String substring : freq1.keySet()) {
            if (freq2.containsKey(substring)) {
                matchingSubstrings += Math.min(freq1.get(substring), freq2.get(substring));
            }
        }

        double similarityScore = (double) (2 * matchingSubstrings) / totalSubstrings;
        return similarityScore > 0.7;
    }

    private static Map<String, Integer> getSubstringFrequency(String fragment) {
        Map<String, Integer> frequency = new HashMap<>();
        for (int i = 0; i <= fragment.length() - 3; i++) {
            String substring = fragment.substring(i, i + 3);
            frequency.put(substring, frequency.getOrDefault(substring, 0) + 1);
        }
        return frequency;
    }

    private static boolean characterSetComparison(String fragment1, String fragment2) {
        long bitVector1 = createBitVector(fragment1);
        long bitVector2 = createBitVector(fragment2);

        long commonChars = bitVector1 & bitVector2;
        long allChars = bitVector1 | bitVector2;

        double similarityScore = (double) Long.bitCount(commonChars) / Long.bitCount(allChars);
        return similarityScore > 0.7;
    }

    private static long createBitVector(String fragment) {
        long bitVector = 0;
        for (char c : fragment.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                bitVector |= 1L << (c - 'a');
            }
        }
        return bitVector;
    }
}
