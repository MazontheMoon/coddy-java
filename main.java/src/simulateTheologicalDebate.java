/*
Create a function named simulateTheologicalDebate that receives String[] arguments and int maxRebuttals as its parameters.

The function simulates a spirited theological debate in a university lecture hall by processing an array of arguments. It should manipulate the array and use control flow to represent the flow of the debate.

The function should process the arguments as follows:
- Remove any argument that is less than 5 characters long (considered too weak).
- Capitalize any argument that contains the word "God" or "faith" (case-insensitive, considered emphatic points).
- Stop the debate if the number of processed arguments exceeds maxRebuttals.

Parameters:
- arguments (String[]): An array of strings representing different theological points.
- maxRebuttals (int): An integer representing the maximum number of back-and-forth exchanges allowed in the debate.

The function returns a String array representing the processed arguments after the debate simulation.
*/

import java.util.ArrayList;
import java.util.List;

class SimulateTheologicalDebate {
    public static String[] simulateTheologicalDebate(String[] arguments, int maxRebuttals) {
        List<String> processedArguments = new ArrayList<>();
        int rebuttals = 0;

        for (String argument : arguments) {
            if (rebuttals >= maxRebuttals) {
                break;
            }

            if (argument.length() < 5) {
                continue;
            }

            String lowercaseArg = argument.toLowerCase();
            if (lowercaseArg.contains("god") || lowercaseArg.contains("faith")) {
                argument = argument.toUpperCase();
            }

            processedArguments.add(argument);
            rebuttals++;
        }

        return processedArguments.toArray(new String[0]);
    }
}