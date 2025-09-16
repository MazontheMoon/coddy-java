/*
Create a function named reverseString that receives original as its parameter.

This function aims to reverse the given string, simulating the deciphering of mysterious runes found in an ancient cave during an exploration mission.

To reverse the string:
- Create an empty string to store the reversed string.
- Iterate through the characters of the original string in reverse order.
- Append each character to the reversed string.

The reversed string will reveal the true meaning of the ancient inscriptions, allowing you to unlock the secrets of the cave.

Parameters:
- original (String): The string to be reversed, representing the sequence of characters inscribed on the cave wall. It will only contain alphanumeric characters and can be up to 100 characters long.

The function returns the reversed version of the original string.
*/

class ReverseString {
    public static String reverseString(String original) {
        String reversed = "";
        for (int i = original.length() - 1; i >= 0; i--) {
            reversed += original.charAt(i);
        }
        return reversed;
    }
}