/*
Create a function named decipherText that receives text as its parameter.

This function aims to decipher an ancient text by reversing the order of its words while omitting any uppercase words.

The function should split the input text into individual words, remove any uppercase words, and then reassemble the remaining words in reverse order.

Parameters:
- text (String): The encoded text to be deciphered, consisting of lowercase and uppercase words separated by spaces.

The function returns a String representing the deciphered text, with the words in reverse order and all uppercase words omitted.
 */

import java.util.*;

class DecipherText {
    public static String decipherText(String text) {
        String[] words = text.split(" ");
        List<String> decipheredWords = new ArrayList<>();

        for (String word : words) {
            if (!word.equals(word.toUpperCase())) {
                decipheredWords.add(word);
            }
        }

        Collections.reverse(decipheredWords);

        return String.join(" ", decipheredWords);
    }
}