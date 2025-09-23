/*
Create a function named createTrailMessage that receives words and indices as its parameters.

This function aims to generate a message from a list of words and a set of integer indices that hikers come across on signposts while hiking through a forest.

The words parameter is an array of strings representing words found in a guidebook. The indices parameter is an array of integers representing positions of these words to create a coherent message.

To create the message, concatenate the words from the words array in the order specified by the indices array. For example, if words is ["Stay", "left", "right", "safe", "and", "dry"] and indices is [0, 4, 1, 2, 3], the resulting message would be "Stay and left right safe".

Parameters:
- words (String[]): An array of strings representing words found in a guidebook.
- indices (int[]): An array of integers representing positions of the words to create a coherent message.
The function returns a string representing the generated message.
 */

class CreateTrailMessage {
    public static String createTrailMessage(String[] words, int[] indices) {
        StringBuilder message = new StringBuilder();
        for (int index : indices) {
            if (index >= 0 && index < words.length) {
                message.append(words[index]).append(" ");
            }
        }
        return message.toString().trim();
    }
}