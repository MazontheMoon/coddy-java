import java.util.*;
import java.util.regex.*;

class AnalyzeNatureHike {
    public static String analyzeNatureHike(String fieldNotes) {
        Map<String, List<Observation>> categories = new HashMap<>();
        Set<String> locations = new HashSet<>();
        int totalObservations = 0;

        String[] observations = fieldNotes.split(";");
        for (String obs : observations) {
            obs = obs.trim();
            if (!obs.isEmpty()) {
                Observation observation = parseObservation(obs);
                categories.computeIfAbsent(observation.category, k -> new ArrayList<>()).add(observation);
                locations.add(observation.location);
                totalObservations++;
            }
        }

        StringBuilder report = new StringBuilder();
        report.append(String.format("Total number of observations: %d\n\n", totalObservations));

        for (String category : categories.keySet()) {
            List<Observation> categoryObservations = categories.get(category);
            int categoryCount = categoryObservations.size();
            int totalIndividuals = categoryObservations.stream().mapToInt(o -> o.count).sum();
            String mostCommonSpecies = findMostCommonSpecies(categoryObservations);

            report.append(String.format("%s:\n", category));
            report.append(String.format("  Number of observations: %d\n", categoryCount));
            report.append(String.format("  Most common species: %s\n", mostCommonSpecies));
            report.append(String.format("  Total count of individuals: %d\n\n", totalIndividuals));
        }

        report.append("Unique locations visited:\n");
        for (String location : locations) {
            report.append(String.format("  %s\n", location));
        }

        return report.toString().trim();
    }

    private static Observation parseObservation(String obs) {
        Pattern pattern = Pattern.compile("(\\w+):\\s*([^,]+),\\s*(\\d+),\\s*(.+)");
        Matcher matcher = pattern.matcher(obs);
        if (matcher.find()) {
            String category = matcher.group(1);
            String species = matcher.group(2);
            int count = Integer.parseInt(matcher.group(3));
            String location = matcher.group(4);
            return new Observation(category, species, count, location);
        }
        throw new IllegalArgumentException("Invalid observation format: " + obs);
    }

    private static String findMostCommonSpecies(List<Observation> observations) {
        Map<String, Integer> speciesCount = new HashMap<>();
        for (Observation obs : observations) {
            speciesCount.put(obs.species, speciesCount.getOrDefault(obs.species, 0) + obs.count);
        }
        return Collections.max(speciesCount.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    private static class Observation {
        String category;
        String species;
        int count;
        String location;

        Observation(String category, String species, int count, String location) {
            this.category = category;
            this.species = species;
            this.count = count;
            this.location = location;
        }
    }
}
