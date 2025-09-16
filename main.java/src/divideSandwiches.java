/*
Create a function named divideSandwiches that receives sandwiches as its parameter.

This function helps Patsy divide sandwiches evenly among her guests at the picnic.

Given an array of integers representing the number of sandwiches each guest brought, calculate the number of sandwiches each guest should receive to ensure everyone gets an equal share. If the sandwiches can't be divided evenly, return 0.

Parameters:
- sandwiches (int[]): An array where each element represents the number of sandwiches a guest brought.

The function returns an integer representing the number of sandwiches each guest should receive. If equal distribution is not possible, return 0.
*/

class DivideSandwiches {
    public static int divideSandwiches(int[] sandwiches) {
        int totalSandwiches = 0;
        for (int sandwichCount : sandwiches) {
            totalSandwiches += sandwichCount;
        }

        int numGuests = sandwiches.length;
        if (totalSandwiches % numGuests != 0) {
            return 0;
        }

        return totalSandwiches / numGuests;
    }
}