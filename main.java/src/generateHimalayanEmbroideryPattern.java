import java.util.Arrays;

class GenerateHimalayanEmbroideryPattern {
    private static final double PI = 3.14159265358979323846;
    private static final double E = 2.71828182845904523536;
    private static final double PHI = 1.61803398874989484820;

    public static int[][] generateHimalayanEmbroideryPattern(int patternSize, int complexity, float baseFrequency, int colorDepth) {
        int[][] pattern = new int[patternSize][patternSize];
        double centerX = patternSize / 2.0;
        double centerY = patternSize / 2.0;

        for (int y = 0; y < patternSize; y++) {
            for (int x = 0; x < patternSize; x++) {
                double dx = x - centerX;
                double dy = y - centerY;
                double distance = Math.sqrt(dx * dx + dy * dy);
                double angle = Math.atan2(dy, dx);

                double value = 0;

                // Trigonometric patterns
                value += Math.sin(angle * complexity + distance * baseFrequency);
                value += Math.cos(angle * complexity * PHI + distance * baseFrequency * E);

                // Logarithmic spiral
                value += Math.log(1 + distance) * Math.sin(angle * complexity);

                // Fractal-like pattern
                for (int i = 1; i <= complexity; i++) {
                    value += Math.sin(distance * baseFrequency * i) / i;
                }

                // Normalize value to [0, 1] range
                value = (value + complexity * 2) / (complexity * 4);

                // Apply color gradient
                int colorIndex = (int) (value * (colorDepth - 1));
                pattern[y][x] = colorIndex;
            }
        }

        return pattern;
    }
}
