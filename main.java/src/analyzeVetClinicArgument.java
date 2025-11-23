/*
Create a function named analyzeVetClinicArgument that receives transcript as its parameter.

Your task is to analyze a heated argument that occurred at a veterinary clinic by processing a transcript of the conversation. You'll need to use advanced string parsing, hashing techniques, and array manipulation to extract meaningful information from the argument.

The function should perform the following operations:
- Parse the input string into individual statements.
- Identify the most frequent speaker using a hash map.
- Categorize each statement as a complaint, rebuttal, or apology using keyword matching.
- Count word frequencies and identify the top 3 most used words (excluding common stop words).
- Calculate a "heat index" for the argument based on the frequency of certain keywords and punctuation.
- Compile all this information into a structured summary.

Parameters:
- transcript (String): A string containing the entire conversation transcript. Each statement is separated by a newline character, and each statement starts with the speaker's name followed by a colon.

The function returns a String array containing a structured summary of the argument, including:
- The total number of statements made
- The most frequent speaker
- The most common type of phrase (complaint, rebuttal, or apology)
- The top 3 most used words (excluding common stop words)
A "heat index" of the argument (calculated based on the frequency of certain keywords and punctuation)

Note: You may assume the following:
- The input transcript will always be properly formatted with at least one statement.
- Names in the transcript will only contain alphabetic characters.
- Words are separated by spaces and may include basic punctuation (periods, commas, question marks, exclamation points).

For simplicity, you can use a predefined list of stop words and keywords for categorization.
Remember to use efficient data structures and algorithms to handle potentially large transcripts.
*/

import java.util.*;

class AnalyzeVetClinicArgument {
    private static final Set<String> STOP_WORDS = new HashSet<>(Arrays.asList("the", "a", "an", "and", "or", "but", "in", "on", "at", "to", "for", "of", "with", "by", "from", "up", "about", "into", "over", "after"));
    private static final Set<String> COMPLAINT_KEYWORDS = new HashSet<>(Arrays.asList("unacceptable", "ridiculous", "frustrated", "waiting", "inconvenience"));
    private static final Set<String> REBUTTAL_KEYWORDS = new HashSet<>(Arrays.asList("understand", "but", "however", "actually", "fact"));
    private static final Set<String> APOLOGY_KEYWORDS = new HashSet<>(Arrays.asList("sorry", "apologize", "regret", "forgive"));
    private static final Set<String> HEAT_KEYWORDS = new HashSet<>(Arrays.asList("unacceptable", "ridiculous", "immediately", "hours", "excuse"));

    public static String[] analyzeVetClinicArgument(String transcript) {
        String[] statements = transcript.split("\n");
        Map<String, Integer> speakerFrequency = new HashMap<>();
        Map<String, Integer> wordFrequency = new HashMap<>();
        int complaints = 0, rebuttals = 0, apologies = 0;
        int heatIndex = 0;

        for (String statement : statements) {
            String[] parts = statement.split(": ", 2);
            String speaker = parts[0];
            String content = parts[1].toLowerCase();

            speakerFrequency.put(speaker, speakerFrequency.getOrDefault(speaker, 0) + 1);

            if (containsAny(content, COMPLAINT_KEYWORDS)) complaints++;
            if (containsAny(content, REBUTTAL_KEYWORDS)) rebuttals++;
            if (containsAny(content, APOLOGY_KEYWORDS)) apologies++;

            for (String word : content.split("\\W+")) {
                if (!STOP_WORDS.contains(word)) {
                    wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
                }
            }

            heatIndex += content.split("!").length - 1;
            heatIndex += containsCount(content, HEAT_KEYWORDS);
        }

        String mostFrequentSpeaker = Collections.max(speakerFrequency.entrySet(), Map.Entry.comparingByValue()).getKey();
        String mostCommonType = getMostCommonType(complaints, rebuttals, apologies);
        List<String> topWords = getTopWords(wordFrequency, 3);

        return new String[] {
                "Total statements: " + statements.length,
                "Most frequent speaker: " + mostFrequentSpeaker,
                "Most common type: " + mostCommonType,
                "Top 3 words: " + String.join(", ", topWords),
                "Heat index: " + heatIndex
        };
    }

    private static boolean containsAny(String str, Set<String> keywords) {
        for (String keyword : keywords) {
            if (str.contains(keyword)) return true;
        }
        return false;
    }

    private static int containsCount(String str, Set<String> keywords) {
        int count = 0;
        for (String keyword : keywords) {
            if (str.contains(keyword)) count++;
        }
        return count;
    }

    private static String getMostCommonType(int complaints, int rebuttals, int apologies) {
        int max = Math.max(complaints, Math.max(rebuttals, apologies));
        if (max == complaints) return "complaint";
        if (max == rebuttals) return "rebuttal";
        return "apology";
    }

    private static List<String> getTopWords(Map<String, Integer> wordFrequency, int n) {
        return wordFrequency.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(n)
                .map(Map.Entry::getKey)
                .collect(java.util.stream.Collectors.toList());
    }
}