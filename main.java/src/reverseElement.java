/*
Create a function named reverseElement that receives elementName as its parameter.

You are a curious chemist working in a peaceful laboratory filled with colorful solutions and gleaming glassware. Your latest experiment involves reversing the names of chemical elements with a special twist.

Your task is to reverse the input string (the name of a chemical element) and modify it as follows:

Reverse the entire string.
- Capitalize the first letter of the reversed string.
- Convert the rest of the letters to lowercase.

Parameters:
- elementName (String): The name of a chemical element. It will contain only alphabetic characters and will have a length between 1 and 100 characters.

The function returns a String, which is the reversed and modified element name.
*/

import java.util.Scanner;

class ReverseElement {
    public static String reverseElement(String elementName) {
        StringBuilder reversed = new StringBuilder(elementName.toLowerCase()).reverse();
        return Character.toUpperCase(reversed.charAt(0)) + reversed.substring(1);
    }
}