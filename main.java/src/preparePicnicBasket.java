/*
Create a function named preparePicnicBasket that receives snacksCount and drinksCount as its parameters.

This function simulates packing a picnic basket with snacks and drinks.

Initialize two arrays of strings, one for snacks and one for drinks:
- Snacks: "sandwich", "apple", "cookie", "salad".
- Drinks: "water", "juice", "soda", "tea".
- Fill the snacks array with the first snacksCount items and the drinks array with the first drinksCount items.

Combine both arrays and return the result, with snacks listed first, followed by drinks.

Parameters:
- snacksCount (int): Number of different snacks to pack.
- drinksCount (int): Number of different drinks to pack.

Returns a String array containing the combined list of snacks and drinks.
*/

import java.util.Arrays;

class PreparePicnicBasket {
    public static String[] preparePicnicBasket(int snacksCount, int drinksCount) {
        String[] snacks = {"sandwich", "apple", "cookie", "salad"};
        String[] drinks = {"water", "juice", "soda", "tea"};

        String[] selectedSnacks = Arrays.copyOfRange(snacks, 0, snacksCount);
        String[] selectedDrinks = Arrays.copyOfRange(drinks, 0, drinksCount);

        String[] picnicBasket = new String[snacksCount + drinksCount];
        System.arraycopy(selectedSnacks, 0, picnicBasket, 0, snacksCount);
        System.arraycopy(selectedDrinks, 0, picnicBasket, snacksCount, drinksCount);

        return picnicBasket;
    }
}
