/*
Create a function named isHarmonyNumber that receives number as its parameter.

In a garden of numbers, we're looking for special "Harmony Numbers". A Harmony Number is a positive integer where the sum of its digits is divisible by the number of digits. Your task is to identify these Harmony Numbers and describe them using garden-themed language.

Follow these steps to solve the challenge:
- Calculate the sum of the digits of the input number.
- Count the number of digits in the input number.
- Check if the sum of digits is divisible by the number of digits.
- Format a string response based on whether the number is a Harmony Number or not.

Parameters:
- number (int): A positive integer to be checked for harmony.

The function returns a string describing whether the number is a Harmony Number, using garden-themed language.
- If it is a Harmony Number, return a string like: "The [number] flower is in perfect harmony! Its [digit count] petals create a beautiful balance."
- If it's not a Harmony Number, return a string like: "The [number] fruit needs more nurturing. Its [digit count] seeds are not yet in harmony."
*/

import java.util.Arrays;

class IsHarmonyNumber {
    public static String isHarmonyNumber(int number) {
        String numStr = String.valueOf(number);
        int digitCount = numStr.length();
        int sum = Arrays.stream(numStr.split("")).mapToInt(Integer::parseInt).sum();

        if (sum % digitCount == 0) {
            return String.format("The %d flower is in perfect harmony! Its %d petals create a beautiful balance.", number, digitCount);
        } else {
            return String.format("The %d fruit needs more nurturing. Its %d seeds are not yet in harmony.", number, digitCount);
        }
    }
}