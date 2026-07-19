import java.util.*;

class OptimizeStaining {
    public static String optimizeStaining(String[] enzymes, int[] mutationLevels, String stain, int duration) {
        Map<String, Double> baseScores = new HashMap<>();
        Map<String, Double> adjustedScores = new HashMap<>();
        List<String> stainSequence = new ArrayList<>();
        StringBuilder result = new StringBuilder();

        // Assign base scores and adjust for stain compatibility
        for (int i = 0; i < enzymes.length; i++) {
            baseScores.put(enzymes[i], (double) mutationLevels[i]);
            adjustedScores.put(enzymes[i], adjustScoreForStain(enzymes[i], stain, mutationLevels[i]));
        }

        // Adjust for enzyme conflicts
        adjustForConflicts(adjustedScores, enzymes);

        // Determine staining sequence
        stainSequence = determineStainingSequence(adjustedScores);

        // Calculate success rates and format output
        result.append("Optimal Staining Sequence: " + String.join(" -> ", stainSequence) + "\n\n");
        result.append("Predicted Success Rates:\n");

        for (String enzyme : stainSequence) {
            double successRate = calculateSuccessRate(adjustedScores.get(enzyme), duration);
            result.append(enzyme + ": " + String.format("%.2f", successRate) + "%\n");
        }

        result.append("\nPotential Issues:\n");
        result.append(identifyPotentialIssues(enzymes, mutationLevels, stain, duration));

        result.append("\nRecommendations:\n");
        result.append(provideRecommendations(enzymes, mutationLevels, stain, duration));

        return result.toString();
    }

    private static double adjustScoreForStain(String enzyme, String stain, int mutationLevel) {
        double adjustedScore = mutationLevel;
        if (enzyme.equals("EnzymeA") && stain.equals("StainX")) {
            adjustedScore *= 1.2;
        } else if (enzyme.equals("EnzymeB") && stain.equals("StainX")) {
            adjustedScore *= 0.9;
        } else if (enzyme.equals("EnzymeC") && stain.equals("StainX")) {
            adjustedScore *= 1.1;
        }
        return adjustedScore;
    }

    private static void adjustForConflicts(Map<String, Double> scores, String[] enzymes) {
        if (Arrays.asList(enzymes).contains("EnzymeA") && Arrays.asList(enzymes).contains("EnzymeB")) {
            scores.put("EnzymeA", scores.get("EnzymeA") * 0.95);
            scores.put("EnzymeB", scores.get("EnzymeB") * 0.95);
        }
    }

    private static List<String> determineStainingSequence(Map<String, Double> scores) {
        return scores.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .collect(java.util.stream.Collectors.toList());
    }

    private static double calculateSuccessRate(double score, int duration) {
        return Math.min(100, score * duration / 10);
    }

    private static String identifyPotentialIssues(String[] enzymes, int[] mutationLevels, String stain, int duration) {
        StringBuilder issues = new StringBuilder();
        if (Arrays.asList(enzymes).contains("EnzymeA") && Arrays.asList(enzymes).contains("EnzymeB")) {
            issues.append("- Potential interference between EnzymeA and EnzymeB\n");
        }
        if (Arrays.stream(mutationLevels).anyMatch(level -> level > 4)) {
            issues.append("- High mutation levels detected, may require extended staining duration\n");
        }
        if (duration < 15) {
            issues.append("- Short staining duration may result in incomplete staining\n");
        }
        return issues.length() > 0 ? issues.toString() : "No significant issues identified.\n";
    }

    private static String provideRecommendations(String[] enzymes, int[] mutationLevels, String stain, int duration) {
        StringBuilder recommendations = new StringBuilder();
        if (Arrays.stream(mutationLevels).anyMatch(level -> level > 4)) {
            recommendations.append("- Consider increasing staining duration for high mutation levels\n");
        }
        if (duration < 15) {
            recommendations.append("- Increase staining duration to improve overall success rate\n");
        }
        if (!stain.equals("StainX")) {
            recommendations.append("- Evaluate alternative staining agents for potential improved results\n");
        }
        return recommendations.length() > 0 ? recommendations.toString() : "No specific recommendations at this time.\n";
    }
}