/*
Create a function named identifySeeds that receives binaryLabel as its parameter.

This function helps identify the type of seeds in a packet based on its binary label. A 1 indicates sunflower seeds, and a 0 indicates rose seeds.

The function should check if binaryLabel contains at least one '1'. If it does, return "sunflower". If it consists only of '0', return "rose".

Parameters:
- binaryLabel (String): A string containing only '0' and '1'.

The function returns a String, either "sunflower" or "rose".
*/

class IdentifySeeds {
    public static String identifySeeds(String binaryLabel) {
        if (binaryLabel.contains("1")) {
            return "sunflower";
        } else {
            return "rose";
        }
    }
}