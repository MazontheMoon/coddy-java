import java.util.Arrays;
import java.util.Random;

class SimulateWaterSprinkling {
    public static float[] simulateWaterSprinkling(float[] initialVelocity, float sprayAngle, float windSpeed, float windDirection, int numPassersby, float[] passerbyPositions, float sprayDuration, float waterFlowRate) {
        Random random = new Random();
        float[] result = new float[2 * numPassersby + 2];
        float totalWaterUsed = waterFlowRate * sprayDuration;
        float totalWaterHit = 0;

        for (int i = 0; i < numPassersby; i++) {
            float x = passerbyPositions[2 * i];
            float y = passerbyPositions[2 * i + 1];
            float distance = (float) Math.sqrt(x * x + y * y);
            float angle = (float) Math.atan2(y, x);

            // Probability calculation (simplified)
            float probability = 1.0f / (1 + distance);
            probability *= Math.max(0, Math.cos(angle - windDirection));
            probability *= Math.max(0, Math.cos(sprayAngle - angle));
            result[i] = Math.min(1, Math.max(0, probability));

            // Expected volume calculation (simplified)
            float expectedVolume = totalWaterUsed * result[i] / numPassersby;
            result[numPassersby + i] = expectedVolume;
            totalWaterHit += expectedVolume;
        }

        // Total water used
        result[2 * numPassersby] = totalWaterUsed;

        // Efficiency calculation
        result[2 * numPassersby + 1] = (totalWaterHit / totalWaterUsed) * 100;

        return result;
    }
}
