/*
Create a function named upgradeCartWheel that receives int[] wheels and int position as its parameters.

In the quirky inventor's workshop, you're tasked with upgrading the wheels of various carts. Each wheel can be in one of four states, represented by integers:
0: Basic wooden wheel
1: Reinforced wooden wheel
2: Iron-rimmed wheel
3: Rubber-coated wheel (highest level)

Your function should upgrade the wheel at the given position to the next level. If the wheel is already at the highest level (3), it should remain unchanged.

Parameters:
- wheels (int[]): An array representing the current state of the cart's wheels.
- position (int): The position of the wheel to be upgraded (0-based index).

The function returns the modified wheels array after the upgrade.

Important Notes:

Check if the given position is valid (within the array bounds).
If the position is invalid, return the original array without modifications.
Upgrade the wheel at the specified position to the next level if it's not already at the highest level.
The array should be modified in-place, meaning you should change the original array and not create a new one.
 */

import java.util.Arrays;

class UpgradeCartWheel {
    public static int[] upgradeCartWheel(int[] wheels, int position) {
        if (position < 0 || position >= wheels.length) {
            return wheels;
        }

        if (wheels[position] < 3) {
            wheels[position]++;
        }

        return wheels;
    }
}
