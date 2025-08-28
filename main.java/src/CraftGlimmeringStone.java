/*
Create a function named craftGlimmeringStone that receives initialShine and polishingCycles as its parameters.

This function simulates the process of crafting an artificial stone in a sculptor's workshop. The stone's shine level changes during polishing cycles, and a special property is added if the final shine is a prime number.

Follow these steps to craft the stone:

Start with the initial shine level.
For each polishing cycle:
 - If the cycle number is odd, increase the shine level by 2.
 - If the cycle number is even, decrease the shine level by 1.
 - After all cycles, if the final shine level is a prime number, add 5 to the shine level.
 - Ensure the final shine level stays within the range of 0-100.

Parameters:

- initialShine (int): The initial shine level of the stone (0-100).
- polishingCycles (int): The number of polishing cycles to perform.

The function returns an int representing the final shine level of the stone.
*/

import java.util.Arrays;

class CraftGlimmeringStone {
    public static int craftGlimmeringStone(int initialShine, int polishingCycles) {
        int shine = initialShine;

        for (int cycle = 1; cycle <= polishingCycles; cycle++) {
            if (cycle % 2 == 1) {
                shine += 2;
            } else {
                shine -= 1;
            }
        }

        if (isPrime(shine)) {
            shine += 5;
        }

        return Math.max(0, Math.min(100, shine));
    }

    private static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}