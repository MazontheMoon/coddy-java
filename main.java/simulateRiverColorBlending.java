import java.util.Arrays;

class SimulateRiverColorBlending {
    public static String[][] simulateRiverColorBlending(String[][] riverSurface, int rainfallCycles, String[] sedimentColors) {
        int rows = riverSurface.length;
        int cols = riverSurface[0].length;

        for (int cycle = 0; cycle < rainfallCycles; cycle++) {
            // Introduce new sediment colors
            for (int i = 0; i < sedimentColors.length; i++) {
                int position = (cycle * 17 + i * 31) % cols;
                riverSurface[0][position] = blendColors(riverSurface[0][position], sedimentColors[i]);
            }

            // Blend colors
            String[][] newSurface = new String[rows][cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    newSurface[i][j] = blendAdjacentColors(riverSurface, i, j, rows, cols);
                }
            }

            // Simulate river flow
            for (int i = rows - 1; i > 0; i--) {
                newSurface[i] = Arrays.copyOf(newSurface[i - 1], cols);
            }

            riverSurface = newSurface;
        }

        return riverSurface;
    }

    private static String blendColors(String color1, String color2) {
        if (color1.equals(color2)) return color1;
        if (color1.equals("brown") || color2.equals("brown")) return "brown";

        String[] primaryColors = {"red", "blue", "yellow"};
        String[] secondaryColors = {"purple", "green", "orange"};
        String[] tertiaryColors = {"magenta", "teal", "amber"};

        if (Arrays.asList(primaryColors).contains(color1) && Arrays.asList(primaryColors).contains(color2)) {
            if ((color1.equals("red") && color2.equals("blue")) || (color1.equals("blue") && color2.equals("red"))) return "purple";
            if ((color1.equals("blue") && color2.equals("yellow")) || (color1.equals("yellow") && color2.equals("blue"))) return "green";
            if ((color1.equals("red") && color2.equals("yellow")) || (color1.equals("yellow") && color2.equals("red"))) return "orange";
        }

        if (Arrays.asList(primaryColors).contains(color1) && Arrays.asList(secondaryColors).contains(color2) ||
            Arrays.asList(primaryColors).contains(color2) && Arrays.asList(secondaryColors).contains(color1)) {
            if ((color1.equals("red") && color2.equals("purple")) || (color1.equals("purple") && color2.equals("red"))) return "magenta";
            if ((color1.equals("blue") && color2.equals("green")) || (color1.equals("green") && color2.equals("blue"))) return "teal";
            if ((color1.equals("yellow") && color2.equals("orange")) || (color1.equals("orange") && color2.equals("yellow"))) return "amber";
        }

        return "brown";
    }

    private static String blendAdjacentColors(String[][] surface, int row, int col, int rows, int cols) {
        String currentColor = surface[row][col];
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                currentColor = blendColors(currentColor, surface[newRow][newCol]);
            }
        }

        return currentColor;
    }
}