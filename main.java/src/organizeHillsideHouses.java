/*
Create a function named organizeHillsideHouses that receives houseNames and houseSizes as its parameters.

You are tasked with organizing houses on a hillside in a quaint townsite nestled on a banked hillside overlooking a serene valley. The organization is based on the houses' names and sizes.

The function should return a string array with the houses organized based on the following criteria:
- Houses with names starting with vowels (A, E, I, O, U) should be placed at the top of the hillside.
- Houses with names starting with consonants should be placed at the bottom of the hillside.
- Within each group (vowel-starting and consonant-starting), houses should be sorted based on their size in descending order (largest to smallest).

Parameters:
- houseNames (String[]): An array of house names. Each name is a non-empty string containing only letters (A-Z, case-insensitive).
- houseSizes (int[]): An array of house sizes in square meters. Each size is a positive integer.

The function returns a String[] representing the organized list of house names.

Note: The input arrays will always have the same length, and there will be at least one house.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class OrganizeHillsideHouses {
    public static String[] organizeHillsideHouses(String[] houseNames, int[] houseSizes) {
        int n = houseNames.length;
        House[] houses = new House[n];
        for (int i = 0; i < n; i++) {
            houses[i] = new House(houseNames[i], houseSizes[i]);
        }

        List<House> vowelHouses = new ArrayList<>();
        List<House> consonantHouses = new ArrayList<>();

        for (House house : houses) {
            if (isVowel(house.name.charAt(0))) {
                vowelHouses.add(house);
            } else {
                consonantHouses.add(house);
            }
        }

        vowelHouses.sort(Comparator.comparingInt((House h) -> h.size).reversed());
        consonantHouses.sort(Comparator.comparingInt((House h) -> h.size).reversed());

        String[] result = new String[n];
        int index = 0;

        for (House house : vowelHouses) {
            result[index++] = house.name;
        }

        for (House house : consonantHouses) {
            result[index++] = house.name;
        }

        return result;
    }

    private static boolean isVowel(char c) {
        return "AEIOUaeiou".indexOf(c) != -1;
    }

    private static class House {
        String name;
        int size;

        House(String name, int size) {
            this.name = name;
            this.size = size;
        }
    }
}