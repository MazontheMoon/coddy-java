/*
* Create a function named analyzeInsectCode that receives speciesName and binaryCode as its parameters.

The function should analyze the relationship between an insect's species name and its binary code, as observed by a tweedy professor in a university laboratory.

The function should perform the following tasks:
- Convert the binary code to its decimal equivalent.
- Compare the length of the insect species name to the decimal number.
- Return a string describing the specimen based on this comparison.

Parameters:
- speciesName (String): The name of the insect species. It will contain at least one character.
- binaryCode (String): A binary number represented as a string. It will contain only '0' and '1' characters and will have at least one character.

The function should return a string with one of the following messages:
- If the length of the species name is equal to the decimal number: "Perfect specimen!"
- If the length of the species name is greater than the decimal number: "Interesting mutation!"
- If the length of the species name is less than the decimal number: "Underdeveloped specimen."

* Note: To convert the binary string to a decimal number, you can use the Integer.parseInt(binaryCode, 2) method in Java.
*/

import java.util.Scanner;

class AnalyzeInsectCode {
    public static String analyzeInsectCode(String speciesName, String binaryCode) {
        int decimalNumber = Integer.parseInt(binaryCode, 2);
        int nameLength = speciesName.length();

        if (nameLength == decimalNumber) {
            return "Perfect specimen!";
        } else if (nameLength > decimalNumber) {
            return "Interesting mutation!";
        } else {
            return "Underdeveloped specimen.";
        }
    }
}
