/*
Create a function named eveningPrayerCountdown that receives startNumber and endNumber as its parameters.

This function should print a countdown from startNumber to endNumber, inclusive.

For each number in the countdown:

If divisible by 3, print "Peace".
If not divisible by 3, print the number.
If divisible by 5, skip to the next iteration without printing.
Use increment and decrement operators for the countdown.

Parameters:
 - startNumber (int): The number to start the countdown from (inclusive).
 - endNumber (int): The number to end the countdown at (inclusive).

The function returns the string "Amen" after completing the countdown.
 */

public class candlelitCountdownPrayer {
    class EveningPrayerCountdown {
        public static String eveningPrayerCountdown(int startNumber, int endNumber) {
            for (int i = startNumber; i >= endNumber; i--) {
                if (i % 5 == 0) {
                    continue;
                }
                if (i % 3 == 0) {
                    System.out.println("Peace");
                } else {
                    System.out.println(i);
                }
            }
            return "Amen";
        }
    }
}
