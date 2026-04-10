import java.util.HashMap;
import java.util.Map;

class AnalyzePlaygroundData {
    public static String[] analyzePlaygroundData(String[] activities, int[] ages, float[] durations) {
        String[] result = new String[activities.length];
        Map<String, String> activityCategories = new HashMap<>();
        initializeActivityCategories(activityCategories);

        for (int i = 0; i < activities.length; i++) {
            double physicalScore = 0, cognitiveScore = 0, socialScore = 0;
            String[] childActivities = activities[i].split(" ");
            double activityWeight = getActivityWeight(ages[i]);

            for (int j = 0; j < childActivities.length; j++) {
                String category = activityCategories.get(childActivities[j]);
                double score = durations[i] * activityWeight;

                if ("physical".equals(category)) {
                    physicalScore += score;
                } else if ("cognitive".equals(category)) {
                    cognitiveScore += score;
                } else if ("social".equals(category)) {
                    socialScore += score;
                }
            }

            double normalizedPhysicalScore = normalizeScore(physicalScore, ages[i]);
            double normalizedCognitiveScore = normalizeScore(cognitiveScore, ages[i]);
            double normalizedSocialScore = normalizeScore(socialScore, ages[i]);

            String primaryStrength = getPrimaryStrength(normalizedPhysicalScore, normalizedCognitiveScore, normalizedSocialScore);
            double maxScore = Math.max(Math.max(normalizedPhysicalScore, normalizedCognitiveScore), normalizedSocialScore);

            result[i] = String.format("Age %d: Score %.1f - Primary Strength: %s", ages[i], maxScore, primaryStrength);
        }

        return result;
    }

    private static void initializeActivityCategories(Map<String, String> activityCategories) {
        String[] physical = {"running", "jumping", "climbing", "sliding"};
        String[] cognitive = {"puzzle", "reading", "counting", "drawing"};
        String[] social = {"sharing", "talking", "playing together", "helping"};

        for (String activity : physical) activityCategories.put(activity, "physical");
        for (String activity : cognitive) activityCategories.put(activity, "cognitive");
        for (String activity : social) activityCategories.put(activity, "social");
    }

    private static double getActivityWeight(int age) {
        if (age >= 9) return 1.5;
        if (age >= 6) return 1.2;
        return 1.0;
    }

    private static double normalizeScore(double rawScore, int age) {
        return rawScore * (1 + Math.log(age) / 10);
    }

    private static String getPrimaryStrength(double physical, double cognitive, double social) {
        if (physical >= cognitive && physical >= social) return "Physical";
        if (cognitive >= physical && cognitive >= social) return "Cognitive";
        return "Social";
    }
}
