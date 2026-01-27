import java.util.Arrays;

class DiplomaticMission {
    public static int[] import java.util.Arrays;

class DiplomaticMission {
    public static int[] diplomaticMission(int[] tensions, int resources) {
        int[] modifiedTensions = Arrays.copyOf(tensions, tensions.length);
        
        // First pass: reduce odd-numbered tensions
        for (int i = 0; i < modifiedTensions.length && resources > 0; i++) {
            if (modifiedTensions[i] % 2 != 0) {
                modifiedTensions[i]--;
                resources--;
            }
        }
        
        // Second pass: reduce even-numbered tensions
        for (int i = 0; i < modifiedTensions.length && resources > 0; i++) {
            if (modifiedTensions[i] > 0) {
                modifiedTensions[i]--;
                resources--;
            }
        }
        
        return modifiedTensions;
    }
}(int[] tensions, int resources) {
        int[] modifiedTensions = Arrays.copyOf(tensions, tensions.length);
        
        // First pass: reduce odd-numbered tensions
        for (int i = 0; i < modifiedTensions.length && resources > 0; i++) {
            if (modifiedTensions[i] % 2 != 0) {
                modifiedTensions[i]--;
                resources--;
            }
        }
        
        // Second pass: reduce even-numbered tensions
        for (int i = 0; i < modifiedTensions.length && resources > 0; i++) {
            if (modifiedTensions[i] > 0) {
                modifiedTensions[i]--;
                resources--;
            }
        }
        
        return modifiedTensions;
    }
}
