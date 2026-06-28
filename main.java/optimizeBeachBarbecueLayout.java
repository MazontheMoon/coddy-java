import java.util.*;

class OptimizeBeachBarbecueLayout {
    private static final char GRILL = 'G';
    private static final char TABLE = 'T';
    private static final char SEATING = 'S';
    private static final char WATER = 'W';
    private static final char SAND = '.';

    public static char[][] optimizeBeachBarbecueLayout(int beachWidth, int beachLength, int grillCount, int tableCount, int seatingCount, float minDistance) {
        char[][] layout = new char[beachLength][beachWidth];
        for (char[] row : layout) {
            Arrays.fill(row, SAND);
        }

        // Add water to the right side of the beach
        for (int i = 0; i < beachLength; i++) {
            layout[i][beachWidth - 1] = WATER;
        }

        List<int[]> objects = new ArrayList<>();
        Random random = new Random(0);  // Use a fixed seed for deterministic results

        // Place grills
        placeObjects(layout, objects, grillCount, GRILL, minDistance, random);

        // Place tables
        placeObjects(layout, objects, tableCount, TABLE, minDistance, random);

        // Place seating areas
        placeObjects(layout, objects, seatingCount, SEATING, minDistance, random);

        return layout;
    }

    private static void placeObjects(char[][] layout, List<int[]> objects, int count, char type, float minDistance, Random random) {
        int attempts = 0;
        int maxAttempts = 1000;

        while (count > 0 && attempts < maxAttempts) {
            int x = random.nextInt(layout[0].length - 2);  // -2 to avoid placing on water
            int y = random.nextInt(layout.length);

            if (canPlace(layout, objects, x, y, minDistance)) {
                layout[y][x] = type;
                objects.add(new int[]{x, y});
                count--;
                attempts = 0;
            } else {
                attempts++;
            }
        }
    }

    private static boolean canPlace(char[][] layout, List<int[]> objects, int x, int y, float minDistance) {
        if (layout[y][x] != SAND) {
            return false;
        }

        for (int[] obj : objects) {
            if (distance(x, y, obj[0], obj[1]) < minDistance) {
                return false;
            }
        }

        return true;
    }

    private static double distance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
}
