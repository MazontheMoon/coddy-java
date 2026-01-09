import java.util.Arrays;

class DrillArtesianWell {
    public static int[] drillArtesianWell(int[] earthLayers, int initialSkill, int targetDepth) {
        int currentDepth = 0;
        int currentSkill = initialSkill;
        int waveredCount = 0;

        for (int layerHardness : earthLayers) {
            if (currentDepth == targetDepth) {
                break;
            }

            if (currentSkill > layerHardness) {
                currentDepth++;
                currentSkill = Math.min(currentSkill + 1, 10);
            } else if (currentSkill == layerHardness) {
                currentDepth++;
            } else {
                int perseverance = (currentDepth * currentSkill) % 10 + 1;
                if (perseverance > layerHardness - currentSkill) {
                    currentDepth++;
                    waveredCount++;
                } else {
                    break;
                }
            }
        }

        return new int[]{currentDepth, currentSkill, waveredCount};
    }
}
