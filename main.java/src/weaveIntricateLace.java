import java.util.*;

class WeaveIntricateLace {
    public static String[] weaveIntricateLace(int n, String[][] patterns) {
        // Sort each pattern array based on string length
        for (String[] pattern : patterns) {
            Arrays.sort(pattern, Comparator.comparingInt(String::length));
        }

        // Sort patterns array based on overall complexity
        Arrays.sort(patterns, Comparator.comparingInt(arr -> Arrays.stream(arr).mapToInt(String::length).sum()));

        // Concatenate all patterns
        List<String> concatenated = new ArrayList<>();
        for (String[] pattern : patterns) {
            concatenated.addAll(Arrays.asList(pattern));
        }

        // Remove empty strings
        concatenated.removeIf(String::isEmpty);

        // Interleave the concatenated array with itself
        List<String> interwoven = new ArrayList<>();
        int size = concatenated.size();
        for (int i = 0; i < size; i++) {
            interwoven.add(concatenated.get(i));
            interwoven.add(concatenated.get(size - 1 - i));
        }

        // Remove duplicates while preserving order
        Set<String> seen = new LinkedHashSet<>(interwoven);
        interwoven = new ArrayList<>(seen);

        return interwoven.toArray(new String[0]);
    }
}
