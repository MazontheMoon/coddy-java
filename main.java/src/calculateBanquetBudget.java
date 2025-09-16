/*
Create a function named calculateBanquetBudget that receives numOfGuests as its parameter.

This function calculates the total budget for a king's banquet based on the number of guests.
Meal costs:
- "Standard" meal: 20 gold coins per guest
- "Deluxe" meal: 50 gold coins per guest

Meal type conditions:
- If guests ≤ 10, serve "Deluxe" meal.
- If guests > 10, serve "Standard" meal.

Parameters:
- numOfGuests (int): Number of guests attending.

Returns an integer representing the total budget required.
*/

class CalculateBanquetBudget {
    public static int calculateBanquetBudget(int numOfGuests) {
        int mealCost = numOfGuests <= 10 ? 50 : 20;
        return numOfGuests * mealCost;
    }
}