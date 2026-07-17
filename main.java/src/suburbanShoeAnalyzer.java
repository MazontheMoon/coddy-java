import java.util.HashMap;
import java.util.Map;

class SuburbanShoeAnalyzer {
    public static String suburbanShoeAnalyzer(int[] agletTaps, String[] shoeTypes, int fibonacciMultiplier) {
        // Calculate the most common shoe type
        Map<String, Integer> shoeCount = new HashMap<>();
        String mostCommonShoe = "";
        int maxCount = 0;
        for (String shoe : shoeTypes) {
            int count = shoeCount.getOrDefault(shoe, 0) + 1;
            shoeCount.put(shoe, count);
            if (count > maxCount) {
                maxCount = count;
                mostCommonShoe = shoe;
            }
        }

        // Calculate total taps after applying Fibonacci multiplier
        int totalTaps = 0;
        for (int taps : agletTaps) {
            totalTaps += taps * fibonacciMultiplier;
        }

        // Calculate neighborhood shoe score
        int score = totalTaps;
        score += shoeCount.size() * 10; // Bonus for unique shoe types
        if (mostCommonShoe.equals("sneakers")) {
            score += 50; // Additional bonus for sneakers
        }

        // Construct and return the result string
        return String.format("%s;%d;%d", mostCommonShoe, totalTaps, score);
    }
}
