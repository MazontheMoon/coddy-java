/*
Create a function named convertToBinaryCountOnes that receives num1 and num2 as its parameters.

This function aims to simulate the counting process of counting the number of ones in the binary representation of two numbers and then summing them up.

Imagine you are part of a historical photogravure exhibit displaying famous Algonquin figures and their contributions. In this challenge, each number represents a unique artifact, and its binary representation corresponds to some coded information about the artifact. Your task is to decode this by converting these numbers to binary, count the number of ones (which represents a specific aspect of the artifact), and sum them for two given artifacts.

To convert a decimal number to its binary representation, you can use the following approach:
- Initialize an empty string to store the binary representation.
- While the number is greater than 0:
  - Calculate the remainder when the number is divided by 2 (using the modulo operator %).
  - Prepend the remainder to the binary string.
  - Divide the number by 2 (integer division).
- If the binary string is empty (in case the input was 0), set it to "0".
- Reverse the binary string to get the correct binary representation.
- After converting both numbers to their binary representations, count the number of ones in each binary string and sum them up to get the final result.

Parameters:
- num1 (int): The first number representing an artifact (0 <= num1 <= 1000).
- num2 (int): The second number representing another artifact (0 <= num2 <= 1000).
The function returns an integer which represents the total count of ones in the binary representation of both numbers combined.
*/

class ConvertToBinaryCountOnes {
    public static int convertToBinaryCountOnes(int num1, int num2) {
        String binary1 = convertToBinary(num1);
        String binary2 = convertToBinary(num2);

        int count1 = countOnes(binary1);
        int count2 = countOnes(binary2);

        return count1 + count2;
    }

    private static String convertToBinary(int num) {
        if (num == 0) {
            return "0";
        }

        StringBuilder binary = new StringBuilder();
        while (num > 0) {
            int remainder = num % 2;
            binary.insert(0, remainder);
            num /= 2;
        }

        return binary.toString();
    }

    private static int countOnes(String binary) {
        int count = 0;
        for (char c : binary.toCharArray()) {
            if (c == '1') {
                count++;
            }
        }
        return count;
    }
}


