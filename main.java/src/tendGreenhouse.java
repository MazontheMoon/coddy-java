import java.util.Arrays;

class TendGreenhouse {
    public static String[] tendGreenhouse(String[] flowerTypes, int[] growthStages, int days, float waterPerDay, float fertilizerPerDay) {
        String[] status = new String[flowerTypes.length];
        float[] waterNeeds = {1.5f, 2.0f, 3.0f};
        float[] fertilizerNeeds = {0.5f, 1.0f, 1.5f};

        for (int day = 0; day < days; day++) {
            float waterLeft = waterPerDay;
            float fertilizerLeft = fertilizerPerDay;

            for (int i = 0; i < flowerTypes.length; i++) {
                if (growthStages[i] < 5) {
                    float waterRequired = waterNeeds[Math.min(growthStages[i], 2)];
                    float fertilizerRequired = fertilizerNeeds[Math.min(growthStages[i], 2)];

                    if (waterLeft >= waterRequired && fertilizerLeft >= fertilizerRequired) {
                        waterLeft -= waterRequired;
                        fertilizerLeft -= fertilizerRequired;
                        growthStages[i]++;
                    }
                }
            }
        }

        for (int i = 0; i < flowerTypes.length; i++) {
            status[i] = getFlowerStatus(flowerTypes[i], growthStages[i]);
        }

        return status;
    }

    private static String getFlowerStatus(String flowerType, int growthStage) {
        String[] stageDescriptions = {"seed", "sprout", "young plant", "maturing plant", "budding plant", "fully bloomed"};
        String condition = growthStage == 5 ? "thriving" : "needs more care";
        return flowerType + ": " + stageDescriptions[growthStage] + " - " + condition;
    }
}
