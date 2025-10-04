/*
Create a function named ancientNumeralConverter that receives modernYear as its parameter.

Your task is to create a museum exhibit that converts modern decimal years into an ancient base-4 numeral system. This function will help visitors understand how different civilizations might have represented numbers.

The function should convert the input year from decimal (base-10) to base-4, and then store each digit of the base-4 number in an array. The array should be reversed to match the ancient system's convention (least significant digit first).

Parameters:
- modernYear (int): A positive integer representing a year in the modern calendar system.
The function returns an integer array where each element represents a digit in the ancient base-4 system, with the least significant digit at index 0.

Here's how to approach the problem:
- Convert the modernYear from decimal to base-4.
- Store each base-4 digit in an array.
- Reverse the array so that the least significant digit is at index 0.

For example, if the input is 2023:
2023 in base-4 is 33213
The function should return [3, 1, 2, 3, 3]
*/

import java.util.ArrayList;
import java.util.Collections;

class AncientNumeralConverter {
    public static int[] ancientNumeralConverter(int modernYear) {
        if (modernYear == 0) {
            return new int[]{0};
        }

        ArrayList<Integer> base4Digits = new ArrayList<>();

        while (modernYear > 0) {
            base4Digits.add(modernYear % 4);
            modernYear /= 4;
        }

        Collections.reverse(base4Digits);

        int[] result = new int[base4Digits.size()];
        for (int i = 0; i < base4Digits.size(); i++) {
            result[i] = base4Digits.get(i);
        }

        return result;
    }
}