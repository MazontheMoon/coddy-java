/*
Create a function named selectChalcedonyGemstones that receives String[] gemstones, int[] prices, int budget, and String targetGemstone as its parameters.

The function simulates a visit to a premium jewelry store specializing in chalcedony gemstones. It processes a list of chalcedony gemstones and their prices, selecting gemstones that can be purchased within a given budget.

Iterate through the list of gemstones and their prices, adding gemstones to the selection as long as the budget allows. Use a break statement to stop the selection process if the target gemstone is found or if the budget is exceeded. Use a continue statement to skip gemstones that are too expensive for the remaining budget.

Parameters:
- gemstones (String[]): An array of chalcedony gemstone names.
- prices (int[]): An array of corresponding prices for each gemstone.
- budget (int): The maximum amount of money to spend.
- targetGemstone (String): A specific gemstone to look for. If not searching for a specific one, this can be an empty string.

The function returns a String array containing the names of selected gemstones that fit within the budget.

Important Notes:
- The gemstones and prices arrays will always have the same length.
- Prices are positive integers.
- The budget is a positive integer.
- If the targetGemstone is found and can be afforded, stop the selection process immediately.
- If no gemstones can be afforded within the budget, return an empty array.

 */

import java.util.ArrayList;
import java.util.List;

class SelectChalcedonyGemstones {
    public static String[] selectChalcedonyGemstones(String[] gemstones, int[] prices, int budget, String targetGemstone) {
        List<String> selectedGemstones = new ArrayList<>();
        int remainingBudget = budget;

        for (int i = 0; i < gemstones.length; i++) {
            if (prices[i] > remainingBudget) {
                continue;
            }

            selectedGemstones.add(gemstones[i]);
            remainingBudget -= prices[i];

            if (gemstones[i].equals(targetGemstone) || remainingBudget == 0) {
                break;
            }
        }

        return selectedGemstones.toArray(new String[0]);
    }
}