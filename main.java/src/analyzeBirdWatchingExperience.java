/*
Create a function named analyzeBirdWatchingExperience that receives String[] swiftletBehaviors and String[] emotionalResponses as its parameters.

As a passionate bird watcher observing swiftlets in their natural habitat, you're experiencing a range of emotions. Your task is to analyze your observations and emotional responses.

The function should process the arrays as follows:
- Count the total number of observations (length of the input arrays).
- Find the most common swiftlet behavior.
- Determine the most frequent emotional response.
- If the emotion "bored" is encountered, skip to the next iteration.
- If the emotion "overwhelmed" is encountered, end the observation early.
- Concatenate the results into a single string array with three elements: total observations, most common behavior, and most frequent emotion.

Parameters:
- swiftletBehaviors (String[]): An array of observed swiftlet behaviors (e.g., "flying", "nesting", "feeding").
- emotionalResponses (String[]): An array of the bird watcher's emotional responses to each behavior (e.g., "excited", "bored", "anxious").

The function returns a String array containing a summary of the bird watching experience, including the total number of observations, the most common behavior, and the most frequent emotion.
*/

import java.util.HashMap;
import java.util.Map;

class AnalyzeBirdWatchingExperience {
    public static String[] analyzeBirdWatchingExperience(String[] swiftletBehaviors, String[] emotionalResponses) {
        int totalObservations = 0;
        Map<String, Integer> behaviorCount = new HashMap<>();
        Map<String, Integer> emotionCount = new HashMap<>();

        for (int i = 0; i < swiftletBehaviors.length; i++) {
            if (i < emotionalResponses.length) {
                if (emotionalResponses[i].equals("overwhelmed")) {
                    break;
                }
                if (emotionalResponses[i].equals("bored")) {
                    continue;
                }
                emotionCount.put(emotionalResponses[i], emotionCount.getOrDefault(emotionalResponses[i], 0) + 1);
            }
            behaviorCount.put(swiftletBehaviors[i], behaviorCount.getOrDefault(swiftletBehaviors[i], 0) + 1);
            totalObservations++;
        }

        String mostCommonBehavior = getMostCommon(behaviorCount);
        String mostFrequentEmotion = getMostCommon(emotionCount);

        return new String[] {
                String.valueOf(totalObservations),
                mostCommonBehavior,
                mostFrequentEmotion
        };
    }

    private static String getMostCommon(Map<String, Integer> map) {
        String mostCommon = "";
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostCommon = entry.getKey();
            }
        }

        return mostCommon;
    }
}