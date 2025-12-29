/*Create a function named analyzePeatBogLayers that receives String[] layers and int minLength as its parameters.

You are a curious botanist exploring a peat bog, examining its unique ecosystem and ancient layers of decomposed plant material. Your task is to analyze the layers of the peat bog to identify palindromic and anagrammatic plant species names.

The function should analyze each layer of the peat bog, identifying palindromes, anagrams, and counting unique species. Here's a detailed breakdown of what the function should do:

Parse each layer of the peat bog (each element of the input array).
For each plant name longer than or equal to the minimum length:
Check if it's a palindrome (ignoring spaces and case).
Check if it forms an anagram with any other plant name in the same layer or different layers.
Keep track of unique species across all layers.
Use advanced control flow to optimize the process, such as breaking out of loops early when conditions are met.
Handle edge cases, such as empty layers or no names meeting the minimum length requirement.
Parameters:

layers (String[]): An array of strings, where each string represents a layer of the peat bog. Each layer is a comma-separated list of plant species names found in that layer.
minLength (int): The minimum length of plant names to consider for analysis.
The function returns a string that describes the findings in the following format:

"Palindromes: [list of palindromic names], Anagrams: [list of anagrammatic pairs], Unique Species: [count of unique species]"
Note:

Palindrome checking should ignore spaces and case.
Anagram checking should compare plant names across all layers.
The function should efficiently handle string parsing and manipulation.
Optimize your solution using appropriate control flow techniques.*/

import java.util.*;

class AnalyzePeatBogLayers {
    public static String analyzePeatBogLayers(String[] layers, int minLength) {
        Set<String> uniqueSpecies = new HashSet<>();
        Set<String> palindromes = new HashSet<>();
        Set<String> anagrams = new HashSet<>();
        Map<String, String> sortedToOriginal = new HashMap<>();

        for (String layer : layers) {
            String[] plants = layer.split(",");
            for (String plant : plants) {
                String trimmedPlant = plant.trim();
                if (trimmedPlant.length() >= minLength) {
                    uniqueSpecies.add(trimmedPlant.toLowerCase());

                    if (isPalindrome(trimmedPlant)) {
                        palindromes.add(trimmedPlant);
                    }

                    String sortedPlant = sortString(trimmedPlant.toLowerCase().replaceAll("\\s+", ""));
                    if (sortedToOriginal.containsKey(sortedPlant)) {
                        anagrams.add(sortedToOriginal.get(sortedPlant) + "," + trimmedPlant);
                    } else {
                        sortedToOriginal.put(sortedPlant, trimmedPlant);
                    }
                }
            }
        }

        return String.format("Palindromes: %s, Anagrams: %s, Unique Species: %d",
                palindromes, anagrams, uniqueSpecies.size());
    }

    private static boolean isPalindrome(String s) {
        String cleaned = s.toLowerCase().replaceAll("\\s+", "");
        int left = 0, right = cleaned.length() - 1;
        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private static String sortString(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
