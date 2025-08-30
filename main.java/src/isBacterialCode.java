/*
Create a function named isBacterialCode that receives number and substring as its parameters.

In the laboratory of an overlarge scientist studying Eubacteriales, a unique coding system has been developed to classify bacterial strains. This system, called the "Bacterial Code", is based on specific numerical properties.

A number is considered a "Bacterial Code" if it satisfies two conditions:

- It contains the given substring.
- The sum of its digits is divisible by 7 (a number significant in microbiology due to bacterial growth patterns).

Your task is to implement this classification system.

Parameters:

- number (int): A positive integer to be checked.
substring (String): A string to be searched for within the number.
- The function returns a boolean value: true if the number is a Bacterial Code, and false otherwise.
*/

class IsBacterialCode {
    public static boolean isBacterialCode(int number, String substring) {
        String numberStr = String.valueOf(number);

        // Check if the number contains the substring
        if (!numberStr.contains(substring)) {
            return false;
        }

        // Calculate the sum of digits
        int sum = 0;
        for (char digit : numberStr.toCharArray()) {
            sum += Character.getNumericValue(digit);
        }

        // Check if the sum is divisible by 7
        return sum % 7 == 0;
    }
}
