/*
Create a function named calculateMineralEssence that receives mineralBinary and addScrub as its parameters.

This function aims to calculate the essence value of a mineral based on its binary representation and the optional addition of a beechnut scrub.

To determine the mineral's essence value:
- Convert the mineralBinary string from binary to its decimal equivalent.
- If addScrub is true, increase the decimal value by 1 to account for the added essence of the beechnut scrub.
- The function should return the final calculated essence value as an integer.

Parameters:
- mineralBinary (String): A string representing the binary number of the mineral. It should only contain '0' and '1' characters.
- addScrub (boolean): Indicates whether to include the beechnut scrub, thereby increasing the essence value by 1.
The function returns an integer representing the calculated essence value of the mineral.
*/

class CalculateMineralEssence {
    public static int calculateMineralEssence(String mineralBinary, boolean addScrub) {
        int decimalValue = Integer.parseInt(mineralBinary, 2);
        if (addScrub) {
            decimalValue++;
        }
        return decimalValue;
    }
}