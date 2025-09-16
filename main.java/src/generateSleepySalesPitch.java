/*
Create a function named generateSleepySalesPitch that receives products and prices as its parameters.

The function simulates a sleepy salesman nervously underselling his wares at a late-night market. It generates a sales pitch for each item, reflecting the salesman's tired and nervous state.

Parameters:
- products (String[]): An array containing product names.
- prices (int[]): An array containing the corresponding prices for each product.

The function should follow these rules:
- Iterate through the products and prices arrays simultaneously.
- For each product, generate a sales pitch line in the format: "Um... [product] for only $[price-5]... I guess?"
- Subtract 5 from each price to represent the salesman underselling the items.
- If the original price is above 50, the salesman gets nervous and skips the item (use a continue statement).
- If the salesman has pitched 5 items, he gets too tired and stops (use a break statement).
- Between each item's pitch, add a line break ("\n") and some ellipsis ("...") to represent the salesman's drowsiness.

The function returns a string containing the complete sales pitch for all applicable products.

Note: Ensure that the arrays products and prices have the same length. If they don't, you can assume the function will process items up to the length of the shorter array.
*/

import java.util.Arrays;

class GenerateSleepySalesPitch {
    public static String generateSleepySalesPitch(String[] products, int[] prices) {
        StringBuilder pitch = new StringBuilder();
        int count = 0;

        for (int i = 0; i < Math.min(products.length, prices.length); i++) {
            if (prices[i] > 50) {
                continue;
            }

            if (count > 0) {
                pitch.append("...\n");
            }

            pitch.append(String.format("Um... %s for only $%d... I guess?", products[i], prices[i] - 5));

            count++;
            if (count == 5) {
                break;
            }
        }

        return pitch.toString();
    }
}