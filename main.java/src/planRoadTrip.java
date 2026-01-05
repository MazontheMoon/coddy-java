import java.util.*;

class PlanRoadTrip {
    public static String[] planRoadTrip(String[] towns, String[] attractions, String[] familyPreferences, int maxDays, int maxTowns) {
        List<String> itinerary = new ArrayList<>();
        Set<String> townSet = new HashSet<>(Arrays.asList(towns));
        Set<String> attractionSet = new HashSet<>(Arrays.asList(attractions));
        Set<String> preferenceSet = new HashSet<>(Arrays.asList(familyPreferences));

        List<Set<String>> powerSet = generatePowerSet(townSet);
        List<List<String>> permutations = new ArrayList<>();

        int maxScore = -1;
        List<String> bestRoute = new ArrayList<>();

        for (Set<String> subset : powerSet) {
            if (subset.size() <= maxTowns && subset.size() > 0) {
                permutations.clear();
                generatePermutations(new ArrayList<>(subset), 0, permutations);

                for (List<String> route : permutations) {
                    int score = calculateScore(route, attractionSet, preferenceSet);
                    if (score > maxScore) {
                        maxScore = score;
                        bestRoute = route;
                    }
                }
            }
        }

        int day = 1;
        for (String town : bestRoute) {
            if (day > maxDays) break;
            String attraction = findBestAttraction(town, attractionSet, preferenceSet);
            itinerary.add("Day " + day + ": " + town + " - " + attraction);
            day++;
        }

        return itinerary.toArray(new String[0]);
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

    private static void generatePermutations(List<String> list, int start, List<List<String>> result) {
        if (start == list.size() - 1) {
            result.add(new ArrayList<>(list));
        } else {
            for (int i = start; i < list.size(); i++) {
                Collections.swap(list, start, i);
                generatePermutations(list, start + 1, result);
                Collections.swap(list, start, i);
            }
        }
    }

    private static int calculateScore(List<String> route, Set<String> attractions, Set<String> preferences) {
        int score = 0;
        Set<String> visitedAttractions = new HashSet<>();

        for (String town : route) {
            String attraction = findBestAttraction(town, attractions, preferences);
            if (!visitedAttractions.contains(attraction)) {
                score += preferences.contains(attraction) ? 2 : 1;
                visitedAttractions.add(attraction);
            }
        }

        return score;
    }

    private static String findBestAttraction(String town, Set<String> attractions, Set<String> preferences) {
        for (String preference : preferences) {
            if (attractions.contains(preference)) {
                return preference;
            }
        }
        return attractions.iterator().next();
    }
}
