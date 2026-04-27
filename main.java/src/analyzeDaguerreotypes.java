import java.util.Arrays;
import java.util.Comparator;

class AnalyzeDaguerreotypes {
    public static String analyzeDaguerreotypes(String[] titles, int[] years, String photographer) {
        // Create a class to hold daguerreotype information
        class Daguerreotype {
            String title;
            int year;
            
            Daguerreotype(String title, int year) {
                this.title = title;
                this.year = year;
            }
        }
        
        // Create an array of Daguerreotype objects
        Daguerreotype[] daguerreotypes = new Daguerreotype[titles.length];
        for (int i = 0; i < titles.length; i++) {
            daguerreotypes[i] = new Daguerreotype(titles[i], years[i]);
        }
        
        // Sort daguerreotypes by year
        Arrays.sort(daguerreotypes, Comparator.comparingInt(d -> d.year));
        
        // Count similar pairs
        int similarPairs = 0;
        for (int i = 0; i < daguerreotypes.length - 1; i++) {
            if (isSimilar(daguerreotypes[i].title, daguerreotypes[i+1].title)) {
                similarPairs++;
            }
        }
        
        // Count daguerreotypes by the given photographer
        int byPhotographer = photographer != null ? titles.length : 0;
        
        // Calculate average year
        double averageYear = Arrays.stream(years).average().orElse(0);
        
        // Find longest streak
        int longestStreak = 1;
        int currentStreak = 1;
        for (int i = 1; i < daguerreotypes.length; i++) {
            if (daguerreotypes[i].year == daguerreotypes[i-1].year + 1) {
                currentStreak++;
            } else {
                longestStreak = Math.max(longestStreak, currentStreak);
                currentStreak = 1;
            }
        }
        longestStreak = Math.max(longestStreak, currentStreak);
        
        // Format the sorted daguerreotypes
        StringBuilder sorted = new StringBuilder();
        for (Daguerreotype d : daguerreotypes) {
            if (sorted.length() > 0) sorted.append(", ");
            sorted.append(d.title).append(" (").append(d.year).append(")");
        }
        
        // Format the result string
        return String.format("Sorted: [%s]\nSimilar pairs: %d\nBy photographer: %d\nAverage year: %.2f\nLongest streak: %d years",
                             sorted.toString(), similarPairs, byPhotographer, averageYear, longestStreak);
    }
    
    private static boolean isSimilar(String s1, String s2) {
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();
        for (int i = 0; i <= s1.length() - 3; i++) {
            if (s2.contains(s1.substring(i, i + 3))) {
                return true;
            }
        }
        return false;
    }
}
