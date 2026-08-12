import java.util.ArrayList;

class FindItemsInDescription {
    public static String[] findItemsInDescription(String[] items, String description) {
        String[] descriptionWords = description.split(" ");
        ArrayList<String> foundItems = new ArrayList<>();

        for (String item : items) {
            for (String word : descriptionWords) {
                if (item.equals(word)) {
                    foundItems.add(item);
                    break;
                }
            }
        }

        return foundItems.toArray(new String[0]);
    }
}