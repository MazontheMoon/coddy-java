import java.util.Arrays;

class CreateColorfulArt {
    public static float[][] createColorfulArt(int friends, float[][] initialPaint, int[] paintingOrder, float[] paintUsagePercentage, int turns) {
        float[][] paint = new float[friends][initialPaint[0].length];
        for (int i = 0; i < friends; i++) {
            paint[i] = Arrays.copyOf(initialPaint[i], initialPaint[i].length);
        }

        for (int turn = 0; turn < turns; turn++) {
            int currentFriend = paintingOrder[turn % paintingOrder.length];
            float usage = paintUsagePercentage[turn % paintUsagePercentage.length];

            // Apply paint usage
            for (int color = 0; color < paint[currentFriend].length; color++) {
                float usedPaint = paint[currentFriend][color] * usage;
                paint[currentFriend][color] -= usedPaint;
            }

            // Apply mixing effect
            float[] mixedPaint = new float[paint[currentFriend].length];
            for (int color = 0; color < paint[currentFriend].length; color++) {
                float mixAmount = paint[currentFriend][color] * 0.05f;
                paint[currentFriend][color] -= mixAmount * (paint[currentFriend].length - 1);
                for (int otherColor = 0; otherColor < paint[currentFriend].length; otherColor++) {
                    if (color != otherColor) {
                        mixedPaint[otherColor] += mixAmount;
                    }
                }
            }
            for (int color = 0; color < paint[currentFriend].length; color++) {
                paint[currentFriend][color] += mixedPaint[color];
            }
        }

        // Apply group sharing
        float[] totalPaint = new float[paint[0].length];
        for (int friend = 0; friend < friends; friend++) {
            for (int color = 0; color < paint[friend].length; color++) {
                totalPaint[color] += paint[friend][color];
            }
        }
        for (int friend = 0; friend < friends; friend++) {
            for (int color = 0; color < paint[friend].length; color++) {
                paint[friend][color] = roundToTwoDecimals(totalPaint[color] / friends);
            }
        }

        return paint;
    }

    private static float roundToTwoDecimals(float value) {
        return Math.round(value * 100) / 100.0f;
    }
}