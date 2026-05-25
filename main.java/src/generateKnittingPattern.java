import java.util.ArrayList;
import java.util.List;

class GenerateKnittingPattern {
    public static char[][] generateKnittingPattern(int colors, int width, int height, int[] techniques) {
        char[][] pattern = new char[height][width];
        List<Integer> powerSet = generatePowerSet(techniques);

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int colorIndex = (i ^ j) % colors;
                int techniqueIndex = powerSet.get((i + j) % powerSet.size());
                char stitchChar = (char) ('A' + (colorIndex ^ techniqueIndex) % 26);
                pattern[i][j] = stitchChar;
            }
        }

        applySetOperations(pattern, colors, techniques);
        return pattern;
    }

    private static List<Integer> generatePowerSet(int[] techniques) {
        List<Integer> powerSet = new ArrayList<>();
        int n = techniques.length;
        for (int i = 0; i < (1 << n); i++) {
            int subset = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    subset |= techniques[j];
                }
            }
            powerSet.add(subset);
        }
        return powerSet;
    }

    private static void applySetOperations(char[][] pattern, int colors, int[] techniques) {
        int height = pattern.length;
        int width = pattern[0].length;
        int mask = (1 << colors) - 1;

        // Apply union operation
        for (int i = 0; i < height / 2; i++) {
            for (int j = 0; j < width / 2; j++) {
                int value = (pattern[i][j] - 'A') | (pattern[i][j + width / 2] - 'A');
                pattern[i][j] = (char) ('A' + (value & mask));
            }
        }

        // Apply intersection operation
        for (int i = height / 2; i < height; i++) {
            for (int j = 0; j < width / 2; j++) {
                int value = (pattern[i][j] - 'A') & (pattern[i][j + width / 2] - 'A');
                pattern[i][j] = (char) ('A' + (value & mask));
            }
        }

        // Apply complement operation
        for (int i = 0; i < height; i++) {
            for (int j = width / 2; j < width; j++) {
                int value = (~(pattern[i][j] - 'A')) & mask;
                pattern[i][j] = (char) ('A' + value);
            }
        }

        // Apply XOR with techniques
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int value = (pattern[i][j] - 'A') ^ techniques[(i + j) % techniques.length];
                pattern[i][j] = (char) ('A' + (value % 26));
            }
        }
    }
}
