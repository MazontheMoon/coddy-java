/*
Create a function named decodeThiefMessage that receives int[] encodedMessage as its parameter.

A cunning thief has left a secret message in a sopping wet alleyway on a rainy night. The message is encoded as an array of integers, where each positive integer represents a binary number (in decimal form) that corresponds to an ASCII character. However, the rain has washed away some parts of the message, represented by negative numbers in the array.

Your task is to decode this message by converting each positive integer to its corresponding ASCII character and replacing the negative integers (damaged parts) with underscores. Follow these steps:

Iterate through the input array.
- For each positive integer:
- Convert it to its binary representation.
- Convert the binary to its corresponding ASCII character.
- For each negative integer, replace it with an underscore ('_').
- Combine all the decoded characters into a single string.

Parameters:
- encodedMessage (int[]): An array of integers where each element is either a positive integer (representing a valid binary number in decimal form) or a negative integer (representing a damaged part of the message).
The function returns a string representing the decoded message.

Constraints:
- The length of the input array will be between 1 and 100.
- Positive integers in the array will be in the range of 32 to 126 (inclusive), representing printable ASCII characters.
- Negative integers can be any negative value.
- Hint: To convert a decimal number to its ASCII character, you can use the following Java code:
  char asciiChar = (char) decimalNumber;

Note: Be careful when handling the conversion from decimal to binary. Make sure to pad the binary representation with leading zeros if necessary to ensure it has 7 bits (as ASCII uses 7-bit encoding).
*/

import java.util.Arrays;

class DecodeThiefMessage {
    public static String decodeThiefMessage(int[] encodedMessage) {
        StringBuilder decodedMessage = new StringBuilder();

        for (int num : encodedMessage) {
            if (num >= 0) {
                String binary = String.format("%7s", Integer.toBinaryString(num)).replace(' ', '0');
                int asciiValue = Integer.parseInt(binary, 2);
                decodedMessage.append((char) asciiValue);
            } else {
                decodedMessage.append('_');
            }
        }

        return decodedMessage.toString();
    }
}