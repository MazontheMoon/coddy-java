/*Create a function named exploreHabitat that receives specialNumbers and creatureNames as its parameters.

This function generates a narrative describing the exploration of a habitat filled with mystical creatures. The narrative includes the count and names of the creatures spotted.

The specialNumbers array contains the count of each type of creature spotted, and the creatureNames array holds the corresponding names. The function should first verify if the lengths of both arrays match. If they don't, it should return "Invalid data". If the lengths match, the function should create a narrative by concatenating strings in the format: <number> <creature name> spotted. for each creature. Finally, it should combine these strings into a single narrative string, with each creature encounter separated by a comma and a space.

Parameters:

specialNumbers (int[]): An array of integers representing the count of each type of creature spotted.
creatureNames (String[]): An array of strings containing the names of creatures corresponding to the numbers in the specialNumbers array.
The function returns a single string containing the formatted narrative of the exploration based on the given arrays.*/

class ExploreHabitat {
    public static String exploreHabitat(int[] specialNumbers, String[] creatureNames) {
        if (specialNumbers.length != creatureNames.length) {
            return "Invalid data";
        }
        
        StringBuilder narrative = new StringBuilder();
        
        for (int i = 0; i < specialNumbers.length; i++) {
            narrative.append(specialNumbers[i])
                    .append(" ")
                    .append(creatureNames[i])
                    .append(" spotted.");
            
            if (i < specialNumbers.length - 1) {
                narrative.append(", ");
            }
        }
        
        return narrative.toString();
    }
}
