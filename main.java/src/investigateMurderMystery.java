import java.util.*;

class InvestigateMurderMystery {
    public static String investigateMurderMystery(String[] crimeSceneEvidence, String[] suspectStatements, String[] witnessAccounts, String[] forensicResults, int detectiveMegrimIntensity) {
        Set<String> evidence = new HashSet<>(Arrays.asList(crimeSceneEvidence));
        Set<String> statements = new HashSet<>(Arrays.asList(suspectStatements));
        Set<String> accounts = new HashSet<>(Arrays.asList(witnessAccounts));
        Set<String> forensics = new HashSet<>(Arrays.asList(forensicResults));

        // Perform set operations
        Set<String> allEvidence = new HashSet<>(evidence);
        allEvidence.addAll(statements);
        allEvidence.addAll(accounts);
        allEvidence.addAll(forensics);

        Set<String> keyEvidence = new HashSet<>(evidence);
        keyEvidence.retainAll(forensics);

        Set<String> inconsistencies = new HashSet<>(statements);
        inconsistencies.removeAll(accounts);

        // Generate power set of key evidence
        List<Set<String>> powerSet = generatePowerSet(keyEvidence);

        // Calculate evidence strength
        int evidenceStrength = calculateEvidenceStrength(allEvidence, keyEvidence, inconsistencies);

        // Adjust analysis based on megrim intensity
        String suspectAnalysis = analyzeSuspects(statements, accounts, forensics, detectiveMegrimIntensity);
        String evidenceAnalysis = analyzeEvidence(keyEvidence, detectiveMegrimIntensity);
        String uncertaintyAnalysis = analyzeUncertainties(inconsistencies, detectiveMegrimIntensity);

        // Generate conclusion
        StringBuilder conclusion = new StringBuilder();
        conclusion.append("Based on the analysis of the evidence, ").append(suspectAnalysis).append("\n");
        conclusion.append("Key evidence: ").append(evidenceAnalysis).append("\n");
        conclusion.append("Uncertainties: ").append(uncertaintyAnalysis).append("\n");
        conclusion.append("Evidence strength: ").append(evidenceStrength).append(" out of 10\n");
        conclusion.append("Disclaimer: This investigation may be affected by the detective's megrim (intensity: ")
                  .append(detectiveMegrimIntensity).append(" out of 10).");

        return conclusion.toString();
    }

    private static List<Set<String>> generatePowerSet(Set<String> set) {
        List<Set<String>> powerSet = new ArrayList<>();
        powerSet.add(new HashSet<>());
        for (String item : set) {
            List<Set<String>> newSubsets = new ArrayList<>();
            for (Set<String> subset : powerSet) {
                Set<String> newSubset = new HashSet<>(subset);
                newSubset.add(item);
                newSubsets.add(newSubset);
            }
            powerSet.addAll(newSubsets);
        }
        return powerSet;
    }

    private static int calculateEvidenceStrength(Set<String> allEvidence, Set<String> keyEvidence, Set<String> inconsistencies) {
        int strength = keyEvidence.size() * 2 + allEvidence.size() - inconsistencies.size();
        return Math.min(Math.max(strength, 1), 10);
    }

    private static String analyzeSuspects(Set<String> statements, Set<String> accounts, Set<String> forensics, int megrimIntensity) {
        if (megrimIntensity > 7) {
            return "The detective's severe megrim prevents a clear analysis of suspects.";
        }
        Set<String> suspiciousStatements = new HashSet<>(statements);
        suspiciousStatements.removeAll(accounts);
        suspiciousStatements.retainAll(forensics);
        return suspiciousStatements.isEmpty() ? "No clear suspect identified." : "There are suspicious inconsistencies in some statements.";
    }

    private static String analyzeEvidence(Set<String> keyEvidence, int megrimIntensity) {
        if (megrimIntensity > 5) {
            return "The detective's megrim makes it difficult to focus on all key evidence.";
        }
        return keyEvidence.toString();
    }

    private static String analyzeUncertainties(Set<String> inconsistencies, int megrimIntensity) {
        if (megrimIntensity > 3) {
            return "The detective's megrim increases the difficulty in resolving inconsistencies.";
        }
        return inconsistencies.isEmpty() ? "No significant inconsistencies found." : "Some inconsistencies require further investigation.";
    }
}