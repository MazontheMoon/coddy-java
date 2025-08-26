/*
Create a function named isJailNumber that receives number as its parameter.

In the context of an old jailhouse turned tourist attraction, you're tasked with creating an automated guide system. This system needs to identify special "Jail Numbers" for an interactive exhibit. A "Jail Number" is defined as a positive integer where the sum of its digits raised to the power of the number of digits is equal to the number itself.

Your function should determine if the input is a "Jail Number" and return a formatted string with information about the number.

Parameters:

number (int): A positive integer to be checked.
The function should perform the following steps:

1. Calculate the sum of the digits of the input number.
2. Count the number of digits in the input number.
3. Calculate the sum of digits raised to the power of the number of digits.
4. Check if this result equals the original number.
5. Return a formatted string with the following information:
Whether the number is a Jail Number or not
- The original number
- The sum of its digits
- The number of digits
- The function returns a string formatted as follows: "[Jail Number/Not a Jail Number]: [number] (Sum: [sum], Digits: [digit count])".

For example:

For input 371, the output should be: "Jail Number: 371 (Sum: 11, Digits: 3)"
For input 123, the output should be: "Not a Jail Number: 123 (Sum: 6, Digits: 3)"
*/
 */

 import java.util.Arrays;

public class IsJailNumber {
    public static String isJailNumber(int number) {
        int sum = sumOfDigits(number);
        int digitCount = countDigits(number);
        long result = (long) Math.pow(sum, digitCount);

        String jailStatus = (result == number) ? "Jail Number" : "Not a Jail Number";

        return String.format("%s: %d (Sum: %d, Digits: %d)", jailStatus, number, sum, digitCount);
    }

    private static int sumOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    private static int countDigits(int num) {
        return String.valueOf(num).length();
    }
}