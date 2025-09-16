/*
Create a function named reverseChemicalSequence that receives elements and masses as its parameters.

Imagine you're in Mr. Oxid's chemistry class, where he's teaching about oxidation and the importance of understanding chemical processes in reverse. Inspired by his lesson, you need to create a program that reverses a sequence of chemical elements while maintaining their relationship with their atomic masses.
Your task is to reverse the order of chemical elements in the elements array. The masses array contains the corresponding atomic masses for each element, which you'll use to ensure the correct reversal order. However, you should only return the reversed elements array.

Parameters:
- elements (String[]): An array of chemical element symbols. The length of this array will be between 1 and 1000.
- masses (float[]): An array of corresponding atomic masses. This array will have the same length as the elements array.

The function returns a String[] representing the reversed order of chemical elements.

Important Notes:
- Always create and return a new array; do not modify the input array.
- Ensure that the relationship between elements and their masses is maintained in the reversal process.
- Handle edge cases such as an array with a single element or empty arrays.
- Remember Mr. Oxid's stern words: "Just as in oxidation reactions, the sequence matters! Reversing the process helps us understand it better, but we must always maintain the integrity of our elements and their masses!"
*/

import java.util.Arrays;

class ReverseChemicalSequence {
    public static String[] reverseChemicalSequence(String[] elements, float[] masses) {
        if (elements == null || masses == null || elements.length != masses.length) {
            return new String[0];
        }

        int length = elements.length;
        String[] reversedElements = new String[length];

        for (int i = 0; i < length; i++) {
            reversedElements[i] = elements[length - 1 - i];
        }

        return reversedElements;
    }
}
