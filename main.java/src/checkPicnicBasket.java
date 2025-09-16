/*
Create a function named checkPicnicBasket that receives basket as its parameter.

This function checks if a picnic basket contains all the necessary items for a perfect summer picnic. The essential items are: "sandwich", "blanket", and at least one snack or drink such as "apple", "chips", "cookies", or "juice".

If any essential item is missing, the function should return the name of the missing item as a string. If the basket contains all necessary items, the function should return "The picnic basket is complete!".

Parameters:
- basket (String[]): An array of strings representing the items currently in the picnic basket.

The function returns a String, either specifying the missing item or confirming the basket is complete.
*/

class CheckPicnicBasket {
    public static String checkPicnicBasket(String[] basket) {
        boolean hasSandwich = false;
        boolean hasBlanket = false;
        boolean hasSnackOrDrink = false;

        for (String item : basket) {
            if (item.equals("sandwich")) {
                hasSandwich = true;
            } else if (item.equals("blanket")) {
                hasBlanket = true;
            } else if (item.equals("apple") || item.equals("chips") || item.equals("cookies") || item.equals("juice")) {
                hasSnackOrDrink = true;
            }
        }

        if (!hasSandwich) {
            return "sandwich";
        } else if (!hasBlanket) {
            return "blanket";
        } else if (!hasSnackOrDrink) {
            return "snack or drink";
        } else {
            return "The picnic basket is complete!";
        }
    }
}