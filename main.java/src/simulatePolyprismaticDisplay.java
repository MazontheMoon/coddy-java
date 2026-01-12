import java.util.Arrays;

class SimulatePolyprismaticDisplay {
    public static String[][] simulatePolyprismaticDisplay(String[][] lightBeams, int iterations) {
        int rows = lightBeams.length;
        int cols = lightBeams[0].length;
        String[][] current = deepCopy(lightBeams);
        String[][] next = new String[rows][cols];

        for (int iter = 0; iter < iterations; iter++) {
            // Move beams diagonally and handle intersections
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    int newI = (i + 1) % rows;
                    int newJ = (j + 1) % cols;
                    String color = current[i][j];
                    if (next[newI][newJ] == null) {
                        next[newI][newJ] = color;
                    } else {
                        next[newI][newJ] = mixColors(next[newI][newJ], color);
                    }
                }
            }

            // Reverse horizontally on even iterations
            if (iter % 2 == 0) {
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols / 2; j++) {
                        String temp = next[i][j];
                        next[i][j] = next[i][cols - 1 - j];
                        next[i][cols - 1 - j] = temp;
                    }
                }
            }

            // Prepare for next iteration
            current = next;
            next = new String[rows][cols];
        }

        return current;
    }

    private static String mixColors(String color1, String color2) {
        if (color1.equals(color2)) return color1;
        if ((color1.equals("R") && color2.equals("G")) || (color1.equals("G") && color2.equals("R"))) return "Y";
        if ((color1.equals("R") && color2.equals("B")) || (color1.equals("B") && color2.equals("R"))) return "P";
        if ((color1.equals("G") && color2.equals("B")) || (color1.equals("B") && color2.equals("G"))) return "C";
        return "W";
    }

    private static String[][] deepCopy(String[][] original) {
        return Arrays.stream(original)
                     .map(String[]::clone)
                     .toArray(String[][]::new);
    }
}

