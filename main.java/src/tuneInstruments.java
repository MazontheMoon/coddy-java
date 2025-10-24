/*
Create a function named tuneInstruments that receives int[] pitches and int conductor as its parameters.

Your task is to simulate the tuning of instruments in a chaotic orchestra rehearsal. The function should adjust the pitches of the instruments based on the conductor's mood and return the new array of pitches.

Here's how the tuning process works:
- If the conductor's mood is less than 50, adjust the first half of the instruments:
- For each instrument in the first half, if its pitch is less than 50, increase it by 1.
- If its pitch is greater than 50, decrease it by 1.
- If the conductor's mood is 50 or higher, adjust the second half of the instruments:
  - For each instrument in the second half, if its pitch is less than 50, decrease it by 1.
  - If its pitch is greater than 50, increase it by 1.
  - Instruments with a pitch of exactly 50 should not be changed.
- Ensure that no pitch goes below 0 or above 100.

Parameters:
- pitches (int[]): An array representing the current pitch of each instrument (0-100, where 50 is perfectly in tune).
- conductor (int): An integer representing the conductor's mood (0-100, where 0 is very calm and 100 is extremely agitated).

The function returns an integer array representing the new pitches of the instruments after tuning.

Use array slicing to work with different halves of the array and increment/decrement operators to adjust the pitches. Remember to create a new array for the result instead of modifying the input array.


 */

import java.util.Arrays;

class TuneInstruments {
    public static int[] tuneInstruments(int[] pitches, int conductor) {
        int[] newPitches = Arrays.copyOf(pitches, pitches.length);
        int midPoint = newPitches.length / 2;

        if (conductor < 50) {
            for (int i = 0; i < midPoint; i++) {
                if (newPitches[i] < 50) {
                    newPitches[i] = Math.min(newPitches[i] + 1, 100);
                } else if (newPitches[i] > 50) {
                    newPitches[i] = Math.max(newPitches[i] - 1, 0);
                }
            }
        } else {
            for (int i = midPoint; i < newPitches.length; i++) {
                if (newPitches[i] < 50) {
                    newPitches[i] = Math.max(newPitches[i] - 1, 0);
                } else if (newPitches[i] > 50) {
                    newPitches[i] = Math.min(newPitches[i] + 1, 100);
                }
            }
        }

        return newPitches;
    }
}