/*
Create a function named calculateTacoOrder that receives tacoQuantities and tacoPrices as its parameters.

Imagine you're at a lively Mexican restaurant, and you've been tasked with creating a simple order calculation system for their famous tacos. Your function should calculate the total cost of a taco order and provide a summary.

Your function should perform the following operations:
- Calculate the total number of tacos ordered by summing up all the quantities in the tacoQuantities array.
- Calculate the total cost of the order by multiplying each taco quantity by its corresponding price and summing all the results.
- Return a formatted string that includes the total number of tacos ordered and the total cost.

Parameters:
- tacoQuantities (int[]): An array representing the number of tacos ordered for each type. Each element corresponds to a different type of taco.
- tacoPrices (int[]): An array representing the prices of different taco types. Each element corresponds to the price of the taco type at the same index in tacoQuantities.

The function returns a string in the format: "Total tacos: X, Total cost: $Y.ZZ", where X is the total number of tacos, and Y.ZZ is the total cost with two decimal places.

Note: Assume that both input arrays have the same length and contain valid, positive integers. The prices in tacoPrices represent the cost in dollars.
*/

import java.text.DecimalFormat;

class CalculateTacoOrder {
    public static String calculateTacoOrder(int[] tacoQuantities, int[] tacoPrices) {
        int totalTacos = 0;
        double totalCost = 0.0;

        for (int i = 0; i < tacoQuantities.length; i++) {
            totalTacos += tacoQuantities[i];
            totalCost += tacoQuantities[i] * tacoPrices[i];
        }

        DecimalFormat df = new DecimalFormat("#.00");
        return "Total tacos: " + totalTacos + ", Total cost: $" + df.format(totalCost);
    }
}