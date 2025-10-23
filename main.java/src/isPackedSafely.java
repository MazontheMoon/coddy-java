/*
Create a function named isPackedSafely that receives items and requiredPadding as its parameters.

A musician is preparing for a concert tour and needs to ensure their cello is packed safely in its case. Your task is to create a function that determines if the cello is packed properly and protected from damage.

The function should check the following conditions:
- The first item in the array must be "cello" (case-insensitive).
- The last item in the array must be "bow" (case-insensitive).
- There should be at least the specified number of padding items ("blanket", "foam", or "bubble wrap") between the cello and the bow.
- No hard or potentially damaging items ("book", "water bottle", "tuner") should be directly next to the cello or the bow.

Parameters:
- items (String[]): An array of strings representing the items packed in the cello case.
- requiredPadding (int): An integer representing the number of padding items required for safe packing.

The function returns a boolean value: true if the cello is packed safely according to all conditions, false otherwise.
 */

import java.util.Arrays;

class IsPackedSafely {
    public static boolean isPackedSafely(String[] items, int requiredPadding) {
        if (items.length < 2 || !items[0].equalsIgnoreCase("cello") || !items[items.length - 1].equalsIgnoreCase("bow")) {
            return false;
        }

        int paddingCount = 0;
        boolean lastItemWasPadding = true;

        for (int i = 1; i < items.length - 1; i++) {
            String item = items[i].toLowerCase();
            if (isPadding(item)) {
                paddingCount++;
                lastItemWasPadding = true;
            } else if (isDangerous(item)) {
                if (i == 1 || i == items.length - 2 || !lastItemWasPadding) {
                    return false;
                }
                lastItemWasPadding = false;
            } else {
                lastItemWasPadding = false;
            }
        }

        return paddingCount >= requiredPadding;
    }

    private static boolean isPadding(String item) {
        return item.equals("blanket") || item.equals("foam") || item.equals("bubble wrap");
    }

    private static boolean isDangerous(String item) {
        return item.equals("book") || item.equals("water bottle") || item.equals("tuner");
    }
}
