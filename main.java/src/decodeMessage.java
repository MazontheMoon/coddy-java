/*
Create a function named decodeMessage that receives message as its parameter.

This function decodes a secret message by:
- Reversing the string.
- Replacing 'a' with '*'.
- Replacing 'm' with '#'.

Parameter:
- message (String): The encoded message consisting of lowercase alphabetical characters.

The function returns the decoded message as a String.
*/

class DecodeMessage {
    public static String decodeMessage(String message) {
        String reversed = new StringBuilder(message).reverse().toString();
        String decodedMessage = reversed.replace("a", "*").replace("m", "#");
        return decodedMessage;
    }
}