import java.util.*;
import java.util.stream.*;

class ExploreAncientLibrary {
    public static String exploreAncientLibrary(String[] initialBooks, String[] libraryBooks, int explorationRounds, String[] keywords, int[][] bookRelations) {
        Set<String> knowledge = new HashSet<>(Arrays.asList(initialBooks));
        Set<String> library = new HashSet<>(Arrays.asList(libraryBooks));
        Set<Set<String>> powerSet = generatePowerSet(knowledge);
        int score = 0;

        for (int round = 0; round < explorationRounds; round++) {
            Set<String> newDiscoveries = new HashSet<>();

            for (Set<String> subset : powerSet) {
                newDiscoveries.addAll(symmetricDifference(subset, library));
            }

            newDiscoveries = filterByKeywords(newDiscoveries, keywords);
            knowledge.addAll(newDiscoveries);

            updateKnowledgeFromRelations(knowledge, libraryBooks, bookRelations);

            score += calculateScore(knowledge, newDiscoveries, keywords, bookRelations, libraryBooks);

            powerSet = generatePowerSet(knowledge);
        }

        return generateExplorationResult(knowledge, score, libraryBooks);
    }

    private static Set<Set<String>> generatePowerSet(Set<String> set) {
        Set<Set<String>> powerSet = new HashSet<>();
        powerSet.add(new HashSet<>());
        for (String item : set) {
            Set<Set<String>> newSubsets = new HashSet<>();
            for (Set<String> subset : powerSet) {
                Set<String> newSubset = new HashSet<>(subset);
                newSubset.add(item);
                newSubsets.add(newSubset);
            }
            powerSet.addAll(newSubsets);
        }
        return powerSet;
    }

    private static Set<String> symmetricDifference(Set<String> set1, Set<String> set2) {
        Set<String> symmetricDiff = new HashSet<>(set1);
        symmetricDiff.addAll(set2);
        Set<String> tmp = new HashSet<>(set1);
        tmp.retainAll(set2);
        symmetricDiff.removeAll(tmp);
        return symmetricDiff;
    }

    private static Set<String> filterByKeywords(Set<String> books, String[] keywords) {
        return books.stream()
                .filter(book -> Arrays.stream(keywords).anyMatch(book::contains))
                .collect(Collectors.toSet());
    }

    private static void updateKnowledgeFromRelations(Set<String> knowledge, String[] libraryBooks, int[][] bookRelations) {
        for (int[] relation : bookRelations) {
            if (Arrays.stream(relation).allMatch(i -> knowledge.contains(libraryBooks[i]))) {
                knowledge.addAll(Arrays.stream(relation).mapToObj(i -> libraryBooks[i]).collect(Collectors.toSet()));
            }
        }
    }

    private static int calculateScore(Set<String> knowledge, Set<String> newDiscoveries, String[] keywords, int[][] bookRelations, String[] libraryBooks) {
        int score = knowledge.size() + newDiscoveries.size() * 2;
        score += (int) knowledge.stream().filter(book -> Arrays.asList(keywords).contains(book)).count() * 3;
        score += (int) Arrays.stream(bookRelations)
                .filter(relation -> Arrays.stream(relation).allMatch(i -> knowledge.contains(libraryBooks[i])))
                .count() * 5;
        return score;
    }

    private static String generateExplorationResult(Set<String> knowledge, int score, String[] libraryBooks) {
        StringBuilder result = new StringBuilder();
        result.append("Exploration complete! \n");
        result.append("Total knowledge acquired: ").append(knowledge.size()).append(" books\n");
        result.append("Rare books discovered: ").append(knowledge.stream().filter(book -> !Arrays.asList(libraryBooks).contains(book)).count()).append("\n");
        result.append("Final score: ").append(score).append("\n");

        if (score > 100) {
            result.append("You've uncovered ancient secrets and solved the library's greatest mysteries!");
        } else if (score > 50) {
            result.append("You've made significant discoveries and are on the path to greater knowledge.");
        } else {
            result.append("You've scratched the surface of the library's secrets. Keep exploring!");
        }

        return result.toString();
    }
}
