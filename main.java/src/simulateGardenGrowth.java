import java.util.Arrays;

class SimulateGardenGrowth {
    public static float[][] simulateGardenGrowth(int days, float[] initialHeights, float[] growthRates, float[] sunlightExposure, float[] nutrientLevels, float avgTemperature, float dailyRainfall) {
        int numPlants = initialHeights.length;
        float[][] gardenGrowth = new float[days][numPlants];
        
        // Initialize the first day with initial heights
        gardenGrowth[0] = Arrays.copyOf(initialHeights, numPlants);
        
        for (int day = 1; day < days; day++) {
            for (int plant = 0; plant < numPlants; plant++) {
                float height = gardenGrowth[day - 1][plant];
                float growthRate = growthRates[plant];
                
                // Apply differential equation for growth
                float dHeight = growthRate * height * (1 - height / 100) * nutrientLevels[plant];
                
                // Apply sunlight effect using trigonometric function
                float sunlightEffect = (float) (1 + 0.2 * Math.sin(Math.PI * sunlightExposure[plant] / 100));
                
                // Adjust growth based on temperature
                float tempFactor = calculateTemperatureFactor(avgTemperature);
                
                // Adjust growth based on rainfall
                float rainfallFactor = calculateRainfallFactor(dailyRainfall);
                
                // Calculate new height
                float newHeight = height + dHeight * sunlightEffect * tempFactor * rainfallFactor;
                
                // Apply competition effect
                newHeight *= calculateCompetitionFactor(plant, gardenGrowth[day - 1]);
                
                // Ensure height doesn't exceed maximum
                gardenGrowth[day][plant] = Math.min(newHeight, 100);
            }
        }
        
        return gardenGrowth;
    }
    
    private static float calculateTemperatureFactor(float temperature) {
        if (temperature < 0 || temperature > 40) {
            return 0.5f; // Extreme temperatures slow growth
        } else if (temperature >= 20 && temperature <= 30) {
            return 1.2f; // Optimal temperature range
        } else {
            return 1.0f; // Normal growth
        }
    }
    
    private static float calculateRainfallFactor(float rainfall) {
        if (rainfall < 1) {
            return 0.8f; // Too dry
        } else if (rainfall > 20) {
            return 0.9f; // Too wet
        } else {
            return 1.0f + (rainfall - 1) / 38f; // Optimal range
        }
    }
    
    private static float calculateCompetitionFactor(int currentPlant, float[] plantHeights) {
        float totalHeight = 0;
        for (int i = 0; i < plantHeights.length; i++) {
            if (i != currentPlant) {
                totalHeight += plantHeights[i];
            }
        }
        float averageHeight = totalHeight / (plantHeights.length - 1);
        return 1 / (1 + (float)Math.exp(0.1 * (plantHeights[currentPlant] - averageHeight)));
    }
}
