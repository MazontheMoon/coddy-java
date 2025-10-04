/*
Create a function named maxFillingsPerPerson that receives sandwiches as its parameter.

This function calculates the maximum number of fillings each person can enjoy if the sandwiches are divided equally among the picnic participants.

Parameters:
- sandwiches (int[]): An array of integers where each value represents the number of fillings in a sandwich.

The function returns an integer representing the maximum number of fillings each person can enjoy if the sandwiches are divided equally.
 */

class MaxFillingsPerPerson {
    public static int maxFillingsPerPerson(int[] sandwiches) {
        int totalFillings = 0;
        for (int fillings : sandwiches) {
            totalFillings += fillings;
        }
        return totalFillings / sandwiches.length;
    }
}