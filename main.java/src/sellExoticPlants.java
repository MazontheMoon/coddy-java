/*
Create a function named sellExoticPlants that receives prices and budget as its parameters.

The function simulates a persistent salesperson at a flower shop trying to sell exotic plants to a customer. The salesperson starts with the most expensive plant and works their way down, using their persuasion skills to maximize sales.

Parameters:
- prices (int[]): An array of integers representing the prices of different exotic plants, sorted in ascending order.
- budget (int): An integer representing the customer's initial budget.

The function should return an integer representing the total amount of money the salesperson managed to convince the customer to spend.

Follow these rules:
- Start selling from the most expensive plant (last element in the array) to the cheapest.
- Skip any plant that is too expensive for the customer's remaining budget (use a continue statement).
- Stop selling if the customer's budget reaches 0 or all plants have been considered (use a break statement).
- For every two plants the customer buys, convince them to spend an extra 10% of their original budget on another plant, if possible.
- Implement this logic using basic control flow, including break and continue statements.
*/

import java.util.Arrays;

class SellExoticPlants {
    public static int sellExoticPlants(int[] prices, int budget) {
        int originalBudget = budget;
        int totalSpent = 0;
        int plantsBought = 0;

        for (int i = prices.length - 1; i >= 0; i--) {
            if (prices[i] > budget) {
                continue;
            }

            budget -= prices[i];
            totalSpent += prices[i];
            plantsBought++;

            if (plantsBought % 2 == 0) {
                int extraBudget = (int) (originalBudget * 0.1);
                budget += extraBudget;
                totalSpent += extraBudget;
            }

            if (budget == 0) {
                break;
            }
        }

        return totalSpent;
    }
}
