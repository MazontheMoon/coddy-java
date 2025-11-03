/*
Create a function named analyzeDefoliation that receives trees as its parameter.

As a scientist studying defoliation patterns in a civilizational park, your task is to analyze an array of trees and generate a report on their leaf status.

Process each tree in the array, keeping track of different leaf statuses, and create a concatenated report.

Parameters:
- trees (String[]): An array of strings where each string represents a tree in the format "species:leafStatus". For example, ["oak:healthy", "maple:falling", "birch:bare"].

The function returns a string containing the concatenated report of the defoliation analysis.

Follow these steps to create your report:
- Iterate through the array of trees.
- For each tree, split the string to separate species and leaf status.
- Count the number of trees for each leaf status (healthy, falling, bare).
- If a tree's leaf status is "bare", immediately add its species to a list of concerning trees and continue to the next tree.
- If the leaf status is "falling", add its species to a watch list.
- Break the loop if more than half of the trees are bare.

Concatenate a report string with the following information:
- Total number of trees analyzed
- Number of healthy trees
- Number of trees with falling leaves
- Number of bare trees
- List of concerning trees (species only)
- Watch list (species only)
- Make sure to use proper string concatenation and basic control flow (break, continue) in your implementation.
 */

import java.util.ArrayList;
import java.util.List;

class AnalyzeDefoliation {
    public static String analyzeDefoliation(String[] trees) {
        int totalTrees = 0;
        int healthyTrees = 0;
        int fallingTrees = 0;
        int bareTrees = 0;
        List<String> concerningTrees = new ArrayList<>();
        List<String> watchList = new ArrayList<>();

        for (String tree : trees) {
            String[] parts = tree.split(":");
            String species = parts[0];
            String status = parts[1];

            totalTrees++;

            if (status.equals("healthy")) {
                healthyTrees++;
            } else if (status.equals("falling")) {
                fallingTrees++;
                watchList.add(species);
            } else if (status.equals("bare")) {
                bareTrees++;
                concerningTrees.add(species);
                if (bareTrees > totalTrees / 2) {
                    break;
                }
                continue;
            }
        }

        StringBuilder report = new StringBuilder();
        report.append("Total trees analyzed: ").append(totalTrees).append("\n");
        report.append("Healthy trees: ").append(healthyTrees).append("\n");
        report.append("Trees with falling leaves: ").append(fallingTrees).append("\n");
        report.append("Bare trees: ").append(bareTrees).append("\n");
        report.append("Concerning trees: ").append(String.join(", ", concerningTrees)).append("\n");
        report.append("Watch list: ").append(String.join(", ", watchList));

        return report.toString();
    }
}