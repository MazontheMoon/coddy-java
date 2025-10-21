/*
Create a function named countSteps that receives directions and maxSteps as its parameters.

Your task is to simulate a journey by following the directions on a map and counting the steps taken. You need to parse the directions and keep track of the total steps, ensuring you don't exceed the maximum allowed steps.

The directions are provided as a string, where each instruction is separated by a comma. Each instruction is in the format "XdY", where X is the number of steps to take, and Y is the direction (N for North, S for South, E for East, W for West).

Parameters:
- directions (String): A string containing comma-separated instructions for the journey.
- maxSteps (int): The maximum number of steps allowed for the journey.

The function should return an integer representing the total number of steps taken during the journey. If the total steps would exceed maxSteps, the journey should end early, and the function should return the number of steps taken up to that point.

Here's how to approach the problem:

Split the directions string into individual instructions.
Initialize a variable to keep track of the total steps.
For each instruction:
Extract the number of steps using the substring before 'd'.
Add these steps to the total.
If the total exceeds maxSteps, break the loop and return the steps taken so far.
After processing all instructions, return the total steps taken.
Remember to use appropriate control flow statements like loops and conditionals, and utilize string manipulation methods to extract the necessary information from each instruction.
 */

import java.util.Arrays;

class CountSteps {
    public static int countSteps(String directions, int maxSteps) {
        String[] instructions = directions.split(",");
        int totalSteps = 0;

        for (String instruction : instructions) {
            int steps = Integer.parseInt(instruction.substring(0, instruction.indexOf('d')));
            if (totalSteps + steps > maxSteps) {
                return maxSteps;
            }
            totalSteps += steps;
        }

        return totalSteps;
    }
}