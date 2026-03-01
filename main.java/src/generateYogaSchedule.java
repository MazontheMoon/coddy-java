import java.util.*;

class GenerateYogaSchedule {
    public static String[][] generateYogaSchedule(float[] patientData, int[] centerConstraints, String[] availableStyles) {
        // Extract patient data
        int age = (int) patientData[0];
        float flexibilityScore = patientData[1];
        float strengthScore = patientData[2];
        float balanceScore = patientData[3];
        float respiratoryCapacity = patientData[4];

        // Extract center constraints
        int programDays = centerConstraints[0];
        int maxDailyDuration = centerConstraints[1];

        // Calculate overall health score
        float healthScore = calculateHealthScore(flexibilityScore, strengthScore, balanceScore, respiratoryCapacity);

        // Initialize schedule
        String[][] schedule = new String[programDays][];

        // Generate schedule for each day
        for (int day = 0; day < programDays; day++) {
            int sessionDuration = calculateSessionDuration(age, healthScore, maxDailyDuration, day);
            int poseCount = calculatePoseCount(day, healthScore);
            String[] dailyRoutine = generateDailyRoutine(poseCount, sessionDuration, availableStyles, patientData, day);
            schedule[day] = dailyRoutine;
        }

        return schedule;
    }

    private static float calculateHealthScore(float flexibility, float strength, float balance, float respiratory) {
        return (float) (0.25 * flexibility + 0.25 * strength + 0.25 * balance + 0.25 * respiratory);
    }

    private static int calculateSessionDuration(int age, float healthScore, int maxDuration, int day) {
        float ageFactor = 1 - (age - 20) / 100f;
        float progressFactor = 1 + (day / 30f);
        return (int) Math.min(maxDuration, maxDuration * healthScore * ageFactor * progressFactor);
    }

    private static int calculatePoseCount(int day, float healthScore) {
        return (int) (5 + Math.pow(1.1, day) * healthScore * 10);
    }

    private static String[] generateDailyRoutine(int poseCount, int duration, String[] styles, float[] patientData, int day) {
        List<String> routine = new ArrayList<>();
        Random random = new Random(day); // Seed for consistent randomness

        // Add warm-up
        routine.add("Warm-up");

        // Generate poses
        for (int i = 0; i < poseCount; i++) {
            String pose = generatePose(styles, patientData, day, i);
            routine.add(pose);

            // Add rest period
            if (i < poseCount - 1) {
                int restDuration = calculateRestDuration(patientData, i);
                routine.add("Rest (" + restDuration + " seconds)");
            }
        }

        // Add cool-down
        routine.add("Cool-down");

        return routine.toArray(new String[0]);
    }

    private static String generatePose(String[] styles, float[] patientData, int day, int poseIndex) {
        String style = styles[day % styles.length];
        String difficulty = calculateDifficulty(patientData, day);
        return style + " - " + difficulty + " Pose " + (poseIndex + 1);
    }

    private static String calculateDifficulty(float[] patientData, int day) {
        float healthScore = calculateHealthScore(patientData[1], patientData[2], patientData[3], patientData[4]);
        float difficultyScore = (float) (healthScore * (1 + Math.log(day + 1) / Math.log(2)));

        if (difficultyScore < 0.4) return "Beginner";
        else if (difficultyScore < 0.7) return "Intermediate";
        else return "Advanced";
    }

    private static int calculateRestDuration(float[] patientData, int poseIndex) {
        float healthScore = calculateHealthScore(patientData[1], patientData[2], patientData[3], patientData[4]);
        return (int) (60 / (healthScore * (1 + poseIndex * 0.1)));
    }
}

