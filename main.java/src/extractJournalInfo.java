/*
Create a function named extractJournalInfo that receives journalTitles, journalContents, maxExtractLength, and keywordToSkip as its parameters.

The function simulates Tess's browsing experience in the library, processing a collection of journal titles and their contents, and extracting specific information based on certain criteria.

The function should perform the following operations:
- Iterate through the journalTitles and journalContents arrays simultaneously.

For each journal:
- Check if the keywordToSkip is present in the title. If so, use 'continue' to skip to the next journal.
- Extract the first letter of each word in the title and concatenate them to form an acronym.
- Find the first sentence in the journal content that contains a number.
- If the sentence is longer than maxExtractLength, truncate it and add "..." at the end.
- Concatenate the acronym, a colon, and the extracted sentence.
- Join all the processed journal information with " | " as a separator.
- If the total length of the result exceeds 500 characters, use 'break' to stop processing more journals.
- Return the final concatenated string.

Parameters:
- journalTitles (String[]): An array of journal titles.
- journalContents (String[]): An array of journal contents, each corresponding to a title.
- maxExtractLength (int): The maximum length of extracted content.
- keywordToSkip (String): A keyword that, if present in a title, should cause the function to skip that journal.

The function returns a String containing the concatenated and processed information from the journals.

Note: Ensure that your implementation handles potential edge cases, such as empty arrays or mismatched array lengths. Also, make sure to use efficient string manipulation techniques to stay within the solution line constraints.
 */

import java.util.ArrayList;
import java.util.List;

class ExtractJournalInfo {
    public static String extractJournalInfo(String[] journalTitles, String[] journalContents, int maxExtractLength, String keywordToSkip) {
        List<String> result = new ArrayList<>();
        StringBuilder finalResult = new StringBuilder();

        for (int i = 0; i < journalTitles.length && i < journalContents.length; i++) {
            if (journalTitles[i].toLowerCase().contains(keywordToSkip.toLowerCase())) {
                continue;
            }

            String acronym = createAcronym(journalTitles[i]);
            String extractedSentence = extractSentenceWithNumber(journalContents[i]);

            if (extractedSentence.length() > maxExtractLength) {
                extractedSentence = extractedSentence.substring(0, maxExtractLength) + "...";
            }

            String journalInfo = acronym + ": " + extractedSentence;
            result.add(journalInfo);

            finalResult.append(journalInfo);
            if (i < journalTitles.length - 1) {
                finalResult.append(" | ");
            }

            if (finalResult.length() > 500) {
                break;
            }
        }

        return finalResult.toString();
    }

    private static String createAcronym(String title) {
        StringBuilder acronym = new StringBuilder();
        for (String word : title.split("\\s+")) {
            if (!word.isEmpty()) {
                acronym.append(Character.toUpperCase(word.charAt(0)));
            }
        }
        return acronym.toString();
    }

    private static String extractSentenceWithNumber(String content) {
        String[] sentences = content.split("[.!?]+");
        for (String sentence : sentences) {
            if (sentence.matches(".*\\d+.*")) {
                return sentence.trim();
            }
        }
        return "";
    }
}