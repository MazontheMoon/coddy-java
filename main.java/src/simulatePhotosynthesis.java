class SimulatePhotosynthesis {
    public static float simulatePhotosynthesis(int[] lightIntensities, int[] temperatures, int[] nutrientLevels) {
        float totalEfficiency = 0;
        int timePoints = lightIntensities.length;

        for (int i = 0; i < timePoints; i++) {
            if (lightIntensities[i] < 50 || temperatures[i] < 20 || temperatures[i] > 40) {
                continue;
            }
            float efficiency = lightIntensities[i] * temperatures[i] * nutrientLevels[i];
            totalEfficiency += efficiency;
        }

        float averageEfficiency = totalEfficiency / timePoints;
        return averageEfficiency;
    }
}