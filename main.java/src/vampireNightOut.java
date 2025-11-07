/*
Create a function named vampireNightOut that receives name, bloodTypes, and locations as its parameters.

Count Dracula needs your help to plan and document his nightly adventures. Your task is to implement a function that simulates a vampire's night out using advanced hashing techniques, string formatting, and control flow.

The function should use a custom hashing algorithm to determine which locations the vampire will visit based on their name. It should then create a detailed report of the vampire's night, including which locations were visited, how many victims of each blood type were encountered, and any special events that occurred.

Implement the following steps:
- Create a custom hash function to determine which locations to visit based on the vampire's name.
- Use advanced control flow to simulate the vampire's journey, including special cases like ending the night early if a favorite blood type is encountered.
- Format the output string to tell the story of the vampire's night out, including statistics and an ASCII art representation of the sabretache.

Parameters:
- name (String): The vampire's name.
- bloodTypes (int[]): An array of integers representing blood types of potential victims (1-8).
- locations (String[]): An array of strings representing locations in the city.

The function returns a formatted string that tells the story of the vampire's night out, including statistics on victims encountered and an ASCII representation of the vampire's sabretache.

Constraints:
- The vampire's name will contain only alphabetic characters and be between 3 and 20 characters long.
- Blood types will be represented by integers from 1 to 8.
- The number of locations will be between 3 and 10.
 The favorite blood type is always 1 (representing O-negative).

Note: Do not use any built-in hashing functions. Implement your own simple hashing algorithm for this challenge.
 */

import java.util.HashMap;
import java.util.Map;

class VampireNightOut {
    public static String vampireNightOut(String name, int[] bloodTypes, String[] locations) {
        StringBuilder report = new StringBuilder();
        Map<Integer, Integer> bloodTypeCount = new HashMap<>();
        int visitedLocations = 0;
        boolean favoriteBloodFound = false;

        // Custom hash function
        int hash = 0;
        for (char c : name.toCharArray()) {
            hash = (hash * 31 + c) % locations.length;
        }

        report.append("Count ").append(name).append("'s Night Out Report:\n\n");

        for (int i = 0; i < bloodTypes.length && !favoriteBloodFound; i++) {
            int currentLocation = (hash + i) % locations.length;
            int bloodType = bloodTypes[i];

            report.append("Location ").append(currentLocation + 1).append(": ").append(locations[currentLocation]).append("\n");
            report.append("Encountered victim with blood type ").append(bloodType).append("\n");

            bloodTypeCount.put(bloodType, bloodTypeCount.getOrDefault(bloodType, 0) + 1);
            visitedLocations++;

            if (bloodType == 1) {
                report.append("Favorite blood type found! Ending the night early.\n");
                favoriteBloodFound = true;
            }

            report.append("\n");
        }

        report.append("Night Summary:\n");
        report.append("Locations visited: ").append(visitedLocations).append("\n");
        report.append("Blood types encountered:\n");

        for (int i = 1; i <= 8; i++) {
            int count = bloodTypeCount.getOrDefault(i, 0);
            report.append("Type ").append(i).append(": ").append(count).append("\n");
        }

        report.append("\nVampire's Sabretache:\n");
        report.append("    _____\n");
        report.append("   /     \\\n");
        report.append("  /       \\\n");
        report.append(" |  BLOOD  |\n");
        report.append(" |   BAG   |\n");
        report.append("  \\       /\n");
        report.append("   \\_____/\n");

        return report.toString();
    }
}
