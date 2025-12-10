/*
Create a function named generateExhibitLabels that receives museum, prefixes, and currentYear as its parameters.

The function simulates a museum exhibit labeling system for a natural history museum. It generates descriptive labels for each exhibit by combining a prefix, the exhibit name, and a unique identifier based on its position in the museum layout and the current year.

Your task is to process the museum layout and create unique labels for each exhibit. Follow these steps:
- Iterate through each section of the museum (rows of the 2D array).
- For each exhibit in a section, create a label using this format: prefix + exhibitName + "-" + sectionIndex + exhibitIndex + lastTwoDigitsOfYear
- Use prefixes in a round-robin fashion. If you run out of prefixes, start over from the beginning.
- Replace the original exhibit name with the newly created label.

Parameters:
- museum (String[][]): A 2D array representing different sections of the museum. Each inner array contains string elements representing exhibit names.
- prefixes (String[]): An array of prefix strings to be used in labeling (e.g., "Dino-", "Fossil-", "Artifact-").
- currentYear (int): The current year, used in creating the unique identifier.

The function returns a new 2D string array with the same structure as the input museum, but with each exhibit name replaced by its generated label.

Constraints:
- The museum array will have at least 1 section and at most 10 sections.
- Each section will have at least 1 exhibit and at most 20 exhibits.
- Each exhibit name will be a non-empty string with a maximum length of 50 characters.
- The prefixes array will have at least 1 prefix and at most 5 prefixes.
- Each prefix will be a non-empty string with a maximum length of 10 characters.
- The currentYear will be a positive integer between 2000 and 9999.
*/

import java.util.Arrays;

class GenerateExhibitLabels {
    public static String[][] generateExhibitLabels(String[][] museum, String[] prefixes, int currentYear) {
        String[][] result = new String[museum.length][];
        int prefixIndex = 0;
        String year = String.valueOf(currentYear).substring(2);

        for (int i = 0; i < museum.length; i++) {
            result[i] = new String[museum[i].length];
            for (int j = 0; j < museum[i].length; j++) {
                String prefix = prefixes[prefixIndex];
                String label = prefix + museum[i][j] + "-" + i + j + year;
                result[i][j] = label;

                prefixIndex = (prefixIndex + 1) % prefixes.length;
            }
        }

        return result;
    }
}