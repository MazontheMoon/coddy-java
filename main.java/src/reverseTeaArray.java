/*
Create a function named reverseTeaArray that receives seatNumbers as its parameter.

This function reverses the order of seat numbers in the array.

Parameters:
- seatNumbers (int[]): An array of integers representing the current order of seat numbers.

The function should return an integer array (int[]) with the seat numbers in reversed order.

Constraints:
- The seatNumbers array will contain at least 1 and at most 20 seat numbers.
- Each seat number in the seatNumbers array is a unique positive integer.
*/

class ReverseTeaArray {
    public static int[] reverseTeaArray(int[] seatNumbers) {
        int n = seatNumbers.length;
        int[] reversedSeats = new int[n];

        for (int i = 0; i < n; i++) {
            reversedSeats[i] = seatNumbers[n - 1 - i];
        }

        return reversedSeats;
    }
}
