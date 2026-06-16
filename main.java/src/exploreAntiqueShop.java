import java.util.Arrays;

class ExploreAntiqueShop {
    public static int[] exploreAntiqueShop(String[] shopItems, String[] desiredItems) {
        int[] result = new int[desiredItems.length];
        Arrays.fill(result, -1);
        int foundItems = 0;

        for (int i = 0; i < shopItems.length && foundItems < 5; i++) {
            if (shopItems[i].isEmpty()) continue;

            for (int j = 0; j < desiredItems.length; j++) {
                if (result[j] == -1 && isMatch(shopItems[i], desiredItems[j])) {
                    result[j] = i;
                    foundItems++;
                    break;
                }
            }
        }

        return result;
    }

    private static boolean isMatch(String shopItem, String desiredItem) {
        String[] shopWords = shopItem.toLowerCase().split(" ");
        String[] desiredWords = desiredItem.toLowerCase().split(" ");

        for (String desiredWord : desiredWords) {
            boolean found = false;
            for (String shopWord : shopWords) {
                if (shopWord.contains(desiredWord) || desiredWord.contains(shopWord)) {
                    found = true;
                    break;
                }
            }
            if (!found) return false;
        }

        return true;
    }
}