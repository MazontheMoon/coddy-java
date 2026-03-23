
import java.util.*;

class DockEncounter {
    public static String dockEncounter(int[] sailorMood, String[] birdTraits, String[] dockItems, String[] weatherConditions, int timeOfDay) {
        Set<Integer> moodSet = new HashSet<>();
        for (int mood : sailorMood) moodSet.add(mood);
        Set<String> traitSet = new HashSet<>(Arrays.asList(birdTraits));
        Set<String> itemSet = new HashSet<>(Arrays.asList(dockItems));
        Set<String> weatherSet = new HashSet<>(Arrays.asList(weatherConditions));

        Set<String> allTraitsAndItems = new HashSet<>(traitSet);
        allTraitsAndItems.addAll(itemSet);

        Set<String> commonTraitsAndItems = new HashSet<>(traitSet);
        commonTraitsAndItems.retainAll(itemSet);

        Set<String> uniqueTraits = new HashSet<>(traitSet);
        uniqueTraits.removeAll(itemSet);

        Set<String> uniqueItems = new HashSet<>(itemSet);
        uniqueItems.removeAll(traitSet);

        int contextScore = calculateContextScore(moodSet, traitSet, itemSet, weatherSet, timeOfDay);

        StringBuilder result = new StringBuilder();

        if (contextScore > 10) {
            result.append("The grumpy old sailor's curiosity is piqued. ");
        } else if (contextScore < 5) {
            result.append("The sailor grumbles and ignores the bird. ");
        } else {
            result.append("The sailor eyes the bird suspiciously. ");
        }

        if (uniqueTraits.contains("curious") && uniqueItems.contains("fish")) {
            result.append("The bird hops closer, eyeing the fish. ");
        }

        if (weatherSet.contains("sunny") && timeOfDay > 12 && timeOfDay < 18) {
            result.append("The afternoon sun casts long shadows on the dock. ");
        }

        if (moodSet.contains(1) && commonTraitsAndItems.size() > 0) {
            result.append("Despite his mood, the sailor finds the bird's interest in ");
            result.append(commonTraitsAndItems.iterator().next()).append(" amusing. ");
        }

        int powerSetSize = 1 << allTraitsAndItems.size();
        if (powerSetSize > 16) {
            result.append("The complexity of the situation overwhelms the sailor. ");
        }

        return result.toString().trim();
    }

    private static int calculateContextScore(Set<Integer> moodSet, Set<String> traitSet, Set<String> itemSet, Set<String> weatherSet, int timeOfDay) {
        int score = 0;
        score += moodSet.size() * 2;
        score += traitSet.size() * 3;
        score += itemSet.size();
        score += weatherSet.size() * 2;
        score += (timeOfDay >= 6 && timeOfDay <= 18) ? 5 : 2;
        return score;
    }
}
