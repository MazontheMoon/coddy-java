import java.util.*;

class SimulateDinosaurDigSite {
    public static String simulateDinosaurDigSite(int numSites, String[] fossilTypes, int numTrainees) {
        Map<Integer, List<String>> siteFossils = new HashMap<>();
        for (int i = 0; i < numSites; i++) {
            siteFossils.put(i, new ArrayList<>());
        }

        // Distribute fossils
        for (String fossil : fossilTypes) {
            int site = hash(fossil, numSites);
            siteFossils.get(site).add(fossil);
        }

        StringBuilder report = new StringBuilder();
        report.append("Dig Site Summary:\n");
        for (int i = 0; i < numSites; i++) {
            report.append(String.format("Site %d: %s\n", i + 1, String.join(", ", siteFossils.get(i))));
        }

        report.append("\nProbabilities:\n");
        for (String fossil : fossilTypes) {
            double probability = calculateProbability(numTrainees, siteFossils, fossil);
            report.append(String.format("%s: %.2f%%\n", fossil, probability * 100));
        }

        report.append("\nNew Recruit's Remark: \"Who knew digging up old bones could be so statistically complex?\"");

        return report.toString();
    }

    private static int hash(String s, int m) {
        int hash = 0;
        for (int i = 0; i < s.length(); i++) {
            hash = (hash * 31 + s.charAt(i)) % m;
        }
        return hash;
    }

    private static double calculateProbability(int numTrainees, Map<Integer, List<String>> siteFossils, String fossil) {
        int totalSites = siteFossils.size();
        int sitesWithFossil = 0;

        for (List<String> fossils : siteFossils.values()) {
            if (fossils.contains(fossil)) {
                sitesWithFossil++;
            }
        }

        // Probability of not finding the fossil
        double probNotFound = Math.pow((double) (totalSites - sitesWithFossil) / totalSites, numTrainees);
        return 1 - probNotFound;
    }
}
