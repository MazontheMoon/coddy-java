import java.util.*;

class FindUniqueShells {
    public static String[] findUniqueShells(int bucketSize, String[] shells) {
        Set<String> uniqueShells = new LinkedHashSet<>();
        
        for (String shell : shells) {
            uniqueShells.add(shell);
            if (uniqueShells.size() == bucketSize) {
                break;
            }
        }
        
        return uniqueShells.toArray(new String[0]);
    }
}