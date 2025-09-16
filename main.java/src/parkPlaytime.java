/*
Create a function named parkPlaytime that receives names and activities as its parameters.

This function combines each child's name with their favorite park activity to create a playful message.

Iterate through the names and activities arrays, concatenating each name with its corresponding activity, separated by a space. Return the final concatenated string.

If the number of names and activities is not the same, combine up to the length of the shorter array.

Parameters:
- names (String[]): An array of children's names.
- activities (String[]): An array of activities each child enjoys (e.g., "swings", "slides").

Returns a String: the concatenated message of each child's name and their favorite activity, separated by spaces.
*/

class ParkPlaytime {
    public static String parkPlaytime(String[] names, String[] activities) {
        StringBuilder result = new StringBuilder();
        int length = Math.min(names.length, activities.length);

        for (int i = 0; i < length; i++) {
            result.append(names[i]).append(" ").append(activities[i]).append(" ");
        }

        return result.toString().trim();
    }
}