import java.util.*;

class AnalyzeProjects {
    public static String analyzeProjects(String[] projectDetails) {
        int plantDiseaseCount = 0;
        int viralInfectionCount = 0;
        Map<String, Integer> organismCount = new HashMap<>();
        int maxComplexity = 0;
        String highestComplexityProject = "";

        for (String project : projectDetails) {
            String[] parts = project.split(":");
            String studentName = parts[0].trim();
            String[] titleAndFindings = parts[1].split("-");
            String projectTitle = titleAndFindings[0].trim();
            String keyFindings = titleAndFindings[1].trim();

            if (projectTitle.toLowerCase().contains("blight") || 
                projectTitle.toLowerCase().contains("rust") || 
                projectTitle.toLowerCase().contains("rot")) {
                plantDiseaseCount++;
            } else if (projectTitle.toLowerCase().contains("virus")) {
                viralInfectionCount++;
            }

            String organism = extractOrganism(projectTitle);
            organismCount.put(organism, organismCount.getOrDefault(organism, 0) + 1);

            int complexity = calculateComplexity(projectTitle + " " + keyFindings);
            if (complexity > maxComplexity) {
                maxComplexity = complexity;
                highestComplexityProject = studentName + " - " + projectTitle;
            }
        }

        String mostCommonOrganism = getMostCommonOrganism(organismCount);

        return String.format("Plant Disease Projects: %d\nViral Infection Projects: %d\nMost Common Organism: %s\nHighest Complexity Project: %s (Score: %d)",
                plantDiseaseCount, viralInfectionCount, mostCommonOrganism, highestComplexityProject, maxComplexity);
    }

    private static String extractOrganism(String projectTitle) {
        String[] words = projectTitle.split(" ");
        for (String word : words) {
            if (!word.equalsIgnoreCase("blight") && !word.equalsIgnoreCase("virus") &&
                !word.equalsIgnoreCase("genome") && !word.equalsIgnoreCase("protein") &&
                !word.equalsIgnoreCase("structure") && !word.equalsIgnoreCase("analysis")) {
                return word;
            }
        }
        return "Unknown";
    }

    private static int calculateComplexity(String text) {
        int score = 0;
        String lowerText = text.toLowerCase();
        score += 2 * (countOccurrences(lowerText, "genome") + 
                      countOccurrences(lowerText, "mutation") + 
                      countOccurrences(lowerText, "protein"));
        score += countOccurrences(lowerText, "analysis") + 
                 countOccurrences(lowerText, "structure") + 
                 countOccurrences(lowerText, "mechanism");
        return score;
    }

    private static int countOccurrences(String text, String word) {
        return text.split(word, -1).length - 1;
    }

    private static String getMostCommonOrganism(Map<String, Integer> organismCount) {
        return Collections.max(organismCount.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}
