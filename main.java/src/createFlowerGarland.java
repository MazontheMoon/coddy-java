/*
Create a function named createFlowerGarland that receives flowerNames and garlandLength as its parameters.

This function creates a flower garland by repeating the pattern of flowers from the flowerNames array until the desired garlandLength is reached.

Start with an empty string. Iterate through the flowerNames array, appending each flower name to the garland string followed by a hyphen ('-'). Repeat the pattern from the beginning of the flowerNames array when you reach the end, until the length of the garland string (excluding the last hyphen) is equal to or greater than garlandLength. Finally, return the garland string with the trailing hyphen removed.

Parameters:
- flowerNames (String[]): An array of strings representing the names of the flowers to be used in the garland.
- garlandLength (int): An integer representing the desired length of the flower garland.

The function returns a String representing the completed flower garland, with flowers arranged in a repeating pattern until the garlandLength is reached.
*/

class CreateFlowerGarland {
    public static String createFlowerGarland(String[] flowerNames, int garlandLength) {
        StringBuilder garland = new StringBuilder();
        int index = 0;

        while (garland.length() < garlandLength) {
            garland.append(flowerNames[index]).append("-");
            index = (index + 1) % flowerNames.length;
        }

        return garland.substring(0, garland.length() - 1);
    }
}