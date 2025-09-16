/*
Create a function named simulatePufferfishInflation that receives initialSize and startleCount as its parameters.

The function simulates a pufferfish's inflation behavior in an aquarium laboratory. Each time the pufferfish is startled, it inflates slightly, increasing its size.

Use a loop to simulate multiple startle events and string concatenation to create a visual representation of the pufferfish's changing size. The pufferfish should be represented using ASCII characters, where "" represents the initial size, and it grows by adding more "O" characters inside the brackets as it inflates (e.g., "", "", etc.).

Parameters:
- initialSize (int): The initial size of the pufferfish, represented by the number of "o" characters.
- startleCount (int): The number of times the pufferfish gets startled and inflates.

The function returns a string that shows the pufferfish's size changing over time, with each stage separated by a space.

For example, if initialSize is 1 and startleCount is 3, the function should return: " "
*/

class SimulatePufferfishInflation {
    public static String simulatePufferfishInflation(int initialSize, int startleCount) {
        StringBuilder result = new StringBuilder();
        StringBuilder fish = new StringBuilder();

        // Create initial pufferfish
        fish.append("<");
        for (int i = 0; i < initialSize; i++) {
            fish.append("o");
        }
        fish.append(">");

        // Add initial size to result
        result.append(fish);

        // Simulate inflation
        for (int i = 0; i < startleCount; i++) {
            fish.insert(fish.length() - 1, "O");
            result.append(" ").append(fish);
        }

        return result.toString();
    }
}