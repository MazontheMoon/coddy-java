import java.util.Random;

class GenerateHorseshoeCrabScene {
    public static String generateHorseshoeCrabScene(int numCrabs, int beachWidth, int waveLayers) {
        StringBuilder scene = new StringBuilder();
        Random rand = new Random(numCrabs * beachWidth * waveLayers);

        // Generate sand
        for (int i = 0; i < 3; i++) {
            scene.append(".".repeat(beachWidth)).append("\n");
        }

        // Generate horseshoe crabs
        for (int i = 0; i < numCrabs; i++) {
            int position = rand.nextInt(beachWidth - 3);
            StringBuilder crabLine = new StringBuilder(".".repeat(beachWidth));
            crabLine.setCharAt(position, '@');
            crabLine.setCharAt(position + 1, '*');
            crabLine.setCharAt(position + 2, '@');
            scene.insert(0, crabLine.toString() + "\n");
        }

        // Generate waves
        for (int i = 0; i < waveLayers; i++) {
            StringBuilder waveLine = new StringBuilder();
            for (int j = 0; j < beachWidth; j++) {
                waveLine.append(j % 2 == 0 ? '~' : '-');
            }
            scene.insert(0, waveLine.toString() + "\n");
        }

        return scene.toString();
    }
}
