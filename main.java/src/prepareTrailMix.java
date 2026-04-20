import java.util.*;

class PrepareTrailMix {
    public static String[] prepareTrailMix(int hikersCount, String[][] snacks) {
        Set<String> trailMixSet = new HashSet<>();
        
        for (int i = 0; i < hikersCount; i++) {
            for (String snack : snacks[i]) {
                trailMixSet.add(snack);
            }
        }
        
        String[] trailMix = trailMixSet.toArray(new String[0]);
        Arrays.sort(trailMix);
        
        return trailMix;
    }
}
