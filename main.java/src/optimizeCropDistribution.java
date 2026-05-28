import java.util.*;
import java.util.stream.*;

class OptimizeCropDistribution {
    public static int[][] optimizeCropDistribution(float[][] fieldDimensions, int[] cropTypes, float[] growthRates, float weatherProbability, int growingSeason) {
        int numFields = fieldDimensions.length;
        int numCrops = cropTypes.length;
        int[][] optimalArrangement = new int[numFields][];

        // Calculate field areas
        float[] fieldAreas = new float[numFields];
        for (int i = 0; i < numFields; i++) {
            fieldAreas[i] = fieldDimensions[i][0] * fieldDimensions[i][1];
        }

        // Model crop growth using a simple exponential growth model
        float[] expectedYields = new float[numCrops];
        for (int i = 0; i < numCrops; i++) {
            expectedYields[i] = (float) (Math.exp(growthRates[i] * growingSeason) - 1);
        }

        // Adjust expected yields based on weather probability
        for (int i = 0; i < numCrops; i++) {
            expectedYields[i] *= (1 - weatherProbability);
        }

        // Use a greedy approach to allocate crops to fields
        PriorityQueue<Integer> cropQueue = new PriorityQueue<>((a, b) -> Float.compare(expectedYields[b], expectedYields[a]));
        for (int i = 0; i < numCrops; i++) {
            cropQueue.offer(i);
        }

        for (int i = 0; i < numFields; i++) {
            int numCropsInField = (int) Math.ceil(Math.sqrt(fieldAreas[i]));
            optimalArrangement[i] = new int[numCropsInField];
            for (int j = 0; j < numCropsInField; j++) {
                if (!cropQueue.isEmpty()) {
                    optimalArrangement[i][j] = cropTypes[cropQueue.poll()];
                } else {
                    // If we run out of crops, start over from the beginning
                    cropQueue.addAll(IntStream.range(0, numCrops).boxed().collect(Collectors.toList()));
                    optimalArrangement[i][j] = cropTypes[cropQueue.poll()];
                }
            }
        }

        return optimalArrangement;
    }
}
