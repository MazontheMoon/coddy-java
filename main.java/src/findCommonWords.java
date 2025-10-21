/*
Create a function named findCommonWords that receives sentence1 and sentence2 as its parameters.

This function identifies common words in both sentences, ignoring case and punctuation.

Steps:
- Split each sentence into words using space as the delimiter.
- Convert all words to lowercase.
- Find distinct words in both arrays.
- Sort the common words alphabetically.
- Return the sorted array of common words.

Parameters:
- sentence1 (String): The first sentence.
- sentence2 (String): The second sentence.
- Returns a String array of common words found in both sentences, sorted alphabetically, with each word appearing only once.
 */

import java.util.*;

class FindCommonWords {
    public static String[] findCommonWords(String sentence1, String sentence2) {
        String[] words1 = sentence1.toLowerCase().split(" ");
        String[] words2 = sentence2.toLowerCase().split(" ");

        Set<String> set1 = new HashSet<>(Arrays.asList(words1));
        Set<String> set2 = new HashSet<>(Arrays.asList(words2));

        set1.retainAll(set2);

        String[] commonWords = set1.toArray(new String[0]);
        Arrays.sort(commonWords);

        return commonWords;
    }
}