import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read number of patients
        int n = Integer.parseInt(scanner.nextLine());
        
        // Store patient records
        Map<String, String> patients = new HashMap<>();
        
        // Read patient records
        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            String id = scanner.nextLine();
            patients.put(name, id);
        }
        
        // Process queries until no more input
        while (scanner.hasNextLine()) {
            String query = scanner.nextLine();
            String[] parts = query.split(" ", 2);
            String queryType = parts[0];
            String queryValue = parts[1];
            
            if (queryType.equals("WILDCARD")) {
                handleWildcard(patients, queryValue);
            } else if (queryType.equals("ANAGRAM")) {
                handleAnagram(patients, queryValue);
            } else if (queryType.equals("MIDDLE")) {
                handleMiddle(patients, queryValue);
            }
        }
        
        scanner.close();
    }
    
    // Handle WILDCARD query
    private static void handleWildcard(Map<String, String> patients, String pattern) {
        List<String> matches = new ArrayList<>();
        
        for (String name : patients.keySet()) {
            if (matchesPattern(name.toLowerCase(), pattern.toLowerCase())) {
                matches.add(name);
            }
        }
        
        Collections.sort(matches);
        for (String match : matches) {
            System.out.println(match);
        }
    }
    
    // Check if a name matches a wildcard pattern
    private static boolean matchesPattern(String name, String pattern) {
        return matchesPatternHelper(name, pattern, 0, 0);
    }
    
    private static boolean matchesPatternHelper(String name, String pattern, int nameIdx, int patternIdx) {
        // Base cases
        if (patternIdx == pattern.length()) {
            return nameIdx == name.length();
        }
        
        if (nameIdx == name.length()) {
            // Check if remaining pattern is all '*'
            for (int i = patternIdx; i < pattern.length(); i++) {
                if (pattern.charAt(i) != '*') {
                    return false;
                }
            }
            return true;
        }
        
        char patternChar = pattern.charAt(patternIdx);
        
        if (patternChar == '*') {
            // Try matching zero or more characters
            // Option 1: * matches zero characters
            if (matchesPatternHelper(name, pattern, nameIdx, patternIdx + 1)) {
                return true;
            }
            // Option 2: * matches one or more characters
            return matchesPatternHelper(name, pattern, nameIdx + 1, patternIdx);
        } else if (patternChar == '?') {
            // ? matches exactly one character
            return matchesPatternHelper(name, pattern, nameIdx + 1, patternIdx + 1);
        } else {
            // Regular character - must match exactly
            if (name.charAt(nameIdx) == patternChar) {
                return matchesPatternHelper(name, pattern, nameIdx + 1, patternIdx + 1);
            }
            return false;
        }
    }
    
    // Handle ANAGRAM query
    private static void handleAnagram(Map<String, String> patients, String target) {
        List<String> matches = new ArrayList<>();
        String targetSorted = sortString(target.toLowerCase());
        
        for (String name : patients.keySet()) {
            String nameSorted = sortString(name.toLowerCase());
            if (nameSorted.equals(targetSorted)) {
                matches.add(name);
            }
        }
        
        Collections.sort(matches);
        for (String match : matches) {
            System.out.println(match);
        }
    }
    
    // Sort characters in a string
    private static String sortString(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
    
    // Handle MIDDLE query
    private static void handleMiddle(Map<String, String> patients, String name) {
        String id = patients.get(name);
        if (id != null) {
            int middleIndex = id.length() / 2;
            System.out.println(id.charAt(middleIndex));
        }
    }
}