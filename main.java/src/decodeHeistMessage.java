/*
Create a function named decodeHeistMessage that receives encodedMessage as its parameter.

This function aims to decode a secret message passed between teammates during a heist. The message is encoded by reversing the original words. You need to reverse the string back to understand the original message and check if it contains any specific words indicating immediate actions like "run", "hide", or "escape".

To solve this challenge, you should:
- Reverse the encodedMessage to obtain the original decoded message.
- Check if the decoded message contains any of the action words: "run", "hide", or "escape" (case-sensitive).
- Return the decoded message and a boolean indicating if an immediate action is required.

Parameters:
- encodedMessage (String): A reversed string representing the encoded message during the heist. It will only consist of lowercase English letters and spaces.

The function returns an array with two elements:
- The decoded message (String)
- A boolean value indicating if the message contains an action word. It should be true if the message contains "run", "hide", or "escape"; false otherwise.
*/
import java.util.Arrays;

class DecodeHeistMessage {
    public static String[] decodeHeistMessage(String encodedMessage) {
        String decodedMessage = new StringBuilder(encodedMessage).reverse().toString();
        boolean actionRequired = Arrays.asList("run", "hide", "escape").stream()
                .anyMatch(decodedMessage::contains);
        return new String[]{decodedMessage, String.valueOf(actionRequired)};
    }
}