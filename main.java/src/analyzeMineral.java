/*
Create a function named analyzeMineral that receives hardnessLevels as its parameter.
As a curious scientist in a laboratory, you are examining unusual mineral samples. Each sample has a hardness level, and you need to adjust these levels based on certain criteria.
Your task is to analyze the mineral samples and modify their hardness levels according to the following rules:

- If a sample's hardness is less than 3, increase it by 1 (strengthening it slightly).
- If a sample's hardness is greater than 7, decrease it by 1 (smoothing it out a bit).
- If a sample's hardness is exactly 5, leave it unchanged (it's perfect as is).
- For any other hardness level:
 - If the sample's index in the array is even, increase the hardness by 1.
 - If the sample's index in the array is odd, decrease the hardness by 1.

Parameters:
- hardnessLevels (int[]): An array representing the initial hardness levels of mineral samples (on a scale of 1-10).

The function returns an int[] representing the adjusted hardness levels after analysis.

*/
import java.util.Arrays;

class AnalyzeMineral {
    public static int[] analyzeMineral(int[] hardnessLevels) {
        int[] adjustedLevels = Arrays.copyOf(hardnessLevels, hardnessLevels.length);

        for (int i = 0; i < adjustedLevels.length; i++) {
            if (adjustedLevels[i] < 3) {
                adjustedLevels[i]++;
            } else if (adjustedLevels[i] > 7) {
                adjustedLevels[i]--;
            } else if (adjustedLevels[i] == 5) {
                // Do nothing, it's perfect as is
            } else {
                if (i % 2 == 0) {
                    adjustedLevels[i]++;
                } else {
                    adjustedLevels[i]--;
                }
            }
        }

        return adjustedLevels;
    }
}