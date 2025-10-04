/*
Create a function named countCircularObjects that receives action, objectType, and count as parameters.

This function manages counts of circular objects (balls, coins, lenses) in a photography exhibit. It starts with zero counts for all objects. Based on the action ('add' or 'remove') and objectType, it updates the count. If 'remove' is requested and there are not enough objects, it returns an error message. The function returns a message indicating the current counts of all objects after the operation.

Parameters:
- action (String): 'add' or 'remove'.
- objectType (String): 'ball', 'coin', or 'lens'.
- count (int): Number of items to add or remove.
The function returns a String message indicating the current counts of all objects after each operation.

Constraints:
- action will be 'add' or 'remove'.
- objectType will be 'ball', 'coin', or 'lens'.
- count will be a positive integer.
*/

class CountCircularObjects {
    private static int ballCount = 0;
    private static int coinCount = 0;
    private static int lensCount = 0;

    public static String countCircularObjects(String action, String objectType, int count) {
        if (action.equals("add")) {
            if (objectType.equals("ball")) {
                ballCount += count;
            } else if (objectType.equals("coin")) {
                coinCount += count;
            } else if (objectType.equals("lens")) {
                lensCount += count;
            }
        } else if (action.equals("remove")) {
            if (objectType.equals("ball")) {
                if (ballCount >= count) {
                    ballCount -= count;
                } else {
                    return "Error: Not enough balls to remove.";
                }
            } else if (objectType.equals("coin")) {
                if (coinCount >= count) {
                    coinCount -= count;
                } else {
                    return "Error: Not enough coins to remove.";
                }
            } else if (objectType.equals("lens")) {
                if (lensCount >= count) {
                    lensCount -= count;
                } else {
                    return "Error: Not enough lenses to remove.";
                }
            }
        }

        return "Current counts: balls = " + ballCount + ", coins = " + coinCount + ", lenses = " + lensCount;
    }
}